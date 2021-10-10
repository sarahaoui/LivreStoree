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
		
		buffer.append("SELECT ?titre ?sous_titre  ?resume ?categorie ?isbn ?nom_maison  ?nom ?prenom\r\n"
				+ "WHERE  {?s rdf:type dc:livre;                                       \r\n"
				+ "                        dc:titre ?titre;\r\n"
				+ "                        dc:sous-titre ?sous_titre;\r\n"
				+ "                        dc:resume ?resume;\r\n"
				+ "                        dc:categorie ?categorie;\r\n"
				+ "                        dc:isbn ?isbn;      \r\n"
				+ "                        dc:ecrit_par ?ss;    \r\n"
				+ "                        dc:publie ?sss.     \r\n"
				+ "                      ?ss dc:nom ?nom.\r\n"
				+ "                      ?ss dc:prenom ?prenom.\r\n"
				+ "                      ?sss dc:nom_maison ?nom_maison.\r\n"
				+ "                    FILTER (regex(?titre, \""+MC+"\",\"i\"))}");
		
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
				
				if((titre==null)||(sousTitre==null)||(categorie==null)||(resume==null)||(isbn==null)||(nom==null)||(prenom==null)||(nom_maison==null)){
					System.out.println("there are no data");
				}else {
					
				 Livre livre= new Livre();
				 livre.setCategorie(categorie.toString());
				 livre.setIsbn(isbn);
				 livre.setResume(resume.toString());
				 livre.setSous_titre(sousTitre.toString());
				 livre.setTitre(titre.toString());
				 livre.setNom_auteur(nom.toString());
				 livre.setMaison(nom_maison.toString());
				 livre.setPrenom_auteur(prenom.toString());			 
				 list.add(livre);
				 
				}
				
			}
		}finally {
		
			queryExecution.close();
		}
		return list;
	}

	@Override
	public void AuteursparMC() {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		Model model= SingletonConnection.getModel();
		
		Auteur auteur= new Auteur();  
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
buffer.append("SELECT ?id_auteur ?nom ?prenom ?date_naiss ?telephone ?email ?address ?code_postal\r\n" + 
		"	WHERE { ?s rdf:type dc:auteur;\r\n" + 
		"                                       dc:id_auteur  \""+ID+"^^xsd:string \" ;\r\n" + 
		"                                       dc:id_auteur ?id_auteur ;\r\n" + 
		"                                       dc:nom ?nom;\r\n" + 
		"                                       dc:prenom ?prenom;\r\n" + 
		"                                       dc:date_naiss ?date_naiss;\r\n" + 
		"                                       dc:email ?email;\r\n" + 
		"                                       dc:address ?address;\r\n" + 
		"                                      dc:telephone ?telephone;\r\n" + 
		"                                      dc:code_postal ?code_postal;\r\n" + 
		"}");
				
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

	@Override
	public List<Maison> MaisonsparMC(String MC) {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		Model model= SingletonConnection.getModel();
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
				"                                      dc:tel_maison ?tel_maison;\r\n" + 
				"FILTER  regex (?nom_maison, \""+MC+"\", \"i\")}");
		
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

	@Override
	public Livre getLivre(int ID) {
		Livre liste = new Livre();
		return liste;
	}

	@Override
	 public Auteur getAuteur(String ID) {
		String defaultNameSpace= SingletonConnection.getDefaultNameSpace();
		Model model= SingletonConnection.getModel();
		
		Auteur auteur= new Auteur();  
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("PREFIX dc"+": <"+defaultNameSpace+">");
		buffer.append("PREFIX rdf"+": <"+"http://www.w3.org/1999/02/22-rdf-syntax-ns#"+">");
		buffer.append("PREFIX owl"+": <"+"http://www.w3.org/2002/07/owl#"+">");
		buffer.append("PREFIX xsd"+": <"+"http://www.w3.org/2001/XMLSchema#"+">");
		buffer.append("PREFIX rdfs"+": <"+"http://www.w3.org/2000/01/rdf-schema#"+">");
		
		//now add query
		
buffer.append("SELECT ?id_auteur ?nom ?prenom ?date_naiss ?telephone ?email ?address ?code_postal\r\n" + 
		"	WHERE { ?s rdf:type dc:auteur;\r\n" + 
		"                                       dc:id_auteur  \""+ID+"^^xsd:string \" ;\r\n" + 
		"                                       dc:id_auteur ?id_auteur ;\r\n" + 
		"                                       dc:nom ?nom;\r\n" + 
		"                                       dc:prenom ?prenom;\r\n" + 
		"                                       dc:date_naiss ?date_naiss;\r\n" + 
		"                                       dc:email ?email;\r\n" + 
		"                                       dc:address ?address;\r\n" + 
		"                                      dc:telephone ?telephone;\r\n" + 
		"                                      dc:code_postal ?code_postal;\r\n" + 
		"}");
				
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

	@Override
	public Maison getMaison(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
