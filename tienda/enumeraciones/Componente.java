package tienda.enumeraciones;

public enum Componente {
	DD("Discos Duros"), PR("Procesadores"), MR("Memoria Ram"), FP("Fuente Alimentación");

	private String nombre;

	/**
	 * Constructor
	 * 
	 * @param nombre
	 */
	Componente(String nombre) {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Guarda un array de String con el nombre de las componentes
	 * 
	 * @return
	 */
	public static String[] elegirComponentes() {
		String[] componentes = new String[values().length];
		int i = 0;
		for (Componente componente : values()) {
			componentes[i++] = componente.getNombre();
		}
		return componentes;
	}

}
