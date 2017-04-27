<%@page import="com.mppkvvcl.rdu.dao.TabResponseDAO"%>
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
<title> View Details </title>
</head>
<body>
<%
HttpSession httpSession1=request.getSession();

%>

<%if(httpSession1.getAttribute("userbean")!=null){ %>



<%@ include file="viewdetailIntermediate.jsp" %>
	

<jsp:useBean id="listBean" class="com.mppkvvcl.rdu.bean.ListBean" scope="page"/>
<h1>
<%

Object deviceSelected2=request.getParameter("deviceSelected");

boolean hasValueN=false;
String deviceSelectedNow="";
String disableButton="true";

 if(deviceSelected2!=null)
{
	
	 deviceSelectedNow=String.valueOf(deviceSelected2);
	 
	 hasValueN=new TabResponseDAO().checkTabResponseN(deviceSelectedNow);
	 
	 if(hasValueN)
	 {
		 
		disableButton="false"; 
		 
	 }
}


	
//Getting session variables here

  String rduSelected=request.getParameter("deviceSelected");
  ListBean lb2 = new ListBean();
  List<Device> items2 = lb2.getItems();
  List<ViewDetail> viewDetails=new ViewDAO().getAll(rduSelected);
  
%>
</h1>

<div align="center">
<table border="1">
<tr>
<th>Sr No</th>
<th>Device</th>
<th>Name</th>
<th>Account Number</th>
<th>Status</th>
<th>Action </th>

</tr>
 <% 
    for(int i = 0; i< viewDetails.size(); i++){%>
    
    <form action="AddTabResponse" method="post">
    
   <input type="hidden"  name="terminalnumber" value=<%=viewDetails.get(i).getTerminalNumber() %> >
    <input type="hidden"  name="t1" value=<%=viewDetails.get(i).getT1() %> >
     <input type="hidden"  name="t2" value=<%=viewDetails.get(i).getT2() %> >
      <input type="hidden"  name="t3" value=<%=viewDetails.get(i).getT3() %> >
       <input type="hidden"  name="t4" value=<%=viewDetails.get(i).getT4() %> >
        <input type="hidden"  name="t5" value=<%=viewDetails.get(i).getT5() %> >
         <input type="hidden"  name="t6" value=<%=viewDetails.get(i).getT6() %> >
         <input type="hidden"  name="deviceSelected" value=<%=deviceSelectedNow%> >
    <tr >
<td align="center"><%=i+1 %></td>
<td align="center" ><input type="text" value=<%=viewDetails.get(i).getDevice() %> style="text-align: center;" name=devicename readonly="readonly"   ></td>

<td>  <input   type="text" value=<%=viewDetails.get(i).getName() %>  style="text-align: center;" name="name" readonly="readonly"   >    </td>

<td >     <input   type="text" value=<%=viewDetails.get(i).getAccountNumber() %> style="text-align: center;"  name="accountnumber" readonly="readonly"   ></td>

<%if(viewDetails.get(i).getStatus()=="ON") {%>


<th  align="center" >  <input  align=right  size="3" maxlength="3" style="background-color:LightSalmon;text-align: center;" type="text" value=<%=viewDetails.get(i).getStatus() %> name="status" readonly="readonly"   > </th>

<%} else{%>

<th  align="center" > <input align="right"  size="3" maxlength="3"  style="background-color:Aquamarine;text-align: center;" type="text" value=<%=viewDetails.get(i).getStatus() %> name="status" readonly="readonly"   > </th>

<%
}
%>


<%if(viewDetails.get(i).getStatus()=="ON") { %>

<%if(hasValueN) {%>
<td align="center"><input type="submit" align="middle" name="onoff" id="onoff" value="OFF" disabled > </td>

<%} else{%>
<td align="center"><input type="submit" name="onoff" id="onoff" value="OFF" > </td>


<%} %>
<%} else{%>



<%if(hasValueN) {%>

<td align="center"><input type="submit" name="onoff" id="onoff" value="ON" disabled> </td>

<%} else{%>

<td align="center"><input type="submit" name="onoff" id="onoff" value="ON"> </td>


<%} %>





<%
}
%>

</tr>
</form>
 <%}
 
 
 
 %>

</table>




</div>






<%} else{%>
<%

response.sendRedirect("index.html");
}
%>

</body>
</html>