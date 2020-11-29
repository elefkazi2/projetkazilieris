package Frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txtnom;
	private JTextField txtpreenr;
	private JTextField txtaddr;
	Personne p=new Personne();
	Client c=new Client();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexionouregister frame = new connexionouregister();
					frame.setVisible(true);
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
		setBounds(100, 100, 681, 319);
		setTitle("SalleBosquetWallon/");
		setSize(900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.ORANGE);
		tabbedPane.setBounds(0, 0, 884, 761);
		contentPane.add(tabbedPane);
		
		JPanel panelconn = new JPanel();
		panelconn.setBackground(new Color(255, 200, 0));
		tabbedPane.addTab("Se connecter", null, panelconn, null);
		panelconn.setLayout(null);
		
		JPanel panelenr = new JPanel();
		panelenr.setBackground(Color.ORANGE);
		tabbedPane.addTab("S'enregistrer", null, panelenr, null);
		panelenr.setLayout(null);
		
		
		JLabel lblt;
		lblt = new JLabel("Salle Bosquet Wallon");
		lblt.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblt.setBounds(291, 65, 271, 58);
		panelenr.add(lblt);
		
		JLabel lblNewLabel_4;
		lblNewLabel_4 = new JLabel("Nom Utilisateur  :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_4.setBounds(46, 178, 174, 33);
		panelenr.add(lblNewLabel_4);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textField2.setBounds(214, 181, 278, 33);
		panelenr.add(textField2);
		textField2.setColumns(10);
		
		JLabel lblNewLabel_3;
		lblNewLabel_3 = new JLabel("Mot de passe :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_3.setBounds(46, 237, 140, 33);
		panelenr.add(lblNewLabel_3);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(214, 241, 278, 33);
		panelenr.add(passwordField2);

		JButton btnsenregistrer1;
		btnsenregistrer1 = new JButton("S'enregistrer");
		btnsenregistrer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField2.getText().isEmpty() | txtnom.getText().isEmpty() | txtpreenr.getText().isEmpty() | txtaddr.getText().isEmpty() | passwordField2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Veillez à remplir tous les champs");
					}
					else {	
						c.register(textField2.getText(),txtnom.getText(), txtpreenr.getText(),txtaddr.getText(),passwordField2.getText());
						connexionouregister conec=new connexionouregister();
						conec.setVisible(true);
						JOptionPane.showMessageDialog(null, "Votre enregistrement a bien été effectué");						
					}
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
		btnsenregistrer1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnsenregistrer1.setBounds(592, 501, 167, 44);
		panelenr.add(btnsenregistrer1);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(46, 302, 75, 20);
		panelenr.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Prenom :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_5.setBounds(46, 359, 106, 33);
		panelenr.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("adresse :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_6.setBounds(46, 417, 119, 33);
		panelenr.add(lblNewLabel_6);
		
		txtnom = new JTextField();
		txtnom.setBounds(214, 300, 278, 33);
		panelenr.add(txtnom);
		txtnom.setColumns(10);
		
		txtpreenr = new JTextField();
		txtpreenr.setBounds(214, 363, 278, 33);
		panelenr.add(txtpreenr);
		txtpreenr.setColumns(10);
		
		txtaddr = new JTextField();
		txtaddr.setBounds(214, 421, 278, 33);
		panelenr.add(txtaddr);
		txtaddr.setColumns(10);
		
		JButton btnquitenr = new JButton("Quitter");
		btnquitenr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnquitenr.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnquitenr.setBounds(750, 11, 119, 44);
		panelenr.add(btnquitenr);
				
		JLabel lblt2 = new JLabel("Salle Bosquet Wallon");
		lblt2.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblt2.setBounds(310, 85, 263, 46);
		panelconn.add(lblt2);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Utilisateur:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(191, 213, 154, 34);
		panelconn.add(lblNewLabel_1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textField1.setBounds(412, 216, 245, 34);
		panelconn.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel_2= new JLabel("Mot de passe :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(191, 311, 154, 34);
		panelconn.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(412, 316, 245, 33);
		panelconn.add(passwordField);
		
		JButton btnconnecter = new JButton("Se connecter");
		btnconnecter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String n=p.login(textField1.getText(),passwordField.getText()).get(1);
					String b=p.login(textField1.getText(),passwordField.getText()).get(0);
					
					
					switch(b) {
					case "client" :
						client c=new client(textField1.getText(),n);
						c.setVisible(true);
						fermer();//fermer cette fenetre avec methode en haut
						break;
					case "gestionnaire":
						gestionnaire g=new gestionnaire(textField1.getText(),n);
						g.setVisible(true);
						fermer();
						break;
					case "organisateur":
						organisateur o=new organisateur(textField1.getText(),n);
						o.setVisible(true);
						fermer();
						break;
					}					
				}
				catch(Exception ex) {				
					textField1.setText(null);
					passwordField.setText(null);
				}
			}
		});
		btnconnecter.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnconnecter.setBounds(352, 422, 180, 34);
		panelconn.add(btnconnecter);
		
		JButton bntquitter = new JButton("Quitter");
		bntquitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bntquitter.setFont(new Font("Tahoma", Font.ITALIC, 20));
		bntquitter.setBounds(732, 11, 137, 46);
		panelconn.add(bntquitter);
		
		JLabel lblNewLabel_7 = new JLabel("Si vous n'\u00EAtes pas encore enregistr\u00E9,allez dans l'onglet s'enregistrer qui se trouve en haut \u00E0 gauche.");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_7.setBounds(57, 469, 822, 86);
		panelconn.add(lblNewLabel_7);
	}
}
