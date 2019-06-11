package shephardmp.screencapturer;

import shephardmp.screencapturer.ScreenCapturer;
/**
 * <p> Stand-alone application of ScreenCapturer. It captures a portion of the screen to the <a href="https://en.wikipedia.org/wiki/Clipboard_(computing)">Clipboard</a>.</p> 
 * @author Mauro Pucheta - "ShephardMP"
 * @version 1.0
 * @since 1.0
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	
    	ScreenCapturer.captureImageFromScreenToClipboard();
    	
    }
}

