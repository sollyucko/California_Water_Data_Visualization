<%@ page language="java" %>
<%
boolean time_date = request.getParameter("time_date") != null;
boolean lat = request.getParameter("lat") != null;
boolean lon = request.getParameter("lon") != null;
%>
<title>California Water Data Table</title>
<table>
	<thead><tr>
		<% if(time_date) out.print("<td>Time and Date</td>"); %>
		<% if(lat) out.print("<td>Latitude</td>"); %>
		<% if(lon) out.print("<td>Longitude</td>"); %>
	</tr></thead>
	<tbody>
		<%
		
		%>
	</tbody>
</table>