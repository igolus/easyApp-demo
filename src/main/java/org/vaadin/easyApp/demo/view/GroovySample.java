package org.vaadin.easyApp.demo.view;

import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.easyApp.demo.DemoLayout;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.ActionContainer.Position;
import org.vaadin.easyapp.util.ActionContainerBuilder;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

@ContentView(sortingOrder=2, viewName = "Groovy Sample", icon = "FILE_CODE", rootViewParent = ExpRoot.class)
@SuppressWarnings("serial")
public class GroovySample extends DemoLayout {
	
    public GroovySample() {
    	super();
    }


	public void enterInView(ViewChangeEvent event) {
		Notification.show("Entering view One");
	}
	
	
	
	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/forum/thread/214731";
	}


	public ActionContainer buildTargetActionContainer() {
		ActionContainerBuilder builder = new ActionContainerBuilder(null)
				.addButton(VaadinIcons.PLAY, this::run, Position.LEFT);

		return builder.build();
	}

	
	public boolean runClickable() {
		return true;
	}
	
	public void run(ClickEvent event) {
		refreshClickable();
	}
	
	private AceEditor aceEditorGroovy;
	private VerticalLayout layoutTarget;

	@Override
	public Component getComponent() {
		
		VerticalSplitPanel splitPanel = new VerticalSplitPanel();
		splitPanel.setSizeFull();
		
		AceEditor aceEditorGroovy = new AceEditor();
		aceEditorGroovy.setMode(AceMode.groovy);
		aceEditorGroovy.setSizeFull();
		
		layoutTarget = new VerticalLayout();
		layoutTarget.setSizeFull();
		
		splitPanel.setFirstComponent(aceEditorGroovy);
		splitPanel.setSecondComponent(layoutTarget);

		return splitPanel;
	}


	@Override
	public String getTitle() {
		return "Groovy Sample";
	}
	
	

}