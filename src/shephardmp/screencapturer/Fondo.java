package shephardmp.screencapturer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fondo extends JFrame {

	
	private static final long serialVersionUID = 1L;


	public Fondo() {
		
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		JLabel leyenda = new JLabel("Seleccionar pantalla/Select Screen");
		leyenda.setFont(new Font("arial", Font.BOLD,40));
		JPanel fondo = new JPanel(); //el frame es un espacio para meter cosas, en si el fondo es el JPanel. 
	
		fondo.setOpaque(false);
		
		fondo.setPreferredSize(screenSize);
		fondo.add(leyenda);
		this.add(fondo);
		
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setUndecorated(true); //sin esto no ocupa todo, queda como window, no como full screen	
	    this.setBackground(new Color(180, 160, 230,100)); //color en RGBA.
	   
	    this.pack();
	    this.setVisible(true);
		
		
	}
	
	
	public void destruir() {
		this.dispose();
		
	}
	
	
}
