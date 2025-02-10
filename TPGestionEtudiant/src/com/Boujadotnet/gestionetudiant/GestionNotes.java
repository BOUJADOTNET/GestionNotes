package com.Boujadotnet.gestionetudiant;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestionNotes implements IGestionNotes   {
	
		///Ajouter un étudiant
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
	    
	    ///Ajouter une matière,
	    public void addMatiere(Matiere matiere) {
	    	String sql = "INSERT INTO matieres (codeMatiere, designation, volume_horaire) VALUES (?, ?, ?)";

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
	    
	    
	    ///Ajouter une note d’un étudiant pour une matière données
	    public void addNote(Note note)
	    {
	    	String query = "INSERT INTO Notes (codeEtudiant  ,codeMatiere , valeur) VALUES (?,?, ?)";
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
	    
	    ///Consulter un Etudiant sachant son code
	    public Etudiant consulterEtudiantById(int idPers)
	    {
	    	String Sql = "SELECT * FROM etudiants WHERE codeEtudiant = ? ";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		stmt.setInt(1, idPers);
	    		try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return new Etudiant(
	                        rs.getInt("codeEtudiant"),
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
	    
	    ///Consulter un Matiere sachant son code
	    public Matiere consulterMatiereById(String codeMatiere)
	    {
	    	String Sql = "Select * from matieres where codeMatiere =?";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		stmt.setString(1, codeMatiere);
	    		try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return new Matiere(
	                        rs.getString("codeMatiere"),
	                        rs.getString("designation"),
	                        rs.getString("volume_horaire")
	                   
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
	    
	    ///List All Etudiant
	    public List<Etudiant> AllEtudiant ()
	    {
	    	List<Etudiant> etudiants= new ArrayList<>();
	    	String Sql = "SELECT * FROM etudiants ";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		//stmt.setInt(1, idPers);
	    		try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                	 etudiants.add(new Etudiant(
	                			 rs.getInt("codeEtudiant"),
	                			 rs.getString("nom"),
	                             rs.getString("prenom"),
	                             rs.getString("adresse"),
	                             rs.getString("telephone")
	                         ));
	                }
	                
	            }
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
				 System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
			}
	    	return etudiants ;
	    }
	    
	    ///List All Matiere
	    public List<Matiere> AllMatiere () 
	    {
	    	List<Matiere> matieres= new ArrayList<>();
	    	String Sql = "SELECT * FROM matieres ";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		//stmt.setInt(1, idPers);
	    		try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                	matieres.add(new Matiere(
	                			// rs.getInt("codeEtudiant"),
	                			 rs.getString(1),
	                             rs.getString(2),
	                             rs.getString(3)
	                            // rs.getString("telephone")
	                         ));
	                }
	                
	            }
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
				 System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
			}
	    	return matieres ;
	    }
	    
	    ///les notes d’un étudiant sachant son code
	    public void showNoteEtudiantById(int code_etudiant )
	    {
	    	
	    	String Sql = "SELECT code_matiere,designation,valeur FROM notes  join matieres on notes.code_matiere = matieres.code where code_etudiant = ?";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		stmt.setInt(1, code_etudiant);
	    		
	    		 // Si l'étudiant a des notes, les afficher
	    		ResultSet rs = stmt.executeQuery();
	            if (!rs.isBeforeFirst()) {
	                System.out.println("Aucune note trouvée pour cet étudiant.");
	            } else {
	                while (rs.next()) {
	                    String matiereCode = rs.getString("code_matiere");
	                    String matiereDesignation = rs.getString("designation");
	                    double note = rs.getDouble("valeur");
	                    System.out.println("Code Matiere : " + matiereCode+" ||  Designation: " +matiereDesignation+"  ||  note: " +note);
	                    System.out.println("-----------------------------");
	                }
	            }	    		
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
				 System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
			}
	    }
	    
	    ///Supprimer un étudiant sachant son code
	    public void deleteEtudiantByID(int code_etudiant)
	    {
	    	String Sql = "delete from etudiants where code = ?";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		stmt.setInt(1, code_etudiant);
	    		stmt.executeUpdate();
	    		 System.out.println("etudiant is delete in succes !!");
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
				 System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
			}
	    	
	    }
	    
	    ///Calculer la moyenne d’un étudiant sachant son code
	    public void calculeMoyenne(int code_etudiant)
	    {
	    	String Sql = "SELECT AVG(Valeur) as average FROM notes where code_etudiant = ?";
	    	try (Connection conn = ConnectionHelper.getConnection();
	    			PreparedStatement stmt = conn.prepareStatement(Sql)
	    			) {
	    		stmt.setInt(1, code_etudiant);
	    		
	    		 // Si l'étudiant a des notes, les afficher
	    		ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	double Average = rs.getDouble(1);
	            	Average = Math.round(Average * 100.0) / 100.0;
	                System.out.println("Average of Etudiant || " + code_etudiant+ " ||  is : "+Average);
	            } 
	    		
			} catch (Exception e) {
				 e.printStackTrace();
				// TODO: handle exception
				 System.out.println("Erreur lors de l'ajout de note : " + e.getMessage());
			}
	    }
}
