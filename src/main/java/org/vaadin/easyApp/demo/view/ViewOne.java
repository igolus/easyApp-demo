package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.ActionContainerBuilder;
import org.vaadin.easyapp.util.EasyAppLayout;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

@ContentView(sortingOrder=2, viewName = "Table", icon = "icons/Java-icon.png", rootViewParent = HomeRoot.class)
@SuppressWarnings("serial")
public class ViewOne extends EasyAppLayout {
	
	private TextField participant;
	private ActionContainer actionContainer;
	
	private boolean b1Clicked = false;
	private boolean b2Clicked = false;
	
    public ViewOne() {
    	//super();
    	setSpacing(true);
        
        Panel panel = new Panel("Astronomer Panel");
        panel.addStyleName("mypanelexample");
        panel.setSizeUndefined(); // Shrink to fit content
        AbstractOrderedLayout layout;
		

        // Create the content
        FormLayout content = new FormLayout();
        content.addStyleName("mypanelcontent");
        participant = new TextField("Participant");
		content.addComponent(participant);
        content.addComponent(new TextField("Organization"));
        content.setSizeUndefined(); // Shrink to fit
        content.setMargin(true);
        panel.setContent(content);
        panel.setSizeFull();
        addComponent(panel);
    }

	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view One");
	}
	
	@Override
	public ActionContainer buildActionContainer() {
		ActionContainerBuilder builder = new ActionContainerBuilder(null)
				.addButton("B1", "ABACUS", null,  this::b1Clickable			
					, this::b1Clicked)
				.addButton("B2", "ABACUS", null,  this::b2Clickable			
					, this::b2Clicked)
				.setSearch(this::search);

		return builder.build();
	}

	
	public boolean b1Clickable() {
		return !b2Clicked;
	}

	public void b1Clicked(ClickEvent event) {
		Notification.show("B1 clicked");
		b1Clicked = !b1Clicked;
		participant.setEnabled(b1Clicked);
		refreshClickable();
	}

	public boolean b2Clickable() {
		return !b1Clicked;
	}

	public void b2Clicked(ClickEvent event) {
		Notification.show("B2 clicked");
		b2Clicked = !b2Clicked;
		//refresh();
		refreshClickable();
	}
	
	public void search(String searchValue) {
		Notification.show("Search for:" + searchValue);
	}
}