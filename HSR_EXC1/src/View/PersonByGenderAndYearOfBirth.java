package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextArea;

import model.Main;
import model.Person;
import utils.Gender;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PersonByGenderAndYearOfBirth extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	HashMap<Gender, HashMap <Integer, ArrayList<Person>>> persons; //to save returned result of the metoda
	ArrayList<Integer> years ; //to save key set of the result
	ArrayList<String> persondByGenderAndYearString;//to save result as strings 
	String [] strings ;// to copy arrayList of strings to this array 
	JList<String> toCopy;//to show the user the result
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonByGenderAndYearOfBirth frame = new PersonByGenderAndYearOfBirth();
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
	public PersonByGenderAndYearOfBirth() {
		setBounds(100, 100, 837, 668);
		getContentPane().setLayout(null);
		
		
		persondByGenderAndYearString=new ArrayList<String>();
		persons = Main.libr.personsByGenderAndYearOfBirth();//calling metoda from factory 
		if(persons!=null) {
			//first we find the persons from gender male 
			 HashMap <Integer, ArrayList<Person>> M =persons.get(Gender.M);
			 if(M!=null) {
				 persondByGenderAndYearString.add("M");//add to arraylist the gender 
				 for(Integer i : M.keySet()) { //then for each year from this gender we add the year then all persons that related to this year 
					 persondByGenderAndYearString.add(""+i);
					 if(M.get(i)!=null) {
						 for(Person p : M.get(i)) {
							 persondByGenderAndYearString.add(p.toString());
						 }
					 }
				 }
			 }
			 //same thing for gender Female
			 M =persons.get(Gender.F);
			 if(M!=null) {
				 persondByGenderAndYearString.add("F");
				 for(Integer i : M.keySet()) {
					 persondByGenderAndYearString.add(""+i);
					 if(M.get(i)!=null) {
						 for(Person p : M.get(i)) {
							 persondByGenderAndYearString.add(p.toString());
						 }
					 }
				 }
			 }
			 
		}
		//then we add all elemnts of ArrayList to the array 
		strings = new String[persondByGenderAndYearString.size()];
		int i=0;
		for(String s : persondByGenderAndYearString) {
			strings[i]=s;
			i++;
		}
		 toCopy = new JList<String>();
		toCopy.setBounds(10, 98, 805, 531);
		getContentPane().add(toCopy);
		
		//then when the user click on button show we add the array to show list and show it to the user 
		JButton btnNewButton = new JButton("show");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(302, 35, 117, 39);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				toCopy.setListData(strings);
			}
			
		});
		getContentPane().add(btnNewButton);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PersonByGenderAndYearOfBirth.class.getResource("/View/background.jpg")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 815, 639);
		getContentPane().add(lblNewLabel);
		
		

	}
}
