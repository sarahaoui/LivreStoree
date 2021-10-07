package Metier.entities;

public class Livre {
	
	private String titre,sous_titre,resume,categorie,isbn;
	public Livre(String isbn, String titre, String sous_titre, String resume, String categorie) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.sous_titre = sous_titre;
		this.resume = resume;
		this.categorie = categorie;
	}
	public Livre() {
		super();
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
		return "Livre [isbn=" + isbn + ", titre=" + titre + ", sous-titre=" + sous_titre + ", resume=" + resume + " categorie="+categorie+"]";
	}

	
}
