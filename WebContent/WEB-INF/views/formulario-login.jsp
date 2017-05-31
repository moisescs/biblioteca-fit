<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Biblioteca FIT</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<h3 class="w3-xxlarge">Seja Bem-vindo à Biblioteca FIT</h3>
	<form class="w3-form w3-center" action="efetuarLogin" style="width:90%; margin:auto;">
		<p>
		<label class="w3-left w3-xlarge">Usuário</label>
		<input class="w3-input w3-border" type="text" name="usuario" required title="Digite um usuário"/>
		</p>
		<p>
		<label class="w3-left w3-xlarge">Senha</label>
		<input class="w3-input w3-border" type="password" name="senha" required/>
		</p>
		<input class="w3-btn w3-margin-right w3-indigo" name="btn-voltar" type="submit" value="Voltar">
		<input class="w3-btn w3-margin-left  w3-indigo" name="btn-logar" type="submit" value="Logar">
	</form>     
</body>
</html> 