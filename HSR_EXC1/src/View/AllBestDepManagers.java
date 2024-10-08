package View;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import model.DepartmentManager;
import model.Main;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Exceptions.NoDataInTheSystem;

import javax.swing.ImageIcon;

public class AllBestDepManagers extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<DepartmentManager> comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllBestDepManagers frame = new AllBestDepManagers();
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
	public AllBestDepManagers() {
		setBounds(100, 100, 794, 590);
		getContentPane().setLayout(null);
		
		//comboBox that will show you all best dep managers 
		comboBox = new JComboBox<DepartmentManager>();
		comboBox.setBounds(10, 109, 735, 49);
		//checking that there is at least manager in the system 
		DepartmentManager d = null;
		for(model.Employee e : Main.libr.getAllEmployees().values()) {
			if(e instanceof DepartmentManager) {
				d=(DepartmentManager)e;
			}
		}
		if(d!=null) { //if there is at least manager we call AllBestsDepManger() and add the returned list to comboBox 
			try {
			ArrayList<DepartmentManager> temp = new ArrayList<>(Main.libr.AllBestsDepManger());
			
			if(temp.size()==0) {//in case array null 
				throw new NoDataInTheSystem();
			}
			for(DepartmentManager dep : temp) {
				comboBox.addItem(dep);
			}
			}catch(NoDataInTheSystem e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			
		}
		comboBox.setMaximumRowCount(3);
		getContentPane().add(comboBox);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AllBestDepManagers.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 782, 561);
		getContentPane().add(lblNewLabel);
		
		

	}
}
