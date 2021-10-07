package DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public class InterfaceImplDAO implements InterfaceDAO {

	@Override
	public List<Livre> LivresparMC(String MC) {
		
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		Model model= SingletonConnection.getModel();
		List<Livre> list= new ArrayList<>();
		
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("SELECT ?titre ?sous_titre  ?resume ?categorie ?isbn \r\n"
				+ "	WHERE { ?s rdf:type dc:livre ;\r\n"
				+ "                                             dc:titre ?titre;\r\n"
				+ "                                             dc:sous-titre ?sous_titre;\r\n"
				+ "                                             dc:resume ?resume;\r\n"
				+ "                                             dc:categorie ?categorie;\r\n"
				+ "                                             dc:isbn ?isbn.\r\n"
				+ "                                 FILTER(regex(?titre, \""+MC+"\",\"i\"))  }");
		
		Query query= QueryFactory.create(buffer.toString());  
	
		QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
	
		
		try {
			ResultSet response=queryExecution.execSelect();  
	
			while(response.hasNext()) {
				QuerySolution sol= response.nextSolution();
	
				RDFNode titre=sol.get("?titre");
				RDFNode sousTitre=sol.get("?sous_titre");
				RDFNode categorie=sol.get("?categorie");
				RDFNode resume=sol.get("?resume");
				String isbn=sol.get("?isbn").toString();
				
				if((titre==null)||(sousTitre==null)||(categorie==null)||(resume==null)||(isbn==null)){
					System.out.println("there are no data");
				}else {
					
				 Livre livre= new Livre();
				 livre.setCategorie(categorie.toString());
				 livre.setIsbn(isbn);
				 livre.setResume(resume.toString());
				 livre.setSous_titre(sousTitre.toString());
				 livre.setTitre(titre.toString());
				 
				 list.add(livre);
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return list;
	}

	@Override
	public List<Auteur> AuteursparMC(String MC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Maison> MaisonsparMC(String MC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livre getLivre(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auteur getAuteur(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maison getMaison(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
