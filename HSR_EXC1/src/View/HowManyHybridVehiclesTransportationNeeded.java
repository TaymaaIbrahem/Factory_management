package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Main;

import javax.swing.ImageIcon;

public class HowManyHybridVehiclesTransportationNeeded extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton click;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowManyHybridVehiclesTransportationNeeded frame = new HowManyHybridVehiclesTransportationNeeded();
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
	public HowManyHybridVehiclesTransportationNeeded() {
		setBounds(100, 100, 811, 679);
		getContentPane().setLayout(null);
		
		
		//when user click on button we call main metoda from factory and show the result as message dialog
		 click = new JButton("click to get how many hybrud vehicles needed");
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(138, 222, 436, 68);
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count =0;
				try {
					count = Main.libr.howManyHybridVehiclesTransportationNeeded();
					JOptionPane.showMessageDialog(null, "factory nedeed : "+count+" vehicles");
				}catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null, "there is no vehicles until now in the factory");
				}catch(ArithmeticException e2) {
					JOptionPane.showMessageDialog(null, "there is no vehicles until now in the factory");
				}
			}
			
		});
		getContentPane().add(click);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HowManyHybridVehiclesTransportationNeeded.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 908, 650);
		getContentPane().add(lblNewLabel);

	}
}
