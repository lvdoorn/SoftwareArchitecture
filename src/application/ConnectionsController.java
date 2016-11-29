package application;

import java.net.URL;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ConnectionsController implements Initializable {

	@FXML private ComboBox<String> firstChoice;
	@FXML private ComboBox<String> secondChoice;
	@FXML private Button searchButton;
	@FXML private TextArea display;

	private ArrayList<Stop> stops = DatabaseConnector.loadAllStops();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<String> stopNames = new ArrayList<String>();
		for (int i = 0; i < stops.size(); i++) {
			String s = stops.get(i).getName() + " " + stops.get(i).getId();
			stopNames.add(s);
		}
		ObservableList<String> obsList = FXCollections.observableArrayList(stopNames);
		obsList = obsList.sorted();
		System.out.println(obsList);
		firstChoice.setItems(obsList);
		secondChoice.setItems(obsList);
		firstChoice.setPlaceholder(new Label("No stops to show"));
		secondChoice.setPlaceholder(new Label("No stops to show"));
	}

	public void handleSearchAction(ActionEvent event) {
		String stop1 = firstChoice.getValue();
		String stop2 = secondChoice.getValue();
		System.out.println(stop1);
		System.out.println(stop2);
		Stop s1 = DatabaseConnector.getStopById(Integer.valueOf(stop1.substring(stop1.lastIndexOf(" ") + 1)));
		Stop s2 = DatabaseConnector.getStopById(Integer.valueOf(stop2.substring(stop2.lastIndexOf(" ") + 1)));
		System.out.println(s1);
		System.out.println(s2);
		if (s1 != null && s2 != null) {
			ArrayList<String> result = DatabaseConnector.checkRoute(s1, s2);
			if (result.isEmpty()) {
				display.setText("No lines found");
			} else {
				display.setText("");
				for (String s : result) {
					display.appendText(s + '\n');
				}
			}
		}
	}

}
