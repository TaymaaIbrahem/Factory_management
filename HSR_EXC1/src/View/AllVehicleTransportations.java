package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;
import java.awt.Color;



import model.Main;
import model.VehicleTransportation;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AllVehicleTransportations extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList <String> show; // to show result to user
	TreeSet<VehicleTransportation> sorted; // to save returned result from calling metoda 
	String[] toCopy; // to save result as string

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllVehicleTransportations frame = new AllVehicleTransportations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllVehicleTransportations() {
		setBounds(100, 100, 797, 677);
		getContentPane().setLayout(null);
		
		 sorted = null;
		
		JButton click = new JButton("click to get all vehicles sorted by pollution level then price");
		click.setBackground(Color.ORANGE);
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(111, 76, 508, 38);
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(Main.libr.getAllVehicleTransportation()!=null) {
						toCopy = new String[Main.libr.getAllVehicleTransportation().values().size()]; //as size of vehicles in system
						sorted = Main.libr.allVehicleTransportations(); // get result of main metoda  and save it in sorted 
						if(sorted!=null) { // in case system has vehicles and not empty we add to array yhe string of the result elemnts and add them to 
							//show list
							int i=0;
							for(VehicleTransportation v : sorted) {
								toCopy[i]=v.toString();
								i++;
							}
							
						}
						show.setListData(toCopy);
					}
					}catch(NullPointerException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
			}
			
		});
		getContentPane().add(click);
		
		 show = new JList<String>();
		show.setBounds(10, 144, 765, 494);
		getContentPane().add(show);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AllVehicleTransportations.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 785, 648);
		getContentPane().add(lblNewLabel);

	}

}
