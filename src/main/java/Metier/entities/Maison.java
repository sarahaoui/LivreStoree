package Metier.entities;

public class Maison {
	private int id_maison;
	private String nom_maison,address_maison,siteweb,fax_maison,tel_maison,nom_auteur,prenom_auteur,maison;
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

	public Maison(int id_maison, String nom_maison, String address_maison, String siteweb, String fax_maison,
			String tel_maison,String nom_auteur,String prenom_auteur,String maison) {
		super();
		this.id_maison = id_maison;
		this.nom_maison = nom_maison;
		this.address_maison = address_maison;
		this.siteweb = siteweb;
		this.fax_maison = fax_maison;
		this.tel_maison = tel_maison;
		this.nom_maison = nom_maison;
		this.nom_auteur = nom_auteur;
		this.prenom_auteur = prenom_auteur;
	}
	
	public Maison() {
		super();
	}

	public int getId_maison() {
		return id_maison;
	}

	public void setId_maison(int id_maison) {
		this.id_maison = id_maison;
	}

	public String getNom_maison() {
		return nom_maison;
	}

	public void setNom_maison(String nom_maison) {
		this.nom_maison = nom_maison;
	}

	public String getAddress_maison() {
		return address_maison;
	}

	public void setAddress_maison(String address_maison) {
		this.address_maison = address_maison;
	}

	public String getSiteweb() {
		return siteweb;
	}

	public void setSiteweb(String siteweb) {
		this.siteweb = siteweb;
	}

	public String getFax_maison() {
		return fax_maison;
	}

	public void setFax_maison(String fax_maison) {
		this.fax_maison = fax_maison;
	}

	public String getTel_maison() {
		return tel_maison;
	}

	public void setTel_maison(String tel_maison) {
		this.tel_maison = tel_maison;
	}
	

}
