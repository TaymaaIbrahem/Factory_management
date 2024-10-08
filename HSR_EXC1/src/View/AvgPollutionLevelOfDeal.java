package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Deal;
import model.Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AvgPollutionLevelOfDeal extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox <Deal> deals ; // to choose deal from all deals in system to get pollution level of it
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvgPollutionLevelOfDeal frame = new AvgPollutionLevelOfDeal();
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
	public AvgPollutionLevelOfDeal() {
		setBounds(100, 100, 773, 564);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("choose deal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(302, 103, 100, 30);
		getContentPane().add(lblNewLabel);
		
		deals = new JComboBox<Deal>();
		deals.setBounds(10, 161, 741, 21);
		if(Main.libr.getAllDeals()!=null) { //adding all deals in system to comboBox
		    for(Deal d : Main.libr.getAllDeals().values()) {
			   deals.addItem(d);
	     	}
		}
		deals.addActionListener(new ActionListener() {
        //when user click on deal from comboBox we call Main.libr.avgPollutionLevelOfDeal((Deal) with this deal 
			///and by essageDialog we show user the result
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s =""+ Main.libr.avgPollutionLevelOfDeal((Deal)deals.getSelectedItem());
				JOptionPane.showMessageDialog(null, deals.getSelectedItem()+"    avePollutionis : "+ s);
							}
			
		});
		
		getContentPane().add(deals);
		
		//Background
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AvgPollutionLevelOfDeal.class.getResource("/View/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 761, 535);
		getContentPane().add(lblNewLabel_1);

	}
}
