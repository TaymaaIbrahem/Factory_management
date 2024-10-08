package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Car;
import model.Customer;
import model.Deal;
import model.Department;
import model.DepartmentManager;
import model.HybridCar;
import model.HybridMotorcycle;
import model.Main;
import model.Motorcycle;
import Exceptions.*;
import model.Van;
import model.VehicleTransportation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class GetRealObj extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	//to suggest to user id of all each type of objects in the system 
	JComboBox <String>vehicles; 
	JComboBox <String>customers;
	JComboBox <String>employees;
	JComboBox <String>deals;
	JComboBox <Integer>departments;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRealObj frame = new GetRealObj();
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
	public GetRealObj() {
		setBounds(100, 100, 808, 667);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("all vehicles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 191, 121, 26);
		getContentPane().add(lblNewLabel);
		
		//adding id of each vehicle in system
		vehicles = new JComboBox<String>();
		vehicles.setBounds(153, 196, 147, 21);
		if(Main.libr.getAllVehicleTransportation()!=null) {
			for(String s : Main.libr.getAllVehicleTransportation().keySet()) {
				vehicles.addItem(s);
			}
		}
		vehicles.addActionListener(new GetRealActionListener());
		getContentPane().add(vehicles);
		
		JLabel lblNewLabel_1 = new JLabel("all customers");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 273, 121, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("you have all pk of objects choose id and they system will show you the obj' information ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(94, 63, 758, 26);
		getContentPane().add(lblNewLabel_2);
		
		//adding id of each customer in system
		customers = new JComboBox<String>();
		customers.setBounds(153, 275, 147, 21);
		if(Main.libr.getAllCustomers()!=null) {
			for(String s : Main.libr.getAllCustomers().keySet()) {
				customers.addItem(s);
			}
		}
		customers.addActionListener(new GetRealActionListener());
		getContentPane().add(customers);
		
		JLabel lblNewLabel_3 = new JLabel("all employees");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 357, 121, 21);
		getContentPane().add(lblNewLabel_3);
		
		//adding id of each employee in system
		employees = new JComboBox<String>();
		employees.setBounds(153, 358, 147, 21);
		if(Main.libr.getAllEmployees()!=null) {
			for(String s : Main.libr.getAllEmployees().keySet()) {
				employees.addItem(s);
			}
		}
		employees.addActionListener(new GetRealActionListener() );
		getContentPane().add(employees);
		
		JLabel lblNewLabel_4 = new JLabel("all Deals");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 437, 103, 21);
		getContentPane().add(lblNewLabel_4);
		
		//adding id of each deal in system
		deals = new JComboBox<String>();
		deals.setBounds(153, 439, 147, 21);
		if(Main.libr.getAllDeals()!=null) {
			for(String s : Main.libr.getAllDeals().keySet()) {
				deals.addItem(s);
			}
		}
		deals.addActionListener(new GetRealActionListener() );
		getContentPane().add(deals);
		
		JLabel lblNewLabel_5 = new JLabel("all departments");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 522, 121, 26);
		getContentPane().add(lblNewLabel_5);
		
		//adding id of each department in system
		departments = new JComboBox<Integer>();
		departments.setBounds(153, 527, 147, 21);
		if(Main.libr.getAllDepartments()!=null) {
			for(int i : Main.libr.getAllDepartments().keySet()) {
				departments.addItem(i);
			}
		}
		departments.addActionListener(new GetRealActionListener() );
		getContentPane().add(departments);
		
		//background
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(GetRealObj.class.getResource("/View/background.jpg")));
		lblNewLabel_6.setBounds(0, 0, 862, 638);
		getContentPane().add(lblNewLabel_6);
	}
	
	//actionlistener that when user select item from combobox ,we call gerReal from factory with the selected id and show toString of element as massage dialog
	class GetRealActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == vehicles) {
				VehicleTransportation v = Main.libr.getAllVehicleTransportation().get(vehicles.getSelectedItem());
				JOptionPane.showMessageDialog(null, v.toString());
			}
			if(e.getSource()==customers) {
				Customer c = Main.libr.getAllCustomers().get(customers.getSelectedItem());
				JOptionPane.showMessageDialog(null, c.toString());
			}
			if(e.getSource() == employees) {
				model.Employee em = Main.libr.getAllEmployees().get(employees.getSelectedItem());
				JOptionPane.showMessageDialog(null, em.toString());
			}
			if(e.getSource() == deals) {
				Deal d = Main.libr.getAllDeals().get(deals.getSelectedItem());
				JOptionPane.showMessageDialog(null, d.toString());
			}
			if(e.getSource() == departments) {
				Department d = Main.libr.getAllDepartments().get(departments.getSelectedItem());
				if(d.getDepManager() ==null) {
					d.setDepManager(new DepartmentManager());
					
				}
				JOptionPane.showMessageDialog(null, d.toString());
				
				
			}
			
		}
		
	    
	}
}
