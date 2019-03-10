package shephardmp.screencapturer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import shephardmp.screencapturer.utils.Fondo;
import shephardmp.screencapturer.utils.MouseHandler;

public class CapturadorPantalla implements ICapturadorPantalla {

	public CapturadorPantalla() {
		
		
	}
	
	
	public Rectangle capturarScreen() {
		
		Rectangle pantallaCapturada=new Rectangle();
		Fondo espacioCaptura= new Fondo();
		boolean[] finCaptura= {false}; //se va a simular un wrapper MUTABLE de esta manera
	
		espacioCaptura.addMouseListener(new MouseHandler(pantallaCapturada,finCaptura));
		while(!finCaptura[0]) {
			
			System.out.println(pantallaCapturada.toString() );
			
		}
		
		System.out.println(pantallaCapturada.toString());
		espacioCaptura.destruir();
		return pantallaCapturada;
		
	}
}


