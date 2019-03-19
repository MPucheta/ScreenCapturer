package shephardmp.screencapturer.utils;

import java.awt.datatransfer.*;
import java.awt.image.*;
import java.io.IOException;


/**
 * @see <a href="https://stackoverflow.com/questions/29511334/why-cant-i-cast-a-buffered-image-into-a-transferrable-object-to-send-it-to-the">Stack Overflow Original Code</a>
 * 
 * 
 * @author      Unknown
 * @version     1.0                
 * @since       1.0   
 * 
 * <p>
 * Basic usage:
 * Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard(); </p>
 * <p>
 * clipBoard.setContents(new ImageTransferable(BufferedImage), null);
 * </p>
 */



public final class ImageTransferable implements Transferable {
	/**
	 * base image which is desired to convert to a Transferable object
	 */
    private final BufferedImage image;

    /**
	 * {@inheritDoc}
	 */
    public ImageTransferable(final BufferedImage image) {
        this.image = image;
    } 

    /**
     * {@inheritDoc}
	 */
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {DataFlavor.imageFlavor};
    }

    /**
	 * {@inheritDoc}
	 */
    public boolean isDataFlavorSupported(final DataFlavor flavor) {
        return DataFlavor.imageFlavor.equals(flavor);
    }

    /**
     * {@inheritDoc}
     */
    public Object getTransferData(final DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return image;
        }

        throw new UnsupportedFlavorException(flavor);
    }
};