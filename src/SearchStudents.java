import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;


public class SearchStudents extends JFrame {

	private JPanel contentPane;
	private List<Student> results;
	private int numberOfEntries=0;
	private Student currententry;
	private JTable table;
	private JTextField item;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchStudents frame = new SearchStudents();
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
	public SearchStudents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentSearch = new JLabel("Students Search");
		lblStudentSearch.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStudentSearch.setBounds(33, 12, 215, 31);
		contentPane.add(lblStudentSearch);
		
		JLabel lblEnterItem = new JLabel("Select Item to search: ");
		lblEnterItem.setBounds(33, 56, 146, 23);
		contentPane.add(lblEnterItem);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AllStudents", "StudentID", "Student_Name", "Grade", "Gender", "School_Enter", "Faith", "Baptizement", "Award_Punishment"}));
		comboBox.setBounds(170, 55, 168, 24);
		contentPane.add(comboBox);
		
		item = new JTextField();
		item.setBounds(355, 56, 152, 24);
		contentPane.add(item);
		item.setColumns(10);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results=sq.studentSearch(comboBox.getSelectedItem(), item.getText());
				numberOfEntries=results.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No Student Lists!!", "No Student Lists!", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{	
					final String[] colheads={"StudentID","StudentName","StudentPhone","StudentEmail","Grade","Dob","Address","Hobbies","Gender","EntMoveinMoveout",
								"EntInOutDate","MomName","MomPhone","MomEmail","DadName","DadPhone","DadEmail","Faith","Baptizement","AwardPunish","AwardPunContent"};                                        
                    String data[][]=new String[numberOfEntries][21];
                    
                    for(int i=0;i<numberOfEntries;i++)
                    {
                          currententry=results.get(i);
                          String str1=String.valueOf(currententry.getStudentID());
                          String str2=currententry.getStudentName();
                          String str3=currententry.getStudentPhone();
                          String str4=currententry.getStudentEmail();
                          String str5=String.valueOf(currententry.getGrade());
                          String str6=currententry.getDob();
                          String str7=currententry.getAddress();
                          String str8=currententry.getHobby();
                          String str9=currententry.getGender();
                          String str10=currententry.getEntMoveinMoveout();
                          String str11=currententry.getEntInOutDate();
                          String str12=currententry.getMomName();
                          String str13=currententry.getMomPhone();
                          String str14=currententry.getMomEmail();
                          String str15=currententry.getDadName();
                          String str16=currententry.getDadPhone();
                          String str17=currententry.getDadEmail();
                          String str18=currententry.getFaith();
                          String str19=currententry.getBaptizement();
                          String str20=currententry.getAwardPunish();
                          String str21=currententry.getAwardPunContent();
                                                                            
                          int k=0;                                                               
                          data[i][k]=str1;    k=k+1; 
                          data[i][k]=str2;    k=k+1;
                          data[i][k]=str3;    k=k+1;
                          data[i][k]=str4;    k=k+1;
                          data[i][k]=str5;    k=k+1;
                          data[i][k]=str6;    k=k+1;
                          data[i][k]=str7;    k=k+1;
                          data[i][k]=str8;    k=k+1;
                          data[i][k]=str9;    k=k+1;
                          data[i][k]=str10;   k=k+1;
                          data[i][k]=str11;   k=k+1;
                          data[i][k]=str12;   k=k+1;
                          data[i][k]=str13;   k=k+1;
                          data[i][k]=str14;   k=k+1;
                          data[i][k]=str15;   k=k+1;
                          data[i][k]=str16;   k=k+1;
                          data[i][k]=str17;   k=k+1;
                          data[i][k]=str18;   k=k+1;
                          data[i][k]=str19;   k=k+1;
                          data[i][k]=str20;   k=k+1;
                          data[i][k]=str21;   k=k+1;
                         
                    }
					
                    DefaultTableModel model=new DefaultTableModel(data,colheads);
                    JScrollPane scrollPane = new JScrollPane();
            		scrollPane.setBounds(34, 116, 1100, 214);
            		contentPane.add(scrollPane);
            		
                    table = new JTable(model);
            		scrollPane.setViewportView(table);
            		
            		           		
				}	
				
			}
		});
		btnSearch.setBounds(519, 55, 107, 25);
		contentPane.add(btnSearch);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPrint.setBounds(638, 55, 107, 25);
		contentPane.add(btnPrint);
		
		JButton btnNewButton = new JButton("Save into Excel File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				XSSFWorkbook workbook = new XSSFWorkbook(); 
				XSSFSheet spreadsheet=workbook.createSheet("Student List");
				XSSFRow row;
				String filename="";
								
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results=sq.studentSearch(comboBox.getSelectedItem(), item.getText());
				
				numberOfEntries=results.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No Student Lists!!", "No Student Lists!", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{	
					Map <String, Object[]> studentsearch=new TreeMap <String, Object[]>();
                  	studentsearch.put("1", new Object[] {"StudentID","StudentName","StudentPhone","StudentEmail","Grade","Dob","Address","Hobbies","Gender","EntMoveinMoveout",
							"EntInOutDate","MomName","MomPhone","MomEmail","DadName","DadPhone","DadEmail","Faith","Baptizement","AwardPunish","AwardPunContent"});
					
                    for(int i=0;i<numberOfEntries;i++)
                    {
                    	currententry=results.get(i);
                        String str1=String.valueOf(currententry.getStudentID());
                        String str2=currententry.getStudentName();
                        String str3=currententry.getStudentPhone();
                        String str4=currententry.getStudentEmail();
                        String str5=String.valueOf(currententry.getGrade());
                        String str6=currententry.getDob();
                        String str7=currententry.getAddress();
                        String str8=currententry.getHobby();
                        String str9=currententry.getGender();
                        String str10=currententry.getEntMoveinMoveout();
                        String str11=currententry.getEntInOutDate();
                        String str12=currententry.getMomName();
                        String str13=currententry.getMomPhone();
                        String str14=currententry.getMomEmail();
                        String str15=currententry.getDadName();
                        String str16=currententry.getDadPhone();
                        String str17=currententry.getDadEmail();
                        String str18=currententry.getFaith();
                        String str19=currententry.getBaptizement();
                        String str20=currententry.getAwardPunish();
                        String str21=currententry.getAwardPunContent();
                          
                          studentsearch.put(String.valueOf(i+2), new Object[] 
                        		  {
                        	         str1, 
                                     str2,
                                     str3, 
                                     str4,
                                     str5,
                                     str6,
                                     str7,
                                     str8,
                                     str9,
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
                                                    	  
                        		  }
                          );
                         Set <String> keyid=studentsearch.keySet();
                         int rowid=0;
                         
                         for(String key:keyid)
                         {
                        	 row=spreadsheet.createRow(rowid++);
                        	 Object[] objectArr=studentsearch.get(key);
                        	 int cellid=0;
                        	 for(Object obj:objectArr)
                        	 {
                        		 Cell cell=row.createCell(cellid++);
                        		 cell.setCellValue((String)obj);
                        	 }
                        	 
                        	 FileOutputStream out=null;
							try {
								filename=comboBox.getSelectedItem()+"_"+item.getText()+".xlsx";
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
				JOptionPane.showMessageDialog(rootPane, filename+" written successfully", filename+" written successfully", JOptionPane.PLAIN_MESSAGE);	
			}
		});
		btnNewButton.setBounds(757, 55, 152, 25);
		contentPane.add(btnNewButton);
		
	}
}
