package org.vaadin.easyApp.demo.view;

import java.util.Arrays;

import org.vaadin.easyApp.demo.DemoLayout;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.ActionContainer.Position;
import org.vaadin.easyapp.util.ActionContainerBuilder;
import org.vaadin.easyapp.util.annotations.ContentView;
import org.vaadin.simplemde.SimpleMarkdownEditor;
import org.vaadin.simplemde.SimpleMarkdownToolbarIcon;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;

@ContentView(sortingOrder=2, viewName = "SimpleMDE", icon = "EDIT", rootViewParent = EditorRoot.class)
@SuppressWarnings("serial")
public class MDEditor extends DemoLayout {

	public MDEditor() {
		super();
	}


	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/directory/component/simplemde";
	}


	public ActionContainer buildTargetActionContainer() {
		ActionContainerBuilder builder = new ActionContainerBuilder(null)
				.addButton(VaadinIcons.ERASER, e -> editor.setValue(""), Position.RIGHT)
				.addButton(VaadinIcons.EYE, e -> editor.setPreview(!editor.isPreview()), Position.RIGHT)
				.addButton(VaadinIcons.CODE, e -> Notification.show(editor.getValue()), Position.RIGHT);
		return builder.build();
	}

	
	private SimpleMarkdownEditor editor;

	@Override
	public Component getComponent() {
		
		editor = new SimpleMarkdownEditor();
        editor.setHideIcons(Arrays.asList(SimpleMarkdownToolbarIcon.GUIDE, SimpleMarkdownToolbarIcon.FULLSCREEN, SimpleMarkdownToolbarIcon.SIDE_BY_SIDE));
        editor.setValue("# Hello World \nwe can write markdown!");
        editor.setShowStatus(false);
        //editor.addValueChangeListener(e -> Notification.show(e.getValue(), Notification.Type.TRAY_NOTIFICATION));
        editor.setSizeFull();
        return editor;    
	}


	@Override
	public String getTitle() {
		return "SimpleMDE";
	}



}