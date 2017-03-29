package utiles;

public class Menu {
	/**
	 * Variables que recogeran el titulo y las opciones del menu
	 */
	private String titulo;
	private String[] opciones;
	
	/**
	 * Constructor de menu
	 * @param titulo
	 * @param opciones
	 */
	public Menu(String titulo, String[] opciones){
		setTitulo(titulo);
		setOpciones(opciones);
	}
	
	/**
	 * Muestra el menu
	 */
	private void mostrar(){
		System.out.println(getTitulo());
		for(int i = 0; i<getOpciones().length; i++){
			System.out.println("("+(i+1)+") "+getOpciones()[i]);
		}
		System.out.println("("+(getOpciones().length+1)+") Salir"); // Una opcion que no se encuentra en el array, que se lo añadiremos en la última opcion + 1 
	}
	
	/**
	 *  Gestiona el menu, mostrando y recogiendo una opcion valida
	 * @return opcion valida
	 */
	public int gestionar(){
		mostrar();
		return recogerOpcion();
		
	}
	
	public int gestionarSinSalida(){
		System.out.println(getTitulo());
		for(int i = 0; i<getOpciones().length; i++){
			System.out.println("("+(i+1)+") "+getOpciones()[i]);
		}
		
		int opcion = Teclado.leerEntero("Dame una opcion: ");

		while (opcion <= 0 || opcion > getOpciones().length) {
			opcion = Teclado.leerEntero("Introduce una opcion VALIDA: ");
		}
		return opcion;
	}
	
	/**
	 * Recoge una opcion valida. Le añadimos getOpciones() porque le añadimos el salir que no esta en el array
	 * @return opcion
	 */
	private int recogerOpcion(){
		int opcion = Teclado.leerEntero("Dame una opcion: ");
		
		while(opcion <= 0 || opcion > getOpciones().length+1){
			opcion = Teclado.leerEntero("Introduce una opcion VALIDA: ");
		}
		return opcion;
	}

	
	private String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private String[] getOpciones() {
		return opciones;
	}

	private void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	
	public int getNumOpciones(){
		return getOpciones().length+1;
	}
	
}
