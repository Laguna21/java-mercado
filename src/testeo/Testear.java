package testeo;



import org.junit.Test;

import classes.CategoriaNoEncontrada;
import classes.Mercado;
import classes.Producto;
import classes.ProductoNoExiste;
import classes.Vendedor;
import classes.VendedorNoExiste;
import classes.VendedorYaExiste;

public class Testear {
@Test
	public void testVendedoresEmpresa() throws VendedorYaExiste{
	Vendedor v1 = new Vendedor(1,"laguna",333f);
	Vendedor v2 = new Vendedor(2,"lang",111f);
	Vendedor v3 = new Vendedor(3,"asda",222f);
	
	Mercado songa = new Mercado();
	
	songa.agregarVendedor(v1);
	songa.agregarVendedor(v2);
	songa.agregarVendedor(v3);
	songa.mostrarVendedores();
	
	
	}
@Test
public void testProductosEmpresa(){

Producto p1 = new Producto(1, "papa", 10f, "verdura");
Producto p2 = new Producto(2, "cerdo", 33f, "CARNE");
Producto p3 = new Producto(7, "celular", 50f, "Celulares");
Mercado songa = new Mercado();

songa.agregarProducto(p1);
songa.agregarProducto(p2);
songa.agregarProducto(p3);
songa.mostrarStock();

}
@Test(expected = VendedorYaExiste.class)
public void testVendedoresError() throws VendedorYaExiste{
Vendedor v1 = new Vendedor(1,"laguna",333f);
Vendedor v2 = new Vendedor(2,"lang",111f);
Vendedor v3 = new Vendedor(3,"asda",222f);

Mercado songa = new Mercado();

songa.agregarVendedor(v1);
songa.agregarVendedor(v1);
songa.agregarVendedor(v3);
songa.mostrarVendedores();

}

@Test
public void testVentas() throws VendedorYaExiste, VendedorNoExiste, ProductoNoExiste{
Vendedor v1 = new Vendedor(1,"laguna",333f);

Producto p1 = new Producto(1, "papa", 10f, "verdura");
Producto p2 = new Producto(2, "cerdo", 33f, "CARNE");
Producto p3 = new Producto(7, "celular", 50f, "Celulares");
Mercado songa = new Mercado();

songa.agregarVendedor(v1);
songa.agregarProducto(p1);
songa.agregarProducto(p2);
songa.agregarProducto(p3);

songa.venderProducto(v1, p1);
songa.venderProducto(v1, p2);
songa.venderProducto(v1, p3);
}

@Test(expected = VendedorNoExiste.class)
public void testVentasErrorVendedor() throws VendedorYaExiste, VendedorNoExiste, ProductoNoExiste{
Vendedor v1 = new Vendedor(1,"laguna",333f);
Vendedor v2 = new Vendedor(2,"lang",111f);
Producto p1 = new Producto(1, "papa", 10f, "verdura");

Mercado songa = new Mercado();

songa.agregarVendedor(v1);
songa.agregarProducto(p1);

songa.venderProducto(v2, p1);
}

@Test(expected = ProductoNoExiste.class)
public void testVentasError() throws VendedorYaExiste, VendedorNoExiste, ProductoNoExiste{
Vendedor v1 = new Vendedor(1,"laguna",333f);

Producto p1 = new Producto(1, "papa", 10f, "verdura");
Producto p2 = new Producto(2, "cerdo", 33f, "CARNE");
Mercado songa = new Mercado();

songa.agregarVendedor(v1);
songa.agregarProducto(p1);

songa.venderProducto(v1, p2);
}

@Test
public void testBuscarProductos() throws ProductoNoExiste, CategoriaNoEncontrada{

Producto p1 = new Producto(1, "papa", 10f, "verdura");
Producto p2 = new Producto(2, "cerdo", 33f, "CARNE");
Producto p3 = new Producto(7, "celular", 50f, "Celulares");
Mercado songa = new Mercado();

songa.agregarProducto(p1);
songa.agregarProducto(p2);
songa.agregarProducto(p3);

songa.buscarProducto(p1);
songa.buscarProductoCategoria("verdURA");
songa.buscarProductoCodigo(1);
songa.buscarProductoNombre("pAPA");

}

@Test(expected = CategoriaNoEncontrada.class)
public void testBuscarProductosErrorCategoria() throws ProductoNoExiste, CategoriaNoEncontrada{

Producto p1 = new Producto(1, "papa", 10f, "verdura");
Producto p2 = new Producto(2, "cerdo", 33f, "CARNE");
Producto p3 = new Producto(7, "celular", 50f, "Celulares");
Mercado songa = new Mercado();

songa.agregarProducto(p1);
songa.agregarProducto(p2);
songa.agregarProducto(p3);

songa.buscarProducto(p1);
songa.buscarProductoCategoria("verdURAsas");
songa.buscarProductoCodigo(1);
songa.buscarProductoNombre("pAPA");

}
}
