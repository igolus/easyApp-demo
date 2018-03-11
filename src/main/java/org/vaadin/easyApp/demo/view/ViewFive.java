package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.EasyAppLayout;
import org.vaadin.easyapp.util.EasyAppView;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=2, viewName = "Calendar", icon = "ANGELLIST", rootViewParent = SecondRoot.class)
@SuppressWarnings("serial")
public class ViewFive extends EasyAppLayout  {

	public ViewFive() {
		setSpacing(true);
		addComponent(new TextField(""));
	}

	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view 1");
	}

	@Override
	public ActionContainer buildActionContainer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}