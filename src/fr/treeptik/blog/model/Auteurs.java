package fr.treeptik.blog.model;

import java.io.Serializable;

public class Auteurs implements  Serializable{
	private final static long serialVersionUID = 1l;
	
	private Integer autId;
	private String autNom;
	private String autPrenom;
	private String autUrl;
	private String autEmail;
	public Auteurs() {
		super();
	}
	public Auteurs(Integer autId, String autNom, String autPrenom,
			String autUrl, String autEmail) {
		super();
		this.autId = autId;
		this.autNom = autNom;
		this.autPrenom = autPrenom;
		this.autUrl = autUrl;
		this.autEmail = autEmail;
	}
	public Integer getAutId() {
		return autId;
	}
	public void setAutId(Integer autId) {
		this.autId = autId;
	}
	public String getAutNom() {
		return autNom;
	}
	public void setAutNom(String autNom) {
		this.autNom = autNom;
	}
	public String getAutPrenom() {
		return autPrenom;
	}
	public void setAutPrenom(String autPrenom) {
		this.autPrenom = autPrenom;
	}
	public String getAutUrl() {
		return autUrl;
	}
	public void setAutUrl(String autUrl) {
		this.autUrl = autUrl;
	}
	public String getAutEmail() {
		return autEmail;
	}
	public void setAutEmail(String autEmail) {
		this.autEmail = autEmail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
