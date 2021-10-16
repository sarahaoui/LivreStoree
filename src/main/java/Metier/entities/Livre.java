package Metier.entities;

public class Livre {
	
	private String id_auteur,id_maison,titre,sous_titre,resume,categorie,isbn,nom_auteur,prenom_auteur,maison,urlimage;
	
	public String getId_auteur() {
		return id_auteur;
	}
	public void setId_auteur(String id_auteur) {
		this.id_auteur = id_auteur;
	}
	public String getId_maison() {
		return id_maison;
	}
	public void setId_maison(String id_maison) {
		this.id_maison = id_maison;
	}
	public Livre(String id_auteur,String id_maison,String urlimage,String isbn, String titre, String sous_titre, String resume, String categorie,String nom_auteur,String prenom_auteur,String maison) {
		super();
		this.id_auteur=id_auteur;
		this.id_maison=id_maison;
		this.isbn = isbn;
		this.titre = titre;
		this.sous_titre = sous_titre;
		this.resume = resume;
		this.categorie = categorie;
		this.maison = maison;
		this.nom_auteur = nom_auteur;
		this.prenom_auteur = prenom_auteur;
		this.urlimage=urlimage;
	}
	public Livre() {
		super();
	}
	public String getUrlimage() {
		return urlimage;
	}
	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}
	public String getNom_auteur() {
		return nom_auteur;
	}

	public void setNom_auteur(String nom_auteur) {
		this.nom_auteur = nom_auteur;
	}

	public String getPrenom_auteur() {
		return prenom_auteur;
	}

	public void setPrenom_auteur(String prenom_auteur) {
		this.prenom_auteur = prenom_auteur;
	}

	public String getMaison() {
		return maison;
	}

	public void setMaison(String maison) {
		this.maison = maison;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSous_titre() {
		return sous_titre;
	}
	public void setSous_titre(String sous_titre) {
		this.sous_titre = sous_titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Livre [url="+urlimage+"isbn=" + isbn + ", titre=" + titre + ", sous-titre=" + sous_titre + ", resume=" + resume + " categorie="+categorie+" nom_auteur="+nom_auteur+" prenom _auteur="+prenom_auteur+" maison="+maison+"]";
	}

	
}
