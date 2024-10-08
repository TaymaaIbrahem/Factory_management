package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Exceptions.ChoosenPhotoException;
import Exceptions.EmptyFields;
import Exceptions.PersonAlreadyExistException;
import Exceptions.RongDateException;
import Exceptions.YearOfBirthNotInRange;
import model.Customer;
import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.Main;

import model.VIPCustomer;

import utils.Area;
import utils.Gender;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Button;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JYearChooser;

public class AddMember extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton photoClick;
	private JPanel contentPane;
	private JTextField UserName;
	private JTextField password;
	private JTextField ID;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField PhoneNumber;
	JComboBox <Gender> gender;
	private JTextField Salary;
	private JComboBox<Integer> department;
	private JTextField BonusField;
	private String image;
	 JDateChooser dateStartOfWork;
	 JDateChooser appointmentDate;
	 JDateChooser dateOfJoining ;
	 JYearChooser yearOfBirth;
	 JRadioButton DepMan;
	 JRadioButton customer;
	 JRadioButton vipCustomer;
	 JRadioButton employee;
	 JComboBox<Area> area;
		JComboBox<Double> disPercent;
		JButton add;
		private JLabel lblNewLabel_16;
		private JLabel lblNewLabel_17;
		private JLabel lblNewLabel_18;
		private JLabel lblNewLabel_19;

	/**
	 * Launch the application.
	 */
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JTextField getUserName() {
		return UserName;
	}


	public void setUserName(JTextField userName) {
		UserName = userName;
	}


	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

	public JTextField getSalary() {
		return Salary;
	}

	public void setSalary(JTextField salary) {
		Salary = salary;
	}

	public JComboBox<Integer> getDepartment() {
		return department;
	}

	public void setDepartment(JComboBox<Integer> department) {
		this.department = department;
	}

	public JTextField getBonusField() {
		return BonusField;
	}

	public void setBonusField(JTextField bonusField) {
		BonusField = bonusField;
	}

	public JDateChooser getDateStartOfWork() {
		return dateStartOfWork;
	}

	public void setDateStartOfWork(JDateChooser dateStartOfWork) {
		this.dateStartOfWork = dateStartOfWork;
	}

	public JDateChooser getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(JDateChooser appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public JDateChooser getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(JDateChooser dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public JRadioButton getDepMan() {
		return DepMan;
	}

	public void setDepMan(JRadioButton depMan) {
		DepMan = depMan;
	}

	public JRadioButton getCustomer() {
		return customer;
	}

	public void setCustomer(JRadioButton customer) {
		this.customer = customer;
	}

	public JRadioButton getVipCustomer() {
		return vipCustomer;
	}

	public void setVipCustomer(JRadioButton vipCustomer) {
		this.vipCustomer = vipCustomer;
	}

	public JRadioButton getEmployee() {
		return employee;
	}

	public void setEmployee(JRadioButton employee) {
		this.employee = employee;
	}

	public JComboBox<Area> getArea() {
		return area;
	}

	public void setArea(JComboBox<Area> area) {
		this.area = area;
	}

	public JComboBox<Double> getDisPercent() {
		return disPercent;
	}

	public void setDisPercent(JComboBox<Double> disPercent) {
		this.disPercent = disPercent;
	}

	/**
	 * Create the frame.
	 */
	
	
	public AddMember() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 622);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label
		JLabel lblNewLabel = new JLabel("Add a member");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(288, 26, 284, 52);
		contentPane.add(lblNewLabel);
		
		//label
		JLabel lblNewLabel_1 = new JLabel("type of member is?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(28, 117, 155, 35);
		contentPane.add(lblNewLabel_1);
		
		
		// radio buttons to user to choose one of type member that tha admin like to add ,one choise using inner listener class 
		 DepMan = new JRadioButton("Department manager");
		DepMan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DepMan.setBounds(218, 117, 155, 21);
		DepMan.addActionListener(new choosingEmployeeListener());
		contentPane.add(DepMan);
		
		 employee= new JRadioButton("employee");
		employee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		employee.setBounds(218, 140, 103, 21);
		employee.addActionListener(new choosingEmployeeListener());
		contentPane.add(employee);
		
		customer = new JRadioButton("customer");
		customer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		customer.setBounds(383, 118, 103, 21);
		customer.addActionListener(new choosingCustomerListener());
		contentPane.add(customer);
		
		 vipCustomer = new JRadioButton("vip customer");
		vipCustomer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		vipCustomer.setBounds(383, 141, 103, 21);
		vipCustomer.addActionListener(new choosingCustomerListener());
		contentPane.add(vipCustomer);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(DepMan);
		radioGroup.add(employee);
		radioGroup.add(customer);
		radioGroup.add(vipCustomer);
		
		
		//label and text field to get user name 
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(34, 178, 104, 21);
		contentPane.add(lblNewLabel_2);
		
		
		UserName = new JTextField();
		UserName.setBounds(148, 181, 173, 19);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		// label and text field to get user password
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(34, 220, 77, 21);
		contentPane.add(lblNewLabel_3);
		
		password = new JTextField();
		password.setBounds(148, 223, 173, 19);
		contentPane.add(password);
		password.setColumns(10);
		
		//label and text field to get id 
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(34, 262, 56, 13);
		contentPane.add(lblNewLabel_4);
		
		ID = new JTextField();
		ID.setBounds(148, 261, 173, 19);
		contentPane.add(ID);
		ID.setColumns(10);
		
		//label and text field to get f name
		JLabel lblNewLabel_5 = new JLabel("First Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(36, 296, 75, 16);
		contentPane.add(lblNewLabel_5);
		
		Fname = new JTextField();
		Fname.setBounds(148, 295, 173, 21);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		//label and text field to get l name
		JLabel lblNewLabel_6 = new JLabel("Last name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(34, 337, 77, 17);
		contentPane.add(lblNewLabel_6);
		
		Lname = new JTextField();
		Lname.setBounds(148, 337, 173, 19);
		contentPane.add(Lname);
		Lname.setColumns(10);
		
		//label and text field to get phone number
		JLabel lblNewLabel_7 = new JLabel("Phone number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(34, 368, 104, 13);
		contentPane.add(lblNewLabel_7);
		
		PhoneNumber = new JTextField();
		PhoneNumber.setBounds(148, 366, 173, 19);
		contentPane.add(PhoneNumber);
		PhoneNumber.setColumns(10);
		
		// label and comboBox with type of genders to choose gender 
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(34, 403, 77, 18);
		contentPane.add(lblNewLabel_8);
		
	    gender = new JComboBox<Gender>();
		gender.setBounds(148, 395, 87, 21);
		gender.addItem(Gender.F);
		gender.addItem(Gender.M);
		contentPane.add(gender);
		
		//label
		JLabel lblNewLabel_9 = new JLabel("Year of birth");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(28, 437, 83, 13);
		contentPane.add(lblNewLabel_9);
		
		//label
		JLabel lblNewLabel_10 = new JLabel("Date of start work");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(28, 470, 116, 21);
		contentPane.add(lblNewLabel_10);
		
		//label
		JLabel lblNewLabel_11 = new JLabel("Salary");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(28, 508, 83, 21);
		contentPane.add(lblNewLabel_11);
		
		
		// text field to get salary , using inner class to chick that the salary just double value 
		Salary = new JTextField();
		Salary.setBounds(148, 510, 162, 19);
		contentPane.add(Salary);
		Salary.addKeyListener(new DoubleListener());
		Salary.setColumns(10);
		
		//label
		JLabel lblNewLabel_12 = new JLabel("Department");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(28, 545, 103, 21);
		contentPane.add(lblNewLabel_12);
		
		//comboBox with id of departments in the system 
		department = new JComboBox<Integer>();
		department.setBounds(148, 547, 162, 21);
		if(Main.libr.getAllDepartments()!=null) {
		    for(Integer d : Main.libr.getAllDepartments().keySet()) {
			     department.addItem(d);
		    }
		}
		contentPane.add(department);
		
		//label
		JLabel AppointmentDatelabel = new JLabel("Appointment date");
		AppointmentDatelabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AppointmentDatelabel.setBounds(439, 178, 116, 21);
		contentPane.add(AppointmentDatelabel);
		
		//label
		JLabel Bonus= new JLabel("Bonus");
		Bonus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bonus.setBounds(439, 226, 103, 21);
		contentPane.add(Bonus);
		
		//text field to get bonus , using double listener 
		BonusField = new JTextField();
		BonusField.setBounds(597, 222, 137, 21);
		contentPane.add(BonusField);
		BonusField.addKeyListener(new DoubleListener());
		BonusField.setColumns(10);
		
		//boutton to choose photo from files descktop and save the path of the photo 
		photoClick = new JButton("click to choose a photo");
		photoClick.setFont(new Font("Tahoma", Font.PLAIN, 13));
		photoClick.setBounds(492, 459, 173, 42);
		photoClick.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
			        image= fileChooser.getSelectedFile().getAbsolutePath();
				}
			}
		});
		contentPane.add(photoClick);
		
		// button add to add the member using addListener to chick all condition
	    add = new JButton("Add !");
		add.setFont(new Font("Tahoma", Font.BOLD, 25));
		add.setBounds(617, 525, 123, 41);
		add.addActionListener(new AddListener());
		contentPane.add(add);
		
		 
		//label
		JLabel lblNewLabel_13 = new JLabel("Area");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(439, 264, 56, 21);
		contentPane.add(lblNewLabel_13);
		
		//comboBox with all areas to choose area
	    area = new JComboBox<Area>();
		area.setBounds(597, 260, 137, 21);
		for(Area a : Area.values()) {
			area.addItem(a);
		}
		contentPane.add(area);
		
		//label
		JLabel lblNewLabel_14 = new JLabel("Date of joining");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(439, 310, 103, 21);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("discount percentage");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_15.setBounds(439, 357, 116, 28);
		contentPane.add(lblNewLabel_15);
		
		//comboBox with percents 0.0-100.0 to choose 
		 disPercent = new JComboBox<Double>();
		disPercent.setBounds(597, 365, 137, 21);
		for(double d=0.0 ; d <=100.0 ; d++){
			disPercent.addItem(d);
		}
		contentPane.add(disPercent);
		
		//backgroundLabel
		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_19.setIcon(new ImageIcon(AddMember.class.getResource("/View/addMember.jpg")));
		lblNewLabel_19.setBounds(158, 77, 435, 383);
		contentPane.add(lblNewLabel_19);
		
		//date chooser for start , appointment and joining date 
		 dateStartOfWork = new JDateChooser();
		 dateStartOfWork.setDateFormatString("dd/MM/yyyy");
		 dateStartOfWork.setBounds(148, 472, 155, 19);
		contentPane.add(dateStartOfWork);
		
	    appointmentDate = new JDateChooser();
	    appointmentDate.setDateFormatString("dd/MM/yyyy");
		appointmentDate.setBounds(597, 180, 137, 19);
		contentPane.add(appointmentDate);
		
	     dateOfJoining = new JDateChooser();
		dateOfJoining.setDateFormatString("dd/MM/yyyy");
		dateOfJoining.setBounds(597, 310, 137, 19);
		contentPane.add(dateOfJoining);
		
		//yrat chooser 
		 yearOfBirth = new JYearChooser();
		yearOfBirth.setBounds(148, 431, 87, 19);
		contentPane.add(yearOfBirth);
		
		
		
		
	} 
	
	//whene user choose to add employee / dep manager we chick these conditions 
	private class choosingEmployeeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// he cant add fields of custome/vipCustomer
			   area.disable();
			   area.setBackground(Color.GRAY);
			  
			   dateOfJoining.setEnabled(false);
			   dateOfJoining.setBackground(Color.GRAY);
			   disPercent.disable();
			   disPercent.setBackground(Color.GRAY);
			   dateStartOfWork.setEnabled(true);
			   dateStartOfWork.setBackground(Color.white);
			   Salary.enable(true);
			   Salary.setBackground(Color.white);
			   department.enable(true);
			   department.setBackground(Color.white);
			   //if user choose to add depMan we make him able to add appointment and bonus
			if(e.getSource() == DepMan) {
				 appointmentDate.setEnabled(true);
				 appointmentDate.setBackground(Color.white);
			     BonusField.enable(true);
			     BonusField.setBackground(Color.white);
			     
				
			}else if(e.getSource() == employee) { // if choose to add employee he cant choose , appointmentDate ,BonusField
				appointmentDate.setEnabled(false);
				appointmentDate.setBackground(Color.GRAY);
			       BonusField.disable();
			       BonusField.setBackground(Color.GRAY);
			     
				 
		}

		
	  }
	}
	
	public class choosingCustomerListener implements ActionListener{

		//if user choose to add customer/vipCustomer 
		// he cant uses fields of employee / depMan 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 UserName.disable();
			 UserName.setBackground(Color.GRAY);
			 password.disable();
			 password.setBackground(Color.GRAY);
			 dateStartOfWork.setEnabled(false);
			 dateStartOfWork.setBackground(Color.GRAY);
			 Salary.disable();
			 Salary.setBackground(Color.GRAY);
			 department.disable();
			 department.setBackground(Color.GRAY);
			 BonusField.disable();
		     BonusField.setBackground(Color.GRAY);
		     appointmentDate.setEnabled(false);
		     appointmentDate.setBackground(Color.GRAY);
		     area.enable(true);
			 area.setBackground(Color.white);
		     dateOfJoining.setEnabled(true);
			 dateOfJoining.setBackground(Color.white);
			if(e.getSource() == customer ) { // if choose to add customer , he cant usedisPercent field 
				   disPercent.disable();
				   disPercent.setBackground(Color.GRAY);
				   
				   
			}else if(e.getSource() == vipCustomer) { // if choose vipCustomer he can use disPercent
				 disPercent.enable(true);;
				 disPercent.setBackground(Color.white);
			}
		}
		
	}

	public class AddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == add) {
				try { // Checking if user choose which type he add
				     if(!DepMan.isSelected() && !employee.isSelected() && !customer.isSelected() && !vipCustomer.isSelected()) {
					    throw new EmptyFields();
					   
				     }else {// Checking if all basic fields full
				    	     if( ID.getText().equals("") || Fname.getText().equals("") || Lname.getText().equals("") || PhoneNumber.getText().equals("") ) {
			    			     throw new EmptyFields();}
				    	     else {
				    	    	    //by type that the user choose we create obj and add it to factory with checking all exceptions 
				    	            if(DepMan.isSelected()) {
				    		            if( UserName.getText().equals("") || password.getText().equals("") || Salary.getText().equals("") || BonusField.getText().equals(""))
				    			           throw new EmptyFields();
				    		            Date start = dateStartOfWork.getDate();
				 
				    		            Date appointment =  appointmentDate.getDate();
				    		            if(appointment.before(start)) {
				    		  
				    		            	throw new RongDateException();
				    		            	
				    		            }
				    		            if(start.getYear()<yearOfBirth.getValue() || appointment.before(start) || appointment.getYear()+1900 < yearOfBirth.getValue() || start.getYear()+1900>2022 ||appointment.getYear()+1900>2022) {
				    		            	
				    		            	throw new RongDateException();
				    		            }
				    		            double  salary=  Double.parseDouble(Salary.getText());
				    		            double bonus = Double.parseDouble(BonusField.getText());
				    		            Gender g = (Gender) gender.getSelectedItem();
				    		            Department dep = (Department) Main.libr.getAllDepartments().get(department.getSelectedItem());
				    		            DepartmentManager d = new DepartmentManager(ID.getText(),Fname.getText(),Lname.getText(), PhoneNumber.getText(),g,
				    				    start, salary,dep, (int)yearOfBirth.getValue(), UserName.getText(),password.getText(), appointment, bonus);
				    		           
							            Main.libr.addDepartmentManager(d);
							            if(image!=null) {
								           if(Main.libr.getEmployeesByPhoto().containsKey(image)) {
										      throw new ChoosenPhotoException();
								           }else Main.libr.getEmployeesByPhoto().put(image, d);
							            }	
							            try {
											Main.save();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
						
				    	            }
				    	            if(employee.isSelected()) {
				    		            if( Salary.getText().equals("")|| UserName.getText().equals("") || password.getText().equals("")  )
				    			            throw new EmptyFields();
				    		            
				    		            Date start =  dateStartOfWork.getDate();
				    		            if(start.getYear() +1900 <yearOfBirth.getValue() || start.getYear()+1900>2022) {
				    		         
				    		            	throw new RongDateException();
				    		            }
				    		            double  salary=  Double.parseDouble(Salary.getText());
				    		            
				    		            Employee emp = new Employee(ID.getText(), Fname.getText(), Lname.getText(), PhoneNumber.getText(),(Gender)gender.getSelectedItem(),start,
				    			        salary,Main.libr.getAllDepartments().get(department.getSelectedItem()),yearOfBirth.getValue(), UserName.getText(), password.getText());
				    		           
				    		            Main.libr.addEmployee(emp);
				    		           
				    		            if(image!=null) {
									       if(Main.libr.getEmployeesByPhoto().containsKey(image)) {
											  throw new ChoosenPhotoException();
									       }else Main.libr.getEmployeesByPhoto().put(image, emp);
							            }
				    		           
				    		            try {
											Main.save();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
				    	           }
				    	           if(customer.isSelected()) {
				    	        	  
				    	        	   Date joning =  dateOfJoining.getDate(); 
				    	        	  
				    	        	   if(joning.getYear()+1900< yearOfBirth.getValue() || joning.getYear()+1900>2022) {
				    	        		
				    	        		   throw new RongDateException();
				    	        	   }
				    	               
				    	        	   Customer c = new Customer(ID.getText(),Fname.getText(),Lname.getText(),PhoneNumber.getText(),(Gender)gender.getSelectedItem()
				    	        			   ,(int)yearOfBirth.getValue(),(Area)area.getSelectedItem(),joning);
				    	        	   
				    	        	   Main.libr.addCustomer(c);
				   
				    	        	   try {
										Main.save();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
				    	           }
				    	           if(vipCustomer.isSelected()) {
				    	        	   Date joning = dateOfJoining.getDate();   
				    	        	   if(joning.getYear()+1900<yearOfBirth.getValue() ||  joning.getYear()+1900>2022) {
				    	        		   throw new RongDateException();
				    	        	   }
				    	        	   VIPCustomer v = new VIPCustomer(ID.getText(),Fname.getText(),Lname.getText(),PhoneNumber.getText(),(Gender)gender.getSelectedItem()
				    	        			   ,(int)yearOfBirth.getValue(),(Area)area.getSelectedItem(),joning,(double)disPercent.getSelectedItem());
				    	        	   Main.libr.addVIPCustomer(v);
				    	        	   
				    	        	   try {
										Main.save();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
				    	        	   
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
				}  catch (PersonAlreadyExistException e3) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e3.getMessage());
					ID.setText("");
				} catch (YearOfBirthNotInRange e4) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e4.getMessage());
				} catch (ChoosenPhotoException e5 ){
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e5.getMessage());
				} catch (RongDateException e6) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e6.getMessage());
				}
			}
		}
		
	}
	
	// in filed that he most be double if use this listener to check it 
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
				if(e.getSource()==Salary)
				    Salary.setText("");
				else if(e.getSource()==BonusField)
					BonusField.setText("");
			}
		}
		
	}
}
