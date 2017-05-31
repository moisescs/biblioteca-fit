<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>Biblioteca FIT</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<form class="w3-form w3-center" action="inserirLivro" method="post" width:90%; margin:auto;">
		<p>
		<label class="w3-left w3-xlarge">Título</label>
		<input class="w3-input w3-border" type="text" name="titulo" required title=""/>
		</p>
		<p>
		<label class="w3-left w3-xlarge">Categoria</label>
		<input class="w3-input w3-border" type="text" name="categoria" required/>
		</p>
		<p>
		<label class="w3-left w3-xlarge">Tipo</label>
		<input class="w3-input w3-border" type="text" name="tipoPublicacao" required/>
		</p>
		<p>
		<label class="w3-left w3-xlarge">isbn</label>
		<input class="w3-input w3-border" type="text" name="isbn" required/>
		</p>
		<p>
		<label class="w3-left w3-xlarge">autor</label>
		<input class="w3-input w3-border" type="text" name="autor" required/>
		</p>
		<p>
		<label class="w3-left w3-xlarge">edicao</label>
		<input class="w3-input w3-border" type="text" name="edicao" required/>
		</p>
		<p>
		<label class="w3-left w3-xlarge">editora</label>
		<input class="w3-input w3-border" type="text" name="editora" required/>
		</p>
		<input class="w3-btn w3-margin-right w3-indigo" name="btn-voltar" type="submit" value="Voltar">
		<input class="w3-btn w3-margin-left  w3-indigo" name="btn-logar" type="submit" value="enviar">
	</form> 
</body>
</html>