<%@ page language="java" import="java.net.URL" import="java.net.URLConnection" import="java.io.InputStream" import="java.io.IOException" %>
<%@ page import="com.solly.CaliforniaWaterDataVisualizationJSPCode" %>
<title>Updating database</title>
<a href="index.html">Return to home page</a>
Updating database...<br>
<%
CaliforniaWaterDataVisualizationJSPCode.update(request, out);
%>