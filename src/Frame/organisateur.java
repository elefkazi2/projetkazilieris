package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class organisateur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttitre;
	private JTextField txtart;
	private JTextField txthdebut;
	private JTextField textField;

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
	 * @param nom_ut 
	 * @param n 
	 */
	public organisateur(String nom_ut, String n) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("SalleBosquetWallon/Organisateur/"+n+"/"+nom_ut);
		setSize(900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.ORANGE);
		tabbedPane.setBounds(0, 0, 884, 661);
		contentPane.add(tabbedPane);
		
		Panel panelplasalle = new Panel();
		panelplasalle.setBackground(Color.ORANGE);
		tabbedPane.addTab("Planing salle", null, panelplasalle, null);
		
		Panel panel_reserver = new Panel();
		panel_reserver.setBackground(Color.ORANGE);
		tabbedPane.addTab("R\u00E9server spectacle", null, panel_reserver, null);
		panel_reserver.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fiche signal\u00E9tique du spectacle.");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblNewLabel.setBounds(228, 41, 399, 60);
		panel_reserver.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("titre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_1.setBounds(135, 218, 78, 29);
		panel_reserver.add(lblNewLabel_1);
		
		txttitre = new JTextField();
		txttitre.setBounds(317, 220, 381, 34);
		panel_reserver.add(txttitre);
		txttitre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("artiste(s):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_2.setBounds(135, 308, 119, 39);
		panel_reserver.add(lblNewLabel_2);
		
		txtart = new JTextField();
		txtart.setBounds(317, 315, 381, 34);
		panel_reserver.add(txtart);
		txtart.setColumns(10);
		
		JButton btnenr = new JButton("Enregistrer et continuer");
		btnenr.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnenr.setBounds(135, 444, 249, 23);
		panel_reserver.add(btnenr);
		
		JButton btncont = new JButton("continuer");
		btncont.setFont(new Font("Tahoma", Font.ITALIC, 17));
		btncont.setBounds(449, 443, 249, 23);
		panel_reserver.add(btncont);
		
		JTextPane txtpnSiLeSpectacle = new JTextPane();
		txtpnSiLeSpectacle.setForeground(Color.BLUE);
		txtpnSiLeSpectacle.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnSiLeSpectacle.setText("Si le spectacle est d\u00E9j\u00E0 enregistr\u00E9,tapez son titre et appuyez sur \"continuer\".S'il n'est pas enregistr\u00E9,tapez son titre et le(s) artiste(s) et appuyez sur \"enregistrer et continuer \".");
		txtpnSiLeSpectacle.setBounds(95, 519, 721, 103);
		panel_reserver.add(txtpnSiLeSpectacle);
		
		JLabel lblNewLabel_3_2 = new JLabel("date d\u00E9but:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_3_2.setBounds(29, 115, 126, 42);
		panel_reserver.add(lblNewLabel_3_2);
		
		JDateChooser dcdatedebut = new JDateChooser();
		dcdatedebut.setBounds(155, 122, 197, 35);
		panel_reserver.add(dcdatedebut);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("date fin :");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_3_1_1.setBounds(449, 115, 126, 42);
		panel_reserver.add(lblNewLabel_3_1_1);
		
		JDateChooser dcdatefin = new JDateChooser();
		dcdatefin.setBounds(559, 122, 197, 35);
		panel_reserver.add(dcdatefin);
		
		JPanel panel_res_rep = new JPanel();
		panel_res_rep.setBackground(Color.ORANGE);
		tabbedPane.addTab("R\u00E9server repr\u00E9sentation", null, panel_res_rep, null);
		panel_res_rep.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("date :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_3.setBounds(32, 44, 126, 42);
		panel_res_rep.add(lblNewLabel_3);
		
		JDateChooser dcdateres = new JDateChooser();
		dcdateres.setBounds(168, 51, 197, 35);
		panel_res_rep.add(dcdateres);
		dcdateres.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblNewLabel_4 = new JLabel("heure d\u00E9but:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_4.setBounds(32, 113, 137, 27);
		panel_res_rep.add(lblNewLabel_4);
		
		txthdebut = new JTextField();
		txthdebut.setBounds(168, 113, 197, 27);
		panel_res_rep.add(txthdebut);
		txthdebut.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("heure fin:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_5.setBounds(36, 168, 120, 27);
		panel_res_rep.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(168, 168, 197, 27);
		panel_res_rep.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("configuration :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_6.setBounds(30, 227, 184, 35);
		panel_res_rep.add(lblNewLabel_6);
		
		JComboBox cmbconfig = new JComboBox();
		cmbconfig.setModel(new DefaultComboBoxModel(new String[] {"", "debout", "concert", "cirque"}));
		cmbconfig.setBounds(181, 227, 184, 33);
		panel_res_rep.add(cmbconfig);
		
		JLabel lblconfig = new JLabel("");
		lblconfig.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblconfig.setBounds(393, 227, 197, 29);
		panel_res_rep.add(lblconfig);
		
		JTextPane textPanedeb = new JTextPane();
		textPanedeb.setText("--------------------DEBOUT--------------------\r\n8000 places =>15\u20AC/place\r\n");
		textPanedeb.setFont(new Font("Tahoma", Font.ITALIC, 22));
		textPanedeb.setBounds(32, 280, 427, 62);
		panel_res_rep.add(textPanedeb);
		
		JTextPane txtpanecirque = new JTextPane();
		txtpanecirque.setFont(new Font("Tahoma", Font.ITALIC, 22));
		txtpanecirque.setText("-------------CIRQUE--------------------\r\ndiamant: 1000 places =>60\u20AC/place\r\nor: 2000 places =>50\u20AC/place\r\nargent:1500 places=>35\u20AC/place\r\nbronze: 1500 places=>20\u20AC/place");
		txtpanecirque.setBounds(32, 353, 427, 141);
		panel_res_rep.add(txtpanecirque);
		
		JTextPane txtpaneconcert = new JTextPane();
		txtpaneconcert.setFont(new Font("Tahoma", Font.ITALIC, 22));
		txtpaneconcert.setText("---------CONCERT--------------\r\nor: 500 places=>50\u20AC/place\r\nargent:1500 places =>35\u20AC/place\r\nbronze:3000 places=>20\u20AC/place");
		txtpaneconcert.setBounds(32, 504, 427, 118);
		panel_res_rep.add(txtpaneconcert);
		
		JButton btnresrep = new JButton("r\u00E9server");
		btnresrep.setFont(new Font("Tahoma", Font.ITALIC, 28));
		btnresrep.setBounds(581, 410, 223, 56);
		panel_res_rep.add(btnresrep);
		
		Panel panel_deconnexion = new Panel();
		panel_deconnexion.setBackground(Color.ORANGE);
		tabbedPane.addTab("se d\u00E9connecter", null, panel_deconnexion, null);
		panel_deconnexion.setLayout(null);
		
		JButton btnNewButton = new JButton("se d\u00E9connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
				connexionouregister c=new connexionouregister();
				c.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 34));
		btnNewButton.setBounds(289, 210, 334, 88);
		panel_deconnexion.add(btnNewButton);
	}
}
