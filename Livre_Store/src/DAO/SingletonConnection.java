package DAO;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class SingletonConnection {
	
	private static String DefaultNameSpace="http://www.livre.com/ontologies/livre.owl#" ;
	private static Model model=null;
	
	static {
		model=ModelFactory.createOntologyModel();  
		java.io.InputStream in=FileManager.get().open("C:/livre.owl");  
		if(in==null) {
			throw new IllegalArgumentException("fichier ontologie intruovable");  }
		else {
			model.read(in,DefaultNameSpace); 
		
		}
	}

	public static Model getModel() {
		return model;
	}
	public static String getDefaultNameSpace() {
		return DefaultNameSpace;
	}

}
