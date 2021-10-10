package web;

import java.util.ArrayList;
import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public class Model {
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public List<Auteur> getAuteurs() {
		return auteurs;
	}
	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}
	public List<Livre> getLivres() {
		return livres;
	}
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	public List<Maison> getMaisons() {
		return maisons;
	}
	public void setMaisons(List<Maison> maisons) {
		this.maisons = maisons;
	}
	private String mc;
	private List<Auteur> auteurs= new ArrayList<Auteur>();
	private List<Livre> livres= new ArrayList<Livre>();
	private List<Maison> maisons= new ArrayList<Maison>();

}
