<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Bill"%>
<%@page import="com.BillAPI"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inquery</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container">

			</form>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<div class="container">
<div class="card">
	<div class="row justify-content-center">
			<div class="col-6"><br>
	<br>
				<h1>ADD Inquery</h1>
<br><br>
				<form id="formLogin">
					Enter Username: <input id="txtUsername" name="txtUsername"
						type="text" class="form-control form-control-sm"><br>
					Enter ACC.Number: <input id="txtACC" name="txtACC"
						type="text" class="form-control form-control-sm"> <br>
					Enter Date: <input id="txtDate" name="txtDate"
						type="text" class="form-control form-control-sm"> <br>
					Enter INQ.Rerson: <input id="txtRerson" name="txtRerson"
						type="text" class="form-control form-control-sm"> <br>
					Enter Description: <input id="txtDes" name="txtDes"
						type="text" class="form-control form-control-sm"> <br>
					Enter Email: <input id="txtEmail" name="txtEmail"
						type="text" class="form-control form-control-sm"> <br>
						
					<input id="btnLogin" name="btnLogin" type="button" value="Submit"
						class="btn btn-primary btn-lg active"> <br> <br><br>
	<br>
					<div id="alertError" class="alert alert-danger"></div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
