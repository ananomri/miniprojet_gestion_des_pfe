
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

public class inscrire_etudiant {
	 private boolean estEmailValide(String email) {
	        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
	 public static boolean validcin(String chaine) {
	        for (int i = 0; i < chaine.length(); i++) {
	            if (!Character.isDigit(chaine.charAt(i))) {
	                return false; 
	            }
	        }
	        return true; 
	    }
	JFrame inscrireframe;
	 JTextField t1;
     JTextField t2;
	 JTextField t3;
	 JTextField t4;
	 JPasswordField t5;
	 JPasswordField t6;
	 JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscrire_etudiant window = new inscrire_etudiant();
					window.inscrireframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public Connection conn1;
PreparedStatement pst;
ResultSet rs ;
private JTextField tcins;
	public inscrire_etudiant() throws SQLException {
		initialize();
		conn1=sqlconnect.conn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		inscrireframe = new JFrame();
		inscrireframe.getContentPane().setBackground(new Color(72, 119, 183));
		inscrireframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Desktop\\image\\Capture d'écran 2024-03-22 115107.png"));
		inscrireframe.setBounds(100, 100, 636, 725);
		inscrireframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inscrireframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 136, 96, 13);
		inscrireframe.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setOpaque(false);
		t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t1.setBackground(new Color(0, 0, 255));
		t1.setForeground(new Color(0, 0, 0));
		t1.setBounds(30, 167, 379, 19);
		inscrireframe.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(30, 196, 96, 13);
		inscrireframe.getContentPane().add(lblNewLabel_1);
		
		t2 = new JTextField();
		t2.setOpaque(false);
		t2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t2.setBackground(new Color(0, 0, 255));
		t2.setBounds(30, 219, 379, 19);
		inscrireframe.getContentPane().add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("email");
		lblNewLabel_2.setForeground(new Color(255, 165, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(30, 297, 96, 19);
		inscrireframe.getContentPane().add(lblNewLabel_2);
		
		t3 = new JTextField();
		t3.setOpaque(false);
		t3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t3.setBackground(new Color(0, 0, 255));
		t3.setBounds(30, 318, 379, 19);
		inscrireframe.getContentPane().add(t3);
		t3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("confirmer email");
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(30, 347, 173, 19);
		inscrireframe.getContentPane().add(lblNewLabel_3);
		
		t4 = new JTextField();
		t4.setOpaque(false);
		t4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t4.setBackground(new Color(0, 0, 255));
		t4.setBounds(30, 376, 379, 19);
		inscrireframe.getContentPane().add(t4);
		t4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Num inscription");
		lblNewLabel_4.setForeground(new Color(255, 165, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(30, 405, 131, 19);
		inscrireframe.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("confirmer le num inscription");
		lblNewLabel_5.setForeground(new Color(255, 140, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(30, 463, 292, 19);
		inscrireframe.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("specialite");
		lblNewLabel_6.setForeground(new Color(255, 165, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(30, 520, 181, 28);
		inscrireframe.getContentPane().add(lblNewLabel_6);
		
		JRadioButton r1 = new JRadioButton("\tLicence: informatique");
		r1.setOpaque(false);
		r1.setBounds(30, 554, 268, 21);
		inscrireframe.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("\tMastère : Recherche");
		r2.setOpaque(false);
		r2.setBounds(30, 577, 292, 21);
		inscrireframe.getContentPane().add(r2);
		
		JRadioButton r3 = new JRadioButton("\tIngénieur: Informatique");
		r3.setOpaque(false);
		r3.setBounds(30, 600, 255, 21);
		inscrireframe.getContentPane().add(r3);
		
		JRadioButton r4 = new JRadioButton("\tLicence:électronique");
		r4.setOpaque(false);
		r4.setBounds(391, 554, 173, 21);
		inscrireframe.getContentPane().add(r4);
		
		JRadioButton r5 = new JRadioButton("\tMastère :Professionnel");
		r5.setOpaque(false);
		r5.setBounds(391, 577, 173, 21);
		inscrireframe.getContentPane().add(r5);
		
		JRadioButton r6 = new JRadioButton("\tIngénieur:  électronique");
		r6.setOpaque(false);
		r6.setBounds(391, 600, 173, 21);
		inscrireframe.getContentPane().add(r6);
		
	    ButtonGroup buttonGroup = new ButtonGroup();
	    buttonGroup.add(r1);
	    buttonGroup.add(r2);
	    buttonGroup.add(r3);
	    buttonGroup.add(r4);
	    buttonGroup.add(r5);
	    buttonGroup.add(r6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Desktop\\image\\Students-icon.png"));
		lblNewLabel_7.setBounds(154, 38, 131, 111);
		inscrireframe.getContentPane().add(lblNewLabel_7);
		
		tcins = new JTextField();
		tcins.setOpaque(false);
		tcins.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		tcins.setBackground(new Color(0, 0, 255));
		tcins.setBounds(30, 268, 379, 19);
		inscrireframe.getContentPane().add(tcins);
		tcins.setColumns(10);
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    String nom = t1.getText();
				    String cin = tcins.getText();
				    String prenom = t2.getText();
				    String mail = t3.getText();
				    String mailc = t4.getText();
				    char[] pw = t5.getPassword();
				    char[] pwConfirm = t6.getPassword(); 
				    String role = "";
				    if (nom.length()==0) {
				        JOptionPane.showMessageDialog(null, "Il faux saisir un nom");
				        return; 
				    }
				    if (prenom.length()==0) {
				        JOptionPane.showMessageDialog(null, "Il faux saisir un prenom");
				        return; 
				    }
				    if (cin.length()==0) {
				        JOptionPane.showMessageDialog(null, "Il faux saisir le cin");
				        return; 
				    }
				    if (cin.length()!=8) {
				        JOptionPane.showMessageDialog(null, "longueur de cin invalid");
				        return; 
				    }
				    if (!validcin(cin)) {
				        JOptionPane.showMessageDialog(null, "cin:seulement des chiffres");
				        return; 
				    }
				    if (mail.length()==0) {
				        JOptionPane.showMessageDialog(null, "Il faux saisir un mail");
				        return; 
				    }
				    if (estEmailValide(mail)==false) {
				    	JOptionPane.showMessageDialog(null, "format mail invalide");
				        return; 
				    }
				    if (!mail.equals(mailc)) {
				        JOptionPane.showMessageDialog(null, "Les adresses email ne correspondent pas.");
				        return; 
				    }
				    String motDePasse = new String(pw);
				    if (motDePasse.length()==0) {
				        JOptionPane.showMessageDialog(null, "Il faux saisir un mot de passe");
				        return; 
				    }
				    String motDePasseConfirm = new String(pwConfirm);
				    if (!motDePasse.equals(motDePasseConfirm)) {
				        JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas.");
				        return; 
				    }
				    if (r1.isSelected()) {
				        role = "Licence: informatique";
				    } else if (r2.isSelected()) {
				        role = "Mastère : Recherche";
				    } else if (r3.isSelected()) {
				        role = "Ingénieur: Informatique";
				    }else if (r4.isSelected()) {
				        role = "Licence:électronique";
				    }else if (r5.isSelected()) {
				        role = "Mastère :Professionnel";
				    }else if (r6.isSelected()) {
				        role = "Ingénieur:  électronique";
				    }else {
				        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une specialite.");
				        return; 
				    }
				    int cinInt = Integer.parseInt(cin);
				    try {
				        Connection connection = sqlconnect.conn();
				        if (connection != null) {
				        	String sql = "INSERT INTO ETUDIANT (NOM, PRENOM, CIN, MAIL, PW, SPCT) VALUES (?, ?, ?, ?, ?, ?)";
				        	PreparedStatement statement = connection.prepareStatement(sql);
				        	statement.setString(1, nom);
				        	statement.setString(2, prenom);
				        	statement.setInt(3, cinInt); 
				        	statement.setString(4, mail);
				        	statement.setString(5, new String(pw));
				        	statement.setString(6, role);

				        	int rowsInserted = statement.executeUpdate();

				            if (rowsInserted > 0) {
				                JOptionPane.showMessageDialog(null, "Enregistrement inséré avec succès !");
				            } else {
				                JOptionPane.showMessageDialog(null, "L'enregistrement n'a pas pu être inséré.");
				            }
				            statement.close();
				            connection.close();
				        } else {
				            JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué.");
				        }
				    } catch (SQLException e1) {
				        JOptionPane.showMessageDialog(null, "Erreur SQL : " + e1.getMessage());
				    }
				}

		});
		btnNewButton.setBounds(30, 627, 379, 38);
		inscrireframe.getContentPane().add(btnNewButton);
		
		t5 = new JPasswordField();
		t5.setOpaque(false);
		t5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t5.setBackground(new Color(0, 0, 255));
		t5.setBounds(30, 434, 379, 19);
		inscrireframe.getContentPane().add(t5);
		
		t6= new JPasswordField();
		t6.setOpaque(false);
		t6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t6.setBackground(new Color(0, 0, 255));
		t6.setBounds(30, 492, 379, 19);
		inscrireframe.getContentPane().add(t6);
		
		table = new JTable();
		table.setBounds(168, 169, 1, 1);
		inscrireframe.getContentPane().add(table);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
		lblNewLabel_8.setBounds(418, 268, 194, 161);
		inscrireframe.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel_9.setBounds(10, 10, 623, 38);
		inscrireframe.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("CIN");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setForeground(new Color(255, 165, 0));
		lblNewLabel_10.setBounds(30, 248, 379, 19);
		inscrireframe.getContentPane().add(lblNewLabel_10);
		
		JButton btnNewButton_1 = new JButton("QUITTER");
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiant isnadmin=new etudiant();
				isnadmin.thirdframe.setVisible(true);
				inscrireframe.dispose();
			}
		});
		btnNewButton_1.setBounds(504, 640, 108, 21);
		inscrireframe.getContentPane().add(btnNewButton_1);
		

	}
}

