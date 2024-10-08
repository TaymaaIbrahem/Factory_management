package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Exceptions.EmptyFields;
import model.Customer;
import model.Deal;
import model.Main;
import model.VehicleTransportation;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdDeal extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<Customer> customer ;
	JDateChooser dealdate;
	JButton add ;
	JList<String> vehicles ;
	JScrollPane j;
	private JTextField shipping;
	final  VehicleTransportation []allV;
	final  String []vString ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdDeal frame = new AdDeal();
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
	public AdDeal() {
		setBounds(100, 100, 791, 683);
		getContentPane().setLayout(null);
		
		//title
		JLabel lblNewLabel = new JLabel("Add Deal $");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(310, 62, 176, 31);
		getContentPane().add(lblNewLabel);
		
		//label
		JLabel lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(27, 156, 77, 13);
		getContentPane().add(lblNewLabel_1);
		
		//comboBox to choose which customer have the deal 
		 customer = new JComboBox<Customer>();
		customer.setBounds(114, 153, 655, 21);
		if(Main.libr.getAllCustomers()!=null) { // if there is customers in factory add them to customers 
			for(String s : Main.libr.getAllCustomers().keySet()) {
				customer.addItem(Main.libr.getAllCustomers().get(s));
			}
		}
		getContentPane().add(customer);
		
		//label
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(27, 200, 45, 13);
		getContentPane().add(lblNewLabel_2);
		
		//date chooser for date of the deal
		dealdate = new JDateChooser();
		dealdate.setBounds(114, 200, 149, 19);
		getContentPane().add(dealdate);
		
		//label
		JLabel lblNewLabel_3 = new JLabel("choose the vehicle");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(27, 273, 120, 21);
		getContentPane().add(lblNewLabel_3);
		
		//array saves all vehicles in system
		allV= new VehicleTransportation[Main.libr.getAllVehicleTransportation().size()];
		//array saves to string of the allV vehicles
		vString = new String[Main.libr.getAllVehicleTransportation().size()]; 
		if(Main.libr.getAllVehicleTransportation()!=null) {
			int i=0;
			for(VehicleTransportation ve : Main.libr.getAllVehicleTransportation().values()) {
				allV[i] = ve;
				vString[i]= ve.toString();
				i++;
				
			}
		}
		//add array string of vehicle to jlist for user to choose
		vehicles = new JList(vString);
	 
		vehicles.setBounds(157, 276, 612, 368);
		vehicles.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		getContentPane().add(vehicles);
		
		//label
		JLabel lblNewLabel_4 = new JLabel("Shipping cost");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(27, 237, 92, 21);
		getContentPane().add(lblNewLabel_4);
		
		//for user to insert shipping cost ,using double listener to make user type just double
		shipping = new JTextField();
		shipping.setBounds(129, 239, 134, 19);
		shipping.addKeyListener(new DoubleListener());
		getContentPane().add(shipping);
		shipping.setColumns(10);
		
		//button to add deal when user click on it ,using addDealListener
		add = new JButton("Add");
		add.setFont(new Font("Tahoma", Font.BOLD, 19));
		add.setBounds(19, 607, 85, 21);
		add.addActionListener(new AddDealListener());
		getContentPane().add(add);
		
		
		

	} 
	
	//double listener to make user type just double
	public class DoubleListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if( (e.getKeyChar()>'9' || e.getKeyChar() <'0') && (e.getKeyChar()!='.'  && e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ) {
				JOptionPane.showMessageDialog(null, "you have to insert just double !!");
				if(e.getSource()==shipping)
				    shipping.setText("");
				
			}
		}
		
	}
	
	public class AddDealListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == add) {
				try {
					//chicking that all fields have value
				       if(customer.getSelectedIndex()==-1 || dealdate.getDate()==null || shipping.getText().equals("")) {
					          throw new EmptyFields();
			           }else {
			        	   Date start =dealdate.getDate();
			        	   
			        	   Customer c = (Customer) customer.getSelectedItem();
			        	   double ship = Double.parseDouble(shipping.getText());
			        	   
			        	   HashSet<VehicleTransportation> v = new HashSet<VehicleTransportation>();//to save vehicles in these deal
			        	   for(Integer i : vehicles.getSelectedIndices()) {
			        		   v.add(allV[i]);
			        	   }
			        	  
			        	   Deal d =new Deal(c, start, v, ship);//creat deal
			        	   //add deal
			        	   Main.libr.addDeal(d);
			        	   try {
							Main.save();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			           }
				}catch (EmptyFields e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} 
			}
		}
		
	}
}
