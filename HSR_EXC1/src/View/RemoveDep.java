package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import model.Department;
import model.DepartmentManager;
import model.Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RemoveDep extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	JComboBox <Department>departments; //to show all Departments in system to the user ,to select one to remove
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveDep frame = new RemoveDep();
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
	public RemoveDep() {
		setBounds(100, 100, 814, 680);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All departments in the factory ");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(218, 78, 269, 55);
		getContentPane().add(lblNewLabel);
		
		//adding all the departments to comboBox
		departments = new JComboBox<Department>();
		departments.setBounds(20, 225, 772, 21);
		if(Main.libr.getAllDepartments()!=null) {
			for(Department d : Main.libr.getAllDepartments().values()) {
				DepartmentManager manager = d.getDepManager();
				//in case the department managet is null we set empty manager to be able to get the toString of the dep
				if(manager!=null) {
					departments.addItem(d);
				}else {
					d.setDepManager(new DepartmentManager());
					departments.addItem(d);
				}
				
			}
		}
		
        //when user select department we call remove metoda from factory with the selected dep 
		departments.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Department dep = (Department)departments.getSelectedItem();
				Main.libr.removeDepartment(dep);
				departments.removeItem(dep);
				try {
					Main.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		getContentPane().add(departments);
		
		//background
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RemoveDep.class.getResource("/View/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 802, 651);
		getContentPane().add(lblNewLabel_1);
		

	}

}
