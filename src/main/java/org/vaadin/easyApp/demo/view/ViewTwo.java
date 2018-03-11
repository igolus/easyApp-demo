package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.EasyAppLayout;
import org.vaadin.easyapp.util.EasyAppView;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=2, viewName = "Table", icon = "icons/Java-icon.png", rootViewParent = HomeRoot.class, componentParent = ViewOne.class)
@SuppressWarnings("serial")
public class ViewTwo extends EasyAppLayout {

    public ViewTwo() {
        setSpacing(true);
        
        /* Create the table with a caption. */
        Grid table = new  Grid("This is my Table");
        table.setSizeFull();

//        /* Define the names and data types of columns.
//         * The "default value" parameter is meaningless here. */
//        table.addContainerProperty("First Name", String.class,  null);
//        table.addContainerProperty("Last Name",  String.class,  null);
//        table.addContainerProperty("Year",       Integer.class, null);
//
//        /* Add a few items in the table. */
//        table.addItem(new Object[] {
//            "Nicolaus","Copernicus",new Integer(1473)}, new Integer(1));
//        table.addItem(new Object[] {
//            "Tycho",   "Brahe",     new Integer(1546)}, new Integer(2));
//        table.addItem(new Object[] {
//            "Giordano","Bruno",     new Integer(1548)}, new Integer(3));
//        table.addItem(new Object[] {
//            "Galileo", "Galilei",   new Integer(1564)}, new Integer(4));
//        table.addItem(new Object[] {
//            "Johannes","Kepler",    new Integer(1571)}, new Integer(5));
//        table.addItem(new Object[] {
//            "Isaac",   "Newton",    new Integer(1643)}, new Integer(6));
        addComponent(table);
    }

	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view Two");
	}

	@Override
	public ActionContainer buildActionContainer() {
		// TODO Auto-generated method stub
		return null;
	}

}