

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class login_enseignant {

    JFrame Secondframe;
	private JTextField t1;
	private JPasswordField pw1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_enseignant window = new login_enseignant();
					window.Secondframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_enseignant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Secondframe = new JFrame();
		Secondframe.getContentPane().setBackground(new Color(72, 119, 183));
		Secondframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
		Secondframe.setBounds(100, 100, 635, 704);
		Secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Secondframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel.setBounds(10, 28, 615, 40);
		Secondframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
		lblNewLabel_1.setBounds(194, 93, 163, 135);
		Secondframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(255, 165, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 262, 433, 25);
		Secondframe.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setOpaque(false);
		t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t1.setBackground(new Color(0, 0, 255));
		t1.setBounds(10, 297, 310, 33);
		Secondframe.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de passe");
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 353, 408, 25);
		Secondframe.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = t1.getText(); 
		        String password = new String(pw1.getPassword());
		        Connection conn = null;
		        try {
		            conn = sqlconnect.conn();
		            if (conn != null) {
		                String sql = "SELECT * FROM ENSEIGNANT WHERE mail = ? AND pw = ?";
		                PreparedStatement statement = conn.prepareStatement(sql);
		                statement.setString(1, email);
		                statement.setString(2, password);

		                ResultSet result = statement.executeQuery();
		                if (result.next()) {
		                    espaceenseignant m = new espaceenseignant();
		                    m.frame2.setVisible(true);
		                    Secondframe.dispose();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        } finally {
		            try {
		                if (conn != null) {
		                    conn.close();
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 466, 310, 33);
		Secondframe.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("S'inscrire");
		btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscription_enseignant insens = null;
				try {
					insens = new inscription_enseignant();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				insens.inscriptionframe.setVisible(true);
				Secondframe.dispose();
			}
		});
		btnNewButton_1.setBounds(298, 530, 145, 21);
		Secondframe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main();
				m.frame.setVisible(true);
				Secondframe.dispose();
			}
		});
		btnNewButton_2.setBounds(10, 567, 100, 21);
		Secondframe.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
		lblNewLabel_4.setBounds(369, 316, 201, 166);
		Secondframe.getContentPane().add(lblNewLabel_4);
		
		pw1 = new JPasswordField();
		pw1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		pw1.setOpaque(false);
		pw1.setBackground(new Color(0, 0, 255));
		pw1.setBounds(10, 388, 310, 33);
		Secondframe.getContentPane().add(pw1);
	}
}
