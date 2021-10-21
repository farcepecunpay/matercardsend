package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ResponseCde {
    @JsonProperty("medioPago")
    private MedioPago medioPago;
    @JsonProperty("acuerdo")
    private Acuerdo acuerdo;
    @JsonProperty("tarifa")
    private TarifaCde tarifa;
    @JsonProperty("empresaMarcaBlanca")
    private EmpresaMarcaBlanca empresaMarcaBlanca;
    public MedioPago getMedioPago() {
	return this.medioPago;
    }
    public void setMedioPago(MedioPago medioPago) {
	this.medioPago = medioPago;
    }
    public Acuerdo getAcuerdo() {
	return this.acuerdo;
    }
    public void setAcuerdo(Acuerdo acuerdo) {
	this.acuerdo = acuerdo;
    }
    public TarifaCde getTarifa() {
	return this.tarifa;
    }
    public void setTarifa(TarifaCde tarifa) {
	this.tarifa = tarifa;
    }
    public EmpresaMarcaBlanca getEmpresaMarcaBlanca() {
	return this.empresaMarcaBlanca;
    }
    public void setEmpresaMarcaBlanca(EmpresaMarcaBlanca empresaMarcaBlanca) {
	this.empresaMarcaBlanca = empresaMarcaBlanca;
    }
}