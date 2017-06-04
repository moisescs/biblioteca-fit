<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<title>FIT - Biblioteca</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	
	<c:import url="menu.jsp"/>

	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" id="myOverlay"></div>

	<div class="w3-main" style="margin-left: 250px;">

		<div id="myTop" class="w3-top w3-theme w3-large" style="background-color: #0070AF">
			<i class="fa fa-bars w3-button w3-hide-large w3-xlarge w3-text-white" onclick="w3_open()"></i> 
			<span id="myIntro" class="w3-hide w3-text-white">FIT: Biblioteca - Lista de Funcionários</span>
		</div>

		<header class="w3-container w3-theme w3-padding-64"
			style="padding-left: 32px; background-color: #0070AF;">
			<h1 class="w3-xxxlarge w3-padding-16 w3-text-white">FIT: Biblioteca - Lista de Funcionários</h1>
		</header>

		<div class="w3-container w3-padding-32" style="padding-left: 32px">  <!-- Inicio do Container -->

			<h2>Lista de Funcionários</h2>

			<p></p>
			
			<table class="w3-table-all w3-hoverable" style="width: 100%;">
				<thead>
					<tr class="w3-light-grey">
						<th>Nome Completo</th>
						<th>Endereço</th>
						<th>RE</th>
						<th>Usuario</th>
						<th>Bloqueado?</th>
						<th>Operações</th>
					</tr>
				</thead>
				<c:forEach var="func" items="${funcs}">
					<tr>
						<td>${func.nomeCompleto}</td>
						<td>${func.logradouro} ${func.numero}, CEP: ${func.cep}, ${func.bairro}, ${func.cidade} - ${func.uf}</td>
						<td>${func.re}</td>
						<td>${func.usuario}</td>
						<td>${func.bloqueado}</td>
						<td>
							<a href="formUpFunc?re=${func.re}" class="w3-bar-item w3-button"><i class="fa fa-pencil" aria-hidden="true"></i></a> 
							<a href="deletarFunc?re=${func.re}" class="w3-bar-item w3-button"><i class="fa fa-trash" aria-hidden="true"></i></a>						
						</td>
					</tr>
			  </c:forEach>
			</table>



		</div> <!-- Fim do Container -->
		<c:import url="rodape.jsp"/>
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