package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classesPojo.*;


public class connexionouregister extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	Personne p=new Personne();
	Client c=new Client();
	private JTextField txtnom;
	private JTextField txtpreenr;
	private JTextField txtaddr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexionouregister frame = new connexionouregister();
					frame.setVisible(true);
					/*Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
					int longueur = tailleMoniteur.width * 2/3;
					int hauteur = tailleMoniteur.height * 2/3;
					//régler la taille de JFrame à 2/3 la taille de l'écran
					frame.setSize(longueur, hauteur);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fermer() {
		this.setVisible(false);
	}
	

	/**
	 * Create the frame.
	 */
	public connexionouregister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.ORANGE);
		tabbedPane.setBounds(10, -31, 515, 304);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		tabbedPane.addTab("tab2", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		tabbedPane.addTab("tab1", null, panel, null);
		panel.setLayout(null);
		
		
		JLabel lblt2 = new JLabel("Salle Bosquet Wallon");
		lblt2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblt2.setBounds(140, 11, 165, 34);
		panel_1.add(lblt2);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Utilisateur:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(78, 77, 97, 17);
		panel_1.add(lblNewLabel_1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textField1.setBounds(200, 74, 150, 25);
		panel_1.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel_2= new JLabel("Mot de passe :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(78, 130, 105, 17);
		panel_1.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 125, 150, 25);
		panel_1.add(passwordField);
		
		JButton btnconnecter = new JButton("Se connecter");
		btnconnecter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					p.login(textField1.getText(), passwordField.getText());
					fermer();//fermer cette fenetre avec methode en haut
				}
				catch(Exception ex) {				
					textField1.setText(null);
					passwordField.setText(null);
				}
				
			}
		});
		btnconnecter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnconnecter.setBounds(58, 182, 134, 25);
		panel_1.add(btnconnecter);
		
	
		JButton btnsenregistrer2_1 = new JButton("S'enregistrer");
		btnsenregistrer2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnsenregistrer2_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnsenregistrer2_1.setBounds(252, 182, 133, 25);
		panel_1.add(btnsenregistrer2_1);
		
		JButton bntquitter = new JButton("Quitter");
		bntquitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bntquitter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bntquitter.setBounds(366, 11, 89, 23);
		panel_1.add(bntquitter);
		
		
		JLabel lblt;
		lblt = new JLabel("Salle Bosquet Wallon");
		lblt.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblt.setBounds(132, 11, 174, 44);
		panel.add(lblt);
		
		JLabel lblNewLabel_4;
		lblNewLabel_4 = new JLabel("Nom Utilisateur  :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(20, 52, 119, 33);
		panel.add(lblNewLabel_4);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textField2.setBounds(138, 59, 168, 20);
		panel.add(textField2);
		textField2.setColumns(10);
		
		JLabel lblNewLabel_3;
		lblNewLabel_3 = new JLabel("Mot de passe :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_3.setBounds(20, 96, 106, 14);
		panel.add(lblNewLabel_3);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(138, 95, 168, 20);
		panel.add(passwordField2);
		
	
		JButton btnsenregistrer1;
		btnsenregistrer1 = new JButton("S'enregistrer");
		btnsenregistrer1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					c.register(textField2.getText(),txtnom.getText(), txtpreenr.getText(),txtaddr.getText(),passwordField2.getText());
					connexionouregister conec=new connexionouregister();
					conec.setVisible(true);
				}
				catch(Exception ex) {
					textField2.setText(null);
					passwordField2.setText(null);
					txtnom.setText(null);
					txtpreenr.setText(null);
					txtaddr.setText(null);
				}
			}
		});
		btnsenregistrer1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnsenregistrer1.setBounds(315, 242, 133, 23);
		panel.add(btnsenregistrer1);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel.setBounds(20, 131, 75, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Prenom :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_5.setBounds(20, 167, 75, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("adresse :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_6.setBounds(20, 204, 77, 14);
		panel.add(lblNewLabel_6);
		
		txtnom = new JTextField();
		txtnom.setBounds(138, 126, 168, 20);
		panel.add(txtnom);
		txtnom.setColumns(10);
		
		txtpreenr = new JTextField();
		txtpreenr.setBounds(138, 166, 168, 20);
		panel.add(txtpreenr);
		txtpreenr.setColumns(10);
		
		txtaddr = new JTextField();
		txtaddr.setBounds(138, 203, 168, 20);
		panel.add(txtaddr);
		txtaddr.setColumns(10);
		
		JButton btnretourconn = new JButton("pr\u00E9c\u00E9dent");
		btnretourconn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnretourconn.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnretourconn.setBounds(0, 11, 96, 23);
		panel.add(btnretourconn);
		
		JButton btnquitenr = new JButton("Quitter");
		btnquitenr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnquitenr.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnquitenr.setBounds(369, 11, 89, 23);
		panel.add(btnquitenr);
	}
}
