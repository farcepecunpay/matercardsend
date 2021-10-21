package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class TarifaCde {
    @JsonProperty("estadoTarifa")
    private String estado;
    @JsonProperty("nombre")
    private String nombre;
    public String getEstado() {
	return this.estado;
    }
    public void setEstado(String estado) {
	this.estado = estado;
    }
    public String getNombre() {
	return this.nombre;
    }
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
}