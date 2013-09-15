package fr.treeptik.blog.model;

import java.io.Serializable;
import java.util.Date;

public class Articles implements  Serializable{
	
	private final static long serialVersionUID = 1l;
	
	private Integer artId;
	private String artTitre;
	private String artChapeau;
	private String artContenu;
	private Date artDate;
	private boolean artEnLigne;
	private Categories ctegories;
	private Auteurs auteurs;
	
	public Articles() {
		super();
	}

	public Articles(Integer artId, String artTitre, String artChapeau,
			String artContenu, Date artDate, boolean artEnLigne,
			Categories ctegories, Auteurs auteurs) {
		super();
		this.artId = artId;
		this.artTitre = artTitre;
		this.artChapeau = artChapeau;
		this.artContenu = artContenu;
		this.artDate = artDate;
		this.artEnLigne = artEnLigne;
		this.ctegories = ctegories;
		this.auteurs = auteurs;
	}

	public Integer getArtId() {
		return artId;
	}

	public void setArtId(Integer artId) {
		this.artId = artId;
	}

	public String getArtTitre() {
		return artTitre;
	}

	public void setArtTitre(String artTitre) {
		this.artTitre = artTitre;
	}

	public String getArtChapeau() {
		return artChapeau;
	}

	public void setArtChapeau(String artChapeau) {
		this.artChapeau = artChapeau;
	}

	public String getArtContenu() {
		return artContenu;
	}

	public void setArtContenu(String artContenu) {
		this.artContenu = artContenu;
	}

	public Date getArtDate() {
		return artDate;
	}

	public void setArtDate(Date artDate) {
		this.artDate = artDate;
	}


	public Categories getCtegories() {
		return ctegories;
	}

	public void setCtegories(Categories ctegories) {
		this.ctegories = ctegories;
	}

	public Auteurs getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Auteurs auteurs) {
		this.auteurs = auteurs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artId == null) ? 0 : artId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articles other = (Articles) obj;
		if (artId == null) {
			if (other.artId != null)
				return false;
		} else if (!artId.equals(other.artId))
			return false;
		return true;
	}

	public boolean isArtEnLigne() {
		return artEnLigne;
	}

	public void setArtEnLigne(boolean artEnLigne) {
		this.artEnLigne = artEnLigne;
	}


	
	
	
	
	
	

}
