<%@ page language="java" import="com.solly.californiawaterdatavisualization.JavaCode" %>
<title>Updating database</title>
<a href="index.html">Return to home page</a>
<br>
Updating database...<br>
<%
JavaCode.updateDB(request, out);
%>