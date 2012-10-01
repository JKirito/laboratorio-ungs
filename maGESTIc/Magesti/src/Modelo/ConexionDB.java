package Modelo;

public class ConexionDB {
	
	private static MySQLBD baseDatos = new MySQLBD().conectar();
	
	private ConexionDB() {}
	
	
	// creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciaci�n m�ltiple 
	private synchronized static void createInstance() {
        if (baseDatos == null) { 
            baseDatos= new MySQLBD();
        }
    }
	
	public static MySQLBD getbaseDatos(){
		createInstance();
		return baseDatos;
	}

	//El m�todo "clone" es sobreescrito por el siguiente que arroja una excepci�n:
	public Object clone() throws CloneNotSupportedException {
	        throw new CloneNotSupportedException(); 
	}
	
	
	//static final MySQLBD baseDatos = new MySQLBD().conectar();
}
