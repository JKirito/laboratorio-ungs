package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Variante {
	
	private Integer id_variante;
	private String nombre;
	private Boolean activo;
	
	public Variante(Integer id_variante, String nombre, Boolean activo) 
	{
		super();
		this.id_variante = id_variante;
		this.nombre = nombre;
		this.activo = activo;
	}

	public Variante(String nombre, Boolean activo) 
	{
		super();
		this.nombre = nombre;
		this.activo = activo;
	}

	public static Integer getId_Variante(String nombreElegido)
	{
		Integer id_var = null;
		nombreElegido = "'" + nombreElegido + "'";
		ResultSet resultado = ConexionDB.getbaseDatos().consultar(
				"SELECT id_variante FROM variante WHERE nombre ="+ nombreElegido);
		
		if (resultado != null) 
		{
			try 
			{
				while (resultado.next()) 
				{
					id_var = resultado.getInt(1);
					break;
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}	
		
		return id_var;
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
	
	public static ArrayList<String> getVarianteDeRetiro(Integer id_SC)
	{
		ArrayList<String> variantes = new ArrayList<String>();
		ResultSet resultado = ConexionDB.getbaseDatos().consultar(
				"SELECT v.nombre FROM variante v INNER JOIN detalle d ON v.id_variante = d.id_variante" +
				" AND id_solicitud_compra = " + id_SC + ";");
		
		if (resultado != null) 
		{
			try 
			{
				while (resultado.next()) 
				{
					variantes.add(resultado.getString("nombre"));
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}	
		return variantes;
	}
	
	public static  String[] getVariantes()
	{
		ArrayList<String> var=new ArrayList<String>();
		
		ResultSet resultado = ConexionDB.getbaseDatos().consultar("SELECT nombre FROM variante WHERE activo = true");
		
		if (resultado != null) 
		{
			try 
			{
				while (resultado.next()) 
				{
					var.add(resultado.getString("nombre"));
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		String [] vars= new String[var.size()];
		
		for(int i=0;i<var.size();i++)
		{
			vars[i]=var.get(i);
		}
		
		return vars;
	}
	
	public static String getNombre(Integer id_var)
	{
		String valor = "";
		ResultSet resultado = ConexionDB.getbaseDatos().consultar(
				"SELECT nombre FROM variante WHERE id_variante="+ id_var);

		if (resultado != null)
		{
			try
			{
				while (resultado.next())
				{
					valor = resultado.getString("nombre");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return valor;
	}
	
	public Boolean getActivo() 
	{
		return activo;
	}

	public void setActivo(Boolean activo) 
	{
		this.activo = activo;
	}
	
	public boolean Alta() {
		String nombre = this.getNombre();
		Boolean activoVariante = this.getActivo();
		
		if (ConexionDB.getbaseDatos()
				.ejecutar("INSERT INTO variante VALUES(default," + "'" + nombre + "'" + "," + activoVariante
						+ ");")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public ArrayList<Variante> Buscar() {

		ResultSet resultado = ConexionDB.getbaseDatos().consultar(
				"SELECT * FROM variante");

		ArrayList<Variante> list_Var = new ArrayList<Variante>();
		if (resultado != null) {

			try {

				while (resultado.next()) {
					Variante variante = new Variante(new Integer(
							resultado.getInt("id_variante")),
							resultado.getString("nombre"),
							resultado.getBoolean("activo"));
					list_Var.add(variante);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list_Var;
	}
	
	public static boolean updateVariante(String id, String nombre, Boolean activo)
	{
		boolean r=ConexionDB.getbaseDatos().ejecutar(
				"UPDATE variante SET nombre = " + "'"+nombre+"'" + ", activo=" + activo
						+ " WHERE id_variante =" 
						+ Integer.parseInt(id));
		return r;
	}
	
	public static  Integer getCantidadVariantes()
	{
		Integer cantidad=0;
		ResultSet resultado = ConexionDB.getbaseDatos().consultar("SELECT COUNT(*) FROM variante");
		
		if (resultado != null) 
		{
			try 
			{
				while (resultado.next()) 
				{
					cantidad= resultado.getInt(1);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return cantidad;
	}
	
	
	
}
