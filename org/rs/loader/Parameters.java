package org.rs.loader;

import java.util.HashMap;

import org.rs.Constants;
import org.rs.net.Web;

public class Parameters {
	private static HashMap<String, String> params = new HashMap<String, String>();

	static {
		final String content = Web.readPage(Constants.PARAMS_PAGE).replaceAll(
				"param=", " ");
		for (final String parse : content.split(" ")) {
			final String[] param = parse.split("=");
			if (param.length == 2) {
				params.put(param[0], param[1]);
			}
		}
	}

	public static final HashMap<String, String> get() {
		return params;
	}

}
