package shephardmp.screencapturer;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * 
 * Clase Imagen. 
 * Permite importar una imagen desde un archivo externo, desde una captura manual o a partir de una porción de pantalla
 * (en forma de Rectangle).
 * Tiene metodos que permiten transformar la imagen a una representacion de arreglo o matriz para mejor manejo.
 * Tiene metodos adicionales para acceder a los pixeles y colores de la imagen.
 * Finalmente permite exportar una imagen a un archivo externo (requiere que se ponga la extensíon).
 * 
 */

public class Imagen {

	
	private BufferedImage img;
	private int alto;
	private int ancho;
	
	public Imagen(String nombreArchivo){
		try{
			img = ImageIO.read(new File(nombreArchivo));
		}catch (IOException e){
			System.out.println("No se pudo cargar la imagen '" + nombreArchivo + "'");
			e.printStackTrace();
		}
		
		alto = img.getHeight();
		ancho = img.getWidth();
	}
	
	public Imagen(Rectangle captura) { //la captura puede ser de una parte de la pantalla o de toda
		Robot robot=null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println("No se pudo inicializar el bot para la creacion de la imagen");
			e.printStackTrace();
		} //permite el uso sencillo de teclado y mouse. Ademas permite crear una imagen a partir de los pixeles dentro de un rectangulo de la pantalla
		this.img= robot.createScreenCapture(captura);
		
		alto = img.getHeight();
		ancho = img.getWidth();
	}
	
	public Imagen() { //la captura puede ser de una parte de la pantalla o de toda

		this(new CapturadorPantalla().capturarScreen());
		
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public int getPixel(int x, int y){
		return img.getRGB(x, y);
	}
	
	public int getRed(int x, int y){
		return (this.getPixel(x, y) >> 16) & 0x000000FF;
	}
	
	public int getGreen(int x, int y){
		return (this.getPixel(x, y) >> 8) & 0x000000FF;
	}
	
	public int getBlue(int x, int y){
		return (this.getPixel(x, y)) & 0x000000FF;
	}
	
	public int[] getArregloPixeles(){ //va recorriendo la imagen por columnas
		int[] arreglo = new int[this.getAlto() * this.getAncho()];
		int alto = this.getAlto();
		int ancho = this.getAncho();
		for (int x = 0; x < ancho; x++)
			for (int y = 0; y < alto; y++){
				arreglo[x * alto + y] = this.getPixel(x, y);
			}
		return arreglo;
	}
	
	public int[][] getMatrizPixeles(){
		int[][] matriz = new int[this.getAlto()][this.getAncho()];
		for (int x = 0; x < this.getAlto(); x++)
			for (int y = 0; y < this.getAncho(); y++){
				matriz[x][y] = getPixel(x, y);
			}
		return matriz;
	}
	
	public Imagen(int[] arrPixeles, int alto, int ancho, int tipo) { //ej tipo: BufferedImage.TYPE_INT_RGB
		/*
		byte MAX = (byte) 255;
		byte[] red = new byte[] {MAX, 127, 0};
		byte[] green = new byte[] {MAX, 127, 0};
		byte[] blue= new byte[] {MAX, 127, 0};
		byte[] alpha= new byte[] {MAX, 127, 0};

		IndexColorModel indexColorModel = new IndexColorModel(4, 2, red, green, blue,alpha);
		 */
		this.alto = alto;
		this.ancho = ancho;
		img= new BufferedImage(ancho, alto, tipo);
		for (int x = 0; x < ancho; x++)
			for (int y = 0; y < alto; y++){
				img.setRGB(x, y, arrPixeles[x * alto + y] );
			}
		
		
	}
	
	public BufferedImage getBufferedImage() {
		return this.img;
		
	}
	
	public void guardarImagen(String nombre) {
		try {
			ImageIO.write(img, "bmp", new File(nombre));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
