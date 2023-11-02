package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class PanelInformacionJuego extends JPanel {
	
	private LightsOutGameGUI juego;
	private JLabel nombre;
	private JLabel jugadorLabel;
	private JLabel jugadasRealizadas;
	private JLabel jugadasLabel;
	
	public PanelInformacionJuego(LightsOutGameGUI juego) {
	
		this.juego = juego;
		GridLayout layout = new GridLayout(0,4,10,0);
		this.setLayout(layout);
		
		Border borderPrincipal = BorderFactory.createTitledBorder("Jugada Actual:");
		this.setBorder(borderPrincipal);
		
		this.jugadorLabel = new JLabel("Jugador: ");
		add(jugadorLabel);
		this.nombre = new JLabel("Null");
		add(nombre);
		
		this.jugadasRealizadas = new JLabel("Jugadas: ");
		add(jugadasRealizadas);
		this.jugadasLabel = new JLabel("0");
		add(jugadasLabel);
		
	}	
}
