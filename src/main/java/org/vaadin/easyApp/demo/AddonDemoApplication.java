package org.vaadin.easyApp.demo;

import java.util.Collections;

import org.vaadin.easyapp.EasyAppBuilder;
import org.vaadin.easyapp.EasyAppMainView;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
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

    private EasyAppMainView easyAppMainView;
	//private static AddonDemoApplication instance;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        
        
        Image image = new Image(null, new ThemeResource("favicon.ico"));
		image.setWidth(50, Unit.PIXELS);
		image.setHeight(50, Unit.PIXELS);
		
		easyAppMainView = new EasyAppBuilder(Collections.singletonList("org.vaadin.easyApp.demo.view"))
        	//.withTopBar()
			.withNavigationIcon(image)
//			.withTopBarIcon(image)
//        	.withTopBarStyle("topBannerBackGround")
//        	.withSearchCapabilities( (searchValue) -> search(searchValue) , FontAwesome.SEARCH)
//        	.withLogingCapabilities( 
//        			(user, password) -> loginAttempt(user, user),
//        			() -> logout()
//			)
//        	.withLogingUserText("login:")
//        	.withLogingPassWordText("password:")
//        	.withLoginCaption("Please login to access the application. (test@test.com/passw0rd)")
//        	.withLoginTextStyle("userLogged")
//        	.withLoginErroText("Bad credentials")
//        	.withLoginErrotLabelStyle("error")
//        	.withBreadcrumb()
//        	.withBreadcrumbStyle("breadcrumbStyle")
        	//.withButtonLinkStyleInBreadCrumb(BaseTheme.BUTTON_LINK)
        	//.withLoginPopupLoginStyle("propupStyle")
        	.build(this);
	
		
		layout.addComponents(easyAppMainView);
        
		//easyAppMainView.getTopBar().setStyleName("topBannerBackGround");
        
        setContent(layout);
        
    }

	private void logout() {
		Notification.show("Logged out");
	}

	private String loginAttempt(String user, String password) {
		if (user.equals("admin")) {
			return " *** logged as " + user + " *** ";
		}
		//null means error
		return null;
	}

	private void search(String searchValue) {
    	Notification.show("Search for : " + searchValue + easyAppMainView.getNavigator().getCurrentView());
	}

//	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
//    @VaadinServletConfiguration(ui = AddonDemoApplication.class, productionMode = false)
//    public static class MyUIServlet extends VaadinServlet {
//    }
}
