package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JCalendar;

import classesPojo.PlaningSalle;
import classesPojo.Representation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class gestionnaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Representation rep=new Representation();
	PlaningSalle pl=new PlaningSalle();

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
	public gestionnaire(String nom_ut, String n) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("SalleBosquetWallon/Gestionnaire/"+n+"/"+nom_ut);
		setSize(900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("se d\u00E9connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
				connexionouregister c=new connexionouregister();
				c.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 22));
		btnNewButton.setBounds(652, 11, 222, 46);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 125, 734, 437);
		contentPane.add(scrollPane);
		
		int l=pl.recup_dernier_pl();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"titre","date", "heure debut","heure fin"
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
			Representation rep1=new Representation();
		    rep1=rep.toute_les_representations(i);
		    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		    
			if(rep1.getidr()!=0 && date.equals(rep1.getdater())) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				Object [] row=new Object[] {rep1.getspect().gettitr(),rep1.getdater(),rep1.getheured(),rep1.getheuref()};
				model.addRow(row);
			}
			else {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				Object [] row=new Object[] {"aucune aujourd'hui",null,null,null};
				model.addRow(row);
			}
		}
		
		JTextPane txtpnPlaningSalle = new JTextPane();
		txtpnPlaningSalle.setBackground(Color.ORANGE);
		txtpnPlaningSalle.setText("Planing salle d'aujourd'hui.\r\n");
		txtpnPlaningSalle.setFont(new Font("Tahoma", Font.ITALIC, 42));
		txtpnPlaningSalle.setBounds(139, 47, 549, 67);
		contentPane.add(txtpnPlaningSalle);
	}
}
