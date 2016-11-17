<%@ page language="java" import="java.net.URL" import="java.net.URLConnection" import="java.io.InputStream" import="java.io.IOException" %>
<%@ page import="com.solly.parsers.PSVParser" %>
<title>Updating database</title>
<a href="index.html">Return to home page</a>
Updating database...<br>
<%
if(request.getParameter("caldata-surface-toxic") != null) {
	URL url = new URL("https://data.ca.gov/sites/default/files/Surface_Water_Toxicity_2001_2015.txt");
	URLConnection connection = url.openConnection();
	InputStream inputStream = connection.getInputStream();
	try {
		byte[] data = new byte[connection.getContentLength()];
		inputStream.read(data);
		String content = new String(data);
		PSVParser.parseFile(content);
	} catch(IOException e) {
		inputStream.close();
		throw e;
	}
}
out.println("Finished retrieving data from data.ca.gov's 2001 to 2015 surface water toxicity record<br>");
%>