package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JList;

import model.Main;
import utils.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CountOfVehiclesTransportationByColor extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	JList <String>showList ; //list to show user result
	ArrayList<String> strings ;//to save the result that we want to show as strings 
	String[] toCopy; // save this result strings in array to copy it to jlist
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CountOfVehiclesTransportationByColor frame = new CountOfVehiclesTransportationByColor();
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
	public CountOfVehiclesTransportationByColor() {
		setBounds(100, 100, 827, 681);
		getContentPane().setLayout(null);
		
		 strings =new ArrayList<String>(); 
		 //calling the main metoda and save the rsult in byColors 
		HashMap<Color, Integer> byColors = Main.libr.countOfVehiclesTransportationByColor();
		if(byColors!=null) { // in case there is deals and bought vehicles
			for(Color c : byColors.keySet()) {//for each color we save string that explain how much vehicles are sold in arraylist strings
				strings.add(c.toString()+" there is : "+ byColors.get(c));
			}
		}
		//we add elemnts of arrayList of strings to array then add array 
		toCopy = new String[strings.size()];
		int i=0;
		for(String s : strings) {
			toCopy[i]=s;
			i++;
		}
		
		
		//when user click on button show we add array to jlist and show him the  result
		JButton show = new JButton("click to see number of vehicles of each color from all deals");
		show.setFont(new Font("Tahoma", Font.BOLD, 15));
		show.setBounds(244, 70, 337, 40);
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showList.setListData(toCopy);
			}
			
		});
		getContentPane().add(show);
		
		showList = new JList<String>();
		showList.setBounds(10, 117, 805, 512);
		getContentPane().add(showList);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CountOfVehiclesTransportationByColor.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 815, 652);
		getContentPane().add(lblNewLabel);
		
		

	}
}
