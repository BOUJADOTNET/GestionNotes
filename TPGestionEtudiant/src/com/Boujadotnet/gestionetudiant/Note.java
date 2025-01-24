package com.Boujadotnet.gestionetudiant;


	
public class Note {
	
	
		private int idNote;
		private Matiere matiere;
		private Etudiant etudiant;
		private double note;
	
		
		public Note(int idNote, Matiere matiere, Etudiant etudiant, double note) {
			super();
			this.idNote = idNote;
			this.matiere = matiere;
			this.etudiant = etudiant;
			this.note = note;
		}
		
		public Note ()
		{
			
		}
		public int getIdNote() {
			return idNote;
		}
		public void setIdNote(int idNote) {
			this.idNote = idNote;
		}
		public Matiere getMatiere() {
			return matiere;
		}
		public void setMatiere(Matiere matiere) {
			this.matiere = matiere;
		}
		public Etudiant getEtudiant() {
			return etudiant;
		}
		public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
		}
		public double getNote() {
			return note;
		}
		public void setNote(double note) {
			this.note = note;
		}

}
