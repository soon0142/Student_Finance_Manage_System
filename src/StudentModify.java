import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class StudentModify extends JFrame {

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
	String s=null;
	private JTextField StudentID;
	private Student currententry;
	private JTextField EntInOutDate;
	private JTextField AwardPunContent;
	private List<Student> results1;
	private int numberOfEntries=0;
	private Student currententry1;
	private int results2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentModify frame = new StudentModify();
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
	public StudentModify() {
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
		
		JMenuItem mntmInputStudent = new JMenuItem("Input Student");
		mntmInputStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				StudentDisplay student=new StudentDisplay();
				student.setVisible(true);
			}
		});
		mnInput.add(mntmInputStudent);
		
		JMenu mnModifyAndDelete = new JMenu("Modify and Delete");
		mnModifyAndDelete.setMnemonic('M');
		menuBar.add(mnModifyAndDelete);
		
		JMenuItem mntmModify = new JMenuItem("Modify");
		mnModifyAndDelete.add(mntmModify);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				StudentDelete delete=new StudentDelete();
				delete.setVisible(true);
			}
		});
		mnModifyAndDelete.add(mntmDelete);
		
		JMenu mnNewMenu = new JMenu("Search and Print");
		mnNewMenu.setMnemonic('S');
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStudents search=new SearchStudents();
				search.setVisible(true);
			}
		});
		mnNewMenu.add(mntmSearch);
		
		JMenu mnDataManagement = new JMenu("Data Management");
		mnDataManagement.setMnemonic('D');
		menuBar.add(mnDataManagement);
		
		JMenuItem mntmBackup = new JMenuItem("Backup");
		mntmBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XSSFWorkbook workbook = new XSSFWorkbook(); 
				XSSFSheet spreadsheet=workbook.createSheet("Backup student file");
				XSSFRow row;
				String filename="";
								
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results1=sq.backupstudentfile();
				numberOfEntries=results1.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No Student Lists!!", "No Student Lists!", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{	
					Map <String, Object[]> backupstudentlists=new TreeMap <String, Object[]>();
                  	backupstudentlists.put("1", new Object[] {"StudentID","StudentName","StudentPhone","StudentEmail","Grade","Dob","Address","Hobbies","Gender",
							"EntMoveinMoveout","EntInOutDate","MomName","MomPhone","MomEmail","DadName","DadPhone","DadEmail","Faith","Baptizement","AwardPunish","AwardPunContent"});
					                  	
                  	
                    for(int i=0;i<numberOfEntries;i++)
                    {
                          currententry1=results1.get(i);
                          String str1=String.valueOf(currententry1.getStudentID());
                          String str2=currententry1.getStudentName();
                          String str3=currententry1.getStudentPhone();
                          String str4=currententry1.getStudentEmail();
                          String str5=String.valueOf(currententry1.getGrade());
                          String str6=currententry1.getDob();
                          String str7=currententry1.getAddress();
                          String str8=currententry1.getHobby();
                          String str10=currententry1.getGender();
                          String str11=currententry1.getEntMoveinMoveout();
                          String str12=currententry1.getEntInOutDate();
                          String str13=currententry1.getMomName();
                          String str14=currententry1.getMomPhone();
                          String str15=currententry1.getMomEmail();
                          String str16=currententry1.getDadName();
                          String str17=currententry1.getDadPhone();
                          String str18=currententry1.getDadEmail();
                          String str19=currententry1.getFaith();
                          String str20=currententry1.getBaptizement();
                          String str21=currententry1.getAwardPunish();
                          String str22=currententry1.getAwardPunContent();
                         
                          
                          backupstudentlists.put(String.valueOf(i+2), new Object[] 
                        		  {
                        	         str1, 
                                     str2,
                                     str3, 
                                     str4,
                                     str5,
                                     str6,
                                     str7,
                                     str8,
                                     str10,
                                     str11,
                                     str12,
                                     str13,
                                     str14,
                                     str15,
                                     str16,
                                     str17,
                                     str18,
                                     str19,
                                     str20,
                                     str21,
                                     str22
                           		  }
                          );
                         Set <String> keyid=backupstudentlists.keySet();
                         int rowid=0;
                         
                         for(String key:keyid)
                         {
                        	 row=spreadsheet.createRow(rowid++);
                        	 Object[] objectArr=backupstudentlists.get(key);
                        	 int cellid=0;
                        	 for(Object obj:objectArr)
                        	 {
                        		 Cell cell=row.createCell(cellid++);
                        		 cell.setCellValue((String)obj);
                        	 }
                        	 
                        	 FileOutputStream out=null;
							try {
								filename="studentbackup.xlsx";
								out = new FileOutputStream(new File(filename));
							} catch (FileNotFoundException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
                        	 try {
								workbook.write(out);
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
                        	 try {
								out.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                        	 
                         }
                        
                    } 
				}	
				JOptionPane.showMessageDialog(rootPane, "Successfully backup into "+filename, "Successfully backup into "+filename, JOptionPane.PLAIN_MESSAGE);	
				
			}
		});
		mnDataManagement.add(mntmBackup);
		
		JMenuItem mntmRestore = new JMenuItem("Restore");
		mntmRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFinanceQueries sq=new StudentFinanceQueries();
				int results3=sq.deletestudentall();
				if (results3==0)
					JOptionPane.showMessageDialog(rootPane, "No Data", "No Data", JOptionPane.PLAIN_MESSAGE);
				else
				{	JOptionPane.showMessageDialog(rootPane, "All Data was deleted", "All Data was deleted", JOptionPane.PLAIN_MESSAGE);}
								
				{	FileInputStream fileIn=null;
					try {
						fileIn = new FileInputStream(new File("studentbackup.xlsx"));
					} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					XSSFWorkbook wb=null;
					try {
						wb = new XSSFWorkbook(fileIn);
					} catch (IOException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					XSSFSheet sheet=wb.getSheetAt(0);
					Row row;
												
					for(int i=1; i<=sheet.getLastRowNum(); i++)
					{	
						row=sheet.getRow(i);
						String col1=row.getCell(0).getStringCellValue();
						String col2=row.getCell(1).getStringCellValue();
						String col3=row.getCell(2).getStringCellValue();
						String col4=row.getCell(3).getStringCellValue();
						String col5=row.getCell(4).getStringCellValue();
						String col6=row.getCell(5).getStringCellValue();
						String col7=row.getCell(6).getStringCellValue();
						String col8=row.getCell(7).getStringCellValue();
						String col9=row.getCell(8).getStringCellValue();
						String col10=row.getCell(9).getStringCellValue();
						String col11=row.getCell(10).getStringCellValue();
						String col12=row.getCell(11).getStringCellValue();
						String col13=row.getCell(12).getStringCellValue();
						String col14=row.getCell(13).getStringCellValue();
						String col15=row.getCell(14).getStringCellValue();
						String col16=row.getCell(15).getStringCellValue();
						String col17=row.getCell(16).getStringCellValue();
						String col18=row.getCell(17).getStringCellValue();
						String col19=row.getCell(18).getStringCellValue();
						String col20=row.getCell(19).getStringCellValue();
						String col21=row.getCell(20).getStringCellValue();
						
						StudentFinanceQueries sq1=new StudentFinanceQueries();
						results2=sq1.restorestudentfile(col1, col2, col3, col4, col5, col6, col7, col8, col9, 
								col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, 
								col20, col21);
					}
					
					if (results2==0)
					{
						JOptionPane.showMessageDialog(rootPane, "Restoring Failed", "Restoring Failed", JOptionPane.PLAIN_MESSAGE);	
					}
					else 
					{	
						JOptionPane.showMessageDialog(rootPane, "Successfully was restored!!", "Successfully was restored!!", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		mnDataManagement.add(mntmRestore);
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
		EntMoveinMoveout.setModel(new DefaultComboBoxModel(new String[] {"Enterance Date", "Move In Date "}));
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
		
		JButton btnInput = new JButton("Modify");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StudentFinanceQueries sq=new StudentFinanceQueries();
				
				int result=sq.modifyStudent(StudentID.getText(), StudentName.getText(), StudentPhone.getText(), StudentEmail.getText(), 
						Grade.getText(), Dob.getText(),
						Address.getText(), Hobbies.getText(), s, Gender.getSelectedItem().toString(), EntMoveinMoveout.getSelectedItem().toString(), EntInOutDate.getText(),
						MomName.getText(), MomPhone.getText(), MomEmail.getText(), DadName.getText(),
						DadPhone.getText(), DadEmail.getText(), Faith.getSelectedItem().toString(), Baptizement.getSelectedItem().toString(),
						AwardPunish.getSelectedItem().toString(), AwardPunContent.getText());
				
				if (result==1)
				{
					int choice = JOptionPane.showConfirmDialog(contentPane,
					        "Student Modified! Do you want to modify new student?",
					        "Modify continue confirmation",
					        JOptionPane.YES_NO_OPTION);
					if (choice==1)
						JOptionPane.showMessageDialog(contentPane, "Modify Finished!", "Modify Finished", JOptionPane.PLAIN_MESSAGE);
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
					JOptionPane.showMessageDialog(contentPane, "Student is not modified", "Error", JOptionPane.PLAIN_MESSAGE);   
				
			
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
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results1=sq.findStudentInfo(StudentID.getText());
				numberOfEntries=results1.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No StudentID!! Please Input Student Information First!!", "No StudentID!", JOptionPane.PLAIN_MESSAGE);
					close();
					StudentDisplay student=new StudentDisplay();
					student.setVisible(true);
				}
				else 
				{	
					currententry=results1.get(0);
					StudentID.setText(String.valueOf(currententry.getStudentID()));
					StudentName.setText(currententry.getStudentName());
					StudentEmail.setText(currententry.getStudentEmail());
					Grade.setText(String.valueOf(currententry.getGrade()));
					Dob.setText(currententry.getDob());
					Address.setText(currententry.getAddress());
					Hobbies.setText(currententry.getHobby());
					
					byte[] imageByte;
					imageByte= currententry.getStudentPhoto();
					BufferedImage imag=null;
					if (imageByte!=null){
						InputStream is=new ByteArrayInputStream(imageByte);
							try {
								imag = ImageIO.read(is);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							
							}
					                   
					Image image = imag;
                    Image img = Toolkit.getDefaultToolkit().createImage(imageByte);
                    img = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
                	ImageIcon icon =new ImageIcon(img);
                	ShowPicture.setIcon(icon) ;  }
				 }
				
						
                	Gender.setSelectedItem(currententry.getGender());
					EntMoveinMoveout.setSelectedItem(currententry.getEntMoveinMoveout());
					EntInOutDate.setText(currententry.getEntInOutDate());
					MomName.setText(currententry.getMomName());
					MomPhone.setText(currententry.getMomPhone());
					MomEmail.setText(currententry.getMomEmail());
					DadName.setText(currententry.getDadName());
					DadPhone.setText(currententry.getDadPhone());
					DadEmail.setText(currententry.getDadEmail());
					Faith.setSelectedItem(currententry.getFaith());
					Baptizement.setSelectedItem(currententry.getBaptizement());
					AwardPunish.setSelectedItem(currententry.getAwardPunish());
					AwardPunContent.setText(currententry.getAwardPunContent());
									
				}	
				
			
		});
		btnFind.setBounds(312, 71, 61, 19);
		contentPane.add(btnFind);
		
		JLabel lblinputStudentidAnd = new JLabel("*Input StudentID,  and then click Find button");
		lblinputStudentidAnd.setFont(new Font("Dialog", Font.ITALIC, 10));
		lblinputStudentidAnd.setBounds(53, 47, 602, 15);
		contentPane.add(lblinputStudentidAnd);
		
		
		
						
	}
}
