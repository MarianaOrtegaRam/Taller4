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

		public String nombre; //guarda el nombre del jugador
		public JButton boton; 
		public JTextField texto; //para que coloque su nombre
		public JLabel pide_nombre;
		public JPanel panel; 
		
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
			
			setSize(400, 200);
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
				new LightsOutGameGUI(nombre);
				this.dispose();
			}

		}
		
		public static void main(String[] args) {
			FlatLightLaf.install();
			new PanelIngresarNombre();
			
		}
		
}
