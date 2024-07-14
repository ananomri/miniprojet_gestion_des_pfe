import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class nouvelle_soutenance {

    public JFrame frames;
  /*  private JTextField t1;*/
    private JTextField t5;
    private JComboBox<String> t4;
    private JComboBox<String> t3;
    private JDateChooser t2;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private ButtonGroup buttonGroup;

    private static final Color BLEU = new Color(0, 102, 204);
    /*private static final Color ORANGE = new Color(255, 165, 0);*/
    private JLabel lblNewLabel_4;
   /* private JButton btnNewButton_1;*/
    private JPanel panel;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    nouvelle_soutenance window = new nouvelle_soutenance();
                    window.frames.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public nouvelle_soutenance() {
        initialize();
    }

    public void initialize() {
        frames = new JFrame();
        frames.getContentPane().setBackground(BLEU);
        frames.setUndecorated(true); 
        frames.setBounds(100, 100, 473, 499);
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Id jury");
        lblNewLabel_1.setForeground(new Color(180, 180, 180));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(242, 98, 95, 23);
        frames.getContentPane().add(lblNewLabel_1);

         JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(242, 119, 96, 19); // Positionner le JComboBox comme le JTextField
        frames.getContentPane().add(comboBox);

        try (Connection conn = sqlconnect.conn()) {
            // Requête SQL pour récupérer les valeurs id_jury de la table jury
            String sql = "SELECT id_jury FROM jury";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Parcourir les résultats et ajouter les valeurs au JComboBox
            while (resultSet.next()) {
                String idJury = resultSet.getString("id_jury");
                comboBox.addItem(idJury);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frames, "Erreur lors de la récupération des données depuis la base de données");
        }

        frames.setVisible(true);
        ////
        
        /*
        t1 = new JTextField();
        t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t1.setOpaque(false);
        t1.setBounds(242, 119, 96, 19);
        frames.getContentPane().add(t1);
        t1.setColumns(10);*/

        JLabel lblNewLabel_2 = new JLabel("Date soutenance");
        lblNewLabel_2.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(242, 138, 141, 23);
        frames.getContentPane().add(lblNewLabel_2);

        t2 = new JDateChooser();
        t2.setOpaque(false);
        t2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t2.setBounds(242, 159, 120, 19);
        frames.getContentPane().add(t2);

        JLabel lblNewLabel_3 = new JLabel("Heure soutenance");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_3.setBounds(245, 182, 138, 13);
        frames.getContentPane().add(lblNewLabel_3);

        t3 = new JComboBox<String>();
        t3.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(218, 165, 32)));
        t3.setOpaque(false);
        t3.setBounds(242, 198, 96, 21);
        frames.getContentPane().add(t3);

        for (int i = 8; i <= 18; i++) {
            t3.addItem(String.format("%02d:00", i));
        }

        r1 = new JRadioButton("Oui");
        r1.setOpaque(false);
        r1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        r2 = new JRadioButton("Non");
        r2.setOpaque(false);
        r3 = new JRadioButton("À venir");
        r3.setOpaque(false);

        frames.getContentPane().add(r1);
        frames.getContentPane().add(r2);
        frames.getContentPane().add(r3);

        r1.setBounds(242, 288, 62, 21);
        r2.setBounds(306, 288, 62, 21);
        r3.setBounds(373, 288, 100, 21);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        JLabel lblLieu = new JLabel("Lieu");
        lblLieu.setForeground(SystemColor.activeCaptionBorder);
        lblLieu.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblLieu.setBounds(242, 216, 45, 23);
        frames.getContentPane().add(lblLieu);

        t4 = new JComboBox<String>();
        t4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t4.setBounds(242, 236, 150, 23);
        frames.getContentPane().add(t4);

        t4.addItem("Salle de réunion A");
        t4.addItem("Salle de conférence B");
        t4.addItem("Salle de formation C");
        t4.addItem("Salle de détente");

        JLabel lblNote = new JLabel("Note");
        lblNote.setForeground(SystemColor.activeCaptionBorder);
        lblNote.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNote.setBounds(242, 315, 45, 13);
        frames.getContentPane().add(lblNote);

        t5 = new JTextField();
        t5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        t5.setOpaque(false);
        t5.setBounds(242, 332, 96, 19);
        frames.getContentPane().add(t5);
        t5.setColumns(10);
        t5.setEnabled(false);

        r1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r1.isSelected() || r2.isSelected()) {
                    t5.setEnabled(true);
                } else {
                    t5.setEnabled(false);
                    t5.setText(""); 
                }
            }
        });

        r2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r1.isSelected() || r2.isSelected()) {
                    t5.setEnabled(true);
                } else {
                    t5.setEnabled(false);
                    t5.setText(""); 
                }
            }
        });

        r3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isFutureSoutenance = r3.isSelected();
                t5.setEnabled(!isFutureSoutenance);
                t5.setText("");
            }
        });

        JButton btnNewButton = createStyledButton("Ajouter", 209, 414, 85, 21,comboBox);
        frames.getContentPane().add(btnNewButton);

        JButton btnBack = new JButton("back!");
        btnBack.setBounds(281, 351, 85, 21);
        frames.getContentPane().add(btnBack);
        btnBack.setOpaque(false);
        btnBack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnBack.setBackground(new Color(255, 165, 0));
        btnBack.setForeground(new Color(218, 165, 32));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				PFE m=new PFE();
				m.frame.setVisible(true);
				frames.dispose();            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setForeground(new Color(0, 0, 255));
        btnBack.setBounds(373, 420, 85, 21);
        frames.getContentPane().add(btnBack);

        JButton btnModifyNote = new JButton("Modifier note pfe");
        btnModifyNote.setBounds(281, 351, 85, 21);
        frames.getContentPane().add(btnModifyNote);
        btnModifyNote.setOpaque(false);
        btnModifyNote.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnModifyNote.setBackground(new Color(255, 165, 0));
        btnModifyNote.setForeground(new Color(218, 165, 32));
        btnModifyNote.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnModifyNote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String idJuryStr = (String)comboBox.getSelectedItem();
                int idJury = 0;
                try {
                    idJury = Integer.parseInt(idJuryStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Id jury invalide. Veuillez saisir un nombre entier.");
                    return;
                }

                String note = t5.getText();

                String valide = r1.isSelected() ? "Oui" : (r2.isSelected() ? "Non" : "À venir");
                try (Connection connection = sqlconnect.conn()) {
                    String updateQuery = "UPDATE soutenancee SET note = ?, validee = ? WHERE id_jury = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, note);
                    updateStatement.setString(2, valide);
                    updateStatement.setInt(3, idJury);

                    int rowsUpdated = updateStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Note et statut de validation mis à jour avec succès !");
                    } else {
                        JOptionPane.showMessageDialog(null, "Échec de la mise à jour de la note et du statut de validation.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL lors de la mise à jour de la note et du statut de validation : " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                }
            }
        });
        btnModifyNote.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnModifyNote.setForeground(new Color(0, 0, 255));
        btnModifyNote.setBounds(234, 451, 163, 21);
        frames.getContentPane().add(btnModifyNote);
        
        lblNewLabel_4 = new JLabel("valide");
        lblNewLabel_4.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_4.setBounds(242, 269, 45, 13);
        frames.getContentPane().add(lblNewLabel_4);
        
        
       
        
        
                
        JButton btnNewButton_1 = new JButton("modifier note etudiant");
        btnNewButton_1.setBounds(281, 351, 85, 21);
        frames.getContentPane().add(btnNewButton_1);
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton_1.setBackground(new Color(255, 165, 0));
        btnNewButton_1.setForeground(new Color(218, 165, 32));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String idJuryStr = (String)comboBox.getSelectedItem();
                int idJury = 0;
                try {
                    idJury = Integer.parseInt(idJuryStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Id jury invalide. Veuillez saisir un nombre entier.");
                    return;
                }

                String note = t5.getText();

                try (Connection connection = sqlconnect.conn()) {
                    String idPfeQuery = "SELECT id_pfe FROM jury WHERE id_jury = ?";
                    PreparedStatement idPfeStatement = connection.prepareStatement(idPfeQuery);
                    idPfeStatement.setInt(1, idJury);
                    ResultSet idPfeResult = idPfeStatement.executeQuery();

                    while (idPfeResult.next()) {
                        int idPfe = idPfeResult.getInt("id_pfe");
                        String cinQuery = "SELECT cin_etudiant_1, cin_etudiant_2 FROM pfee WHERE id_pfe = ?";
                        PreparedStatement cinStatement = connection.prepareStatement(cinQuery);
                        cinStatement.setInt(1, idPfe);
                        ResultSet resultSet = cinStatement.executeQuery();
                        String updateQuery = "UPDATE etudiant SET note = ? WHERE cin = ?";
                        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                        while (resultSet.next()) {
                            String cin1 = resultSet.getString("cin_etudiant_1");
                            String cin2 = resultSet.getString("cin_etudiant_2");
                            updateStatement.setString(1, note);
                            updateStatement.setString(2, cin1);
                            updateStatement.executeUpdate();
                            if (cin2 != null && !cin2.isEmpty()) {
                                updateStatement.setString(1, note);
                                updateStatement.setString(2, cin2);
                                updateStatement.executeUpdate();
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Notes des étudiants mises à jour avec succès !");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL lors de la mise à jour des notes des étudiants : " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                }
            }
        });

        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setBounds(234, 388, 196, 21);
        frames.getContentPane().add(btnNewButton_1);
        
        panel = new JPanel();
        panel.setBackground(new Color(218, 165, 32));
        panel.setBounds(0, 0, 228, 499);
        frames.getContentPane().add(panel);
        panel.setLayout(null);
        
        lblNewLabel_5 = new JLabel("X");
        lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frames.dispose();
        	}
        });
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_5.setForeground(new Color(72, 119, 183));
        lblNewLabel_5.setBounds(0, 10, 45, 13);
        panel.add(lblNewLabel_5);
        
                JLabel lblNewLabel = new JLabel("Nouvelle");
                lblNewLabel.setBounds(139, 23, 89, 39);
                panel.add(lblNewLabel);
                lblNewLabel.setForeground(new Color(72, 119, 183));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                lblNewLabel_7 = new JLabel("Bienvenue");
                lblNewLabel_7.setForeground(SystemColor.activeCaptionBorder);
                lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 30));
                lblNewLabel_7.setBounds(26, 136, 160, 39);
                panel.add(lblNewLabel_7);
                
                lblNewLabel_8 = new JLabel("");
                lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\circle-icon (1).png"));
                lblNewLabel_8.setBounds(36, 171, 140, 149);
                panel.add(lblNewLabel_8);
                
                lblNewLabel_6 = new JLabel("Soutenance");
                lblNewLabel_6.setBounds(242, 32, 122, 25);
                frames.getContentPane().add(lblNewLabel_6);
                lblNewLabel_6.setForeground(new Color(218, 165, 32));
                lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                
                
                

        frames.setVisible(true);
    }

    private JButton createStyledButton(String text, int x, int y, int width, int height,JComboBox<String> comboBox) {
        JButton button = new JButton(text);
        button.setOpaque(false);
        button.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String idJuryStr = (String)comboBox.getSelectedItem();
                int idJury = 0;
                try {
                    idJury = Integer.parseInt(idJuryStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Id jury invalide. Veuillez saisir un nombre entier.");
                    return;
                }

                if (!isIdJuryUnique(idJury)) {
                    JOptionPane.showMessageDialog(null, "L'id jury existe déjà. Veuillez saisir un autre id jury.");
                    return;
                }
                Date selectedDate = t2.getDate();
                if (selectedDate == null) {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une date de soutenance.");
                    return;
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(selectedDate);
                String heureSoutenance = (String) t3.getSelectedItem() + ":00";
                String salle = (String) t4.getSelectedItem();
                String valide="";
                if (isSoutenanceExists(salle, formattedDate, heureSoutenance)) {
                    JOptionPane.showMessageDialog(null, "Il existe déjà une soutenance dans cette salle à cette date et heure.");
                    return;
                }

                try (Connection connection = sqlconnect.conn()) {
                	if (r1.isSelected()) {
                        valide = "Oui";
                    } else if (r2.isSelected()) {
                        valide = "Non";
                    } else if (r3.isSelected()) {
                        valide = "À venir";
                    }
                    String note = "";

                    if (r1.isSelected() || r2.isSelected()) {
                        note = t5.getText();
                    
                    try {
                        double noteValue = Double.parseDouble(note);
                        if (noteValue < 0 || noteValue > 20) {
                            JOptionPane.showMessageDialog(null, "La note doit être comprise entre 0 et 20.");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Veuillez saisir une valeur numérique pour la note.");
                        return;
                    }}
                    String insertQuery = "INSERT INTO soutenancee (id_jury, date_soutenance, heure_soutenance, lieu, note, validee) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setInt(1, idJury);
                    insertStatement.setDate(2, java.sql.Date.valueOf(formattedDate));
                    insertStatement.setTimestamp(3, Timestamp.valueOf(formattedDate + " " + heureSoutenance));
                    insertStatement.setString(4, salle);
                    insertStatement.setString(5, note);
                    insertStatement.setString(6, valide);

                    int rowsInserted = insertStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Soutenance ajoutée avec succès !");
                    } else {
                        JOptionPane.showMessageDialog(null, "Échec de l'ajout de la soutenance.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL lors de l'insertion de la soutenance : " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                }
            }
        });
        button.setBounds(373, 357, width, height);
        button.setBackground(BLEU);
        button.setForeground(new Color(218, 165, 32));
        button.setFont(new Font("Tahoma", Font.PLAIN, 12));
        return button;
    }

    private boolean isIdJuryUnique(int idJury) {
        try (Connection connection = sqlconnect.conn()) {
            String checkQuery = "SELECT COUNT(*) AS count FROM soutenancee WHERE id_jury = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, idJury);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count == 0; 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur SQL lors de la vérification de l'unicité de l'id_jury : " + ex.getMessage());
        }
        return false; 
    }

    private boolean isSoutenanceExists(String salle, String date, String heure) {
        try (Connection connection = sqlconnect.conn()) {
            String checkQuery = "SELECT * FROM soutenancee WHERE lieu = ? AND date_soutenance = ? AND heure_soutenance = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, salle);
            checkStatement.setDate(2, java.sql.Date.valueOf(date));
            checkStatement.setTimestamp(3, Timestamp.valueOf(date + " " + heure));
            ResultSet resultSet = checkStatement.executeQuery();
            return resultSet.next(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur SQL lors de la vérification de l'existence de la soutenance : " + ex.getMessage());
            return true; 
        }
    }
}
