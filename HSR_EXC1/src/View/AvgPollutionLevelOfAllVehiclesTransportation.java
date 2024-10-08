package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import model.Main;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AvgPollutionLevelOfAllVehiclesTransportation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvgPollutionLevelOfAllVehiclesTransportation frame = new AvgPollutionLevelOfAllVehiclesTransportation();
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
	public AvgPollutionLevelOfAllVehiclesTransportation() {
		setBounds(100, 100, 798, 616);
		getContentPane().setLayout(null);
		
		//whwn user click on button a masseege dialog show the user the avePollutionLevel by calling the metoda from factory 
		JButton show = new JButton("click to get ave pollution level of all vehicles in system");
		show.setFont(new Font("Tahoma", Font.BOLD, 15));
		show.setBounds(49, 96, 494, 63);
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double avg =0.0;
				try {
					avg = Main.libr.avgPollutionLevelOfAllVehiclesTransportation();
					JOptionPane.showMessageDialog(null, "average of pollution is : " +avg);
				}catch(NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "there is no vehicles until now in the factory so there is no average");
				}
			}
			
		});
		getContentPane().add(show);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AvgPollutionLevelOfAllVehiclesTransportation.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 587);
		getContentPane().add(lblNewLabel);

	}

}
