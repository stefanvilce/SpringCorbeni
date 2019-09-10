package com.irisoft.corbeni.model;

public class Image {
	private int id;  
    private String imagName;
    private String url;
    private int pagesId;
    private String principala;
    
    public void setId(int imageId) {
		this.id = imageId;
	}
	public int getId() {
		return id;
	}
	public String getImagName() {
		return imagName;
	}
	public void setImagName(String imagName) {
		this.imagName = imagName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPagesId() {
		return pagesId;
	}
	public void setPagesId(int pagesId) {
		this.pagesId = pagesId;
	}
	public String getPrincipala() {
		return principala;
	}
	public void setPrincipala(String principala) {
		this.principala = principala;
	}
}
