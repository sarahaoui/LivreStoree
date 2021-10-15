<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Maisons</title>
<link rel="stylesheet" href="css/Maisons.css" />
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
        <form action="Maisons.php" method="get">
          <div class="search_box">
        <input type="text" placeholder="Rechercher sur ..." class="form-style" name="motCle" value="${model.mc}" />
          <button type="submit"><span class="material-icons">search</span></button>
      </div>
          
          </form>
        </div>
        </div>
       <div class="Maison">
       <h2>Maisons</h2>
       <table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Nom     </th>
							<th>Telephone</th>
							<th>Fax    </th>
							<th>Address</th>
							<th>Site web</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${model.maisons}" var="p">
							<tr>
							<td>${p.id_maison}</td>
							<td>${p.nom_maison}</td>
							<td>${p.tel_maison}</td>
							<td>${p.fax_maison}</td>
							<td>${p.address_maison}</td>
							<td>${p.siteweb}</td>
							<td><a href="SuprimerMaison.php?id=${p.id_maison}"><img alt="delete" src="images/deleteblack.png"></a></td>
							<td><a href="Maison.php?id=${p.id_maison}"><img alt="delete" src="images/editblack.png"></a></td>
							</tr>
							</c:forEach>
						
					</tbody>
				</table>
       </div>

</div>
</body>
</html>