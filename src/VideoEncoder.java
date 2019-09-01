import java.io.IOException;


public class VideoEncoder {
	public static String pathToFfmpegExecutable = "ffmpeg";
	public static int framerate = 30;
	public static String filename = "time_lapse";
	
	public static void encodeVideo() {
		
		try {
			String command = String.format("\"%s\" -c:v libx264 -pix_fmt yuv420p %s.mp4 -framerate %s -i \"tmp/screenshot%%05d.png\" -y", pathToFfmpegExecutable, filename, framerate);

			Process pr = Runtime.getRuntime().exec(command);
			
			java.io.InputStream in = pr.getErrorStream();
			int c;
			while ((c = in.read()) != -1) {
			    System.out.print((char)c);
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
