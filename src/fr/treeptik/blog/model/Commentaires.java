package fr.treeptik.blog.model;

import java.io.Serializable;
import java.util.Date;

public class Commentaires implements  Serializable{

	private final static long serialVersionUID = 1l;
	
	private Integer comId;
	private String comNom;
	private String comEmail;
	private String comText;
	private Date comDate;
	private String comValidation;
	private Articles articles;
	
	public Commentaires() {
		super();
	}
	public Commentaires(Integer comId, String comNom, String comEmail,
			String comText, Date comDate, String comValidation, Articles articles) {
		super();
		this.comId = comId;
		this.comNom = comNom;
		this.comEmail = comEmail;
		this.comText = comText;
		this.comDate = comDate;
		this.comValidation = comValidation;
		this.articles = articles;
	}
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	public String getComNom() {
		return comNom;
	}
	public void setComNom(String comNom) {
		this.comNom = comNom;
	}
	public String getcomEmail() {
		return comEmail;
	}
	public void setcomEmail(String comEmail) {
		this.comEmail = comEmail;
	}
	public String getComText() {
		return comText;
	}
	public void setComText(String comText) {
		this.comText = comText;
	}
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	public String getComValidation() {
		return comValidation;
	}
	public void setComValidation(String comValidation) {
		this.comValidation = comValidation;
	}
	public Articles getArticles() {
		return articles;
	}
	public void setArticles(Articles articles) {
		this.articles = articles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
