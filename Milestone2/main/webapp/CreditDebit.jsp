<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit-Debit</title>
        <style>
            h1{
                padding-top: 20px;
                color:rgb(243, 24, 152);
            }
            .container{
                padding:80px;
                margin-top:100px;
                margin-bottom: 100px;
                background: linear-gradient(45deg,#8500ff,#5aca);  /*45deg, #2ecc71, #16a085*/
            }
            .col{
                text-align:center;
                margin:0px 60px;
                background: white;
                padding:70px;
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<h1 class="display-3 text-center">Welcome!!</h1>
        <div class="container">
            <div class="row align-items-center">
                <div class="col">Credit Portal<br>
                <form action="credit" method="post">
                User:<input type="text" name="userID" placeholder="User" />
                <br> Credit Amount: <input type="text" name="camt" placeholder="Amount" />
                <button>Credit</button>
                </form>
                </div>
                <div class="col">Debit Portal<br>
                <form action="debit" method="post">
                 Debit Amount: <input type="text" name="damt" placeholder="Amount" />
                </form>
                </div>
              </div>
        </div>
</body>
</html>