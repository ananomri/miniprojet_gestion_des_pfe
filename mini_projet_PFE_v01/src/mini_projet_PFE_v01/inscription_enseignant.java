import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class inscription_enseignant {
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

    JFrame inscriptionframe;
    private JTextField te1;
    private JTextField te2;
    private JTextField te3;
    private JPasswordField te4;
    private JPasswordField te5;
    private final JLabel lblNewLabel_7 = new JLabel("");

    public Connection conn2;
    PreparedStatement pst;
    ResultSet rs;
    private JTextField tcin;

    public inscription_enseignant() throws SQLException {
        initialize();
        conn2 = sqlconnect.conn();
    }

    private void initialize() {
        inscriptionframe = new JFrame();
        inscriptionframe.getContentPane().setBackground(new Color(72, 119, 183));
        inscriptionframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
        inscriptionframe.setBounds(100, 100, 698, 882);
        inscriptionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inscriptionframe.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
        lblNewLabel.setBounds(141, 59, 215, 173);
        inscriptionframe.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nom");
        lblNewLabel_1.setForeground(new Color(255, 140, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 224, 380, 28);
        inscriptionframe.getContentPane().add(lblNewLabel_1);

        te1 = new JTextField();
        te1.setOpaque(false);
        te1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        te1.setBackground(new Color(0, 0, 255));
        te1.setBounds(10, 255, 452, 31);
        inscriptionframe.getContentPane().add(te1);
        te1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Prenom");
        lblNewLabel_2.setForeground(new Color(255, 140, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(10, 283, 361, 28);
        inscriptionframe.getContentPane().add(lblNewLabel_2);

        te2 = new JTextField();
        te2.setOpaque(false);
        te2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        te2.setBackground(new Color(0, 0, 255));
        te2.setBounds(10, 311, 452, 28);
        inscriptionframe.getContentPane().add(te2);
        te2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Email");
        lblNewLabel_3.setForeground(new Color(255, 140, 0));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(10, 388, 361, 28);
        inscriptionframe.getContentPane().add(lblNewLabel_3);

        te3 = new JTextField();
        te3.setOpaque(false);
        te3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        te3.setBackground(new Color(0, 0, 255));
        te3.setBounds(10, 416, 452, 28);
        inscriptionframe.getContentPane().add(te3);
        te3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Mot de passe");
        lblNewLabel_4.setForeground(new Color(255, 140, 0));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(10, 443, 361, 28);
        inscriptionframe.getContentPane().add(lblNewLabel_4);
        
        tcin = new JTextField();
        tcin.setOpaque(false);
        tcin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        tcin.setBackground(new Color(0, 0, 255));
        tcin.setBounds(10, 362, 452, 28);
        inscriptionframe.getContentPane().add(tcin);
        tcin.setColumns(10);
        
        te4 = new JPasswordField();
        te4.setOpaque(false);
        te4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        te4.setBackground(new Color(0, 0, 255));
        te4.setBounds(10, 472, 452, 28);
        inscriptionframe.getContentPane().add(te4);

        JLabel lblNewLabel_5 = new JLabel("Confirmer le mot de passe");
        lblNewLabel_5.setForeground(new Color(255, 140, 0));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(10, 497, 361, 28);
        inscriptionframe.getContentPane().add(lblNewLabel_5);

        te5 = new JPasswordField();
        te5.setOpaque(false);
        te5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        te5.setBackground(new Color(0, 0, 255));
        te5.setBounds(10, 529, 452, 28);
        inscriptionframe.getContentPane().add(te5);

        JLabel lblNewLabel_6 = new JLabel("Departement");
        lblNewLabel_6.setForeground(new Color(255, 140, 0));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_6.setBounds(10, 556, 361, 28);
        inscriptionframe.getContentPane().add(lblNewLabel_6);

        JRadioButton re1 = new JRadioButton("Informatique");
        re1.setOpaque(false);
        re1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        re1.setBounds(10, 577, 365, 28);
        inscriptionframe.getContentPane().add(re1);

        JRadioButton re2 = new JRadioButton("Mathematiques");
        re2.setOpaque(false);
        re2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        re2.setBounds(10, 607, 365, 21);
        inscriptionframe.getContentPane().add(re2);

        JRadioButton re3 = new JRadioButton("Technologie");
        re3.setOpaque(false);
        re3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        re3.setBounds(10, 630, 361, 21);
        inscriptionframe.getContentPane().add(re3);
 
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(re1);
        buttonGroup.add(re2);
        buttonGroup.add(re3);
        JButton btnNewButton = new JButton("S'inscrire");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = te1.getText();
                String prenom = te2.getText();
                String mail = te3.getText();
                String cin = tcin.getText();
                char[] pw = te4.getPassword();
                char[] pwConfirm = te5.getPassword();
                String dept = "";
                if (nom.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un nom");
                    return;
                }
                if (prenom.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un prenom");
                    return;
                }
                if (cin.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un cin");
                    return;
                }
                if (cin.length() != 8) {
                    JOptionPane.showMessageDialog(null, "longueur invalide");
                    return;
                }
                if (!validcin(cin)) {
			        JOptionPane.showMessageDialog(null, "cin:seulement des chiffres");
			        return; 
			    }
                if (mail.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un mail");
                    return;
                }
                if (estEmailValide(mail) == false) {
                    JOptionPane.showMessageDialog(null, "Format mail invalide");
                    return;
                }
                String motDePasse = new String(pw);
                if (motDePasse.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un mot de passe");
                    return;
                }
                String motDePasseConfirm = new String(pwConfirm);
                if (!motDePasse.equals(motDePasseConfirm)) {
                    JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas.");
                    return;
                }
                if (re1.isSelected()) {
                    dept = "Informatique";
                } else if (re2.isSelected()) {
                    dept = "Mathematiques";
                } else if (re3.isSelected()) {
                    dept = "Technologie";
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un departement svp.");
                    return;
                }
                try {
                    Connection connection = sqlconnect.conn();
                    if (connection != null) {
                        String checkSql = "SELECT * FROM ENSEIGNANT WHERE MAIL = ? AND PW = ?";
                        PreparedStatement checkStatement = connection.prepareStatement(checkSql);
                        checkStatement.setString(1, mail);
                        checkStatement.setString(2, new String(pw));
                        ResultSet existingTeachers = checkStatement.executeQuery();
                        if (existingTeachers.next()) {
                            JOptionPane.showMessageDialog(null, "Un enseignant avec le même e-mail et mot de passe existe déjà.");
                            return;
                        }
                        
                        String sql = "INSERT INTO ENSEIGNANT (NOM, PRENOM,MAIL,CIN, PW, DEPT) VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, nom);
                        statement.setString(2, prenom);
                        statement.setString(3, mail);
                        statement.setString(4, cin);
                        statement.setString(5, new String(pw));
                        statement.setString(6, dept);

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
        btnNewButton.setBounds(10, 657, 452, 38);
        inscriptionframe.getContentPane().add(btnNewButton);
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
        lblNewLabel_7.setBounds(472, 317, 202, 195);
        inscriptionframe.getContentPane().add(lblNewLabel_7);
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNewLabel_8 = new JLabel("New label");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_8.setBounds(10, 10, 624, 54);
        inscriptionframe.getContentPane().add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("cin");
        lblNewLabel_9.setForeground(new Color(255, 140, 0));
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_9.setBounds(10, 335, 45, 28);
        inscriptionframe.getContentPane().add(lblNewLabel_9);
        
        JButton btnNewButton_1 = new JButton("QUITTER");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		enseignant m=new enseignant();
				m.Secondframee.setVisible(true);
				inscriptionframe.dispose();
        	}
        });
        btnNewButton_1.setBackground(new Color(255, 165, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setBounds(510, 609, 124, 21);
        inscriptionframe.getContentPane().add(btnNewButton_1);
        

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    inscription_enseignant window = new inscription_enseignant();
                    window.inscriptionframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
