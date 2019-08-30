import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		
		VideoEncoder.encodeVideo();
		
		Checker checker = new Checker();
		Checker.startListening(checker);
		
		Recorder.deleteTmp();
		Recorder.TakeScreenshot();
		
		while (true) {
			System.out.println(checker.getLastActive());
			Recorder.TakeScreenshot();
			
			try {
				TimeUnit.SECONDS.sleep((long) 0.5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
