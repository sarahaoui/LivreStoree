<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Livre:${livre.titre}</title>
<link rel="stylesheet" href="css/stylelivre2.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com"  />
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
			rel="stylesheet"
		/>
		<link rel="shortcut icon" href="images/logo.png" />
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>
<div class="content">
			<div class="left">
				<img src="${livre.urlimage}" />
			</div>
			<div class="right">
				<h2>${livre.titre}</h2>
				<h3>${livre.sous_titre}</h3>

				<div class="informa">
				    <h3>Categorie: ${livre.categorie}</h3>
					<h3>ISBN: ${livre.isbn}</h3>
					<h3><a href="Auteur.php?id=${livre.id_auteur} ">Auteur: ${livre.prenom_auteur} ${livre.nom_auteur}</a></h3>
					<h3><a href="Maison.php?id=${livre.id_maison} ">Maison d'edition: ${livre.maison}</a></h3>
				</div>

				<div class="btn">
					<a href="#">Supprimer</a>
					<a href="#">Modifier</a>
				</div>
			</div>
		</div>
		<div class="resume">
			<h2>Resume</h2>
			<p>
		 ${livre.resume}
			</p>
		</div>
		<div class="list">
			<img src="images/icon.png" />
		</div>
		<div class="sidebar">
			<div class="icon2"><img src="images/icon2.png" /></div>
			<div class="menu">
				<div class="item"><a href="acceuil.php">Acceuil</a></div>
				<div class="item"><a href="livre_index.php">Livres</a></div>
				<div class="item"><a href="Auteurs.php?motCle= ">Auteurs</a></div>
				<div class="item"><a href="Maisons.php?motCle= ">Maisons</a></div>
			</div>
		</div>
		<script type="text/javascript">
var model=document.querySelector('.list');
var model2=document.querySelector('.icon2');

model.addEventListener('click',function(){
	
	document.querySelector('.sidebar').style.visibility= 'visible';
});
model2.addEventListener('click',function(){
	
	document.querySelector('.sidebar').style.visibility= 'hidden';
});
</script>
</body>
</html>