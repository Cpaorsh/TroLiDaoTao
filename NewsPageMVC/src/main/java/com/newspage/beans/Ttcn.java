package com.newspage.beans;

public class Ttcn {

	private int mdt;
	private String msv;
	private String cstt;
	
	private Sinhvien sinhvien;
	private Detaitt detaitt;
	
	public Sinhvien getSinhvien() {
		return sinhvien;
	}
	public void setSinhvien(Sinhvien sinhvien) {
		this.sinhvien = sinhvien;
	}

	public Detaitt getDetaitt() {
		return detaitt;
	}
	public void setDetaitt(Detaitt detaitt) {
	    this.detaitt = detaitt;
	}
	
	
	public int getMdt() {    
	    return mdt;    
	}    
	public void setMdt(int mdt) {    
	    this.mdt = mdt;    
	}
	
	public String getCstt() {    
	    return cstt;    
	}    
	public void setCstt(String cstt) {    
	    this.cstt = cstt;    
	}
	
	public String getMsv() {    
	    return msv;    
	}    
	public void setMsv(String msv) {    
	    this.msv = msv;    
	}

}
