import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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


public class SearchStudentPayment extends JFrame {

	private JPanel contentPane;
	private JTextField tStudentID;
	private JTextField tStudentName;
	private List<Finance> results;
	private int numberOfEntries=0;
	private Finance currententry;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchStudentPayment frame = new SearchStudentPayment();
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
	public SearchStudentPayment() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyPaymentSearch = new JLabel("Student Payment Search");
		lblMonthlyPaymentSearch.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMonthlyPaymentSearch.setBounds(33, 12, 215, 31);
		contentPane.add(lblMonthlyPaymentSearch);
		
		JLabel lblEnterStudentID = new JLabel("Enter StudentID:");
		lblEnterStudentID.setBounds(33, 56, 107, 23);
		contentPane.add(lblEnterStudentID);
		
		tStudentID = new JTextField();
		tStudentID.setBounds(150, 55, 78, 23);
		contentPane.add(tStudentID);
		tStudentID.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Enter Student Name:");
		lblStudentName.setBounds(246, 55, 134, 23);
		contentPane.add(lblStudentName);
		
		tStudentName = new JTextField();
		tStudentName.setBounds(398, 55, 152, 23);
		contentPane.add(tStudentName);
		tStudentName.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results=sq.studentpayment(tStudentID.getText(),tStudentName.getText());
				numberOfEntries=results.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No Payment Lists!!", "No Payment Lists!", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{	
					final String[] colheads={"StudentID","StudentName","PaymentYear","PaymentMonth","MonthlyTuition","CostOfBooks","T1","T1Cost","T2","T2Cost","T3","T3Cost",
								"T4","T4Cost","T5","T5Cost","T6","T6Cost","T7","T7Cost","T8","T8Cost","T9","T9Cost","TotalCost","Scholarship"};                                        
                    String data[][]=new String[numberOfEntries][26];
                    
                    for(int i=0;i<numberOfEntries;i++)
                    {
                          currententry=results.get(i);
                          String str1=String.valueOf(currententry.getStudentID());
                          String str2=currententry.getStudentName();
                          String str3=String.valueOf(currententry.getpYear());
                          String str4=String.valueOf(currententry.getpMonth());
                          String str5=String.valueOf(currententry.getmTuition());
                          String str6=String.valueOf(currententry.getBookCost());
                          String str7=currententry.getT1();
                          String str8=String.valueOf(currententry.getT1Cost());
                          String str9=currententry.getT2();
                          String str10=String.valueOf(currententry.getT2Cost());
                          String str11=currententry.getT3();
                          String str12=String.valueOf(currententry.getT3Cost());
                          String str13=currententry.getT4();
                          String str14=String.valueOf(currententry.getT4Cost());
                          String str15=currententry.getT5();
                          String str16=String.valueOf(currententry.getT5Cost());
                          String str17=currententry.getT6();
                          String str18=String.valueOf(currententry.getT6Cost());
                          String str19=currententry.getT7();
                          String str20=String.valueOf(currententry.getT7Cost());
                          String str21=currententry.getT8();
                          String str22=String.valueOf(currententry.getT8Cost());
                          String str23=currententry.getT9();
                          String str24=String.valueOf(currententry.getT9Cost());
                          String str25=String.valueOf(currententry.getTotalCost());
                          String str26=currententry.getScholarship();
                                                  
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
                          data[i][k]=str22;   k=k+1;
                          data[i][k]=str23;   k=k+1;
                          data[i][k]=str24;   k=k+1;
                          data[i][k]=str25;   k=k+1;
                          data[i][k]=str26;   k=k+1;
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
		btnSearch.setBounds(582, 56, 107, 25);
		contentPane.add(btnSearch);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results=sq.studentpayment(tStudentID.getText(),tStudentName.getText());
				numberOfEntries=results.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No Payment Lists!!", "No Payment Lists!", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{	
					final String[] colheads={"StudentID","StudentName","PaymentYear","PaymentMonth","MonthlyTuition","CostOfBooks","T1","T1Cost","T2","T2Cost","T3","T3Cost",
								"T4","T4Cost","T5","T5Cost","T6","T6Cost","T7","T7Cost","T8","T8Cost","T9","T9Cost","TotalCost","Scholarship"};                                        
                    String data[][]=new String[numberOfEntries][26];
                    
                    for(int i=0;i<numberOfEntries;i++)
                    {
                          currententry=results.get(i);
                          String str1=String.valueOf(currententry.getStudentID());
                          String str2=currententry.getStudentName();
                          String str3=String.valueOf(currententry.getpYear());
                          String str4=String.valueOf(currententry.getpMonth());
                          String str5=String.valueOf(currententry.getmTuition());
                          String str6=String.valueOf(currententry.getBookCost());
                          String str7=currententry.getT1();
                          String str8=String.valueOf(currententry.getT1Cost());
                          String str9=currententry.getT2();
                          String str10=String.valueOf(currententry.getT2Cost());
                          String str11=currententry.getT3();
                          String str12=String.valueOf(currententry.getT3Cost());
                          String str13=currententry.getT4();
                          String str14=String.valueOf(currententry.getT4Cost());
                          String str15=currententry.getT5();
                          String str16=String.valueOf(currententry.getT5Cost());
                          String str17=currententry.getT6();
                          String str18=String.valueOf(currententry.getT6Cost());
                          String str19=currententry.getT7();
                          String str20=String.valueOf(currententry.getT7Cost());
                          String str21=currententry.getT8();
                          String str22=String.valueOf(currententry.getT8Cost());
                          String str23=currententry.getT9();
                          String str24=String.valueOf(currententry.getT9Cost());
                          String str25=String.valueOf(currententry.getTotalCost());
                          String str26=currententry.getScholarship();
                                                  
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
                          data[i][k]=str22;   k=k+1;
                          data[i][k]=str23;   k=k+1;
                          data[i][k]=str24;   k=k+1;
                          data[i][k]=str25;   k=k+1;
                          data[i][k]=str26;   k=k+1;
                    }
					
                    DefaultTableModel model=new DefaultTableModel(data,colheads);
                    JScrollPane scrollPane = new JScrollPane();
            		scrollPane.setBounds(34, 116, 1100, 214);
            		contentPane.add(scrollPane);
            		
                    table = new JTable(model);
            		//scrollPane.setViewportView(table);
                    try {
						table.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                       		           		
				}	
				
			}
		});
		btnPrint.setBounds(725, 56, 107, 25);
		contentPane.add(btnPrint);
				
		JButton btnSaveIntoExcel = new JButton("Save into Excel File");
		btnSaveIntoExcel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				XSSFWorkbook workbook = new XSSFWorkbook(); 
				XSSFSheet spreadsheet=workbook.createSheet("Student Payment List");
				XSSFRow row;
				String filename="";
								
				StudentFinanceQueries sq=new StudentFinanceQueries();
				results=sq.studentpayment(tStudentID.getText(),tStudentName.getText());
				numberOfEntries=results.size();
				
				if (numberOfEntries==0)
				{
					JOptionPane.showMessageDialog(rootPane, "No Payment Lists!!", "No Payment Lists!", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{	
					Map <String, Object[]> studentpayment=new TreeMap <String, Object[]>();
                  	studentpayment.put("1", new Object[] {"StudentID","StudentName","PaymentYear","PaymentMonth","MonthlyTuition","CostOfBooks","T1","T1Cost","T2","T2Cost","T3","T3Cost",
							"T4","T4Cost","T5","T5Cost","T6","T6Cost","T7","T7Cost","T8","T8Cost","T9","T9Cost","TotalCost","Scholarship"});
					
                    for(int i=0;i<numberOfEntries;i++)
                    {
                          currententry=results.get(i);
                          String str1=String.valueOf(currententry.getStudentID());
                          String str2=currententry.getStudentName();
                          String str3=String.valueOf(currententry.getpYear());
                          String str4=String.valueOf(currententry.getpMonth());
                          String str5=String.valueOf(currententry.getmTuition());
                          String str6=String.valueOf(currententry.getBookCost());
                          String str7=currententry.getT1();
                          String str8=String.valueOf(currententry.getT1Cost());
                          String str9=currententry.getT2();
                          String str10=String.valueOf(currententry.getT2Cost());
                          String str11=currententry.getT3();
                          String str12=String.valueOf(currententry.getT3Cost());
                          String str13=currententry.getT4();
                          String str14=String.valueOf(currententry.getT4Cost());
                          String str15=currententry.getT5();
                          String str16=String.valueOf(currententry.getT5Cost());
                          String str17=currententry.getT6();
                          String str18=String.valueOf(currententry.getT6Cost());
                          String str19=currententry.getT7();
                          String str20=String.valueOf(currententry.getT7Cost());
                          String str21=currententry.getT8();
                          String str22=String.valueOf(currententry.getT8Cost());
                          String str23=currententry.getT9();
                          String str24=String.valueOf(currententry.getT9Cost());
                          String str25=String.valueOf(currententry.getTotalCost());
                          String str26=currententry.getScholarship();
                          
                          studentpayment.put(String.valueOf(i+2), new Object[] 
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
                                     str26                        	  
                        		  }
                          );
                         Set <String> keyid=studentpayment.keySet();
                         int rowid=0;
                         
                         for(String key:keyid)
                         {
                        	 row=spreadsheet.createRow(rowid++);
                        	 Object[] objectArr=studentpayment.get(key);
                        	 int cellid=0;
                        	 for(Object obj:objectArr)
                        	 {
                        		 Cell cell=row.createCell(cellid++);
                        		 cell.setCellValue((String)obj);
                        	 }
                        	 
                        	 FileOutputStream out=null;
							try {
								filename="studentpayment"+str1+".xlsx";
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
		btnSaveIntoExcel.setBounds(871, 55, 152, 25);
		contentPane.add(btnSaveIntoExcel);
		
		
	}
}
