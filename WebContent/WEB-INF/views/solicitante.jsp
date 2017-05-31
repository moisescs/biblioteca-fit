<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>FIT - Biblioteca</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: "Roboto", sans-serif
}

.w3-bar-block .w3-bar-item {
	padding: 16px;
	font-weight: bold
}
</style>
<body>

	<c:import url="menu.jsp" />

	<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor: pointer" id="myOverlay"></div>

	<div class="w3-main" style="margin-left: 250px;">

		<div id="myTop" class="w3-top w3-theme w3-large" style="background-color: #0070AF">
			<i class="fa fa-bars w3-button w3-hide-large w3-xlarge w3-text-white" onclick="w3_open()"></i> 
			<span id="myIntro" class="w3-hide w3-text-white">FIT: Biblioteca - Acervo</span>
		</div>

		<header class="w3-container w3-theme w3-padding-64" style="padding-left: 32px; background-color: #0070AF;">
			<h1 class="w3-xxxlarge w3-padding-16 w3-text-white">FIT: Biblioteca - Acervo</h1>
		</header>

		<div class="w3-container w3-padding-32" style="padding-left: 32px"> <!-- Inicio do container do site-->
			
			<div class="w3-row-padding w3-margin-bottom">
				<div class="w3-third">
					<div class="w3-container w3-red w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-check-square-o w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>Professor</h3>
						</div>
						<div class="w3-clear"></div>
						<br>
						<div class="w3-bar w3-container w3-centered">
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-search fa-2x" aria-hidden="true"></i></a> 
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-plus fa-2x" aria-hidden="true"></i></a> 
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-trash fa-2x" aria-hidden="true"></i></a>
						</div>
					</div>
				</div>
				<div class="w3-third">
					<div class="w3-container w3-blue w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-graduation-cap w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>Aluno</h3>
						</div>
						<div class="w3-clear"></div>
						<br>
						<div class="w3-bar w3-container w3-centered">
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-search fa-2x" aria-hidden="true"></i></a> 
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-plus fa-2x" aria-hidden="true"></i></a> 
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-trash fa-2x" aria-hidden="true"></i></a>
						</div>
					</div>
				</div>
				<div class="w3-third">
					<div class="w3-container w3-teal w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-user w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>Funcionário</h3>
						</div>
						<div class="w3-clear"></div>
						<br>
						<div class="w3-bar w3-container w3-centered">
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-search fa-2x" aria-hidden="true"></i></a> 
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-plus fa-2x" aria-hidden="true"></i></a> 
							<a href="#" class="w3-bar-item w3-button w3-hover-none"><i class="fa fa-trash fa-2x" aria-hidden="true"></i></a>
						</div>
					</div>
				</div>
			</div>
			
		</div><!--  Fim do container do site-->

		<c:import url="rodape.jsp" />

	</div>

	<script>
		// Open and close the sidebar on medium and small screens
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("myOverlay").style.display = "block";
		}
		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("myOverlay").style.display = "none";
		}

		// Change style of top container on scroll
		window.onscroll = function() {
			myFunction()
		};
		function myFunction() {
			if (document.body.scrollTop > 80
					|| document.documentElement.scrollTop > 80) {
				document.getElementById("myTop").classList.add("w3-card-4",
						"w3-animate-opacity");
				document.getElementById("myIntro").classList
						.add("w3-show-inline-block");
			} else {
				document.getElementById("myIntro").classList
						.remove("w3-show-inline-block");
				document.getElementById("myTop").classList.remove("w3-card-4",
						"w3-animate-opacity");
			}
		}

		// Accordions
		function myAccordion(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-theme";
			} else {
				x.className = x.className.replace("w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-theme", "");
			}
		}
	</script>

</body>
</html>