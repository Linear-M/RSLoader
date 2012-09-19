package org.rs.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class Web {

	public static final String readPage(final String page) {
		String content = "";
		try {
            final URL url = new URL(page);
            final URLConnection c = url.openConnection();
            final BufferedReader in = new BufferedReader(new InputStreamReader(c
                    .getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content += inputLine + " ";
 
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return content;
	}
}
