package Metier.entities;

public class Auteur {
	
	private String code_postal; String telephone; String id_auteur;
	private String date_naiss,nom,prenom,address,email;
	public Auteur(String id_auteur, String telephone, String code_postal, String date_naiss, String nom, String prenom,
			String address, String email) {
		super();
		this.id_auteur = id_auteur;
		this.telephone = telephone;
		this.code_postal = code_postal;
		this.date_naiss = date_naiss;
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.email = email;
	}
	
	public Auteur() {
		super();
	}

	public String getId_auteur() {
		return id_auteur;
	}

	public void setId_auteur(String id_auteur) {
		this.id_auteur = id_auteur;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
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
	
 public String toString() {
		return "Auteur[Id_auteur= "+id_auteur+" , Nom=" + nom + " , Prenom=" + prenom + " , Date_naiss=" + date_naiss + " , Telephone=" + telephone + " , Email="+ email +" , Address="+address+" , Code_postal="+code_postal+"].";

 }
}
