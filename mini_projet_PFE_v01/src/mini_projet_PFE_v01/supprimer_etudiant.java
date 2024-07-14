import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class supprimer_etudiant {

    public JFrame frame;
    private JComboBox<String> comboBoxCin;
    private JComboBox<String> comboBoxNom;
    private JComboBox<String> comboBoxPrenom;
    private JComboBox<String> comboBoxMail;
    private JComboBox<String> comboBoxSpecialite;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    supprimer_etudiant window = new supprimer_etudiant();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public supprimer_etudiant() {
        initialize();
        fetchEtudiantData();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(72, 119, 183));
        frame.setBounds(100, 100, 1008, 359);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Supprimer étudiant");
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 68));
        lblNewLabel.setBounds(174, 142, 744, 90);
        frame.getContentPane().add(lblNewLabel);

        comboBoxCin = new JComboBox<>();
        comboBoxCin.setBounds(48, 239, 96, 19);
        frame.getContentPane().add(comboBoxCin);

        comboBoxNom = new JComboBox<>();
        comboBoxNom.setBounds(229, 239, 96, 19);
        frame.getContentPane().add(comboBoxNom);

        comboBoxPrenom = new JComboBox<>();
        comboBoxPrenom.setBounds(433, 239, 96, 19);
        frame.getContentPane().add(comboBoxPrenom);

        comboBoxMail = new JComboBox<>();
        comboBoxMail.setBounds(607, 239, 96, 19);
        frame.getContentPane().add(comboBoxMail);

        comboBoxSpecialite = new JComboBox<>();
        comboBoxSpecialite.setBounds(845, 239, 96, 19);
        frame.getContentPane().add(comboBoxSpecialite);

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnSupprimer.setOpaque(false);
        btnSupprimer.setBackground(new Color(255, 165, 0));
        btnSupprimer.setForeground(new Color(0, 0, 255));
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cin = comboBoxCin.getSelectedItem().toString();
                String nom = comboBoxNom.getSelectedItem().toString();
                String prenom = comboBoxPrenom.getSelectedItem().toString();
                String mail = comboBoxMail.getSelectedItem().toString();
                String specialite = comboBoxSpecialite.getSelectedItem().toString();

                // Vérifier au moins une valeur sélectionnée
                if (cin.isEmpty() && nom.isEmpty() && prenom.isEmpty() && mail.isEmpty() && specialite.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner au moins une valeur", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Connection connection = null;
                PreparedStatement deleteStatement = null;

                try {
                    connection = sqlconnect.conn();

                    if (connection != null) {
                        connection.setAutoCommit(false);

                        // Construction de la requête de suppression
                        StringBuilder deleteSQL = new StringBuilder("DELETE FROM etudiant WHERE ");
                        List<String> conditions = new ArrayList<>();

                        if (!cin.isEmpty()) {
                            conditions.add("CIN = ?");
                        }
                        if (!nom.isEmpty()) {
                            conditions.add("NOM = ?");
                        }
                        if (!prenom.isEmpty()) {
                            conditions.add("PRENOM = ?");
                        }
                        if (!mail.isEmpty()) {
                            conditions.add("MAIL = ?");
                        }
                        if (!specialite.isEmpty()) {
                            conditions.add("SPCT = ?");
                        }

                        deleteSQL.append(String.join(" AND ", conditions));
                        deleteStatement = connection.prepareStatement(deleteSQL.toString());

                        int parameterIndex = 1;
                        if (!cin.isEmpty()) {
                            deleteStatement.setString(parameterIndex++, cin);
                        }
                        if (!nom.isEmpty()) {
                            deleteStatement.setString(parameterIndex++, nom);
                        }
                        if (!prenom.isEmpty()) {
                            deleteStatement.setString(parameterIndex++, prenom);
                        }
                        if (!mail.isEmpty()) {
                            deleteStatement.setString(parameterIndex++, mail);
                        }
                        if (!specialite.isEmpty()) {
                            deleteStatement.setString(parameterIndex++, specialite);
                        }

                        int rowsAffected = deleteStatement.executeUpdate();
                        connection.commit();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "L'étudiant a été supprimé avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Aucun étudiant correspondant trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    try {
                        if (connection != null) {
                            connection.rollback();
                        }
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace();
                    }
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur lors de la suppression de l'étudiant", "Erreur", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (deleteStatement != null) {
                            deleteStatement.close();
                        }
                        if (connection != null) {
                            connection.setAutoCommit(true);
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnSupprimer.setBounds(260, 291, 168, 21);
        frame.getContentPane().add(btnSupprimer);

        JButton btnBack = new JButton("Retour");
        btnBack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnBack.setOpaque(false);
        btnBack.setBackground(new Color(255, 165, 0));
        btnBack.setForeground(new Color(0, 0, 255));
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retour à la fenêtre précédente
                frame.dispose(); 
                new etudiant().thirdframe.setVisible(true); 
            }
        });
        btnBack.setBounds(491, 293, 85, 21);
        frame.getContentPane().add(btnBack);
        
        lblNewLabel_1 = new JLabel("cin");
        lblNewLabel_1.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 239, 45, 13);
        frame.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_2.setBounds(379, 56, 608, 40);
        frame.getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_3.setBounds(-172, 0, 552, 126);
        frame.getContentPane().add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("nom");
        lblNewLabel_4.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(174, 242, 45, 13);
        frame.getContentPane().add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("prenom");
        lblNewLabel_5.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(358, 233, 68, 25);
        frame.getContentPane().add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("mail");
        lblNewLabel_6.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_6.setBounds(568, 242, 45, 13);
        frame.getContentPane().add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("specialite");
        lblNewLabel_7.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_7.setBounds(754, 239, 81, 19);
        frame.getContentPane().add(lblNewLabel_7);
    }

    /**
     * Fetch etudiant data from database and populate comboboxes.
     */
    private void fetchEtudiantData() {
        try {
            Connection connection = sqlconnect.conn();
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement("SELECT CIN, NOM, PRENOM, MAIL, SPCT FROM etudiant");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    comboBoxCin.addItem(resultSet.getString("CIN"));
                    comboBoxNom.addItem(resultSet.getString("NOM"));
                    comboBoxPrenom.addItem(resultSet.getString("PRENOM"));
                    comboBoxMail.addItem(resultSet.getString("MAIL"));
                    comboBoxSpecialite.addItem(resultSet.getString("SPCT"));
                }
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
