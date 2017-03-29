package tienda.enumeraciones;

public enum Marca {
	SN("Sony"), SG("Seagate"), IN("Intel-Core"), SM("Samsung");

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Constructor
	 * @param nombre
	 */

	Marca(String nombre) {
		setNombre(nombre);
	}

	/**
	 * Que guarda un array de String con el nombre de las marcas
	 * 
	 * @return
	 */
	public static String[] elegirMarca() {
		String[] marcas = new String[values().length];
		int i = 0;
		for (Marca marca : values()) {
			marcas[i++] = marca.getNombre();
		}
		return marcas;
	}

}
