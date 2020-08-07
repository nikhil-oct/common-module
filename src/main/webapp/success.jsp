<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information</title>
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
</head>
<body>

	<div class="container" align="center">

		<div id="grad">


		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="login.jsp">Login <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="resend.jsp">Request</a>
      <a class="nav-item nav-link" href="register.jsp">Register</a>
      <a class="nav-item nav-link disabled" href="#">Disabled</a>

    </div>
  </div>
</nav>


<h1>Success</h1>

<h2>Personal Information</h2>
<h4>${name}</h4>
<h4>${mobile}</h4>
<h4>${email}</h4>
<h4>${address}</h4>
<h4>${age}</h4>
<h4>${state}</h4>

<h2>Visit Information</h2>

<h4>${se}</h4>
<h4>${nop}</h4>
<h4>${idList}</h4>
<h4>${date}</h4>
<h4>${idNo}</h4>
<h4>${prasasa}</h4>
<h4>${poojatype}</h4><br><br>
<footer class="mx-auto bg-warning">
					<p class="text-white-50 bg-dark mx-auto bg-warning">Powered by
						X-workz &reg;</p>
				</footer>
				<br>
				<br>
				
			

		</div>
	</div>



</body>
</html>