package org.rs;

import javax.swing.UIManager;
import org.rs.ui.GUI;

public final class Boot {
	
	public static void main(String[] args) {
		Constants.startTime = System.currentTimeMillis();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new GUI();
	}

}
