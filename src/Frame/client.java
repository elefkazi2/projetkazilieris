package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.Visibility;
import java.util.Date;
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

public class client extends JFrame implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_mesreserv;
	private JLabel lblnumrep;
	private JLabel lbltitre;
	private JTextPane txtpnexpli;
	Representation rep=new Representation();
	Spectacle spec=new Spectacle();
	Commande com=new Commande();
	Place place=new Place();
	

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
		scrollPane.setBounds(31, 119, 820, 437);
		listespectrep.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"n\u00B0", "titre", "date", "heure d\u00E9but", "artiste(s)", "configuration"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		txtpnexpli = new JTextPane();
		txtpnexpli.setForeground(new Color(0, 0, 0));
		txtpnexpli.setFont(new Font("Tahoma", Font.ITALIC, 22));
		txtpnexpli.setText("Cliquez sur le N\u00B0 de la repr\u00E9sentation que vous souhaitez r\u00E9server.Ensuite, allez dans l'onglet \r\nr\u00E9server pour continuer votre r\u00E9servation.");
		txtpnexpli.setBounds(31, 21, 820, 87);
		listespectrep.add(txtpnexpli);
		
		for(int i = 1; i < 15; i++) {
		Representation rep1=new Representation();
	    rep1=rep.toute_les_representations(i);
		if(rep1.getidr()!=0) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		Object [] row=new Object[] {rep1.getidr(),rep1.getspect().gettitr(),rep1.getdater(),rep1.getheured(),null,null};
		model.addRow(row);
			}
		 }
		
		ListSelectionModel listModel = table.getSelectionModel();
	    listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    listModel.addListSelectionListener(this);
	    
		JPanel panreserv = new JPanel();
		panreserv.setBackground(Color.ORANGE);
		tabbedPane.addTab("R\u00E9server", null, panreserv, null);
		panreserv.setLayout(null);
		
		lblnumrep = new JLabel("New label");
		lblnumrep.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblnumrep.setBounds(20, 31, 232, 27);
		panreserv.add(lblnumrep);
		
		lbltitre = new JLabel("New label");
		lbltitre.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lbltitre.setBounds(20, 96, 232, 27);
		panreserv.add(lbltitre);
		
		JLabel lblconfig = new JLabel("concert");
		lblconfig.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblconfig.setBounds(20, 159, 232, 27);
		panreserv.add(lblconfig);
		
		JLabel lblrecupcat = new JLabel("");
		lblrecupcat.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblrecupcat.setBounds(756, 159, 96, 27);
		panreserv.add(lblrecupcat);
		
		JComboBox ccirque = new JComboBox();
		ccirque.setModel(new DefaultComboBoxModel(new String[] {"", "diamant ", "or ", "argent ", "bronze"}));
		ccirque.setBounds(591, 165, 137, 22);
		panreserv.add(ccirque);

		recupcombobox(ccirque, lblrecupcat);
		
		JComboBox cconcert = new JComboBox();
		cconcert.setModel(new DefaultComboBoxModel(new String[] {"", "or", "argent ", "bronze"}));
		cconcert.setBounds(591, 165, 137, 22);
		panreserv.add(cconcert);
		
		recupcombobox(cconcert, lblrecupcat);
		
		JLabel lblcat = new JLabel("cat\u00E9gorie:");
		lblcat.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblcat.setBounds(468, 154, 113, 37);
		panreserv.add(lblcat);
		
		if(lblconfig.getText()=="cirque") {
			cconcert.setVisible(false);			
		}
		else if(lblconfig.getText()=="concert") {
			ccirque.setVisible(false);
		}
		else {
			cconcert.setVisible(false);
			ccirque.setVisible(false);
		}
		
		JLabel lblNewLabel = new JLabel("nombre de places(10max) :");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(20, 226, 259, 37);
		panreserv.add(lblNewLabel);
		
		JTextArea txtnbrplace = new JTextArea();
		txtnbrplace.setBounds(320, 226, 207, 32);
		panreserv.add(txtnbrplace);
		
		JButton btnNewButton = new JButton("cliquez ici pour calculer le prix");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnNewButton.setBounds(551, 233, 320, 23);
		panreserv.add(btnNewButton);
		
		JLabel lblprix = new JLabel("New label");
		lblprix.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblprix.setBounds(20, 290, 136, 27);
		panreserv.add(lblprix);
		
		JLabel lblrecupliv = new JLabel("");
		lblrecupliv.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblrecupliv.setBounds(411, 355, 317, 28);
		panreserv.add(lblrecupliv);
		
		JComboBox cmlivraison = new JComboBox();
		cmlivraison.setModel(new DefaultComboBoxModel(new String[] {"", "sur place jour spectacle", "par envoi avec timbre prior", "par envoi securis\u00E9(+10\u20AC)"}));
		cmlivraison.setBounds(195, 355, 177, 28);
		panreserv.add(cmlivraison);

		recupcombobox(cmlivraison, lblrecupliv);
		
		JLabel lblNewLabel_1 = new JLabel("Mode livraison :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(20, 355, 151, 21);
		panreserv.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mode payement :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(20, 426, 169, 37);
		panreserv.add(lblNewLabel_2);
		
		JLabel lbrecuppay = new JLabel("");
		lbrecuppay.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lbrecuppay.setBounds(411, 426, 317, 27);
		panreserv.add(lbrecuppay);
		
		JComboBox cmpayement = new JComboBox();
		cmpayement.setModel(new DefaultComboBoxModel(new String[] {"", "Visa ", "PayPal", "Virement SEPA"}));
		cmpayement.setBounds(199, 426, 173, 27);
		panreserv.add(cmpayement);

		recupcombobox(cmpayement, lbrecuppay);
		
		JButton btnreserver = new JButton("r\u00E9server");
		btnreserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idrep=Integer.valueOf(lblnumrep.getText());
				int nbre_place=Integer.valueOf(txtnbrplace.getText());
				lblrecupliv.getText();
				lbrecuppay.getText();
				int idcli=Integer.valueOf(id);
				int  h=com.recup_dernier_comm();;

				//reservation_client(int idc,int nbre_place,String ml,String mp,int idrep)
				com.reservation_client(idcli,nbre_place, lblrecupliv.getText(), lbrecuppay.getText(), idrep);
				place.creation_place(h+1, idrep, nbre_place);
			}
		});
		btnreserver.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnreserver.setBounds(551, 502, 177, 67);
		panreserv.add(btnreserver);
		
	    lblcat = new JLabel("cat\u00E9gorie:");
		lblcat.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblcat.setBounds(468, 154, 113, 37);
		panreserv.add(lblcat);
		
		JPanel panmesreservation = new JPanel();
		panmesreservation.setBackground(Color.ORANGE);
		tabbedPane.addTab("Mes r\u00E9servations", null, panmesreservation, null);
		panmesreservation.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(118, 102, 638, 372);
		panmesreservation.add(scrollPane_1);
		
		table_mesreserv = new JTable();
		table_mesreserv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"titre", "date", "heure"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_mesreserv);
		
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
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] sel;
		int[] col;
	
		try {
	      sel = table.getSelectedRows();
	      col=table.getSelectedColumns();
         //donc faut dire que le premier je clique ou je veux dans nom_ut par exemple donc 
	      //leur dire de cliquer sur le nom du spectacle qu il veulent
		  int i=(int) table.getValueAt(sel[0], col[0]);
		  String t = String.valueOf(i);
	      lblnumrep.setText(t);
	      lbltitre.setText((String)table.getValueAt(sel[0],1));
		}
		catch(Exception ex) {
			txtpnexpli.setText("Attention,Cliquez sur le N° de la représentation que vous souhaitez réserver.Ensuite, allez dans l'onglet \r\n"
					+ "réserver pour continuer votre réservation.");
			txtpnexpli.setForeground(Color.RED);
		}

	}
	/*public void setValueAt(JTable value, int row, int col) {
       value.editCellAt(row, col);
    }*/
}
