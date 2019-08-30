import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Recorder {
	public static int count = 1;
	
	public static void TakeScreenshot() {
		BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			try {
				new File("tmp").mkdir();
				ImageIO.write(image, "png", new File(String.format("tmp/screenshot%06d.png", count)));
				count ++;
				
			} catch (IOException e) {}
		} catch (HeadlessException | AWTException e) {}
	}
	
	public static void deleteTmp() {
		File[] contents = new File("tmp").listFiles();
	    if (contents != null) {
	        for (File f : contents) {
	            f.delete();
	        }
	    }
	}
}
