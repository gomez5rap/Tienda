package tienda.funcionalidad;

import java.util.ArrayList;

import tienda.enumeraciones.Componente;
import tienda.enumeraciones.Marca;
import tienda.excepciones.ComponenteNoValidoException;
import tienda.excepciones.DescripcionNoValidaException;
import tienda.excepciones.ListaVaciaException;
import tienda.excepciones.MarcaNoValidaException;
import tienda.excepciones.PrecioNoValidoException;
import tienda.excepciones.ProductoExisteException;
import tienda.excepciones.ProductoNoExisteException;

public class Tienda {
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	public void annadir(Marca marca, Componente componente, double precio, String descriptor)
			throws DescripcionNoValidaException, MarcaNoValidaException, ComponenteNoValidoException,
			PrecioNoValidoException, ProductoExisteException {
		Producto producto = new Producto(marca, componente, precio, descriptor);
		if (listaProductos.contains(producto))
			throw new ProductoExisteException("El producto ya esta en la lista.");
		listaProductos.add(producto);
	}

	public void eliminar(String id) throws ProductoNoExisteException {
		if (!listaProductos.remove(new Producto(id)))
			throw new ProductoNoExisteException("El producto no existe.");
	}

	public String mostrar() throws ListaVaciaException {
		if (listaProductos.isEmpty())
			throw new ListaVaciaException("La lista esta vacia compadre.");
		StringBuilder cadena = new StringBuilder();
		for (Producto producto : listaProductos) {
			cadena.append(producto.toString() + "\n");
		}
		return cadena.toString();
	}

	public String mostrar(Marca marca) throws ListaVaciaException {
		if (listaProductos.isEmpty())
			throw new ListaVaciaException("La lista esta vacia compadre.");
		StringBuilder cadena = new StringBuilder();
		for (Producto producto : listaProductos) {
			if (producto.getMarca() == marca)
				cadena.append(producto.toString() + "\n");
		}
		return cadena.toString();
	}

	public void aumentarProducto() throws PrecioNoValidoException {
		for (Producto producto : listaProductos) {
			producto.incrementarPrecio();

		}
	}

	public String mostrar(String id) throws ListaVaciaException, ProductoNoExisteException {
		Producto producto = new Producto(id);

		if (listaProductos.isEmpty())
			throw new ListaVaciaException("La lista esta vacia compadre.");
		if (!listaProductos.contains(producto))
			throw new ProductoNoExisteException("No existe el producto");
		return listaProductos.get(listaProductos.indexOf(producto)).toString();

	}
}
