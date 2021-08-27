<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcomponent/allCss.jsp" %>
</head>
<body>
<%@include file="allcomponent/navbar.jsp" %>

<% if(user==null) 
{
	session.setAttribute("invalidMsg", "Login Fisrt");
	response.sendRedirect("login.jsp");	
}
%>

<div class="container-fluid">
<div class="row p-2">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h4 class="text-center text-success">Add Contact Page</h4>

<%String succMsg=(String)session.getAttribute("succMsg"); 
	String failedMsg=(String)session.getAttribute("failedMsg");
if(succMsg!=null){
%>

	<p class="text-success text-center"><%=succMsg %></p>
<% 
session.removeAttribute("succMsg");
}

if(failedMsg!=null){
%>

	<p class="text-danger text-center"><%=failedMsg %></p>
<% 
session.removeAttribute("failedMsg");
}
%>
<form action="addContact" method="post">

<%
if(user!=null)
{%>
<input type="hidden" value="<%=user.getId() %>" name="userid">
<%}
%>

  <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputName" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Enter Phone Number</label>
    <input type="text" name="phno" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <button type="submit" class="btn btn-primary">Save Contact</button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>