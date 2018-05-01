package org.vaadin.easyApp.demo.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.vaadin.addons.ComboBoxMultiselect;
import org.vaadin.easyApp.demo.DemoLayout;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;

@ContentView(sortingOrder=2, viewName = "ComboBoxMultiselect", icon = "COMBOBOX", rootViewParent = UIRoot.class)
@SuppressWarnings("serial")
public class ComboBoxMultiselectSample extends DemoLayout {
	
    public class NamedObject {

		private long rank;
		private String name;

		public NamedObject(long rank, String name) {
			this.rank = rank;
			this.name = name;
		}
		
		public String toString() {
			return name;
		}

	}


	public ComboBoxMultiselectSample() {
    	super();
    }


	public void enterInView(ViewChangeEvent event) {
		Notification.show("Entering view One");
	}
	
	
	
	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/directory/component/comboboxmultiselect-add-on";
	}


	public ActionContainer buildTargetActionContainer() {
		return null;
	}

	
	
	@Override
	public Component getComponent() {
		
		// Initialize a list with items
		List<NamedObject> list = new ArrayList<NamedObject>();
		NamedObject vaadin = new NamedObject(2L, "Vaadin");
		list.add(new NamedObject(1L, "Java"));
		list.add(vaadin);
		list.add(new NamedObject(3L, "Bonprix"));
		list.add(new NamedObject(4L, "Addon"));

		// Initialize the ComboBoxMultiselect
		final ComboBoxMultiselect<NamedObject> comboBoxMultiselect = new ComboBoxMultiselect<>();
		comboBoxMultiselect.setPlaceholder("Type here");
		comboBoxMultiselect.setCaption("ComboBoxMultiselect");
		comboBoxMultiselect.setItems(list);
		comboBoxMultiselect.setValue(new HashSet<>(Arrays.asList(vaadin)));
		
		return comboBoxMultiselect;
	}


	@Override
	public String getTitle() {
		return "ComboBoxMultiselect";
	}
	
}