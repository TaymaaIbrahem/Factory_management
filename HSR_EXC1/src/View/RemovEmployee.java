package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Exceptions.PersonNotExistException;
import model.DepartmentManager;
import model.Employee;
import model.Main;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RemovEmployee extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	JComboBox <Employee>employees; // to show the user all employees to choose one to remove
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemovEmployee frame = new RemovEmployee();
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
	public RemovEmployee() {
		setBounds(100, 100, 811, 643);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All employees in factory");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(303, 111, 242, 27);
		getContentPane().add(lblNewLabel);
		
		//adding employees
	    employees = new JComboBox<Employee>();
		employees.setBounds(10, 219, 773, 21);
		if(Main.libr.getAllEmployees()!=null) {
			for(Employee e : Main.libr.getAllEmployees().values()) {
				employees.addItem((Employee)e);
			}
		}
		employees.addActionListener(new ActionListener() {
			//when user select employee we find the type of him then call remove by the type 

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Employee em = (Employee)employees.getSelectedItem();
				try {
				      if(em instanceof DepartmentManager) {
					       Main.libr.removeDepartmentManager((DepartmentManager)em);
				      }else {
				    	  Main.libr.removeEmployee(em);
				      }
				      employees.removeItem((Employee)em);
				      Main.save();
				}catch(PersonNotExistException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		getContentPane().add(employees);
		//background
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RemovEmployee.class.getResource("/View/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 846, 614);
		getContentPane().add(lblNewLabel_1);

	}
}
