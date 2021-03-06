package Metier.entities;

public class Maison{
	
	private String id_maison,fax_maison,tel_maison;
	private String nom_maison,address_maison,siteweb;
	

	public Maison(String id_maison, String nom_maison, String address_maison, String siteweb, String fax_maison,
			String tel_maison) {
		super();
		this.id_maison = id_maison;
		this.nom_maison = nom_maison;
		this.address_maison = address_maison;
		this.siteweb = siteweb;
		this.fax_maison = fax_maison;
		this.tel_maison = tel_maison;
		
	}
	
	public Maison() {
		super();
	}

	public String getId_maison() {
		return id_maison;
	}

	public void setId_maison(String id_maison) {
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
	 public String toString() {
			return "Maison[Id_maison = " +id_maison+" , Nom_maison = " + nom_maison + " , Address_maison = " + address_maison + " , Siteweb = " + siteweb + " , Fax_maison = " + fax_maison + " , Tel_maison = "+ tel_maison +"].";

	 }	

}
