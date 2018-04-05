package org.vaadin.easyApp.demo;

import org.vaadin.easyapp.util.EasyAppLayout;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

public abstract class DemoLayout extends EasyAppLayout {

	public DemoLayout() {
		super();
		TabSheet tabSheet = new TabSheet();
		tabSheet.setSizeFull();
		tabSheet.addTab(getComponent(), "Component", VaadinIcons.ABACUS);

		BrowserFrame vaadinBrowser = getBrowser(getVaadinHomeUrl());
		//vaadinBrowser.addStyleName("embedded-frame");

		VerticalLayout verticalLayout = new VerticalLayout();
		//vaadinBrowser.setHeight("100%");
		
		verticalLayout.setMargin(false);
		verticalLayout.setSizeFull();
		verticalLayout.addComponent(vaadinBrowser);
		verticalLayout.setExpandRatio(vaadinBrowser, 1.0f);
		
		if (vaadinBrowser != null) {
			tabSheet.addTab(vaadinBrowser, "Vaadin Links", VaadinIcons.VAADIN_H);
		}
		BrowserFrame sourceBrowser = getBrowser(getSourceUrl());
		if (sourceBrowser != null) {
			tabSheet.addTab(sourceBrowser, "Source Code", VaadinIcons.CODE);
			//tab.set
		}

		addComponent(tabSheet);
	}

	private BrowserFrame getBrowser(String url) {
		if (url == null) {
			return null;
		}
		BrowserFrame browser = new BrowserFrame(null,
				new ExternalResource(url));
		browser.setSizeFull();
		return browser;
	}

	/**
	 * Define the url where the component is defined
	 * @return null if not set
	 */
	public String getVaadinHomeUrl() {
		return null;
	}

	/**
	 * Define the source code url 
	 * @return null if not set
	 */
	public String getSourceUrl() {
		return null;
	}


	public abstract Component getComponent();



}
