package View;



import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;


import model.Main;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Admin extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = getContentPane();
	JMenuItem back;
	JMenuItem logOut;
	JMenuItem addVehicle;
	JMenuItem addDepartment;
	JMenuItem addMember;
	JMenuItem addDeal;
	JMenuItem avePollutionLevelOfDeal;
	JMenuItem totalProfit;
	JMenuItem allBestDepManagers;
	JMenuItem allEmployees;
	JMenuItem removedCV ;
	JMenuItem removeEmployee;
	JMenuItem removeDepartment;
	JMenuItem profitPer ;
	JMenuItem allObj;
	JMenuItem customerByArea;
	JMenuItem PersonByGenderAndYearOfBirth ;
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
					Admin frame = new Admin();
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
	
	
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 690);
	   
		//menu , each item uses openPageListener
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 804, 31);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("exit options");
		menuBar.add(mnNewMenu);
		
		//return you to last page befor this 
		back = new JMenuItem("back");
		back.addActionListener(new OpenPageListener());
		mnNewMenu.add(back);
		
		//log out back to lg in page
		logOut = new JMenuItem("log out");
		mnNewMenu.add(logOut);
		logOut.addActionListener(new OpenPageListener());
		
		JMenu mnNewMenu_1 = new JMenu("add");
		menuBar.add(mnNewMenu_1);
		
		//each menu option open new page with the right metoda by the title 
	     addDeal = new JMenuItem("Deal");
	     addDeal.addActionListener(new OpenPageListener());
		mnNewMenu_1.add(addDeal);
		
		addDepartment = new JMenuItem("Department");
		addDepartment.addActionListener(new OpenPageListener());
		mnNewMenu_1.add(addDepartment);
		
		addVehicle = new JMenuItem("vehicle");
		addVehicle.addActionListener(new OpenPageListener());
		mnNewMenu_1.add(addVehicle);
		
		addMember = new JMenuItem("member");
		addMember.addActionListener(new OpenPageListener());
		mnNewMenu_1.add(addMember);
		
		JMenu mnNewMenu_2 = new JMenu("Remove");
		menuBar.add(mnNewMenu_2);
		
		removedCV = new JMenuItem("deal / customer / vehicle");
		removedCV.addActionListener(new OpenPageListener());
		mnNewMenu_2.add(removedCV);
		
		removeEmployee = new JMenuItem("removeEmployee");
		removeEmployee.addActionListener(new OpenPageListener());
		mnNewMenu_2.add(removeEmployee);
		
		removeDepartment= new JMenuItem("removeDepartment");
		removeDepartment.addActionListener(new OpenPageListener());
		mnNewMenu_2.add(removeDepartment);
		
		JMenu mnNewMenu_3 = new JMenu("Get real");
		menuBar.add(mnNewMenu_3);
		
		//open page with all obj in the system
		allObj = new JMenuItem("all obj' in system");
		allObj.addActionListener(new OpenPageListener());
		mnNewMenu_3.add(allObj);
		
		
		JMenu mnNewMenu_4 = new JMenu("to all other service");
		menuBar.add(mnNewMenu_4);
		
		// each menu item open new page that show metoda result of the item 
		avePollutionLevelOfDeal = new JMenuItem("avePollutionLevelOfDeal");
		avePollutionLevelOfDeal.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(avePollutionLevelOfDeal);
		
		totalProfit = new JMenuItem("totalProfit");
		totalProfit.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(totalProfit);
		
		allEmployees = new JMenuItem("allEmployees");
		allEmployees.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(allEmployees);
		
		allBestDepManagers = new JMenuItem("allBestDepManagers");
		allBestDepManagers.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(allBestDepManagers);
		
		profitPer = new JMenuItem("profitPerVehicleTransportation");
		profitPer.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(profitPer);
		
		customerByArea = new JMenuItem("Customer By Area");
		customerByArea.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(customerByArea);
		
		PersonByGenderAndYearOfBirth = new JMenuItem("Person By Gender And YearOfBirth");
		PersonByGenderAndYearOfBirth.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(PersonByGenderAndYearOfBirth);
		
		countOfVehiclesTransportationByColor =new JMenuItem("count Of Vehicles By Color");
		countOfVehiclesTransportationByColor.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(countOfVehiclesTransportationByColor);
		
		idOfDealWithMinAvgPollutionLevel = new JMenuItem("idOfDealWithMinAvgPollutionLevel");
		idOfDealWithMinAvgPollutionLevel.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(idOfDealWithMinAvgPollutionLevel);
		
		avgPollutionLevelOfAllVehiclesTransportation = new JMenuItem("avgPollutionLevelOfAllVehiclesTransportation");
		avgPollutionLevelOfAllVehiclesTransportation.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(avgPollutionLevelOfAllVehiclesTransportation);
		
		relativePrecentageOfHybrid = new JMenuItem("relative Precentage Of Hybrid");
		relativePrecentageOfHybrid.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(relativePrecentageOfHybrid);
		
		isGlobalStandard = new JMenuItem("isGlobalStandard");
		isGlobalStandard.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(isGlobalStandard);
		
		howManyHybridVehiclesTransportationNeeded = new JMenuItem("how Many Hybrid Vehicle Needed");
		howManyHybridVehiclesTransportationNeeded.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(howManyHybridVehiclesTransportationNeeded);
		
		appointmentOfNewDepartmentManager = new JMenuItem("appointment Of New DepartmentManager");
		appointmentOfNewDepartmentManager.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(appointmentOfNewDepartmentManager);
		
		allCustomers = new JMenuItem("allCustomers");
		allCustomers.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(allCustomers);
		
		allVehicleTransportations  = new JMenuItem("allVehicleTransportations");
		allVehicleTransportations.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(allVehicleTransportations);
		
		allCustomersCmp  = new JMenuItem("allCustomersCmp");
		allCustomersCmp.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(allCustomersCmp);
		
		getBestsDeal = new JMenuItem("getBestsDeal");
		getBestsDeal.addActionListener(new OpenPageListener());
		mnNewMenu_4.add(getBestsDeal);
		
		JLabel lblNewLabel = new JLabel("Hello Admin !!");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(326, 112, 257, 31);
		getContentPane().add(lblNewLabel);
		
		//admin photo
		JLabel lblNewLabel_1 = new JLabel("Tayma Ibrahem");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setVerticalTextPosition(JLabel.EAST);
		lblNewLabel_1.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Admin.class.getResource("/View/admin.jpg")));
		lblNewLabel_1.setBounds(0, 0, 257, 209);
		getContentPane().add(lblNewLabel_1);
		
		//background
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Admin.class.getResource("/View/AdminGround.jpg")));
		lblNewLabel_2.setBounds(0, 31, 804, 652);
		getContentPane().add(lblNewLabel_2);
		
		
		
	}
     public JMenuItem getAddDepartment() {
		return addDepartment;
	}

	
	class OpenPageListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//checking the source of all action on jmenu item, by source of an action we open new internal jframe with subordinate operations to the source title
			if(e.getSource() == back) { // get you back the last jframe
				getContentPane().setVisible(false);
				setContentPane(c);
				getContentPane().setVisible(true);
			}
			if(e.getSource() == logOut) {
				Admin.super.dispose();
				new LogIn().setVisible(true);
			}
			if(e.getSource() == addVehicle ) {
				c=getContentPane();
				getContentPane().setVisible(false);
				setContentPane(new AddVehclie());
				getContentPane().setVisible(true);
			}else {
				if(e.getSource()== addDepartment) {
					c=getContentPane();
					getContentPane().setVisible(false);
					setContentPane(new AddDepartment());
					getContentPane().setVisible(true);
				}else {
					if(e.getSource() == addMember) {
						if(Main.libr.getAllDepartments().isEmpty()) {
							JOptionPane.showMessageDialog(null, "you cant add employee/manager because until now ther is no departments in the factory");
							
						}
						c=getContentPane();
						getContentPane().setVisible(false);
						setContentPane(new AddMember());
						getContentPane().setVisible(true);
					}else {
						if(e.getSource()==addDeal) {
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
											if(e.getSource() == removeEmployee) {
												c=getContentPane();
												getContentPane().setVisible(false);
												setContentPane(new RemovEmployee());
												getContentPane().setVisible(true);
										    }else if(e.getSource() == removeDepartment) {
												     c=getContentPane();
												     getContentPane().setVisible(false);
												     setContentPane(new RemoveDep());
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
																    
														        }
													        	else {
													        		
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
																				    
																		        }
																        		else {
																        			
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
																	        			else {
																	        				
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
																								    
																						        }
																		        				else{
																		        					
																		        					if(e.getSource() == allCustomersCmp) {
																									     c=getContentPane();
																									     getContentPane().setVisible(false);
																									     setContentPane(new AllCustomersCmp());
																									     getContentPane().setVisible(true);
																									    
																							        }
																		        					else{
																		        						
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
  }
}
