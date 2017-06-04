<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<title>FIT - Biblioteca</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/w3.css"/>
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
			<i class="fa fa-bars w3-button w3-hide-large w3-xlarge w3-text-white" onclick="w3_open()"></i> <span id="myIntro" class="w3-hide w3-text-white">FIT: Biblioteca - Altera��o de Professores</span>
		</div>

		<header class="w3-container w3-theme w3-padding-64" style="padding-left: 32px; background-color: #0070AF;">
			<h1 class="w3-xxxlarge w3-padding-16 w3-text-white">FIT: Biblioteca - Altera��o de Professores</h1>
		</header>

		<div class="w3-container w3-padding-32" style="padding-left: 32px">

			<h2>Altera��o de Professores</h2>

			<p>Esta pagina deve ser usada para Altera��o de professores:</p>

			<form class="w3-form" method="post" action="alterarProf">
				<input type="hidden" name="idPessoa" value="${prof.idPessoa}">
				<article class="w3-row-padding">
					<h4>Dados Pessoais</h4>
					<hr/>
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">Nome Completo:</label>
						<input class="w3-input w3-border" name="nomeCompleto" value="${prof.nomeCompleto}" type="text" placeholder="Nome do Professor" required maxlength="100"/>
					</div>
					<div class="w3-half">
						<p>
							<label class="w3-label w3-text-black">RE:</label>
							<input class="w3-input w3-border" name="re" value="${prof.re}" type="number" placeholder="Informe o n� do RE" required maxlength="10">
						</p>
					</div>
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">Logradouro:</label>
						<input class="w3-input w3-border" name="logradouro" value="${prof.logradouro}" type="text" placeholder="Nome da Rua ou Avenida" maxlength="60" required/>
					</div>
					<div class="w3-half">
						<p>
							<label class="w3-label w3-text-black">N�:</label>
							<input class="w3-input w3-border" name="numero" value="${prof.numero}" type="number" placeholder="Numero da Residencia" required maxlength="5">
						</p>
					</div>
					
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">CEP:</label>
						<input class="w3-input w3-border" name="cep" value="${prof.cep}" type="text" placeholder="Informe o CEP: 00000-000" required maxlength="9">
					</div>
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">Bairro:</label>
						<input class="w3-input w3-border" name="bairro" value="${prof.bairro}" type="text" placeholder="Nome do Bairro" required maxlength="50">
					</div>
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">Cidade:</label>
						<input class="w3-input w3-border" name="cidade" value="${prof.cidade}" type="text" placeholder="Nome da Cidade" required maxlength="15">
					</div>
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">UF:</label>
						<input class="w3-input w3-border" name="uf" value="${prof.uf}" type="text" placeholder="Estado" required maxlength="2">
					</div>
					
					<p>&nbsp;</p>
					<h4>Dados do Usu�rio</h4>
					<hr/>
										
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">Nome de Usu�rio:</label>
						<input class="w3-input w3-border" name="usuario" value="${prof.usuario}" type="text" placeholder="Nome do usu�rio" required maxlength="10">
					</div>
					<div class="w3-half w3-margin-top">
						<label class="w3-label w3-text-black">Senha:</label>
						<input class="w3-input w3-border" name="senha" value="${prof.senha}" type="password" placeholder="Senha" required maxlength="10">
					</div>
					
					<input type="hidden" name="tipoSolicitante" value="professor">	
					<input type="hidden" name="bloqueado" value="0">			
					<div class="w3-row w3-margin-top w3-center">
						<div class="w3-col s12">
							<p>&nbsp;</p>
						</div>
						<div class="w3-col s12">
							<input class="w3-btn w3-indigo w3-center w3-margin" type="submit" value="Cadastrar">
							<input class="w3-btn w3-indigo w3-center w3-margin" type="reset" value="Limpar">
						</div>						
					</div>					
				</article>
			</form>

		</div>

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

