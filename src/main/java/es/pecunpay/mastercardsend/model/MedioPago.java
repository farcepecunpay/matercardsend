package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class MedioPago {
    @JsonProperty("id_medio_pago")
    private int id_medio_pago;
    @JsonProperty("estadoMedioPago")
    private String estado;
    @JsonProperty("tipoMedioPago")
    private String tipoMedioPago;
    @JsonProperty("id_acuerdo")
    private int id_acuerdo;
    public int getId_medio_pago() {
	return this.id_medio_pago;
    }
    public void setId_medio_pago(int id_medio_pago) {
	this.id_medio_pago = id_medio_pago;
    }
    public String getEstado() {
	return this.estado;
    }
    public void setEstado(String estado) {
	this.estado = estado;
    }
    public String getTipoMedioPago() {
	return this.tipoMedioPago;
    }
    public void setTipoMedioPago(String tipoMedioPago) {
	this.tipoMedioPago = tipoMedioPago;
    }
    public int getId_acuerdo() {
	return this.id_acuerdo;
    }
    public void setId_acuerdo(int id_acuerdo) {
	this.id_acuerdo = id_acuerdo;
    }
}
