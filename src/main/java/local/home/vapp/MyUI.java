package local.home.vapp;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.UIDetachedException;
import com.vaadin.ui.VerticalLayout;

import jmr.y2.resources.ClientRecord;
import jmr.y2.resources.ClientRegistry;
import jmr.y2.resources.KnownClients;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Push
@SuppressWarnings("serial")
@Theme("mytheme")
//@Theme("vaadinserverpush")
public class MyUI extends UI {

//	@WebServlet(value = "/*", asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = VaadinserverpushUI.class)
//	public static class Servlet extends VaadinServlet {
//	}

	
//	final static ClientListing listing;
	static {
//		listing = new ClientListing(  );
//		final Thread thread = new Thread() {
//			public void run() {
//				try {
//					ClientListing.main( null );
//				} catch ( final UnsatisfiedLinkError e ) {
//					e.printStackTrace();
//				}
//			};
//		};
//		thread.start();
//		DesktopUI.getInstance();
	}
	
	

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
	
	
    @Override
    protected void init( final VaadinRequest vaadinRequest ) {

//		DesktopUI.getInstance();

        final UI ui = UI.getCurrent();
		final Page page = ui.getPage();

		final int iWidth = page.getBrowserWindowWidth();
        final int iHeight = page.getBrowserWindowHeight();
        
        final boolean bLandscape = iWidth > iHeight;
        
        // graphic
        // textual

//      final Panel pnlGraphic = new Panel( "Graphic" );
      final Panel pnlGraphic = new Panel( (String)null );
//        pnlGraphic.addStyleName( ValoTheme.PANEL_BORDERLESS );
        pnlGraphic.setSizeFull();
        final HorizontalLayout hlGraphic = new HorizontalLayout();
        hlGraphic.setSizeFull();
        pnlGraphic.setContent( hlGraphic );
        

        final VerticalLayout vlGraphic = new VerticalLayout();
        vlGraphic.setSizeFull();
        
        final Component image = getImageComponent();
        if ( null!=image ) {
	        
	        image.setSizeFull();
	        
			hlGraphic.addComponent( image );
	        hlGraphic.addComponent( vlGraphic );
	        
	        hlGraphic.setExpandRatio( image, 0.70f );
	        hlGraphic.setExpandRatio( vlGraphic, 0.28f );
        }

        

//        final Panel pnlTextual = new Panel( "Textual" );
        final Panel pnlTextual = new Panel( (String)null );
//        pnlGraphic.addStyleName( ValoTheme.PANEL_BORDERLESS );
        pnlTextual.setSizeFull();
        final VerticalLayout vlTextual = new VerticalLayout();
        vlTextual.setSizeFull();
        pnlTextual.setContent( vlTextual );


    	final Layout layout;
    	if ( bLandscape ) {
    		layout = new HorizontalLayout();
    		pnlGraphic.setWidth( "100%" );
    		pnlTextual.setWidth( "100%" );
    		pnlGraphic.setSizeFull();
    		pnlTextual.setSizeFull();
    		layout.addComponents( pnlGraphic, pnlTextual );
    		layout.setSizeFull();
    		layout.setWidth( "100%" );
    	} else {
    		layout = new VerticalLayout();
    		pnlGraphic.setHeight( "100%" );
    		pnlTextual.setHeight( "100%" );
    		pnlGraphic.setSizeFull();
    		pnlTextual.setSizeFull();
    		layout.addComponents( pnlGraphic, pnlTextual );
    	}
        
        
        
        
		final ClientRecord record = 
					ClientRegistry.getInstance().addClient( page );


    	final KnownClients knownclient = KnownClients.identify( page );
		final String strTitle;
    	if ( null!=knownclient ) {
    		strTitle = "Y2 - " + knownclient.getName();
    	} else {
    		strTitle = "Y2 - UNKNOWN CLIENT";
    	}
    	final Label lblClientName = new Label( strTitle );
    	page.setTitle( strTitle );
    	
        final Label lblTime = new Label( "<label>" );
        lblTime.setValue( "Time: lbl setValue()");
//		lblTime.setImmediate( true );
		
		final TextField txtTime = new TextField( "<caption>" );
        txtTime.setValue( "Time: lbl setValue()");
//		txtTime.setImmediate( true );
//		lblTime.
        
        final TextField txtValue = new TextField();
        txtValue.setValue( "100" );
        txtValue.setStyleName( "my_highlight" );
        

        final TextField name = new TextField();
        name.setCaption("Type your name here:");
//        name.setValue( name.getStyleName() );
        System.out.println( "name.getStyleName() = " + name.getStyleName() );

//        Button button = new Button("Click Me");
//        button.addClickListener( e -> {
//            layout.addComponent(new Label("Thanks " + name.getValue() 
//                    + ", it works!"));
//        });
        
        
        
        
        
        // BEGIN-EXAMPLE: component.grid.editing.basic
        Grid grid = new Grid(GridExample.exampleDataSource());
        grid.setWidth("400px");
        grid.setHeight("200px");

        // Single-selection mode (default)
        grid.setSelectionMode(SelectionMode.NONE);

        // Enable editing
        grid.setEditorEnabled(true);
        
        
        
        
        
//        final TableExample table = new TableExample();
        final Table table = new Table("My Table",
                TableExample.generateContent());
        table.setHeight( "200px" );
        
        
        
        
        
        
        final List<Component> listCompGraphic = new LinkedList<>();
        final List<Component> listCompTextual = new LinkedList<>();

        final Label lblClock = new Label( "11:36" );
//        final Component lblClock = 
//        		new Label( "11:36" );
//        final TextField lblClock = 
//        		new TextField(); lblClock.setValue( "11:36" );
        lblClock.setSizeFull();
//        lblClock.setStyleName( "my_highlight" );
        lblClock.setStyleName( "my-label-title-vertical" );
		listCompGraphic.add( lblClock );
		
		
		listCompGraphic.add( new Label( "Spotify Advance Track" ) );
        final Button btnSpotifyNext = new Button( "Next" );
//        btnSpotifyNext.setCaption( "Spotify Advance Track" );
		listCompGraphic.add( btnSpotifyNext );
		
		listCompGraphic.add( new Label( "Spotify Stop Playback" ) );
        final Button btnSpotifyStop = new Button( "Stop" );
//        btnSpotifyStop.setCaption( "Spotify Stop Playback" );
		listCompGraphic.add( btnSpotifyStop );
		
		listCompGraphic.add( new Label( "Change Source to Radio" ) );
        final Button btnSourceRadio = new Button( "Radio" );
//        btnSourceRadio.setCaption( "Change Source to Radio" );
		listCompGraphic.add( btnSourceRadio );
        
        
        listCompTextual.add( lblClientName ); 
        listCompTextual.add( lblTime ); 
        listCompTextual.add( txtTime ); 
        listCompTextual.add( txtValue ); 
        listCompTextual.add( name ); 
//        listComponents.add( button ); 
		listCompTextual.add( grid ); 
		listCompTextual.add( table );

		
        
        
//        layout.addComponents( 
//        				lblClientName, lblTime, txtTime, txtValue, 
//        				name, button, 
//        				grid, table );
//        layout.setMargin(true);
//        layout.setSpacing(true);
        
        

//        int iIndex = 4;
        final Label lblWidth = new Label( "Width: " + iWidth );
        final Label lblHeight = new Label( "Height: " + iHeight );
//		layout.addComponent( lblWidth, iIndex++ );
//		layout.addComponent( lblHeight, iIndex++ );
		listCompTextual.add( lblWidth );
		listCompTextual.add( lblHeight );

		
//        layout.addComponent( new Label( "UI.getCaption(): " 		+ ui.getCaption() ), 5 );
//        layout.addComponent( new Label( "UI.getDebugId(): " 		+ ui.getDebugId() ), 5 );
//        layout.addComponent( new Label( "UI.getDescription(): " 	+ ui.getDescription() ), 5 );
//        layout.addComponent( new Label( "UI.getId(): " 			+ ui.getId() ), 5 );
//        layout.addComponent( new Label( "UI.getEmbedId(): " 		+ ui.getEmbedId() ), iIndex++ );
//        layout.addComponent( new Label( "UI.getConnectorId(): " 	+ ui.getConnectorId() ), iIndex++ );

//        layout.addComponent( new Label( "UI.getWidth(): " 		+ ui.getWidth() ), 5 );
//        layout.addComponent( new Label( "UI.getHeight(): " 		+ ui.getHeight() ), 5 );
        
//        final WebBrowser browser = page.getWebBrowser();
//        layout.addComponent( new Label( "browser.getAddress(): " 	+ browser.getAddress() ), iIndex++ );
//        layout.addComponent( new Label( "browser.getBrowserApplication(): " + browser.getBrowserApplication() ), iIndex++ );
//        layout.addComponent( new Label( "browser.getScreenHeight(): "+ browser.getScreenHeight() ), iIndex++ );
//        layout.addComponent( new Label( "browser.getScreenWidth(): " + browser.getScreenWidth() ), iIndex++ );
//        layout.addComponent( new Label( "browser.getLocale(): " 	+ browser.getLocale() ), iIndex++ );
        
        
        
        
        page.addListener( new BrowserWindowResizeListener() {
			@Override
			public void browserWindowResized( final BrowserWindowResizeEvent event ) {
				access( new Runnable() {
					@Override
					public void run() {
						final int iWidth = page.getBrowserWindowWidth();
				        final int iHeight = page.getBrowserWindowHeight();
				        lblWidth.setValue( "Width: " + iWidth );
				        lblHeight.setValue( "Height: " + iHeight );
					}
				});
			}
        });
        
        
        
        
        // Let the user view the file in browser or download it
//        final Link link = new Link("Link to the image file", resource);
        
        
//        layout.addComponent( image, iIndex++ );
//        layout.addComponent( link, iIndex++ );
//        listCompGraphic.add( image );
//        listCompGraphic.add( link );
        
        

        for ( final Component component : listCompTextual ) {
        	component.setSizeFull();
        	vlTextual.addComponent( component );
        }
        for ( final Component component : listCompGraphic ) {
        	component.setSizeFull();
        	vlGraphic.addComponent( component );
        }
        
        
        setContent(layout);
        this.setSizeFull();
        
        
        final Thread threadTestPush = new Thread() {
        	@Override
        	public void run() {
				System.out.println( "Starting thread.." );
        		try {
        			boolean bAttached = true;
        			do {
						Thread.sleep( 1000 );
						final String strTime = "Time: " 
									+ System.currentTimeMillis() + (int)( 10000 * Math.random() );
//						System.out.println( "Setting value: " + strTime );
						
						final int iValue = (int)( 100 * Math.random() );
						final String strValue = Integer.toString( iValue );
						final String strStyle = iValue > 60 ? "my_highlight" : "";
						
						try {
							access( new Runnable() {
								public void run() {
					        		lblTime.setValue( strTime );
					        		txtTime.setValue( strTime );
	//				        		layout.addComponent( new Label("New strTime: " + strTime ) );
					        		
					                txtValue.setValue( strValue );
					                txtValue.setStyleName( strStyle );
	
								};
							});
						} catch ( final UIDetachedException 
										| RejectedExecutionException
										| IllegalStateException e ) {
//							e.printStackTrace();
							bAttached = false;
						}
		        		
		        		
        			} while ( bAttached );
				} catch ( final InterruptedException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		record.setConnected( false );
				System.out.println( "Ending thread.." );
        	}
        };
        threadTestPush.start();
        
        
    }
    
    
    public Component getImageComponent() {

//        // Image as a file resource
//        final FileResource resource = new FileResource(
////        		new File(basepath +
//////                			"/WEB-INF/images/Spotify_LanaDelRey.jpg"));
////    						"/META-INF/images/Spotify_LanaDelRey.jpg"));
//        		new File( "C:\\Development\\workspaces\\20160807_Eclipse_4.6\\vapp\\files\\Spotify_LanaDelRey.jpg" ) );


        // Find the application directory
       final String strVBaseDir = 
    		   VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
       final String strResDir = strVBaseDir + "\\WEB-INF\\classes";
       
       final String strSpotifyImage = strResDir + "\\images\\Spotify_LanaDelRey.jpg"; 

       final FileResource resSpotify = new FileResource( new File( strSpotifyImage ) );

        
        // Show the image in the application
//        final Image image = new Image("Image from file", resource);
        if ( null!=resSpotify ) {
        	final Image image = new Image( null, resSpotify );
        	return image;
        } else {
        	return null;
        }
    }
    

}
