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
import java.awt.Color;

public class TotalProfit extends JInternalFrame {

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
					TotalProfit frame = new TotalProfit();
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
	public TotalProfit() {
		setBounds(100, 100, 792, 622);
		getContentPane().setLayout(null);
		
		//when user click on the button we call Main.libr.totalProfit() and show the result as message dialog
		JButton btnNewButton = new JButton("click to get the total profit");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(192, 237, 362, 59);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "total prifut is : " + Main.libr.totalProfit());
			}
			
		});
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TotalProfit.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 780, 593);
		getContentPane().add(lblNewLabel);

	}
}
