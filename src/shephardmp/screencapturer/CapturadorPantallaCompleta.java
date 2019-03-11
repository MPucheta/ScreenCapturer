package shephardmp.screencapturer;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;



/*
 * Clase que provee la funcionalidad de entregar toda la pantalla como captura
 * 
 */

public class CapturadorPantallaCompleta implements ICapturadorPantalla {

	
	public Rectangle capturarScreen() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Rectangle(0, 0, screenSize.width, screenSize.height);
	}

}
