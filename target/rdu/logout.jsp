<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<%
HttpSession httpSession=request.getSession();

%>

<%if(httpSession.getAttribute("userbean")!=null){ %>


<%
	
HttpSession currentSession=request.getSession();
currentSession.invalidate();


response.sendRedirect("index.html");

%>

<%} else{%>
<%

response.sendRedirect("index.html");
}
%>

</body>
</html>