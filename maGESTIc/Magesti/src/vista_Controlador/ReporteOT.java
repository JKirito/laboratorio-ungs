package vista_Controlador;

import java.util.ArrayList;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReporteOT 
{
	private String nroOT, nombreOT, cliente, descripcion, tipoProducto, preimpresion, estado;
	private String fechaProm, fechaConfec,fechaCierre,apasiado,cantEntregar;
	private Double ancho, alto;
	private ArrayList<FilaElementos> elementos;
	private ArrayList<FilaMateriales> materiales;
	private ArrayList<FilaOEjecucion> ordenEjecucion;
	
	public ReporteOT(String nroOT, String nombreOT, String cliente,
			String descripcion, String tipoProducto, String preimpresion,
			String estado, String fechaProm, String fechaConfec, Double ancho, Double alto,
			String cantEntregar, String apasiado, String fcierre, ArrayList<FilaElementos> elementos,
			ArrayList<FilaMateriales> materiales,ArrayList<FilaOEjecucion> ordenEjecucion) 
	{
		this.nroOT = nroOT;
		this.nombreOT = nombreOT;
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.tipoProducto = tipoProducto;
		this.preimpresion = preimpresion;
		this.estado = estado;
		this.fechaProm = fechaProm;
		this.fechaConfec = fechaConfec;
		this.apasiado = apasiado;
		this.cantEntregar = cantEntregar;
		this.ancho = ancho;
		this.alto = alto;
		this.fechaCierre=fcierre;
		this.elementos = elementos;
		this.materiales = materiales;
		this.ordenEjecucion = ordenEjecucion;
	}



	public String getNroOT() 
	{
		return nroOT;
	}

	public void setNroOT(String nroOT)
	{
		this.nroOT = nroOT;
	}

	public String getNombreOT() 
	{
		return nombreOT;
	}

	public void setNombreOT(String nombreOT) 
	{
		this.nombreOT = nombreOT;
	}

	public String getCliente() 
	{
		return cliente;
	}

	public void setCliente(String cliente) 
	{
		this.cliente = cliente;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	public String getTipoProducto() 
	{
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) 
	{
		this.tipoProducto = tipoProducto;
	}

	public String getPreimpresion() 
	{
		return preimpresion;
	}

	public void setPreimpresion(String preimpresion)
	{
		this.preimpresion = preimpresion;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado) 
	{
		this.estado = estado;
	}

	public String getFechaProm()
	{
		return fechaProm;
	}

	public void setFechaProm(String fechaProm) 
	{
		this.fechaProm = fechaProm;
	}

	public String getFechaConfec() 
	{
		return fechaConfec;
	}

	public void setFechaConfec(String fechaConfec) 
	{
		this.fechaConfec = fechaConfec;
	}

	public Double getAncho() 
	{
		return ancho;
	}

	public void setAncho(Double ancho) 
	{
		this.ancho = ancho;
	}

	public Double getAlto()
	{
		return alto;
	}

	public void setAlto(Double alto)
	{
		this.alto = alto;
	}

	public String getCantEntregar() 
	{
		return cantEntregar;
	}

	public void setCantEntregar(String cantEntregar) 
	{
		this.cantEntregar = cantEntregar;
	}

	public String getApasiado() 
	{
		return apasiado;
	}

	public void setApasiado(String apasiado) 
	{
		this.apasiado = apasiado;
	}
	
	public ArrayList<FilaElementos> getElementos()
	{
		return elementos;
	}

	public void setElementos(ArrayList<FilaElementos> elementos) 
	{
		this.elementos = elementos;
	}

	public ArrayList<FilaMateriales> getMateriales() 
	{
		return materiales;
	}

	public void setMateriales(ArrayList<FilaMateriales> materiales) 
	{
		this.materiales = materiales;
	}

	public ArrayList<FilaOEjecucion> getOrdenEjecucion() 
	{
		return ordenEjecucion;
	}

	public void setOrdenEjecucion(ArrayList<FilaOEjecucion> ordenEjecucion) 
	{
		this.ordenEjecucion = ordenEjecucion;
	}

	public String getFechaCierre() 
	{
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre)
	{
		this.fechaCierre = fechaCierre;
	}
	
	
}
