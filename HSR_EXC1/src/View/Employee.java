package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.Admin.OpenPageListener;
import model.Main;
import utils.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Employee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container c = getContentPane();
	
	private String userName;
	JMenuItem logOut;
	JMenuItem back ;
	JMenuItem addvehicle;
	JMenuItem adddeal;
	JMenuItem avePollutionLevelOfDeal;
	JMenuItem totalProfit;
	JMenuItem addcustomer;
	JMenuItem allEmployees;
	JMenuItem allBestDepManagers;
	JMenuItem removedCV;
	JMenuItem profitPer;
	JMenuItem allObj;
	JMenuItem customerByArea;
	JMenuItem PersonByGenderAndYearOfBirth;
	JMenuItem countOfVehiclesTransportationByColor;
	JMenuItem idOfDealWithMinAvgPollutionLevel;
	JMenuItem avgPollutionLevelOfAllVehiclesTransportation;
	JMenuItem relativePrecentageOfHybrid;
	JMenuItem isGlobalStandard;
	JMenuItem howManyHybridVehiclesTransportationNeeded;
	JMenuItem appointmentOfNewDepartmentManager;
	JMenuItem allCustomers;
	JMenuItem allVehicleTransportations;
	JMenuItem allCustomersCmp;
	JMenuItem getBestsDeal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee("");
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
	public Employee(String userName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 690);
		this.userName = userName;
		model.Employee em = Main.libr.getEmployeesByUserName().get(userName);
		ImageIcon img = null;
		for(String s : Main.libr.getEmployeesByPhoto().keySet()) {
			if(Main.libr.getEmployeesByPhoto().get(s).equals(em)) {
				img = new ImageIcon(s);
			}
		}
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 816, 32);
		setJMenuBar(menuBar);
		
		
		JMenu mnExitOptions = new JMenu("exit options");
		menuBar.add(mnExitOptions);
		
		//menu item to logout using openPageListener
		logOut = new JMenuItem("log out");
		logOut.addActionListener(new OpenPageListener ());
		mnExitOptions.add(logOut);
		
		//menu item to get back last page
		 back = new JMenuItem("back");
		 back.addActionListener(new OpenPageListener ());
		mnExitOptions.add(back);
		
		//menu items each one open new internal jframe with add metodos
		JMenu mnNewMenu = new JMenu("add");
		menuBar.add(mnNewMenu);
		
		addvehicle = new JMenuItem("vehicle");
		addvehicle.addActionListener(new OpenPageListener ());
		mnNewMenu.add(addvehicle);
		
		adddeal = new JMenuItem("deal");
		adddeal.addActionListener(new OpenPageListener ());
		mnNewMenu.add(adddeal);
		
		addcustomer = new JMenuItem("customer");
		addcustomer.addActionListener(new OpenPageListener ());
		mnNewMenu.add(addcustomer);
		
		//menu item open jframe to remove obj 
		JMenu mnNewMenu_1 = new JMenu("remove");
		menuBar.add(mnNewMenu_1);
		
		removedCV =new JMenuItem("deal / customer / vehicle");
		removedCV.addActionListener(new OpenPageListener ());
		mnNewMenu_1.add(removedCV);
		
		//menu item open jframe to get information about obj
		JMenu mnNewMenu_2 = new JMenu("Get real");
		menuBar.add(mnNewMenu_2);
		
	    allObj = new JMenuItem("all obj' in system");
	    allObj.addActionListener(new OpenPageListener ());
		mnNewMenu_2.add(allObj);
		
		
		//menu items each one open internal jfram with metoda of the title of the item
		JMenu mnNewMenu_3 = new JMenu("All other service");
		menuBar.add(mnNewMenu_3);
		getContentPane().setLayout(null);
		
		avePollutionLevelOfDeal = new JMenuItem("avePollutionLevelOfDeal");
		avePollutionLevelOfDeal.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(avePollutionLevelOfDeal); 
		
		totalProfit = new JMenuItem("totalProfit");
		totalProfit.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(totalProfit);
		
		allEmployees = new JMenuItem("allEmployees");
		allEmployees.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(allEmployees);
		
		allBestDepManagers =  new JMenuItem("allBestDepManagers");
		allBestDepManagers.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(allBestDepManagers);
		
		profitPer =new JMenuItem("profitPer");
		profitPer.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(profitPer);
		
		customerByArea=new JMenuItem("customer By Area");
		customerByArea.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(customerByArea);
		
		PersonByGenderAndYearOfBirth =new JMenuItem("PersonByGenderAndYearOfBirth");
		PersonByGenderAndYearOfBirth.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(PersonByGenderAndYearOfBirth);
		 
		countOfVehiclesTransportationByColor =new JMenuItem("count Of Vehicles By Color");
		countOfVehiclesTransportationByColor.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(countOfVehiclesTransportationByColor);
		
		idOfDealWithMinAvgPollutionLevel = new JMenuItem("idOfDealWithMinAvgPollutionLevel");
		idOfDealWithMinAvgPollutionLevel.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(idOfDealWithMinAvgPollutionLevel);
		
		avgPollutionLevelOfAllVehiclesTransportation = new JMenuItem("avgPollutionLevelOfAllVehiclesTransportation");
		avgPollutionLevelOfAllVehiclesTransportation.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(avgPollutionLevelOfAllVehiclesTransportation);
		
		relativePrecentageOfHybrid = new JMenuItem("relative Precentage Of Hybrid");
		relativePrecentageOfHybrid.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(relativePrecentageOfHybrid);
		
		isGlobalStandard = new JMenuItem("isGlobalStandard");
		isGlobalStandard.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(isGlobalStandard);
		
		howManyHybridVehiclesTransportationNeeded = new JMenuItem("how Many Hybrid Vehicles Needed");
		howManyHybridVehiclesTransportationNeeded.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(howManyHybridVehiclesTransportationNeeded);
		
		appointmentOfNewDepartmentManager = new JMenuItem("appointment Of New DepartmentManager");
		appointmentOfNewDepartmentManager.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(appointmentOfNewDepartmentManager);
		
		allCustomers = new JMenuItem("allCustomers");
		allCustomers.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(allCustomers);
		
		allVehicleTransportations  = new JMenuItem("allVehicleTransportations");
		allVehicleTransportations.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(allVehicleTransportations);
		
		allCustomersCmp  = new JMenuItem("allCustomersCmp");
		allCustomersCmp.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(allCustomersCmp);
		
		getBestsDeal = new JMenuItem("getBestsDeal");
		getBestsDeal.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(getBestsDeal);
		
		JLabel photo = new JLabel(userName);
		photo.setBounds(0, 0, 69, 82);
		if(img!=null) {
			photo.setIcon(img);
		}
		photo.setVerticalTextPosition(JLabel.BOTTOM);
		photo.setHorizontalTextPosition(JLabel.CENTER);
		getContentPane().add(photo);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Employee.class.getResource("/View/employeeBackg.jpg")));
		lblNewLabel.setBounds(0, 0, 804, 621);
		getContentPane().add(lblNewLabel);
	}

	class OpenPageListener implements ActionListener{

		////checking the source of all action on jmenu item, by source of an action we open new internal jframe with subordinate operations to the source title
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == back) {
				getContentPane().setVisible(false);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
			if(e.getSource() == logOut) {
				Employee.super.dispose();
				new LogIn().setVisible(true);
			}
			if(e.getSource() == addvehicle ) {
				c=getContentPane();
				getContentPane().setVisible(false);
				setContentPane(new AddVehclie());
				getContentPane().setVisible(true);
			}else {
					if(e.getSource() == addcustomer) {
						c=getContentPane();
						getContentPane().setVisible(false);
						AddMember temp = new AddMember();
						temp.getEmployee().setEnabled(false);
						temp.getDepMan().setEnabled(false); temp.getAppointmentDate().setEnabled(false);
						temp.getSalary().disable(); temp.getBonusField().disable(); temp.getDateStartOfWork().setEnabled(false);
						temp.getPassword().disable(); temp.getUserName().disable();temp.getDepartment().setEnabled(false);
						setContentPane(temp);
						getContentPane().setVisible(true);
					}else {
						if(e.getSource()==adddeal) {
						    if(Main.libr.getAllCustomers().isEmpty()) {
							    JOptionPane.showMessageDialog(null, "you cant add deal because until now ther is no customers in the factory");
						    }
						    if(Main.libr.getAllVehicleTransportation().isEmpty()) {
							    JOptionPane.showMessageDialog(null, "you cant add deal because until now ther is no vehiclestransporation in the factory");
						    }
						   c=getContentPane();
						   getContentPane().setVisible(false);
						   setContentPane(new AdDeal());
						   getContentPane().setVisible(true);
						}else {
							if(e.getSource() == avePollutionLevelOfDeal) {
								c=getContentPane();
								   getContentPane().setVisible(false);
								   setContentPane(new AvgPollutionLevelOfDeal());
								   getContentPane().setVisible(true);
							}else {
								if(e.getSource() ==totalProfit) {
									c=getContentPane();
									   getContentPane().setVisible(false);
									   setContentPane(new TotalProfit());
									   getContentPane().setVisible(true);
								}else {
									if(e.getSource() ==allEmployees) {
										c=getContentPane();
										   getContentPane().setVisible(false);
										   setContentPane(new AllEmployees());
										   getContentPane().setVisible(true);
									}else {
										if(e.getSource() == allBestDepManagers) {
											c=getContentPane();
											   getContentPane().setVisible(false);
											   setContentPane(new AllBestDepManagers());
											   getContentPane().setVisible(true);
										}else {
											if(e.getSource() == removedCV) {
												c=getContentPane();
												getContentPane().setVisible(false);
												setContentPane(new RemoveDVC());
												getContentPane().setVisible(true);
										    }
											else {
												if(e.getSource() == profitPer) {
												     c=getContentPane();
												     getContentPane().setVisible(false);
												     setContentPane(new ProfitPerVehicleTransportation());
												     getContentPane().setVisible(true);
												    
										        }else {
										        	if(e.getSource() == allObj) {
													     c=getContentPane();
													     getContentPane().setVisible(false);
													     setContentPane(new GetRealObj());
													     getContentPane().setVisible(true);
													    
											        }else {
											        	if(e.getSource() == customerByArea) {
														     c=getContentPane();
														     getContentPane().setVisible(false);
														     setContentPane(new CustomersByArea());
														     getContentPane().setVisible(true);
														    
												        }else {

												        	if(e.getSource() == PersonByGenderAndYearOfBirth) {
															     c=getContentPane();
															     getContentPane().setVisible(false);
															     setContentPane(new PersonByGenderAndYearOfBirth());
															     getContentPane().setVisible(true);
															    
													        }else {

													        	if(e.getSource() == countOfVehiclesTransportationByColor) {
																     c=getContentPane();
																     getContentPane().setVisible(false);
																     setContentPane(new CountOfVehiclesTransportationByColor());
																     getContentPane().setVisible(true);
																    
														        }else {
														        	if(e.getSource() == idOfDealWithMinAvgPollutionLevel) {
																	     c=getContentPane();
																	     getContentPane().setVisible(false);
																	     setContentPane(new IdOfDealWithMinAvgPollutionLevel());
																	     getContentPane().setVisible(true);
																	    
															        }
														        	else {
														        		if(e.getSource() == avgPollutionLevelOfAllVehiclesTransportation) {
																		     c=getContentPane();
																		     getContentPane().setVisible(false);
																		     setContentPane(new AvgPollutionLevelOfAllVehiclesTransportation());
																		     getContentPane().setVisible(true);
																		    
																        }
														        		else {
														        			if(e.getSource() == relativePrecentageOfHybrid) {
																			     c=getContentPane();
																			     getContentPane().setVisible(false);
																			     setContentPane(new RelativePrecentageOfHybrid());
																			     getContentPane().setVisible(true);
																			    
																	        }
														        			else {

																        		if(e.getSource() == isGlobalStandard) {
																				     c=getContentPane();
																				     getContentPane().setVisible(false);
																				     setContentPane(new IsGlobalStandard());
																				     getContentPane().setVisible(true);
																				    
																		        }else {
																        			
																        			if(e.getSource() == howManyHybridVehiclesTransportationNeeded) {
																					     c=getContentPane();
																					     getContentPane().setVisible(false);
																					     setContentPane(new HowManyHybridVehiclesTransportationNeeded());
																					     getContentPane().setVisible(true);
																					    
																			        }else {

																	        			if(e.getSource() == appointmentOfNewDepartmentManager) {
																						     c=getContentPane();
																						     getContentPane().setVisible(false);
																						     setContentPane(new AppointmentOfNewDepartmentManager());
																						     getContentPane().setVisible(true);
																						    
																				        }
																	        			else{

																	        				if(e.getSource() == allCustomers) {
																							     c=getContentPane();
																							     getContentPane().setVisible(false);
																							     setContentPane(new AllCustomers());
																							     getContentPane().setVisible(true);
																							    
																					        }
																	        				else {
																	        					if(e.getSource() == allVehicleTransportations) {
																								     c=getContentPane();
																								     getContentPane().setVisible(false);
																								     setContentPane(new AllVehicleTransportations());
																								     getContentPane().setVisible(true);
																								    
																						        }else {

																		        					if(e.getSource() == allCustomersCmp) {
																									     c=getContentPane();
																									     getContentPane().setVisible(false);
																									     setContentPane(new AllCustomersCmp());
																									     getContentPane().setVisible(true);
																									    
																							        }else {
																							        	if(e.getSource() == getBestsDeal) {
																										     c=getContentPane();
																										     getContentPane().setVisible(false);
																										     setContentPane(new GetBestsDeal());
																										     getContentPane().setVisible(true);
																										    
																								        }
																							        }
																						        }
																	        				}
																	        			}
																			        }
																        		}
																        		
															        		}
														        		}
														        	}
														        }
													        }
												        }
											        }
										        }
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
		}
	}
	
	


