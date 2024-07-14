import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class testtt {
    private JFrame frame;
    private JTextField searchField;
    private JTable table;
    private DefaultTableModel tableModel;

    public testtt() {
        frame = new JFrame("Database Search and Delete Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        searchField = new JTextField(20);
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
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { 
                    String enseignantId = tableModel.getValueAt(selectedRow, 0).toString(); // ID de l'enseignant sélectionné
                    deleteEnseignant(enseignantId);
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un enseignant à supprimer.");
                }
            }
        });

        // Ajout des composants à la fenêtre
        frame.setLayout(new FlowLayout());
        frame.add(searchField);
        frame.add(scrollPane);
        frame.add(deleteButton);

        frame.setVisible(true);
    }

    private void performSearch() {
        String searchText = searchField.getText().trim();
        try (Connection conn = sqlconnect.conn()) {
            String sql = "SELECT cin, nom, prenom FROM enseignant WHERE nom LIKE ? OR prenom LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchText + "%");
            statement.setString(2, "%" + searchText + "%");
            ResultSet resultSet = statement.executeQuery();
            Vector<Vector<Object>> data = new Vector<>();
            Vector<String> columnNames = new Vector<>();
            columnNames.add("cin");
            columnNames.add("Nom");
            columnNames.add("Prénom");

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("cin"));
                row.add(resultSet.getString("nom"));
                row.add(resultSet.getString("prenom"));
                data.add(row);
            }
            tableModel.setDataVector(data, columnNames);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur lors de la recherche dans la base de données");
        }
    }

    private void deleteEnseignant(String enseignantId) {
        // Connexion à la base de données et suppression de l'enseignant
        try (Connection conn = sqlconnect.conn()) {
            String sql = "DELETE FROM enseignant WHERE cin = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(enseignantId));
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(frame, "Enseignant supprimé avec succès.");
                performSearch(); // Rafraîchir le tableau après suppression
            } else {
                JOptionPane.showMessageDialog(frame, "Échec de la suppression de l'enseignant.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur lors de la suppression de l'enseignant");
        }
    }

    public static void main(String[] args) {
        // Assurez-vous de démarrer l'interface graphique depuis le thread de l'EDT
        SwingUtilities.invokeLater(testtt::new);
    }
}
