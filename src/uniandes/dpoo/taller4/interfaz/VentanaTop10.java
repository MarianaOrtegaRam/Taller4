package uniandes.dpoo.taller4.interfaz;
import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaTop10 extends JFrame {

	private Top10 top10 = null;
	private boolean visibilidad = false;
	private JPanel panel;
	private JPanel headerPanel;
	private JLabel header;
	private String str10Resgitros;
	private String[] lista10Registros;
	private JList<String> listaJlist;
	
	
	
	public VentanaTop10(Top10 queu) {
		setTitle("Top 10 Jugadores");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(300, 500);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				changeVisibility(); 
			}
		});
		
		
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(1, 1));
		
		this.header = new JLabel();
		header.setVisible(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(header);
		panel.add(headerPanel);
		
		
		this.str10Resgitros = "";
		int contador = 1;
		for (RegistroTop10 i : top10.darRegistros())
		{
			str10Resgitros += contador + "  " + i.darNombre() + " " + i.darPuntos() + ",";
			contador++;
		}
		
		this.lista10Registros = str10Resgitros.split(",");
		this.listaJlist = new JList<String> (lista10Registros);
		listaJlist.setVisibleRowCount(10);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) listaJlist.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		listaJlist.setFixedCellHeight(50);
		JScrollPane scrollPane = new JScrollPane(listaJlist);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		panel.add(scrollPane);

		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(visibilidad); 
		this.revalidate();
		
	}
	
	public void changeVisibility()
	{
		this.visibilidad = !visibilidad;
		this.setVisible(visibilidad);
	}
}
