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

public class ConnectionsController implements Initializable {

	@FXML
	private ComboBox<String> firstChoice;
	@FXML
	private ComboBox<String> secondChoice;
	@FXML
	private Button searchButton;
	
	private ArrayList<String> stops = DatabaseConnector.loadAllStops();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> obsList = FXCollections.observableArrayList(stops);
		firstChoice.setItems(obsList);
		secondChoice.setItems(obsList);
		firstChoice.setPlaceholder(new Label("No stops to show"));
		secondChoice.setPlaceholder(new Label("No stops to show"));
	}
	
	public void handleSearchAction(ActionEvent event) {
		String stop1 = firstChoice.getValue();
		String stop2 = secondChoice.getValue();
		// TODO show the lines if they exist
	}

}
