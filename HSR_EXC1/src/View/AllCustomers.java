package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;


import model.Customer;
import model.Main;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AllCustomers extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	JList<String> showList;
	String [] toCopy;
	ArrayList<Customer> sorted ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllCustomers frame = new AllCustomers();
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
	public AllCustomers() {
		setBounds(100, 100, 805, 666);
		getContentPane().setLayout(null);
	   sorted = null;
		
	   //buttont that when user click on it shhow to the user allCustomers sorted 
		JButton click = new JButton("click to get all customers sorted by id ");
		click.setForeground(new Color(0, 0, 0));
		click.setBackground(new Color(255, 200, 0));
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(143, 103, 445, 40);
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				if(Main.libr.getAllCustomers()!=null) { // in case there is hash map of customers
					toCopy = new String[Main.libr.getAllCustomers().values().size()]; // array of strings of customers in size the returned list from allCustomers()
					sorted = Main.libr.allCustomers();
					if(sorted!=null) { //in case returned list not null we add it to array then we add the array to jlist and show it to the user 
						int i=0;
						for(Customer c : sorted) {
							toCopy[i]=c.toString();
							i++;
						}
						
					}
					showList.setListData(toCopy);
				}
				}catch(NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There is no customers in the system until now");
				}
				
			}
			
		});
		getContentPane().add(click);
		
		//jlist to show the result to user
		showList = new JList<String>();
		showList.setBounds(10, 178, 756, 449);
		getContentPane().add(showList);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AllCustomers.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 793, 637);
		getContentPane().add(lblNewLabel);

	}
}
