package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import Exceptions.RongPassword;
import model.Main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userText; //to get user name
	private JPasswordField passwordField;//to get password
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//border for labels
		Border lableBourder = BorderFactory.createLineBorder(Color.yellow,3);
		
		
		
		JLabel lblNewLabel = new JLabel("Welcome to my Factory !!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(264, 30, 346, 72);
		contentPane.add(lblNewLabel);
		
		JLabel UserName = new JLabel("User name ");
		UserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		UserName.setBounds(56, 143, 140, 43);
		UserName.setBorder(lableBourder);
		contentPane.add(UserName);
		
		userText = new JTextField();
		userText.setBounds(264, 152, 279, 33);
		contentPane.add(userText);
		userText.setColumns(10);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 20));
		password.setBounds(56, 211, 140, 33);
		password.setBorder(lableBourder);
		contentPane.add(password);
		
		JButton logIn = new JButton("LogIn");
		logIn.setBackground(SystemColor.info);
		logIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		logIn.setBounds(353, 355, 115, 43);
		
		//when user click on log in button 
		logIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try { //in case user name and password are admin we open admin jframe
				   if(userText.getText().equals("admin")) {
					  if(passwordField.getText().equals("admin")) {
						  LogIn.super.dispose();
						  new Admin().setVisible(true);
					  }else throw new RongPassword();
					 
				   }else {
					   try {//in other cases we make sure that iin the system there is a employee with this user name and password then open employee jframe 
						   //and showing for user messages
					   for(String s : Main.libr.getEmployeesByUserName().keySet()) {
							if(userText.getText().equals(s))
							{
								try {
								    if(passwordField.getText().equals(Main.libr.getEmployeesByUserName().get(s).getPassword())){
									   
								    	
								    	
									   new Employee(s).setVisible(true);
									   LogIn.super.dispose();
				
			                        }else throw new RongPassword();
								}catch(RongPassword e2) {
									 JOptionPane.showMessageDialog(null, e2.getMessage());
									   passwordField.setText("");
								}
							}
					  }
					  if(!Main.libr.getEmployeesByUserName().containsKey(userText.getText())) {
						  throw new PersonNotExistException();
					  }
					 }catch(PersonNotExistException e3) {
						 JOptionPane.showMessageDialog(null, e3.getMessage());
					 }
				   }
					
			   }catch(RongPassword e1){
				   JOptionPane.showMessageDialog(null, e1.getMessage());
				   passwordField.setText("");
			   }
				
			}
		});
		contentPane.add(logIn);
		
		//background
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(LogIn.class.getResource("/View/loginBackground.jpg")));
		lblNewLabel_3.setBounds(0, 0, 824, 606);
		contentPane.add(lblNewLabel_3);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(264, 215, 279, 33);
		contentPane.add(passwordField);
		
		
		
	}
	
}
