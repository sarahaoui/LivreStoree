package DAO;
import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public interface InterfaceDAO {
	
	public List<Livre> LivresparMC(String MC,String Categorie);
	public List<Auteur> AuteursparMC(String Nom);
	public List<Maison> MaisonsparMC(String Nom);
	
	public Livre getLivre(String ID);
	public Auteur getAuteur(String ID);
	public Maison getMaison(String ID);
	public List<String> getCategorie();
	
	
	

}
