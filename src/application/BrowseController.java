package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.input.KeyEvent;

public class BrowseController implements Initializable {

	@FXML private TextArea stopList;
	@FXML private CheckBox nameCheck;
	@FXML private TextField nameInput;
	@FXML private CheckBox longitudeCheck;
	@FXML private TextField longitudeInput;
	@FXML private RadioButton longitudeAbove;
	@FXML private CheckBox latitudeCheck;
	@FXML private TextField latitudeInput;
	@FXML private RadioButton latitudeAbove;
	@FXML private Button refreshButton;

	private ArrayList<String> stops = DatabaseConnector.loadAllStops();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		stopList.setText(""); // add stops to TextArea
		for (String s : stops) {
			stopList.appendText(s + '\n');
		}
		stopList.positionCaret(0); // scrolls to top
	}

	/**
	 * 
	 * @param name
	 *            The name of the stop, or "" if it is empty
	 * @param latitude
	 *            The latitude String: "", "above", or "below"
	 * @param longitude
	 *            The longitude String: "", "above", or "below"
	 * @param lat
	 *            Latitude double value, ignored if latitude equals ""
	 * @param long
	 *            Longtitude double value, ignored if longitude equals ""
	 */
	private void refreshStops(String name, String latitude, String longitude, double lat, double lon) {
		CopyOnWriteArrayList<String> clone = new CopyOnWriteArrayList<>(stops);
		if (nameCheck.isSelected() && !name.equals("")) {
			for (String s : clone) {
				if (!s.matches("(?i).*" + name + ".*")) { // case-insensitive
					clone.remove(s);
				}
			}
		}
		stopList.setText("");
		for (String s : clone) {
			stopList.appendText(s + '\n');
		}
		stopList.selectPositionCaret(0); // scroll to top
		stopList.deselect();

		// TODO: handle latitude and longitude
	}

	public void liveRefreshStops(KeyEvent event) {
		String name = nameInput.getText();
		refreshStops(name, "", "", 0.0, 0.0);
	}

	public void handleRefreshAction(ActionEvent event) {
		String name = "";
		String latitude = "";
		String longitude = "";
		double lat = 0d;
		double lon = 0d;
		name = nameInput.getText();
		if (latitudeCheck.isSelected()) {
			if (!latitudeInput.getText().equals("")) {
				lat = Double.parseDouble(latitudeInput.getText());
			}
			if (latitudeAbove.isSelected()) {
				latitude = "above";
			} else {
				latitude = "below";
			}
		}
		if (longitudeCheck.isSelected()) {
			if (!longitudeInput.getText().equals("")) {
				lon = Double.parseDouble(longitudeInput.getText());
			}
			if (longitudeAbove.isSelected()) {
				longitude = "above";
			} else {
				longitude = "below";
			}
		}
		refreshStops(name, latitude, longitude, lat, lon);
	}

}
