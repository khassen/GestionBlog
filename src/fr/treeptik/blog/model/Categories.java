package fr.treeptik.blog.model;

import java.io.Serializable;

public class Categories implements  Serializable{
	private final static long serialVersionUID = 1l;
	
	private Integer catId;
	private String catName;
	private String catUrl;
	
	public Categories() {
		super();
	}

	public Categories(Integer catId, String catName, String catUrl) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catUrl = catUrl;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatUrl() {
		return catUrl;
	}

	public void setCatUrl(String catUrl) {
		this.catUrl = catUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
