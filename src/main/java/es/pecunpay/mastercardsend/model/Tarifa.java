package es.pecunpay.mastercardsend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Tarifa {
    @JsonProperty("id")
    private int id;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("estadoTarifa")
    private String estadoTarifa;
    @JsonProperty("tipoMedioPago")
    private String tipoMedioPago;
    @JsonProperty("producto")
    private Producto producto;
    @JsonProperty("idEmpresaMarca")
    private int idEmpresaMarca;
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
    public String getEstadoTarifa() {
	return this.estadoTarifa;
    }
    public void setEstadoTarifa(String estadoTarifa) {
	this.estadoTarifa = estadoTarifa;
    }
    public String getTipoMedioPago() {
	return this.tipoMedioPago;
    }
    public void setTipoMedioPago(String tipoMedioPago) {
	this.tipoMedioPago = tipoMedioPago;
    }
    public Producto getProducto() {
	return this.producto;
    }
    public void setProducto(Producto producto) {
	this.producto = producto;
    }
    public int getIdEmpresaMarca() {
	return this.idEmpresaMarca;
    }
    public void setIdEmpresaMarca(int idEmpresaMarca) {
	this.idEmpresaMarca = idEmpresaMarca;
    }
}