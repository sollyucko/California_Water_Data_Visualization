<%@ page language="java" import="com.solly.CaliforniaWaterDataVisualizationJSPCode" %>
<title>Updating database</title>
<a href="index.html">Return to home page</a>
<br>
Updating database...<br>
<%
CaliforniaWaterDataVisualizationJSPCode.update(request, out);
%>