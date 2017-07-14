import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField t_loginName;
	private JTextField t_passwd;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close(){
		
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLabel = new JLabel("Student Finance Management System");
		lblLabel.setBounds(85, 78, 487, 37);
		lblLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		contentPane.add(lblLabel);
		
		JLabel lblEnterLoginName = new JLabel("Login Name");
		lblEnterLoginName.setBounds(153, 171, 133, 31);
		lblEnterLoginName.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(lblEnterLoginName);
		
		t_loginName = new JTextField();
		t_loginName.setBounds(304, 171, 196, 31);
		contentPane.add(t_loginName);
		t_loginName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(154, 238, 94, 31);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		t_passwd = new JTextField();
		t_passwd.setBounds(304, 238, 196, 31);
		contentPane.add(t_passwd);
		t_passwd.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(281, 327, 107, 37);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			StudentFinanceQueries sq=new StudentFinanceQueries();
			int result=sq.loginsuccess(t_loginName.getText(),t_passwd.getText());
			
			
			if (result==0)
			{
				JOptionPane.showMessageDialog(rootPane, "No LoginName!! Please Input Login Name again!!", "No LoginName!", JOptionPane.PLAIN_MESSAGE);
				t_loginName.setText("");
				t_passwd.setText("");
				
				
			}
			else 
			{	
				close();
				StudentFinanceDisplay student=new StudentFinanceDisplay();
				student.setVisible(true);
				
			}	
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(btnLogin);
	}
	
}
