package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ValoresTarifa {
    @JsonProperty("valor")
    private String valor;
    public String getValor() {
	return this.valor;
    }
    public void setValor(String valor) {
	this.valor = valor;
    }
}
