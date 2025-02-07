package com.Boujadotnet.gestionetudiant;

import java.util.List;

public class Menu {
	

public static void main(String[] args) {
	GestionNotes gestionNotes= new GestionNotes();
	
	////////////////////Insert Into Table Etudiant and Matiere and Note //////////////////////////
	 Etudiant etudiant1 = new Etudiant(1,"khalid", "karimo", "av  gjjfjk", "060606006");
	 gestionNotes.addEtudiant(etudiant1);
	
	 Matiere matiere1 = new Matiere( "#00003", "Jean","10");
		gestionNotes.addMatiere(matiere1);
	 Note notes = new Note(etudiant1,matiere1,18);
		gestionNotes.addNote(notes);
		
      ////////////////////Insert Into Table Etudiant and Matiere and Note //////////////////////////
		
Etudiant findByIdEtudiant =	gestionNotes.consulterEtudiantById(6);
	System.out.println("Nom :"+findByIdEtudiant.getFirstName()+" ||penom :" + findByIdEtudiant.getLastName()+"|| Adresse :"+findByIdEtudiant.getAddress()+"|| Telephone :"+findByIdEtudiant.getTelPhone());
	
	Matiere findByIdMatiere =	gestionNotes.consulterMatiereById("#00003");
	System.out.println("Code Matiere :"+findByIdMatiere.getCodeMatire()+" || Designation :" + findByIdMatiere.getDesignation()+"|| Adresse :"+findByIdMatiere.getVolume());
	
	List<Etudiant> findAllEtudiant = gestionNotes.AllEtudiant();
	for (Etudiant AllEtudiant :findAllEtudiant ) 
	{
		System.out.println(""+AllEtudiant.getFirstName()+"|| "+AllEtudiant.getLastName()+"||"+AllEtudiant.getAddress());
	}
	
	List<Matiere> findAllMatiere = gestionNotes.AllMatiere();
	for (Matiere AllMatiere :findAllMatiere ) 
	{
		System.out.println(""+AllMatiere.getCodeMatire()+"|| "+AllMatiere.getDesignation()+"||"+AllMatiere.getVolume());
	}
}
}