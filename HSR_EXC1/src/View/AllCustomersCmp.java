package View;

import java.awt.EventQueue;
import java.util.TreeSet;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.Customer;
import model.Main;


import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class AllCustomersCmp extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TreeSet<Customer> sorted; // returned from metoda from factory
	String[] toCopy; // to string of the customers in sorted
	JList<String> showList; // list to shhow result
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllCustomersCmp frame = new AllCustomersCmp();
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
	public AllCustomersCmp() {
		setBounds(100, 100, 794, 673);
		getContentPane().setLayout(null);
		
		//when user click the button we show the jlist of the result 
		JButton click = new JButton("click to get all customers sorted by deals number and vehicles in the deals");
		click.setBackground(Color.ORANGE);
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(32, 53, 678, 58);
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(Main.libr.getAllVehicleTransportation()!=null) {//in case the hashMap of vehicles not null
						toCopy = new String[Main.libr.getAllVehicleTransportation().values().size()];//array of strings with same size of vehicles in system 
						sorted = Main.libr.allCustomersCmp();// returnd result 
						if(sorted!=null) {//if list of result not null we add to string of each elemnt to the array then we add it to show list to show it to user
							int i=0;
							for(Customer v : sorted) {
								toCopy[i]=v.toString();
								i++;
							}
							
						}
						showList.setListData(toCopy);
					}
					}catch(NullPointerException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
			}
			
		});
		getContentPane().add(click);
		 //list to show user the result
		showList = new JList<String>();
		showList.setBounds(10, 177, 762, 457);
		getContentPane().add(showList);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AllCustomersCmp.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 782, 644);
		getContentPane().add(lblNewLabel);

	}

}
