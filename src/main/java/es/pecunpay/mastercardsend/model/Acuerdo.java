package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Acuerdo {
    @JsonProperty("id_acuerdo")
    private int id_acuerdo;
    @JsonProperty("estadoAcuerdo")
    private String estado;
    @JsonProperty("numeroAcuerdoCDE")
    private String numeroAcuerdoCDE;
    @JsonProperty("saldo")
    private String saldo;
    public int getId_acuerdo() {
	return this.id_acuerdo;
    }
    public void setId_acuerdo(int id_acuerdo) {
	this.id_acuerdo = id_acuerdo;
    }
    public String getEstado() {
	return this.estado;
    }
    public void setEstado(String estado) {
	this.estado = estado;
    }
    public String getNumeroAcuerdoCDE() {
	return this.numeroAcuerdoCDE;
    }
    public void setNumeroAcuerdoCDE(String numeroAcuerdoCDE) {
	this.numeroAcuerdoCDE = numeroAcuerdoCDE;
    }
    public String getSaldo() {
	return this.saldo;
    }
    public void setSaldo(String saldo) {
	this.saldo = saldo;
    }
}
