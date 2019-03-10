package shephardmp.screencapturer;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.Iterator;

public class AreaPantalla {

	Rectangle area;
	private class ItPantalla implements Iterator<Integer>{
		
		int[] pixeles= null;
		int i;
		public ItPantalla() {
			Imagen pantalla= new Imagen(area);
			i=0;
			this.pixeles=pantalla.getArregloPixeles();
			System.out.println(pantalla.getAlto());
			System.out.println(pantalla.getAncho());
			
		}
		public boolean hasNext() {
			return i<(area.height*area.width);
			
		}

		
		public Integer next() {
			
			int pixel=this.pixeles[i++];
			return new Integer(pixel);
		}
		
		
		
	}
	
	public AreaPantalla() {
		//este constructor establece un area que ocupe toda la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.area= new Rectangle(0, 0, screenSize.width, screenSize.height);
		
	}
	
	public AreaPantalla(Rectangle r) {
		
		this.area=r;
		
	}
	
	public Rectangle getArea() {
		
		return area;
	}
	
	
	public int getPixel( int x, int y) {
		//saca el pixel en cuestion siguiendo las coordenadas
		Robot r=null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			System.out.println("error en la creacion de bot al capturar la pantalla");
			e.printStackTrace();
		}
		
		Color pixel= r.getPixelColor(x, y);
		return pixel.getRGB();
		
		
	}
	
	public Iterator<Integer> getIterador() {
		
		return new ItPantalla();
	}
	
	public int posInicialX() {return (int) area.getX();}
	public int posInicialY() {return (int) area.getY();}
	public int getAncho() {return (int)area.getWidth();}
	public int getAlto() {return(int) area.getHeight();}

}
