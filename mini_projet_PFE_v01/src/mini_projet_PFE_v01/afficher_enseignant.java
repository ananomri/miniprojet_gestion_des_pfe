/*import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.border.MatteBorder;

public class afficher_enseignant {

    public JFrame frame;
    private JComboBox<String> comboBoxCIN;
    private JComboBox<String> comboBoxNom;
    private JComboBox<String> comboBoxPrenom;
    private JComboBox<String> comboBoxMail;
    private JComboBox<String> comboBoxDept;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                afficher_enseignant window = new afficher_enseignant();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public afficher_enseignant() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(72, 119, 183));
        frame.setBounds(100, 100, 906, 428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Afficher Enseignant");
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 25));
        lblTitle.setBounds(179, 166, 436, 76);
        frame.getContentPane().add(lblTitle);

        JLabel lblCIN = new JLabel("CIN");
        lblCIN.setForeground(SystemColor.activeCaptionBorder);
        lblCIN.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCIN.setBounds(35, 318, 45, 13);
        frame.getContentPane().add(lblCIN);

        // JComboBox for CIN selection
        comboBoxCIN = new JComboBox<>();
        comboBoxCIN.setBounds(105, 318, 96, 19);
        frame.getContentPane().add(comboBoxCIN);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setForeground(SystemColor.activeCaptionBorder);
        lblNom.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNom.setBounds(236, 318, 45, 13);
        frame.getContentPane().add(lblNom);

        // JComboBox for Nom selection
        comboBoxNom = new JComboBox<>();
        comboBoxNom.setBounds(291, 312, 96, 19);
        frame.getContentPane().add(comboBoxNom);

        JLabel lblPrenom = new JLabel("Prénom");
        lblPrenom.setForeground(SystemColor.activeCaptionBorder);
        lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPrenom.setBounds(397, 305, 83, 27);
        frame.getContentPane().add(lblPrenom);

        // JComboBox for Prenom selection
        comboBoxPrenom = new JComboBox<>();
        comboBoxPrenom.setBounds(471, 312, 96, 19);
        frame.getContentPane().add(comboBoxPrenom);

        JLabel lblMail = new JLabel("Mail");
        lblMail.setForeground(SystemColor.activeCaptionBorder);
        lblMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMail.setBounds(577, 305, 45, 27);
        frame.getContentPane().add(lblMail);

        // JComboBox for Mail selection
        comboBoxMail = new JComboBox<>();
        comboBoxMail.setBounds(624, 312, 96, 19);
        frame.getContentPane().add(comboBoxMail);

        JLabel lblDept = new JLabel("Dept");
        lblDept.setForeground(SystemColor.activeCaptionBorder);
        lblDept.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDept.setBounds(734, 312, 45, 13);
        frame.getContentPane().add(lblDept);

        // JComboBox for Dept selection
        comboBoxDept = new JComboBox<>();
        comboBoxDept.setBounds(786, 305, 96, 19);
        frame.getContentPane().add(comboBoxDept);

        JButton btnAfficher = new JButton("Afficher");
        btnAfficher.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnAfficher.setOpaque(false);
        btnAfficher.setBackground(new Color(255, 165, 0));
        btnAfficher.setForeground(new Color(0, 0, 255));
        btnAfficher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherEnseignants();
            }
        });
        btnAfficher.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAfficher.setBounds(371, 358, 124, 33);
        frame.getContentPane().add(btnAfficher);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel.setBounds(272, 43, 610, 59);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_1.setBounds(-274, -6, 552, 162);
        frame.getContentPane().add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("back");
        btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton.setOpaque(false);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		enseignant isnadmin = new enseignant();
                isnadmin.Secondframee.setVisible(true);
                frame.dispose();
        	}
        });
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.setForeground(new Color(0, 0, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(530, 358, 85, 23);
        frame.getContentPane().add(btnNewButton);

        populateComboBoxes();
    }

    private void populateComboBoxes() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = sqlconnect.conn();

            String sqlCIN = "SELECT CIN FROM enseignant";
            pstmt = conn.prepareStatement(sqlCIN);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                comboBoxCIN.addItem(rs.getString("CIN"));
            }

            String sqlNom = "SELECT DISTINCT Nom FROM enseignant";
            pstmt = conn.prepareStatement(sqlNom);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                comboBoxNom.addItem(rs.getString("Nom"));
            }

            String sqlPrenom = "SELECT DISTINCT Prenom FROM enseignant";
            pstmt = conn.prepareStatement(sqlPrenom);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                comboBoxPrenom.addItem(rs.getString("Prenom"));
            }

            String sqlMail = "SELECT DISTINCT Mail FROM enseignant";
            PreparedStatement preparedStatement = pstmt = conn.prepareStatement(sqlMail);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                comboBoxMail.addItem(rs.getString("Mail"));
            }

            String sqlDept = "SELECT DISTINCT Dept FROM enseignant";
            pstmt = conn.prepareStatement(sqlDept);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                comboBoxDept.addItem(rs.getString("Dept"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void afficherEnseignants() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = sqlconnect.conn(); 

            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM enseignant WHERE 1=1");

            if (comboBoxCIN.getSelectedIndex() != -1) {
                sqlBuilder.append(" AND CIN = ?");
            }
            if (comboBoxNom.getSelectedIndex() != -1) {
                sqlBuilder.append(" AND Nom = ?");
            }
            if (comboBoxPrenom.getSelectedIndex() != -1) {
                sqlBuilder.append(" AND Prenom = ?");
            }
            if (comboBoxMail.getSelectedIndex() != -1) {
                sqlBuilder.append(" AND Mail = ?");
            }
            if (comboBoxDept.getSelectedIndex() != -1) {
                sqlBuilder.append(" AND Dept = ?");
            }

            pstmt = conn.prepareStatement(sqlBuilder.toString());

            int paramIndex = 1;
            if (comboBoxCIN.getSelectedIndex() != -1) {
                pstmt.setString(paramIndex++, (String) comboBoxCIN.getSelectedItem());
            }
            if (comboBoxNom.getSelectedIndex() != -1) {
                pstmt.setString(paramIndex++, (String) comboBoxNom.getSelectedItem());
            }
            if (comboBoxPrenom.getSelectedIndex() != -1) {
                pstmt.setString(paramIndex++, (String) comboBoxPrenom.getSelectedItem());
            }
            if (comboBoxMail.getSelectedIndex() != -1) {
                pstmt.setString(paramIndex++, (String) comboBoxMail.getSelectedItem());
            }
            if (comboBoxDept.getSelectedIndex() != -1) {
                pstmt.setString(paramIndex++, (String) comboBoxDept.getSelectedItem());
            }

            rs = pstmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("CIN");
            model.addColumn("Nom");
            model.addColumn("Prenom");
            model.addColumn("Mail");
            model.addColumn("Dept");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("CIN"),
                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getString("Mail"),
                        rs.getString("Dept")
                });
            }

            JTable table = new JTable(model);
            JOptionPane.showMessageDialog(null, new JScrollPane(table));

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class afficher_enseignant {

	public JFrame frame;
	private JTextField t0;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JButton supprime;
	private JTextField searchField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afficher_enseignant window = new afficher_enseignant();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public afficher_enseignant() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
		frame.getContentPane().setBackground(new Color(72, 119, 183));
		frame.setBounds(100, 100, 972, 704);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Afficher enseignant");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 67));
		lblNewLabel.setBounds(124, 156, 699, 109);
		frame.getContentPane().add(lblNewLabel);
		searchField = new JTextField(20);
		searchField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		searchField.setOpaque(false);
		searchField.setBounds(256, 377, 455, 34);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }
        });
        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(256, 421, 455, 218);
        frame.getContentPane().add(searchField);
        frame.getContentPane().add(scrollPane);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_1.setBounds(-211, 0, 552, 169);
        frame.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_2.setBounds(343, 37, 615, 83);
        frame.getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
        lblNewLabel_3.setBounds(360, 239, 180, 147);
        frame.getContentPane().add(lblNewLabel_3);
        
        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            		enseignant isnadmin = new enseignant();
                    isnadmin.Secondframee.setVisible(true);
                    frame.dispose();
            	}
        	
        });
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.setBounds(811, 555, 126, 21);
        frame.getContentPane().add(btnNewButton_1);

        frame.setVisible(true);
    }

    private void performSearch() {
        String searchText = searchField.getText().trim();
        try (Connection conn = sqlconnect.conn()) {
            String sql = "SELECT cin, nom, prenom, mail, dept FROM enseignant WHERE cin LIKE ? OR nom LIKE ? OR prenom LIKE ? or mail LIKE ? or DEPT LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchText + "%");
            statement.setString(2, "%" + searchText + "%");
            statement.setString(3, "%" + searchText + "%");
            statement.setString(4, "%" + searchText + "%");
            statement.setString(5, "%" + searchText + "%");
            ResultSet resultSet = statement.executeQuery();
            Vector<Vector<Object>> data = new Vector<>();
            Vector<String> columnNames = new Vector<>();
            columnNames.add("cin");
            columnNames.add("Nom");
            columnNames.add("Prénom");
            columnNames.add("mail");
            columnNames.add("departement");
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("cin"));
                row.add(resultSet.getString("nom"));
                row.add(resultSet.getString("prenom"));
                row.add(resultSet.getString("mail"));
                row.add(resultSet.getString("DEPT"));
                data.add(row);
            }
            tableModel.setDataVector(data, columnNames);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur lors de la recherche dans la base de données");
        }
    }

    private void deleteEnseignant(String enseignantId) {
        try (Connection conn = sqlconnect.conn()) {
            String sql = "DELETE FROM enseignant WHERE cin = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(enseignantId));
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(frame, "Enseignant supprimé avec succès.");
                performSearch(); 
            } else {
                JOptionPane.showMessageDialog(frame, "Échec de la suppression de l'enseignant.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur lors de la suppression de l'enseignant");
        }

		supprime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		supprime.setBounds(316, 364, 168, 21);
		frame.getContentPane().add(supprime);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
		lblNewLabel_5.setBounds(-29, 0, 513, 144);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel_6.setBounds(483, 23, 632, 100);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignant isnadmin=new enseignant();
				isnadmin.Secondframee.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(513, 368, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}