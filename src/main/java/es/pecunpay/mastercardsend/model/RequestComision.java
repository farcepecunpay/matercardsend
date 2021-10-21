package es.pecunpay.mastercardsend.model;
import java.util.Date;
/**
 * Clase que se crea al recibir los parametros json para el calculo de comision
 *
 * @author jmansilla_ext
 *
 */
public class RequestComision {
    String payment_type;
    String numMp;
    float importe;
    Date fechaHoraOperacion;
    int pan;
    String nombre;
    String apellidos;
    public String getPayment_type() {
	return this.payment_type;
    }
    public void setPayment_type(String payment_type) {
	this.payment_type = payment_type;
    }
    public String getNumMp() {
	return this.numMp;
    }
    public void setNumMp(String numMP) {
	this.numMp = numMP;
    }
    public float getImporte() {
	return this.importe;
    }
    public void setImporte(float importe) {
	this.importe = importe;
    }
    public Date getFechaHoraOperacion() {
	return this.fechaHoraOperacion;
    }
    public void setFechaHoraOperacion(Date fechaHoraOperacion) {
	this.fechaHoraOperacion = fechaHoraOperacion;
    }
    public int getPan() {
	return this.pan;
    }
    public void setPan(int pan) {
	this.pan = pan;
    }
    public String getNombre() {
	return this.nombre;
    }
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
    public String getApellidos() {
	return this.apellidos;
    }
    public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
    }
}
