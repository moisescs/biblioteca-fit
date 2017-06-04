<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>FIT - Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
</head>
<body>
	<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

	<section class="w3-main">
		<div id="myTop" class="w3-top w3-container w3-padding-16 w3-theme w3-large" style="background-color: #0070AF;">
			<span id="myIntro" class="w3-hide w3-text-white"><i class="fa fa-cogs w3-large" aria-hidden="true"></i> FIT: Painel de Administração</span>
		</div>
		<header class="w3-container w3-theme w3-padding-48" style="padding-left:32px; background-color: #0070AF;">
			<h1 class="w3-xxlarge w3-text-white"><i class="fa fa-cogs w3-jumbo" aria-hidden="true"></i> FIT: Painel de Administração</h1>
		</header>

		<section class="w3-container w3-padding-32 w3-white">
			<div class="w3-container w3-center">
				<div class="w3-row">
				  <div class="w3-col w3-hide-small m2 l3">&nbsp;</div>
				  <div class="w3-col s 12 m8 l6 w3-center">
				  	<h3 class="w3-xxlarge">Seja Bem-vindo a Biblioteca da FIT!</h3>
				  	
				  	<form class="w3-form w3-center" method="post" action="efetuarLogin" style="width:90%; margin:auto;">
						<p>
							<label class="w3-left w3-xlarge">Usuário</label>
							<input class="w3-input w3-border" type="text" name="usuario"/>
						</p>
						<p>
							<label class="w3-left w3-xlarge">Senha</label>
							<input class="w3-input w3-border" type="password" name="senha"/>
						</p>
					    <input class="w3-btn w3-margin-right w3-indigo" name="btn-voltar" type="reset" value="Volta" tabindex="2"/>
					    <input class="w3-btn w3-margin-left  w3-indigo" name="btn-logar" type="submit" value="Logar" tabindex="1"/>
					</form>
				  </div>
				  <div class="w3-col w3-hide-small m2 l3">&nbsp;</div>
				</div>
			</div>
		</section >
		<c:import url="rodape.jsp" />   
	</section>

<script>
	// Open and close the sidenav on medium and small screens
	function w3_open() {
		document.getElementById("mySidenav").style.display = "block";
		document.getElementById("myOverlay").style.display = "block";
	}
	function w3_close() {
		document.getElementById("mySidenav").style.display = "none";
		document.getElementById("myOverlay").style.display = "none";
	}

	// Change style of top container on scroll
	window.onscroll = function() {myFunction()};
	function myFunction() {
		if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
			document.getElementById("myTop").classList.add("w3-card-4");
			document.getElementById("myIntro").classList.add("w3-show-inline-block");
		} else {
			document.getElementById("myIntro").classList.remove("w3-show-inline-block");
			document.getElementById("myTop").classList.remove("w3-card-4");
		}
	}
</script>
     
</body>
</html> 