package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import model.Main;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class IdOfDealWithMinAvgPollutionLevel extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	String iDeal;//to save returned id from metoda 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdOfDealWithMinAvgPollutionLevel frame = new IdOfDealWithMinAvgPollutionLevel();
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
	public IdOfDealWithMinAvgPollutionLevel() {
		setBounds(100, 100, 790, 660);
		getContentPane().setLayout(null);
		
		JButton click = new JButton("click to get the id of the deal with min avg pollution level");
		click.setBackground(Color.ORANGE);
		click.setFont(new Font("Tahoma", Font.BOLD, 13));
		click.setBounds(55, 118, 448, 54);
		 iDeal="";
		if(Main.libr.getAllDeals()!=null) {//in case there is deals in the system we call metoda and get the id of the min deal 
		   iDeal += Main.libr.idOfDealWithMinAvgPollutionLevel();
		}
		click.addActionListener(new ActionListener() {//then when user click on button we show the result as message dialog

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "The id of the deal is : "+iDeal);
			}
			
		});
		getContentPane().add(click);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IdOfDealWithMinAvgPollutionLevel.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 778, 631);
		getContentPane().add(lblNewLabel);

	}

}
