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
import java.awt.Color;
import javax.swing.JTextField;

import Exceptions.EmptyFields;
import Exceptions.IntFieldException;
import Exceptions.NoDealsInSystem;
import model.ArithmeticMean;
import model.Deal;
import model.GeometricMean;
import model.HarmonicMean;
import model.Main;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GetBestsDeal extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField k;//to get k number from user
	JList <String>showList ;//to show result to the user
	List<Deal> data;//save the result of the metoda
	String[] toCopy; //to save string of each elemnt in result (data)
	JComboBox<String> calcTyps; // for user to choose calculate type 
	JButton show;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetBestsDeal frame = new GetBestsDeal();
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
	public GetBestsDeal() {
		setBounds(100, 100, 798, 639);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("insert k");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 38, 80, 19);
		getContentPane().add(lblNewLabel);
		
		k = new JTextField();
		k.setBackground(Color.WHITE);
		k.setBounds(114, 40, 147, 19);
		k.addKeyListener(new KeyListener() { //to make sure that the user insert integer

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
		
		JLabel lblNewLabel_1 = new JLabel("choose score calculator");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 89, 186, 17);
		getContentPane().add(lblNewLabel_1);
		
		data=null;
		
		//adding calc typs to the comboBox
		 calcTyps = new JComboBox<String>();
		calcTyps.setBounds(241, 91, 147, 17);
		calcTyps.addItem("ArithmeticMean");
		calcTyps.addItem("GeometricMean");
		calcTyps.addItem("HarmonicMean");
		getContentPane().add(calcTyps);
		
		showList = new JList<String>();
		showList.setBounds(10, 150, 766, 450);
		getContentPane().add(showList);
		
		 show = new JButton("show me");
		show.setFont(new Font("Tahoma", Font.BOLD, 15));
		show.setBounds(10, 119, 128, 21);
		show.addActionListener(new ActionListener() {
         //when user click on show button we call getBestsDeal with the selected type calculate
			//then we save the strings of result in toCopy then we add it to show list 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(k.getText().equals("")) {
						throw new EmptyFields();
					}
					int k2 = Integer.parseInt(k.getText());
					String s=(String) calcTyps.getSelectedItem();
				    if(s.equals("ArithmeticMean")) {
					    data = Main.libr.getBestsDeal(k2, new ArithmeticMean());
				    }
				    if(s.equals("GeometricMean")) {
					    data = Main.libr.getBestsDeal(k2, new GeometricMean());
				    }
				    if(s.equals("HarmonicMean")) {
					    data = Main.libr.getBestsDeal(k2, new HarmonicMean());
				    }
				    if(data!=null) {
				    	if(data.size()==0) {
				    		throw new NoDealsInSystem();
				    	}
				    	toCopy = new String[data.size()];
				    	int i =0;
				    	for(Deal d : data) {
				    		toCopy[i]=d.toString();
				    		i++;
				    		
				    	}
				    	showList.setListData(toCopy);
				    }
				    
					
				}catch(NoDealsInSystem e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());	
				}catch(EmptyFields e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());	
				}catch(NullPointerException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
			}
			
		});
		getContentPane().add(show);
		
		//background
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GetBestsDeal.class.getResource("/View/background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 786, 610);
		getContentPane().add(lblNewLabel_2);

	}
}
