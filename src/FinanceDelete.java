import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FinanceDelete extends JFrame {

	private JTextField pYear;
	private JTextField pMonth;
	private JTextField StudentID;
	private JTextField StudentName;
	private JTextField mTuition;
	private JTextField BookCost;
	private JTextField T1;
	private JTextField T1Cost;
	private JTextField T2;
	private JTextField T2Cost;
	private JTextField T3;
	private JTextField T3Cost;
	private JTextField T4;
	private JTextField T4Cost;
	private JTextField T5;
	private JTextField T5Cost;
	private JTextField T6;
	private JTextField T6Cost;
	private JTextField T7;
	private JTextField T7Cost;
	private JTextField T8;
	private JTextField T8Cost;
	private JTextField T9;
	private JTextField T9Cost;
	private JTextField TotalCost;
	private JLabel lblScholarshipName;
	private JTextField Scholarship;
	private JButton btnNewButton;
	
	private List<Finance> results1;
	private int results2;
	private Student currententry;
	private Finance currententry1;
	private int numberOfEntries=0;
	private JMenu mnSearch;
	private JMenuItem mntmStudentPaymentList;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmFinanceInput;
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinanceDelete frame = new FinanceDelete();
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
public void close(){
		
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public FinanceDelete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 527);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInput = new JMenu("Input");
		mnInput.setMnemonic('I');
		menuBar.add(mnInput);
		
		JMenuItem mntmStudentInput = new JMenuItem("Student Input");
		mntmStudentInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				StudentDisplay student=new StudentDisplay();
				student.setVisible(true);
				
			}
			
		});
		mnInput.add(mntmStudentInput);
		
		mntmFinanceInput = new JMenuItem("Finance Input");
		mntmFinanceInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				FinanceDisplay finance=new FinanceDisplay();
				finance.setVisible(true);			
				
			}
		});
		mnInput.add(mntmFinanceInput);
		
		JMenu mnModify = new JMenu("Modify And Delete");
		mnModify.setMnemonic('M');
		menuBar.add(mnModify);
		
		JMenuItem mntmModify = new JMenuItem("Modify");
		mntmModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				FinanceModify modify=new FinanceModify();
				modify.setVisible(true);
			}
		});
		mnModify.add(mntmModify);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				FinanceDelete delete=new FinanceDelete();
				delete.setVisible(true);
			}
		});
		mnModify.add(mntmDelete);
		
		mnSearch = new JMenu("Search And Print");
		mnSearch.setMnemonic('S');
		menuBar.add(mnSearch);
		
		mntmStudentPaymentList = new JMenuItem("Student Payment Lists");
		mntmStudentPaymentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStudentPayment ssp=new SearchStudentPayment();
				ssp.setVisible(true);
			}
		});
		mnSearch.add(mntmStudentPaymentList);
		
		mntmNewMenuItem = new JMenuItem("Monthly Payment Lists");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMonthYear smy=new SearchMonthYear();
				smy.setVisible(true);
			}
		});
		mnSearch.add(mntmNewMenuItem);
		
		JMenu datamanagement = new JMenu("Data Management");
		datamanagement.setMnemonic('D');
		menuBar.add(datamanagement);
		
		JMenuItem backup = new JMenuItem("Backup");
		backup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XSSFWorkbook workbook = new XSSFWorkbook(); 
				XSSFSheet spreadsheet=workbook.createSheet("Backup file");
				XSSFRow row;
				String filename="";
								
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results1=sq.backupfile();
				numberOfEntries=results1.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No Payment Lists!!", "No Payment Lists!", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{	
					Map <String, Object[]> backuplists=new TreeMap <String, Object[]>();
                  	backuplists.put("1", new Object[] {"PaymentID","PaymentYear","PaymentMonth","MonthlyTuition","CostOfBooks","T1","T1Cost","T2","T2Cost","T3","T3Cost",
							"T4","T4Cost","T5","T5Cost","T6","T6Cost","T7","T7Cost","T8","T8Cost","T9","T9Cost","TotalCost","Scholarship","StudentID","StudentName"});
					
                    for(int i=0;i<numberOfEntries;i++)
                    {
                          currententry1=results1.get(i);
                          String str1=String.valueOf(currententry1.getPaymentID());
                          String str2=String.valueOf(currententry1.getpYear());
                          String str3=String.valueOf(currententry1.getpMonth());
                          String str4=String.valueOf(currententry1.getmTuition());
                          String str5=String.valueOf(currententry1.getBookCost());
                          String str6=currententry1.getT1();
                          String str7=String.valueOf(currententry1.getT1Cost());
                          String str8=currententry1.getT2();
                          String str9=String.valueOf(currententry1.getT2Cost());
                          String str10=currententry1.getT3();
                          String str11=String.valueOf(currententry1.getT3Cost());
                          String str12=currententry1.getT4();
                          String str13=String.valueOf(currententry1.getT4Cost());
                          String str14=currententry1.getT5();
                          String str15=String.valueOf(currententry1.getT5Cost());
                          String str16=currententry1.getT6();
                          String str17=String.valueOf(currententry1.getT6Cost());
                          String str18=currententry1.getT7();
                          String str19=String.valueOf(currententry1.getT7Cost());
                          String str20=currententry1.getT8();
                          String str21=String.valueOf(currententry1.getT8Cost());
                          String str22=currententry1.getT9();
                          String str23=String.valueOf(currententry1.getT9Cost());
                          String str24=String.valueOf(currententry1.getTotalCost());
                          String str25=currententry1.getScholarship();
                          String str26=String.valueOf(currententry1.getStudentID());
                          String str27=currententry1.getStudentName();
                          
                          
                          backuplists.put(String.valueOf(i+2), new Object[] 
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
                                     str22,
                                     str23,
                                     str24,
                                     str25,
                                     str26,
                                     str27
                        		  }
                          );
                         Set <String> keyid=backuplists.keySet();
                         int rowid=0;
                         
                         for(String key:keyid)
                         {
                        	 row=spreadsheet.createRow(rowid++);
                        	 Object[] objectArr=backuplists.get(key);
                        	 int cellid=0;
                        	 for(Object obj:objectArr)
                        	 {
                        		 Cell cell=row.createCell(cellid++);
                        		 cell.setCellValue((String)obj);
                        	 }
                        	 
                        	 FileOutputStream out=null;
							try {
								filename="backup.xlsx";
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
		datamanagement.add(backup);
		
		JMenuItem restore = new JMenuItem("Restore");
		restore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentFinanceQueries sq=new StudentFinanceQueries();
				int results3=sq.deleteall();
				if (results3==0)
					JOptionPane.showMessageDialog(rootPane, "No Data", "No Data", JOptionPane.PLAIN_MESSAGE);
				else
				{	JOptionPane.showMessageDialog(rootPane, "All Data was deleted", "All Data was deleted", JOptionPane.PLAIN_MESSAGE);}
								
				{	FileInputStream fileIn=null;
					try {
						fileIn = new FileInputStream(new File("backup.xlsx"));
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
					{	row=sheet.getRow(i);
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
						String col22=row.getCell(21).getStringCellValue();
						String col23=row.getCell(22).getStringCellValue();
						String col24=row.getCell(23).getStringCellValue();
						String col25=row.getCell(24).getStringCellValue();
						String col26=row.getCell(25).getStringCellValue();
						String col27=row.getCell(26).getStringCellValue();
						
						StudentFinanceQueries sq1=new StudentFinanceQueries();
						results2=sq1.restorefile(col1, col2, col3, col4, col5, col6, col7, col8, col9, 
								col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, 
								col20, col21, col22, col23, col24, col25, col26, col27);
						
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
		datamanagement.add(restore);
		getContentPane().setLayout(null);
		
		JLabel lblFinanceManagement = new JLabel("Finance Management");
		lblFinanceManagement.setFont(new Font("Dialog", Font.BOLD, 28));
		lblFinanceManagement.setBounds(192, 12, 359, 46);
		getContentPane().add(lblFinanceManagement);
		
		JLabel lpYear = new JLabel("Payment Year(yyyy)");
		lpYear.setBounds(41, 71, 154, 27);
		getContentPane().add(lpYear);
		
		pYear = new JTextField();
		pYear.setBounds(202, 75, 114, 19);
		getContentPane().add(pYear);
		pYear.setColumns(10);
		
		JLabel lpMonth = new JLabel("Payment Month(mm)");
		lpMonth.setBounds(368, 72, 154, 26);
		getContentPane().add(lpMonth);
		
		pMonth = new JTextField();
		pMonth.setBounds(524, 75, 119, 19);
		getContentPane().add(pMonth);
		pMonth.setColumns(10);
		
		JLabel lblStudentid = new JLabel("StudentID");
		lblStudentid.setBounds(40, 110, 80, 15);
		getContentPane().add(lblStudentid);
		
		StudentID = new JTextField();
		StudentID.setBounds(120, 108, 114, 19);
		getContentPane().add(StudentID);
		StudentID.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results1=sq.findFinanceInfo(pYear.getText(),pMonth.getText(),StudentID.getText());
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
					currententry1=results1.get(0);
					pYear.setText(String.valueOf(currententry1.getpYear()));
					pMonth.setText(String.valueOf(currententry1.getpMonth()));
					mTuition.setText(String.valueOf(currententry1.getmTuition()));
					BookCost.setText(String.valueOf(currententry1.getBookCost()));
					T1.setText(currententry1.getT1());
					T1Cost.setText(String.valueOf(currententry1.getT1Cost()));
					T2.setText(currententry1.getT2());
					T2Cost.setText(String.valueOf(currententry1.getT2Cost()));
					T3.setText(currententry1.getT3());
					T3Cost.setText(String.valueOf(currententry1.getT3Cost()));
					T4.setText(currententry1.getT4());
					T4Cost.setText(String.valueOf(currententry1.getT4Cost()));
					T5.setText(currententry1.getT5());
					T5Cost.setText(String.valueOf(currententry1.getT5Cost()));
					T6.setText(currententry1.getT6());
					T6Cost.setText(String.valueOf(currententry1.getT6Cost()));
					T7.setText(currententry1.getT7());
					T7Cost.setText(String.valueOf(currententry1.getT7Cost()));
					T8.setText(currententry1.getT8());
					T8Cost.setText(String.valueOf(currententry1.getT8Cost()));
					T9.setText(currententry1.getT9());
					T9Cost.setText(String.valueOf(currententry1.getT9Cost()));
					TotalCost.setText(String.valueOf(currententry1.getTotalCost()));
					Scholarship.setText(currententry1.getScholarship());	
					StudentID.setText(String.valueOf(currententry1.getStudentID()));
					StudentName.setText(currententry1.getStudentName());
					
				}	
			}
		});
		btnFind.setBounds(252, 106, 64, 19);
		getContentPane().add(btnFind);
		
		JLabel lStudentName = new JLabel("Student Name");
		lStudentName.setBounds(368, 110, 154, 15);
		getContentPane().add(lStudentName);
		
		StudentName = new JTextField();
		StudentName.setBounds(524, 108, 119, 19);
		getContentPane().add(StudentName);
		StudentName.setColumns(10);
		
		JLabel lblMonthlyTuition = new JLabel("Monthly Tuition");
		lblMonthlyTuition.setBounds(41, 147, 135, 15);
		getContentPane().add(lblMonthlyTuition);
		
		mTuition = new JTextField();
		mTuition.setText("0");
		mTuition.setHorizontalAlignment(SwingConstants.RIGHT);
		mTuition.setBounds(202, 145, 114, 19);
		getContentPane().add(mTuition);
		mTuition.setColumns(10);
		
		JLabel lblCostOfBooks = new JLabel("Cost Of Books");
		lblCostOfBooks.setBounds(368, 147, 154, 15);
		getContentPane().add(lblCostOfBooks);
		
		BookCost = new JTextField();
		BookCost.setText("0");
		BookCost.setHorizontalAlignment(SwingConstants.RIGHT);
		BookCost.setBounds(524, 145, 119, 19);
		getContentPane().add(BookCost);
		BookCost.setColumns(10);
		
		T1 = new JTextField();
		T1.setBounds(41, 184, 148, 19);
		getContentPane().add(T1);
		T1.setColumns(10);
		
		T1Cost = new JTextField();
		T1Cost.setText("0");
		T1Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T1Cost.setBounds(202, 182, 114, 19);
		getContentPane().add(T1Cost);
		T1Cost.setColumns(10);
		
		T2 = new JTextField();
		T2.setBounds(368, 184, 143, 19);
		getContentPane().add(T2);
		T2.setColumns(10);
		
		T2Cost = new JTextField();
		T2Cost.setText("0");
		T2Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T2Cost.setBounds(524, 184, 119, 19);
		getContentPane().add(T2Cost);
		T2Cost.setColumns(10);
		
		T3 = new JTextField();
		T3.setBounds(41, 224, 148, 19);
		getContentPane().add(T3);
		T3.setColumns(10);
		
		T3Cost = new JTextField();
		T3Cost.setText("0");
		T3Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T3Cost.setBounds(202, 224, 114, 19);
		getContentPane().add(T3Cost);
		T3Cost.setColumns(10);
		
		T4 = new JTextField();
		T4.setBounds(368, 224, 143, 19);
		getContentPane().add(T4);
		T4.setColumns(10);
		
		T4Cost = new JTextField();
		T4Cost.setText("0");
		T4Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T4Cost.setBounds(524, 223, 119, 19);
		getContentPane().add(T4Cost);
		T4Cost.setColumns(10);
		
		T5 = new JTextField();
		T5.setBounds(41, 261, 148, 19);
		getContentPane().add(T5);
		T5.setColumns(10);
		
		T5Cost = new JTextField();
		T5Cost.setText("0");
		T5Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T5Cost.setBounds(202, 261, 114, 19);
		getContentPane().add(T5Cost);
		T5Cost.setColumns(10);
		
		T6 = new JTextField();
		T6.setBounds(368, 261, 143, 19);
		getContentPane().add(T6);
		T6.setColumns(10);
		
		T6Cost = new JTextField();
		T6Cost.setText("0");
		T6Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T6Cost.setBounds(524, 261, 119, 19);
		getContentPane().add(T6Cost);
		T6Cost.setColumns(10);
		
		T7 = new JTextField();
		T7.setBounds(41, 300, 148, 19);
		getContentPane().add(T7);
		T7.setColumns(10);
		
		T7Cost = new JTextField();
		T7Cost.setText("0");
		T7Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T7Cost.setBounds(202, 300, 114, 19);
		getContentPane().add(T7Cost);
		T7Cost.setColumns(10);
		
		T8 = new JTextField();
		T8.setBounds(368, 300, 143, 19);
		getContentPane().add(T8);
		T8.setColumns(10);
		
		T8Cost = new JTextField();
		T8Cost.setText("0");
		T8Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T8Cost.setBounds(524, 300, 119, 19);
		getContentPane().add(T8Cost);
		T8Cost.setColumns(10);
		
		T9 = new JTextField();
		T9.setBounds(41, 341, 148, 19);
		getContentPane().add(T9);
		T9.setColumns(10);
		
		T9Cost = new JTextField();
		T9Cost.setText("0");
		T9Cost.setHorizontalAlignment(SwingConstants.RIGHT);
		T9Cost.setBounds(202, 341, 114, 19);
		getContentPane().add(T9Cost);
		T9Cost.setColumns(10);
		
		TotalCost = new JTextField();
		TotalCost.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalCost.setBounds(368, 383, 143, 19);
		getContentPane().add(TotalCost);
		TotalCost.setColumns(10);
		
		lblScholarshipName = new JLabel("Scholarship Name");
		lblScholarshipName.setBounds(368, 343, 148, 15);
		getContentPane().add(lblScholarshipName);
		
		Scholarship = new JTextField();
		Scholarship.setBounds(524, 341, 119, 19);
		getContentPane().add(Scholarship);
		Scholarship.setColumns(10);
		
		JButton btnCalculateT = new JButton("Calculate Total Cost");
		btnCalculateT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int tot=0;
				 tot=Integer.parseInt(mTuition.getText())+Integer.parseInt(BookCost.getText())+Integer.parseInt(T1Cost.getText())+
				     Integer.parseInt(T2Cost.getText())+Integer.parseInt(T3Cost.getText())+Integer.parseInt(T4Cost.getText())+
				     Integer.parseInt(T5Cost.getText())+Integer.parseInt(T6Cost.getText())+Integer.parseInt(T7Cost.getText())+
				     Integer.parseInt(T8Cost.getText())+Integer.parseInt(T9Cost.getText());
				 TotalCost.setText(Integer.toString(tot));	 
			}
		});
		btnCalculateT.setBounds(41, 380, 275, 22);
		getContentPane().add(btnCalculateT);
		
		
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StudentFinanceQueries sq=new StudentFinanceQueries();
				
				int result=sq.deleteFinance(pYear.getText(), pMonth.getText(), StudentID.getText(), StudentName.getText());
						
				if (result!=0)
					JOptionPane.showMessageDialog(getContentPane(), "Finance Infomation was deleted!", "Finance Infomation was deleted!", JOptionPane.PLAIN_MESSAGE);
				else
					JOptionPane.showMessageDialog(getContentPane(), "Finance Infomation not deleted!", "Error", JOptionPane.PLAIN_MESSAGE); 
				
					StudentID.setText("");
					StudentName.setText("");
					pYear.setText("");
					pMonth.setText("");
					mTuition.setText("");
					BookCost.setText("");
					T1.setText("");
					T1Cost.setText("0");
					T2.setText("");
					T2Cost.setText("0");
					T3.setText("");
					T3Cost.setText("0");
					T4.setText("");
					T4Cost.setText("0");
					T5.setText("");
					T5Cost.setText("0");
					T6.setText("");
					T6Cost.setText("0");
					T7.setText("");
					T7Cost.setText("0");
					T8.setText("");
					T8Cost.setText("0");
					T9.setText("");
					T9Cost.setText("0");
					TotalCost.setText("0");
					Scholarship.setText(""); 		
				
			}
					
		});
		btnNewButton.setBounds(281, 430, 143, 25);
		getContentPane().add(btnNewButton);
		
		label = new JLabel("*Input Payment Year, Payment Month, and StudentID,  and then click Find button");
		label.setFont(new Font("Dialog", Font.ITALIC, 10));
		label.setBounds(41, 55, 602, 15);
		getContentPane().add(label);
			
		
	}
}


