package jmr.y2.resources;

import com.vaadin.server.Page;
import com.vaadin.server.WebBrowser;

public enum KnownClients {

	// Tablet, room/desk
	Samsung_Galaxy_Tab_4( "Samsung Galaxy Tab 4", 1280,800, false,
			"Mozilla/5.0 (Android 5.0.2; Tablet; rv:51.0) Gecko/51.0 Firefox/51.0" ),
	
	// Tablet, room/bed
	Samsung_Galaxy_Tab_10_1( "Samsung Galaxy Tab 10.1", 1280,752, false,
			"Mozilla/5.0 (Android 4.0.4; Tablet; rv:51.0) Gecko/51.0 Firefox/51.0" ),

	// Tablet, kitchen
	Kitchen_tablet( "Kitchen tablet", 600,912, false,
			"Mozilla/5.0 (Android 4.4.4; Tablet; rv:51.0) Gecko/51.0 Firefox/51.0" ),

	// VM102
	VM102( "VM102 on primary desktop", 1920,1015, true,
			"Mozilla/5.0 (Windows NT 5.1; rv:51.0) Gecko/20100101 Firefox/51.0" ),

	// VM101
	VM101( "VM101 on primary desktop", 2560,1335, true,
			"Mozilla/5.0 (Windows NT 5.2; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0" ),
	VM101_Eclipse( "VM101 on primary desktop in Eclipse", 2560,1335, true,
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Win64; x64; Trident/4.0)" ),

	// Phone
	Samsung_Galaxy_phone( "Samsung Galaxy primary phone", 360,640, false,
			"Mozilla/5.0 (Android 6.0.1; Mobile; rv:51.0) Gecko/51.0 Firefox/51.0" ),
	;
	
	public final String strName;
	public final String strBrowser;
	public final int iScreenWidth, iScreenHeight;
	public final boolean bWindowed;
	
	private KnownClients(	final String strName,
							final int iScreenWidth, 
							final int iScreenHeight,
							final boolean bWindowed,
							final String strBrowser ) {
		this.strName = strName;
		this.strBrowser = strBrowser;
		this.iScreenWidth = iScreenWidth;
		this.iScreenHeight = iScreenHeight;
		this.bWindowed = bWindowed;
	}
	
	public String getName() {
		return this.strName;
	}

	public static KnownClients identify( final ClientRecord record ) {
		if ( null==record ) return null;
		
		for ( final KnownClients known : KnownClients.values() ) {
			if ( ( known.iScreenWidth == record.iScreenWidth ) 
					&& ( known.iScreenHeight == record.iScreenHeight )
					&& ( known.strBrowser.equals( record.strBrowserApp ) ) ) {
				return known;
			}
		}
		return null;
	}

	public static KnownClients identify( final Page page ) {
		if ( null==page ) return null;

        final WebBrowser browser = page.getWebBrowser();
        if ( null==browser ) return null; // can this even happen?
		final int iScreenWidth = browser.getScreenWidth();
		final int iScreenHeight = browser.getScreenHeight();
		final String strBrowserApp = browser.getBrowserApplication();

		for ( final KnownClients known : KnownClients.values() ) {
			if ( ( known.iScreenWidth == iScreenWidth ) 
					&& ( known.iScreenHeight == iScreenHeight )
					&& ( known.strBrowser.equals( strBrowserApp ) ) ) {
				return known;
			}
		}
		return null;
	}
	
}
