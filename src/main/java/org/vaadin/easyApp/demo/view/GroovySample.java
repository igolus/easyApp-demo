package org.vaadin.easyApp.demo.view;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.codehaus.groovy.control.CompilationFailedException;
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
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.Eval;

@ContentView(sortingOrder=2, viewName = "Groovy Sample", icon = "FILE_CODE", rootViewParent = ExpRoot.class)
@SuppressWarnings("serial")
public class GroovySample extends DemoLayout {

	public GroovySample() {
		super();
	}


	public void enterInView(ViewChangeEvent event) {
	}



	@Override
	public String getVaadinHomeUrl() {
		return null;
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

		try {

			ScriptEngine engine = new ScriptEngineManager().getEngineByName("Groovy");
			StringWriter out = new StringWriter();
			PrintWriter writer = new PrintWriter(out);
			engine.getContext().setWriter(writer);
			engine.getContext().setErrorWriter(writer);
			engine.eval(aceEditorGroovy.getValue());

			aceEditorResult.setValue(out.toString());
		} catch (CompilationFailedException | ScriptException e) {
			aceEditorResult.setValue(e.getMessage() + System.lineSeparator() + stackTraceToString(e));
		}


	}

	private AceEditor aceEditorGroovy;
	private AceEditor aceEditorResult;

	@Override
	public Component getComponent() {

		HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
		splitPanel.setSizeFull();

		aceEditorGroovy = new AceEditor();

		String script = "def createGreeter = { name ->\r\n" + 
				"  return {\r\n" + 
				"    def day = new Date().getDay()\r\n" + 
				"    if (day == 0 || day == 6) {\r\n" + 
				"      println \"Nice Weekend, $name\"\r\n" + 
				"    } else {\r\n" + 
				"      println \"Hello, $name\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}\r\n" + 
				"def greetWorld = createGreeter(\"World\")\r\n" + 
				"greetWorld()";
		aceEditorGroovy.setValue(script);
		aceEditorGroovy.setMode(AceMode.groovy);
		aceEditorGroovy.setSizeFull();

		aceEditorResult = new AceEditor();
		aceEditorResult.setReadOnly(true);
		aceEditorResult.setSizeFull();

		splitPanel.setFirstComponent(aceEditorGroovy);
		splitPanel.setSecondComponent(aceEditorResult);

		return splitPanel;
	}


	@Override
	public String getTitle() {
		return "Groovy Sample";
	}

	public String stackTraceToString(Throwable e) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append("\n");
		}
		return sb.toString();
	}



}