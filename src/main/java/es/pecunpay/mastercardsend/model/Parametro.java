package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Parametro {
    @JsonProperty("id")
    private int id;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("tipoParametroTarifa")
    private String tipoParametroTarifa;
    @JsonProperty("agrupacionParametroTarifa")
    private String agrupacionParametroTarifa;
    @JsonProperty("paramsuperior")
    private String paramsuperior;
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
    public String getTipoParametroTarifa() {
	return this.tipoParametroTarifa;
    }
    public void setTipoParametroTarifa(String tipoParametroTarifa) {
	this.tipoParametroTarifa = tipoParametroTarifa;
    }
    public String getAgrupacionParametroTarifa() {
	return this.agrupacionParametroTarifa;
    }
    public void setAgrupacionParametroTarifa(String agrupacionParametroTarifa) {
	this.agrupacionParametroTarifa = agrupacionParametroTarifa;
    }
    public String getParamsuperior() {
	return this.paramsuperior;
    }
    public void setParamsuperior(String paramsuperior) {
	this.paramsuperior = paramsuperior;
    }
}