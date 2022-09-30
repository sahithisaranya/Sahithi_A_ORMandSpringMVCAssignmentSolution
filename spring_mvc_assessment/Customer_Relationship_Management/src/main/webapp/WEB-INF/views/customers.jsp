<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<title>Customer relationship management</title>
<style>
h1 {
	text-align: center;
	font-weight: 200;
	font-size: 60px;
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

thead,a {
	background-color: rgb(116, 77, 4);
	color: beige;
	text-align: center;
}
</style>
</head>

<body>

	<div class="container">
		<h1>Customer Relationship Management</h1>
		<hr>
		<!-- Add a search form -->

		<form action="/Customer_Relationship_Management/" class="form-inline">
			<!-- Add a button -->
			<a href="/Customer_Relationship_Management/add"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a>

		</form>

		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="customer">
					<tr>
						<td><c:out value="${customer.first_name}" /></td>
						<td><c:out value="${customer.last_name}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/Customer_Relationship_Management/update?customer_id=${customer.customer_id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/Customer_Relationship_Management/delete?customer_id=${customer.customer_id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete
						</a>
						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>



