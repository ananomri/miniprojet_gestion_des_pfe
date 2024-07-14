import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class inscription_admin {
    private boolean estEmailValide(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean veriftel(String numero) {
        if (numero.length() != 8) {
            return false;
        }

        for (char c : numero.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    JFrame adminframe;
    private JTextField ta1;
    private JTextField ta2;
    private JTextField ta3;
    private JTextField ta6;

    public Connection conn3;
    PreparedStatement pst;
    ResultSet rs;
    private JPasswordField ta5;
    private JPasswordField ta4;

    public inscription_admin() {
        initialize();
        conn3 = sqlconnect.conn();
    }

    private void initialize() {
        adminframe = new JFrame();
        adminframe.getContentPane().setBackground(new Color(72, 119, 183));
        adminframe.setBounds(100, 100, 677, 894);
        adminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminframe.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel.setBounds(10, 10, 642, 46);
        adminframe.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Users-Administrator-icon (1).png"));
        lblNewLabel_1.setBounds(208, 66, 128, 115);
        adminframe.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
        lblNewLabel_2.setBounds(463, 278, 189, 178);
        adminframe.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Nom");
        lblNewLabel_3.setForeground(new Color(255, 140, 0));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(10, 177, 407, 25);
        adminframe.getContentPane().add(lblNewLabel_3);

        ta1 = new JTextField();
        ta1.setOpaque(false);
        ta1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        ta1.setBackground(new Color(0, 0, 255));
        ta1.setForeground(new Color(0, 0, 0));
        ta1.setBounds(10, 212, 407, 30);
        adminframe.getContentPane().add(ta1);
        ta1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Prenom");
        lblNewLabel_4.setForeground(new Color(255, 140, 0));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(10, 252, 407, 25);
        adminframe.getContentPane().add(lblNewLabel_4);

        ta2 = new JTextField();
        ta2.setOpaque(false);
        ta2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        ta2.setBackground(new Color(0, 0, 255));
        ta2.setBounds(10, 278, 407, 30);
        adminframe.getContentPane().add(ta2);
        ta2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("numero de tel");
        lblNewLabel_5.setForeground(new Color(255, 140, 0));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(10, 318, 407, 30);
        adminframe.getContentPane().add(lblNewLabel_5);

        ta3 = new JTextField();
        ta3.setOpaque(false);
        ta3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        ta3.setBackground(new Color(0, 0, 255));
        ta3.setBounds(10, 358, 407, 30);
        adminframe.getContentPane().add(ta3);
        ta3.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Mot de passe");
        lblNewLabel_6.setForeground(new Color(255, 140, 0));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_6.setBounds(10, 398, 407, 25);
        adminframe.getContentPane().add(lblNewLabel_6);

        ta6 = new JTextField();
        ta6.setOpaque(false);
        ta6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        ta6.setBackground(new Color(0, 0, 255));
        ta6.setBounds(10, 583, 407, 30);
        adminframe.getContentPane().add(ta6);
        ta6.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Confirmer mot de passe");
        lblNewLabel_7.setForeground(new Color(255, 140, 0));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_7.setBounds(10, 473, 407, 25);
        adminframe.getContentPane().add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Email");
        lblNewLabel_8.setForeground(new Color(255, 140, 0));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_8.setBounds(10, 548, 407, 25);
        adminframe.getContentPane().add(lblNewLabel_8);

        JButton btnNewButton = new JButton("S'inscrire");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = ta1.getText();
                String prenom = ta2.getText();
                String tel = ta3.getText();
                char[] pw = ta4.getPassword();
                char[] pwConfirm = ta5.getPassword();
                String mail = ta6.getText();
                if (nom.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un nom");
                    return;
                }
                if (prenom.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un prenom");
                    return;
                }
                if (tel.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un num de tel");
                    return;
                }
                if (veriftel(tel) == false) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un num de tel valide");
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
                if (mail.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Il faut saisir un mail");
                    return;
                }
                if (estEmailValide(mail) == false) {
                    JOptionPane.showMessageDialog(null, "Format mail invalide");
                    return;
                }
                try {
                    Connection connection = sqlconnect.conn();
                    if (connection != null) {
                        String checkSql = "SELECT * FROM ADMIN WHERE pw = ? AND mail = ?";
                        PreparedStatement checkStatement = connection.prepareStatement(checkSql);
                        checkStatement.setString(1, motDePasse);
                        checkStatement.setString(2, mail);
                        ResultSet existingAdmins = checkStatement.executeQuery();
                        if (existingAdmins.next()) {
                            JOptionPane.showMessageDialog(null,
                                    "Un administrateur avec le même mot de passe et e-mail existe déjà.");
                            return;
                        }

                        String sql = "INSERT INTO ADMIN (nom, prenom, tel, pw, mail)VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, nom);
                        statement.setString(2, prenom);
                        statement.setString(3, tel);
                        statement.setString(4, motDePasse);
                        statement.setString(5, mail);
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
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 255));
        btnNewButton.setBounds(10, 631, 407, 46);
        adminframe.getContentPane().add(btnNewButton);

        ta5 = new JPasswordField();
        ta5.setOpaque(false);
        ta5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        ta5.setBackground(new Color(0, 0, 255));
        ta5.setBounds(10, 508, 407, 30);
        adminframe.getContentPane().add(ta5);

        ta4 = new JPasswordField();
        ta4.setOpaque(false);
        ta4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        ta4.setBackground(new Color(0, 0, 255));
        ta4.setBounds(10, 433, 407, 30);
        adminframe.getContentPane().add(ta4);
        
        JButton QUITTER = new JButton("QUITTER");
        QUITTER.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Main m=new Main();
				m.frame.setVisible(true);
				adminframe.dispose();
        	}
        });
        QUITTER.setBackground(new Color(255, 165, 0));
        QUITTER.setForeground(new Color(0, 0, 255));
        QUITTER.setFont(new Font("Tahoma", Font.PLAIN, 15));
        QUITTER.setBounds(494, 604, 128, 21);
        adminframe.getContentPane().add(QUITTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    inscription_admin window = new inscription_admin();
                    window.adminframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
}
