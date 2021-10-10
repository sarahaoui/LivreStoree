package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.php")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Controleur() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path =request.getServletPath();
		
		/******************Index .php ******************/	
			if(path.equals("/acceuil.php")) {
				request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
