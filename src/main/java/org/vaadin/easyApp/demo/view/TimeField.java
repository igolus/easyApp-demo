package org.vaadin.easyApp.demo.view;

import java.time.LocalTime;
import java.util.Locale;

import org.vaadin.easyApp.demo.DemoLayout;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.annotations.ContentView;
import org.vaadin.thomas.timefield.AbstractTimeField;
import org.vaadin.thomas.timefield.TimeTextField;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.v7.shared.ui.datefield.Resolution;

@ContentView(sortingOrder=1, viewName = "Timefield", icon = "TIME_FORWARD", rootViewParent = FormRoot.class)
@SuppressWarnings("serial")
public class TimeField extends DemoLayout {

	public TimeField() {
		super();
	}


	public void enterInView(ViewChangeEvent event) {
	}



	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/directory/component/timefield";
	}


	public ActionContainer buildTargetActionContainer() {
		//No button in top bar
		return null;

	}


	@Override
	public Component getComponent() {
		final VerticalLayout content = new VerticalLayout();
		
		final AbstractTimeField<?> f = createField("Normal 24h");
		f.setLocale(Locale.FRANCE);
		f.setWidth("100px");
		f.setImmediate(true);
		f.setHours(0);
		content.addComponent(f);

		AbstractTimeField<?> f2 = createField("Normal 12h");
		f2.setResolution(Resolution.SECOND);
		f2.setLocale(Locale.US);
		f2.setWidth("200px");
		// f2.setHourMin(1);
		// f2.setHourMax(14);
		content.addComponent(f2);
		f.addValueChangeListener(e -> {
			final AbstractTimeField<?> field = (AbstractTimeField<?>) e
					.getProperty();
			Notification.show(field.getFormattedValue());
			System.out.println(field.getValue());
		});
		f2.setBuffered(false);

		f2.setPropertyDataSource(f);

		f2 = createField("Restricted");
		f2.setWidth("200px");
		f2.setResolution(Resolution.MINUTE);
		f2.setMinutes(40);
		f2.setMinuteInterval(30);
		f2.setHourMin(-12);
		f2.setHourMax(3);
		content.addComponent(f2);

		f2 = createField("disabled");
		f2.setWidth("200px");
		f2.setHours(LocalTime.now().getHour());
		f2.setEnabled(false);
		content.addComponent(f2);

		f2 = createField("readonly");
		f2.setWidth("200px");
		f2.setHours(LocalTime.now().getHour());
		f2.setReadOnly(true);
		content.addComponent(f2);
		
		return content;
	}
	
	private AbstractTimeField<?> createField(String caption) {
		return new TimeTextField(caption);
	}


	@Override
	public String getTitle() {
		return "Time FIeld";
	}



}