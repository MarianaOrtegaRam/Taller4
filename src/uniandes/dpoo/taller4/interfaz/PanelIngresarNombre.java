package uniandes.dpoo.taller4.interfaz;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatLightLaf;

@SuppressWarnings("serial")
public class PanelIngresarNombre extends JFrame implements ActionListener{

		private String nombre; //guarda el nombre del jugador
		private JButton boton; 
		private JTextField texto; //para que coloque su nombre
		private JLabel pide_nombre;
		private JPanel panel; 
		
		public PanelIngresarNombre() {
			//Define el titulo de la Ventanita
			setTitle("Ingreso a LightsOutGame");
			//Le asigno un texto a mi Jlabel
			this.pide_nombre = new JLabel("Ingrese su nombre con sus 3 iniciales: ");
			//Creo el boton para que intente ir a la ventana del juego
			this.boton = new JButton("empecemos");
			boton.addActionListener(this);
			this.texto = new JTextField(16);
			texto.addActionListener(this);
			panel = new JPanel();
			
			panel.add(pide_nombre);
			panel.add(texto);
			panel.add(boton);
			
			add(panel);
			
			setSize(400, 400);
			setLocationRelativeTo(null);
			setResizable(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == boton)
			{
				this.nombre = texto.getText();
				//new LightsOutGameGUI(nombre);
				this.dispose();
			}

		}
		
		public static void main(String[] args) {
			FlatLightLaf.install();
			new PanelIngresarNombre();
			
		}
		
}