package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.List;

import javax.swing.JTextField;

import Exceptions.IntFieldException;

import model.Employee;
import model.Main;


import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AllEmployees extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField k;//to get k from the user 
	JButton play;
	JList<String> copy; // to show customer t he result
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllEmployees frame = new AllEmployees();
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
	public AllEmployees() {
		setBounds(100, 100, 769, 591);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("insert k : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 43, 85, 13);
		getContentPane().add(lblNewLabel);
		
		k = new JTextField();
		k.setBounds(166, 42, 96, 19);
		k.addKeyListener(new KeyListener() { // key listener to check the input most be integer

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
				    if((e.getKeyChar()>'9' || e.getKeyChar()<'0') && e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)  {
					    throw new IntFieldException();
				    }
				}catch(IntFieldException e1) {
					JOptionPane.showMessageDialog(null, "you have to insert just integer !!");
					k.setText("");
				}
			}
			
		});
		getContentPane().add(k);
		k.setColumns(10);
		
		copy = new JList<String>();
		copy.setBounds(32, 134, 693, 394);
		getContentPane().add(copy);
		
		play = new JButton("play");
		play.setFont(new Font("Tahoma", Font.BOLD, 15));
		play.setBounds(365, 41, 85, 21);
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { //when user click on play we call allEmployees from factory with the input of k then we 
				//insert the result as a to string of each elemnt in array then we add it to jlist to show the user result
				
				List <Employee> temp ;
				temp = Main.libr.allEmployees(Integer.parseInt(k.getText()));
				 String []arr = null ;
				if(temp!=null) {
				   arr = new String[temp.size()];
				   int i=0;
				   for(Employee em : temp ) {
					
					  arr[i]= em.toString();
					  i++;
				   }
				}
				copy.setListData(arr);
				
				
			}
			
		});
		getContentPane().add(play);
		
		//background
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AllEmployees.class.getResource("/View/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 757, 562);
		getContentPane().add(lblNewLabel_1);

	}
}
