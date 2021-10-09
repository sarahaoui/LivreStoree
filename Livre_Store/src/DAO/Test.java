package DAO;

import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public class Test {

	public static void main(String[] args) {
		InterfaceImplDAO imp = new InterfaceImplDAO();
		
   ///////////////////////////////////////////////////////////////////		
        
       List<Livre> livres= imp.LivresparMC("sparql");
		
		for(Livre p :livres) {
			System.out.println(p.toString());
		}
   ///////////////////////////////////////////////////////////////////	
		
		 List<Auteur> auteurs= imp.AuteursparMC("smith");
			
			for(Auteur p :auteurs) {
				System.out.println(p.toString());
			}
    ///////////////////////////////////////////////////////////////////	
			List<Maison> maisons= imp.MaisonsparMC("kitab");
			for(Maison p :maisons) {
				System.out.println(p.toString());
			}
   ///////////////////////////////////////////////////////////////////			
		Auteur auteur= imp.getAuteur("9");
		System.out.println(auteur.toString());
			
			/////////////////////////////////////			 
	}

}
