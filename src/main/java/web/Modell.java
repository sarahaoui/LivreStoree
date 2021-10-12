package web;

import java.util.ArrayList;
import java.util.List;

import Metier.entities.Auteur;
import Metier.entities.Livre;
import Metier.entities.Maison;

public class Modell {
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
	private String mc,categorie;
	private List<Auteur> auteurs= new ArrayList<Auteur>();
	public List<String> getListcategorie() {
		return listcategorie;
	}
	public void setListcategorie(List<String> listcategorie) {
		this.listcategorie = listcategorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	private List<Livre> livres= new ArrayList<Livre>();
	private List<Maison> maisons= new ArrayList<Maison>();
	private List<String> listcategorie= new ArrayList<String>();

}
