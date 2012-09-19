package org.rs.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CenterGUI {

	public static void center(JFrame f, int width, int height) {
		Dimension fscreen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (fscreen.width - width) / 2;
		int y = (fscreen.height - height) / 2;
		f.setBounds(x, y, width, height);
	}

}
