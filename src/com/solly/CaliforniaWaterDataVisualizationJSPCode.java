package com.solly;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import com.solly.parser.PSVParser;

public abstract class CaliforniaWaterDataVisualizationJSPCode {
	static public void update(HttpServletRequest request, JspWriter out) throws IOException {
		if(request.getParameter("caldata-surface-toxic") != null) {
			URL url = new URL("https://data.ca.gov/sites/default/files/Surface_Water_Toxicity_2001_2015.txt");
			URLConnection connection = url.openConnection();
			try(InputStream inputStream = connection.getInputStream()) {
				byte[] data = new byte[connection.getContentLength()];
				inputStream.read(data);
				String content = new String(data);
				PSVParser.parseFile(content);
			}
		}
		out.println("Finished retrieving data from data.ca.gov's 2001 to 2015 surface water toxicity record<br>");
	}
}
