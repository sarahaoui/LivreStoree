package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.rdf.model.Model;

import java.util.ArrayList;
import java.util.List;
import DAO.InterfaceDAO;
import DAO.InterfaceImplDAO;
import DAO.SingletonConnection;
import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;


@WebServlet("*.php")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InterfaceImplDAO imp;
	
       
    
    public Controleur() {
        super();
        
    }
    public void init() throws ServletException {
    	imp = new InterfaceImplDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path =request.getServletPath();
		
		/******************Acceuil .php ******************/	
		
			if(path.equals("/acceuil.php")) {
				request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
				
				
		/******************Livre_Index .php ******************/
				
			}else if((path.equals("/livre_index.php")) ) {
				
				Modell modell= new Modell();
				List<String>list=imp.getCategorie();
				modell.setListcategorie(list);
				modell.setMc("");
				modell.setCategorie(null);
				List<Livre> livres= imp.LivresparMC("",null); 
				modell.setLivres(livres);
				
				request.setAttribute("model", modell);
				request.getRequestDispatcher("Livres.jsp").forward(request, response);
				
			}
			/******************livres.php ******************/
			
			else if(path.equals("/livres.php")) {
				String mc= request.getParameter("motCle");
				String categorie= request.getParameter("Categorie");
				Modell modell= new Modell();
				List<String>list=imp.getCategorie();
				modell.setListcategorie(list);
				modell.setMc(mc);
				modell.setCategorie(categorie);
				List<Livre> livres= imp.LivresparMC(mc,categorie); 
				modell.setLivres(livres);
				
				request.setAttribute("model", modell);
				request.getRequestDispatcher("Livres.jsp").forward(request, response);
			}
			
			/******************Livre.php ******************/
			
			else if(path.equals("/livre.php")) {
				String isbn=request.getParameter("id").toString();			
				Livre livre= imp.getLivre(isbn);
				request.setAttribute("livre", livre);
				request.getRequestDispatcher("Livre.jsp").forward(request, response);
				
			}
			/******************Auteurs .php ******************/	
			
			else if(path.equals("/Auteurs.php")) {
				String mc= request.getParameter("motCle");
				String sexe=request.getParameter("Sexe");
				List<Auteur>liste = imp.AuteursparMC(sexe,mc);
				Modell model= new Modell();
				model.setAuteurs(liste);
				model.setMc(mc);
				request.setAttribute("model", model);
				request.getRequestDispatcher("Auteurs.jsp").forward(request, response);
			}
			
			/******************Maisons .php ******************/
			
			else if(path.equals("/Maisons.php")) {
			    String mc= request.getParameter("motCle");
				List<Maison>liste = imp.MaisonsparMC(mc);
				Modell model= new Modell();
				model.setMaisons(liste);
				model.setMc(mc);
				request.setAttribute("model", model);
				request.getRequestDispatcher("Maisons.jsp").forward(request, response);
				
			}
			
			/******************Maison.php ******************/
			
			else if(path.equals("/Maison.php")) {
				String id=request.getParameter("id").toString();
				Maison maison= imp.getMaison(id);
				request.setAttribute("maison", maison);
				request.getRequestDispatcher("EditMaison.jsp").forward(request, response);
			}
			
			/******************Auteur.php ******************/
			
			else if(path.equals("/Auteur.php")) {
				String id=request.getParameter("id").toString();
				Auteur auteur= imp.getAuteur(id);
				request.setAttribute("auteur", auteur);
				request.getRequestDispatcher("EditAuteur.jsp").forward(request, response);
			}
			
			/******************SuprimerAuteur.php ******************/
			
			else if(path.equals("/Suprimer.php")) {
				String id=request.getParameter("id").toString();
				imp.deleteAuteur(id);
				response.sendRedirect("Auteurs.php?motCle=");
				
			}
			/******************SuprimerMaison.php ******************/
			else if(path.equals("/SuprimerMaison.php")) {
				String id=request.getParameter("id").toString();
				imp.deleteMaison(id);
				response.sendRedirect("Maisons.php?motCle=");
			}
			/******************SuprimerLivre.php ******************/
			
			else if(path.equals("/SuprimerLivre.php")) {
				String id=request.getParameter("id").toString();
				imp.deleteLivre(id);
				response.sendRedirect("livre_index.php");
			}
			/******************EditAuteur.php ******************/
			
			else if(path.equals("/editAuteur.php")) {
				Auteur aut = new Auteur();
				String id=request.getParameter("ID");
				String nom=request.getParameter("name");
				String prenom=request.getParameter("prenom");
				String addrress=request.getParameter("adresse");
				String code=request.getParameter("code");
				String date=request.getParameter("date");
				String email=request.getParameter("email");
				String tlf=request.getParameter("tlf");
				aut.setId_auteur(id);
				aut.setNom(nom);
				aut.setPrenom(prenom);
				aut.setAddress(addrress);
				aut.setCode_postal(code);
				aut.setDate_naiss(date);
				aut.setEmail(email);
				aut.setTelephone(tlf);
				
				imp.updateDataAuteurs(aut, id);
				response.sendRedirect("Auteur.php?id="+id);
				
			}
			/******************EditMaison.php ******************/
			else if(path.equals("/editMaison.php")) {
				Maison maison = new Maison();
				String id=request.getParameter("ID");
				String nom=request.getParameter("name");
				String addrress=request.getParameter("adresse");
				String site=request.getParameter("site");
				String fax=request.getParameter("fax");
				String tlf=request.getParameter("tlf");
				
				maison.setAddress_maison(addrress);
				maison.setFax_maison(fax);
				maison.setId_maison(id);
				maison.setNom_maison(nom);
				maison.setSiteweb(site);
				maison.setTel_maison(tlf);
				imp.UpdateDataMaison(maison, id);
				response.sendRedirect("Maison.php?id="+id);
			}
			
			/****************** Class not found ******************/	
			else {
				response.sendError(response.SC_NOT_FOUND);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
