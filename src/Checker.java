import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;


public class Checker implements NativeKeyListener,  NativeMouseInputListener{
	
	public long activeTime = System.currentTimeMillis();
	
	
	public float getLastActive() {
		return (System.currentTimeMillis() - activeTime) / 1000F;
	}
	
	public static void startListening(Checker checker) {
		try {
			
			LogManager.getLogManager().reset();
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.OFF);
			
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");

			System.exit(1);
		}

		
		GlobalScreen.addNativeKeyListener(checker);
		GlobalScreen.addNativeMouseListener(checker);
		GlobalScreen.addNativeMouseMotionListener(checker);
		
	}
	
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		activeTime = System.currentTimeMillis();
	}
	
	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
		activeTime = System.currentTimeMillis();
		
	}
	
	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		activeTime = System.currentTimeMillis();
		
	}
	
	// Empty

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {}
	
	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {}
}
