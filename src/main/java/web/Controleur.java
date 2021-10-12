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
			/******************Index .php ******************/	
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
			else if(path.equals("/livre.php")) {
				String isbn=request.getParameter("id").toString();
				Livre livre= imp.getLivre(isbn);
				request.setAttribute("livre", livre);
				request.getRequestDispatcher("Livre.jsp").forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
