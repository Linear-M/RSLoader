package org.rs;

import java.net.MalformedURLException;
import java.net.URL;

public final class Constants {
	
	
	public static final String BASE_LINK = "http://world2.runescape.com/";
	public static final String PARAMS_PAGE = BASE_LINK + "l=0/jav_config.ws";
	public static URL BaseUrl = null;
	public static long startTime = 0;
	
	static {
		try {
			BaseUrl = new URL(BASE_LINK);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	

}
