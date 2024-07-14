                                                                                                                                                                                                       import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.border.MatteBorder;

public class enseignant {

	public JFrame Secondframee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enseignant window = new enseignant();
					window.Secondframee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public enseignant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		Secondframee = new JFrame();
		Secondframee.getContentPane().setBackground(new Color(72, 119, 183));
		Secondframee.setBounds(100, 100, 1552, 882);
		Secondframee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Secondframee.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DES ENSEIGNANTS");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(563, 57, 419, 49);
		Secondframee.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
		lblNewLabel_1.setBounds(702, 96, 124, 128);
		Secondframee.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel.setBounds(449, 211, 212, 165);
		Secondframee.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Modifier un enseignant");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(37, 23, 165, 31);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Users-Change-User-icon.png"));
		lblNewLabel_5.setBounds(60, 46, 91, 81);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_15 = new JButton("click here");
		btnNewButton_15.setBounds(36, 134, 141, 21);
		panel.add(btnNewButton_15);
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_enseignants m=new modifier_enseignants();
				m.frame.setVisible(true);
				Secondframee.dispose();
			}
		});
		btnNewButton_15.setBackground(new Color(255, 165, 0));
		btnNewButton_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_15.setForeground(new Color(0, 0, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_1.setBounds(850, 211, 212, 165);
		Secondframee.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Afficher un enseignant");
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(33, 20, 169, 33);
		panel_1.add(lblNewLabel_6);
		
		JButton btnNewButton_14 = new JButton("click here");
		btnNewButton_14.setBounds(34, 134, 140, 21);
		panel_1.add(btnNewButton_14);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher_enseignant m=new afficher_enseignant();
				m.frame.setVisible(true);
				Secondframee.dispose();
			}
		});
		btnNewButton_14.setBackground(new Color(255, 165, 0));
		btnNewButton_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_14.setForeground(new Color(0, 0, 255));
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\select-search-icon.png"));
		lblNewLabel_14.setBounds(43, 52, 95, 72);
		panel_1.add(lblNewLabel_14);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setBounds(1072, 297, 191, 29);
		Secondframee.getContentPane().add(horizontalGlue);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setBounds(242, 297, 197, 29);
		Secondframee.getContentPane().add(horizontalGlue_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_2.setBounds(1269, 208, 250, 165);
		Secondframee.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Afficher la liste des enseignants");
		lblNewLabel_7.setForeground(new Color(0, 0, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 21, 230, 51);
		panel_2.add(lblNewLabel_7);
		JButton btnNewButton_1 = new JButton("click here");
		btnNewButton_1.setBounds(45, 134, 157, 21);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = sqlconnect.conn();
                if (connection != null) {
                    try {
                        String sql = "SELECT  nom, prenom, cin, mail, dept FROM ENSEIGNANT";
                        PreparedStatement statement = connection.prepareStatement(sql);

                        ResultSet result = statement.executeQuery();

                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("Nom");
                        model.addColumn("Prénom");
                        model.addColumn("cin");
                        model.addColumn("mail");
                        model.addColumn("dept");
                        while (result.next()) {
                            String nom = result.getString("nom"); 
                            String prenom = result.getString("prenom");
                            String cin = result.getString("cin"); 
                            String mail = result.getString("mail"); 
                            String dept = result.getString("dept"); 
                            model.addRow(new Object[]{ nom, prenom,cin,mail,dept});
                        }

                        JTable table = new JTable(model);

                        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Liste des enseignants", JOptionPane.INFORMATION_MESSAGE);

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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Programming-Show-Property-icon.png"));
		lblNewLabel_13.setBounds(83, 65, 119, 72);
		panel_2.add(lblNewLabel_13);
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_3.setBounds(24, 208, 212, 165);
		Secondframee.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter un enseignant");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 10, 159, 44);
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("click here");
		btnNewButton.setBounds(30, 121, 140, 21);
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscription_enseignant logens;
				try {
					logens = new inscription_enseignant();
					logens.inscriptionframe.setVisible(true);
					Secondframee.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Users-Add-User-icon.png"));
		lblNewLabel_3.setBounds(63, 39, 72, 81);
		panel_3.add(lblNewLabel_3);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalGlue_2.setBounds(658, 297, 191, 29);
		Secondframee.getContentPane().add(horizontalGlue_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_4.setBounds(850, 527, 240, 165);
		Secondframee.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Supprimer la liste des enseignants");
		lblNewLabel_9.setBounds(10, 21, 230, 19);
		panel_4.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(0, 0, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JButton btnNewButton_5 = new JButton("click here");
		btnNewButton_5.setBounds(64, 134, 132, 21);
		panel_4.add(btnNewButton_5);
		btnNewButton_5.setForeground(new Color(0, 0, 255));
		btnNewButton_5.setBackground(new Color(255, 165, 0));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Database-Delete-icon.png"));
		lblNewLabel_17.setBounds(64, 50, 91, 74);
		panel_4.add(lblNewLabel_17);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = sqlconnect.conn();
                if (connection != null) {
                    try {
                        String sql = "DELETE FROM ENSEIGNANT";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Tous les enseignants ont été supprimés avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Aucun enseignant trouvé à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
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
			
		});
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(109, 372, 62, 156);
		Secondframee.getContentPane().add(verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(270, 610, 169, 21);
		Secondframee.getContentPane().add(horizontalStrut);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_5.setBounds(10, 527, 258, 165);
		Secondframee.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Afficher enseignant par departement");
		lblNewLabel_8.setForeground(new Color(0, 0, 255));
		lblNewLabel_8.setBounds(10, 26, 248, 19);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_8);
		
		
		
		JButton btnNewButton_13 = new JButton("click here");
		btnNewButton_13.setBounds(62, 134, 138, 21);
		panel_5.add(btnNewButton_13);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Connection connection = sqlconnect.conn();
			    if (connection != null) {
			        try {
			            String sql = "SELECT dept, COUNT(*) AS count FROM ENSEIGNANT GROUP BY dept";
			            PreparedStatement statement = connection.prepareStatement(sql);

			            ResultSet result = statement.executeQuery();

			            DefaultTableModel model = new DefaultTableModel();
			            model.addColumn("Département");
			            model.addColumn("Nombre d'enseignants");

			            while (result.next()) {
			                String dept = result.getString("dept"); 
			                int count = result.getInt("count");
			                model.addRow(new Object[]{dept, count});
			            }

			            JTable table = new JTable(model);
			            JScrollPane scrollPane = new JScrollPane(table);

			            JOptionPane.showMessageDialog(null, scrollPane, "Nombre d'enseignants par département", JOptionPane.INFORMATION_MESSAGE);

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
		btnNewButton_13.setBackground(new Color(255, 165, 0));
		btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_13.setForeground(new Color(0, 0, 255));
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\form-select-icon.png"));
		lblNewLabel_15.setBounds(68, 55, 92, 69);
		panel_5.add(lblNewLabel_15);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(680, 610, 169, 29);
		Secondframee.getContentPane().add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(1059, 610, 202, 21);
		Secondframee.getContentPane().add(horizontalStrut_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_6.setBounds(436, 527, 240, 165);
		Secondframee.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Supprimer un enseignant");
		lblNewLabel_10.setForeground(new Color(0, 0, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(23, 20, 207, 29);
		panel_6.add(lblNewLabel_10);
		
		JButton btnNewButton_17 = new JButton("click here");
		btnNewButton_17.setBounds(55, 134, 124, 21);
		panel_6.add(btnNewButton_17);
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimer_enseignant m=new supprimer_enseignant();
				m.frames.setVisible(true);
				Secondframee.dispose();
			}
		});
		btnNewButton_17.setBackground(new Color(255, 165, 0));
		btnNewButton_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_17.setForeground(new Color(0, 0, 255));
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\user-man-delete-icon.png"));
		lblNewLabel_16.setBounds(67, 41, 72, 83);
		panel_6.add(lblNewLabel_16);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_7.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_7.setBounds(1262, 527, 288, 165);
		Secondframee.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("departement");
		lblNewLabel_12.setForeground(new Color(0, 0, 255));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(125, 22, 88, 29);
		panel_7.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("Supprimer les enseignant d'un");
		lblNewLabel_11.setForeground(new Color(0, 0, 255));
		lblNewLabel_11.setBounds(66, 5, 206, 19);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_11);
		
		JButton btnNewButton_16 = new JButton("cklick here");
		btnNewButton_16.setBounds(112, 134, 136, 21);
		panel_7.add(btnNewButton_16);
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String dept = JOptionPane.showInputDialog(null, "Veuillez saisir le departement à supprimer :", "Supprimer étudiants par spécialité", JOptionPane.PLAIN_MESSAGE);
		   	    if (dept != null&& !dept.isEmpty()) {
		   	     System.out.println("Département saisi : " + dept);
		            Connection connection = sqlconnect.conn();
		            if (connection != null) {
		                try {
		                    String sql = "DELETE FROM enseignant WHERE DEPT = ?";
		                    PreparedStatement statement = connection.prepareStatement(sql);
		                    statement.setString(1, dept);
		                    
		                    int rowsAffected = statement.executeUpdate();
		                    if (rowsAffected > 0) {
		                        JOptionPane.showMessageDialog(null, "Les enseignants du epartement " + dept + " ont été supprimés avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Aucun enseignant trouvé à supprimer pour le departement " + dept, "Erreur", JOptionPane.ERROR_MESSAGE);
		                    }
		                    
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Veuillez saisir le departement pour supprimer les étudiants", "Erreur", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		btnNewButton_16.setForeground(new Color(0, 0, 255));
		btnNewButton_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_16.setBackground(new Color(255, 165, 0));
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Files-Delete-File-icon.png"));
		lblNewLabel_18.setBounds(135, 44, 88, 80);
		panel_7.add(lblNewLabel_18);
		
		JButton btnNewButton_2 = new JButton("back");
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espace_adminv2 m=new espace_adminv2();
				m.frame.setVisible(true);
				Secondframee.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(1316, 107, 85, 34);
		Secondframee.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
		lblNewLabel_19.setBounds(-19, 6, 586, 112);
		Secondframee.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel_20.setBounds(902, 6, 665, 49);
		Secondframee.getContentPane().add(lblNewLabel_20);
		
	}
}
