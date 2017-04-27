<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>



<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
</head>
<body>
<%
HttpSession httpSession=request.getSession();

%>

<%if(httpSession.getAttribute("userbean")!=null){ %>
<br><br>

<div align="center" >
<p>
<font size="10">
<a  href="adddevice.jsp">Add Device</a>

<br><br>
<a href="addconsumers.jsp">Add Consumer</a>

<br><br>
<a href="viewdetailIntermediate.jsp">View Detail</a>

</font>
</p>
</div>
<br>
<a href="logout.jsp" >logout</a>

<%} else{%>
<%

response.sendRedirect("index.html");
}
%>


</body>
</html>