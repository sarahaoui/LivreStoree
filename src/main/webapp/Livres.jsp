<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>livre</title>
		<link rel="stylesheet" href="css/stylelivre.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
			rel="stylesheet"
		/>
		<link rel="shortcut icon" href="images/logo.png" />
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>
<div class="container">
			<div class="nav-bar">
				<div class="nav">
					<ul>
						<li><a href="acceuil.php">Acceuil</a></li>
						<li><a href="livre_index.php">Livres</a></li>
						<li><a href="#">Auteurs</a></li>
						<li><a href="#">Maisons</a></li>
					</ul>
				</div>
				<div class="div2">
				<form action="livres.php" method="get">
				<div>
					<select name="Categorie" id="categorie">
					<c:if test="${empty model.categorie }"> 
					<option selected disabled>Categorie</option></c:if>
					<c:if test="${!empty model.categorie }"> 
					<option selected disabled >${model.categorie}</option></c:if>
					
					<option value="Tous">Tous</option>
					<c:forEach items="${model.listcategorie}" var="p">
						<option value="${p}">${p}</option>
						</c:forEach>
						
					</select>
					</div>
					<div class="search_box">
				<input type="text" placeholder="Rechercher sur ..." name="motCle" value="${model.mc}" />
					<button type="submit"><span class="material-icons">search</span></button>
			</div>
					
					</form>
				</div>
			</div>

			<div class="livres">
				<h2>Livres</h2>
				<div class="box-container">
				<c:forEach items="${model.livres}" var="p">
					<div class="box">
						<div class="image"><a href="livre.php?id=${p.isbn}"><img src="${p.urlimage}" /></a></div>
						<div class="titre"><a href="livre.php?id=${p.isbn}">${p.titre}</a></div>
						<div class="auteur"><h6>${p.nom_auteur} ${p.prenom_auteur}</h6></div>
						
					</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
</body>
</html>