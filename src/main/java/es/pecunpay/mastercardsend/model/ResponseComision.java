package es.pecunpay.mastercardsend.model;
/**
 * Clase que contiene los datos de respuesta de la aplicacion con la comision
 * creada
 *
 * @author jmansilla_ext
 *
 */
public class ResponseComision {
    private String estado;
    private String ide_tra_mcs;
    private float comision;
    public String getEstado() {
	return this.estado;
    }
    public void setEstado(String estado) {
	this.estado = estado;
    }
    public String getIde_tra_mcs() {
	return this.ide_tra_mcs;
    }
    public void setIde_tra_mcs(String string) {
	this.ide_tra_mcs = string;
    }
    public float getComision() {
	return this.comision;
    }
    public void setComision(float comision) {
	this.comision = comision;
    }
}