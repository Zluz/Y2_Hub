package jmr.y2.ui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import jmr.y2.resources.ClientRecord;
import jmr.y2.resources.ClientRegistry;
import jmr.y2.resources.IDataListener;
import jmr.y2.resources.KnownClients;

public class ClientListing implements IDataListener {

	final static Display display = Display.getDefault();
	
	final private Table table;
	final private TableColumn tcName;
	final private TableColumn tcConnected;
	final private TableColumn tcScreen;
	final private TableColumn tcBrowser;
	
	
	public ClientListing( final Composite parent ) {
		final Composite comp = new Composite( parent, SWT.NONE );
		comp.setLayout( new FillLayout() );
		table = new Table( comp, SWT.FULL_SELECTION );
		table.setHeaderVisible( true );
		table.setLinesVisible( true );
		
		tcName = new TableColumn( table, SWT.LEFT );
		tcConnected = new TableColumn( table, SWT.LEFT );
		tcScreen = new TableColumn( table, SWT.LEFT );
		tcBrowser = new TableColumn( table, SWT.LEFT );
		
		tcName.setWidth( 200 ); 	tcName.setText( "Name" );
		tcConnected.setWidth( 80 );	tcConnected.setText( "Connected" );
		tcScreen.setWidth( 80 ); 	tcScreen.setText( "Screen" );
		tcBrowser.setWidth( 500 ); 	tcBrowser.setText( "Browser Application" );
		
		reload();
		ClientRegistry.getInstance().addListener( this );
	}
	
	public void reload() {
		table.getDisplay().asyncExec( new Runnable() {
			@Override
			public void run() {
				table.removeAll();
				for ( final ClientRecord record : ClientRegistry.getInstance().list ) {
					final KnownClients kc = KnownClients.identify( record );

					final TableItem item = new TableItem( table, SWT.NONE );
					
					final String strName = null!=kc ? kc.getName() : "UNKNOWN";
					final String strConnected = record.bConnected ? "Connected" : "-disconnected-";
					final String strScreen = "" + record.iScreenWidth + "x" + record.iScreenHeight;
					
					item.setText( new String[]{ 
									strName, 
									strConnected, 
									strScreen, 
									record.strBrowserApp } );
				}
			}
		});
	}
	

	@Override
	public void updated() {
		reload();
	}

	
	
	public static void main( final String[] args ) {
		final Shell shell = new Shell( display );
		shell.setLayout( new FillLayout() );
		
		final ClientListing listing = new ClientListing( shell );
		
		shell.pack();
		shell.open();
		

	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
	}

}
