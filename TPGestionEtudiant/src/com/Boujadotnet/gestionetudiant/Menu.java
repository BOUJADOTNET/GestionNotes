package com.Boujadotnet.gestionetudiant;
public class Menu {
	

public static void main(String[] args) {
	GestionNotes gestionNotes= new GestionNotes();
	 Etudiant etudiant1 = new Etudiant(1,"khalid", "karimo", "av  gjjfjk", "060606006");
	 gestionNotes.addEtudiant(etudiant1);
	
	 Matiere matiere1 = new Matiere( "#00003", "Jean","10");
		gestionNotes.addMatiere(matiere1);
	Note notes = new Note(etudiant1,matiere1,18);
	gestionNotes.addNote(notes);
}
}