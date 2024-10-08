package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextField;

import model.Customer;
import model.Main;
import utils.Area;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CustomersByArea extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	JComboBox <Area>comboBox; // to make user choose area
	HashMap<Area,ArrayList<Customer>> toCopy; //result of calling main metoda that we will show it after thet 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomersByArea frame = new CustomersByArea();
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
	public CustomersByArea() {
		setBounds(100, 100, 807, 667);
		getContentPane().setLayout(null);
		
		//adding enum values of area 
		comboBox = new JComboBox<Area>();
		for(Area a : Area.values()) {
			comboBox.addItem(a);
		}
		
		comboBox.setBounds(280, 177, 183, 21);
		
		
		toCopy = null;
		if(Main.libr.getAllCustomers()!=null) {
			toCopy=Main.libr.customersByArea(); //calling metoda and save the result in toCoby
		}
		comboBox.addActionListener(new ActionListener() {
         //when user select area from comboBox we add all first name of customers from this area(we get this customers from the result of the metoda) to string then 
			//showing it to user by massege dialog
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Area a = (Area)comboBox.getSelectedItem();
				
				String s =new String();
				if(toCopy!=null) {
					
					if(toCopy.containsKey(a)) {
						
						for(Customer c : toCopy.get(a)) {
							
							 s+=" , "+c.getFirstName();
						}
						JOptionPane.showMessageDialog(null," customers from : "+a+" "+ s);
					}else {
						JOptionPane.showMessageDialog(null, "there is no customers from this area");
					}
				}else {
					JOptionPane.showMessageDialog(null, "there is no customers");
				}
			}
			
		});
		getContentPane().add(comboBox);
		JButton btnNewButton = new JButton("shoose area to see  the customers who belongs then click here");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(165, 63, 550, 36);
		getContentPane().add(btnNewButton);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CustomersByArea.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 914, 638);
		getContentPane().add(lblNewLabel);
		
		

	}
}
