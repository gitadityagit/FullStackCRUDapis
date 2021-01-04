<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Form</title>
</head>
<body>
	<h1 class="jumbotron text-center p-1">CRUD Operations</h1>
	<div class="container">
		<a href="/getAllRecords"><button class="btn btn-dark">see
				all records in database</button></a><br>
		<br>

		<h6>
			Use this form to <u>add record</u> into the database
			<spam class="badge badge-success">(CREATE)</spam>
		</h6>
		<form action="/addRecord">
			<input type="text" placeholder="id" name="id"><br> <input
				type="text" placeholder="name" name="name"><br> <input
				type="submit" value="submit">
		</form>
		<br>

		<h6>
			Use this form to <u>get record using Employee id</u> from the
			database
			<spam class="badge badge-primary">(RETRIEVE)</spam>
		</h6>
		<form action="/getRecord">
			<input type="text" placeholder="id" name="id"><br> <input
				type="submit" value="submit">
		</form>
		<br>

		<h6>
			Use this form to <u>update record</u> from the database
			<spam class="badge badge-warning">(UPDATE)</spam>
		</h6>
		<form action="/updateRecord">
			<input type="text" placeholder="id" name="id"><br> <input
				type="text" placeholder="name" name="name"><br> <input
				type="submit" value="submit">
		</form>
		<br>

		<h6>
			Use this form to <u>delete record</u> from the database
			<spam class="badge badge-danger">(DELETE)</spam>
		</h6>
		<form action="/deleteRecord">
			<input type="text" placeholder="id" name="id"><br> <input
				type="submit" value="submit">
		</form>
		<br>
	</div>
</body>
</html>