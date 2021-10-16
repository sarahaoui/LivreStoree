package DAO;
import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public interface InterfaceDAO {
	
	public List<Livre> LivresparMC(String MC,String Categorie);
	public List<Auteur> AuteursparMC(String sexe,String Nom);
	public List<Maison> MaisonsparMC(String Nom);
	
	public Livre getLivre(String ID);
	public Auteur getAuteur(String ID);
	public Maison getMaison(String ID);
	
	public List<String> getCategorie();
	
	public void deleteAuteur(String ID);
	public void deleteMaison(String ID);
	public void deleteLivre(String ID);
	
	public void UpdateDataMaison(Maison maison ,String ID);
	public void updateDataLivre(Livre livre,String ID) ;
	public void updateDataAuteurs(Auteur aut, String ID);
	
	
	

}
