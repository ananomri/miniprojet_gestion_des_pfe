

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;

public class espace_adminv2 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					espace_adminv2 window = new espace_adminv2();
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
	public espace_adminv2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134324.png"));
		frame.setBounds(100, 100, 1257, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(72, 119, 183));
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(72, 119, 183));
		panel_5.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(72, 119, 183));
		panel_5.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(250, 250));
		panel_4.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(255, 165, 0), 5, true));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("PFE");
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(182, 68, 77, 21);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Users-Student-icon (1).png"));
		lblNewLabel_4.setBounds(7, 10, 197, 143);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gestion des PFE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(new Color(128, 128, 128));
		lblNewLabel_5.setBounds(30, 146, 142, 26);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PFE p=new PFE();
				p.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(20, 177, 100, 26);
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 250));
		panel_4.add(panel);
		panel.setBorder(new LineBorder(new Color(255, 165, 0), 5, true));
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Science-Classroom-icon (1).png"));
		lblNewLabel_8.setBounds(10, 23, 141, 135);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Gestion des  Enseignant");
		lblNewLabel_7.setForeground(new Color(105, 105, 105));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(30, 156, 156, 27);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Enseignant");
		lblNewLabel_6.setForeground(new Color(255, 165, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(141, 47, 125, 36);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Click Here");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignant logens=new enseignant();
				logens.Secondframee.setVisible(true);
				frame.dispose();
				}
		});
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(22, 187, 103, 27);
		panel.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(250, 250));
		panel_4.add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(255, 165, 0), 5, true));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Etudiant\r\n");
		lblNewLabel_9.setForeground(new Color(255, 165, 0));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(137, 36, 104, 41);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Anen\\Desktop\\image\\Students-icon.png"));
		lblNewLabel_10.setBounds(0, 24, 142, 100);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Gestion des Etudiant");
		lblNewLabel_11.setForeground(new Color(105, 105, 105));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(10, 134, 132, 25);
		panel_2.add(lblNewLabel_11);
		
		JButton btnNewButton_2 = new JButton("Click Here");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiant m=new etudiant();
				m.thirdframe.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(20, 178, 94, 25);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_5.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152839.png"));
		
	}
}
