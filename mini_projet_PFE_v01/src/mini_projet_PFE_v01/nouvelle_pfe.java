
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class nouvelle_pfe {

    public JFrame framepfe;
    private JTextField t1;
    private JDateChooser t2;
    private JDateChooser t3;
    private JComboBox<String> t4;
    private JComboBox<String> t5;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    nouvelle_pfe window = new nouvelle_pfe();
                    window.framepfe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public nouvelle_pfe() {
        initialize();
        loadCINsToComboBoxes(); 
    }

    private void initialize() {
        framepfe = new JFrame();
        framepfe.getContentPane().setBackground(new Color(72, 119, 183));
        framepfe.setUndecorated(true); 
        framepfe.setBounds(100, 100, 524, 395);
        framepfe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framepfe.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Titre");
        lblNewLabel_1.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(282, 100, 96, 13);
        framepfe.getContentPane().add(lblNewLabel_1);

        t1 = new JTextField();
        t1.setOpaque(false);
        t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t1.setBounds(282, 123, 150, 19);
        framepfe.getContentPane().add(t1);
        t1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Date Début");
        lblNewLabel_2.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(282, 144, 96, 19);
        framepfe.getContentPane().add(lblNewLabel_2);

        t2 = new JDateChooser();
        t2.setOpaque(false);
        t2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t2.setBounds(282, 162, 150, 19);
        framepfe.getContentPane().add(t2);

        JLabel lblNewLabel_3 = new JLabel("Date Fin");
        lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(282, 182, 64, 13);
        framepfe.getContentPane().add(lblNewLabel_3);

        t3 = new JDateChooser();
        t3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t3.setOpaque(false);
        t3.setBounds(282, 197, 150, 19);
        framepfe.getContentPane().add(t3);

        JLabel lblNewLabel_4 = new JLabel("CIN Étudiant");
        lblNewLabel_4.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_4.setBounds(282, 218, 110, 13);
        framepfe.getContentPane().add(lblNewLabel_4);

        t4 = new JComboBox<>();
        t4.setOpaque(false);
        t4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t4.setBounds(282, 234, 150, 19);
        framepfe.getContentPane().add(t4);

        JLabel lblNewLabel_5 = new JLabel("CIN Partenaire");
        lblNewLabel_5.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_5.setBounds(282, 252, 110, 13);
        framepfe.getContentPane().add(lblNewLabel_5);

        t5 = new JComboBox<>();
        t5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t5.setOpaque(false);
        t5.setBounds(282, 268, 150, 19);
        framepfe.getContentPane().add(t5);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(218, 165, 32));
        panel.setBounds(0, 0, 255, 395);
        framepfe.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel close = new JLabel("X");
        close.setBackground(new Color(72, 119, 183));
        close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        close.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		framepfe.dispose()    ;
        		}
        });
        close.setForeground(new Color(72, 119, 183));
        close.setHorizontalAlignment(SwingConstants.CENTER);
        close.setFont(new Font("Tahoma", Font.BOLD, 15));
        close.setBounds(0, 0, 45, 25);
        panel.add(close);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\circle-icon (1).png"));
        lblNewLabel_7.setBounds(24, 186, 153, 141);
        panel.add(lblNewLabel_7);
        
        JLabel lblNewLabel_6 = new JLabel("Bienvenue");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_6.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_6.setBounds(24, 114, 162, 62);
        panel.add(lblNewLabel_6);
        
                JLabel lblNewLabel = new JLabel("Nouveau");
                lblNewLabel.setBounds(159, 10, 96, 33);
                panel.add(lblNewLabel);
                lblNewLabel.setForeground(new Color(72, 119, 183));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                JLabel lblNewLabel_8 = new JLabel("PFE");
                lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel_8.setForeground(new Color(218, 165, 32));
                lblNewLabel_8.setBounds(263, 10, 45, 35);
                framepfe.getContentPane().add(lblNewLabel_8);
                
                        JButton ajouter = new JButton("Ajouter");
                        ajouter.setBounds(429, 351, 85, 21);
                        framepfe.getContentPane().add(ajouter);
                        ajouter.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
                        ajouter.setOpaque(false);
                        ajouter.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String titre = t1.getText();
                                Date dateDebut = t2.getDate();
                                Date dateFin = t3.getDate();
                                String cinEtudiant = (String) t4.getSelectedItem();
                                String cinPartenaire = (String) t5.getSelectedItem();

                                if (titre.isEmpty() || dateDebut == null || dateFin == null || cinEtudiant.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
                                    return;
                                }

                                if (dateDebut.after(dateFin)) {
                                    JOptionPane.showMessageDialog(null, "La date de début doit être avant la date de fin.");
                                    return;
                                }

                                Calendar calDebut = Calendar.getInstance();
                                calDebut.setTime(dateDebut);

                                Calendar calFin = Calendar.getInstance();
                                calFin.setTime(dateFin);

                                long diffInMillies = Math.abs(calFin.getTimeInMillis() - calDebut.getTimeInMillis());
                                long diffInMonths = TimeUnit.MILLISECONDS.toDays(diffInMillies) / 30;

                                if (diffInMonths < 3) {
                                    JOptionPane.showMessageDialog(null, "La durée du projet doit être d'au moins 3 mois.");
                                    return;
                                }

                                try {
                                    Connection connection = sqlconnect.conn();
                                    if (connection != null) {
                                        String sql = "INSERT INTO PFEE (TITRE, DATE_DEBUT, DATE_FIN, CIN_ETUDIANT_1, CIN_ETUDIANT_2) VALUES (?, ?, ?, ?, ?)";
                                        PreparedStatement statement = connection.prepareStatement(sql);
                                        statement.setString(1, titre);
                                        statement.setDate(2, new java.sql.Date(dateDebut.getTime()));
                                        statement.setDate(3, new java.sql.Date(dateFin.getTime()));
                                        statement.setString(4, cinEtudiant);
                                        statement.setString(5, cinPartenaire);
                                        int rowsInserted = statement.executeUpdate();

                                        if (rowsInserted > 0) {
                                            JOptionPane.showMessageDialog(null, "Enregistrement inséré avec succès !");
                                            // Réinitialiser les champs après l'insertion réussie
                                            t1.setText("");
                                            t2.setDate(null);
                                            t3.setDate(null);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "L'enregistrement n'a pas pu être inséré.");
                                        }
                                        statement.close();
                                        connection.close();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué.");
                                    }
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Erreur SQL : " + ex.getMessage());
                                }
                            }
                        });
                        ajouter.setBackground(new Color(255, 165, 0));
                        ajouter.setForeground(new Color(0, 0, 255));
                        ajouter.setFont(new Font("Tahoma", Font.BOLD, 15));
                        
                                JButton btnRetour = new JButton("Retour");
                                btnRetour.setBounds(281, 351, 85, 21);
                                framepfe.getContentPane().add(btnRetour);
                                btnRetour.setOpaque(false);
                                btnRetour.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
                                btnRetour.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                    	PFE m=new PFE();
				                        m.frame.setVisible(true);
				                        framepfe.dispose();       
                                    }
                                });
                                btnRetour.setBackground(new Color(255, 165, 0));
                                btnRetour.setForeground(new Color(0, 0, 255));
                                btnRetour.setFont(new Font("Tahoma", Font.BOLD, 15));
    }

    private void loadCINsToComboBoxes() {
        try {
            Connection connection = sqlconnect.conn(); 
            if (connection != null) {
                String selectSql = "SELECT CIN FROM Etudiant"; // Requête SQL pour récupérer les CINs des étudiants
                PreparedStatement selectStatement = connection.prepareStatement(selectSql);
                ResultSet resultSet = selectStatement.executeQuery();

                t4.removeAllItems(); 
                t5.removeAllItems(); 

                while (resultSet.next()) {
                    String cin = resultSet.getString("CIN");
                    t4.addItem(cin); 
                    t5.addItem(cin); 
                }

                resultSet.close();
                selectStatement.close();
                connection.close();
            } else {
                JOptionPane.showMessageDialog(null, "La connexion à la base de données a échoué.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur SQL : " + ex.getMessage());
        }
    }
}
