package com.Boujadotnet.gestionetudiant;

public class Matiere {

	 private String CodeMatire ;
	 private String Designation ;
	 private String volume;
	 
	public Matiere(String codeMatire, String designation, String volume) {
		super();
		CodeMatire = codeMatire;
		Designation = designation;
		this.volume = volume;
	}
	  	
	public Matiere() {
			
	}


	public String getCodeMatire() {
		return CodeMatire;
	}

	public void setCodeMatire(String codeMatire) {
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
