<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- including external css --%>
<link rel="stylesheet" href="<%= application.getContextPath() %>/css/style.css">

</head>
<body>

<div class ="container">
<%@include file="menu.jsp" %>


<h1>Welcome To Servlet Crash Course</h1>
<p>This is very information video about servlet</p>


<form action="<%= application.getContextPath() %> /third" method ="post">

<input type="text" placeholder="Enter Text Here" name="message">
   <button type = "submit">Submit</button>

</form>




</div>

<script type="text/javascript" src="<%= application.getContextPath() %>/js/script.js"></script>
</body>
</html>