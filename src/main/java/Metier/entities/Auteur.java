package Metier.entities;

public class Auteur {
	private int id_auteur,telephone,codepostal;
	private String date_naiss,nom,prenom,address,email;
	public Auteur(int id_auteur, int telephone, int codepostal, String date_naiss, String nom, String prenom,
			String address, String email) {
		super();
		this.id_auteur = id_auteur;
		this.telephone = telephone;
		this.codepostal = codepostal;
		this.date_naiss = date_naiss;
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.email = email;
	}
	
	public Auteur() {
		super();
	}

	public int getId_auteur() {
		return id_auteur;
	}

	public void setId_auteur(int id_auteur) {
		this.id_auteur = id_auteur;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public int getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public String getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
