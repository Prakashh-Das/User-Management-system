<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>JSP Tags</h1></center>
	
	<%!
	int a=5;
	int b=6;
	%>
	
	
	<%
	if(a>b)
	{
		out.print(a+" is greater");
	}
	else
	{
		out.print(b+" is greater");
	}
	%>
	
	<br>
	<%="sum is "+a+b%>
</body>
</html>