package org.rs.ui;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import org.rs.Constants;
import org.rs.loader.Parameters;
import org.rs.loader.Stub;
import org.rs.log.TextAreaLogHandler;
import org.rs.splash.Splash;
import org.rs.util.CenterGUI;

public class GUI extends JFrame {
	private static final long serialVersionUID = 5513937520865895901L;
	private static GUI instance = null;
	private static JPanel gamePanel = new JPanel(new BorderLayout());
	

	final ActionListener exitListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	};

	public GUI() {
		instance = this;
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		TextLogger.jTextArea1.setPreferredSize(new Dimension(756, 80));
		final JScrollPane textScroll = new JScrollPane(
				TextAreaLogHandler.TEXT_AREA, 22, 31);
		textScroll.setBorder(null);
		textScroll.setPreferredSize(new Dimension(800, 100));
		textScroll.setVisible(true);
		TextLogger.registerLogging();
		final JMenuBar bar = new JMenuBar();
		final JMenu file = new JMenu("File");
		final JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(exitListener);
		gamePanel.setPreferredSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		file.add(exit);
		bar.add(file);
		setJMenuBar(bar);
		CenterGUI.center(this, 800, 700);
		setTitle("Runescape loader - by Parnassian");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.add(Splash.get());
		getContentPane().add(gamePanel, BorderLayout.CENTER);
		getContentPane().add(textScroll, BorderLayout.SOUTH);
		loadRunescape.start();
	}

	private static final Thread loadRunescape = new Thread(new Runnable() {

		@Override
		public void run() {
			try {
				Splash.log("Parsing parameters...");
				Parameters.get();
				Splash.log("Loading runescape applet...");
				@SuppressWarnings("resource")
				final Applet loader = (Applet) new URLClassLoader(
						new URL[] { new URL(Constants.BASE_LINK
								+ Parameters.get().get("initial_jar")) })
						.loadClass("Rs2Applet").newInstance();
				loader.setStub(new Stub());
				loader.init();
				loader.start();
				gamePanel.removeAll();
				gamePanel.add(loader);
				instance.revalidate();
				double seconds = (System.currentTimeMillis() - Constants.startTime) / 1000D;
				TextLogger.log("Succesfully loaded runescape in " + seconds  + " seconds.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	});
	


}
