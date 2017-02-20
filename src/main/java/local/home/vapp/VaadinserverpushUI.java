//package local.home.vapp;
//
//import java.time.Instant;
//
//import javax.servlet.annotation.WebServlet;
//
//import com.vaadin.annotations.Push;
//import com.vaadin.annotations.Theme;
//import com.vaadin.annotations.VaadinServletConfiguration;
//import com.vaadin.server.VaadinRequest;
//import com.vaadin.server.VaadinServlet;
//import com.vaadin.ui.Label;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.VerticalLayout;
//
//@Push
//@SuppressWarnings("serial")
//@Theme("vaadinserverpush")
//public class VaadinserverpushUI extends UI {
//
//	@WebServlet(value = "/VSP/*", asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = VaadinserverpushUI.class)
//	public static class Servlet extends VaadinServlet {
//	}
//
//	private QuoteGenerator qg;
//	private VerticalLayout layout;
//	private Label theTime;
//	
//	@Override
//	protected void init(VaadinRequest request) {
//		qg = new QuoteGenerator();
//		layout = new VerticalLayout();
//		layout.setMargin(true);
//		setContent(layout);
//		theTime = new Label();
//		theTime.setValue("Its now : " + Instant.now());
//		layout.addComponent(theTime);
//		new MyFirsthThread().start();
//		new MySecondThread2().start();
//	}
//
//	class MyFirsthThread extends Thread {
//
//	    @Override
//	    public void run() {
//	        try {
//	            while (true) {
//	        		Thread.sleep(1000);
//
//	                access(new Runnable() {
//	                    @Override
//	                    public void run() {
//	                		theTime.setValue("Its now : " + Instant.now());
//	                    }
//	                });
//	            }
//
//	        	} catch (InterruptedException e) {
//	        		e.printStackTrace();
//	        	}
//	    }
//	}
//
//	class MySecondThread2 extends Thread {
//	    int count = 0;
//
//	    @Override
//	    public void run() {
//	        try {
//	            while (count < 4) {
//	                Thread.sleep(10000);
//
//	                access(new Runnable() {
//	                    @Override
//	                    public void run() {
//	                    	layout.addComponent(new Label(qg.getQuote()));
//	                    	count++;
//	                    }
//	                });
//	            }
//
//	            access(new Runnable() {
//	                @Override
//	                public void run() {
//	                    layout.addComponent(new Label("No more messages for you !"));
//	                }
//	            });
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}	
//	
//}