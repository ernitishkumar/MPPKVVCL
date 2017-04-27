<%@page import="com.mppkvvcl.rdu.bean.ViewDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.mppkvvcl.rdu.bean.ListBean" %>
<%@ page import="com.mppkvvcl.rdu.bean.Device" %>
<%@ page import="com.mppkvvcl.rdu.bean.ViewDetail" %>
<%@ page import="com.mppkvvcl.rdu.dao.ViewDAO" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RDU Data Details</title>
</head>
<body>

<%
HttpSession httpSession=request.getSession();

%>

<%if(httpSession.getAttribute("userbean")!=null){ %>

<h1>
<%
 ListBean lb1 = new ListBean();
 List<Device> items1 = lb1.getItems();
Object deviceSelected3=request.getParameter("deviceSelected");
String  deviceSelectedNow1 = null;
if(deviceSelected3!=null)
{
	 deviceSelectedNow1=String.valueOf(deviceSelected3);	
	 
}
%>
</h1>

<div align="center">

<table>

<tr>

<td>Please select Device Here..</td>

<td>

<form action="viewdetail.jsp" method="post" name="myForm">

<select name="deviceSelected">
       <option>select </option>
    <% 
    for(int i = 0; i< items1.size(); i++){
    	
    	if(deviceSelectedNow1 != null && items1.get(i).getDevice().equals(deviceSelectedNow1)){%>
    	  <option  selected value=<%=items1.get(i).getDevice()%>><%= items1.get(i).getDevice() %></option>
    	<%}else{%>
    		<option value=<%=items1.get(i).getDevice()%>><%= items1.get(i).getDevice() %></option>
    	<% }
    }  %>
</select>
<input type="submit" value="GetDetail" name="getdtl">


<script type="text/javascript">



setTimeout("document.myForm.submit();",30000);


</script>



</form>

</td>
</tr>

</table>








</div>
<a href="home.jsp">home</a><br><br>
<a href="logout.jsp" >logout</a>

<%} else{%>
<%

response.sendRedirect("index.html");
}
%>



</body>
</html>