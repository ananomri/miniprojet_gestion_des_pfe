import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class modifier_etudiant {

    public JFrame framem;
    private JComboBox<String> comboBoxCin;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    modifier_etudiant window = new modifier_etudiant();
                    window.framem.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public modifier_etudiant() {
        initialize();
    }

    private void initialize() {
        framem = new JFrame();
        framem.getContentPane().setBackground(new Color(72, 119, 183));
        framem.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Desktop\\image\\Capture d'écran 2024-03-22 115107.png"));
        framem.setBounds(100, 100, 1000, 422);
        framem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framem.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Modifier étudiant");
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setBounds(180, 190, 693, 37);
        lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        framem.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("CIN");
        lblNewLabel_1.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_1.setBounds(16, 263, 45, 13);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        framem.getContentPane().add(lblNewLabel_1);

        comboBoxCin = new JComboBox<>();
        comboBoxCin.setBounds(65, 263, 150, 25);
        framem.getContentPane().add(comboBoxCin);

        JLabel lblNewLabel_2 = new JLabel("Nom");
        lblNewLabel_2.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_2.setBounds(250, 263, 45, 13);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        framem.getContentPane().add(lblNewLabel_2);

        t2 = new JTextField();
        t2.setBounds(305, 263, 96, 19);
        framem.getContentPane().add(t2);
        t2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Prénom");
        lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_3.setBounds(420, 254, 96, 30);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        framem.getContentPane().add(lblNewLabel_3);

        t3 = new JTextField();
        t3.setBounds(500, 263, 96, 19);
        framem.getContentPane().add(t3);
        t3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Mail");
        lblNewLabel_4.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_4.setBounds(620, 251, 45, 37);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        framem.getContentPane().add(lblNewLabel_4);

        t4 = new JTextField();
        t4.setBounds(670, 263, 96, 19);
        framem.getContentPane().add(t4);
        t4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Spécialité");
        lblNewLabel_5.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_5.setBounds(790, 260, 104, 19);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        framem.getContentPane().add(lblNewLabel_5);

        t5 = new JTextField();
        t5.setBounds(890, 263, 96, 19);
        framem.getContentPane().add(t5);
        t5.setColumns(10);

        JButton btnNewButton = new JButton("Modifier");
        btnNewButton.setOpaque(false);
        btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton.setForeground(new Color(0, 0, 255));
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cin = (String) comboBoxCin.getSelectedItem();
                String nom = t2.getText();
                String prenom = t3.getText();
                String mail = t4.getText();
                String specialite = t5.getText();

                if (cin != null && !cin.isEmpty()) {
                    Connection connection = sqlconnect.conn();
                    if (connection != null) {
                        try {
                            String sqlSelect = "SELECT * FROM etudiant WHERE CIN = ?";
                            PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
                            selectStatement.setString(1, cin);
                            ResultSet resultSet = selectStatement.executeQuery();

                            if (resultSet.next()) {
                                String existingNom = resultSet.getString("NOM");
                                String existingPrenom = resultSet.getString("PRENOM");
                                String existingMail = resultSet.getString("MAIL");
                                String existingSpecialite = resultSet.getString("SPCT");

                                if (!nom.isEmpty()) {
                                    existingNom = nom;
                                }
                                if (!prenom.isEmpty()) {
                                    existingPrenom = prenom;
                                }
                                if (!mail.isEmpty()) {
                                    existingMail = mail;
                                }
                                if (!specialite.isEmpty()) {
                                    existingSpecialite = specialite;
                                }

                                String sqlUpdate = "UPDATE etudiant SET NOM = ?, PRENOM = ?, MAIL = ?, SPCT = ? WHERE CIN = ?";
                                PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
                                updateStatement.setString(1, existingNom);
                                updateStatement.setString(2, existingPrenom);
                                updateStatement.setString(3, existingMail);
                                updateStatement.setString(4, existingSpecialite);
                                updateStatement.setString(5, cin);

                                int rowsAffected = updateStatement.executeUpdate();
                                if (rowsAffected > 0) {
                                    JOptionPane.showMessageDialog(null, "L'étudiant a été modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé avec le CIN spécifié", "Erreur", JOptionPane.ERROR_MESSAGE);
                                }

                                updateStatement.close();
                            } else {
                                JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé avec le CIN spécifié", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }

                            selectStatement.close();
                            resultSet.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner le CIN de l'étudiant à modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(405, 344, 174, 37);
        framem.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Retour");
        btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setBackground(new Color(255, 165, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etudiant isnadmin = new etudiant();
                isnadmin.thirdframe.setVisible(true);
                framem.dispose();
            }
        });
        btnNewButton_1.setBounds(636, 354, 85, 21);
        framem.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Anen\\Desktop\\image\\Students-icon.png"));
        lblNewLabel_6.setBounds(466, 65, 146, 128);
        framem.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_7.setBounds(-149, 0, 531, 135);
        framem.getContentPane().add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_8.setBounds(377, 0, 616, 74);
        framem.getContentPane().add(lblNewLabel_8);

        // Charger les CIN depuis la base de données et les ajouter à la JComboBox
        loadCinData();
    }

    private void loadCinData() {
        Connection connection = sqlconnect.conn();
        if (connection != null) {
            try {
                String sqlSelect = "SELECT CIN FROM etudiant";
                PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
                ResultSet resultSet = selectStatement.executeQuery();

                while (resultSet.next()) {
                    String cin = resultSet.getString("CIN");
                    comboBoxCin.addItem(cin);
                }

                selectStatement.close();
                resultSet.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
