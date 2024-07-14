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

public class supprimer_enseignant {

	public JFrame frames;
	/*private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;*/
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
					supprimer_enseignant window = new supprimer_enseignant();
					window.frames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public supprimer_enseignant() {
		initialize();
	}

	
	private void initialize() {
		frames = new JFrame();
		frames.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
		frames.getContentPane().setBackground(new Color(72, 119, 183));
		frames.setBounds(100, 100, 972, 704);
		frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frames.getContentPane().setLayout(null);
		frames.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("supprimer enseignant");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 67));
		lblNewLabel.setBounds(124, 156, 699, 109);
		frames.getContentPane().add(lblNewLabel);
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
		
		/*JLabel lblNewLabel_1 = new JLabel("cin");
		lblNewLabel_1.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 276, 45, 13);
		frames.getContentPane().add(lblNewLabel_1);
		t0 = new JTextField();
		t0.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    System.out.println("----------");
			  }
			  public void removeUpdate(DocumentEvent e) {
				  System.out.println(t0.getText());
			  }
			  public void insertUpdate(DocumentEvent e) {
			    System.out.println(t0.getText());
			  }
		});
		t0.setBounds(63, 275, 96, 19);
		frames.getContentPane().add(t0);
		t0.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("nom");
		lblNewLabel_2.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(210, 276, 45, 13);
		frames.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(265, 276, 96, 19);
		frames.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("prenom");
		lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(387, 267, 76, 30);
		frames.getContentPane().add(lblNewLabel_3);
		
		t2 = new JTextField();
		t2.setBounds(473, 276, 96, 19);
		frames.getContentPane().add(t2);
		t2.setColumns(10);
		
		JLabel ttextfield3 = new JLabel("mail");
		ttextfield3.setForeground(SystemColor.activeCaptionBorder);
		ttextfield3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ttextfield3.setBounds(608, 276, 81, 25);
		frames.getContentPane().add(ttextfield3);
		
		t3 = new JTextField();
		t3.setBounds(669, 276, 111, 19);
		frames.getContentPane().add(t3);
		t3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("departement");
		lblNewLabel_4.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(844, 275, 111, 19);
		frames.getContentPane().add(lblNewLabel_4);
		
		t4 = new JTextField();
		t4.setBounds(965, 276, 96, 19);
		frames.getContentPane().add(t4);
		t4.setColumns(10);
		*/
		JButton supprime = new JButton("supprimer");
		supprime.setOpaque(false);
		supprime.setFont(new Font("Tahoma", Font.BOLD, 18));
		supprime.setBounds(803, 461, 134, 41);
		supprime.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		supprime.setBackground(new Color(255, 165, 0));
		supprime.setForeground(new Color(0, 0, 255));
		supprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { 
                    String enseignantId = tableModel.getValueAt(selectedRow, 0).toString(); // ID de l'enseignant sélectionné
                    deleteEnseignant(enseignantId);
                } else {
                    JOptionPane.showMessageDialog(frames, "Veuillez sélectionner un enseignant à supprimer.");
                }}
				});
        frames.getContentPane().add(searchField);
        frames.getContentPane().add(scrollPane);
        frames.getContentPane().add(supprime);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_1.setBounds(-211, 0, 552, 169);
        frames.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_2.setBounds(343, 37, 615, 83);
        frames.getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
        lblNewLabel_3.setBounds(360, 239, 180, 147);
        frames.getContentPane().add(lblNewLabel_3);
        
        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            		enseignant isnadmin = new enseignant();
                    isnadmin.Secondframee.setVisible(true);
                    frames.dispose();
            	}
        	
        });
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.setBounds(811, 555, 126, 21);
        frames.getContentPane().add(btnNewButton_1);

        frames.setVisible(true);
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
            JOptionPane.showMessageDialog(frames, "Erreur lors de la recherche dans la base de données");
        }
    }

    private void deleteEnseignant(String enseignantId) {
        try (Connection conn = sqlconnect.conn()) {
            String sql = "DELETE FROM enseignant WHERE cin = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(enseignantId));
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(frames, "Enseignant supprimé avec succès.");
                performSearch(); 
            } else {
                JOptionPane.showMessageDialog(frames, "Échec de la suppression de l'enseignant.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frames, "Erreur lors de la suppression de l'enseignant");
        }

		supprime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		supprime.setBounds(316, 364, 168, 21);
		frames.getContentPane().add(supprime);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
		lblNewLabel_5.setBounds(-29, 0, 513, 144);
		frames.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel_6.setBounds(483, 23, 632, 100);
		frames.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignant isnadmin=new enseignant();
				isnadmin.Secondframee.setVisible(true);
				frames.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(513, 368, 85, 21);
		frames.getContentPane().add(btnNewButton);
	}
}