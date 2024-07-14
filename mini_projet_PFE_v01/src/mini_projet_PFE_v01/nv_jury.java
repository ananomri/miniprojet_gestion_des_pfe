import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class nv_jury {

    public JFrame framej;
    private JComboBox<String> comboBoxIdPFE;
    private JComboBox<String> comboBoxCinPresident;
    private JComboBox<String> comboBoxCinRapporteur;
    private JComboBox<String> comboBoxCinExaminateur;
    private JComboBox<String> comboBoxCinEncadreur;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    nv_jury window = new nv_jury();
                    window.framej.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public nv_jury() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        framej = new JFrame();
        framej.getContentPane().setBackground(new Color(72, 119, 183));
        framej.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Science-Law-icon.png"));
        framej.setBounds(100, 100, 1321, 399);
        framej.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framej.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("JURY");
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(492, 224, 436, 28);
        framej.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID PFE");
        lblNewLabel_1.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 287, 80, 19);
        framej.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("CIN president");
        lblNewLabel_2.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(206, 287, 119, 19);
        framej.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("CIN rapporteur");
        lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(759, 287, 146, 19);
        framej.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("CIN examinateur");
        lblNewLabel_4.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(1030, 285, 141, 23);
        framej.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("CIN encadreur societe");
        lblNewLabel_5.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(436, 287, 181, 19);
        framej.getContentPane().add(lblNewLabel_5);

        comboBoxIdPFE = new JComboBox<>();
        comboBoxIdPFE.setBounds(72, 290, 96, 19);
        framej.getContentPane().add(comboBoxIdPFE);

        comboBoxCinPresident = new JComboBox<>();
        comboBoxCinPresident.setBounds(317, 290, 96, 19);
        framej.getContentPane().add(comboBoxCinPresident);

        comboBoxCinRapporteur = new JComboBox<>();
        comboBoxCinRapporteur.setBounds(897, 290, 96, 19);
        framej.getContentPane().add(comboBoxCinRapporteur);

        comboBoxCinExaminateur = new JComboBox<>();
        comboBoxCinExaminateur.setBounds(1188, 290, 96, 19);
        framej.getContentPane().add(comboBoxCinExaminateur);

        comboBoxCinEncadreur = new JComboBox<>();
        comboBoxCinEncadreur.setBounds(627, 290, 96, 19);
        framej.getContentPane().add(comboBoxCinEncadreur);

        JButton btnNewButton = new JButton("Ajouter");
        btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton.setOpaque(false);
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setForeground(new Color(0, 0, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPfe = (String) comboBoxIdPFE.getSelectedItem();
                String cinPresident = (String) comboBoxCinPresident.getSelectedItem();
                String cinRapporteur = (String) comboBoxCinRapporteur.getSelectedItem();
                String cinExaminateur = (String) comboBoxCinExaminateur.getSelectedItem();
                String cinEncadreur = (String) comboBoxCinEncadreur.getSelectedItem();

                Connection connection = sqlconnect.conn();
                try {
                    // Vérifiez d'abord s'il n'existe pas déjà un jury pour cet ID PFE
                    String selectSql = "SELECT * FROM JURY WHERE ID_PFE = ?";
                    PreparedStatement selectStatement = connection.prepareStatement(selectSql);
                    selectStatement.setString(1, idPfe);
                    ResultSet resultSet = selectStatement.executeQuery();
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "Un jury existe déjà pour cet ID PFE.");
                    } else {
                        // Insérer les données dans la table JURY
                        String insertSql = "INSERT INTO JURY (ID_PFE, CIN_PRESIDENT, CIN_RAPPORTEUR, CIN_EXAMINATEUR, CIN_ENCADREUR) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                        insertStatement.setString(1, idPfe);
                        insertStatement.setString(2, cinPresident);
                        insertStatement.setString(3, cinRapporteur);
                        insertStatement.setString(4, cinExaminateur);
                        insertStatement.setString(5, cinEncadreur);

                        int rowsInserted = insertStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Membres du jury ajoutés avec succès !");
                        } else {
                            JOptionPane.showMessageDialog(null, "Échec de l'ajout des membres du jury.");
                        }
                    }
                    connection.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL : " + ex.getMessage());
                }
            }
        });
        btnNewButton.setBounds(350, 334, 85, 28);
        framej.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("back");
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton_1.setBackground(new Color(255, 165, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PFE m = new PFE();
                m.frame.setVisible(true);
                framej.dispose();
            }
        });
        btnNewButton_1.setBounds(453, 331, 85, 21);
        framej.getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_6.setBounds(152, 10, 925, 125);
        framej.getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_7.setBounds(705, 47, 602, 48);
        framej.getContentPane().add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Law-icon.png"));
        lblNewLabel_8.setBounds(567, 105, 202, 182);
        framej.getContentPane().add(lblNewLabel_8);

        // Charger les données dans les JComboBox
        loadComboBoxData();
    }

    private void loadComboBoxData() {
        try {
            Connection connection = sqlconnect.conn();
            
            // Charger les ID_PFE dans comboBoxIdPFE à partir de la table pfee
            String selectIdPFE = "SELECT id_pfe FROM pfee";
            PreparedStatement selectIdPFEStatement = connection.prepareStatement(selectIdPFE);
            ResultSet idPfeResultSet = selectIdPFEStatement.executeQuery();
            while (idPfeResultSet.next()) {
                comboBoxIdPFE.addItem(idPfeResultSet.getString("id_pfe"));
            }

            // Charger les CIN des enseignants dans les autres JComboBox à partir de la table enseignant
            String selectCinEnseignant = "SELECT cin FROM enseignant";
            PreparedStatement selectCinEnseignantStatement = connection.prepareStatement(selectCinEnseignant);
            ResultSet cinEnseignantResultSet = selectCinEnseignantStatement.executeQuery();
            while (cinEnseignantResultSet.next()) {
                String cin = cinEnseignantResultSet.getString("cin");
                comboBoxCinPresident.addItem(cin);
                comboBoxCinRapporteur.addItem(cin);
                comboBoxCinExaminateur.addItem(cin);
                comboBoxCinEncadreur.addItem(cin);
            }

            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données : " + ex.getMessage());
        }
    }
}
