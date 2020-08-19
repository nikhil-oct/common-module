<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Home Page</title>
</head>
<body>

	<div class="container" align="center">

		<div id="grad">


			<form action="sending.do" method="get">
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

							<a class="nav-item nav-link active" href="sending.do">Register <span
								class="sr-only">(current)</span></a> <a class="nav-item nav-link"
								href="resend.jsp">Request</a> <a class="nav-item nav-link"
								href="login.jsp">Login</a>
								<a class="nav-item nav-link"
								href="homePage.jsp">Home</a>
								 <a
								class="nav-item nav-link disabled" href="#">Disabled</a>

						</div>
					</div>
				</nav>
<!--Carousel Wrapper-->
    <div id="carousel-example-1z" class="carousel slide carousel-fade z-depth-1-half" data-ride="carousel">
      <!--Indicators-->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-1z" data-slide-to="1"></li>
        <li data-target="#carousel-example-1z" data-slide-to="2"></li>
      </ol>
      <!--/.Indicators-->
      <!--Slides-->
      <div class="carousel-inner" role="listbox">
        <!--First slide-->
        <div class="carousel-item active">
          <img class="d-block w-100" src="https://mdbootstrap.com/img/Photos/Slides/img%20(130).jpg" alt="First slide">
        </div>
        <!--/First slide-->
        <!--Second slide-->
        <div class="carousel-item">
          <img class="d-block w-100" src="https://mdbootstrap.com/img/Photos/Slides/img%20(129).jpg" alt="Second slide">
        </div>
        <!--/Second slide-->
        <!--Third slide-->
        <div class="carousel-item">
          <img class="d-block w-100" src="https://mdbootstrap.com/img/Photos/Slides/img%20(70).jpg" alt="Third slide">
        </div>
        <!--/Third slide-->
      </div>
      <!--/.Slides-->
      <!--Controls-->
      <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
      <!--/.Controls-->
    </div>

		

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