import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class nouveau_encadrement {

    public JFrame frameEncadrement;
    private JComboBox<String> comboBoxIdPFE;
    private JComboBox<String> comboBoxCinEnseignant;
    private JRadioButton r1, r2, r3;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    nouveau_encadrement window = new nouveau_encadrement();
                    window.frameEncadrement.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public nouveau_encadrement() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frameEncadrement = new JFrame();
        frameEncadrement.setUndecorated(true); 
        frameEncadrement.getContentPane().setBackground(new Color(72, 119, 183));
        frameEncadrement.setBounds(100, 100, 450, 370);
        frameEncadrement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEncadrement.getContentPane().setLayout(null);

        JLabel lblIdPFE = new JLabel("ID PFE:");
        lblIdPFE.setForeground(SystemColor.activeCaptionBorder);
        lblIdPFE.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblIdPFE.setBounds(227, 85, 70, 19);
        frameEncadrement.getContentPane().add(lblIdPFE);

        JLabel lblCinEnseignant = new JLabel("CIN Enseignant:");
        lblCinEnseignant.setForeground(SystemColor.activeCaptionBorder);
        lblCinEnseignant.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCinEnseignant.setBounds(227, 149, 120, 19);
        frameEncadrement.getContentPane().add(lblCinEnseignant);

        JLabel lblTypeEncadrement = new JLabel("Type Encadrement:");
        lblTypeEncadrement.setForeground(SystemColor.activeCaptionBorder);
        lblTypeEncadrement.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTypeEncadrement.setBounds(227, 201, 150, 19);
        frameEncadrement.getContentPane().add(lblTypeEncadrement);

        comboBoxIdPFE = new JComboBox<>();
        comboBoxIdPFE.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        comboBoxIdPFE.setOpaque(false);
        comboBoxIdPFE.setBounds(227, 114, 150, 25);
        frameEncadrement.getContentPane().add(comboBoxIdPFE);

        comboBoxCinEnseignant = new JComboBox<>();
        comboBoxCinEnseignant.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        comboBoxCinEnseignant.setBounds(227, 171, 150, 25);
        frameEncadrement.getContentPane().add(comboBoxCinEnseignant);

        r1 = new JRadioButton("Principal");
        r1.setOpaque(false);
        r1.setForeground(new Color(218, 165, 32));
        r1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        r1.setBounds(227, 258, 80, 25);
        frameEncadrement.getContentPane().add(r1);

        r2 = new JRadioButton("Co-encadrant");
        r2.setForeground(new Color(218, 165, 32));
        r2.setOpaque(false);
        r2.setBounds(227, 285, 110, 25);
        frameEncadrement.getContentPane().add(r2);

        r3 = new JRadioButton("Examinateur");
        r3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        r3.setForeground(new Color(218, 165, 32));
        r3.setOpaque(false);
        r3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        r3.setBounds(230, 226, 100, 25);
        frameEncadrement.getContentPane().add(r3);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setOpaque(false);
        btnAjouter.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPFE = (String) comboBoxIdPFE.getSelectedItem();
                String cinEnseignant = (String) comboBoxCinEnseignant.getSelectedItem();
                String typeEncadrement = "";

                if (r1.isSelected()) {
                    typeEncadrement = "Principal";
                } else if (r2.isSelected()) {
                    typeEncadrement = "Co-encadrant";
                } else if (r3.isSelected()) {
                    typeEncadrement = "Examinateur";
                }

                Connection conn = sqlconnect.conn(); 

                try {
                    String selectSql = "SELECT * FROM encadrement WHERE id_pfe = ? AND cin_enseignant = ? AND type_encadrement = ?";
                    PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                    selectStatement.setString(1, idPFE);
                    selectStatement.setString(2, cinEnseignant);
                    selectStatement.setString(3, typeEncadrement);
                    ResultSet resultSet = selectStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(frameEncadrement, "Cette entrée existe déjà dans la table Encadrement.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String insertSql = "INSERT INTO encadrement (id_pfe, cin_enseignant, type_encadrement) VALUES (?, ?, ?)";
                        PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                        insertStatement.setString(1, idPFE);
                        insertStatement.setString(2, cinEnseignant);
                        insertStatement.setString(3, typeEncadrement);

                        int rowsInserted = insertStatement.executeUpdate();

                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(frameEncadrement, "Nouvel encadrement ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frameEncadrement, "Erreur lors de l'ajout de l'encadrement.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    conn.close(); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameEncadrement, "Erreur SQL : " + ex.getMessage(), "Erreur SQL", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAjouter.setBackground(new Color(255, 165, 0));
        btnAjouter.setForeground(new Color(0, 0, 255));
        btnAjouter.setBounds(340, 280, 100, 30);
        frameEncadrement.getContentPane().add(btnAjouter);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(281, 351, 85, 21);
        frameEncadrement.getContentPane().add(btnNewButton);
        btnNewButton.setOpaque(false);
        btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.setForeground(new Color(218, 165, 32));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PFE m=new PFE();
				m.frame.setVisible(true);
				frameEncadrement.dispose();  
        	}
        });
        btnNewButton.setBounds(227, 327, 85, 21);
        frameEncadrement.getContentPane().add(btnNewButton);
        
        panel = new JPanel();
        panel.setBackground(new Color(218, 165, 32));
        panel.setBounds(0, 0, 217, 410);
        frameEncadrement.getContentPane().add(panel);
        panel.setLayout(null);
        
        lblNewLabel = new JLabel("X");
        lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frameEncadrement.dispose();
        	}
        });
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(72, 119, 183));
        lblNewLabel.setBounds(0, 0, 45, 13);
        panel.add(lblNewLabel);
        
                JLabel lblEncadrement = new JLabel("Nouvel");
                lblEncadrement.setBounds(139, 22, 250, 25);
                panel.add(lblEncadrement);
                lblEncadrement.setForeground(new Color(72, 119, 183));
                lblEncadrement.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\circle-icon (1).png"));
                lblNewLabel_2.setBounds(30, 169, 144, 128);
                panel.add(lblNewLabel_2);
                
                lblNewLabel_3 = new JLabel("Bienvenue");
                lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
                lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
                lblNewLabel_3.setBounds(30, 134, 144, 25);
                panel.add(lblNewLabel_3);
                
                lblNewLabel_1 = new JLabel(" Encadrement");
                lblNewLabel_1.setBounds(213, 14, 154, 36);
                frameEncadrement.getContentPane().add(lblNewLabel_1);
                lblNewLabel_1.setForeground(new Color(218, 165, 32));
                lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));

        loadComboBoxData();
    }

    private void loadComboBoxData() {
        try {
            Connection conn = sqlconnect.conn(); 

            String selectIdPFE = "SELECT id_pfe FROM pfee";
            PreparedStatement selectIdPFEStatement = conn.prepareStatement(selectIdPFE);
            ResultSet idPfeResultSet = selectIdPFEStatement.executeQuery();
            while (idPfeResultSet.next()) {
                comboBoxIdPFE.addItem(idPfeResultSet.getString("id_pfe"));
            }

            String selectCinEnseignant = "SELECT cin FROM enseignant";
            PreparedStatement selectCinEnseignantStatement = conn.prepareStatement(selectCinEnseignant);
            ResultSet cinEnseignantResultSet = selectCinEnseignantStatement.executeQuery();
            while (cinEnseignantResultSet.next()) {
                comboBoxCinEnseignant.addItem(cinEnseignantResultSet.getString("cin"));
            }

            conn.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frameEncadrement, "Erreur SQL : " + ex.getMessage(), "Erreur SQL", JOptionPane.ERROR_MESSAGE);
        }
    }
}
