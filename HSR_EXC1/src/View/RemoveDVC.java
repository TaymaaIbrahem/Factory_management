package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Exceptions.PersonNotExistException;
import model.Car;
import model.Customer;
import model.Deal;
import model.HybridCar;
import model.HybridMotorcycle;
import model.Main;
import model.Motorcycle;

import model.VIPCustomer;
import model.Van;
import model.VehicleTransportation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RemoveDVC extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	//to show to the user all objects of all types in the system , to choose one to remove 
	JComboBox <VehicleTransportation>removeVehicle; 
	JComboBox <Customer>removeCustomer;
	JComboBox <Deal>removeDeal ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveDVC frame = new RemoveDVC();
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
	public RemoveDVC() {
		setBounds(100, 100, 788, 683);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove vehicle");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(26, 239, 108, 24);
		getContentPane().add(lblNewLabel);
		
		//adding vehicles 
		 removeVehicle = new JComboBox<VehicleTransportation>();
		removeVehicle.setBounds(159, 242, 607, 21);
		if(Main.libr.getAllVehicleTransportation()!=null) {
			for(VehicleTransportation v : Main.libr.getAllVehicleTransportation().values()) {
				removeVehicle.addItem(v);
			}
		}
		removeVehicle.addActionListener(new REmoveListener());
		getContentPane().add(removeVehicle);
		
		JLabel lblNewLabel_1 = new JLabel("Remove customer");
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 295, 125, 24);
		getContentPane().add(lblNewLabel_1);
		
		//adding customers
		 removeCustomer = new JComboBox<Customer>();
		removeCustomer.setBounds(161, 298, 605, 21);
		if(Main.libr.getAllCustomers()!=null) {
			for(Customer c : Main.libr.getAllCustomers().values()) {
				removeCustomer.addItem((Customer)c);
			}
		}
		removeCustomer.addActionListener(new REmoveListener());
		getContentPane().add(removeCustomer);
		
		JLabel lblNewLabel_2 = new JLabel("Remove deal");
		lblNewLabel_2.setBackground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(26, 355, 117, 24);
		getContentPane().add(lblNewLabel_2);
		
		//adding deals
		 removeDeal = new JComboBox<Deal>();
		removeDeal.setBounds(159, 358, 607, 21);
		if(Main.libr.getAllDeals()!=null) {
			for(Deal d : Main.libr.getAllDeals().values()) {
				removeDeal.addItem(d);
			}
		}
		removeDeal.addActionListener(new REmoveListener());
		getContentPane().add(removeDeal);
		
		//background
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(RemoveDVC.class.getResource("/View/background.jpg")));
		lblNewLabel_3.setBounds(0, 0, 776, 654);
		getContentPane().add(lblNewLabel_3);

	}
	
	class REmoveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == removeVehicle) {//in case the selected item is  from removeVehicle
				//we find the type of the vehicle and call remove from factory with this obj
				VehicleTransportation v = (VehicleTransportation) removeVehicle.getSelectedItem();
				if(v instanceof HybridCar) {
					HybridCar h = (HybridCar)v;
					Main.libr.removeHybridCar(h);
					
					
				}
				if(v instanceof Car && !(v instanceof HybridCar)) {
					Car c = (Car)v;
					Main.libr.removeCar(c);
				}
				if(v instanceof HybridMotorcycle) {
					HybridMotorcycle h = (HybridMotorcycle)v;
					Main.libr.removeHybridMotorcycle(h);
					
				}
				if(v instanceof Motorcycle && !(v instanceof HybridMotorcycle)) {
					Motorcycle m = (Motorcycle)v;
					Main.libr.removeMotorcycle(m);
				}
				if(v instanceof Van) {
					Van h = (Van)v;
					Main.libr.removeVan(h);
					
				}
				removeVehicle.removeItem(v);
				try {
					Main.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			if(e.getSource() == removeCustomer) { //in case the selected item from removeCustomer
				//we find the type of customer then call remove from factory 
				Customer c = (Customer)removeCustomer.getSelectedItem();
				try {
				     if(c instanceof VIPCustomer) {
					     VIPCustomer v = (VIPCustomer)c;
					      Main.libr.removeVIPCustomer(v);
				     }else {
				    	 Main.libr.removeCustomer(c);
				     }
				     removeCustomer.removeItem(c);
				     Main.save();
				}catch(PersonNotExistException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(e.getSource() == removeDeal) {//in case selected item is from removeDeal we call remove deal from factory with this deal
				Deal d = (Deal) removeDeal.getSelectedItem();
				Main.libr.removeDeal(d);
				removeDeal.removeItem(d);
				try {
					Main.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
}
