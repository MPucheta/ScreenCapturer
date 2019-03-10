package shephardmp.screencapturer;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;

public class ScreenCapturer {
	
	
	public static Rectangle getScreen() {
		
		ICapturadorPantalla capturador= new CapturadorPantalla();
		return capturador.capturarScreen();
	} 
	
	public static Rectangle getFullScreen() {
			
			ICapturadorPantalla capturador= new CapturadorPantallaCompleta();
			return capturador.capturarScreen();
		} 
	
	
	public static BufferedImage getBufferedImage() {
		
		Imagen img= new Imagen(getScreen());
		return img.getBufferedImage();
	}

	public static void getClipboardImage() {
		
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(new ImageTransferable(getBufferedImage()), null);
		
	}
	
	
	public static void main(String [] args) {
		getClipboardImage();
	}
}
