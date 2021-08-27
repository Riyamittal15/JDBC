<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcomponent/allCss.jsp" %>
</head>
<body style="background-color:#f7faf8;">
<%@include file="allcomponent/navbar.jsp" %>
<div class="container-fluid">
<div class="row p-2">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h4 class="text-center text-success">Registration Page</h4>
<%String succ=(String)session.getAttribute("succ"); 
	String error=(String)session.getAttribute("error");
if(succ!=null){
%>

	<p class="text-success text-center"><%=succ %></p>
<% 
session.removeAttribute("succ");
}

if(error!=null){
%>

	<p class="text-danger text-center"><%=error %></p>
<% 
session.removeAttribute("error");
}
%>
<h6></h6>
<form action="register" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputName" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" >
  </div>
  <button type="submit" class="btn btn-primary">Register</button>
</form>
</div>
</div>
</div>
</div>
</div>
<div style="margin-top:120px;">
<%@ include file="allcomponent/footer.jsp" %>
</div>
</body>
</html>