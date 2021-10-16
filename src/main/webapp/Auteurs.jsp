<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auteurs</title>
<link rel="stylesheet" href="css/Auteurs.css" />
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
						<li><a href="Auteurs.php?motCle= ">Auteurs</a></li>
						<li><a href="Maisons.php?motCle= ">Maisons</a></li>
          </ul>
        </div>
        <div class="div2">
        <form action="Auteurs.php" method="get">
        <div>
					<select name="Sexe" id="sexe">
					 
					<option selected disabled >Sexe</option>
					
					<option value="femme">femme</option>
					<option value="homme">homme</option>
					
						
					</select>
					</div>
          <div class="search_box">
        <input type="text" placeholder="Rechercher sur ..." class="form-style" name="motCle" value="${model.mc}"/>
          <button type="submit"><span class="material-icons">search</span></button>
      </div>
          
          </form>
        </div>
        </div>
       <div class="Auteurs">
       <h2>Auteurs</h2>
       <table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Date de naissance</th>
							<th>Code postal</th>
							<th>Telephone</th>
							<th>Email</th>
							<th>Address</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${model.auteurs}" var="p">
							<tr>
							<td>${p.id_auteur}</td>
							<td>${p.nom}</td>
							<td>${p.prenom}</td>
							<td>${p.date_naiss}</td>
							<td>${p.code_postal}</td>
							<td>${p.telephone}</td>
							<td>${p.email}</td>
							<td>${p.address}</td>
							<td><a href="Suprimer.php?id=${p.id_auteur}"><img alt="delete" src="images/deleteblack.png"></a></td>
							<td><a href="Auteur.php?id=${p.id_auteur}"><img alt="delete" src="images/editblack.png"></a></td>
							</tr>
							</c:forEach>
						
					</tbody>
				</table>
       </div>

</div>
</body>
</html>