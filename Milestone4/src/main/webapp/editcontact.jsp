<%@page import="com.entity.Contact"%>
<%@page import="com.conn.Dbconnect"%>
<%@page import="com.dao.ContactDao"%>
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
<h4 class="text-center text-success">Edit Contact</h4>

<%
	String failedMsg=(String)session.getAttribute("failedMsg");
if(failedMsg!=null){
%>

	<p class="text-danger text-center"><%=failedMsg %></p>
<% 
session.removeAttribute("failedMsg");
}
%>
<form action="update" method="post">

<%
int cid=Integer.parseInt(request.getParameter("cid"));
ContactDao dao=new ContactDao(Dbconnect.getConn());
Contact c=dao.getContactByID(cid);
%>

<input type="hidden" value="<%=cid%>" name="cid">

  <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input value="<%=c.getName() %>" type="text" name="name" class="form-control" id="exampleInputName" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Email address</label>
    <input value="<%=c.getEmail() %>" type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Enter Phone Number</label>
    <input value="<%=c.getPhno() %>" type="text" name="phno" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="text-center mt-2">
  <button type="submit" class="btn btn-primary">Update Contact</button>
  </div>
  
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>