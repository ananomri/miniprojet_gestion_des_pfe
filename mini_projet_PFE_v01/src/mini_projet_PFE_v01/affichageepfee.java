import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.text.MessageFormat;
import java.awt.print.PrinterException;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class affichageepfee {

    public JFrame frame;
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;
    private DefaultTableModel tableModel3;
    private DefaultTableModel tableModelNonValides;
    private DefaultTableModel tableModelParHeure;
    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    affichageepfee window = new affichageepfee();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public affichageepfee() {
        initialize();
        connection = sqlconnect.conn();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(72, 119, 183));
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Users-Student-2-icon.png"));
        frame.setBounds(100, 100, 1012, 882);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Affichage des PFES & SOUTENANCES");
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 60));
        lblTitle.setBounds(0, 163, 1048, 48);
        frame.getContentPane().add(lblTitle);

        String[] columns1 = {"ID PFE", "Titre", "CIN Etudiant 1", "CIN Etudiant 2"};
        tableModel1 = new DefaultTableModel(columns1, 0); 
        JTable table1 = new JTable(tableModel1);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        scrollPane1.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(218, 165, 32)));
        scrollPane1.setBounds(69, 372, 331, 112);
        frame.getContentPane().add(scrollPane1);

        JButton btnAfficherPFEs = new JButton("Afficher PFEs");
        btnAfficherPFEs.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAfficherPFEs.setOpaque(false);
        btnAfficherPFEs.setBackground(new Color(255, 165, 0));
        btnAfficherPFEs.setForeground(new Color(0, 0, 255));
        btnAfficherPFEs.setBounds(69, 332, 220, 30);
        frame.getContentPane().add(btnAfficherPFEs);

        JButton btnImprimerTableau1 = new JButton("Imprimer");
        btnImprimerTableau1.setForeground(new Color(255, 165, 0));
        btnImprimerTableau1.setBounds(310, 332, 90, 30);
        frame.getContentPane().add(btnImprimerTableau1);
        btnImprimerTableau1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimerTableau(table1,"liste des pfe");
            }
        });
    

        String[] columns2 = {"ID Soutenance", "Date", "Heure", "Valide"};
        tableModel2 = new DefaultTableModel(columns2, 0); 
        JTable table2 = new JTable(tableModel2);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        scrollPane2.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(218, 165, 32)));
        scrollPane2.setBounds(69, 534, 338, 105);
        frame.getContentPane().add(scrollPane2);

        JButton btnAfficherSoutenancesValides = new JButton("Afficher Soutenances Valides");
        btnAfficherSoutenancesValides.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAfficherSoutenancesValides.setOpaque(false);
        btnAfficherSoutenancesValides.setBackground(new Color(255, 165, 0));
        btnAfficherSoutenancesValides.setForeground(new Color(0, 0, 255));
        btnAfficherSoutenancesValides.setBounds(69, 494, 220, 30);
        frame.getContentPane().add(btnAfficherSoutenancesValides);

        JButton btnImprimerTableau2 = new JButton("Imprimer");
        btnImprimerTableau2.setForeground(new Color(255, 165, 0));
        btnImprimerTableau2.setBounds(317, 494, 90, 30);
        frame.getContentPane().add(btnImprimerTableau2);
        btnImprimerTableau2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimerTableau(table2,"liste des soutenance validees");
            }
        });

        String[] columns3 = {"ID Soutenance", "Date", "Heure", "Valide"};
        tableModel3 = new DefaultTableModel(columns3, 0); 
        JTable table3 = new JTable(tableModel3);
        JScrollPane scrollPane3 = new JScrollPane(table3);
        scrollPane3.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(218, 165, 32)));
        scrollPane3.setBounds(69, 689, 338, 90);
        frame.getContentPane().add(scrollPane3);

        JButton btnAfficherSoutenancesAVenir = new JButton("Afficher Soutenances à Venir");
        btnAfficherSoutenancesAVenir.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAfficherSoutenancesAVenir.setOpaque(false);
        btnAfficherSoutenancesAVenir.setForeground(new Color(0, 0, 255));
        btnAfficherSoutenancesAVenir.setBackground(new Color(255, 165, 0));
        btnAfficherSoutenancesAVenir.setBounds(69, 649, 220, 30);
        frame.getContentPane().add(btnAfficherSoutenancesAVenir);

        JButton btnImprimerTableau3 = new JButton("Imprimer");
        btnImprimerTableau3.setForeground(new Color(255, 165, 0));
        btnImprimerTableau3.setBounds(317, 649, 90, 30);
        frame.getContentPane().add(btnImprimerTableau3);
        btnImprimerTableau3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimerTableau(table3,"liste des soutenances a venir");
            }
        });

        String[] columnsNonValides = {"ID Soutenance", "Date", "Heure", "Valide"};
        tableModelNonValides = new DefaultTableModel(columnsNonValides, 0); 
        JTable tableNonValides = new JTable(tableModelNonValides);
        JScrollPane scrollPaneNonValides = new JScrollPane(tableNonValides);
        scrollPaneNonValides.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(218, 165, 32)));
        scrollPaneNonValides.setBounds(446, 372, 338, 112);
        frame.getContentPane().add(scrollPaneNonValides);

        JButton btnAfficherSoutenancesNonValides = new JButton("Afficher Soutenances Non Valides");
        btnAfficherSoutenancesNonValides.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAfficherSoutenancesNonValides.setOpaque(false);
        btnAfficherSoutenancesNonValides.setBackground(new Color(255, 165, 0));
        btnAfficherSoutenancesNonValides.setForeground(new Color(0, 0, 255));
        btnAfficherSoutenancesNonValides.setBounds(446, 332, 232, 30);
        frame.getContentPane().add(btnAfficherSoutenancesNonValides);
        JButton btnImprimerTableauNonValides = new JButton("Imprimer");
        btnImprimerTableauNonValides.setForeground(new Color(255, 165, 0));
        btnImprimerTableauNonValides.setBounds(694, 332, 90, 30);
        frame.getContentPane().add(btnImprimerTableauNonValides);
        btnImprimerTableauNonValides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimerTableau(tableNonValides,"liste des soutenances non valides");
            }
        });
        DefaultTableModel tableModelParDate = new DefaultTableModel(new String[]{"ID Soutenance", "Date", "Heure", "Valide"}, 0);
        JTable tableParDate = new JTable(tableModelParDate);
        JScrollPane scrollPaneParDate = new JScrollPane(tableParDate);
        scrollPaneParDate.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(218, 165, 32)));
        scrollPaneParDate.setBounds(446, 534, 338, 105);
        frame.getContentPane().add(scrollPaneParDate);
        JButton btnImprimerTableauParDate = new JButton("Imprimer");
        btnImprimerTableauParDate.setForeground(new Color(255, 165, 0));
        btnImprimerTableauParDate.setBounds(694, 494, 90, 30);
        frame.getContentPane().add(btnImprimerTableauParDate);
        btnImprimerTableauParDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimerTableau(tableParDate,"liste des soutenances par date");
            }
        });
        JButton btnAfficherSoutenancesParDate = new JButton("Afficher Soutenances par Date");
        btnAfficherSoutenancesParDate.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAfficherSoutenancesParDate.setOpaque(false);
        btnAfficherSoutenancesParDate.setBackground(new Color(255, 165, 0));
        btnAfficherSoutenancesParDate.setForeground(new Color(0, 0, 255));
        btnAfficherSoutenancesParDate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        if (connection == null) {
        		            System.out.println("La connexion à la base de données n'est pas disponible.");
        		            return;
        		        }
          		        String dateDemandee = JOptionPane.showInputDialog(frame, "Entrez la date (YYYY-MM-DD) :");
        		        if (dateDemandee == null || dateDemandee.trim().isEmpty()) {
        		            JOptionPane.showMessageDialog(frame, "Veuillez entrer une date valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        		            return;
        		        }


        		        String query = "SELECT id_soutenance, date_soutenance, heure_soutenance, validee FROM soutenancee WHERE date_soutenance = TO_DATE(?, 'YYYY-MM-DD')";
        		        try (PreparedStatement statement = connection.prepareStatement(query)) {
        		            statement.setString(1, dateDemandee);
        		            ResultSet resultSet = statement.executeQuery();
        		            while (resultSet.next()) {
        		                int idSoutenance = resultSet.getInt("id_soutenance");
        		                String dateSoutenance = resultSet.getString("date_soutenance");
        		                String heureSoutenance = resultSet.getString("heure_soutenance");
        		                String validee = resultSet.getString("validee");

        		                Vector<Object> row = new Vector<>();
        		                row.add(idSoutenance);
        		                row.add(dateSoutenance);
        		                row.add(heureSoutenance);
        		                row.add(validee);
        		                tableModelParDate.addRow(row);
        		            }
        		        } catch (SQLException ex) {
        		            System.out.println("Erreur lors de l'exécution de la requête : " + ex.getMessage());
        		        }
        		    }

        	
        });
        btnAfficherSoutenancesParDate.setBounds(446, 494, 232, 30);
        frame.getContentPane().add(btnAfficherSoutenancesParDate);

        String[] columnsParHeure = {"ID Soutenance", "Date", "Heure", "Valide"};
        tableModelParHeure = new DefaultTableModel(columnsParHeure, 0); 
        JTable tableParHeure = new JTable(tableModelParHeure);
        JScrollPane scrollPaneParHeure = new JScrollPane(tableParHeure);
        scrollPaneParHeure.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(218, 165, 32)));
        scrollPaneParHeure.setBounds(446, 689, 338, 90);
        frame.getContentPane().add(scrollPaneParHeure);

        JButton btnAfficherSoutenancesParHeure = new JButton("Afficher Soutenances par Heure");
        btnAfficherSoutenancesParHeure.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAfficherSoutenancesParHeure.setOpaque(false);
        btnAfficherSoutenancesParHeure.setBackground(new Color(255, 165, 0));
        btnAfficherSoutenancesParHeure.setForeground(new Color(0, 0, 255));
        btnAfficherSoutenancesParHeure.setBounds(446, 649, 232, 30);
        frame.getContentPane().add(btnAfficherSoutenancesParHeure);
        JButton btnImprimerTableauParHeure = new JButton("Imprimer");
        btnImprimerTableauParHeure.setForeground(new Color(255, 165, 0));
        btnImprimerTableauParHeure.setBounds(694, 649, 90, 30);
        frame.getContentPane().add(btnImprimerTableauParHeure);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel.setBounds(363, 45, 646, 48);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_1.setBounds(-159, 10, 524, 133);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
        lblNewLabel_2.setBounds(794, 675, 194, 160);
        frame.getContentPane().add(lblNewLabel_2);
        
        JButton btnNewButton = new JButton("Back!");
        btnNewButton.setBounds(903, 278, 85, 21);
        frame.getContentPane().add(btnNewButton);
        btnNewButton.setOpaque(false);
        btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.setForeground(new Color(218, 165, 32));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PFE m=new PFE();
				m.frame.setVisible(true);
				frame.dispose();  
        	}
        });
        btnNewButton.setBounds(879, 235, 85, 21);
        frame.getContentPane().add(btnNewButton);
        btnImprimerTableauParHeure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimerTableau(tableParHeure,"liste des soutenances par heure");
            }
        });

        btnAfficherPFEs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherPFEs(tableModel1);
            }
        });

        btnAfficherSoutenancesValides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherSoutenancesValides(tableModel2);
            }
        });

        btnAfficherSoutenancesAVenir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherSoutenancesAVenir(tableModel3);
            }
        });

        btnAfficherSoutenancesNonValides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherSoutenancesNonValides(tableModelNonValides);
            }
        });

        btnAfficherSoutenancesParHeure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherSoutenancesPourHeureDonnee();
            }
        });
    }

    private void imprimerTableau(JTable table,String titre) {
        try {
            MessageFormat header = new MessageFormat(titre);
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(frame, "Erreur lors de l'impression : " + e.getMessage(), "Erreur d'impression", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void afficherPFEs(DefaultTableModel tableModel) {
        if (connection == null) {
            System.out.println("La connexion à la base de données n'est pas disponible.");
            return;
        }
        tableModel.setRowCount(0);
        String query = "SELECT id_pfe, titre, cin_etudiant_1, cin_etudiant_2 FROM pfee";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idPfe = resultSet.getInt("id_pfe");
                String titre = resultSet.getString("titre");
                String cinEtudiant1 = resultSet.getString("cin_etudiant_1");
                String cinEtudiant2 = resultSet.getString("cin_etudiant_2");

                Vector<Object> row = new Vector<>();
                row.add(idPfe);
                row.add(titre);
                row.add(cinEtudiant1);
                row.add(cinEtudiant2);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'exécution de la requête : " + ex.getMessage());
        }
    }

    private void afficherSoutenancesValides(DefaultTableModel tableModel) {
        if (connection == null) {
            System.out.println("La connexion à la base de données n'est pas disponible.");
            return;
        }
        tableModel.setRowCount(0);
        String query = "SELECT id_soutenance, date_soutenance, heure_soutenance, validee FROM soutenancee WHERE validee = 'Oui'";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idSoutenance = resultSet.getInt("id_soutenance");
                String dateSoutenance = resultSet.getString("date_soutenance");
                String heureSoutenance = resultSet.getString("heure_soutenance");
                String validee = resultSet.getString("validee");

                Vector<Object> row = new Vector<>();
                row.add(idSoutenance);
                row.add(dateSoutenance);
                row.add(heureSoutenance);
                row.add(validee);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'exécution de la requête : " + ex.getMessage());
        }
    }

    private void afficherSoutenancesAVenir(DefaultTableModel tableModel) {
        if (connection == null) {
            System.out.println("La connexion à la base de données n'est pas disponible.");
            return;
        }
        tableModel.setRowCount(0);
        String query = "SELECT id_soutenance, date_soutenance, heure_soutenance, validee FROM soutenancee WHERE date_soutenance > CURRENT_DATE";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idSoutenance = resultSet.getInt("id_soutenance");
                String dateSoutenance = resultSet.getString("date_soutenance");
                String heureSoutenance = resultSet.getString("heure_soutenance");
                String validee = resultSet.getString("validee");

                Vector<Object> row = new Vector<>();
                row.add(idSoutenance);
                row.add(dateSoutenance);
                row.add(heureSoutenance);
                row.add(validee);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'exécution de la requête : " + ex.getMessage());
        }
    }

    private void afficherSoutenancesNonValides(DefaultTableModel tableModel) {
        if (connection == null) {
            System.out.println("La connexion à la base de données n'est pas disponible.");
            return;
        }
        tableModel.setRowCount(0);
        String query = "SELECT id_soutenance, date_soutenance, heure_soutenance, validee FROM soutenancee WHERE validee = 'Non'";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idSoutenance = resultSet.getInt("id_soutenance");
                String dateSoutenance = resultSet.getString("date_soutenance");
                String heureSoutenance = resultSet.getString("heure_soutenance");
                String validee = resultSet.getString("validee");

                Vector<Object> row = new Vector<>();
                row.add(idSoutenance);
                row.add(dateSoutenance);
                row.add(heureSoutenance);
                row.add(validee);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'exécution de la requête : " + ex.getMessage());
        }
    }

    private void afficherSoutenancesPourHeureDonnee() {
        if (connection == null) {
            System.out.println("La connexion à la base de données n'est pas disponible.");
            return;
        }
        
        String heureDemandee = JOptionPane.showInputDialog(frame, "Entrez l'heure (HH:MM) :");
        if (heureDemandee == null || heureDemandee.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer une heure valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModelParHeure.setRowCount(0);
        String heureRecherchee = heureDemandee + ":00"; 
        String query = "SELECT id_soutenance, date_soutenance, heure_soutenance, validee FROM soutenancee WHERE heure_soutenance LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + heureRecherchee + "%"); 
            ResultSet resultSet = statement.executeQuery();
            boolean found = false;
            while (resultSet.next()) {
                int idSoutenance = resultSet.getInt("id_soutenance");
                String dateSoutenance = resultSet.getString("date_soutenance");
                String heureSoutenance = resultSet.getString("heure_soutenance");
                String validee = resultSet.getString("validee");
                Vector<Object> row = new Vector<>();
                row.add(idSoutenance);
                row.add(dateSoutenance);
                row.add(heureSoutenance);
                row.add(validee);
                tableModelParHeure.addRow(row);
                found = true;
            }
            if (!found) {
                JOptionPane.showMessageDialog(frame, "Aucune soutenance n'a été trouvée pour l'heure spécifiée.", "Aucun résultat", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'exécution de la requête : " + ex.getMessage());
        }
    }
}
