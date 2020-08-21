package classes;

import java.util.LinkedList;

public class Mercado {
	private LinkedList<Producto> ListaProductos;
	private LinkedList<Vendedor> ListaVendedores;

	public Mercado() {

		ListaProductos = new LinkedList<Producto>();
		ListaVendedores = new LinkedList<Vendedor>();
	}

	public void agregarVendedor(Vendedor nuevoVendedor) throws VendedorYaExiste {
		if (this.ListaVendedores.contains(nuevoVendedor)) {
			throw new VendedorYaExiste();
		} else {
			this.ListaVendedores.add(nuevoVendedor);
			// return "Vendedor agregado correctamente";
		}
	}

	public void agregarProducto(Producto nuevoProducto) {
		this.ListaProductos.add(nuevoProducto);
	}

	public void mostrarVendedores() {
		for (Vendedor v : ListaVendedores) {
			System.out.println("NUMERO : "+this.ListaVendedores.indexOf(v)+" "+v.toString());
		}
	}

	public void mostrarStock() {
		for (Producto p : ListaProductos) {
			System.out.println("NUMERO : "+this.ListaProductos.indexOf(p)+" "+p.toString());
		}
	}

	public void venderProducto(Vendedor vendedor, Producto producto) throws VendedorNoExiste, ProductoNoExiste {
		if (!this.ListaVendedores.contains(vendedor)) {
			throw new VendedorNoExiste();
		}
		if (!this.ListaProductos.contains(producto)) {
			throw new ProductoNoExiste();
		}

		int i = this.ListaVendedores.indexOf(vendedor);
		this.ListaProductos.remove(producto);
		this.ListaVendedores.get(i).sumarContadorVentas();
		float comision = obtenerComision(this.ListaVendedores.get(i).getContadorVentas(), producto.getPrecio());
		System.out.println("La comision del vendedor " + vendedor.getNombre()+" es de " +comision);
		this.ListaVendedores.get(i).sumarComision(comision);

	}

	private float obtenerComision(int contadorVentas, float precio) {

		return (contadorVentas <= 2) ? precio * 0.05f : precio * 0.10f;
	}
	
public void buscarProducto(Producto p) throws ProductoNoExiste {
		
		
			if (this.ListaProductos.contains(p)) {
				System.out.println("PRDUCTO ENCONTRADO : "+p.toString() );
				
			}else {
				throw new ProductoNoExiste();
			}
		
	}
	
	public void buscarProductoCategoria(String c) throws CategoriaNoEncontrada {
		String categoria = c.toLowerCase();
		/*aca podria generar una nueva lista con los tipos de categorias
		 *  y retornarla, pero opte por solamente mostralo por pantalla*/
		boolean encontrado = false;
		for (Producto p : ListaProductos) {
			if (p.getCategoria().equals(categoria)) {
				System.out.println("Categoria : " +categoria+" "+p.toString() );
				encontrado = true;
			}
		}
		if (!encontrado) {
			throw new CategoriaNoEncontrada();
		}
	}
	
	public void buscarProductoCodigo(int codigo) throws ProductoNoExiste {
		
		boolean encontrado = false;
		for (Producto p : ListaProductos) {
			if (p.getCodigo() == codigo) {
				System.out.println("Codigo de producto : "+p.toString() );
				encontrado = true;
			}
		}
		if (!encontrado) {
			throw new ProductoNoExiste();
		}
	}
	
 public void buscarProductoNombre(String nombre) throws ProductoNoExiste {
		
		boolean encontrado = false;
		for (Producto p : ListaProductos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Codigo de producto : "+p.toString() );
				encontrado = true;
			}
		}
		if (!encontrado) {
			throw new ProductoNoExiste();
		}
	}

public LinkedList<Producto> getListaProductos() {
	return ListaProductos;
}

public LinkedList<Vendedor> getListaVendedores() {
	return ListaVendedores;
}
	
}
