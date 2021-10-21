package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class EmpresaMarcaBlanca {
    @JsonProperty("id")
    private int id;
    @JsonProperty("nombre")
    private String nombre;
    public int getId() {
	return this.id;
    }
    public void setId(int id) {
	this.id = id;
    }
    public String getNombre() {
	return this.nombre;
    }
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
}
