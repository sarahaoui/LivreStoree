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
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public class InterfaceImplDAO implements InterfaceDAO {
	Model model= SingletonConnection.getModel();

/********************************************************************/
	@Override
	public List<Livre> LivresparMC(String MC,String Categoriee) {
		
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		List<Livre> list= new ArrayList<>();
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		if((Categoriee==null) || (Categoriee.equals("Tous"))) {	
			buffer.append("SELECT ?id_auteur ?id_maison ?url ?titre ?sous_titre  ?resume ?categorie ?isbn ?nom_maison  ?nom ?prenom\r\n"
					+ "				WHERE  {?s rdf:type dc:livre;                                       \r\n"
					+ "				                      dc:titre ?titre;\r\n"
					+ "				                       dc:sous-titre ?sous_titre;\r\n"
					+ "				                        dc:resume ?resume;\r\n"
					+ "				                       dc:categorie ?categorie;\r\n"
					+ "				                      dc:isbn ?isbn;      \r\n"
					+ "				                        dc:hasURL ?url.     \r\n"
					+ "	OPTIONAL {?s dc:ecrit_par ?ss.\r\n"
					+ "				    ?ss dc:id_auteur ?id_auteur. ?ss dc:nom ?nom.  ?ss dc:prenom ?prenom. }\r\n"
					+ " OPTIONAL{  ?s dc:publie ?sss.  ?sss dc:id_maison ?id_maison.  ?sss dc:nom_maison ?nom_maison.}"
					+ "				           FILTER (regex(?titre, \""+MC+"\",\"i\"))}");}
		else {
				buffer.append("SELECT ?id_auteur ?id_maison ?url ?titre ?sous_titre  ?resume ?categorie ?isbn ?nom_maison  ?nom ?prenom\r\n"
						+ "				WHERE  {?s rdf:type dc:livre;                                       \r\n"
						+ "				                      dc:titre ?titre;\r\n"
						+ "				                       dc:sous-titre ?sous_titre;\r\n"
						+ "				                        dc:resume ?resume;\r\n"
						+ "				                       dc:categorie ?categorie;\r\n"
						+ "				                      dc:isbn ?isbn;      \r\n"
						+ "				                        dc:hasURL ?url.     \r\n"
						+ "	OPTIONAL {?s dc:ecrit_par ?ss.\r\n"
						+ "				    ?ss dc:id_auteur ?id_auteur. ?ss dc:nom ?nom.  ?ss dc:prenom ?prenom. }\r\n"
						+ " OPTIONAL{  ?s dc:publie ?sss.  ?sss dc:id_maison ?id_maison.  ?sss dc:nom_maison ?nom_maison.}"
						+ "				           FILTER (regex(?titre, \""+MC+"\",\"i\"))"
						+ " FILTER ( ?categorie=\""+Categoriee+"\")}");}
	
		
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
				RDFNode imageurl=sol.get("?url");
				RDFNode nom=sol.get("?nom");
				RDFNode prenom=sol.get("?prenom");
				RDFNode nom_maison=sol.get("?nom_maison");
				RDFNode id_auteur=sol.get("?id_auteur");
				RDFNode id_maison=sol.get("?id_maison");
				
				if((titre==null)||(sousTitre==null)||(categorie==null)||(resume==null)||(isbn==null)||(imageurl==null)){
					System.out.println("there are no data");
				}else {
					
				 Livre livre= new Livre();
				 livre.setCategorie(categorie.toString());
				 livre.setIsbn(isbn);
				 livre.setResume(resume.toString());
				 livre.setSous_titre(sousTitre.toString());
				 livre.setTitre(titre.toString());
				 livre.setUrlimage(imageurl.toString());
				 if((nom==null) ||(prenom==null)||(id_auteur==null)) {
					 livre.setNom_auteur("");
					 livre.setPrenom_auteur("");
					 livre.setId_auteur("");
				 }else {
					 livre.setNom_auteur(nom.toString());
					 livre.setPrenom_auteur(prenom.toString());
					 livre.setId_auteur(id_auteur.toString());
				 }
				 if((nom_maison==null) ||(id_maison==null)) {
					 livre.setId_maison("");
					 livre.setMaison("");
				 }else {
				 livre.setMaison(nom_maison.toString());
				 livre.setId_maison(id_maison.toString());}
				 
				 list.add(livre);
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return list;
	}
	
	/********************************************************************/

	@Override
	public List<Auteur> AuteursparMC(String sexe,String Nom) {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		List<Auteur> listee= new ArrayList<>();
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		if((sexe==null) || (sexe.equals("Tous"))) {
		buffer.append("SELECT  ?nom ?prenom ?date_naiss  ?telephone ?email ?address ?id_auteur ?code_postal \r\n"
				+ "			    WHERE { ?s rdf:type dc:auteur; \r\n"
				+ "			       dc:nom ?nom; \r\n"
				+ "			       dc:prenom ?prenom;\r\n"
				+ "		                              dc:date_naiss ?date_naiss; \r\n"
				+ "			      dc:email ?email; \r\n"
				+ "			      dc:address ?address;\r\n"
				+ "			     dc:telephone ?telephone;\r\n"
				+ "		         dc:id_auteur ?id_auteur;\r\n"
				+ "             dc:code_postal ?code_postal.\r\n"
				+ "			   FILTER(regex(?nom ,\""+Nom+"\",\"i\"))}\r\n"
				+ "			  ORDERBY ?id_auteur");}
		else {
			buffer.append("SELECT  ?nom ?prenom ?date_naiss  ?telephone ?email ?address ?id_auteur ?code_postal \r\n"
					+ "			    WHERE { ?s rdf:type dc:auteur; \r\n"
					+ "			       dc:nom ?nom; \r\n"
					+ "			       dc:prenom ?prenom;\r\n"
					+ "		                              dc:date_naiss ?date_naiss; \r\n"
					+ "			      dc:email ?email; \r\n"
					+ "			      dc:address ?address;\r\n"
					+ "			     dc:telephone ?telephone;\r\n"
					+ "		         dc:id_auteur ?id_auteur;\r\n"
					+ "          rdf:type dc:"+sexe+"; "
					+ "             dc:code_postal ?code_postal.\r\n"
					+ "			   FILTER(regex(?nom ,\""+Nom+"\",\"i\"))}\r\n"
					
					+ "			  ORDERBY ?id_auteur");
		}
		
		
		
		Query query= QueryFactory.create(buffer.toString());  
	
		QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
	
		
		try {
			ResultSet response=queryExecution.execSelect();  
	
			while(response.hasNext()) {
				QuerySolution sol= response.nextSolution();
	
				RDFNode id_auteur=sol.get("?id_auteur");
				RDFNode nom=sol.get("?nom");
				RDFNode prenom=sol.get("?prenom");
				RDFNode date_naiss=sol.get("?date_naiss");
				RDFNode email=sol.get("?email");
				RDFNode address=sol.get("?address");
	            RDFNode telephone=sol.get("?telephone");
	            RDFNode code_postal=sol.get("?code_postal");
				
				if((id_auteur==null)||(nom==null)||(prenom==null)||(date_naiss==null)||(email==null)||(address==null)||(telephone==null)||(code_postal==null)){
					System.out.println("there are no data");
				}else {
					
				Auteur auteur= new Auteur();
				 auteur.setId_auteur(id_auteur.toString());
				 auteur.setNom(nom.toString());
				 auteur.setPrenom(prenom.toString());
				 auteur.setDate_naiss(date_naiss.toString());
				 auteur.setEmail(email.toString());
				 auteur.setAddress(address.toString());
				 auteur.setTelephone(telephone.toString());
                 auteur.setCode_postal(code_postal.toString()); 
                 
				 
				 listee.add(auteur);
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return listee;
		}
	
	/********************************************************************/

	@Override
	public List<Maison> MaisonsparMC(String Nom) {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		List<Maison> listee= new ArrayList<>();
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("SELECT ?id_maison ?nom_maison ?address_maison ?siteweb ?fax_maison ?tel_maison \r\n" + 
				"	WHERE { ?s rdf:type dc:maison;\r\n" + 
				"                                       dc:id_maison ?id_maison;\r\n" + 
				"                                       dc:nom_maison ?nom_maison;\r\n" + 
				"                                       dc:address_maison ?address_maison;\r\n" + 
				"                                       dc:siteweb ?siteweb;                                                             \r\n" + 
				"                                      dc:fax_maison ?fax_maison;\r\n" + 
				"                                      dc:tel_maison ?tel_maison.\r\n" + 
				"    FILTER(regex(?nom_maison ,\""+Nom+"\",\"i\"))}"
						+ "ORDER BY ?id_maison");
		
		Query query= QueryFactory.create(buffer.toString());  
	
		QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
	
		
		try {
			ResultSet response=queryExecution.execSelect();  
	
			while(response.hasNext()) {
				QuerySolution sol= response.nextSolution();
	
				RDFNode id_maison=sol.get("?id_maison");
				RDFNode nom_maison=sol.get("?nom_maison");
				RDFNode address_maison=sol.get("?address_maison");
				RDFNode siteweb=sol.get("?siteweb");
				RDFNode fax_maison=sol.get("?fax_maison");
				RDFNode tel_maison=sol.get("?tel_maison");
				
				if((id_maison==null)||(nom_maison==null)||(address_maison==null)||(siteweb==null)||(fax_maison==null)||(tel_maison==null)){
					System.out.println("there are no data");
				}else {
					
				 Maison maison= new Maison();
				 maison.setId_maison(id_maison.toString());
				 maison.setNom_maison(nom_maison.toString());
				 maison.setAddress_maison(address_maison.toString());
				 maison.setSiteweb(siteweb.toString());
				 maison.setFax_maison(fax_maison.toString());
				 maison.setTel_maison(tel_maison.toString()); 
                 
				 
				 listee.add(maison);
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return listee;
	}
	
	/********************************************************************/
	@Override
	public Livre getLivre(String ID) {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		Livre livre= new Livre();
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("SELECT ?id_auteur ?id_maison ?url ?titre ?sous_titre  ?resume ?categorie ?isbn ?nom_maison  ?nom ?prenom\r\n"
				+ "				WHERE  {?s rdf:type dc:livre;                                       \r\n"
				+ "				                      dc:titre ?titre;\r\n"
				+ "				                       dc:sous-titre ?sous_titre;\r\n"
				+ "				                        dc:resume ?resume;\r\n"
				+ "				                       dc:categorie ?categorie;\r\n"
				+ "				                      dc:isbn ?isbn;      \r\n"
				+ "				                        dc:hasURL ?url.     \r\n"
                +"OPTIONAL {?s dc:ecrit_par ?ss.\r\n"
                + "				    ?ss dc:id_auteur ?id_auteur. ?ss dc:nom ?nom.  ?ss dc:prenom ?prenom. }\r\n"
                + " OPTIONAL{  ?s dc:publie ?sss.  ?sss dc:id_maison ?id_maison.  ?sss dc:nom_maison ?nom_maison.}"
		
				+ "                       FILTER(?isbn =\""+ID+"\")}");
		
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
				RDFNode nom=sol.get("?nom");
				RDFNode prenom=sol.get("?prenom");
				RDFNode nom_maison=sol.get("?nom_maison");
				RDFNode imageurl=sol.get("?url");
				RDFNode id_auteur=sol.get("?id_auteur");
				RDFNode id_maison=sol.get("?id_maison");
				
				if((titre==null)||(sousTitre==null)||(categorie==null)||(resume==null)||(isbn==null)||(imageurl==null)){
					System.out.println("there are no data");
				}else {
					
					livre.setCategorie(categorie.toString());
					 livre.setIsbn(isbn);
					 livre.setResume(resume.toString());
					 livre.setSous_titre(sousTitre.toString());
					 livre.setTitre(titre.toString());
					 livre.setUrlimage(imageurl.toString());
					 if((nom==null) ||(prenom==null)||(id_auteur==null)) {
						 livre.setNom_auteur("");
						 livre.setPrenom_auteur("");
						 livre.setId_auteur("");
					 }else {
						 livre.setNom_auteur(nom.toString());
						 livre.setPrenom_auteur(prenom.toString());
						 livre.setId_auteur(id_auteur.toString());
					 }
					 if((nom_maison==null) ||(id_maison==null)) {
						 livre.setId_maison("");
						 livre.setMaison("");
					 }else {
					 livre.setMaison(nom_maison.toString());
					 livre.setId_maison(id_maison.toString());}
				 
				 
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return livre;
	}
	
	/********************************************************************/
	@Override
	 public Auteur getAuteur(String ID) {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		Auteur auteur= new Auteur();  
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
buffer.append("SELECT ?nom ?prenom ?date_naiss  ?telephone ?email ?address ?id_auteur ?code_postal  \r\n"
		+ "					WHERE { ?s rdf:type dc:auteur; \r\n"
		+ "				                                     dc:nom ?nom; \r\n"
		+ "				                                     dc:prenom ?prenom;\r\n"
		+ "				                                    dc:date_naiss ?date_naiss; \r\n"
		+ "				                                   dc:email ?email; \r\n"
		+ "				                                    dc:address ?address;\r\n"
		+ "				                                   dc:telephone ?telephone;\r\n"
		+ "			                                                          dc:id_auteur ?id_auteur;\r\n"
		+ "				                                    dc:code_postal ?code_postal.\r\n"
		+ "				FILTER(?id_auteur =\""+ID+"\")}");
				
                        Query query= QueryFactory.create(buffer.toString());  
			
                        QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
			
				
                      try {
                       ResultSet response=queryExecution.execSelect();  
			
                       while(response.hasNext()) {
                       QuerySolution sol= response.nextSolution();
                       RDFNode id_auteur=sol.get("?id_auteur");
						RDFNode nom=sol.get("?nom");
						RDFNode prenom=sol.get("?prenom");
						RDFNode date_naiss=sol.get("?date_naiss");
						RDFNode email=sol.get("?email");
						RDFNode address=sol.get("?address");
			            RDFNode telephone=sol.get("?telephone");
			            RDFNode code_postal=sol.get("?code_postal");
				
			            if((nom==null)||(prenom==null)||(date_naiss==null)||(email==null)||(address==null)||(telephone==null)||(id_auteur==null)||(code_postal==null)){
							System.out.println("there are no data");
						}else {
							
						    
							auteur.setId_auteur(id_auteur.toString());
							 auteur.setNom(nom.toString());
							 auteur.setPrenom(prenom.toString());
							 auteur.setDate_naiss(date_naiss.toString());
							 auteur.setEmail(email.toString());
							 auteur.setAddress(address.toString());
							 auteur.setTelephone(telephone.toString());
			                 auteur.setCode_postal(code_postal.toString());
		               
						} 						
					} 
				}finally {
				
					queryExecution.close();
				}
		
		return auteur;
	}

	/********************************************************************/
	
	@Override
	public Maison getMaison(String ID) {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		Maison maison= new Maison();
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("SELECT ?id_maison ?nom_maison ?address_maison ?siteweb ?fax_maison ?tel_maison \r\n" + 
				"	WHERE { ?s rdf:type dc:maison;\r\n" + 
				"                                       dc:id_maison ?id_maison;\r\n" + 
				"                                       dc:nom_maison ?nom_maison;\r\n" + 
				"                                       dc:address_maison ?address_maison;\r\n" + 
				"                                       dc:siteweb ?siteweb;                                                             \r\n" + 
				"                                      dc:fax_maison ?fax_maison;\r\n" + 
				"                                      dc:tel_maison ?tel_maison.\r\n" + 
				"     FILTER(?id_maison =\""+ID+"\")}");
		
		Query query= QueryFactory.create(buffer.toString());  
	
		QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
	
		
		try {
			ResultSet response=queryExecution.execSelect();  
	
			while(response.hasNext()) {
				QuerySolution sol= response.nextSolution();
	
				RDFNode id_maison=sol.get("?id_maison");
				RDFNode nom_maison=sol.get("?nom_maison");
				RDFNode address_maison=sol.get("?address_maison");
				RDFNode siteweb=sol.get("?siteweb");
				RDFNode fax_maison=sol.get("?fax_maison");
				RDFNode tel_maison=sol.get("?tel_maison");
				
				if((id_maison==null)||(nom_maison==null)||(address_maison==null)||(siteweb==null)||(fax_maison==null)||(tel_maison==null)){
					System.out.println("there are no data");
				}else {
					
				 
				 maison.setId_maison(id_maison.toString());
				 maison.setNom_maison(nom_maison.toString());
				 maison.setAddress_maison(address_maison.toString());
				 maison.setSiteweb(siteweb.toString());
				 maison.setFax_maison(fax_maison.toString());
				 maison.setTel_maison(tel_maison.toString());  
                 
				 
				 
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return maison;
	}

	/********************************************************************/
	
	@Override
	public List<String> getCategorie() {
		
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();	
		List<String> list= new ArrayList<>();
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("SELECT DISTINCT ?categorie\r\n"
				+ "WHERE  {?s rdf:type dc:livre; \r\n"
				+ "                 dc:categorie ?categorie.}");
		
		Query query= QueryFactory.create(buffer.toString());  
	
		QueryExecution queryExecution= QueryExecutionFactory.create(query,model);  
	
		
		try {
			ResultSet response=queryExecution.execSelect();  
	
			while(response.hasNext()) {
				QuerySolution sol= response.nextSolution();
	
				RDFNode categorie=sol.get("?categorie");
				
				
				if(categorie==null){
					System.out.println("there are no data");
				}else {
					
				 list.add(categorie.toString());
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return list;
	}
	
	/********************************************************************/
	
    public void deleteAuteur(String ID) {
    	String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append(
				"DELETE { ?s ?p ?o}"
				+ "WHERE{ ?s rdf:type dc:auteur;\r\n"
				+ "          dc:id_auteur ?id_auteur;"
				+ "                ?p ?o.\r\n"
				+ "      FILTER(?p NOT IN( dc:ecrit,dc:ecrit_par)) "

				+ "FILTER(?id_auteur =\""+ID+"\")}");
		
	    UpdateAction.parseExecute(buffer.toString(), model);
	
    }
    
    /********************************************************************/
    
    public void updateDataAuteurs(Auteur aut, String ID) {
String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("DELETE{?s ?p ?o."
				+ "          ?s dc:id_auteur ?id_auteur;"
				+ "               ?p ?o.}"
				+ "INSERT {?s rdf:type dc:auteur;"
				+ "             dc:nom \""+aut.getNom()+"\";"
						+ "    dc:prenom \""+aut.getPrenom()+"\";"
						+ "    dc:id_auteur \""+aut.getId_auteur()+"\";"
						+ "    dc:email  \""+aut.getEmail()+"\";"
						+ "    dc:date_naiss \""+aut.getDate_naiss()+"\";"
					    + "    dc:address   \""+aut.getAddress()+"\";"
					    + "    dc:telephone  \""+aut.getTelephone()+"\";"
					    + "    dc:code_postal   \""+aut.getCode_postal()+"\".}"
					    +  "WHERE{ ?s rdf:type dc:auteur;\r\n"
						+ "          dc:id_auteur ?id_auteur;"
						+ "                ?p ?o.\r\n"
						+ "      FILTER(?p NOT IN( dc:ecrit,dc:ecrit_par)) "

						+ "FILTER(?id_auteur =\""+ID+"\")}"
				              );

	    UpdateAction.parseExecute(buffer.toString(), model);
	
    }
    
    /********************************************************************/
    
  public void deleteMaison(String ID) {
	  String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append(
				"DELETE { ?s ?p ?o}"
				+ "WHERE{ ?s rdf:type dc:maison;\r\n"
				+ "          dc:id_maison ?id_maison;"
				+ "                ?p ?o.\r\n"
				+ "      FILTER(?p NOT IN( dc:publie)) "

				+ "FILTER(?id_maison =\""+ID+"\")}");
		
	    UpdateAction.parseExecute(buffer.toString(), model);

  }
  
  /********************************************************************/
  
  public void deleteLivre(String ID) {
	  String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
	
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append(
				"DELETE { ?s ?p ?o}"
				+ "WHERE{ ?s rdf:type dc:livre;\r\n"
				+ "          dc:isbn ?isbn;"
				+ "                ?p ?o.\r\n"
				+ "      FILTER(?p NOT IN( dc:publie,dc:ecrit,dc:ecrit_par)) "

				+ "FILTER(?isbn =\""+ID+"\")}");
		
	    UpdateAction.parseExecute(buffer.toString(), model);
	
  }
  
  /********************************************************************/
  
  public void UpdateDataMaison(Maison maison ,String ID) {
	  String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("DELETE{?s ?p ?o."
				+ "          ?s dc:id_maison ?id_maison;"
				+ "               ?p ?o.}"
				+ "INSERT {?s rdf:type dc:maison;"
				+ "             dc:nom_maison \""+maison.getNom_maison()+"\";"
						+ "    dc:id_maison \""+maison.getId_maison()+"\";"
						+ "    dc:address_maison \""+maison.getAddress_maison()+"\";"
					    + "    dc:siteweb   \""+maison.getSiteweb()+"\";"
					    + "    dc:tel_maison  \""+maison.getTel_maison()+"\";"
					    + "    dc:fax_maison   \""+maison.getFax_maison()+"\".}"
					    +  "WHERE{ ?s rdf:type dc:maison;\r\n"
						+ "          dc:id_maison ?id_maison;"
						+ "                ?p ?o.\r\n"
						+ "      FILTER(?p NOT IN( dc:publie)) "

						+ "FILTER(?id_maison =\""+ID+"\")}"
				              );
		  
	    UpdateAction.parseExecute(buffer.toString(), model);
  }
  
 /*************************************************************/ 
  
  public void updateDataLivre(Livre livre,String ID) {
	  String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
		buffer.append("DELETE{?s ?p ?o."
				+ "          ?s dc:isbn ?isbn;"
				+ "               ?p ?o.}"
				+ "INSERT {?s rdf:type dc:livre ;"
				+ "             dc:titre  \""+livre.getTitre()+"\";"
						+ "    dc:sous-titre  \""+livre.getSous_titre()+"\";"
						+ "    dc:categorie  \""+livre.getCategorie()+"\";"
						+ "    dc:resume   \""+livre.getResume()+"\";"
						+ "    dc:isbn  \""+livre.getIsbn()+"\";"
						+ "    dc:hasURL  \""+livre.getUrlimage()+"\".}"
					    +  "WHERE{ ?s rdf:type dc:livre;\r\n"
						+ "          dc:isbn ?isbn;"
						+ "                ?p ?o.\r\n"
						+ "      FILTER(?p NOT IN( dc:ecrit,dc:ecrit_par,dc:publie)) "

						+ "FILTER(?isbn =\""+ID+"\")}"
				              );
	
 
	    UpdateAction.parseExecute(buffer.toString(), model); 
  }
  
  

}



