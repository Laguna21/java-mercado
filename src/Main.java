import java.util.LinkedList;
import java.util.Scanner;

import classes.*;

public class Main {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		
		
	Vendedor v1 = new Vendedor(11, "test", 555f);
	
	Producto p1 = new Producto(1, "papa", 10f, "verdura");
	Producto p2 = new Producto(2, "cerdo", 33f, "CARNE");
	Producto p3 = new Producto(7, "celular", 50f, "Celulares");
	Mercado croto = new Mercado();
	
	croto.agregarVendedor(v1);
	croto.agregarProducto(p1);
	croto.agregarProducto(p2);
	croto.agregarProducto(p3);
	
	
	int opcion = 0;
	do {
		System.out.println("Ingresar 1 para agregar vendedor,"
				+ " 2 para agregar producto,3 para vender,"
				+ " 4 para buscar producto, 5 mostrar productos, 6 mostrar vendedores"
				+ " o 0 para salir");
		opcion = teclado.nextInt();
		switch (opcion) {
		case 1: 
			ingresarVendedores(croto);
			break;
		case 2: 	
			ingresarProductos(croto);
			break;
		case 3: 
			vender(croto);
			break;
		case 4:
			buscar(croto);
			break;
		case 5:
			croto.mostrarStock();
			break;
		case 6: 
			croto.mostrarVendedores();
			break;
		default:
			opcion = 0;
		}
		
	} while (opcion != 0);
	System.out.println("Muchas gracias!");
	System.exit(0);
	}
	

	public static void ingresarVendedores(Mercado mercado) throws VendedorYaExiste
	{
		System.out.println("Cuantos Vendedores va a ingresar?");
		int cant = teclado.nextInt();
		for (int i = 0; i < cant; i++) {
			teclado.nextLine();
			System.out.println("Ingresar nombre: ");
			String nombre = teclado.nextLine();

			System.out.println("Ingresar salario: ");
			Float salario = teclado.nextFloat();

			teclado.nextLine();
			System.out.println("Ingrese su codigo: ");
			int codigo = teclado.nextInt();
			
			Vendedor v = new Vendedor(codigo,nombre,salario);
			mercado.agregarVendedor(v);
		}
		teclado.nextLine();
	}

	public static void ingresarProductos(Mercado mercado) throws VendedorYaExiste
	{
		System.out.println("Cuantos Productos va a ingresar?");
		int cant = teclado.nextInt();
		for (int i = 0; i < cant; i++) {
			teclado.nextLine();
			System.out.println("Ingresar nombre: ");
			String nombre = teclado.nextLine();

			System.out.println("Ingresar salario: ");
			Float precio = teclado.nextFloat();

			teclado.nextLine();
			System.out.println("Ingrese su codigo: ");
			int codigo = teclado.nextInt();
			
			teclado.nextLine();
			System.out.println("Ingrese su categoria: ");
			String categoria = teclado.nextLine();
			
			Producto p = new Producto(codigo,nombre,precio,categoria);
			mercado.agregarProducto(p);
		}
	}
	
	public static void vender(Mercado mercado) throws VendedorYaExiste, VendedorNoExiste, ProductoNoExiste
	{
		System.out.println("Selecciones con NUMERO que vendedor efectuara la venta");
		mercado.mostrarVendedores();
		int iVend = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Selecciones con NUMERO que Producto se vendio");
		mercado.mostrarStock();;
		int iProd = teclado.nextInt();
		
		Vendedor vendedor = mercado.getListaVendedores().get(iVend);
		Producto producto = mercado.getListaProductos().get(iProd);
		mercado.venderProducto(vendedor, producto);
	}
	
	public static void buscar(Mercado mercado)throws ProductoNoExiste, CategoriaNoEncontrada
	{
		teclado.nextLine();
		System.out.println("Seleccione 1 para buscar por nombre, 2 para categoria o 0 para salir");
		int op = 0 ;
			op=	teclado.nextInt();
		teclado.nextLine();
		
		do {
			switch (op) {
			case 1:
				System.out.println("ingresar nombre de producto:");
				String nombre = teclado.nextLine();
				mercado.buscarProductoNombre(nombre);
				op = 0;
				break;
			case 2:
				System.out.println("ingresar nombre de producto:");
				String categoria = teclado.nextLine();
				mercado.buscarProductoCategoria(categoria);
				op = 0;
				break;
				
			default:
				op = 0;
				break;
			}
		} while (op!=0);
		
		
	
	}
}
