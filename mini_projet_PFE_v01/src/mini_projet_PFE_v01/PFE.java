import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class PFE {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PFE window = new PFE();
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
	public PFE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(72, 119, 183));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Users-Student-2-icon.png"));
		frame.setBounds(100, 100, 1634, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des PFE");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 68));
		lblNewLabel.setBounds(377, 35, 525, 74);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel.setBounds(342, 205, 220, 202);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("click here");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nouveau_encadrement m=new nouveau_encadrement();
				m.frameEncadrement.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(58, 158, 112, 21);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Nouveau encadrement");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(28, 10, 182, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Affiliate-icon (1).png"));
		lblNewLabel_4.setBounds(44, 43, 128, 84);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_1.setBounds(670, 205, 220, 202);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("click here");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nv_jury m=new nv_jury();
				m.framej.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(65, 158, 109, 21);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(84, 105, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Nouveau jury");
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(53, 0, 126, 31);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Law-icon.png"));
		lblNewLabel_7.setBounds(22, 25, 152, 128);
		panel_1.add(lblNewLabel_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_2.setBounds(1007, 205, 220, 202);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Users-Student-2-icon.png"));
		lblNewLabel_9.setBounds(51, 28, 125, 128);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Nouvelle soutenance");
		lblNewLabel_8.setBounds(41, 10, 141, 19);
		lblNewLabel_8.setForeground(new Color(0, 0, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_8);
		
		JButton btnNewButton_3 = new JButton("click here");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nouvelle_soutenance m=new nouvelle_soutenance();
				m.frames.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(255, 165, 0));
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setBounds(71, 166, 105, 21);
		panel_2.add(btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_3.setBounds(22, 205, 220, 202);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nouveau PFE");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 10, 149, 19);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Users-Student-icon (3).png"));
		lblNewLabel_2.setBounds(39, 39, 128, 99);
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("click here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nouvelle_pfe m=new nouvelle_pfe();
				m.framepfe.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(49, 157, 101, 21);
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(255, 165, 0), 2, true));
		panel_4.setBounds(1317, 205, 223, 202);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("affichage");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setForeground(new Color(0, 0, 255));
		lblNewLabel_10.setBounds(72, 10, 98, 13);
		panel_4.add(lblNewLabel_10);
		
		JButton btnNewButton_4 = new JButton("click here");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageepfee m=new affichageepfee();
				m.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_4.setBackground(new Color(255, 165, 0));
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(72, 171, 98, 21);
		panel_4.add(btnNewButton_4);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\select-window-icon (1).png"));
		lblNewLabel_13.setBounds(40, 33, 155, 112);
		panel_4.add(lblNewLabel_13);
		
		JButton btnNewButton_5 = new JButton("back");
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espace_adminv2 m=new espace_adminv2();
				m.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_5.setBackground(new Color(255, 165, 0));
		btnNewButton_5.setForeground(new Color(0, 0, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setBounds(1333, 133, 85, 21);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
		lblNewLabel_11.setBounds(-180, 0, 585, 126);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		lblNewLabel_12.setBounds(912, 10, 628, 88);
		frame.getContentPane().add(lblNewLabel_12);
	}

}
