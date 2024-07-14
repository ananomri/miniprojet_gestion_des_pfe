import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class afficher_etudiant {

    public JFrame frame1;
    private JComboBox<String> comboBoxNom;
    private JComboBox<String> comboBoxPrenom;
    private JComboBox<String> comboBoxMail;
    private JComboBox<String> comboBoxCin;
    private JComboBox<String> comboBoxSpecialite;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                afficher_etudiant window = new afficher_etudiant();
                window.frame1.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public afficher_etudiant() {
        initialize();
    }

    private void initialize() {
        frame1 = new JFrame();
        frame1.getContentPane().setBackground(new Color(72, 119, 183));
        frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Anen\\Desktop\\image\\Capture d'écran 2024-03-22 115107.png"));
        frame1.setBounds(100, 100, 1030, 411);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Afficher Etudiant");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
        lblNewLabel.setBounds(256, 187, 553, 44);
        frame1.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nom");
        lblNewLabel_1.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 266, 63, 23);
        frame1.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("Prénom");
        lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(206, 269, 72, 17);
        frame1.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Mail");
        lblNewLabel_4.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(411, 270, 45, 13);
        frame1.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("CIN");
        lblNewLabel_5.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(594, 271, 45, 13);
        frame1.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Spécialité");
        lblNewLabel_6.setForeground(SystemColor.activeCaptionBorder);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_6.setBounds(779, 268, 103, 16);
        frame1.getContentPane().add(lblNewLabel_6);

        comboBoxNom = new JComboBox<>();
        comboBoxNom.addItem(""); // Ajouter un élément vide comme première option
        comboBoxNom.setBounds(53, 271, 150, 19);
        frame1.getContentPane().add(comboBoxNom);

        comboBoxPrenom = new JComboBox<>();
        comboBoxPrenom.addItem("");
        comboBoxPrenom.setBounds(265, 270, 150, 19);
        frame1.getContentPane().add(comboBoxPrenom);

        comboBoxMail = new JComboBox<>();
        comboBoxMail.addItem("");
        comboBoxMail.setBounds(447, 270, 150, 19);
        frame1.getContentPane().add(comboBoxMail);

        comboBoxCin = new JComboBox<>();
        comboBoxCin.addItem("");
        comboBoxCin.setBounds(628, 270, 150, 19);
        frame1.getContentPane().add(comboBoxCin);

        comboBoxSpecialite = new JComboBox<>();
        comboBoxSpecialite.addItem("");
        comboBoxSpecialite.setBounds(866, 271, 150, 19);
        frame1.getContentPane().add(comboBoxSpecialite);

        JButton afficherButton = new JButton("Afficher");
        afficherButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        afficherButton.setOpaque(false);
        afficherButton.setBackground(new Color(255, 165, 0));
        afficherButton.setForeground(new Color(0, 0, 255));
        afficherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = (String) comboBoxNom.getSelectedItem();
                String prenom = (String) comboBoxPrenom.getSelectedItem();
                String mail = (String) comboBoxMail.getSelectedItem();
                String cin = (String) comboBoxCin.getSelectedItem();
                String specialite = (String) comboBoxSpecialite.getSelectedItem();
                rechercherEtudiant(nom, prenom, mail, cin, specialite);
            }
        });
        afficherButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        afficherButton.setBounds(358, 331, 141, 33);
        frame1.getContentPane().add(afficherButton);

        JButton backButton = new JButton("Retour");
        backButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
        backButton.setOpaque(false);
        backButton.setForeground(new Color(0, 0, 255));
        backButton.setBackground(new Color(255, 165, 0));
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etudiant isnadmin = new etudiant();
                isnadmin.thirdframe.setVisible(true);
                frame1.dispose();
            }
        });
        backButton.setBounds(566, 339, 85, 21);
        frame1.getContentPane().add(backButton);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 152754.png"));
        lblNewLabel_2.setBounds(-170, 0, 553, 151);
        frame1.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Anen\\Downloads\\Capture d'écran 2024-03-24 134208.png"));
        lblNewLabel_7.setBounds(383, 10, 623, 78);
        frame1.getContentPane().add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Anen\\Desktop\\image\\Students-icon.png"));
        lblNewLabel_8.setBounds(462, 78, 145, 116);
        frame1.getContentPane().add(lblNewLabel_8);

        populateComboBoxes();
    }

    private void populateComboBoxes() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = sqlconnect.conn();
            if (conn != null) {
                String sql = "SELECT NOM, PRENOM, MAIL, CIN, SPCT FROM etudiant";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    comboBoxNom.addItem(rs.getString("NOM"));
                    comboBoxPrenom.addItem(rs.getString("PRENOM"));
                    comboBoxMail.addItem(rs.getString("MAIL"));
                    comboBoxCin.addItem(rs.getString("CIN"));
                    comboBoxSpecialite.addItem(rs.getString("SPCT"));
                }
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

    private void rechercherEtudiant(String nom, String prenom, String mail, String cin, String specialite) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = sqlconnect.conn();
            StringBuilder sqlBuilder = new StringBuilder("SELECT NOM, PRENOM, MAIL, CIN, SPCT FROM etudiant WHERE 1=1");
            if (!nom.isEmpty()) {
                sqlBuilder.append(" AND NOM = ?");
            }
            if (!prenom.isEmpty()) {
                sqlBuilder.append(" AND PRENOM = ?");
            }
            if (!mail.isEmpty()) {
                sqlBuilder.append(" AND MAIL = ?");
            }
            if (!cin.isEmpty()) {
                sqlBuilder.append(" AND CIN = ?");
            }
            if (!specialite.isEmpty()) {
                sqlBuilder.append(" AND SPCT = ?");
            }

            pstmt = conn.prepareStatement(sqlBuilder.toString());

            int paramIndex = 1;
            if (!nom.isEmpty()) {
                pstmt.setString(paramIndex++, nom);
            }
            if (!prenom.isEmpty()) {
                pstmt.setString(paramIndex++, prenom);
            }
            if (!mail.isEmpty()) {
                pstmt.setString(paramIndex++, mail);
            }
            if (!cin.isEmpty()) {
                pstmt.setString(paramIndex++, cin);
            }
            if (!specialite.isEmpty()) {
                pstmt.setString(paramIndex++, specialite);
            }

            rs = pstmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nom");
            model.addColumn("Prénom");
            model.addColumn("Mail");
            model.addColumn("CIN");
            model.addColumn("Spécialité");

            while (rs.next()) {
                String[] row = {rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("MAIL"), rs.getString("CIN"), rs.getString("SPCT")};
                model.addRow(row);
            }

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(10, 140, 840, 100); 
            frame1.getContentPane().add(scrollPane);

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


