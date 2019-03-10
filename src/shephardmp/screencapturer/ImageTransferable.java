package shephardmp.screencapturer;

import java.awt.Toolkit;

//Codigo de imagen transferable https://stackoverflow.com/questions/29511334/why-cant-i-cast-a-buffered-image-into-a-transferrable-object-to-send-it-to-the
//El modo de uso de esto es 

/*
 * Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
 * clipBoard.setContents(new ImageTransferable(imagenCapturada.getBufferedImage()), null); //o cualquier bufferedImage
 * 
 */

import java.awt.datatransfer.*;
import java.awt.image.*;
import java.io.IOException;




public final class ImageTransferable implements Transferable {
    final BufferedImage image;

    public ImageTransferable(final BufferedImage image) {
        this.image = image;
    }

    
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {DataFlavor.imageFlavor};
    }

    
    public boolean isDataFlavorSupported(final DataFlavor flavor) {
        return DataFlavor.imageFlavor.equals(flavor);
    }

   
    public Object getTransferData(final DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return image;
        }

        throw new UnsupportedFlavorException(flavor);
    }
};