package jmr.y2.resources;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.vaadin.server.Page;

public class ClientRegistry implements IDataProvider {


	public List<ClientRecord> list = new LinkedList<>();

	public final Set<IDataListener> listeners = new HashSet<IDataListener>();
	
	
	private ClientRegistry(){};
	
	private static ClientRegistry instance;
	
	public static ClientRegistry getInstance() {
		if ( null==instance ) {
			instance = new ClientRegistry();
		}
		return instance;
	}
	
	public ClientRecord addClient( final Page page ) {
		final ClientRecord cr = new ClientRecord( page );
		list.add( cr );

		for ( final IDataListener listener : listeners ) {
			listener.updated();
		}
		
		System.out.println( instance.toString() );
		return cr;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		sb.append( "ClientRegistry - " + list.size() + " client(s)\n" );
		for ( final ClientRecord record : list ) {
			sb.append( "  " );
			final KnownClients kc = KnownClients.identify( record );
			if ( null!=kc ) {
				sb.append( "\"" + kc.getName() + "\" - " );
			} else {
				sb.append( "UNKNOWN CLIENT - " );
			}
			sb.append( record.toString() );
			sb.append( "\n" );
		}
		return sb.toString();
	}

	@Override
	public void addListener( final IDataListener listener ) {
		listeners.add( listener );
	}
	
}
