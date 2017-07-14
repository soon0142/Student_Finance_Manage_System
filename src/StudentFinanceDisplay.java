import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class StudentFinanceDisplay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFinanceDisplay frame = new StudentFinanceDisplay();
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
	public StudentFinanceDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcom = new JLabel("Welcome ");
		lblWelcom.setFont(new Font("Dialog", Font.BOLD, 35));
		lblWelcom.setBounds(253, 61, 172, 46);
		contentPane.add(lblWelcom);
		
		JLabel lblNewLabel = new JLabel("Student Finance Management System");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNewLabel.setBounds(81, 118, 534, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Student Management System");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDisplay student=new StudentDisplay();
				student.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(181, 206, 345, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finance Management System");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinanceDisplay finance=new FinanceDisplay();
				finance.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1.setBounds(181, 288, 345, 35);
		contentPane.add(btnNewButton_1);
	}
	
}
