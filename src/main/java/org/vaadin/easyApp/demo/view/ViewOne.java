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


	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view One");
	}
	
	
	
	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/forum/thread/214731";
	}

	@Override
	public String getSourceUrl() {
		return "https://github.com/miraclefoxx/bigdecimal-math/blob/master/src/main/java/io/github/miraclefoxx/math/Bernoulli.java";
	}
	
	public ActionContainer buildTargetActionContainer() {
		ActionContainerBuilder builder = new ActionContainerBuilder(null)
				.addButton("B1", "ABACUS", null,  this::b1Clickable			
					, this::b1Clicked, Position.LEFT, null)
				.addButton("B2", "ABACUS", null,  this::b2Clickable			
					, this::b2Clicked, Position.LEFT, null);

		return builder.build();
	}

	
	public boolean b1Clickable() {
		return true;
	}

	public void b1Clicked(ClickEvent event) {
	}

	public boolean b2Clickable() {
		return true;
	}

	public void b2Clicked(ClickEvent event) {
	}


	@Override
	public Component getComponent() {
		Panel panel = new Panel("Astronomer Panel");
		panel.setSizeFull();
		return panel;
	}

}