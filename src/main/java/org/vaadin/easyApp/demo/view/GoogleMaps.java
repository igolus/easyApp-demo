package org.vaadin.easyApp.demo.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.vaadin.easyApp.demo.DemoLayout;
import org.vaadin.easyapp.util.ActionContainer;
import org.vaadin.easyapp.util.ActionContainer.InsertPosition;
import org.vaadin.easyapp.util.ActionContainer.Position;
import org.vaadin.easyapp.util.ActionContainerBuilder;
import org.vaadin.easyapp.util.annotations.ContentView;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

@ContentView(sortingOrder=1, viewName = "GoogleMaps", icon = "MAP_MARKER", rootViewParent = MapRoot.class)
@SuppressWarnings("serial")
public class GoogleMaps extends DemoLayout {
	//Please get you own key from https://developers.google.com/maps/documentation/javascript/get-api-key
	private static final String GOOGLE_KEY = "AIzaSyCWrgCsop8-1HEYJdp5QVZl6cR7ShzfMDc";
	private GoogleMap googleMap;
	private TextField searchTextField;
;
	private static Logger logger = Logger.getLogger(GoogleMaps.class);
	
	public GoogleMaps() {
		super();
		//VaadinIcons.FILE_CODE
	}
	
	@Override
	public Component getComponent() {
		
		googleMap = new GoogleMap(GOOGLE_KEY, null, "english");
		googleMap.setSizeFull();
		googleMap.addMarker("DRAGGABLE: Paavo Nurmi Stadion", new LatLon(
		        60.442423, 22.26044), true, "VAADIN/1377279006_stadium.png");
		googleMap.addMarker("DRAGGABLE: Kakolan vankila",
		        new LatLon(60.44291, 22.242415), true, null);
		googleMap.addMarker("NOT DRAGGABLE: Iso-Heikkilä", new LatLon(
		        60.450403, 22.230399), false, null);
		googleMap.setMinZoom(4);
		googleMap.setMaxZoom(16);
		googleMap.setSizeFull();
		//layout.setSizeFull();
		return googleMap;
	}


	public void enterInView(ViewChangeEvent event) {
	}



	@Override
	public String getVaadinHomeUrl() {
		return "https://vaadin.com/directory/component/googlemaps-add-on";
	}

	public ActionContainer buildTargetActionContainer() {
		//This is how we can add interactive components in the view
		
		//Add a button targeting search method
		ActionContainerBuilder builder = new ActionContainerBuilder(null)
				.addButton(VaadinIcons.SEARCH, this::search, Position.RIGHT);
		
		searchTextField = new TextField();
		//add the text field
		builder.addComponent(searchTextField, Position.RIGHT, InsertPosition.BEFORE);
		Label label = new Label("Search somewhere: ");
		builder.addComponent(label, Position.RIGHT, InsertPosition.BEFORE);
		return builder.build();
	}
	
	/**
	 * Click on search
	 * @param event
	 */
	public void search(ClickEvent event) {
		//use google API
		URI uri;
		try {
			uri = new URIBuilder()
			        .setScheme("https")
			        .setHost("maps.googleapis.com")
			        .setPath("/maps/api/geocode/json")
			        .setParameter("address", URLEncoder.encode(searchTextField.getValue(), "UTF-8"))
			        .setParameter("key", GOOGLE_KEY)
			        .build();
			HttpGet httpget = new HttpGet(uri);
			HttpClient client = HttpClientBuilder.create().build();
			
			HttpResponse response = client.execute(httpget);

			BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			JSONObject obj = new JSONObject(result.toString());
			double limitNElat =obj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("bounds")
					.getJSONObject("northeast").getDouble("lat");
			double limitNElng = obj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("bounds")
					.getJSONObject("northeast").getDouble("lng");
			
			double limitSWlat =obj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("bounds")
					.getJSONObject("southwest").getDouble("lat");
			double limitSWlng =obj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("bounds")
					.getJSONObject("southwest").getDouble("lng");
			
			googleMap.setVisibleAreaBoundLimits(new LatLon(limitNElat, limitNElng), new LatLon(limitSWlat, limitSWlng));
		} catch (Exception e) {
			logger.error("Unable to get location", e);
		} 		
		
	}

	@Override
	public String getTitle() {
		return "GoogleMaps";
	}



}