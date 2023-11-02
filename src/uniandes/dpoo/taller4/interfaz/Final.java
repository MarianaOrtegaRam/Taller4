package uniandes.dpoo.taller4.interfaz;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class Final extends JFrame implements ActionListener
{
	private LightsOutGameGUI juego;
	public JButton empezar;
	public JButton salir;
	public JLabel texto1;
	public JLabel texto2;
	public JLabel texto3;
	public JPanel panel;
	
	
	
	
	public Final(int jugadas, int puntaje, LightsOutGameGUI juego)
	{
		this.juego = juego;
		this.setTitle("Has ganado!");
		GridLayout layout = new GridLayout(5,1);
		setLayout(layout);
		
		
		this.texto1 = new JLabel("Fin del juego!");
		this.texto2 = new JLabel("Ha terminado el juego en: " + jugadas + " jugadas.");
		this.texto3 = new JLabel("Su puntaje ha sido: " + puntaje + " puntos.");
		
		this.empezar = new JButton("Volver a empezar");
		empezar.setMinimumSize(new Dimension(100, 20));
		empezar.addActionListener(this);
		this.salir = new JButton("Salir");
		salir.setMinimumSize(new Dimension(100, 20));
		salir.addActionListener(this);
		
		this.panel = new JPanel();
		panel.setLayout( new FlowLayout());
		
		panel.add(empezar);
		panel.add(salir);
		add(texto1);
		add(texto2);
		add(texto3);
		add(panel);
		
		setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == empezar)
		{
			new PanelIngresarNombre();
			this.dispose();
			try
			{
				this.juego.salvarTop10();
			} catch (FileNotFoundException | UnsupportedEncodingException e1)
			{
				e1.printStackTrace();
			}
			this.juego.dispose();
		}
		else if(e.getSource()==salir)
		{
			try
			{
				this.juego.salvarTop10();
			} catch (FileNotFoundException | UnsupportedEncodingException e1)
			{
				e1.printStackTrace();
			}
			System.exit(0);
			this.dispose();
		}
		
	}

}

