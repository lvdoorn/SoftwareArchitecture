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

public class NewLineController implements Initializable {
	
	@FXML private ScrollPane scrollPane;
	@FXML private Button addButton;
	@FXML private Label resultMessage;
	
	private ArrayList<String> stopNames = DatabaseConnector.loadStopNames();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		VBox vbox = new VBox();
		ArrayList<CheckBox> boxes = new ArrayList<>();
		for (String s : stopNames) {
			boxes.add(new CheckBox(s));
		}
		for (int i = 0; i < boxes.size(); i++) {
			vbox.getChildren().add(boxes.get(i));
		}
		scrollPane.setContent(vbox);
	}
}
