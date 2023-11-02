package uniandes.dpoo.taller4.interfaz;
import uniandes.dpoo.taller4.modelo.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class LightsOutGameGUI extends JFrame implements ActionListener {

    private Tablero tablero;
    private Top10 top10;
    
    private PanelBotonesDerecha panelBotonesDerecha;
    private PanelDificultad panelDificultad;
    private PanelInformacionJuego panelInformacionJuego;
    private PanelIngresarNombre panelIngresarNombre;
    private TableroJava2D tableroJava;
    private VentanaTop10 ventanaTop10;
    
    
    private JButton nuevoJuego;
	private JButton reiniciarJuego;
	private JButton verTop10;
	private JButton cambiarJugador;

	public JRadioButton facil;
	public JRadioButton intermedio;
	public JRadioButton dificil;

	public JComboBox<String> opcionesTamanio;
	public Integer size = 4;
	public Integer dificultad = 3;
	public JLabel jugadasRealizadas;
   
    public LightsOutGameGUI(String nombre) {
    	tablero = new Tablero(size);
    	setLayout(new BorderLayout());
		pack();
		setTitle("¡Juego LightsOut!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);

		setSize(800, 800);
    
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try
				{
					salvarTop10();
				} catch (FileNotFoundException e1)
				{
					System.err.println("\nNo se encontr� el archvio.\n");
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1)
				{
					System.err.println("\nUnsupportedEncoding!\n");
					e1.printStackTrace();
				}
			}
		});
		
		this.top10 = new Top10();
		this.cargarTop10();
		this.ventanaTop10 = new VentanaTop10(top10);
		this.panelDificultad = new PanelDificultad(this);
		add(panelDificultad,BorderLayout.NORTH);
		
		this.panelInformacionJuego = new PanelInformacionJuego(this);
		panelInformacionJuego.nombre.setText(nombre);
		add(panelInformacionJuego,BorderLayout.SOUTH);
		
		this.panelBotonesDerecha = new PanelBotonesDerecha(this);
		add(panelBotonesDerecha,BorderLayout.EAST);
		
		this.tableroJava = new TableroJava2D(this);
		add(tableroJava,BorderLayout.CENTER);
		int PanelX = (getWidth() - tableroJava.getWidth() - getInsets().left - getInsets().right) / 2;
		int PanelY = (getHeight() - tableroJava.getHeight() - getInsets().top - getInsets().bottom) / 2;
		
		tableroJava.setLocation(PanelX, PanelY);

		setLocationRelativeTo(null);
		setVisible(true);

		nuevoJuego();
	
    }
    
    public void nuevoJuego()
	{

    	panelInformacionJuego.jugadasRealizadas.setText("0");
		this.tablero = new Tablero(size);
		tablero.desordenar(dificultad);
		tableroJava.nuevoPanel(tablero);

	}


	public void cargarTop10()
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		top10.cargarRecords(archivoFile);
	}

	@SuppressWarnings("static-access")
	public void salvarTop10() throws FileNotFoundException, UnsupportedEncodingException
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		this.top10.salvarRecords(archivoFile);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		// Botones panel de la derecha

		this.nuevoJuego = panelBotonesDerecha.nuevoJuego;
		this.reiniciarJuego = panelBotonesDerecha.reiniciarJuego;
		this.verTop10 = panelBotonesDerecha.verTop10;
		this.cambiarJugador = panelBotonesDerecha.cambiarJugador;

		// Botones panel de arriba

		facil = panelDificultad.facil;
		intermedio = panelDificultad.intermedio;
		dificil = panelDificultad.dificil;

		this.opcionesTamanio = panelDificultad.opcionesTamanio;

		// Panel de la derecha

		if (e.getSource() == nuevoJuego)
		{
			nuevoJuego();
		}

		else if (e.getSource() == reiniciarJuego)
		{
			tablero.reiniciar();
			tableroJava.nuevoPanel(tablero);
			panelInformacionJuego.jugadasRealizadas.setText("0");
		}

		else if (e.getSource() == verTop10)
		{
			ventanaTop10.changeVisibility();
		}

		else if (e.getSource() == cambiarJugador)
		{
			new PanelIngresarNombre();
		}

		// Panel de arriba

		else if (e.getSource() == facil)
		{
			dificultad = 3;
			nuevoJuego();
		}

		else if (e.getSource() == intermedio)
		{
			dificultad = 5;
			nuevoJuego();
		}

		else if (e.getSource() == dificil)
		{
			dificultad = 7;
			nuevoJuego();
		}

		else if (e.getSource() == opcionesTamanio)
		{
			String selectedSize = (String) opcionesTamanio.getSelectedItem();
			if (selectedSize.equals("3x3"))
			{
				size = 3;
				nuevoJuego();
			}
			else if (selectedSize.equals("4x4"))
			{
				size = 4;
				nuevoJuego();
			}

			else if (selectedSize.equals("5x5"))
			{
				size = 5;
				nuevoJuego();
			}

			else if (selectedSize.equals("6x6"))
			{
				size = 6;
				nuevoJuego();
			}

			else if (selectedSize.equals("7x7"))
			{
				size = 7;
				nuevoJuego();
			}

			else if (selectedSize.equals("8x8"))
			{
				size = 8;
				nuevoJuego();
			}

		}

	}

	public void Jugar(int i, int j)
	{
		tablero.jugar(i, j);
		Integer cantidad = tableroJava.cantidadJugadas;
		panelInformacionJuego.jugadasRealizadas.setText(cantidad.toString());

		int puntaje = tablero.calcularPuntaje();
		int jugadas = Integer.parseInt(panelInformacionJuego.jugadasRealizadas.getText());

		if (tablero.tableroIluminado() == true)
		{
			if (top10.esTop10(puntaje))
			{
				top10.agregarRegistro(panelInformacionJuego.nombre.getText(), puntaje);
			}
			new Final(jugadas, puntaje, this);
		}

	}

}


    	
    	
        