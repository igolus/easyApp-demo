package org.vaadin.easyApp.demo;

import java.util.Collections;

import org.vaadin.easyapp.EasyAppBuilder;
import org.vaadin.easyapp.ui.ViewWithToolBar;
import org.vaadin.easyapp.util.ActionContainerBuilder;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * VAAIN Easy APP sample
 */
@Push
@Theme("mytheme")
public class AddonDemoApplication extends UI {

    private ViewWithToolBar easyAppMainView;
	//private static AddonDemoApplication instance;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        
        
        Image image = new Image(null, new ThemeResource("favicon.ico"));
		image.setWidth(50, Unit.PIXELS);
		image.setHeight(50, Unit.PIXELS);
		
		EasyAppBuilder easyAppBuilder = new EasyAppBuilder(Collections.singletonList("org.vaadin.easyApp.demo.view"));
		easyAppBuilder.withNavigationIcon(image);
		//easyAppBuilder.withNavigationStlyle("Nav", "Selected");
		easyAppBuilder.withTopBarIcon(image);
		easyAppBuilder.withRessourceBundle(null);
		easyAppBuilder.withNavigationStyle("Nav", "Selected");
		
		
		ActionContainerBuilder actionContainerBuilder = new ActionContainerBuilder(null)
				.addButton("Test", VaadinIcons.MINUS, null , this::always, this::test);
		actionContainerBuilder.withStyleNam("TopBar");
		actionContainerBuilder.addImageIcon(image);
		easyAppBuilder.withActionContainer(actionContainerBuilder.build());
	
		easyAppMainView = easyAppBuilder.build(this);
		layout.addComponents(easyAppMainView);
        
        setContent(layout);
        
    }
	
	public void test(ClickEvent event) {
		
	}
	
	public boolean always() {
		return true;
	}
	
}
