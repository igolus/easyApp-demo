package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.EasyAppLayout;
import org.vaadin.easyapp.util.EasyAppView;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=3, viewName = "Slider", icon = "ANCHOR", rootViewParent = SecondRoot.class)
@SuppressWarnings("serial")
public class ViewFour extends EasyAppLayout {

	public ViewFour() {
		setSpacing(true);

		// Create a vertical slider
		Slider horizslider = new Slider(1, 100);
		horizslider.setOrientation(SliderOrientation.HORIZONTAL);
		horizslider.setSizeFull();
		
		// Shows the value of the vertical slider
		final Label vertvalue = new Label();
		vertvalue.setSizeUndefined();

		// Handle changes in slider value.
//		horizslider.addValueChangeListener(
//		    new Property.ValueChangeListener() {
//		    public void valueChange(ValueChangeEvent event) {
//		        double value = (Double) horizslider.getValue();
//
//		        // Use the value
//		        //box.setHeight((float) value, Sizeable.UNITS_PERCENTAGE);
//		        vertvalue.setValue(String.valueOf(value));
//		    }
//		});
//		
//		horizslider.setImmediate(true);
		
		addComponent(horizslider);
		addComponent(vertvalue);
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