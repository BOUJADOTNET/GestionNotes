package com.Boujadotnet.gestionetudiant;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestionNotes {
	
	    public int addEtudiant(Etudiant etudiant) {
	    	String sql = "INSERT INTO etudiants (nom, prenom, adresse, telephone) VALUES (?, ?, ?, ?)";

	        try (Connection conn = ConnectionHelper.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
	            // Définir les valeurs des paramètres
	        	
	            pstmt.setString(1, etudiant.getLastName());
	            pstmt.setString(2, etudiant.getFirstName());
	            pstmt.setString(3, etudiant.getAddress());
	            pstmt.setString(4, etudiant.getTelPhone());
	            //pstmt.executeUpdate();
	            // Exécuter la requête
	            int rowsInserted = pstmt.executeUpdate();
	            if (rowsInserted > 0) {
	                //ystem.out.println("Étudiant ajouté avec succès !");
	            	try (ResultSet generatekey=pstmt.getGeneratedKeys())
	            	{
	            		if(generatekey.next()) 
	            		{
	            			int generateID = generatekey.getInt(1);
	            			etudiant.setIdPers(generateID);
	            			System.out.println("Étudiant ajouté avec succès !");
	            		}
	            	}
	            }
	          
	        } catch (SQLException e) {
	            System.out.println("Erreur lors de l'ajout de l'étudiant : " + e.getMessage());
	        }
	        return etudiant.getIdPers();  // En cas d'échec
		}
	    
	    public void addMatiere(Matiere matiere) {
	    	String sql = "INSERT INTO matieres (code, designation, volume_horaire) VALUES (?, ?, ?)";

	        try (Connection conn = ConnectionHelper.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            // Définir les valeurs des paramètres
	        	
	            pstmt.setString(1, matiere.getCodeMatire());
	            pstmt.setString(2, matiere.getDesignation());
	            pstmt.setString(3, matiere.getVolume());
	        

	            // Exécuter la requête
	            int rowsInserted = pstmt.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Matiere ajouté avec succès !");
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur lors de l'ajout de l'étudiant : " + e.getMessage());
	        }
	   }
	    
	    public void addNote(Note note)
	    {
	    	String query = "INSERT INTO Notes ( code_etudiant ,code_matiere, valeur) VALUES (?,?, ?)";
	        try (Connection conn = ConnectionHelper.getConnection(); 	
	        		PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, note.getEtudiant().getIdPers());
	            stmt.setString(2, note.getMatiere().getCodeMatire());
	            stmt.setDouble(3, note.getNote());
	            stmt.executeUpdate();
	            System.out.println("la note ajouté avec succès  ");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
	        }
	    	
	    }
	    
	    public Etudiant consulterEtudiantById(int idPers)
	    {
	    	String Sql = "SELECT * FROM etudiants WHERE code = ? ";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		stmt.setInt(1, idPers);
	    		try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return new Etudiant(
	                        rs.getInt("code"),
	                        rs.getString("nom"),
	                        rs.getString("prenom"),
	                        rs.getString("adresse"),
	                        rs.getString("telephone")
	                    );
	                }
	                else {
	                    // If no matching student is found
	                	
	                    System.out.println("Student with id " + idPers + " does not exist.");
	                }
	            }
	    		
	    		
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
				 System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
			}
	    	return null;
	    	
	    }
	    public Etudiant consulterMatiereById(String codeMatiere)
	    {
	    	String Sql = "Select * from matieres where id ?";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		stmt.setString(1, codeMatiere);
	    		try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return new Etudiant(
	                        rs.getString("code"),
	                        rs.getString("designation"),
	                        rs.getString("volume_horaire")
	                       /// rs.getString("adresse"),
	                        //rs.getString("telephone")
	                    );
	                }
	                else {
	                    // If no matching student is found
	                	
	                    System.out.println("Student with id " + codeMatiere + " does not exist.");
	                }
	            }
	    		
	    		
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
				 System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
			}
	    	return null;
	    	
	    }
}
