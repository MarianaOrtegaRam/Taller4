package uniandes.dpoo.taller4.interfaz;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelBotonesDerecha extends JPanel {
	
	public LightsOutGameGUI juego;
	public JButton nuevoJuego;
	public JButton reiniciarJuego;
	public JButton verTop10;
	public JButton cambiarJugador;
	
	public PanelBotonesDerecha (LightsOutGameGUI juego) {
		
		this.juego = juego;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createTitledBorder("Menu Principal");
		this.setBorder(border);
		
		this.nuevoJuego = new JButton("Nuevo Juego");
		nuevoJuego.addActionListener(juego);
		this.reiniciarJuego = new JButton("Reinciar Juego");
		reiniciarJuego.addActionListener(juego);
		this.verTop10 = new JButton("Ver Top 10");
		verTop10.addActionListener(juego);
		this.cambiarJugador = new JButton("Cambio de Jugador");
		cambiarJugador.addActionListener(juego);
		
		this.add(nuevoJuego);
		this.add(reiniciarJuego);
		this.add(verTop10);
		this.add(cambiarJugador);
		
		
	}
	
	
	

}
