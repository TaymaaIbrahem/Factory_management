package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import model.Main;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class RelativePrecentageOfHybrid extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelativePrecentageOfHybrid frame = new RelativePrecentageOfHybrid();
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
	public RelativePrecentageOfHybrid() {
		setBounds(100, 100, 773, 529);
		getContentPane().setLayout(null);
		
		//when user click on button we call main metoda from factory and show message dialog with result 
		JButton click = new JButton("cllick to get relative precentage");
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(152, 192, 419, 54);
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					double precent = Main.libr.relativePrecentageOfHybrid();
					JOptionPane.showMessageDialog(null, "relative precentage of hybrid is : " + precent);
				}catch(NullPointerException e1) {
					JOptionPane.showMessageDialog(null, " there is no vehicles so orecentage is 0.0");
				}
			}
			
		});
		getContentPane().add(click);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RelativePrecentageOfHybrid.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 761, 500);
		getContentPane().add(lblNewLabel);

	}

}
