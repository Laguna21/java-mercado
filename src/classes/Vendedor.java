package classes;

public class Vendedor {
private Integer codigo;
private String nombre;
private float sueldo;
private int contadorVentas=0;
private float comisionPorVenta=0;

public Vendedor(Integer codigo, String nombre, float sueldo) {
	
	this.codigo = codigo;
	this.nombre = nombre;
	this.sueldo = sueldo;
}
public Integer getCodigo() {
	return codigo;
}
public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public float getSueldo() {
	return sueldo;
}
public void setSueldo(float sueldo) {
	this.sueldo = sueldo;
}
@Override
public String toString() {
	return "Vendedor  : " + nombre + "  [ codigo= " + codigo + ", sueldo= " + sueldo + " comisiones= "+comisionPorVenta+" ]";
}
public int getContadorVentas() {
	return contadorVentas;
}
public void sumarContadorVentas() {
	this.contadorVentas ++;
}
public void sumarComision(float com) {
	this.comisionPorVenta+= com;
}
}
