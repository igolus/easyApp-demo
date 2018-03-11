package org.vaadin.easyApp.demo.view;

import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.EasyAppLayout;
import org.vaadin.easyapp.util.EasyAppView;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=1, viewName = "Tree", icon = "ANCHOR", rootViewParent = HomeRoot.class, componentParent = ViewOne.class)
@SuppressWarnings("serial")
public class ViewThree extends EasyAppLayout  {

	public ViewThree() {
		setSpacing(true);

		Tree<String> tree = new Tree<>();
		TreeData<String> treeData = new TreeData<>();

		// Couple of childless root items
		treeData.addItem(null,"Mercury");
		treeData.addItem(null,"Venus");

		// Items with hierarchy
		treeData.addItem(null,"Earth");
		treeData.addItem("Earth","The Moon");

		TreeDataProvider inMemoryDataProvider = new TreeDataProvider<>(treeData);
		tree.setDataProvider(inMemoryDataProvider);
		tree.expand("Earth"); // Expand programmatically
		addComponent(tree);

	}

	public void enter(ViewChangeEvent event) {
		Notification.show("Entering view 1");
	}

	@Override
	public ActionContainer buildActionContainer() {
		// TODO Auto-generated method stub
		return null;
	}

}