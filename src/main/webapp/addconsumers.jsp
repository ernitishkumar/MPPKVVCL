<%@ page import="com.mppkvvcl.rdu.bean.ListBean" %>
<%@ page import="com.mppkvvcl.rdu.bean.Device" %>

<%@ page import="java.util.List" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Consumer Details</title>
</head>
<body>
<%
HttpSession httpSession=request.getSession();

%>

<%if(httpSession.getAttribute("userbean")!=null){ %>

<jsp:useBean id="listBean" class="com.mppkvvcl.rdu.bean.ListBean" scope="page"/>
<h1>
<%
  ListBean lb = new ListBean();
  List<Device> items = lb.getItems();
%>
</h1>

<form action="AddConsumer" method="post">
<div align="center">
<table>
<tr>

<td><label>Select Device :</label></td>
<td>
<select name="deviceSelected">
    <% 
       for(int i = 0; i< items.size(); i++){%>
       <option  value=<%=items.get(i).getDevice()%> > <%=items.get(i).getDevice() %></option>
    <%} %>
</select>
</td>
</tr>

<tr>
<td><label>Account Number:</label></td>		<td><input type="text" name="accountnumber" required="required"></td><br>
</tr>

<tr>
<td><label>Name :</label>            </td>	<td><input type="text" name="name" required="required"></td><br>
</tr>

<tr>
<td><label>Address:      </label>     	</td><td><input type="text" name="address" required="required"></td><br>
</tr>

<tr>
<td><label>Pole Number:      </label>	</td><td><input type="text" name="polenumber" required="required"></td><br>
</tr>

<tr>
<td><label>Terminal Number : </label> </td>	<td><input type="text" name="terminalnumber" required="required"></td><br>
</tr>

<tr>
<td>Click to add : </td><td><input type="submit" value="Add Consumer"></td>
</tr>

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