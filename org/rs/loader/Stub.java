package org.rs.loader;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.URL;

import org.rs.Constants;

public class Stub implements AppletStub {

	@Override
	public void appletResize(int width, int height) {

	}

	@Override
	public AppletContext getAppletContext() {
		return null;
	}

	@Override
	public URL getCodeBase() {
		return Constants.BaseUrl;
	}

	@Override
	public URL getDocumentBase() {
		return Constants.BaseUrl;
	}

	@Override
	public String getParameter(String name) {
		return Parameters.get().get(name);
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
