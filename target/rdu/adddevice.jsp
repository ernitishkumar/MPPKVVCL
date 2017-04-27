<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Device Details</title>
</head>
<body>

<%
HttpSession httpSession=request.getSession();

%>

<%if(httpSession.getAttribute("userbean")!=null){ %>


<h3 align="center">Add Device Page</h3>
<form action="AddDevice" method="post" >

<div align="center">
<table >
<tr><td><label>Device Name    :</label></td><td>     <input style="text-align: right"  type="text" required="required"  name="device"></td></tr><br>

<tr><td><label>Name of Feeder :</label> </td>	<td>     <input type="text" required="required" name="nameoffeeder" ></td></tr><br>

<tr><td><label>Pole Number    :</label>	</td><td>     <input   type="text" required="required" name="polenumber" ></td></tr><br>

<tr><td><label>Date of installation :</label></td> <td>  <input type="date" required="required" name="dateofinstallation"></td></tr><br>

<tr><td><label>Zone Name :</label>   </td>     <td>      <input type="text" required="required" name="zonename" ></td></tr><br>

<tr><td>Sim No. : </td><td>               <input type="text" required="required" name="simnumber" ></td></tr><br>
<tr><td></td></tr>
<tr></tr>
 <tr><td></td> <td>    <input type="submit" value="Add Device"  ></td></tr>

</table>
</div>
</form>
<a href="home.jsp">home</a><br><br>
<a href="logout.jsp" >logout</a>

<%} else{%>
<%

response.sendRedirect("index.html");
}
%>








</body>
</html>