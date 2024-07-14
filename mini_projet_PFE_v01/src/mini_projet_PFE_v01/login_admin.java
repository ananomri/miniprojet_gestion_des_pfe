

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;

public class login_admin {

    JFrame firstframe;
	private JTextField t2;
	private JPasswordField pw2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_admin window = new login_admin();
					window.firstframe.pack();
					window.firstframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() {
		firstframe = new JFrame();
		firstframe.getContentPane().setBackground(new Color(72, 119, 183));
		firstframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Users-Administrator-icon.png"));
		firstframe.setBounds(100, 100, 683, 598);
		firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel.setBounds(10, 23, 613, 40);
		firstframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
		lblNewLabel_1.setBounds(473, 252, 193, 164);
		firstframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Users-Administrator-icon (1).png"));
		lblNewLabel_2.setBounds(213, 73, 187, 118);
		firstframe.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 224, 347, 26);
		firstframe.getContentPane().add(lblNewLabel_3);
		
		t2 = new JTextField();
		t2.setOpaque(false);
		t2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t2.setBackground(new Color(0, 0, 255));
		t2.setBounds(10, 260, 426, 34);
		firstframe.getContentPane().add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setForeground(new Color(255, 165, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 304, 426, 26);
		firstframe.getContentPane().add(lblNewLabel_4);
		
		pw2 = new JPasswordField();
		pw2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		pw2.setOpaque(false);
		pw2.setBackground(new Color(0, 0, 255));
		pw2.setBounds(10, 351, 426, 34);
		firstframe.getContentPane().add(pw2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = t2.getText(); 
		        String password = new String(pw2.getPassword());
		        Connection conn = null;
		        try {
		            conn = sqlconnect.conn();
		            if (conn != null) {
		                String sql = "SELECT * FROM admin WHERE mail = ? AND pw = ?";
		                PreparedStatement statement = conn.prepareStatement(sql);
		                statement.setString(1, email);
		                statement.setString(2, password);

		                ResultSet result = statement.executeQuery();
		                if (result.next()) {
		                    espace_adminv2 m = new espace_adminv2();
		                    m.frame.setVisible(true);
		                    firstframe.dispose();
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
			
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 424, 426, 34);
		firstframe.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nouveau admin");
		btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscription_admin isnadmin=new inscription_admin();
				isnadmin.adminframe.setVisible(true);
				firstframe.dispose();
			}
		});
		btnNewButton_1.setBounds(400, 490, 223, 21);
		firstframe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main();
				m.frame.setVisible(true);
				firstframe.dispose();
			}
		});
		btnNewButton_2.setBounds(24, 521, 85, 26);
		firstframe.getContentPane().add(btnNewButton_2);
	}

}
