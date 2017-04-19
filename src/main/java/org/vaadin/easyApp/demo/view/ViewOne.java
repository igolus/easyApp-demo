package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=1, viewName = "Panel", icon = "ANDROID", rootViewParent = HomeRoot.class, homeView = true)
@SuppressWarnings("serial")
public class ViewOne extends VerticalLayout implements View {

    public ViewOne() {
        setSpacing(true);
        
        Panel panel = new Panel("Astronomer Panel");
        panel.addStyleName("mypanelexample");
        panel.setSizeUndefined(); // Shrink to fit content
        AbstractOrderedLayout layout;
		

        // Create the content
        FormLayout content = new FormLayout();
        content.addStyleName("mypanelcontent");
        content.addComponent(new TextField("Participant"));
        content.addComponent(new TextField("Organization"));
        content.setSizeUndefined(); // Shrink to fit
        content.setMargin(true);
        panel.setContent(content);
        panel.setSizeFull();
        addComponent(panel);

    }

	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view 1");
	}

}