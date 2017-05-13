import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class StudentDisplay extends JFrame {

	private JPanel contentPane;
	private JTextField StudentName;
	private JTextField StudentPhone;
	private JTextField StudentEmail;
	private JTextField Grade;
	private JTextField Dob;
	private JTextField MomName;
	private JTextField MomPhone;
	private JTextField MomEmail;
	private JTextField DadName;
	private JTextField DadPhone;
	private JTextField DadEmail;
	private JTextField Address;
	String s;
	private JTextField StudentID;
	private Student currentEntry;
	private JTextField EntInOutDate;
	private JTextField AwardPunContent;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDisplay frame = new StudentDisplay();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentDisplay() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 644);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInput = new JMenu("Input");
		mnInput.setMnemonic('I');
		menuBar.add(mnInput);
	
		
		JMenuItem mntmInputFinance = new JMenuItem("Input Finance");
		mntmInputFinance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				close();
				FinanceDisplay finance=new FinanceDisplay();
				finance.setVisible(true);
				
		
			}
		});
		
		mnInput.add(mntmInputFinance);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Management");
		lblNewLabel.setBounds(169, 12, 346, 33);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setBounds(379, 74, 126, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStudentPhone = new JLabel("Student Phone");
		lblStudentPhone.setBounds(53, 112, 117, 15);
		contentPane.add(lblStudentPhone);
		
		JLabel lblNewLabel_2 = new JLabel("Student Email");
		lblNewLabel_2.setBounds(379, 103, 119, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Grade");
		lblNewLabel_4.setBounds(53, 146, 108, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DOB(mm/dd/yyyy)");
		lblNewLabel_5.setBounds(379, 139, 132, 33);
		contentPane.add(lblNewLabel_5);
		
		StudentName = new JTextField();
		StudentName.setBounds(516, 72, 126, 19);
		contentPane.add(StudentName);
		StudentName.setColumns(10);
		
		StudentEmail = new JTextField();
		StudentEmail.setBounds(516, 110, 126, 19);
		contentPane.add(StudentEmail);
		StudentEmail.setColumns(10);
		
		Grade = new JTextField();
		Grade.setBounds(181, 144, 126, 19);
		contentPane.add(Grade);
		Grade.setColumns(10);
		
		Dob = new JTextField();
		Dob.setBounds(514, 146, 126, 19);
		contentPane.add(Dob);
		Dob.setColumns(10);
		
		StudentPhone = new JTextField();
		StudentPhone.setBounds(181, 110, 126, 19);
		contentPane.add(StudentPhone);
		StudentPhone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Hobbies/Specialties");
		lblNewLabel_6.setBounds(53, 215, 167, 15);
		contentPane.add(lblNewLabel_6);
		
		final JTextArea Hobbies = new JTextArea();
		Hobbies.setWrapStyleWord(true);
		Hobbies.setBounds(53, 237, 254, 83);
		contentPane.add(Hobbies);
		
		JLabel lblNewLabel_7 = new JLabel("Mom Name");
		lblNewLabel_7.setBounds(53, 376, 119, 15);
		contentPane.add(lblNewLabel_7);
		
		MomName = new JTextField();
		MomName.setBounds(181, 374, 126, 19);
		contentPane.add(MomName);
		MomName.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mom Phone");
		lblNewLabel_8.setBounds(379, 374, 117, 15);
		contentPane.add(lblNewLabel_8);
		
		MomPhone = new JTextField();
		MomPhone.setBounds(516, 372, 126, 19);
		contentPane.add(MomPhone);
		MomPhone.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Mom Email");
		lblNewLabel_9.setBounds(53, 405, 108, 15);
		contentPane.add(lblNewLabel_9);
		
		MomEmail = new JTextField();
		MomEmail.setBounds(181, 403, 126, 19);
		contentPane.add(MomEmail);
		MomEmail.setColumns(10);
		
		JLabel lblDadName = new JLabel("Dad Name");
		lblDadName.setBounds(379, 407, 108, 15);
		contentPane.add(lblDadName);
		
		DadName = new JTextField();
		DadName.setBounds(516, 405, 126, 19);
		contentPane.add(DadName);
		DadName.setColumns(10);
		
		JLabel lblDadPhone = new JLabel("Dad Phone");
		lblDadPhone.setBounds(53, 435, 117, 15);
		contentPane.add(lblDadPhone);
		
		DadPhone = new JTextField();
		DadPhone.setBounds(181, 434, 126, 19);
		contentPane.add(DadPhone);
		DadPhone.setColumns(10);
		
		JLabel lblDadEmail = new JLabel("Dad Email");
		lblDadEmail.setBounds(379, 436, 70, 18);
		contentPane.add(lblDadEmail);
		
		DadEmail = new JTextField();
		DadEmail.setBounds(516, 436, 126, 20);
		contentPane.add(DadEmail);
		DadEmail.setColumns(10);
		
		
		
		JLabel lblNewLabel_10 = new JLabel("Student Picture");
		lblNewLabel_10.setBounds(379, 217, 132, 15);
		contentPane.add(lblNewLabel_10);
		
		final JLabel ShowPicture = new JLabel("Show Picture");
		ShowPicture.setBounds(516, 215, 126, 116);
		contentPane.add(ShowPicture);
		
		final JLabel ShowFilename = new JLabel("Show Filename");
		ShowFilename.setBounds(379, 285, 132, 22);
		contentPane.add(ShowFilename);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);
				File file=chooser.getSelectedFile();
				String path = file.getAbsolutePath();
				ImageIcon image=new ImageIcon(path);
				s=path;
				
				Rectangle rect=ShowPicture.getBounds();
				Image scaledimage=image.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
				image=new ImageIcon(scaledimage);
				ShowPicture.setIcon(image);
				
				String fname=file.getName();
				ShowFilename.setText(fname);
				
								
			}
		});
		btnNewButton.setBounds(379, 248, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lGender = new JLabel("Gender");
		lGender.setBounds(53, 343, 70, 15);
		contentPane.add(lGender);
		
		final JComboBox Gender = new JComboBox();
		Gender.setModel(new DefaultComboBoxModel(new String[] {"Boy", "Girl"}));
		Gender.setBounds(181, 341, 126, 19);
		contentPane.add(Gender);
		
		JLabel lAddress = new JLabel("Address");
		lAddress.setBounds(53, 182, 70, 15);
		contentPane.add(lAddress);
		
		Address = new JTextField();
		Address.setBounds(181, 181, 459, 19);
		contentPane.add(Address);
		Address.setColumns(10);
		
		JLabel lFaith = new JLabel("Acceptance of Jesus Christ as his/her personal Savior and Lord");
		lFaith.setBounds(53, 471, 447, 15);
		contentPane.add(lFaith);
		
		final JComboBox Faith = new JComboBox();
		Faith.setModel(new DefaultComboBoxModel(new String[] {"Not Sure", "Yes", "No"}));
		Faith.setBounds(514, 468, 126, 18);
		contentPane.add(Faith);
		
		JLabel lBaptizement = new JLabel("Baptizement");
		lBaptizement.setBounds(53, 501, 119, 15);
		contentPane.add(lBaptizement);
		
		final JComboBox Baptizement = new JComboBox();
		Baptizement.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		Baptizement.setBounds(181, 501, 126, 19);
		contentPane.add(Baptizement);
		
		final JComboBox EntMoveinMoveout = new JComboBox();
		EntMoveinMoveout.setModel(new DefaultComboBoxModel(new String[] {"Enterance Date", "MoveIn Date ", "MoveOut Date"}));
		EntMoveinMoveout.setBounds(378, 338, 120, 24);
		contentPane.add(EntMoveinMoveout);
		
		EntInOutDate = new JTextField();
		EntInOutDate.setBounds(516, 341, 126, 19);
		contentPane.add(EntInOutDate);
		EntInOutDate.setColumns(10);
		
		final JComboBox AwardPunish = new JComboBox();
		AwardPunish.setModel(new DefaultComboBoxModel(new String[] {"Award", "Punishment"}));
		AwardPunish.setBounds(379, 498, 119, 24);
		contentPane.add(AwardPunish);
		
		AwardPunContent = new JTextField();
		AwardPunContent.setBounds(516, 498, 126, 22);
		contentPane.add(AwardPunContent);
		AwardPunContent.setColumns(10);
		
		JButton btnInput = new JButton("Input New Student");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StudentFinanceQueries sq=new StudentFinanceQueries();
				
				int result=sq.addStudent(StudentID.getText(), StudentName.getText(), StudentPhone.getText(), StudentEmail.getText(), 
						Grade.getText(), Dob.getText(),
						Address.getText(), Hobbies.getText(), s, Gender.getSelectedItem().toString(), EntMoveinMoveout.getSelectedItem().toString(), EntInOutDate.getText(),
						MomName.getText(), MomPhone.getText(), MomEmail.getText(), DadName.getText(),
						DadPhone.getText(), DadEmail.getText(), Faith.getSelectedItem().toString(), Baptizement.getSelectedItem().toString(),
						AwardPunish.getSelectedItem().toString(), AwardPunContent.getText());
				
				if (result==1)
				{
					int choice = JOptionPane.showConfirmDialog(contentPane,
					        "Student Added!! Do you want to continue new student input?",
					        "Input continue confirmation",
					        JOptionPane.YES_NO_OPTION);
					if (choice==1)
						JOptionPane.showMessageDialog(contentPane, "Input Finished!", "Input Finished", JOptionPane.PLAIN_MESSAGE);
					StudentID.setText("");
					StudentName.setText("");
					StudentPhone.setText("");
					StudentEmail.setText(""); 
					Grade.setText("");
					Dob.setText("");
					Address.setText("");
					Hobbies.setText("");
					ShowPicture.setIcon(null);
					ShowFilename.setText("Show Filename");
					Gender.setSelectedIndex(0);
					EntMoveinMoveout.setSelectedIndex(0);
					EntInOutDate.setText("");
					MomName.setText("");
					MomPhone.setText("");
					MomEmail.setText("");
					DadName.setText("");
					DadPhone.setText("");
					DadEmail.setText("");
					Faith.setSelectedIndex(0);
					Baptizement.setSelectedIndex(0);
					AwardPunish.setSelectedIndex(0);
					AwardPunContent.setText("");
					
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Student not added!", "Error", JOptionPane.PLAIN_MESSAGE);   
				
			
			}
		});
		btnInput.setBounds(267, 532, 167, 25);
		contentPane.add(btnInput);
		
		JLabel JStudentID = new JLabel("StudentID");
		JStudentID.setBounds(53, 74, 95, 15);
		contentPane.add(JStudentID);
		
		StudentID = new JTextField();
		StudentID.setBounds(181, 72, 126, 19);
		contentPane.add(StudentID);
		StudentID.setColumns(10);
		
		
		
						
	}
}