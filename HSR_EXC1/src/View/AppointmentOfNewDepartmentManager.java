package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Exceptions.DepartmentAlreadyHasManager;
import model.Department;
import model.DepartmentManager;
import model.Main;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AppointmentOfNewDepartmentManager extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox <Department>dep ; //to choose one department of the system to appoint manager 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentOfNewDepartmentManager frame = new AppointmentOfNewDepartmentManager();
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
	public AppointmentOfNewDepartmentManager() {
		setBounds(100, 100, 802, 686);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("choose department to appoint for it manager ");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(159, 139, 350, 44);
		getContentPane().add(lblNewLabel);
		
		//adding all deapartments in the system to comboBox ,in case department has no manager 
		//we set a embty obj of manager to get to string of department then we return it to null 
		dep = new JComboBox<Department>();
		Department temp =null;
		if(Main.libr.getAllDepartments()!=null) {
			for(Department d: Main.libr.getAllDepartments().values()) {
				if(d.getDepManager()==null) {
					temp =d;
					d.setDepManager(new DepartmentManager());
				}
				dep.addItem(d);
				if(temp!=null) {
					temp.setDepManager(null);
				}
			
			}
		}
		dep.setBounds(10, 244, 754, 44);
		dep.addActionListener(new ActionListener() {
         //when user click on department from the comboBox we call Main.libr.appointmentOfNewDepartmentManager and appoint him and show a massage about result
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Department department = (Department)dep.getSelectedItem();
				if(department!=null) {
					try {
						Main.libr.appointmentOfNewDepartmentManager(department);
						Main.save();
						JOptionPane.showMessageDialog(null, "opration sucssed");
					}catch(DepartmentAlreadyHasManager e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage());
				    }catch (NullPointerException e2) {
						// TODO Auto-generated catch block
				    	JOptionPane.showMessageDialog(null, "Department is null,falid");
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						
					} catch (ParseException e4) {
						// TODO Auto-generated catch block
						
					}
				}
			}
			
		});
		getContentPane().add(dep);
		
		//background
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AppointmentOfNewDepartmentManager.class.getResource("/View/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 780, 647);
		getContentPane().add(lblNewLabel_1);

	}
}
