package org.vaadin.easyApp.demo;

import org.vaadin.easyapp.util.EasyAppLayout;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

public abstract class DemoLayout extends EasyAppLayout {

	public DemoLayout() {
		super();
		TabSheet tabSheet = new TabSheet();
		tabSheet.addTab(getComponent(), "Component", VaadinIcons.ABACUS);


		String url = "http://demo.vaadin.com/sampler/";
		BrowserFrame vaadinBrowser = getBrowser(getVaadinHomeUrl());
		if (vaadinBrowser != null) {
			tabSheet.addTab(getComponent(), "Vaadin Links", VaadinIcons.VAADIN_H);
		}
		BrowserFrame sourceBrowser = getBrowser(getSourceUrl());
		if (sourceBrowser != null) {
			tabSheet.addTab(getComponent(), "Source Code", VaadinIcons.CODE);
		}

		addComponent(tabSheet);
	}

	private BrowserFrame getBrowser(String url) {
		if (url == null) {
			return null;
		}
		BrowserFrame browser = new BrowserFrame("Browser",
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
