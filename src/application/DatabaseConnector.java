package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

	private static ArrayList<Stop> stops;
	private static Connection conn;

	// TODO: Add API calls that allows easy DB access

	public static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/softarch", "root", "test");

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> loadStopNames() {
		if (stops == null) {
			loadAllStops();
		}
		ArrayList<String> res = new ArrayList<>();
		for (Stop s : stops) {
			res.add(s.getName());
		}
		return res;
	}

	public static ArrayList<Stop> loadAllStops() {
		if (stops != null) {
			return stops;
		}
		stops = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM stops");
			rs.first();
			while (!rs.isAfterLast()) {
				int id = rs.getInt(1);
				double lon = rs.getDouble(2);
				double lat = rs.getDouble(3);
				String name = rs.getString(4);
				stops.add(new Stop(id, lon, lat, name));
				rs.next();
			}

		} catch (Exception e) {
		}
		return stops;
	}
}
