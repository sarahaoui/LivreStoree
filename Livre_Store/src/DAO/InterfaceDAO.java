package DAO;
import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public interface InterfaceDAO {
	
	public List<Livre> LivresparMC(String MC);
	public void AuteursparMC();
	public List<Maison> MaisonsparMC(String Name);
	
	public Livre getLivre(int ID);
	public Auteur getAuteur(int ID);
	public Maison getMaison(int ID);
	
	
	

}
