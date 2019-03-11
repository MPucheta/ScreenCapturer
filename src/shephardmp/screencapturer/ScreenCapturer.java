package shephardmp.screencapturer;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;

import shephardmp.screencapturer.utils.ImageTransferable;

/*Clase ScreenCapturer que puede ser usada como una aplicacion por si misma 
 * o como modulo en otros programas. Esta clase debe proveer una interfaz unica de servicios
 * que permitan obtener partes de la pantalla ya sea por captura manual o por captura automatica al proveer
 * la misma porcion de pantalla
 */

public class ScreenCapturer {
	
	
	public static Rectangle captureScreen() {
		
		ICapturadorPantalla capturador= new CapturadorPantalla();
		return capturador.capturarScreen();
	} 
	
	public static Rectangle getFullScreen() {
			
			ICapturadorPantalla capturador= new CapturadorPantallaCompleta();
			return capturador.capturarScreen();
		} 
	
	
	
	public static BufferedImage getBufferedImageFromRectangle(Rectangle areaPantalla) {
			
			Imagen img= new Imagen(areaPantalla);
			return img.getBufferedImage();
	}
	
	public static BufferedImage captureBufferedImageFromScreen() {
		
		Imagen img= new Imagen(captureScreen());
		return img.getBufferedImage();
	}
	
	public static BufferedImage getBufferedImageFromFullScreen() {
		
		Imagen img= new Imagen(getFullScreen());
		return img.getBufferedImage();
	}

	public static void captureClipboardImageFromScreen() {
		
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(new ImageTransferable(captureBufferedImageFromScreen()), null);
		
	}
	
	public static void getClipboardImageFromFullScreen() {
		
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(new ImageTransferable(getBufferedImageFromFullScreen()), null);
		
	}
	
	
	public static void main(String [] args) {
		captureClipboardImageFromScreen();
		
		/*
		 
		AreaPantalla a= new AreaPantalla();
		int[] pixeles= new int[1920*1080];
		Iterator<Integer> it= a.getIterador();
		int i=0;
		while(it.hasNext()) {
		
			pixeles[i++]=it.next().intValue();
			
		}
		
		Imagen test2= new Imagen(pixeles,1080,1920,BufferedImage.TYPE_INT_RGB);
		test2.guardarImagen("test2.jpg");
		
		*/
		
	}
}
