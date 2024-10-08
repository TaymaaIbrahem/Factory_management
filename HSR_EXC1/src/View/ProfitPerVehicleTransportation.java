package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Main;
import model.VehicleTransportation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ProfitPerVehicleTransportation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	JComboBox <VehicleTransportation>vehicles;//to show all vehicles in the system to user to choose vehicle 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfitPerVehicleTransportation frame = new ProfitPerVehicleTransportation();
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
	public ProfitPerVehicleTransportation() {
		setBounds(100, 100, 854, 637);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All vehicles Transportation in the factory");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(227, 105, 327, 40);
		getContentPane().add(lblNewLabel);
		
		//adding vehicles in the system to comboBox 
		vehicles = new JComboBox<VehicleTransportation>();
		vehicles.setBounds(10, 227, 822, 21);
		if(Main.libr.getAllVehicleTransportation()!=null) {
			for(VehicleTransportation v : Main.libr.getAllVehicleTransportation().values()) {
				vehicles.addItem(v);
			}
		}
		vehicles.addActionListener(new ActionListener() {//when user select vehicle we call profitPerVehiclesTransportation and show him message dialog with result

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double profit = Main.libr.profitPerVehiclesTransportation((VehicleTransportation)vehicles.getSelectedItem());
				JOptionPane.showMessageDialog(null, "profit of this vehicle is : "+profit);
			}
			
		});
		getContentPane().add(vehicles);
		
		//background
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ProfitPerVehicleTransportation.class.getResource("/View/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 842, 608);
		getContentPane().add(lblNewLabel_1);

	}

}
