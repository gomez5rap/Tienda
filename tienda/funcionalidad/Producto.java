package tienda.funcionalidad;

import java.util.regex.Pattern;

import tienda.enumeraciones.Componente;
import tienda.enumeraciones.Marca;
import tienda.excepciones.ComponenteNoValidoException;
import tienda.excepciones.DescripcionNoValidaException;
import tienda.excepciones.MarcaNoValidaException;
import tienda.excepciones.PrecioNoValidoException;

public class Producto {
	private Pattern patron = Pattern.compile("([A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄\\.\\d\\-]+\\s){2,}[A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄\\.\\d\\-]+");
	private Marca marca;
	private Componente componente;
	private double precio;
	private String descriptor;
	private static int id = 1;
	private String identificador;

	Marca getMarca() {
		return marca;
	}

	private void setMarca(Marca marca) throws MarcaNoValidaException {
		if (marca == null)
			throw new MarcaNoValidaException("La marca introducida no es valida.");
		this.marca = marca;
	}

	

	private void setComponente(Componente componente) throws ComponenteNoValidoException {
		if (componente == null)
			throw new ComponenteNoValidoException("El componente introducido no es valido.");
		this.componente = componente;
	}

	double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) throws PrecioNoValidoException {
		if (precio <= 0.0)
			throw new PrecioNoValidoException("El precio introducido no es valido");
		this.precio = precio;
	}

	

	private void setDescriptor(String descriptor) throws DescripcionNoValidaException {
		if (!patron.matcher(descriptor).matches())
			throw new DescripcionNoValidaException("La descripciÛn no es valida.");
		this.descriptor = descriptor;

	}

	private static int getId() {
		return id;
	}


	Producto(String id){
		setIdentificador(id);
	}
	Producto(Marca marca, Componente componente, double precio, String descriptor) throws DescripcionNoValidaException,
			MarcaNoValidaException, ComponenteNoValidoException, PrecioNoValidoException {

		
		setMarca(marca);
		setComponente(componente);
		setDescriptor(descriptor);
		setPrecio(precio);
		setIdentificador(marca.toString() + "-" + componente.toString() + "-" + (getId()));
		id++;
	}

	public String getIdentificador() {
		return identificador;
	}

	@Override
	public String toString() {
		return "Producto [marca=" + marca + ", componente=" + componente + ", precio=" + precio + ", descriptor="
				+ descriptor + "] "+getIdentificador();
	}

	private void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public void incrementarPrecio() throws PrecioNoValidoException{
		if(getPrecio()<100)
		setPrecio(getPrecio()*1.1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}
	

	
	

}
