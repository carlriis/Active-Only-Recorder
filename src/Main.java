
public class Main {
	public static void main(String[] args) {
		Checker checker = new Checker();
		Checker.startListening(checker);
		
		Recorder.deleteTmp();
		Recorder.TakeScreenshot();
		
		while (true) {
			System.out.println(checker.getLastActive());
		}
	}
	
	
}
