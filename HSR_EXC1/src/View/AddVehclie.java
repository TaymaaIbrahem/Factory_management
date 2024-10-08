package View;

import java.awt.EventQueue;
import utils.Color;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;

import Exceptions.CostAndPriceException;
import Exceptions.EmptyFields;

import Exceptions.IncorrectNumberOfSeats;
import Exceptions.PoullutionLevelHybridVehiclesMustBeOne;
import Exceptions.PoullutionLevelNotInRange;
import model.Car;
import model.HybridCar;
import model.HybridMotorcycle;

import model.Main;
import model.Motorcycle;


import model.Van;


import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;



public class AddVehclie extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Price;
	private JTextField capacity;
	private JTextField trunk;
	private JTextField mXCarr;
	JComboBox <String>vehclieClass;
	JComboBox <Integer>numOfSet;
	JComboBox <Color>color;
	JComboBox<Integer> pollution;
	JYearChooser yearChooser;
	JRadioButton convertible;
	JRadioButton ofRoad;
	JButton add;
	private JTextField CostManufacturing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehclie frame = new AddVehclie();
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
	public AddVehclie() {
		setBounds(100, 100, 795, 618);
		getContentPane().setLayout(null);
		
		//label
		JLabel lblNewLabel = new JLabel("Add Vehclie transporation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(204, 38, 377, 31);
		getContentPane().add(lblNewLabel);
		
		//label
		JLabel lblNewLabel_1 = new JLabel("choose the type of the vehclie");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 123, 203, 36);
		getContentPane().add(lblNewLabel_1);
		
		//to check which type of vehicle
		vehclieClass = new JComboBox<String>();
		vehclieClass.setBounds(227, 132, 138, 21);
		vehclieClass.addItem("Car");
		vehclieClass.addItem("HybridCar");
		vehclieClass.addItem("Van");
		vehclieClass.addItem("Motorcycle");
		vehclieClass.addItem("HybridMotorcycle");
		vehclieClass.addActionListener(new TypeVehclieListener());
		getContentPane().add(vehclieClass);
		
		//label
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(20, 229, 71, 13);
		getContentPane().add(lblNewLabel_3);
		
		//price of vehicle
		Price = new JTextField();
		Price.setBounds(227, 228, 138, 19);
		Price.addKeyListener(new DoubleListener());
		getContentPane().add(Price);
		Price.setColumns(10);
		
		//label
		JLabel lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(20, 273, 71, 13);
		getContentPane().add(lblNewLabel_4);
		
		//to choose colour of vehicle 
		color = new JComboBox<Color>();
		color.setBounds(227, 271, 138, 21);
		for(Color c : Color.values()) {
			color.addItem(c);
		}
		getContentPane().add(color);
		
		//label
		JLabel lblNewLabel_12 = new JLabel("Cost of manufacturing");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_12.setBounds(20, 296, 153, 24);
		getContentPane().add(lblNewLabel_12);
		
		//to get CostManufacturing
		CostManufacturing = new JTextField();
		CostManufacturing.setBounds(227, 300, 138, 19);
		CostManufacturing.addKeyListener(new DoubleListener());
		getContentPane().add(CostManufacturing);
		CostManufacturing.setColumns(10);
		
		//label
		JLabel lblNewLabel_5 = new JLabel("Year of manufacture");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(20, 323, 153, 21);
		getContentPane().add(lblNewLabel_5);
		
		// to get year of invention
		yearChooser = new JYearChooser();
		yearChooser.setBounds(227, 325, 138, 19);
		getContentPane().add(yearChooser);
		
		JLabel lblNewLabel_6 = new JLabel("Engine capacity");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(20, 364, 112, 21);
		getContentPane().add(lblNewLabel_6);
		
		//to get capacity of vehicle
		capacity = new JTextField();
		capacity.setBounds(227, 366, 138, 19);
		capacity.addKeyListener(new DoubleListener());
		getContentPane().add(capacity);
		capacity.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Pollution level");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(20, 406, 112, 21);
		getContentPane().add(lblNewLabel_7);
		
		//to choose pollution level 1-15
		pollution = new JComboBox<Integer>();
		pollution.setBounds(227, 407, 138, 21);
		for(int i=1 ; i <=15 ;i++) {
			pollution.addItem(i);
		}
		getContentPane().add(pollution);
		
		JLabel lblNewLabel_8 = new JLabel("Number of seats");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(20, 453, 112, 18);
		getContentPane().add(lblNewLabel_8);
		
		//to get number of sets 1-7
		numOfSet = new JComboBox<Integer>();
		numOfSet.setBounds(227, 450, 138, 21);
		for(int i=1 ; i<=7 ; i++) {
			numOfSet.addItem(i);
		}
		getContentPane().add(numOfSet);
		
		//to get if convertible
		convertible = new JRadioButton("isConvertible");
		convertible.setFont(new Font("Tahoma", Font.BOLD, 13));
		convertible.setBounds(20, 501, 184, 31);
		getContentPane().add(convertible);
		
		JLabel lblNewLabel_9 = new JLabel("Trunk size");
		
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(20, 538, 112, 27);
		getContentPane().add(lblNewLabel_9);
		
		//to get trunk size of van
		trunk= new JTextField();
		trunk.setBounds(227, 538, 138, 27);
		trunk.addKeyListener(new DoubleListener());
		getContentPane().add(trunk);
		trunk.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Max weight carrying");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(425, 131, 150, 22);
		getContentPane().add(lblNewLabel_10);
		
		// to get max carring of van 
		mXCarr = new JTextField();
		mXCarr.setBounds(585, 134, 144, 19);
		mXCarr.addKeyListener(new DoubleListener());
		getContentPane().add(mXCarr);
		mXCarr.setColumns(10);
		
		//to get if motor ofRoad
		ofRoad = new JRadioButton("is offRoad");
		ofRoad.setFont(new Font("Tahoma", Font.BOLD, 13));
		ofRoad.setBounds(425, 180, 112, 21);
		getContentPane().add(ofRoad);
		
		//add button when user click on it addVehicleListener check all conditions then add it 
		add = new JButton("Add");
        add.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add.setBounds(550, 365, 112, 31);
		add.addActionListener(new AddVehclieListener());
		getContentPane().add(add);

		//background
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(AddVehclie.class.getResource("/View/vehicles.jpeg")));
		lblNewLabel_11.setBounds(0, 0, 783, 589);
		getContentPane().add(lblNewLabel_11);
	}
	
	//listener that find the type of vehicle that user choose and make the other not affiliated fields to not edtalbe 
	class TypeVehclieListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(vehclieClass.getSelectedItem().equals("Car") || vehclieClass.getSelectedItem().equals("HybridCar")) {
				trunk.disable();
				mXCarr.disable();
				
				ofRoad.setEnabled(false);
			
				numOfSet.enable(true);
				
				convertible.setEnabled(false);
			
			}
			if(vehclieClass.getSelectedItem().equals("Motorcycle") || vehclieClass.getSelectedItem().equals("HybridMotorcycle") ) {
				numOfSet.disable();
			
				convertible.setEnabled(false);
				
				trunk.disable();
			
				mXCarr.disable();
				
				ofRoad.setEnabled(true);
				
			}
			if(vehclieClass.getSelectedItem().equals("Van")) {
				numOfSet.disable();
				
				convertible.setEnabled(false);
				
				ofRoad.setEnabled(false);
				
				trunk.enable(true);
				
				mXCarr.enable(true);
				
			}
		}
		
	}
	
	//listener to check that the fields that wait double value get just numbers 
	class DoubleListener implements KeyListener{

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
				if(e.getSource()== Price)
                     Price.setText("");
				else if(e.getSource()==capacity)
					     capacity.setText("");
				else if(e.getSource() == CostManufacturing)
					CostManufacturing.setText("");
			}
		}
		
	}
	
	class AddVehclieListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == add) {
				try {
				      if(vehclieClass.getSelectedIndex()== -1) { // to check that the user choose type of vehicle 
					     throw new EmptyFields(", you have to choose a type!");
				      }else { // checking that the basic fields is full
				    	  if(Price.getText().equals("") || CostManufacturing.getText().equals("") || color.getSelectedIndex()==-1 || capacity.getText().equals("") || pollution.getSelectedIndex()==-1 ) {
				    		  throw new EmptyFields();
				    	  }else {
				    		  double p = Double.parseDouble(Price.getText());
			    			  double cm = Double.parseDouble(CostManufacturing.getText());
			    			  double cap = Double.parseDouble(capacity.getText());
			    			  if(p<cm) { // price should greater than cost 
			    				  throw new CostAndPriceException();
			    			  }
			    			  //find the type that selected and create obj and add it to the system 
				    		  if(vehclieClass.getSelectedItem().equals("Car")) {
				    			  System.out.println(color.getSelectedItem());
				    			  Car c = new Car( p,cm,(Color)color.getSelectedItem(),yearChooser.getYear(),
				    					  cap,(int)pollution.getSelectedItem(),(int)numOfSet.getSelectedItem(),convertible.isSelected());
				    			  Main.libr.addCar(c);
				    		  }
				    		  if(vehclieClass.getSelectedItem().equals("HybridCar")) {
				    			HybridCar h = new HybridCar( p, cm, (Color)color.getSelectedItem(), yearChooser.getYear(), cap,
				    					(int)pollution.getSelectedItem(),(int)numOfSet.getSelectedItem(),convertible.isSelected());  
				    			Main.libr.addHybridCar(h);
				    		  }
				    		  if(vehclieClass.getSelectedItem().equals("Motorcycle")) {
				    			  Motorcycle m = new Motorcycle( p, cm,(Color)color.getSelectedItem(),yearChooser.getYear(),
				    					  cap, (int)pollution.getSelectedItem(), ofRoad.isSelected());
				    			  Main.libr.addMotorcycle(m);
				    		  }
				    		  if(vehclieClass.getSelectedItem().equals("HybridMotorcycle")) {
				    			  HybridMotorcycle h = new HybridMotorcycle (p, cm,(Color)color.getSelectedItem()
				    					  ,yearChooser.getYear(), cap, (int)pollution.getSelectedItem(), ofRoad.isSelected());
				    			  Main.libr.addHybridMotorcycle(h);
				    		  }
				    		  if(vehclieClass.getSelectedItem().equals("Van")) {
				    
				    			  double t = Double.parseDouble(trunk.getText());
				    			  double m= Double.parseDouble(mXCarr.getText());
				    			  Van v = new Van( p, cm,(Color)color.getSelectedItem(),yearChooser.getYear(), cap,(int)pollution.getSelectedItem(), t, m);
				    			  Main.libr.addVan(v);
				    		  }
				    	  }
				      }
				      try {
				    	 
						Main.save();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}catch(EmptyFields e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (PoullutionLevelNotInRange e2) {
				          JOptionPane.showMessageDialog(null, e2.getMessage());
				} catch (IncorrectNumberOfSeats e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				} catch (PoullutionLevelHybridVehiclesMustBeOne e4) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e4.getMessage());
				} catch (CostAndPriceException e6) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e6.getMessage());
				}
			}
		}
		
	}
}
