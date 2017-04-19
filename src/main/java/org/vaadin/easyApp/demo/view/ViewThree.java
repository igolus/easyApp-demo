package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=1, viewName = "Tree", icon = "ANCHOR", rootViewParent = HomeRoot.class, componentParent = ViewOne.class)
@SuppressWarnings("serial")
public class ViewThree extends VerticalLayout implements View {

	public ViewThree() {
		setSpacing(true);

		Tree menu = new Tree();

		// Couple of childless root items
		menu.addItem("Mercury");
		menu.setChildrenAllowed("Mercury", false);
		menu.addItem("Venus");
		menu.setChildrenAllowed("Venus", false);

		// An item with hierarchy
		menu.addItem("Earth");
		menu.addItem("The Moon");
		menu.setChildrenAllowed("The Moon", false);
		menu.setParent("The Moon", "Earth");
		menu.expandItem("Earth"); // Expand programmatically
		addComponent(menu);

	}

	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view 1");
	}

}