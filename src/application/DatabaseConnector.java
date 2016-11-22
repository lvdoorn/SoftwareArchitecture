package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseConnector {
	
	private static ArrayList<String> stops;
	
	
	// TODO: Add API calls that allows easy DB access
	
	
	
	public static ArrayList<String> loadAllStops() {
		if (stops != null) {
			return stops;
		}
		ArrayList<String> stops = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("resources/routes.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			stops.add(sc.nextLine());
		}
		stops.remove(0); // remove header line
		return stops;
	}
}
