<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head> <meta charset=UTF-8>
<title> Auteur: ${auteur.prenom} ${auteur.nom } </title> 
 <link rel="stylesheet" href="css/EditAuteur.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com"  />
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
			rel="stylesheet"
		/>
		<link rel="shortcut icon" href="images/logo.png" />
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
   <script> 
            function validateForm()                                    
{

    var email = document.forms["myForm"]["email"];
    var name = document.forms["myForm"]["name"]; 
    var prenom = document.forms["myForm"]["prenom"];
    var adresse = document.forms["myForm"]["adresse"];
    var date = document.forms["myForm"]["date"];
    var ID = document.forms["myForm"]["ID"];
    var code = document.forms["myForm"]["code"];
    var tlf = document.forms["myForm"]["tlf"];
    ////////////////////////////////
    if (ID.value == "")                                  
    { 
        document.getElementById('errorID').innerHTML="Veuillez entrez un ID valide";  
        name.focus(); 
        return false; 
    }else{
        document.getElementById('errorID').innerHTML="";  
    }

    ////////////////////////////////
    if (name.value == "")                                  
    { 
        document.getElementById('errorname').innerHTML="Veuillez entrez un nom valide";  
        name.focus(); 
        return false; 
    }else{
        document.getElementById('errorname').innerHTML="";  
    }
   /////////////////////////////////
   if (prenom.value == "")                                  
    { 
        document.getElementById('errorprenom').innerHTML="Veuillez entrez un prenom valide";  
        prenom.focus(); 
        return false; 
    }else{
        document.getElementById('errorprenom').innerHTML="";  
    }

    ///////////////////////////////
    if (email.value == "")                                   
    { 
        document.getElementById('erroremail').innerHTML="Veuillez entrez une adresse mail valide"; 
        email.focus(); 
        return false; 
    }else{
        document.getElementById('erroremail').innerHTML="";  
    }
   
    if (email.value.indexOf("@", 0) < 0)                 
    { 
        document.getElementById('erroremail').innerHTML="Veuillez entrez une adresse mail valide"; 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf(".", 0) < 0)                 
    { 
        document.getElementById('erroremail').innerHTML="Veuillez entrez une adresse mail valide"; 
        email.focus(); 
        return false; 
    }
    ///////////////////////
    if (adresse.value == "")                                  
    { 
        document.getElementById('erroradresse').innerHTML="Veuillez entrez une adresse valide";  
        adresse.focus(); 
        return false; 
    }else{
        document.getElementById('erroradresse').innerHTML="";  
    }
    ///////////////////////
    if (date.value == "")                                  
    { 
        document.getElementById('errordate').innerHTML="Veuillez entrez une date valide";  
        date.focus(); 
        return false; 
    }else{
        document.getElementById('errordate').innerHTML="";  
    }
    ////////////////////////////////
    if (code.value == "")                                  
    { 
        document.getElementById('errorcode').innerHTML="Veuillez entrez un code postal valide";  
        code.focus(); 
        return false; 
    }else{
        document.getElementById('errorcode').innerHTML="";  
    }

    ///////////////////////
    if (tlf.value == "")                                  
    { 
        document.getElementById('errortlf').innerHTML="Veuillez entrez un numéro valide";  
        tlf.focus(); 
        return false; 
    }else{
        document.getElementById('errortlf').innerHTML="";  
    }    
}
   </script>
 </head>

   <body>
           
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


      <form name="myForm" onsubmit="return validateForm()" method="post" action="editAuteur.php">
         <table class="form-style">
            <tr>
               <td>
                  <label> ID Acteur: </label>
               </td>
               <td>
                  <input type="text" name="ID" class="long" value=" ${auteur.id_auteur }"/>
                  <span class="error" id="errorID"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Nom:</label>
               </td>
               <td>
                  <input type="text" name="name" class="long" value=" ${auteur.nom }"/>
                  <span class="error" id="errorname"></span>
               </td>
            <tr>
               <td>
                  <label> Prenom: </label>
               </td>
               <td>
                  <input type="text" name="prenom" class="long" value=" ${auteur.prenom }"/>
                  <span class="error" id="errorprenom"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Date de naissance: </label>
               </td>
               <td>
                  <input type="text" name="date" class="long" value=" ${auteur.date_naiss }"/>
                  <span class="error" id="errordate"></span>
               </td>
            </tr>
           <tr>
               <td>
                  <label> Adresse: </label>
               </td>
               <td>
                  <input type="text" name="adresse" class="long" value=" ${auteur.address }"/>
                  <span class="error" id="erroradresse"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Code postal: </label>
               </td>
               <td>
                  <input type="text" name="code" class="long" value=" ${auteur.code_postal }"/>
                  <span class="error" id="errorcode"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Telephone: </label>
               </td>
               <td>
                  <input type="text" name="tlf" class="long" value=" ${auteur.telephone }"/>
                  <span class="error" id="errortlf"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> E-mail </label>
               </td>
               <td>
                  <input type="email" name="email" class="long" value=" ${auteur.email}"/>
                  <span class="error" id="erroremail"></span>
               </td>
            </tr>
            <tr>
               <td></td>
               <td>
                  <input type="submit" value="Confirmer">      
                  <input type="reset" value="Annuler"> 
               </td>
            </tr>
         </table>
      </form>
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