package vista_Controlador;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.*;

import vista_Controlador.OrdenDeTrabajo;
@SuppressWarnings("serial")
public class Calendario 
extends JInternalFrame 
implements ItemListener,ActionListener, Config
{
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	private JPanel pan3 = new JPanel();


	
	private Choice chAnio  = new Choice();
	private Choice chMes = new Choice();

	private JLabel lblAnio  = new JLabel("   Seleccione el A�o: ");
	private JLabel lblMes = new JLabel("   seleccione el Mes: ");

	private JButton btnMatriz[]= new JButton[31];

  	String dias[] = 
  	{
		"DOMINGO", 
		"LUNES", 
		"MARTES", 
		"MI�RCOLES",
		"JUEVES",
		"VIERNES", 
		"S�BADO"
  	};

  	String meses[]=
  	{
  		"Enero", 
  		"Febrero", 
  		"Marzo", 
  		"Abril",
  		"Mayo", 
  		"Junio",
		"Julio", 
		"Agosto", 
		"Septiembre",
		"Octubre", 
		"Noviembre", 
		"Diciembre"
	};

	String diaTemp="", anio, mm, dd;

	int 
	btn_tag=1,
	diaSeleccionado=1, 
	Anio, 
	DiaDeLaSemana,
	totalDiasDelMes,
	MM, 
	id=1;
	boolean 
	filaUno=true;

	JLabel txt_lbl;
	TextArea ta;
	JButton Ingresar,Modificar,Borrar,Siguiente,Anterior,Salir;
	private final JPanel panel = new JPanel();
	
	private java.util.Date fechaHoy= new java.util.Date ();
	
	private SimpleDateFormat fechaDiaHoy = new SimpleDateFormat ("dd", Locale.getDefault());
	private SimpleDateFormat fechaMesHoy = new SimpleDateFormat ("MM", Locale.getDefault());
	private SimpleDateFormat fechaAnioHoy = new SimpleDateFormat ("yy", Locale.getDefault());
	
	private String diaHoy = fechaDiaHoy.format (fechaHoy);
	private String mesHoy = fechaMesHoy.format (fechaHoy);
	private String anioHoy = fechaAnioHoy.format (fechaHoy);
	
	Calendario()
	{
		super("Calendario");
		setIconifiable(true);
		setClosable(true);			
		aplylisteners();		
		startup();
	}
	

	public void aplylisteners()
	{
		chAnio.addItemListener(this);
		chMes.addItemListener(this);
	}

	public void startup()
	{
		fixItems();
		panel1();		
		panel2();	
		panel3();
		
	}

	public void itemStateChanged(ItemEvent ie)
	{	
		panel3();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String msg=ae.getActionCommand();
		
			diaSeleccionado=Integer.parseInt(msg.trim());
			db();
		
	}

	public void fixItems()
	{
		for(int i=2000; i<=2030; i++)
			chAnio.add(" "+i); 
	
		for(int i=0; i<12; i++)
			chMes.add(meses[i]);
chAnio.select(Integer.valueOf(anioHoy));
		chMes.select(Integer.valueOf(mesHoy)-1);
	}

	public void panel1()
	{
		pan1.setBackground(Color.GRAY);
			pan1.setLayout(new GridLayout(0, 4, 0, 0));
			lblAnio.setForeground(new Color(255, 255, 255));
			pan1.add(lblAnio);
			pan1.add(chAnio);
			lblMes.setForeground(new Color(255, 255, 255));
			pan1.add(lblMes);
			pan1.add(chMes);
			
	}

	public void panel2()
	{
		pan2.setForeground(Color.BLACK);
		pan2.setBackground(Color.ORANGE);
		pan2.removeAll();
		pan2.setLayout(new GridLayout(1,7,5,5));
		for(int i=0; i<7;i++)
			pan2.add(new JLabel(dias[i])); 
	}
	public void panel3()
	{

		pan3.removeAll(); 
		DiaDeLaSemana=0;
		totalDiasDelMes=0;
		calculosNecesarios();
		for(int i=0; i<totalDiasDelMes; i++)
		{
			btnMatriz[i]=new JButton(" "+btn_tag);
			btn_tag++;
			btnMatriz[i].addActionListener(this);
			if (i == Integer.valueOf(diaHoy))
				{System.out.println("SIPI");
				btnMatriz[i-1].setForeground(Color.BLUE);
				btnMatriz[i-1].setIcon(new ImageIcon ("Imagenes/hoy.png"));
				
				//btnMatriz[i-1].
				}
			else if (i == 20 || i ==29)
			{
				btnMatriz[i-1].setForeground(Color.RED);
				btnMatriz[i-1].setIcon(new ImageIcon ("Imagenes/tarea.png"));
			}
		}
		
		
	sketch();
	display();
	}

	public void sketch()
	{
		
		pan3.setLayout(new GridLayout(0,7));
		for(int i=0; i<totalDiasDelMes; i++)
		{
  			for(int g=1;g<8;g++)
  			{
				if(filaUno)
				{
					if(g<DiaDeLaSemana)
						pan3.add(new JLabel(""));
					else if(g>=DiaDeLaSemana)
					{ 	filaUno=false;
						pan3.add(btnMatriz[i]);
					}
				}
				else
				pan3.add(btnMatriz[i]);
			}
		}
		
		btnMatriz[Integer.parseInt(diaHoy)].setFocusPainted(true);
	}

	public void display()
	{
		
		filaUno=true;	
		btn_tag=1;
		System.out.println(anioHoy + " " + mesHoy);
		getContentPane().add(pan1, BorderLayout.NORTH);
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 0, 0,8));
		getContentPane().add(pan2, BorderLayout.CENTER);
		getContentPane().add(pan3, BorderLayout.SOUTH);

		pack();
	}

	public void calculosNecesarios()
	{
		Anio= Integer.parseInt(chAnio.getSelectedItem().trim());
		MM =chMes.getSelectedIndex();
		anio=Integer.toString(Anio);
		mm = Integer.toString(++MM);
		dd = Integer.toString(diaSeleccionado);
		diaTemp = anio + "/" + mm + "/" + dd;
		id=1;
		java.util.Date Date = null;
		try 
		{
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		    Date = formatter.parse(diaTemp);
		} 
		catch (ParseException e)
		{	
			System.out.println(e.toString());
		    e.printStackTrace();
		}
		java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
		cal.setTime(Date);
		DiaDeLaSemana= cal.get(java.util.Calendar.DAY_OF_WEEK);
		totalDiasDelMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public void db()
	{
		
		
		String msg = "En lugar de este cartel deber�a estar la OT\n de la fecha: " + diaSeleccionado+ "/" + mm + "/" + anio +"\n hoy es:";
		JOptionPane.showMessageDialog (this, msg, "Mensajito", JOptionPane.PLAIN_MESSAGE);
		calculosNecesarios();
		setVisible(false);
		dispose();
	}

}