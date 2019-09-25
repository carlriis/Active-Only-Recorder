import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static int activeLimit = 5;
	public static boolean activeOn = true;
	public static boolean keepTmp = false;
	public static boolean record = true;
	
	public static void main(String[] args) {
		argumentParser(args);
		Menu.menu();
	
	}
	
	public static void argumentParser(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-a")) {	
				activeLimit = Integer.parseInt(args[i + 1]);
			} else if (args[i].equals("-f")) {
				VideoEncoder.framerate = Integer.parseInt(args[i + 1]);
			} else if (args[i].equals("-n")) {
				VideoEncoder.filename = args[i + 1];
			} else if (args[i].equals("-ffmpeg")) {
				VideoEncoder.pathToFfmpegExecutable = args[i + 1];
			} else if (args[i].equals("-off")) {
				activeOn = false;
			} else if (args[i].equals("-keeptmp")) {
				keepTmp = true;
			} else if (args[i].equals("-recordoff")) {
				record = false;
			}
		}
		
	}
	
	
	public static void record() {
		
		Checker checker = new Checker();
		Checker.startListening(checker);
		
		Recorder.mkdir();
		Recorder.deleteTmp();
		
		while (true) {
			if (checker.getLastActive() <= activeLimit || !activeOn) {
				
				Recorder.TakeScreenshot();
				
				try {
					TimeUnit.SECONDS.sleep((long) 1);
				} catch (InterruptedException e) {}
			}
		}
	}
}

class Menu {
	
	public static void menu() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		if (Main.record) {
			System.out.println("Active Only Recorder\n");
			System.out.println("Press enter");
			System.out.print("Start recording:");
			scanner.nextLine();
			
			new Thread(new Runnable() {
				public void run() {
					Main.record(); 
				}
			}).start();
			
			System.out.println("\nRecording...");
			System.out.print("\nStop recording:");
			scanner.nextLine();
		}
		System.out.println("Recording stopped");
		System.out.println("Exporting video");
		VideoEncoder.encodeVideo();
		
		if (!Main.keepTmp) {
			Recorder.deleteTmp();
		}
		
		System.out.println("\ntime lapse finished");
		System.exit(0);
	}
}

