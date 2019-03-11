package shephardmp.screencapturer;

import java.awt.Rectangle;

/*
 * Interfaz para capturadores de pantalla. No es del todo necesario de momento ya que hay solo dos capturadores
 * pero es una buena práctica.
 * 
 */

public interface ICapturadorPantalla {
	
	public Rectangle capturarScreen();

}
