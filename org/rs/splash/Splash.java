package org.rs.splash;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import org.rs.ui.TextLogger;

public class Splash extends Applet {
	private static final long serialVersionUID = 7412412644921803896L;
	private static Splash current = null;
	private static String state = "Loader starting...";
	private FontMetrics fontMetrics = null;
	

	@Override
	public void init() {
		setSize(800, 600);
		setBackground(Color.black);
	}

	@Override
	public void paint(Graphics g) {
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		if(fontMetrics == null) {
			fontMetrics = g.getFontMetrics();
		}
		g.setColor(Color.white);
		int x = (getWidth() / 2) - (fontMetrics.stringWidth(state) / 2);
		g.drawString(state, x, 50);
	}
	
	public static Splash get() {
		final Splash splash = new Splash();
		splash.init();
		current = splash;
		return splash;
	}
	
	public static void log(final String message) {
		state = message;
		current.repaint();
		TextLogger.log(message);
	}

}
