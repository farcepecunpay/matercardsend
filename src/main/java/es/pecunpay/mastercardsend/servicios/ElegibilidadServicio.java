package es.pecunpay.mastercardsend.servicios;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.pecunpay.mastercardsend.bbdd.ManagerBBDD;
import es.pecunpay.mastercardsend.model.Parametros;
import es.pecunpay.mastercardsend.model.RequestComision;
import es.pecunpay.mastercardsend.model.ResponseCde;
import es.pecunpay.mastercardsend.model.ResponseComision;
/**
 * Servicio que selecciona la comision de la transaccion y si esta es elegible
 *
 * @author jmansilla_ext
 *
 */
@RestController
@RequestMapping("/api")
public class ElegibilidadServicio {
    RestTemplate rest;
    static String estado = "MCS_000";
    static String tipo = "";
    static float importe = 0;
    static float comision = 0;
    Object[] datos;
    @PostMapping("/compruebaposibletransaccion")
    public ResponseComision getElegibilidad(@RequestBody RequestComision request) {
	String numMp = request.getNumMp();
	this.datos = new Object[13];
	String uuid = this.generaUuid();
	this.datos[0] = uuid;
	this.datos[1] = request.getPayment_type();
	this.datos[3] = numMp;
	this.datos[4] = request.getFechaHoraOperacion();
	this.datos[9] = request.getNombre();
	this.datos[10] = request.getApellidos();
	this.importe = request.getImporte();
	this.datos[11] = importe;
	ResponseComision r = new ResponseComision();
	this.comision = this.buscaComision(numMp);
	this.compruebacde(numMp);
	if (estado.equalsIgnoreCase("MCS_000")) {
	    r.setComision(this.comision);
	}
	r.setEstado(estado);
	r.setIde_tra_mcs(uuid);
	this.datos[12] = comision;
	this.datos[2] = estado;
	ManagerBBDD.insertarInicio(Arrays.asList(this.datos));
	return r;
    }
    private boolean compruebacde(String numMp) {
	RestTemplate restTemplate = new RestTemplate();
	ResponseCde response = restTemplate.getForObject("http://10.248.23.150:8481/mediopago/" + numMp + "/acuerdo",
		ResponseCde.class);
	try {
	    if (!response.getMedioPago().getTipoMedioPago().equalsIgnoreCase("TARJETA")) {
		estado = "MCS_011";
		return false;
	    }
	    if (!response.getMedioPago().getEstado().equalsIgnoreCase("ACTIVADO")) {
		estado = "MCS_012";
		return false;
	    } else {
		this.datos[7] = response.getMedioPago().getId_medio_pago();
		this.datos[8] = response.getMedioPago().getId_acuerdo();
	    }
	    if (!response.getAcuerdo().getEstado().equalsIgnoreCase("ACTIVADO")) {
		estado = "MCS_013";
		return false;
	    } else {
		this.datos[5] = response.getAcuerdo().getId_acuerdo();
		this.datos[6] = response.getAcuerdo().getNumeroAcuerdoCDE();
	    }
	    if (!response.getTarifa().getEstado().equalsIgnoreCase("ACTIVA")) {
		estado = "MCS_014";
		return false;
	    }
	    if (Float.parseFloat(response.getAcuerdo().getSaldo()) < importe + comision) {
		estado = "MCS_020";
		return false;
	    }
	    return true;
	} catch (Exception e) {
	    estado = "MCS_001";
	    return false;
	}
    }
    private float buscaComision(String numMp) {
	RestTemplate restTemplate = new RestTemplate();
	try {
	    String response = restTemplate
		    .getForObject("http://localhost:8081/mediopago/" + numMp + "/tarifa/parametroscde", String.class);
	    ObjectMapper mapper = new ObjectMapper();
	    List<Parametros> list = new ArrayList<Parametros>();
	    list = mapper.readValue(response, new TypeReference<ArrayList<Parametros>>() {
	    });
	    HashMap<String, Parametros> validaciones = new HashMap();
	    for (Parametros p : list) {
		validaciones.put(p.getParametro().getCodigo(), p);
	    }
	    return ElegibilidadServicio.validar(validaciones);
	} catch (Exception e) {
	    estado = "MCS_001";
	    return 0;
	}
    }
    private static float validar(HashMap<String, Parametros> validaciones) {
	float comision = 0;
	try {
	    if ("NO".equalsIgnoreCase(validaciones.get("MCSEND_USO").getValoresTarifa().getValor())) {
		estado = "MCS_021";
		return 0;
	    }
	    if ("FIJO".equals(validaciones.get("MCSEND_COM").getValoresTarifa().getValor())) {
		tipo = "FIJO";
	    } else {
		tipo = "PORCENTAJE";
	    }
	    if (tipo.equals("") && tipo.equalsIgnoreCase("FIJO")) {
		return Float.parseFloat(validaciones.get("MCSEND_COM_IF").getValoresTarifa().getValor());
	    } else if (tipo.equalsIgnoreCase("PORCENTAJE")) {
		String porcen = validaciones.get("MCSEND_COM_PO").getValoresTarifa().getValor().replace(",", ".");
		float porcentaje = Float.parseFloat(porcen);
		float max = Float
			.parseFloat(validaciones.get("MCSEND_IM_MAX").getValoresTarifa().getValor().replace(",", "."));
		float min = Float
			.parseFloat(validaciones.get("MCSEND_IM_MIN").getValoresTarifa().getValor().replace(",", "."));
		if (max > porcentaje && min < porcentaje) {
		    comision = importe * porcentaje / 100;
		}
		if (comision < min) {
		    comision = min;
		}
		if (comision > max) {
		    comision = max;
		}
	    }
	} catch (Exception e) {
	    estado = "MC_001";
	}
	return comision;
    }
    private String generaUuid() {
	return UUID.randomUUID().toString();
    }
}