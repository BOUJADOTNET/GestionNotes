package com.Boujadotnet.gestionetudiant;

public class Matiere {

	 private int CodeMatire ;
	 private String Designation ;
	 private String volume;
	 
	public Matiere(int codeMatire, String designation, String volume) {
		super();
		CodeMatire = codeMatire;
		Designation = designation;
		this.volume = volume;
	}
	  	
	public Matiere() {
			
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
