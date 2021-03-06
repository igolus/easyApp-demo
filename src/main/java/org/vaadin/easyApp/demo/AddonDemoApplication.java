package org.vaadin.easyApp.demo;

import java.util.Collections;

import org.vaadin.easyapp.EasyAppBuilder;
import org.vaadin.easyapp.EasyAppMainView;
import org.vaadin.easyapp.event.SearchTrigger;
import org.vaadin.easyapp.ui.ViewWithToolBar;
import org.vaadin.easyapp.util.ActionContainerBuilder;
import org.vaadin.easyapp.util.ActionContainer.InsertPosition;
import org.vaadin.easyapp.util.ActionContainer.Position;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * VAAIN Easy APP sample
 */
@Push
@Theme("mytheme")
public class AddonDemoApplication extends UI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EasyAppMainView easyAppMainView;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        
        
        Image image = new Image(null, new ThemeResource("LogoMakr_7ZbveE.png"));
		image.setWidth(40, Unit.PIXELS);
		image.setHeight(40, Unit.PIXELS);
		
		//use the package where the views are defined
		EasyAppBuilder easyAppBuilder = new EasyAppBuilder(Collections.singletonList("org.vaadin.easyApp.demo.view"));
		
		easyAppBuilder.withNavigationIcon(image);
		easyAppBuilder.withTopBarIcon(image);
		easyAppBuilder.withRessourceBundle(null);
		easyAppBuilder.withNavigatorStyle("Nav");
		easyAppBuilder.withNavigationButtonSelectedStyle("Selected");
		easyAppBuilder.withContentStyle("Content");
		easyAppBuilder.withActionContainerStyle("Container");
		easyAppBuilder.withNavigatorSplitPosition(300);
		easyAppBuilder.withMenuCollapsable();
		easyAppBuilder.withTopBarStyle("TopBar");
		easyAppBuilder.withApplicationTitle("EasyApp Laboratory");
		easyAppBuilder.withContextualTextLabelStyle("Contextual");
		
		easyAppBuilder.withMenuCollapsable();
		
		ActionContainerBuilder actionContainerBuilder = new ActionContainerBuilder(null);
		actionContainerBuilder.addImageIcon(image,  Position.LEFT, null);
		actionContainerBuilder.addSearch(this::searchTriggered, Position.RIGHT, null);
		
		easyAppBuilder.withActionContainer(actionContainerBuilder.build());
	
		layout.addComponents(easyAppBuilder.build(this));
		easyAppMainView = easyAppBuilder.getMainView();
        
        setContent(layout);
    }

	
	public boolean always() {
		return true;
	}
	
	public void searchTriggered(String search) {
		Notification.show("Search to be implemented");
	}
	
}
