package DAO;
import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public interface InterfaceDAO {
	
	public List<Livre> LivresparMC(String MC);
	public List<Auteur> AuteursparMC(String MC);
	public List<Maison> MaisonsparMC(String MC);
	
	public Livre getLivre(int ID);
	public Auteur getAuteur(int ID);
	public Maison getMaison(int ID);
	
	
	

}
