<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head> <meta charset=UTF-8>
<title> Maison: ${maison.nom_maison}</title> 
 <link rel="stylesheet" href="css/EditMaison.css" />
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


      <form name="myForm" onsubmit="return validateForm()" method="post" action="editMaison.php">
         <table class="form-style">
            <tr>
               <td>
                  <label> ID Maison: </label>
               </td>
               <td>
                  <input type="text" name="ID" class="long" value="${maison.id_maison}"/>
                  <span class="error" id="errorID"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Nom Maison:</label>
               </td>
               <td>
                  <input type="text" name="name" class="long " value="${maison.nom_maison}"/>
                  <span class="error" id="errorname"></span>
               </td>
                <tr>
               <td>
                  <label> Adresse Maison: </label>
               </td>
               <td>
                  <input type="text" name="adresse" class="long" value="${maison.address_maison}"/>
                  <span class="error" id="erroradresse"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Tel Maison: </label>
               </td>
               <td>
                  <input type="text" name="tlf" class="long" value="${maison.tel_maison}"/>
                  <span class="error" id="errortlf"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Fax Maison: </label>
               </td>
               <td>
                  <input type="text" name="fax" class="long" value="${maison.fax_maison}"/>
                  <span class="error" id="errorfax"></span>
               </td>
            </tr>
            <tr>
               <td>
                  <label> Siteweb: </label>
               </td>
               <td>
                  <input type="text" name="site" class="long" value="${maison.siteweb}"/>
                  <span class="error" id="errorsite"></span>
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
 <script> 
            function validateForm()                                    
{

    var site = document.forms["myForm"]["site"];
    var name = document.forms["myForm"]["name"]; 
    var adresse = document.forms["myForm"]["adresse"];
    var ID = document.forms["myForm"]["ID"];
    var tlf = document.forms["myForm"]["tlf"];
    var fax = document.forms["myForm"]["fax"];
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
    if (tlf.value == "")                                  
    { 
        document.getElementById('errortlf').innerHTML="Veuillez entrez un numéro de téléphone valide";  
        tlf.focus(); 
        return false; 
    }else{
        document.getElementById('errortlf').innerHTML="";  
    } 
    ///////////////////////
    if (fax.value == "")                                  
    { 
        document.getElementById('errorfax').innerHTML="Veuillez entrez un numéro de fax valide";  
        fax.focus(); 
        return false; 
    }else{
        document.getElementById('errorfax').innerHTML="";  
    }       
    ///////////////////////////////
    if (site.value == "")                                  
    { 
        document.getElementById('errorsite').innerHTML="Veuillez entrez un Siteweb valide";  
        site.focus(); 
        return false; 
    }else{
        document.getElementById('errorsite').innerHTML="";  
    }       
}
   </script>
   </body>
</html>