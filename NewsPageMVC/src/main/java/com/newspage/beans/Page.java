package com.newspage.beans;

import java.sql.Date;

public class Page {
	private int id;    
	private String title;    
	private String author;    
	private String content; 
	private String category;
	private Date datec;
	    
	public int getId() {    
	    return id;    
	}    
	public void setId(int id) {    
	    this.id = id;    
	}    
	public String getTitle() {    
	    return title;    
	}    
	public void setTitle(String title) {    
	    this.title = title;    
	}    
	public String getAuthor() {    
	    return author;    
	}    
	public void setAuthor(String author) {    
	    this.author = author;    
	}    
	public String getContent() {    
	    return content;    
	}    
	public void setContent(String content) {    
	    this.content = content;    
	}    
	public String getCategory() {    
	    return category;    
	}    
	public void setCategory(String category) {    
	    this.category = category;    
	}
	public Date getDatec() {    
	    return datec;    
	}    
	public void setDatec(Date datec) {    
	    this.datec = datec;    
	}

}

