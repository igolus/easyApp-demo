package org.vaadin.easyApp.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.aceeditor.AceTheme;
import org.vaadin.easyapp.ui.ViewWithToolBar;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.EasyAppLayout;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

public abstract class DemoLayout extends EasyAppLayout {

	private static final String SRC_FOLDER = "src/";

	private static final String JAVA_EXT = ".java";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(DemoLayout.class);
	
	private TargetEasyAppLayout targetEasyAppLayout;


	public DemoLayout() {
		super();
		TabSheet tabSheet = new TabSheet();
		tabSheet.setSizeFull();
		
		ViewWithToolBar viewWithToolBar = new ViewWithToolBar();
		viewWithToolBar.setActionContainerStlyle("Container");
		
		targetEasyAppLayout = new TargetEasyAppLayout(getComponent(), buildTargetActionContainer());
		viewWithToolBar.buildComponents(targetEasyAppLayout);
		targetEasyAppLayout.refreshClickable();
		

		tabSheet.addTab(viewWithToolBar, "Component", VaadinIcons.ABACUS);

		BrowserFrame vaadinBrowser = getBrowser(getVaadinHomeUrl());
	
		if (vaadinBrowser != null) {
			tabSheet.addTab(vaadinBrowser, "Vaadin Links", VaadinIcons.VAADIN_H);
		}
		
		AceEditor aceEditor = getSourceEditor();
		if (aceEditor != null) {
			tabSheet.addTab(aceEditor, "Source Code", VaadinIcons.CODE);
		}
		
		setSizeFull();
		addComponent(tabSheet);
	}
	
	
	
	
	@Override
	public void refreshClickable() {
		targetEasyAppLayout.refreshClickable();
	}


	private AceEditor getSourceEditor() {
		List<String> splitList = Arrays.asList(this.getClass().toString().split("\\."));
		InputStream in = getClass().getClassLoader().getResourceAsStream(SRC_FOLDER + splitList.get(splitList.size() - 1) + JAVA_EXT);
		if (in != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			try {
				String source = IOUtils.toString(reader);
				AceEditor aceEditor = new AceEditor();
				aceEditor.setValue(source);
				aceEditor.setMode(AceMode.java);
				aceEditor.setTheme(AceTheme.eclipse);
				aceEditor.setSizeFull();
				aceEditor.setReadOnly(true);
				return aceEditor;
			} catch (IOException e) {
				logger.error("Unable to load java source code", e);
			}
		}
		return null;
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
	
	public abstract ActionContainer buildTargetActionContainer();
	
	private class TargetEasyAppLayout extends EasyAppLayout {

		private ActionContainer targetActionContainer;

		public TargetEasyAppLayout(Component targetComponent, ActionContainer targetActionContainer) {
			super();
			this.targetActionContainer = targetActionContainer;
			setSizeFull();
			addComponent(targetComponent);
		}

		@Override
		public ActionContainer buildActionContainer() {
			return targetActionContainer;
		}

		@Override
		public void enterInView(ViewChangeEvent event) {
		
		}
		
		
	}

}
