package jmr.y2.resources;

import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;

public class ClientRecord {

	final WebBrowser browser;

	public final String strBrowserApp;
	public final String strAddress;
	public final String strLocale;
	
	public final int iScreenWidth;
	public final int iScreenHeight;
	
	int iClientWidth;
	int iClientHeight;
	
	public boolean bConnected;
	
	public ClientRecord( final Page page ) {

        this.browser = page.getWebBrowser();

		strBrowserApp = browser.getBrowserApplication();
		strAddress = browser.getAddress();
		strLocale = browser.getLocale().toString();
		
		iScreenWidth = browser.getScreenWidth();
		iScreenHeight = browser.getScreenHeight();
		
		iClientWidth = page.getBrowserWindowWidth();
		iClientHeight = page.getBrowserWindowHeight();
		
		bConnected = true;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		if ( this.bConnected ) {
			sb.append( "[connected] " );
		} else {
			sb.append( "[NOT CONNECTED] " );
		}
		sb.append( "Addr:" + strAddress + ", " );
		sb.append( "Locale:" + strLocale + ", " );
		sb.append( "Screen:" + iScreenWidth + "x" + iScreenHeight + ", " );
		sb.append( "Client:" + iClientWidth + "x" + iClientHeight + ", " );
		sb.append( "Browser:\"" + strBrowserApp + "\"" );
		return sb.toString();
	}

	public void setConnected( final boolean bConnected ) {
		this.bConnected = bConnected;
	}
	
}
