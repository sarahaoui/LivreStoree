package DAO;

import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;


public class Test {

	public static void main(String[] args) {
		InterfaceImplDAO imp = new InterfaceImplDAO();
		/*List<Livre>livres=imp.LivresparMC("","Manga");
		for(Livre p :livres) {
			System.out.println(p.toString());
		}*/
		
	/***********************************************************/
		imp.deleteAuteur("7");
	    List<Auteur> auteur= imp.AuteursparMC("");
		
		for(Auteur p :auteur) {
			System.out.println(p.toString());
		}
		
   /***********************************************************/
 /*List<Maison> maison= imp.MaisonsparMC("");
		
		for(Maison p :maison) {
			System.out.println(p.toString());
		}
  /***********************************************************/	
		
	
/***********************************************************/		
		/*Auteur aut = imp.getAuteur("9");
		System.out.println(aut.toString());*/
 /***********************************************************/	
		/*Maison aut = imp.getMaison("1");
		System.out.println(aut.toString());*/
		 
		

	}

}
