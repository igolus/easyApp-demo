package org.vaadin.easyApp.demo;

import java.util.Collections;

import org.vaadin.easyapp.EasyAppBuilder;
import org.vaadin.easyapp.event.SearchTrigger;
import org.vaadin.easyapp.ui.ViewWithToolBar;
import org.vaadin.easyapp.util.ActionContainerBuilder;

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
	private ViewWithToolBar easyAppMainView;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        
        
        Image image = new Image(null, new ThemeResource("gene_white_transp.png"));
		image.setWidth(40, Unit.PIXELS);
		image.setHeight(40, Unit.PIXELS);
		
		EasyAppBuilder easyAppBuilder = new EasyAppBuilder(Collections.singletonList("org.vaadin.easyApp.demo.view"));
		easyAppBuilder.withNavigationIcon(image);
		easyAppBuilder.withTopBarIcon(image);
		easyAppBuilder.withRessourceBundle(null);
		easyAppBuilder.withNavigatorStyle("Nav");
		easyAppBuilder.withNavigationButtonSelectedStyle("Selected");
		easyAppBuilder.withContentStyle("Content");
		
		ActionContainerBuilder actionContainerBuilder = new ActionContainerBuilder(null);
				//.addButton("Test", VaadinIcons.MINUS, null , this::always, this::test);
		actionContainerBuilder.withStyleName("TopBar");
		actionContainerBuilder.setSearch(this::searchTriggered);
		actionContainerBuilder.addImageIcon(image);
		easyAppBuilder.withActionContainer(actionContainerBuilder.build());
	
		easyAppMainView = easyAppBuilder.build(this);
		layout.addComponents(easyAppMainView);
        
        setContent(layout);
    }
	
	public void test(ClickEvent event) {
		Notification.show("Search to be implemented");
	}
	
	public boolean always() {
		return true;
	}
	
	public void searchTriggered(String search) {
		
	}
	
}
