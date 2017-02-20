package jmr.y2.ui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class DesktopUI {

	final static Display display = Display.getDefault();

	private static DesktopUI instance = null;
	private final Shell shell;

	final private Table table;
	final private TableColumn tcName;
	
	
	public static DesktopUI getInstance() {
		final DesktopUI[] result = { null };
		display.syncExec( new Runnable() {
			@Override
			public void run() {
				if ( null==instance ) {
					instance = new DesktopUI();
				}
				result[0] = instance;
			}
		});
		return result[0];
	}
	
	private DesktopUI() {
		shell = new Shell( display, SWT.NONE );
		shell.setLayout( new FillLayout() );
		final Composite comp = new Composite( shell, SWT.NONE );
		comp.setLayout( new FillLayout() );
		
		table = new Table( comp, SWT.FULL_SELECTION );
		table.setHeaderVisible( true );
		table.setLinesVisible( true );
		tcName = new TableColumn( table, SWT.LEFT );
		tcName.setWidth( 200 ); 
		tcName.setText( "Name" );
		
		
		final Shell shellListing = new Shell( display );

		final ClientListing listing = new ClientListing( shellListing );
		
		shellListing.pack();
		shellListing.open();
	}
	
	
	public static void run() {
//		final Shell shell = new Shell( display );
//		shell.setLayout( new FillLayout() );
		
//		final DesktopUI ui = new DesktopUI( shell );
		final DesktopUI ui = DesktopUI.getInstance();
		
		ui.shell.pack();
		ui.shell.open();
		
	    while (!ui.shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
	}
	
	

	public static void main( final String[] args ) {
		run();
	}

}
