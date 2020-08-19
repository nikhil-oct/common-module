<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="newcheck.css">
<link href="./css/bootstrap.css" rel="stylesheet">

<style>
body {
	font-family: "Times New Roman", Georgia, Serif;
}

h2, h4, h5, h6 {
	font-family: "Playfair Display";
	letter-spacing: 3px;
}

h3 {
	font-family: "Georgia";
}

h1 {
	font-family: "Times New Roman";
}

#done {
	width: 15%;
	align-items: center;
}

#grad {
	background-image: linear-gradient(to bottom right, red, yellow);
}
</style>
<title>Booking Visit</title>
</head>
<body>

	<div class="container" align="center">

		<div id="grad">


			<form action="book.do" method="post">
				<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
					<a class="navbar-brand" href="#">Navbar</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<div class="navbar-nav">

							<a class="nav-item nav-link active" href="forgetPassword.jsp">Forget Password
								<span class="sr-only">(current)</span>
							</a> <a class="nav-item nav-link" href="login.jsp">login</a> <a
								class="nav-item nav-link" href="register.jsp">Register</a> <a
								class="nav-item nav-link" href="resend.jsp">Request</a> <a
								class="nav-item nav-link disabled" href="#">Disabled</a>
								<h2>Welcome, ${emailId}</h2>
						</div>
					</div>
				</nav>


<br> <br>
					<div class="border border-primary rounded-lg"
						style="margin-left: 2.5em; padding: 0 7em 2em 0; border-width: 2px; border-color: black; border-style: solid;">
						<br> <br>
						<h3 class="text-success">VISIT</h3>
						<br> <b>Special Entrance : </b><select
							name="specialEntryList">
							<c:forEach items="${specialEntryList}" var="databaseValue">
								<option value="${databaseValue.propValue}">
									${databaseValue.propValue}</option>
							</c:forEach>
						</select><br> <br> <label><b> No of People : </b></label><select
							name="noOfPersonList">
							<c:forEach items="${noOfPersonList}" var="databaseValue">
								<option value="${databaseValue.propValue}">
									${databaseValue.propValue}</option>
							</c:forEach>
						</select> <br> <br> <b>Prasad List : </b><select
							name="prasadaList">
							<c:forEach items="${prasadaList}" var="databaseValue">
								<option value="${databaseValue.propValue}">${databaseValue.propValue}</option>
							</c:forEach>
						</select><br> <br> <b>Pooja Type : </b><select
							name="poojaTypeList">
							<c:forEach items="${poojaTypeList}" var="databaseValue">
								<option value="${databaseValue.propValue}">${databaseValue.propValue}</option>
							</c:forEach>
						</select><br> <br> <b>ID : </b><select name="idList">
							<c:forEach items="${idList}" var="databaseValue">
								<option value="${databaseValue.propValue}">${databaseValue.propValue}</option>
							</c:forEach>
						</select><br> <br> <b>Date of visiting : </b><input type="date"
							name="date" placeholder="Enter date" required><br> <br>
						<b>ID No : </b><input type="text" name="idNo"
							placeholder="Enter ID No" required><br> <br>

					</div>
					<br> <br>
				

				<button id="done"
					class="mx-auto bg-warning btn btn-lg btn-primary btn-block text-uppercase d-flex justify-content-center"
					type="submit">Click To Book</button>



				<footer class="mx-auto bg-warning">
					<p class="text-white-50 bg-dark mx-auto bg-warning">Powered by
						X-workz &reg;</p>
				</footer>
			</form>
			<br> <br>



		</div>
	</div>
</body>
</html>