package com.solly.californiawaterdatavisualization;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.sqlite.JDBC;

import com.solly.parser.PSVParser;


public abstract class JavaCode {
	public static boolean	isDBRegistered	= false;
	public static String	dbURL			= "jdbc:sqlite:California_Water_Data.db";
	
	static void registerDB() throws SQLException {
		if( !isDBRegistered) {
			DriverManager.registerDriver(new JDBC());
			isDBRegistered = true;
		}
	}
	
	static public void updateDB(HttpServletRequest request, JspWriter out) throws SQLException, IOException {
		try(Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:California_Water_Data.db")) {
			if(request.getParameter("caldata-surface-toxic") != null) {
				URL url = new URL("https://data.ca.gov/sites/default/files/Surface_Water_Toxicity_2001_2015.txt");
				URLConnection urlConnection = url.openConnection();
				try(InputStream inputStream = urlConnection.getInputStream()) {
					byte[] data = new byte[urlConnection.getContentLength()];
					inputStream.read(data);
					String content = new String(data);
					PSVParser.parseFile(content);
				}
			}
			out.println("Finished retrieving data from data.ca.gov's 2001 to 2015 surface water toxicity record<br>");
		}
	}
	
	static public Connection connectToDB() throws SQLException {
		return DriverManager.getConnection(dbURL);
	}
}
