package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=2, viewName = "Calendar", icon = "ANGELLIST", rootViewParent = SecondRoot.class)
@SuppressWarnings("serial")
public class ViewFive extends VerticalLayout implements View {

	public ViewFive() {
		setSpacing(true);
		Calendar cal = new Calendar("My Calendar");
		cal.setSizeFull();
		addComponent(cal);
	}

	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view 1");
	}

}