package org.rs.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;

import org.rs.log.LogFormatter;
import org.rs.log.LogTextArea;
import org.rs.log.SystemConsoleHandler;
import org.rs.log.TextAreaLogHandler;

public class TextLogger {
	protected static LogTextArea jTextArea1 = new LogTextArea();
	
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("Loader");

	public static void log(String s) {
		log.info(s);
	}

	public static void error(String s) {
		log.severe(s);
	}

	public static void clearLog() {
		jTextArea1.clearSelection();
	}

	public static void hideLog() {
		jTextArea1.setVisible(false);
	}

	public static void showLog() {
		jTextArea1.setVisible(true);
	}
	
	protected static void registerLogging() {
		final Properties logging = new Properties();
		final String logFormatter = LogFormatter.class.getCanonicalName();
		final String fileHandler = FileHandler.class.getCanonicalName();
		logging.setProperty("handlers",
				TextAreaLogHandler.class.getCanonicalName() + "," + fileHandler);
		logging.setProperty(".level", "INFO");
		logging.setProperty(SystemConsoleHandler.class.getCanonicalName()
				+ ".formatter", logFormatter);
		logging.setProperty(fileHandler + ".formatter", logFormatter);
		logging.setProperty(TextAreaLogHandler.class.getCanonicalName()
				+ ".formatter", logFormatter);
		final ByteArrayOutputStream logout = new ByteArrayOutputStream();
		try {
			logging.store(logout, "");
			LogManager.getLogManager().readConfiguration(
					new ByteArrayInputStream(logout.toByteArray()));
		} catch (final Exception ignored) {
		}
	}

}
