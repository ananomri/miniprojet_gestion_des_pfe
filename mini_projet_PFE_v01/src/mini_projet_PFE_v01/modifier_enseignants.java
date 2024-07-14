import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class modifier_enseignants {

    public JFrame frame;
    private JTextField t0;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    modifier_enseignants window = new modifier_enseignants();
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
    public modifier_enseignants() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(72, 119, 183));
        frame.setBounds(100, 100, 1138, 446);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("modifier enseignant");
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(72, 199, 794, 50);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("cin");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 312, 45, 25);
        frame.getContentPane().add(lblNewLabel_1);

        t0 = new JTextField();
        t0.setBounds(57, 317, 96, 19);
        frame.getContentPane().add(t0);
        t0.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("nom");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(212, 315, 45, 19);
        frame.getContentPane().add(lblNewLabel_2);

        t1 = new JTextField();
        t1.setBounds(250, 317, 96, 19);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("prenom");
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(409, 312, 88, 25);
        frame.getContentPane().add(lblNewLabel_3);

        t2 = new JTextField();
        t2.setBounds(492, 317, 96, 19);
        frame.getContentPane().add(t2);
        t2.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("mail");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(679, 316, 61, 17);
        frame.getContentPane().add(lblNewLabel_4);

        t3 = new JTextField();
        t3.setBounds(721, 317, 96, 19);
        frame.getContentPane().add(t3);
        t3.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("departement");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(893, 312, 115, 25);
        frame.getContentPane().add(lblNewLabel_5);

        t4 = new JTextField();
        t4.setBounds(1001, 317, 96, 19);
        frame.getContentPane().add(t4);
        t4.setColumns(10);

        JButton modifier = new JButton("modifier");
        modifier.setOpaque(false);
        modifier.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        modifier.setBackground(new Color(255, 165, 0));
        modifier.setForeground(new Color(0, 0, 255));
        modifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cin = t0.getText();
                String nom = t1.getText();
                String prenom = t2.getText();
                String mail = t3.getText();
                String dept = t4.getText();
                
                if (!cin.isEmpty()) {
                    Connection connection = sqlconnect.conn();
                    if (connection != null) {
                        try {
                            String sqlSelect = "SELECT * FROM enseignant WHERE CIN = ?";
                            PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
                            selectStatement.setString(1, cin);
                            ResultSet resultSet = selectStatement.executeQuery();
                            
                            if (resultSet.next()) {
                                String existingNom = resultSet.getString("NOM");
                                String existingPrenom = resultSet.getString("PRENOM");
                                String existingMail = resultSet.getString("MAIL");
                                String existingDept = resultSet.getString("DEPT");
                                
                                if (!nom.isEmpty()) {
                                    existingNom = nom;
                                }
                                if (!prenom.isEmpty()) {
                                    existingPrenom = prenom;
                                }
                                if (!mail.isEmpty()) {
                                    existingMail = mail;
                                }
                                if (!dept.isEmpty()) {
                                    existingDept = dept;
                                }
                                
                                String sqlUpdate = "UPDATE enseignant SET NOM = ?, PRENOM = ?, MAIL = ?, DEPT = ? WHERE CIN = ?";
                                PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
                                updateStatement.setString(1, existingNom);
                                updateStatement.setString(2, existingPrenom);
                                updateStatement.setString(3, existingMail);
                                updateStatement.setString(4, existingDept);
                                updateStatement.setString(5, cin);
                                
                                int rowsAffected = updateStatement.executeUpdate();
                                if (rowsAffected > 0) {
                                    JOptionPane.showMessageDialog(null, "l'enseignant a été modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Aucun enseignat trouvé avec le CIN spécifié", "Erreur", JOptionPane.ERROR_MESSAGE);
                                }
                                
                                updateStatement.close();
                            } else {
                                JOptionPane.showMessageDialog(null, "Aucun enseignat trouvé avec le CIN spécifié", "Erreur", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "Veuillez saisir le CIN de l'enseignant à modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        modifier.setFont(new Font("Tahoma", Font.PLAIN, 20));
        modifier.setBounds(386, 356, 122, 43);
        frame.getContentPane().add(modifier);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_6.setBounds(-42, 10, 620, 164);
        frame.getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_7.setBounds(508, 52, 616, 69);
        frame.getContentPane().add(lblNewLabel_7);
        
        JButton btnNewButton = new JButton("back");
        btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        btnNewButton.setOpaque(false);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setForeground(new Color(0, 0, 255));
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		enseignant isnadmin=new enseignant();
				isnadmin.Secondframee.setVisible(true);
				frame.dispose();
        	}
        });
        btnNewButton.setBounds(547, 371, 85, 28);
        frame.getContentPane().add(btnNewButton);
    }
}
