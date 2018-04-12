package org.vaadin.easyApp.demo.view;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.easyApp.demo.DemoLayout;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BarChartConfig;
import com.byteowls.vaadin.chartjs.data.BarDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.options.Position;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@ContentView(sortingOrder=2, viewName = "ChartJS", icon = "CHART", rootViewParent = GraphsRoot.class)
@SuppressWarnings("serial")
public class ChartJS extends DemoLayout {

	public ChartJS() {
		super();
	}


	public void enterInView(ViewChangeEvent event) {
		Notification.show("Entering in Chart JS");
	}



	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/directory/component/chartjs-add-on";
	}


	public ActionContainer buildTargetActionContainer() {
		//No button in top bar
		return null;

	}


	@Override
	public Component getComponent() {
		//code from grabbed from https://github.com/moberwasserlechner/vaadin-chartjs
		BarChartConfig config = new BarChartConfig();
		config
		.data()
		.labels("January", "February", "March", "April", "May", "June", "July")
		.addDataset(new BarDataset().type().label("Dataset 1").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
		.addDataset(new LineDataset().type().label("Dataset 2").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
		.addDataset(new BarDataset().type().label("Dataset 3").backgroundColor("rgba(220,220,220,0.5)"))
		.and();

		config.
		options()
		.responsive(true)
		.title()
		.display(true)
		.position(Position.LEFT)
		.text("Chart.js Combo Bar Line Chart")
		.and()
		.done();

		List<String> labels = config.data().getLabels();
		for (Dataset<?, ?> ds : config.data().getDatasets()) {
			List<Double> data = new ArrayList<>();
			for (int i = 0; i < labels.size(); i++) {
				data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
			}

			if (ds instanceof BarDataset) {
				BarDataset bds = (BarDataset) ds;
				bds.dataAsList(data);    
			}

			if (ds instanceof LineDataset) {
				LineDataset lds = (LineDataset) ds;
				lds.dataAsList(data);    
			}
		}

		ChartJs chart = new ChartJs(config);
		chart.setJsLoggingEnabled(true);
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		chart.setWidth("800px");
		chart.setHeight("600px");
		layout.addComponent(chart);
		layout.setComponentAlignment(chart, Alignment.MIDDLE_CENTER);
		return layout;
	}


	@Override
	public String getTitle() {
		return "ChartJS";
	}



}