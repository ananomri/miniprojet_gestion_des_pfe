  import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;

public class etudiant {

	 public JFrame thirdframe;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					etudiant window = new etudiant();
					window.thirdframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public etudiant() {
		initialize();
	}

	
	private void initialize() {
		thirdframe = new JFrame();
		thirdframe.getContentPane().setBackground(new Color(72, 119, 183));
		thirdframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Desktop\\image\\Students-icon.png"));
		thirdframe.setBounds(100, 100, 1551, 882);
		thirdframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thirdframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des etudiants");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(467, 29, 478, 49);
		thirdframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Desktop\\image\\Students-icon.png"));
		lblNewLabel_1.setBounds(623, 88, 124, 128);
		thirdframe.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel.setBounds(1323, 535, 185, 146);
		thirdframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Supprimer tout les etudiants");
		lblNewLabel_15.setForeground(new Color(0, 0, 255));
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_15.setBounds(0, 0, 204, 25);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_17 = new JLabel("d'une specialite");
		lblNewLabel_17.setForeground(new Color(0, 0, 255));
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17.setBounds(41, 22, 103, 25);
		panel.add(lblNewLabel_17);
		JButton btnNewButton_8 = new JButton("supprimer");
		btnNewButton_8.setBounds(36, 115, 108, 21);
		panel.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        String specialite = JOptionPane.showInputDialog(null, "Veuillez saisir la spécialité à supprimer :", "Supprimer étudiants par spécialité", JOptionPane.PLAIN_MESSAGE);
				   	    if (specialite != null && !specialite.isEmpty()) {
				            Connection connection = sqlconnect.conn();
				            if (connection != null) {
				                try {
				                    String sql = "DELETE FROM etudiant WHERE SPCT = ?";
				                    PreparedStatement statement = connection.prepareStatement(sql);
				                    statement.setString(1, specialite);
				                    
				                    int rowsAffected = statement.executeUpdate();
				                    if (rowsAffected > 0) {
				                        JOptionPane.showMessageDialog(null, "Les étudiants de la spécialité " + specialite + " ont été supprimés avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
				                    } else {
				                        JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé à supprimer pour la spécialité " + specialite, "Erreur", JOptionPane.ERROR_MESSAGE);
				                    }
				                    
				                    statement.close();
				                    connection.close(); 
				                } catch (SQLException ex) {
				                    ex.printStackTrace();
				                }
				            } else {
				                JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
				            }
				        } else {
				            JOptionPane.showMessageDialog(null, "Veuillez saisir la spécialité pour supprimer les étudiants", "Erreur", JOptionPane.ERROR_MESSAGE);
				        }
				    }
				});
		
				btnNewButton_8.setBackground(new Color(255, 165, 0));
				btnNewButton_8.setForeground(new Color(0, 0, 255));
				btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblNewLabel_19 = new JLabel("");
				lblNewLabel_19.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Files-Delete-File-icon.png"));
				lblNewLabel_19.setBounds(51, 43, 93, 72);
				panel.add(lblNewLabel_19);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_1.setBounds(933, 535, 185, 146);
		thirdframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Supprimer tout les etudiants");
		lblNewLabel_14.setForeground(new Color(0, 0, 255));
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(0, 5, 190, 28);
		panel_1.add(lblNewLabel_14);
		
				JButton btnNewButton_9 = new JButton("Click here");
				btnNewButton_9.setBounds(31, 115, 114, 21);
				panel_1.add(btnNewButton_9);
				btnNewButton_9.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        int confirmation = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer tous les étudiants ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
				        if (confirmation == JOptionPane.YES_OPTION) {
				            Connection connection = sqlconnect.conn();
				            if (connection != null) {
				                try {
				                    String sql = "DELETE FROM etudiant";
				                    PreparedStatement statement = connection.prepareStatement(sql);
				                    int rowsAffected = statement.executeUpdate();
				                    if (rowsAffected > 0) {
				                        JOptionPane.showMessageDialog(null, "Tous les étudiants ont été supprimés avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
				                    } else {
				                        JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
				                    }
				                    statement.close();
				                    connection.close();
				                } catch (SQLException ex) {
				                    ex.printStackTrace();
				                }
				            } else {
				                JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
				            }
				        }
				    }
				});
				
						btnNewButton_9.setBackground(new Color(255, 165, 0));
						btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnNewButton_9.setForeground(new Color(0, 0, 255));
						
						JLabel lblNewLabel_20 = new JLabel("");
						lblNewLabel_20.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Database-Delete-icon.png"));
						lblNewLabel_20.setBounds(38, 25, 83, 80);
						panel_1.add(lblNewLabel_20);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_2.setBounds(73, 226, 192, 158);
		thirdframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter un etudiant");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(26, 10, 156, 27);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\user-woman-add-icon.png"));
		lblNewLabel_3.setBounds(55, 35, 97, 72);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Click here");
		btnNewButton_1.setBounds(37, 127, 115, 21);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscrire_etudiant isnadmin;
				try {
					isnadmin = new inscrire_etudiant();
					isnadmin.inscrireframe.setVisible(true);
					thirdframe.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_3.setBounds(73, 535, 192, 146);
		thirdframe.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Afficher le nbre d'etudiants");
		lblNewLabel_10.setForeground(new Color(0, 0, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 10, 192, 13);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("par specialite");
		lblNewLabel_11.setForeground(new Color(0, 0, 255));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(43, 24, 122, 19);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\men-3-icon.png"));
		lblNewLabel_12.setBounds(34, 33, 105, 77);
		panel_3.add(lblNewLabel_12);
		JButton btnNewButton_6 = new JButton("Click here");
		btnNewButton_6.setBounds(44, 120, 115, 21);
		panel_3.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        Connection connection = sqlconnect.conn();
				        if (connection != null) {
				            try {
				                String sql = "SELECT SPCT, COUNT(*) AS nombre_etudiants FROM etudiant GROUP BY SPCT";
				                PreparedStatement statement = connection.prepareStatement(sql);

				                ResultSet result = statement.executeQuery();

				                DefaultTableModel model = new DefaultTableModel();

				                model.addColumn("Spécialité");
				                model.addColumn("Nombre d'étudiants");
				                
				                while (result.next()) {
				                    String specialite = result.getString("SPCT"); 
				                    int nombreEtudiants = result.getInt("nombre_etudiants");
				                    model.addRow(new Object[]{specialite, nombreEtudiants});
				                }

				                JTable table = new JTable(model);

				                JOptionPane.showMessageDialog(null, new JScrollPane(table), "Nombre d'étudiants par spécialité", JOptionPane.INFORMATION_MESSAGE);

				                result.close();
				                statement.close();
				                connection.close(); 
				            } catch (SQLException ex) {
				                ex.printStackTrace();
				            }
				        } else {
				            JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
				        }

			}
		});
		btnNewButton_6.setBackground(new Color(255, 165, 0));
		btnNewButton_6.setForeground(new Color(0, 0, 255));
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_4.setBounds(1316, 223, 192, 146);
		thirdframe.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Afficher la liste des etudiants");
		lblNewLabel_8.setBounds(0, 5, 192, 19);
		lblNewLabel_8.setForeground(new Color(0, 0, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\user-man-info-2-icon.png"));
		lblNewLabel_9.setBounds(54, 32, 91, 79);
		panel_4.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Click here");
		btnNewButton.setBounds(31, 115, 133, 21);
		panel_4.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Connection connection = sqlconnect.conn();
                if (connection != null) {
                    try {
                        String sql = "SELECT * FROM etudiant";
                        PreparedStatement statement = connection.prepareStatement(sql);

                        ResultSet result = statement.executeQuery();

                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("Nom");
                        model.addColumn("PRENOM");
                        model.addColumn("CIN");
                        model.addColumn("PW");
                        model.addColumn("MAIL");
                        model.addColumn("SPCT");
                        while (result.next()) {
                            String nom = result.getString("NOM"); 
                            String prenom = result.getString("PRENOM"); 
                            String cin = result.getString("CIN"); 
                            String pw = result.getString("PW"); 
                            String mail = result.getString("MAIL"); 
                            String specialite = result.getString("SPCT"); 
                            model.addRow(new Object[]{nom, prenom,cin,pw,mail,specialite});
                        }

                        JTable table = new JTable(model);

                        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Liste des étudiants", JOptionPane.INFORMATION_MESSAGE);

                        result.close();
                        statement.close();
                        connection.close(); 
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_5.setBounds(933, 223, 181, 146);
		thirdframe.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Afficher un etudiant");
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(21, 20, 150, 13);
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\searchuser-icon.png"));
		lblNewLabel_7.setBounds(42, 29, 107, 72);
		panel_5.add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Click here");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher_etudiant m=new afficher_etudiant();
				m.frame1.setVisible(true);
				thirdframe.dispose();
			}
		});
		btnNewButton_3.setBounds(42, 111, 129, 21);
		panel_5.add(btnNewButton_3);
		btnNewButton_3.setBackground(new Color(255, 165, 0));
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_6.setBounds(502, 226, 200, 145);
		thirdframe.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Modifier un  etudiant");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(31, 10, 169, 26);
		panel_6.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\user-man-edit-icon.png"));
		lblNewLabel_5.setBounds(53, 32, 103, 77);
		panel_6.add(lblNewLabel_5);
		JButton btnNewButton_2 = new JButton("Click here");
		btnNewButton_2.setBounds(43, 114, 113, 21);
		panel_6.add(btnNewButton_2);
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_etudiant m=new modifier_etudiant();
				m.framem.setVisible(true);
				thirdframe.dispose();
			}
		});
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_7.setBounds(502, 535, 200, 146);
		thirdframe.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Supprimer un etudiant");
		lblNewLabel_13.setForeground(new Color(0, 0, 255));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(10, 5, 165, 27);
		panel_7.add(lblNewLabel_13);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\user-woman-invalid-icon.png"));
		lblNewLabel_16.setBounds(50, 27, 95, 80);
		panel_7.add(lblNewLabel_16);
		JButton btnNewButton_4 = new JButton("Click here");
		btnNewButton_4.setBounds(33, 115, 112, 21);
		panel_7.add(btnNewButton_4);
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.setBackground(new Color(255, 165, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimer_etudiant m=new supprimer_etudiant();
				m.frame.setVisible(true);
				thirdframe.dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(1214, 590, 85, 48);
		thirdframe.getContentPane().add(lblNewLabel_18);
		
		JButton btnNewButton_5 = new JButton("back");
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espace_adminv2 m=new espace_adminv2();
				m.frame.setVisible(true);
				thirdframe.dispose();}
		});
		btnNewButton_5.setBackground(new Color(255, 165, 0));
		btnNewButton_5.setForeground(new Color(0, 0, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setBounds(1300, 105, 85, 21);
		thirdframe.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel_21.setBounds(919, 4, 633, 49);
		thirdframe.getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
		lblNewLabel_22.setBounds(-128, 0, 537, 128);
		thirdframe.getContentPane().add(lblNewLabel_22);
		
	}

}
