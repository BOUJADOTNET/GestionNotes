package com.Boujadotnet.gestionetudiant;

import java.util.List;

public interface IGestionNotes {

	public int addEtudiant(Etudiant etudiant);
	public void addMatiere(Matiere matiere) ;
	 public void addNote(Note note);
	 public Etudiant consulterEtudiantById(int idPers);
	  public Matiere consulterMatiereById(String codeMatiere);
	  public List<Etudiant> AllEtudiant ();
	  public List<Matiere> AllMatiere ();
	  public void showNoteEtudiantById(int code_etudiant );
	  public void deleteEtudiantByID(int code_etudiant);
	  public void calculeMoyenne(int code_etudiant);
}
