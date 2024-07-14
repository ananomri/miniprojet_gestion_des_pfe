
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class login_etudiant {

	JFrame thirdframe;
	private JTextField t1;
	private JPasswordField pw1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_etudiant window = new login_etudiant();
					window.thirdframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_etudiant() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		thirdframe = new JFrame();
		thirdframe.getContentPane().setBackground(new Color(72, 119, 183));
		thirdframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Desktop\\image\\Capture d'écran 2024-03-22 115107.png"));
		thirdframe.setBounds(100, 100, 629, 561);
		thirdframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thirdframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("email");
		lblNewLabel.setBounds(28, 244, 68, 34);
		lblNewLabel.setForeground(new Color(238, 148, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		thirdframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setBounds(28, 322, 214, 34);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setForeground(new Color(238, 148, 30));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		thirdframe.getContentPane().add(lblNewLabel_1);
		
		t1 = new JTextField();
		t1.setOpaque(false);
		t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		t1.setBounds(28, 269, 305, 49);
		t1.setBackground(Color.BLUE);
		thirdframe.getContentPane().add(t1);
		t1.setColumns(10);
		
		pw1 = new JPasswordField();
		pw1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		pw1.setOpaque(false);
		pw1.setBounds(28, 343, 305, 42);
		pw1.setBackground(Color.BLUE);
		thirdframe.getContentPane().add(pw1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String email = t1.getText(); 
		        String password = new String(pw1.getPassword());
		        Connection conn = null;
		        try {
		            conn = sqlconnect.conn();
		            if (conn != null) {
		                String sql = "SELECT * FROM etudiant WHERE mail = ? AND pw = ?";
		                PreparedStatement statement = conn.prepareStatement(sql);
		                statement.setString(1, email);
		                statement.setString(2, password);

		                ResultSet result = statement.executeQuery();
		                if (result.next()) {
		                	espaceetudiant m = new espaceetudiant();
		                    m.frame1.setVisible(true);
		                    thirdframe.dispose();
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


		btnNewButton.setBounds(28, 395, 305, 34);
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		thirdframe.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("S'inscrire");
		btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBounds(289, 445, 119, 21);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscrire_etudiant inscetud = null;
				try {
					inscetud = new inscrire_etudiant();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				inscetud.inscrireframe.setVisible(true);
				thirdframe.dispose();
			}
		});
		thirdframe.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main();
				m.frame.setVisible(true);
				thirdframe.dispose();
			}
		});
		btnNewButton_2.setBounds(28, 480, 85, 34);
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setForeground(Color.WHITE);
		thirdframe.getContentPane().add(btnNewButton_2);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(108, 78, 134, 97);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Desktop\\image\\Students-icon.png"));
		thirdframe.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 26, 617, 42);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		thirdframe.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
		lblNewLabel_4.setBounds(384, 239, 191, 178);
		thirdframe.getContentPane().add(lblNewLabel_4);
	}
}
