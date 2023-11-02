package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class PanelDificultad extends JPanel {

	public LightsOutGameGUI juego;
	public JComboBox <String >opcionesTamanio;
	
	public JRadioButton facil;
	public JRadioButton intermedio;
	public JRadioButton dificil;
	public ButtonGroup grupoDificultades;
	public JLabel tamanio;
	public JLabel dificultad;
	
	public PanelDificultad(LightsOutGameGUI juego)
	{
		this.juego = juego;
		GridLayout layout = new GridLayout(0,6,10,0);
		this.setLayout(layout);
		this.tamanio = new JLabel("Tamaño tablero: ");
		tamanio.setAlignmentX(LEFT_ALIGNMENT);
		this.add(tamanio);
		
		
		String [] opciones_cuadricula = {"3x3","4x4","5x5","6x6","7x7","8x8"};
		this.opcionesTamanio = new JComboBox<String>(opciones_cuadricula);
		opcionesTamanio.setMaximumSize(getPreferredSize());
		opcionesTamanio.setAlignmentX(LEFT_ALIGNMENT);
		opcionesTamanio.addActionListener(juego);
		this.add(opcionesTamanio);
		
		this.dificultad = new JLabel("Dificultad: ");
		this.add(dificultad);
		
		this.facil = new JRadioButton("facil",true);
		this.intermedio = new JRadioButton("intermedio",false);
		this.dificil = new JRadioButton("dificil",false);
		this.grupoDificultades = new ButtonGroup();
		grupoDificultades.add(facil);
		grupoDificultades.add(intermedio);
		grupoDificultades.add(dificil);
		
		facil.addActionListener(juego);
		intermedio.addActionListener(juego);
		dificil.addActionListener(juego);
		this.add(facil);
		this.add(intermedio);
		this.add(dificil);
		
	}
}
