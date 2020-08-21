package classes;

public class Producto {
	
	private Integer codigo;
	private String nombre;
	private float precio;
	private String categoria;

	public Producto(Integer codigo, String nombre, float precio, String categoria) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria.toLowerCase();

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto : " + nombre + " [ codigo=" + codigo +  ", precio=" + precio + ", categoria=" + categoria
				+ "]";
	}
	
}
