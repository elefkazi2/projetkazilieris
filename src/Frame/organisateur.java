package Frame;

import classesPojo.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class organisateur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttitre;
	private JTextField txtart;
	private JTextField txthdebut;
	private JTextField txthfin;
	private JTextField txttitredeja;
	private JTextField txtaccompte;
	private JButton btnresspec;
	private JButton btnresrep;
	Categorie cat=new Categorie();
	Representation rep=new Representation();
	Reservation res=new Reservation();
	Spectacle spec=new Spectacle();
	PlaningSalle pl=new PlaningSalle();
	configuration config=new configuration();
	private JTable table;
	private JTextField txtnbrjours;

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
	public void recupcombobox(JComboBox c,JLabel lbl) {
		c.addItemListener(
	            new ItemListener()
	            {
	                public void itemStateChanged(ItemEvent evenement)
	                {
	                    if(evenement.getStateChange()==ItemEvent.SELECTED)
	                    {	                    	
	                       lbl.setText(c.getSelectedItem().toString());	                       
	                    }
	                }
	            }
	         );
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
		panelplasalle.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 127, 734, 437);
		panelplasalle.add(scrollPane);
		
		int l=pl.recup_dernier_pl();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"n°","titre","date debut", "date fin"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		for(int i = 1; i <=l; i++) {
			PlaningSalle pl1=new PlaningSalle();
		    pl1=pl.all(i);
		    
			if(pl1.getId()!=0) {
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			Object [] row=new Object[] {pl1.getId(),pl1.getspect().gettitr(),pl1.getdd(),pl1.getdf()};
			model.addRow(row);
				}
			 }

		JTextPane txtpnPlaningDesDates = new JTextPane();
		txtpnPlaningDesDates.setBackground(Color.ORANGE);
		txtpnPlaningDesDates.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtpnPlaningDesDates.setText("                 Planing des dates d\u00E9j\u00E0 prises.\r\nAllez dans l'onglet R\u00E9server spectacle pour continuer.");
		txtpnPlaningDesDates.setBounds(70, 34, 778, 95);
		panelplasalle.add(txtpnPlaningDesDates);
		
		JTextPane txtpnjourPartir = new JTextPane();
		txtpnjourPartir.setBackground(Color.ORANGE);
		txtpnjourPartir.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtpnjourPartir.setText("4500\u20AC/jour \u00E0 partir de vendredi ou samedi et 3000\u20AC/jour pour les autres.");
		txtpnjourPartir.setBounds(90, 575, 724, 33);
		panelplasalle.add(txtpnjourPartir);
		
		Panel panel_reserver = new Panel();
		panel_reserver.setBackground(Color.ORANGE);
		tabbedPane.addTab("R\u00E9server spectacle", null, panel_reserver, null);
		panel_reserver.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fiche signal\u00E9tique du spectacle.");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblNewLabel.setBounds(226, 11, 399, 60);
		panel_reserver.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("titre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_1.setBounds(450, 179, 78, 29);
		panel_reserver.add(lblNewLabel_1);
		
		txttitre = new JTextField();
		txttitre.setBounds(577, 181, 275, 34);
		panel_reserver.add(txttitre);
		txttitre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("artiste(s):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_2.setBounds(450, 460, 119, 39);
		panel_reserver.add(lblNewLabel_2);
		
		txtart = new JTextField();
		txtart.setBounds(577, 467, 275, 34);
		panel_reserver.add(txtart);
		txtart.setColumns(10);
		
		JButton btnenr = new JButton("continuer");
		btnenr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);				
				btnresrep.setEnabled(true);
				btnresspec.setEnabled(false);
			}
		});
		btnenr.setFont(new Font("Tahoma", Font.ITALIC, 26));
		btnenr.setBounds(521, 542, 290, 60);
		panel_reserver.add(btnenr);
		
		JButton btncont = new JButton("continuer");
		btncont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				btnresspec.setEnabled(true);
				btnresrep.setEnabled(false);
			}
		});
		btncont.setFont(new Font("Tahoma", Font.ITALIC, 26));
		btncont.setBounds(67, 422, 249, 60);
		panel_reserver.add(btncont);
		
		JLabel lblNewLabel_3_2 = new JLabel("date d\u00E9but:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_3_2.setBounds(450, 219, 126, 42);
		panel_reserver.add(lblNewLabel_3_2);
		
		JDateChooser dcdatedebut = new JDateChooser();
		dcdatedebut.setBounds(577, 226, 275, 35);
		panel_reserver.add(dcdatedebut);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("date fin :");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_3_1_1.setBounds(450, 272, 126, 42);
		panel_reserver.add(lblNewLabel_3_1_1);
		
		JDateChooser dcdatefin = new JDateChooser();
		dcdatefin.setBounds(577, 280, 275, 35);
		panel_reserver.add(dcdatefin);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(426, 82, 14, 521);
		panel_reserver.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("titre :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_1_1.setBounds(25, 315, 78, 29);
		panel_reserver.add(lblNewLabel_1_1);
		
		txttitredeja = new JTextField();
		txttitredeja.setColumns(10);
		txttitredeja.setBounds(114, 310, 290, 34);
		panel_reserver.add(txttitredeja);
		
		JTextPane txtpnSpectacleDjRserv = new JTextPane();
		txtpnSpectacleDjRserv.setBackground(Color.ORANGE);
		txtpnSpectacleDjRserv.setForeground(Color.BLUE);
		txtpnSpectacleDjRserv.setFont(new Font("Tahoma", Font.BOLD, 26));
		txtpnSpectacleDjRserv.setText("Si spectacle et r\u00E9servation sont d\u00E9j\u00E0 enregistr\u00E9s.\r\n");
		txtpnSpectacleDjRserv.setBounds(17, 104, 399, 70);
		panel_reserver.add(txtpnSpectacleDjRserv);
		
		JTextPane txtpnSpectaclepasEncoreEnregistr = new JTextPane();
		txtpnSpectaclepasEncoreEnregistr.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtpnSpectaclepasEncoreEnregistr.setBackground(Color.ORANGE);
		txtpnSpectaclepasEncoreEnregistr.setForeground(Color.BLUE);
		txtpnSpectaclepasEncoreEnregistr.setText("Si spectacle et r\u00E9servation pas encore enregistr\u00E9s.");
		txtpnSpectaclepasEncoreEnregistr.setBounds(450, 104, 416, 64);
		panel_reserver.add(txtpnSpectaclepasEncoreEnregistr);
		
		JLabel lblNewLabel_2_1 = new JLabel("accompte:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_2_1.setBounds(450, 394, 119, 39);
		panel_reserver.add(lblNewLabel_2_1);
		
		txtaccompte = new JTextField();
		txtaccompte.setColumns(10);
		txtaccompte.setBounds(577, 401, 275, 34);
		panel_reserver.add(txtaccompte);
		
		JLabel lblNewLabel_8 = new JLabel("nombre de jours :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_8.setBounds(450, 344, 175, 29);
		panel_reserver.add(lblNewLabel_8);
		
		txtnbrjours = new JTextField();
		txtnbrjours.setBounds(635, 344, 217, 29);
		panel_reserver.add(txtnbrjours);
		txtnbrjours.setColumns(10);
		
		JPanel panel_res_rep = new JPanel();
		panel_res_rep.setBackground(Color.ORANGE);
		tabbedPane.addTab("R\u00E9server repr\u00E9sentation", null, panel_res_rep, null);
		panel_res_rep.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("date :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_3.setBounds(33, 159, 126, 42);
		panel_res_rep.add(lblNewLabel_3);
		
		JDateChooser dcdateres = new JDateChooser();
		dcdateres.setBounds(180, 166, 197, 35);
		panel_res_rep.add(dcdateres);
		dcdateres.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblNewLabel_4 = new JLabel("heure d\u00E9but:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_4.setBounds(33, 226, 137, 27);
		panel_res_rep.add(lblNewLabel_4);
		
		txthdebut = new JTextField();
		txthdebut.setBounds(180, 226, 197, 32);
		panel_res_rep.add(txthdebut);
		txthdebut.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("heure fin:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_5.setBounds(32, 283, 120, 27);
		panel_res_rep.add(lblNewLabel_5);
		
		txthfin = new JTextField();
		txthfin.setBounds(180, 275, 197, 35);
		panel_res_rep.add(txthfin);
		txthfin.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("configuration :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_6.setBounds(32, 339, 184, 35);
		panel_res_rep.add(lblNewLabel_6);
		
		JComboBox cmbconfig = new JComboBox();
		cmbconfig.setModel(new DefaultComboBoxModel(new String[] {"", "debout", "concert", "cirque"}));
		cmbconfig.setBounds(180, 339, 197, 33);
		panel_res_rep.add(cmbconfig);
		
		JLabel lblconfig = new JLabel("");
		lblconfig.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblconfig.setBounds(32, 409, 197, 29);
		panel_res_rep.add(lblconfig);
		
		JTextPane textPanedeb = new JTextPane();
		textPanedeb.setText("--------------------DEBOUT--------------------\r\n8000 places =>15\u20AC/place\r\n");
		textPanedeb.setFont(new Font("Tahoma", Font.ITALIC, 22));
		textPanedeb.setBounds(431, 443, 427, 62);
		panel_res_rep.add(textPanedeb);
		
		JTextPane txtpanecirque = new JTextPane();
		txtpanecirque.setFont(new Font("Tahoma", Font.ITALIC, 22));
		txtpanecirque.setText("-------------CIRQUE--------------------\r\ndiamant: 1000 places =>60\u20AC/place\r\nor: 2000 places =>50\u20AC/place\r\nargent:1500 places=>35\u20AC/place\r\nbronze: 1500 places=>20\u20AC/place");
		txtpanecirque.setBounds(10, 481, 427, 141);
		panel_res_rep.add(txtpanecirque);
		
		JTextPane txtpaneconcert = new JTextPane();
		txtpaneconcert.setFont(new Font("Tahoma", Font.ITALIC, 22));
		txtpaneconcert.setText("---------CONCERT--------------\r\nor: 500 places=>50\u20AC/place\r\nargent:1500 places =>35\u20AC/place\r\nbronze:3000 places=>20\u20AC/place");
		txtpaneconcert.setBounds(431, 504, 427, 118);
		panel_res_rep.add(txtpaneconcert);
		
		recupcombobox(cmbconfig,lblconfig);
		btnresrep = new JButton("r\u00E9server");
		btnresrep.setEnabled(false);
		btnresrep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try { 
					String datedebut = new SimpleDateFormat("dd-MM-yyyy").format(dcdatedebut.getDate());
					String datefin = new SimpleDateFormat("dd-MM-yyyy").format(dcdatefin.getDate());
					String dateres = new SimpleDateFormat("dd-MM-yyyy").format(dcdateres.getDate());
					String jour=new SimpleDateFormat("EEEE").format(dcdatedebut.getDate());
					if(txtnbrjours.getText().isEmpty() | txtart.getText().isBlank() | datedebut.isEmpty() | datefin.isEmpty() | dateres.isEmpty() | dateres.isEmpty() | jour.isEmpty()  | txtaccompte.getText().isEmpty() | txttitre.getText().isEmpty() | txthdebut.getText().isEmpty() | txthfin.getText().isEmpty() | lblconfig.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Veillez à remplir tous les champs");
					}else {
					  
						int  h=config.recup_dernier_conf();
						
						pl.ajout_planingsalle(datedebut, datefin, Integer.valueOf(n));
						res.ajout_reservation(Double.valueOf(txtaccompte.getText()),jour, pl.recup_dernier_pl(), Integer.valueOf(n),Integer.valueOf(txtnbrjours.getText()));
						spec.ajout_spectacle(txttitre.getText(),txtart.getText(), pl.recup_dernier_pl());
						rep.ajout_representation(dateres, txthdebut.getText(), txthfin.getText(),spec.recup_dernier_spec());
						config.ajout_configuration(lblconfig.getText(),spec.recup_dernier_spec(),rep.recup_dernier_rep(),h+1);
						JOptionPane.showMessageDialog(null, "la réservation "+res.calcul_prix(res.getp(),Double.valueOf(txtaccompte.getText()))+",a bien été effectuée vous pouvez réservé une vouvelle représentation ou le faire plus tard ");
					}	
			   }catch(Exception ex) {					
						JOptionPane.showMessageDialog(null, "Veuillez verifier que tout soit correctement rempli");
			   }				
			}
		});
		btnresrep.setFont(new Font("Tahoma", Font.ITALIC, 28));
		btnresrep.setBounds(594, 226, 223, 56);
		panel_res_rep.add(btnresrep);
		
		JLabel lblNewLabel_7 = new JLabel("R\u00E9server une repr\u00E9sentation.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel_7.setBounds(230, 40, 387, 62);
		panel_res_rep.add(lblNewLabel_7);
		
		btnresspec = new JButton("r\u00E9server");
		btnresspec.setEnabled(false);
		btnresspec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dateres = new SimpleDateFormat("dd-MM-yyyy").format(dcdateres.getDate());
					if(txttitredeja.getText().isEmpty() | txthdebut.getText().isEmpty() | txthfin.getText().isEmpty() | lblconfig.getText().isEmpty() | dateres.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Veillez à remplir tous les champs");
					}else {
						String is=spec.recup_id(txttitredeja.getText(),null).get(0);
						int  h=config.recup_dernier_conf();					
						rep.ajout_representation(dateres, txthdebut.getText(), txthfin.getText(),Integer.valueOf(is));
						config.ajout_configuration(lblconfig.getText(),Integer.valueOf(is),rep.recup_dernier_rep(),h+1);
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Veuillez verifier que tout soit correctement rempli");
				}
			}
		});
		btnresspec.setFont(new Font("Tahoma", Font.ITALIC, 28));
		btnresspec.setBounds(594, 305, 223, 56);
		panel_res_rep.add(btnresspec);
		
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
