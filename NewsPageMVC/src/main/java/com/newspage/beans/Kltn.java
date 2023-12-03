package com.newspage.beans;



public class Kltn {

	private int mkl;
	private String detai;
	private String mgv;
	private String msv;
	private String cstt;
	private int idhk;
	private Byte duyet;
	
	private Sinhvien sinhvien;
	private Giangvien giangvien;
	
	
	public int getMkl() {    
	    return mkl;    
	}    
	public void setMkl(int mkl) {    
	    this.mkl = mkl;    
	}
	
	public int getIdhk() {    
	    return idhk;    
	}    
	public void setIdhk(int idhk) {    
	    this.idhk = idhk;    
	}
	
	public String getDetai() {    
	    return detai;    
	}    
	public void setDetai(String detai) {    
	    this.detai = detai;    
	}
	
	public String getMsv() {    
	    return msv;    
	}    
	public void setMsv(String msv) {    
	    this.msv = msv;    
	}
	
	public String getMgv() {    
	    return mgv;    
	}    
	public void setMgv(String mgv) {    
	    this.mgv = mgv;    
	}
	
	public String getCstt() {    
	    return cstt;    
	}    
	public void setCstt(String cstt) {    
	    this.cstt = cstt;    
	}
	
	public Byte getDuyet() {    
	    return duyet;    
	}    
	public void setDuyet(Byte duyet) {    
	    this.duyet = duyet;    
	}
	
	
	public Sinhvien getSinhvien() {
		return sinhvien;
	}
	public void setSinhvien(Sinhvien sinhvien) {
		this.sinhvien = sinhvien;
	}
	
	public Giangvien getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(Giangvien giangvien) {
	    this.giangvien = giangvien;
	}
}
