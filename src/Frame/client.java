package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classesPojo.*;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblnumrep;
	private JLabel lbltitre;
	private JTextPane txtpnexpli;
	private JLabel lblconfig;
	private JLabel lblplace;
	private JComboBox ccirque;
	private JComboBox cconcert;
	private JLabel lblrecupcat;
	Representation rep=new Representation();
	Spectacle spec=new Spectacle();
	Commande com=new Commande();
	Place place=new Place();
	private JTextField txtnintro;
	private JTextField txttitreintro;
	private JTextField txtconfigintro;
	

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
	 * @param n 
	 */
	public client(String nom_ut, String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("SalleBosquetWallon/Client/"+id+"/"+nom_ut);
		setSize(900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 984, 761);
		contentPane.add(tabbedPane);
		
		JPanel listespectrep = new JPanel();
		listespectrep.setBackground(Color.ORANGE);
		tabbedPane.addTab("   Liste spectacles", null, listespectrep, null);
		listespectrep.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 148, 820, 304);
		listespectrep.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"n\u00B0", "titre", "date", "heure d\u00E9but","configuration","artiste(s)"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false,false, false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		txtpnexpli = new JTextPane();
		txtpnexpli.setBackground(Color.ORANGE);
		txtpnexpli.setForeground(new Color(0, 0, 0));
		txtpnexpli.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtpnexpli.setText("Veuillez noter le N\u00B0,le titre et la configuration de la repr\u00E9sentation que vous souhaitez r\u00E9server dans les champs appropri\u00E9s en bas du tableau des repr\u00E9sentations et appuyez sur continuer.");
		txtpnexpli.setBounds(31, 11, 820, 109);
		listespectrep.add(txtpnexpli);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0 :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_3.setBounds(10, 491, 46, 39);
		listespectrep.add(lblNewLabel_3);
		
		txtnintro = new JTextField();
		txtnintro.setBounds(83, 491, 86, 39);
		listespectrep.add(txtnintro);
		txtnintro.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Titre\r\n :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(204, 491, 64, 39);
		listespectrep.add(lblNewLabel_4);
		
		txttitreintro = new JTextField();
		txttitreintro.setBounds(262, 494, 239, 39);
		listespectrep.add(txttitreintro);
		txttitreintro.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("configuration :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(523, 491, 119, 39);
		listespectrep.add(lblNewLabel_5);
		
		txtconfigintro = new JTextField();
		txtconfigintro.setBounds(652, 494, 199, 39);
		listespectrep.add(txtconfigintro);
		txtconfigintro.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Continuer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if( txtnintro.getText().isEmpty() | txttitreintro.getText().isEmpty() | txtconfigintro.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Veillez à remplir tous les champs");					
				}
				else {
					lblnumrep.setText(txtnintro.getText());
					lbltitre.setText(txttitreintro.getText());
					lblconfig.setText(txtconfigintro.getText());
					tabbedPane.setSelectedIndex(1);
					if(lblconfig.getText().equals("cirque")) {
						cconcert.setEnabled(false);
						ccirque.setEnabled(true);
						lblrecupcat.setText("");
					}
					else if(lblconfig.getText().equals("concert")) {
						cconcert.setEnabled(true);
						ccirque.setEnabled(false);
						lblrecupcat.setText("");
					}
					else {
						cconcert.setEnabled(false);
						ccirque.setEnabled(false);
						lblrecupcat.setText("debout");
					}
				}
			}
			catch(Exception ex) {
				txtnintro.setText(null);
				txttitreintro.setText(null);
				txtconfigintro.setText(null);
			}
			}	
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 23));
		btnNewButton_1.setBounds(288, 562, 264, 58);
		listespectrep.add(btnNewButton_1);
		
		int g=rep.recup_dernier_rep();
		for(int i = 1; i <=g; i++) {
		Representation rep1=new Representation();
	    rep1=rep.toute_les_representations(i);
		if(rep1.getidr()!=0) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		Object [] row=new Object[] {rep1.getidr(),rep1.getspect().gettitr(),rep1.getdater(),rep1.getheured(),rep1.getspect().getconfig().gettypeconfig(),rep1.getspect().getart()};
		model.addRow(row);
			}
		 }
	    
		JPanel panreserv = new JPanel();
		panreserv.setBackground(Color.ORANGE);
		tabbedPane.addTab("R\u00E9server", null, panreserv, null);
		panreserv.setLayout(null);
		
		lblnumrep = new JLabel("");
		lblnumrep.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblnumrep.setBounds(20, 31, 232, 27);
		panreserv.add(lblnumrep);
		
		lbltitre = new JLabel("");
		lbltitre.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lbltitre.setBounds(20, 96, 232, 27);
		panreserv.add(lbltitre);
		
		lblconfig = new JLabel("concert");
		lblconfig.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblconfig.setBounds(20, 159, 232, 27);
		panreserv.add(lblconfig);
		
		lblrecupcat = new JLabel("");
		lblrecupcat.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblrecupcat.setBounds(756, 159, 96, 27);
		panreserv.add(lblrecupcat);
		
		ccirque = new JComboBox();
		ccirque.setEnabled(false);
		ccirque.setModel(new DefaultComboBoxModel(new String[] {"", "diamant ", "or ", "argent ", "bronze"}));
		ccirque.setBounds(566, 184, 137, 22);
		panreserv.add(ccirque);

		recupcombobox(ccirque, lblrecupcat);
		
	    cconcert = new JComboBox();
	    cconcert.setEnabled(false);
		cconcert.setModel(new DefaultComboBoxModel(new String[] {"", "or", "argent ", "bronze"}));
		cconcert.setBounds(566, 143, 137, 22);
		panreserv.add(cconcert);
		
		recupcombobox(cconcert, lblrecupcat);
		
		JLabel lblcat = new JLabel("cat\u00E9gorie:");
		lblcat.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblcat.setBounds(468, 154, 113, 37);
		panreserv.add(lblcat);
		
		JLabel lblNewLabel = new JLabel("nombre de places :");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(20, 248, 259, 37);
		panreserv.add(lblNewLabel);
		
		JLabel lblrecupliv = new JLabel("");
		lblrecupliv.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblrecupliv.setBounds(411, 355, 317, 28);
		panreserv.add(lblrecupliv);
		
		JComboBox cmlivraison = new JComboBox();
		cmlivraison.setModel(new DefaultComboBoxModel(new String[] {"", "sur place jour spectacle", "par envoi avec timbre prior", "par envoi securis\u00E9(+10\u20AC)"}));
		cmlivraison.setBounds(218, 341, 177, 28);
		panreserv.add(cmlivraison);

		recupcombobox(cmlivraison, lblrecupliv);
		
		JLabel lblNewLabel_1 = new JLabel("Mode livraison :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(20, 341, 151, 21);
		panreserv.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mode payement :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(25, 416, 169, 37);
		panreserv.add(lblNewLabel_2);
		
		JLabel lbrecuppay = new JLabel("");
		lbrecuppay.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lbrecuppay.setBounds(411, 426, 317, 27);
		panreserv.add(lbrecuppay);
		
		JComboBox cmpayement = new JComboBox();
		cmpayement.setModel(new DefaultComboBoxModel(new String[] {"", "Visa ", "PayPal", "Virement SEPA"}));
		cmpayement.setBounds(218, 425, 173, 27);
		panreserv.add(cmpayement);

		recupcombobox(cmpayement, lbrecuppay);
		
		JButton btnreserver = new JButton("r\u00E9server");
		btnreserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int idrep=Integer.valueOf(lblnumrep.getText());
				int nbre_place=Integer.valueOf(lblplace.getText());
				lblrecupliv.getText();
				lbrecuppay.getText();
				int idcli=Integer.valueOf(id);
				int  h=com.recup_dernier_comm();				
				int k=place.nbre_place_encore_dispo(lblrecupcat.getText(), lblnumrep.getText());
				double montanttotal;
				
				if(k>nbre_place) {
					com.reservation_client(idcli,nbre_place, lblrecupliv.getText(), lbrecuppay.getText(), idrep,lblrecupcat.getText());					
					montanttotal=com.cout(lblrecupcat.getText(),lblnumrep.getText(),nbre_place);
				    place.creation_place(h+1, idrep, nbre_place);
					int resultat=k-nbre_place;
					Categorie cat=new Categorie();
					cat.settypecat(lblrecupcat.getText());
					cat.decrementer_nbre_place(lblrecupcat.getText(),String.valueOf(resultat),lblnumrep.getText());
					JOptionPane.showMessageDialog(null, "votre reservation pour un montant de "+ montanttotal +" € a bien été effectué,vous recevrez les détails de votre réservation sur votre adresse mail");	
				}
				else {
					JOptionPane.showMessageDialog(null, "il ne reste que "+k+" place(s) disponibles pour la catégories "+lblrecupcat.getText());
				}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Veuillez verifier que tout soit correctement rempli");
				}
			}
		});
		btnreserver.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnreserver.setBounds(551, 502, 177, 67);
		panreserv.add(btnreserver);
		
	    lblcat = new JLabel("cat\u00E9gorie:");
		lblcat.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblcat.setBounds(468, 154, 113, 37);
		panreserv.add(lblcat);
		
		JComboBox cmbplace = new JComboBox();
		cmbplace.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cmbplace.setBounds(218, 257, 177, 27);
		panreserv.add(cmbplace);
		
		lblplace = new JLabel("");
		lblplace.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblplace.setBounds(483, 248, 98, 37);
		panreserv.add(lblplace);
		
		recupcombobox(cmbplace,lblplace);
		
		JPanel panelsedeconnecter = new JPanel();
		panelsedeconnecter.setBackground(Color.ORANGE);
		tabbedPane.addTab("Se d\u00E9connecter", null, panelsedeconnecter, null);
		panelsedeconnecter.setLayout(null);
		
		JButton btnsedeconnecter = new JButton("Cliquez ici pour vous d\u00E9connecter");
		btnsedeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
				connexionouregister c=new connexionouregister();
				c.setVisible(true);
			}
		});
		btnsedeconnecter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnsedeconnecter.setBounds(269, 277, 348, 54);
		panelsedeconnecter.add(btnsedeconnecter);
	}
}
