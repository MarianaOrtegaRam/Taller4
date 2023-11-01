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
    private int tamanoTablero;
    
   
    public LightsOutGameGUI() {
    	
    	
        tablero = new Tablero(tamanoTablero);
        top10 = new Top10();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Lights Out Game");

        // Crear un panel para el tablero
        JPanel tableroPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarTablero(g);
            }
        };

        tableroPanel.setPreferredSize(new Dimension(400, 400));



    private void pedirTamanoTablero() {
        String tamanoStr = JOptionPane.showInputDialog(this, "Introduce el tamaño del tablero:");
        try {
            int nuevoTamano = Integer.parseInt(tamanoStr);
            if (nuevoTamano > 0) {
                tamanoTablero = nuevoTamano;

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
                pedirTamanoTablero(); // Pide el tamaño nuevamente en caso de valor no válido
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            pedirTamanoTablero(); // Pide el tamaño nuevamente en caso de valor no numérico
        }
    }
    private void actualizarTop10TextArea(JTextArea top10TextArea) {
        StringBuilder top10Text = new StringBuilder("Top 10:\n");
        int i = 1;
        for (RegistroTop10 registro : top10.darRegistros()) {
            top10Text.append(i).append(". ").append(registro.toString()).append("\n");
            i++;
        }
        top10TextArea.setText(top10Text.toString());
    }

    public static void main(String[] args) {
        
        	
            LightsOutGameGUI gameGUI = new LightsOutGameGUI();
            gameGUI.pedirTamanoTablero();
            gameGUI.setVisible(true);
 
    }
}
