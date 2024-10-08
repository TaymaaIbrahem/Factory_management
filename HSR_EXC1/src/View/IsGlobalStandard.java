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

public class IsGlobalStandard extends JInternalFrame {

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
					IsGlobalStandard frame = new IsGlobalStandard();
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
	public IsGlobalStandard() {
		setBounds(100, 100, 627, 484);
		getContentPane().setLayout(null);
		
		//when user clic on button we call metoda is global from factory and show the result to user as message dialog
		JButton click = new JButton("click to chick if factory is global");
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(145, 159, 294, 53);
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					boolean global =  Main.libr.isGlobalStandard();
					if(global)
					   JOptionPane.showMessageDialog(null, "the factory is global standard");
					else{ JOptionPane.showMessageDialog(null, "the factory is not global standard");}
					
				}catch(NullPointerException e1) {
					 JOptionPane.showMessageDialog(null, "there is no data until now so we cant chick if is global !!");
				}
			}
			
		});
		getContentPane().add(click);
		
		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IsGlobalStandard.class.getResource("/View/background.jpg")));
		lblNewLabel.setBounds(0, 0, 615, 455);
		getContentPane().add(lblNewLabel);

	}
}
