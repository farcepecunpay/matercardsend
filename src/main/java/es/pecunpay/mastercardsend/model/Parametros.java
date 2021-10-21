package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Parametros {
    @JsonProperty("id")
    private int id;
    @JsonProperty("valoresTarifa")
    private ValoresTarifa valoresTarifa;
    @JsonProperty("negociable")
    private boolean negociable;
    @JsonProperty("parametro")
    private Parametro parametro;
    @JsonProperty("tarifa")
    private Tarifa tarifa;
    @JsonProperty("negociablePorApi")
    private boolean negociablePorApi;
    public int getId() {
	return this.id;
    }
    public void setId(int id) {
	this.id = id;
    }
    public ValoresTarifa getValoresTarifa() {
	return this.valoresTarifa;
    }
    public void setValoresTarifa(ValoresTarifa valoresTarifa) {
	this.valoresTarifa = valoresTarifa;
    }
    public boolean isNegociable() {
	return this.negociable;
    }
    public void setNegociable(boolean negociable) {
	this.negociable = negociable;
    }
    public Parametro getParametro() {
	return this.parametro;
    }
    public void setParametro(Parametro parametro) {
	this.parametro = parametro;
    }
    public Tarifa getTarifa() {
	return this.tarifa;
    }
    public void setTarifa(Tarifa tarifa) {
	this.tarifa = tarifa;
    }
    public boolean isNegociablePorApi() {
	return this.negociablePorApi;
    }
    public void setNegociablePorApi(boolean negociablePorApi) {
	this.negociablePorApi = negociablePorApi;
    }
}
