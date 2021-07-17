<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%-- <meta charset="ISO-8859-1">--%>
<meta charset="utf-8">
	<title>Animated Login Form</title>
	<iframe width="0" height="0" src="" frameborder="0" allowfullscreen></iframe>
	<style>
		body{  
	margin: 0;
	padding: o;
	/*font-family: sans-serif;
	background-image: url(pic1.jpg);
	background-size: cover;*/
	
	background:linear-gradient(45deg,#8500ff,#5aca);
	height: 100vh;
}
.box{
	width: 400px;
	padding: 40px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	background: black;
	text-align: center;	
	box-shadow: 12px 15px #bfbebb;
}
.box h1{
	color: white;
	text-transform: uppercase;
	font-weight: 500;
	text-decoration: underline;
	 text-decoration-color: #1affd1;
}
.box input{
border: 0;
background: none;
display: block;	
margin: 20px auto;
text-align: center;
border:2px solid #3498db;
padding: 14px 10px;
width: 200px;
outline:none;
color: white;
border-radius: 24px;
transition:0.25s;
}
.box input:focus{
width: 280px;
border-color:#2ecc71;
}
.box input[type="submit"]{
border: 0;
background: none;
display: block;	
margin: 20px auto;
text-align: center;
border:2px solid #2ecc71;
padding: 14px 40px;
outline: none;
color: white;
border-radius: 24px;
transition:0.25s;
cursor: pointer;
}	
.box input[type="submit"]:hover{
	background: #2ecc71;
}
a
{
	color: white;
}
a:hover{
	color: #1affd1 ;
}
	</style>
</head>


<body>
	<form class="box" action="Register" method="GET">
 <h1>Login</h1>
 <input type="text" name="fname" placeholder="Username">
 <input type="email" name="email" placeholder="Email">
 <input type="text" name="phone" placeholder="Phone">
 <input type="password" name="password" placeholder="Password">
 <input type="submit" name="submit" value="Login">
 <p style="color:white;"><input type="checkbox" name="" checked ="checked" color="black">Remember me.   
 <a href="#" >Forgot Password ?</a></p>
</form>
</body>
</html>