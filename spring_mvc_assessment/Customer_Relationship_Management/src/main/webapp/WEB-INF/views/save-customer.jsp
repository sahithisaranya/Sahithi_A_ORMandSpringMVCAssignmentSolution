<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Add customer form</title>
<style>
h1 {
	text-align: center;
	font-weight: 200;
	font-size: 40px;
	font-style: italic;
	background-color: rgb(116, 77, 4);
	color: beige;
}

h3 {
	text-align: left;
	font-weight: bold;
	font-size: 30px;
	font-style: normal;
	color: black;
}
</style>
</head>
<body>
	<h1>Customer Relationship Management</h1>

	<div class="container">

		<h3>Save Customer</h3>
		<hr>

		<p class="h4 mb-4"></p>

		<form action="/Customer_Relationship_Management/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="customer_id"
				value="${Customer.customer_id}" />

			<div class="form-inline">
				<input type="text" name="first_name" value="${Customer.first_name}"
					class="form-control mb-4 col-4" placeholder="First Name: ">
			</div>

			<div class="form-inline">
				<input type="text" name="last_name" value="${Customer.last_name}"
					class="form-control mb-4 col-4" placeholder="Last Name: ">
			</div>

			<div class="form-inline">
				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email: ">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Customer_Relationship_Management/customers">Back to List</a>

	</div>
</body>
</html>