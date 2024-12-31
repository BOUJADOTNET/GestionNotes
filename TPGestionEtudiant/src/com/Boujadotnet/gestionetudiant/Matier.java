package com.Boujadotnet.gestionetudiant;

public class Matier {

	

	 private int CodeMatire ;
	 private String Designation ;
	 private String volume;
	 
	  public Matier(int codeMatire, String designation, String volume) {
		super();
		CodeMatire = codeMatire;
		Designation = designation;
		this.volume = volume;
	  }
	  	
	 public Matier() {
			
		}
	 
	public int getCodeMatire() {
		return CodeMatire;
	}

	public void setCodeMatire(int codeMatire) {
		CodeMatire = codeMatire;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
}
