package es.pecunpay.mastercardsend.model;
public class ResponsePedirTransferencia {
    private String estado;
    private String motivo_estado;
    public String getEstado() {
	return this.estado;
    }
    public void setEstado(String estado) {
	this.estado = estado;
    }
    public String getMotivo_estado() {
	return this.motivo_estado;
    }
    public void setMotivo_estado(String motivo_estado) {
	this.motivo_estado = motivo_estado;
    }
}