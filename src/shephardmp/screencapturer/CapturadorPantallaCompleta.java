package shephardmp.screencapturer;

import java.awt.Rectangle;

import shephardmp.screencapturer.utils.AreaPantalla;

public class CapturadorPantallaCompleta implements ICapturadorPantalla {

	
	public Rectangle capturarScreen() {
		
		
		AreaPantalla fullScreen= new AreaPantalla();
		return fullScreen.getArea();
	}

}
