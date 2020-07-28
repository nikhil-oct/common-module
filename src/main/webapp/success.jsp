<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Temple Common Module</title>
<meta charset="utf-8">
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

<style>
body {
	font-family: "Times New Roman", Georgia, Serif;
}

.pad_menu {
   padding: 100px;
   background-color: #ff8000;
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

</style>
</head>
<body>
<body>


	<div class="container" >
	
	<div class="pad_menu">


		<form action="/sending.do" method="post">

			<!-- Top menu -->
			<div class="top">
				<div class="white xlarge d-flex justify-content-center"
					style="max-width: 1200px; margin: auto" >
					<h1 class="center padding-16 text-white-50 bg-dark">
						<b>TEMPLE REGISTRATION</b>
					</h1>
				</div>
				<br>
				<div class="border border-primary rounded-lg" style="margin-left: 2.5em;padding: 0 7em 2em 0;border-width: 2px; border-color: black; border-style:solid;">
				<br>
				<br>
				<h3 class="text-success">REGISTER</h3>
				<br> <b> Name : </b><input type="text" name="name"
					placeholder="Enter the Name" required> &nbsp;&nbsp;&emsp;
				<b> Mobile No : </b><input type="text" name="mobile"
					placeholder="Enter the Mobile No" required><br> <br>
				<br>
				<b>Address : </b><input type="text" name="address"
					placeholder="Enter the Address" required>&nbsp;&nbsp;&emsp;
				<b>Age : </b><input type="text" name="age"
					placeholder="Enter the Age" required><br> <br>
				<br>
				<b>State : </b><input type="text" name="state"
					placeholder="Enter the State" required>&nbsp;&emsp;&emsp;
				<b>Email : </b><input type="email" name="email"
					placeholder="Enter the Age" required><br>
				<br>
				<br>
				</div>
				<!-- for(AppPropertyDTO databaseValue:specialEntryList){
						databaseValue.getPropertyName();
				} -->
				<br>
				<br>
				<div class="border border-primary rounded-lg" style="margin-left: 2.5em;padding: 0 7em 2em 0;border-width: 2px; border-color: black; border-style:solid;">
				<br>
				<br>
				<h3 class="text-success">VISIT</h3>
				<br> <b>Special Entrance : </b><select name="specialEntryList">
					<c:forEach items="${specialEntryList}" var="databaseValue">
						<option value="${databaseValue.propValue}">
							${databaseValue.propValue}</option>
					</c:forEach>
				</select><br><br>
				
				<b> No of People : </b><select name="noOfPersonList">
					<c:forEach items="${noOfPersonList}" var="databaseValue">
						<option value="${databaseValue.propValue}">
							${databaseValue.propValue}</option>
					</c:forEach>
				</select> <br><br>
				<b>Prasad List : </b><select name="prasadaList">
					<c:forEach items="${prasadaList}" var="databaseValue">
						<option value="${databaseValue.propValue}">${databaseValue.propValue}</option>
					</c:forEach>
				</select><br><br>
				
				<b>Pooja Type : </b><select name="poojaTypeList">
					<c:forEach items="${poojaTypeList}" var="databaseValue">
						<option value="${databaseValue.propValue}">${databaseValue.propValue}</option>
					</c:forEach>
				</select><br><br>
				
				<b>ID : </b><select name="idList">
					<c:forEach items="${idList}" var="databaseValue">
						<option value="${databaseValue.propValue}">${databaseValue.propValue}</option>
					</c:forEach>
				</select><br>
				</div><br><br>

				<button id="done" class="mx-auto bg-warning btn btn-lg btn-primary btn-block text-uppercase d-flex justify-content-center"
					type="submit">SUBMIT</button><br>

				<footer class="mx-auto bg-warning">
					<p class="text-white-50 bg-dark mx-auto bg-warning">Powered by X-workz &reg;</p>
				</footer>
		</form>
	</div>
	</div>

</body>
</html>