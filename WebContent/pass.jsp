<%@ page import="java.io.*,java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
		String count = request.getParameter("ver");
		out.println(count);
		out.println("<img style='border:5px solid black;position: relative; left:7%' width='70%' height='90%'  src=displayphoto?name=" +count+ "></img> <p/>");
%>