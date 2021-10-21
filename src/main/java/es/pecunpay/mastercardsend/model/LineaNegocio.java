package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class LineaNegocio {
    @JsonProperty("id")
    private int id;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("tipoAcuerdo")
    private String tipoAcuerdo;
    public int getId() {
	return this.id;
    }
    public void setId(int id) {
	this.id = id;
    }
    public String getCodigo() {
	return this.codigo;
    }
    public void setCodigo(String codigo) {
	this.codigo = codigo;
    }
    public String getNombre() {
	return this.nombre;
    }
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
    public String getTipoAcuerdo() {
	return this.tipoAcuerdo;
    }
    public void setTipoAcuerdo(String tipoAcuerdo) {
	this.tipoAcuerdo = tipoAcuerdo;
    }
}