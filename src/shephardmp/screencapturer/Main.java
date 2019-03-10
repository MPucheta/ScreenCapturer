package shephardmp.screencapturer;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import shephardmp.screencapturer.utils.ImageTransferable;

public class Main {

	
	public static void main(String[] arg) {
		
		ICapturadorPantalla capturador= new CapturadorPantalla();
		
		Rectangle captura=capturador.capturarScreen();
		
		Imagen imagenCapturada= new Imagen(captura);
		imagenCapturada.guardarImagen("Captura.jpg");
		
		//lo siguiente es para mandar la imagen al clipboard, es una funcionalidad del main de screenCapturer. No como modulo
		
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(new ImageTransferable(imagenCapturada.getBufferedImage()), null);
		
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
		
		System.out.println("fin ejecucion");
	}
	
}
