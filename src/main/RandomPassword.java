/**
 * AIM : To create a Random Password generator using Swing and Store it in a file.
 * DEVELOPED BY :RAHUL DHAR
 * VERSION : 1.01.25.07.2020
 */
package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import helper.CreateFile;
import helper.PasswordGenerator;

public class RandomPassword {

	private JFrame frame;
	private JTextField len;
	private JTextField result;
	private int i = 0;
	private String pass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomPassword window = new RandomPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandomPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setTitle("Random Password Generator");
		frame.setBounds(100, 100, 549, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		len = new JTextField();
		len.setBounds(146, 45, 159, 20);
		frame.getContentPane().add(len);
		len.setColumns(10);

		result = new JTextField();
		result.setEditable(false);
		result.setEnabled(false);
		result.setBounds(146, 135, 247, 20);
		frame.getContentPane().add(result);
		result.setColumns(10);

		JLabel lenLabel = new JLabel("Enter the length");
		lenLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lenLabel.setBounds(10, 48, 111, 14);
		frame.getContentPane().add(lenLabel);

		JButton save = new JButton("Save Into File");
		save.setFont(new Font("Times New Roman", Font.BOLD, 12));
		save.setEnabled(false);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CreateFile.create(++i, pass);
				JOptionPane.showMessageDialog(frame,
						"Password successfully saved in the file located in the current directory in encrypted format ");
				int i = JOptionPane.showConfirmDialog(frame, "Do you want to refesh ?");
				System.out.println(i);
				if (i == 0) {
					result.setText("");
					len.setText("");
				}
			}
		});

		JButton submit = new JButton("Generate Password");
		submit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int l = Integer.parseInt(len.getText());
					if (l <= 0 || l >= 13) {
						JOptionPane.showMessageDialog(frame,
								"The length needs to be more than 0 and less than equal to 13");
						System.exit(0);
					}
					pass = PasswordGenerator.createPassword(l);
					result.setText(pass);
					result.setEnabled(true);
					result.setEditable(false);
					save.setEnabled(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1);

				}
			}
		});
		submit.setBounds(146, 89, 159, 23);
		frame.getContentPane().add(submit);

		JLabel resLabel = new JLabel("Generated Password");
		resLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		resLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resLabel.setBounds(21, 138, 111, 14);
		frame.getContentPane().add(resLabel);

		JLabel Footer = new JLabel("\u00A9 Rahul Dhar , 2020");
		Footer.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		Footer.setForeground(new Color(0, 51, 0));
		Footer.setHorizontalAlignment(SwingConstants.CENTER);
		Footer.setBounds(146, 236, 159, 14);
		frame.getContentPane().add(Footer);

		save.setBounds(59, 180, 159, 23);
		frame.getContentPane().add(save);

		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(frame, "Do you want to exit");
				if (i == 0) {
					JOptionPane.showMessageDialog(frame,
							"Thank You for using this application it has been made by Rahul Dhar");
					System.exit(0);
				}
			}
		});
		exit.setBounds(413, 180, 89, 23);
		frame.getContentPane().add(exit);

		JButton refreshBtn = new JButton("Refresh ");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Refreshing the data ");
				len.setText("");
				result.setText("");
				JOptionPane.showMessageDialog(frame, "Refresh done successfully");
			}
		});
		refreshBtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		refreshBtn.setBounds(260, 180, 89, 23);
		frame.getContentPane().add(refreshBtn);

		JLabel headingLabel = new JLabel("Random Password Generator");
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		headingLabel.setBounds(44, 11, 393, 23);
		frame.getContentPane().add(headingLabel);
	}
}
