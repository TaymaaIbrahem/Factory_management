package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Exceptions.EmptyFields;
import model.Department;
import model.Main;
import utils.Specialization;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddDepartment extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartment frame = new AddDepartment();
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
	public AddDepartment() {
		setBounds(100, 100, 818, 617);
		getContentPane().setLayout(null);
		
		//label
		JLabel lblNewLabel = new JLabel("Specialization");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(184, 320, 150, 32);
		getContentPane().add(lblNewLabel);
		
		//user choose specialization
		JComboBox <Specialization>  specialization= new JComboBox<Specialization>();
		specialization.setBounds(379, 327, 140, 21);
        for(Specialization s : Specialization.values()) {
        	specialization.addItem(s);
		}
		getContentPane().add(specialization);
		
		//label
		JLabel lblNewLabel_1 = new JLabel("Department ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(184, 224, 168, 21);
		getContentPane().add(lblNewLabel_1);
		
		//title
		JLabel lblNewLabel_2 = new JLabel("Department");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(315, 74, 182, 32);
		getContentPane().add(lblNewLabel_2);
		
		
		//combo box to make user choose id of the department
		JComboBox<Integer> id = new JComboBox<Integer>();
		id.setBounds(379, 227, 140, 21);
		for(int i=1 ; i<=2000;i++) {
			id.addItem(i);
		}
		getContentPane().add(id);
		
		//button add when user click on it we chick every condition and if its okay to add we add it
		JButton add = new JButton("Add");
		add.setFont(new Font("Tahoma", Font.BOLD, 22));
		add.setBounds(379, 450, 117, 32);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//chicking that there is no 2 dep with same id
				if(Main.libr.getAllDepartments().containsKey(id.getSelectedItem())) {
					JOptionPane.showMessageDialog(null, "already there is dep with this id !!");
				}else {//build dep and add it then save changes
					    Department d = new Department((int)id.getSelectedItem(),(Specialization)specialization.getSelectedItem() );
					    Main.libr.addDepartment(d);
					    try {
							Main.save();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		getContentPane().add(add);
		
		//background 
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AddDepartment.class.getResource("/View/dep3.jpg")));
		lblNewLabel_3.setBounds(0, 0, 806, 578);
		getContentPane().add(lblNewLabel_3);
		

	}
}
