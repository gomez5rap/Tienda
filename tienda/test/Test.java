package tienda.test;

import tienda.enumeraciones.Componente;
import tienda.enumeraciones.Marca;
import tienda.excepciones.ComponenteNoValidoException;
import tienda.excepciones.DescripcionNoValidaException;
import tienda.excepciones.ListaVaciaException;
import tienda.excepciones.MarcaNoValidaException;
import tienda.excepciones.PrecioNoValidoException;
import tienda.excepciones.ProductoExisteException;
import tienda.excepciones.ProductoNoExisteException;
import tienda.funcionalidad.Tienda;
import utiles.Menu;
import utiles.Teclado;

public class Test {
	private static Menu menuPrincipal = new Menu("**Menu Principal**", new String[] { "Añadir", "Eliminar",
			"Mostrar Producto por ID", "Mostrar Tienda", "Mostrar productos por marca", "Incrementar 10% precio" });
	private static Menu menuMarcas = new Menu("**Menu Marcas**", Marca.elegirMarca());
	private static Menu menuComponentes = new Menu("**Menu Componentes**", Componente.elegirComponentes());
	private static Tienda tienda = new Tienda();

	public static void main(String[] args) throws DescripcionNoValidaException, MarcaNoValidaException,
			ComponenteNoValidoException, PrecioNoValidoException, ProductoExisteException, ListaVaciaException, ProductoNoExisteException {
gestionarMenu();
	}

	static void gestionarMenu() throws DescripcionNoValidaException, MarcaNoValidaException,
			ComponenteNoValidoException, PrecioNoValidoException, ProductoExisteException, ListaVaciaException, ProductoNoExisteException {
		int opcion;
		do {
			opcion = menuPrincipal.gestionar();
			switch (opcion) {
			case 1:
				annadir();break;
			case 2:
				borrar();break;
			case 3: 
				mostrar(Teclado.leerCadena("Introduce el id"));break;
			case 4:
				mostrar();break;
			case 5:
				mostrar(getMarca());break;
			case 6:
				incrementar();break;
				default:
					System.out.println("Adios...");

			}

		} while (opcion != menuPrincipal.getNumOpciones());
	}

	static void annadir() throws DescripcionNoValidaException, MarcaNoValidaException, ComponenteNoValidoException,
			PrecioNoValidoException, ProductoExisteException {
		try {
			tienda.annadir(getMarca(), getComponentes(), Teclado.leerDecimal("Introduce el precio"),
					Teclado.leerCadena("Introduce la descripción"));
		} catch (DescripcionNoValidaException | MarcaNoValidaException | ComponenteNoValidoException
				| PrecioNoValidoException | ProductoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	static void borrar() throws ProductoNoExisteException {
		try {
			tienda.eliminar(Teclado.leerCadena("Introduce el identificador"));
		} catch (ProductoNoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	static void mostrar() throws ListaVaciaException {
		try {
			System.out.println(tienda.mostrar());
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
		}
	}

	static void mostrar(String id) throws ListaVaciaException, ProductoNoExisteException {
		try {
			System.out.println(tienda.mostrar(id));
		} catch (ListaVaciaException | ProductoNoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	static void mostrar(Marca marca) throws ListaVaciaException {
		try {
			System.out.println(tienda.mostrar(marca));
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
		}
	}

	static void incrementar() throws PrecioNoValidoException {
		try {
			tienda.aumentarProducto();
		} catch (PrecioNoValidoException e) {
			System.out.println(e.getMessage());
		}
	}

	static Marca getMarca() {
		int opcion;
		do {
			opcion = menuMarcas.gestionarSinSalida();
			switch (opcion) {
			default:
				return Marca.values()[opcion-1];
			}
		} while (opcion != menuMarcas.getNumOpciones());

	}

	static Componente getComponentes() {
		int opcion;
		do {
			opcion = menuComponentes.gestionarSinSalida();
			switch (opcion) {
			default:
				return Componente.values()[opcion-1];
			}
		} while (opcion != menuComponentes.getNumOpciones());

	}
}