package com.newspage.beans;

public class Detaitt {
	private int mdt;
	private String tendt;
	private String mgv;
	private String lidotc;
	private int idhk;
	private Byte duyet;
	private Giangvien giangvien;
	
	public Giangvien getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(Giangvien giangvien) {
	    this.giangvien = giangvien;
	}
	
	public int getMdt() {    
	    return mdt;    
	}    
	public void setMdt(int mdt) {    
	    this.mdt = mdt;    
	}
	
	public String getTendt() {    
	    return tendt;    
	}    
	public void setTendt(String tendt) {    
	    this.tendt = tendt;    
	}
	
	public String getMgv() {    
	    return mgv;    
	}    
	public void setMgv(String mgv) {    
	    this.mgv = mgv;    
	}
	
	public String getLidotc() {    
	    return lidotc;    
	}    
	public void setLidotc(String lidotc) {    
	    this.lidotc = lidotc;    
	}
	
	public int getIdhk() {    
	    return idhk;    
	}    
	public void setIdhk(int idhk) {    
	    this.idhk = idhk;    
	}
	
	public Byte getDuyet() {    
	    return duyet;    
	}    
	public void setDuyet(Byte duyet) {    
	    this.duyet = duyet;    
	}
}
