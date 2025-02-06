package com.Boujadotnet.gestionetudiant;

public class Etudiant {

	private int idPers;
	private String firstName;
	private String lastName;
	private String address;
	private String telPhone;
	
	public int getIdPers() {
		return idPers;
	}
	public void setIdPers(int idPers) {
		this.idPers = idPers;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	
	
	public Etudiant(int idPers ,String firstName, String lastName, String address, String telPhone) {
		super();
		this.idPers = idPers;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telPhone = telPhone;
	}


	
}
