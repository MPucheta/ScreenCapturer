package shephardmp.screencapturer;

import java.awt.Rectangle;

public class CapturadorPantallaCompleta implements ICapturadorPantalla {

	
	public Rectangle capturarScreen() {
		
		
		AreaPantalla fullScreen= new AreaPantalla();
		return fullScreen.getArea();
	}

}
