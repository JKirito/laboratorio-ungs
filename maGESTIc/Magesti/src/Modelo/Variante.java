package Modelo;

public class Variante {
	
	private Integer id_variante;
	private String nombre;
	
	
	public Variante(Integer id_variante, String nombre) {
		super();
		this.id_variante = id_variante;
		this.nombre = nombre;
	}

	public Variante(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	public Integer getId_variante() {
		return id_variante;
	}


	public void setId_variante(Integer id_variante) {
		this.id_variante = id_variante;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public boolean Alta() {
		String nombre = this.getNombre();

		if (ConexionDB.baseDatos
				.ejecutar("INSERT INTO variante VALUES(default," + "'" + nombre
						+ "'" + ");")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
}
