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

public class organisateur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		tabbedPane.addTab("R\u00E9server", null, panel_reserver, null);
		
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
