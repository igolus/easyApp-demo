package org.vaadin.easyApp.demo.view;

import org.vaadin.easyApp.demo.DemoLayout;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.ActionContainerBuilder;
import org.vaadin.easyapp.util.EasyAppLayout;
import org.vaadin.easyapp.util.ActionContainer.Position;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=2, viewName = "Table", icon = "icons/Java-icon.png", rootViewParent = HomeRoot.class)
@SuppressWarnings("serial")
public class ViewOne extends DemoLayout {
	
    public ViewOne() {
    	super();
    }


	public void enterInView(ViewChangeEvent event) {
		Notification.show("Entering view One");
	}
	
	
	
	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/forum/thread/214731";
	}


	public ActionContainer buildTargetActionContainer() {
//		ActionContainerBuilder builder = new ActionContainerBuilder(null)
//				.addButton("B1", "ABACUS", null,  this::b1Clickable			
//					, this::b1Clicked, Position.LEFT, null)
//				.addButton("B2", "ABACUS", null,  this::b2Clickable			
//					, this::b2Clicked, Position.LEFT, null);
//
//		return builder.build();
		return null;
	}

	
	public boolean b1Clickable() {
		return true;
	}
	
	boolean b2Clickable = false;
	
	public void b1Clicked(ClickEvent event) {
		b2Clickable = !b2Clickable;
		refreshClickable();
	}

	public boolean b2Clickable() {
		return b2Clickable;
	}

	public void b2Clicked(ClickEvent event) {
		refreshClickable();
	}


	@Override
	public Component getComponent() {
		Panel panel = new Panel("Astronomer Panel");
		panel.setSizeFull();
		return panel;
	}


	@Override
	public String getTitle() {
		return "View One";
	}
	
	

}