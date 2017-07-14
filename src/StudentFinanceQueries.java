import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;


public class StudentFinanceQueries {
		
	private static final String URL="jdbc:sqlite:Paraguay.db";
	//private static final String URL="jdbc:sqlite::resource:Paraguay.db"; // embeded database inside program
	//private static final String URL = "jdbc:sqlite:/home/cloudera/workspace/Paraguay1/Paraguay.db";
	
			
	static private Connection connection=null;
	static private PreparedStatement insertNewStudent=null;
	static private PreparedStatement updateStudent=null;
	static private PreparedStatement updateStudent1=null;
	static private PreparedStatement delStudent=null;
	static private PreparedStatement selectStudentName=null;
	static private PreparedStatement selectStudentInfo0=null;
	static private PreparedStatement selectStudentInfo=null;
	static private PreparedStatement StudentSearchInfo1=null;
	static private PreparedStatement StudentSearchInfo2=null;
	static private PreparedStatement StudentSearchInfo3=null;
	static private PreparedStatement StudentSearchInfo4=null;
	static private PreparedStatement StudentSearchInfo5=null;
	static private PreparedStatement StudentSearchInfo6=null;
	static private PreparedStatement StudentSearchInfo7=null;
	static private PreparedStatement insertNewFinance=null;
	static private PreparedStatement updateFinance=null;
	static private PreparedStatement delFinance=null;
	static private PreparedStatement selectMonthlyPaymentLists=null;
	static private PreparedStatement selectstudentPaymentLists=null;
	static private PreparedStatement selectAllData=null;
	static private PreparedStatement selectStudentAllData=null;
	static private PreparedStatement insertRestoreData=null;
	static private PreparedStatement insertRestoreStudentData=null;
	static private PreparedStatement deleteAll=null;
	static private PreparedStatement deleteStudentAll=null;
	static private PreparedStatement selectFinanceInfo=null;
	static private PreparedStatement selectlogin=null;

		
	public StudentFinanceQueries(){
		
		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			connection= DriverManager.getConnection(URL);
			
			insertNewStudent=connection.prepareStatement("INSERT INTO student"+
					"(StudentID, StudentName,StudentPhone,StudentEmail,Grade,DOB,Address,"+
					"Hobby,Studentphoto,Gender,EntMoveinMoveout,EntInOutDate,MomName,MomPhone,MomEmail,DadName,DadPhone,"+
					"DadEmail,Faith,Baptizement,AwardPunish,AwardPunContent) "+
					"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
								
					updateStudent=connection.prepareStatement("update student set StudentName=?, StudentPhone=?,StudentEmail=?,Grade=?,"
							+ "DOB=?,Address=?,Hobby=?,Studentphoto=?,Gender=?,EntMoveinMoveout=?,"+
							"EntInOutDate=?,MomName=?,MomPhone=?,MomEmail=?,DadName=?,DadPhone=?,DadEmail=?,Faith=?,Baptizement=?,AwardPunish=?,AwardPunContent=? "+
							"where StudentID=?");
					
					updateStudent1=connection.prepareStatement("update student set StudentName=?, StudentPhone=?,StudentEmail=?,Grade=?,"
							+ "DOB=?,Address=?,Hobby=?,Gender=?,EntMoveinMoveout=?,"+
							"EntInOutDate=?,MomName=?,MomPhone=?,MomEmail=?,DadName=?,DadPhone=?,DadEmail=?,Faith=?,Baptizement=?,AwardPunish=?,AwardPunContent=? "+
							"where StudentID=?");
									
					delStudent=connection.prepareStatement("delete from student where StudentID=?");
					
					selectStudentName=connection.prepareStatement("select StudentID, StudentName from student where StudentID=?");
					
					selectStudentInfo0=connection.prepareStatement("select * from student order by StudentID asc");
					
					selectStudentInfo=connection.prepareStatement("select * from student where StudentID=?");
					
					StudentSearchInfo1=connection.prepareStatement("select * from student where StudentName=?");
					
					StudentSearchInfo2=connection.prepareStatement("select * from student where Grade=?");
					
					StudentSearchInfo3=connection.prepareStatement("select * from student where Gender=?");
					
					StudentSearchInfo4=connection.prepareStatement("select * from student where EntMoveinMoveout=?");
					
					StudentSearchInfo5=connection.prepareStatement("select * from student where Faith=?");
					
					StudentSearchInfo6=connection.prepareStatement("select * from student where Baptizement=?");
					
					StudentSearchInfo7=connection.prepareStatement("select * from student where AwardPunish=?");
					
					
					insertNewFinance=connection.prepareStatement("INSERT INTO finance"+
					"(PaymentYear,PaymentMonth,MonthlyTuition,CostOfBooks,T1,T1Cost,T2,T2Cost,T3,T3Cost,"+
					"T4,T4Cost,T5,T5Cost,T6,T6Cost,T7,T7Cost,T8,T8Cost,T9,T9Cost,"+
					"TotalCost,Scholarship,StudentID, StudentName) "+
					"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					updateFinance=connection.prepareStatement("update finance set PaymentYear=?, PaymentMonth=?,MonthlyTuition=?,CostOfBooks=?,"
							+ "T1=?,T1Cost=?,T2=?,T2Cost=?,T3=?,T3Cost=?,"+
							"T4=?,T4Cost=?,T5=?,T5Cost=?,T6=?,T6Cost=?,T7=?,T7Cost=?,T8=?,T8Cost=?,T9=?,T9Cost=?,"+
							"TotalCost=?,Scholarship=?, StudentName=? where StudentID=?");
					
					delFinance=connection.prepareStatement("delete from finance where PaymentYear=? and PaymentMonth=? and StudentID=? and StudentName=?");
					
					selectFinanceInfo=connection.prepareStatement("select * from finance where StudentID=? and PaymentYear=? and PaymentMonth=?");
					
					insertRestoreData=connection.prepareStatement("INSERT INTO finance"+
							"(PaymentID, PaymentYear,PaymentMonth,MonthlyTuition,CostOfBooks,T1,T1Cost,T2,T2Cost,T3,T3Cost,"+
							"T4,T4Cost,T5,T5Cost,T6,T6Cost,T7,T7Cost,T8,T8Cost,T9,T9Cost,"+
							"TotalCost,Scholarship,StudentID, StudentName) "+
							"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					insertRestoreStudentData=connection.prepareStatement("INSERT INTO student"+
							"(StudentID, StudentName,StudentPhone,StudentEmail,Grade,DOB,Address,"+
							"Hobby,Gender,EntMoveinMoveout,EntInOutDate,MomName,MomPhone,MomEmail,DadName,DadPhone,"+
							"DadEmail,Faith,Baptizement,AwardPunish,AwardPunContent) "+
							"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					deleteAll=connection.prepareStatement("delete from finance");
					
					deleteStudentAll=connection.prepareStatement("delete from student");
					
					 selectMonthlyPaymentLists=connection.prepareStatement("select * from finance where PaymentYear=? and PaymentMonth=?");
					 
					 selectstudentPaymentLists=connection.prepareStatement("select * from finance where StudentID=? and StudentName=?");
					 
					 selectAllData=connection.prepareStatement("select * from finance");
					 
					 selectStudentAllData=connection.prepareStatement("select * from student");
					 
					 selectlogin=connection.prepareStatement("select * from login where loginName=? and passwd=?");
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					System.exit(1);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	               catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
			
			
			public int addStudent(String studentid,String studentname, String studentphone, String studentemail, String grd, String dob,String address,
					String hobby, String photo, String gender, String entmoveinmoveout , String entinoutdate, String momname, String momphone, String momemail, String dadname, String dadphone, 
					String dademail, String faith, String baptizement, String awardpunish, String awardpuncontent){
				
				int result=0;
				
				try
				{
					insertNewStudent.setInt(1, Integer.parseInt(studentid));
					insertNewStudent.setString(2,studentname);
					if (studentphone.isEmpty())
						insertNewStudent.setString(3," ");
					else
						insertNewStudent.setString(3,studentphone);
					if (studentemail.isEmpty())
						insertNewStudent.setString(4,null);
					else
						insertNewStudent.setString(4,studentemail);
					insertNewStudent.setInt(5, Integer.parseInt(grd));
					insertNewStudent.setString(6,dob);
					insertNewStudent.setString(7,address);
					if (hobby.isEmpty())
						insertNewStudent.setString(8," ");
					else
						insertNewStudent.setString(8,hobby);
					
					insertNewStudent.setBytes(9, readFile(photo));
					/*
					if (photo==null)
					{
						insertNewStudent.setBlob(9,(Blob)null);
					}	
					else 
					{	
						InputStream is;
						try {
							is = new FileInputStream(new File(photo));
							insertNewStudent.setBlob(9,is);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	*/
					
					insertNewStudent.setString(10,gender);
					insertNewStudent.setString(11, entmoveinmoveout);
					insertNewStudent.setString(12, entinoutdate);
					insertNewStudent.setString(13,momname);
					if (momphone.isEmpty())
						insertNewStudent.setString(14," ");
					else
						insertNewStudent.setString(14,momphone);
					if (momemail.isEmpty())
						insertNewStudent.setString(15," ");
					else
						insertNewStudent.setString(15,momemail);
					insertNewStudent.setString(16,dadname);
					if (dadphone.isEmpty())
						insertNewStudent.setString(17," ");
					else
						insertNewStudent.setString(17,dadphone);
					if (dademail.isEmpty())
						insertNewStudent.setString(18," ");
					else
						insertNewStudent.setString(18,dademail);
					insertNewStudent.setString(19,faith);
					insertNewStudent.setString(20,baptizement);
					insertNewStudent.setString(21,awardpunish);
					insertNewStudent.setString(22,awardpuncontent);
					
					result=insertNewStudent.executeUpdate();
					
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				return result;
				
			}
			
			
			 private byte[] readFile(String file) {
			        ByteArrayOutputStream bos = null;
			        try {
			            File f = new File(file);
			            FileInputStream fis = new FileInputStream(f);
			            byte[] buffer = new byte[1024];
			            bos = new ByteArrayOutputStream();
			            for (int len; (len = fis.read(buffer)) != -1;) {
			                bos.write(buffer, 0, len);
			            }
			        } catch (FileNotFoundException e) {
			            System.err.println(e.getMessage());
			        } catch (IOException e2) {
			            System.err.println(e2.getMessage());
			        }
			        return bos != null ? bos.toByteArray() : null;
			    }
			
			public int modifyStudent(String studentid,String studentname, String studentphone, String studentemail, String grd, String dob,String address,
					String hobby, String photo, String gender, String entmoveinmoveout , String entinoutdate, String momname, String momphone, String momemail, String dadname, String dadphone, 
					String dademail, String faith, String baptizement, String awardpunish, String awardpuncontent) {
							
				int result=0;
				
				if (photo!=null)
				{
					try
					{
						updateStudent.setString(1, studentname);
						if (studentphone.isEmpty())
							updateStudent.setString(2," ");
						else
							updateStudent.setString(2,studentphone);
						if (studentemail.isEmpty())
							updateStudent.setString(3,null);
						else
							updateStudent.setString(3,studentemail);
						updateStudent.setInt(4, Integer.parseInt(grd));
						updateStudent.setString(5,dob);
						updateStudent.setString(6,address);
						if (hobby.isEmpty())
							updateStudent.setString(7," ");
						else
							updateStudent.setString(7,hobby);
						//if (photo!=null)
							updateStudent.setBytes(8, readFile(photo));
						//else
							//updateStudent.setBytes(8, null);
						
											
						updateStudent.setString(9,gender);
						updateStudent.setString(10, entmoveinmoveout);
						updateStudent.setString(11, entinoutdate);
						updateStudent.setString(12,momname);
						if (momphone.isEmpty())
							updateStudent.setString(13," ");
						else
							updateStudent.setString(13,momphone);
						if (momemail.isEmpty())
							updateStudent.setString(14," ");
						else
							updateStudent.setString(14,momemail);
						updateStudent.setString(15,dadname);
						if (dadphone.isEmpty())
							updateStudent.setString(16," ");
						else
							updateStudent.setString(16,dadphone);
						if (dademail.isEmpty())
							updateStudent.setString(17," ");
						else
							updateStudent.setString(17,dademail);
						updateStudent.setString(18,faith);
						updateStudent.setString(19,baptizement);
						updateStudent.setString(20,awardpunish);
						updateStudent.setString(21,awardpuncontent);
						updateStudent.setInt(22, Integer.parseInt(studentid));
						
						result=updateStudent.executeUpdate();
						
					}
					catch (SQLException sqlException)
					{
						sqlException.printStackTrace();
						close();
					}
					finally {
						  if (connection != null) {
						    try {
						      connection.close(); // <-- This is important
						    } catch (SQLException e) {
						      /* handle exception */
						    }
						  }
					}
				}
				else
				{
					try
					{
						updateStudent1.setString(1, studentname);
						if (studentphone.isEmpty())
							updateStudent1.setString(2," ");
						else
							updateStudent1.setString(2,studentphone);
						if (studentemail.isEmpty())
							updateStudent1.setString(3,null);
						else
							updateStudent1.setString(3,studentemail);
						updateStudent1.setInt(4, Integer.parseInt(grd));
						updateStudent1.setString(5,dob);
						updateStudent1.setString(6,address);
						if (hobby.isEmpty())
							updateStudent1.setString(7," ");
						else
							updateStudent1.setString(7,hobby);
																	
						updateStudent1.setString(8,gender);
						updateStudent1.setString(9, entmoveinmoveout);
						updateStudent1.setString(10, entinoutdate);
						updateStudent1.setString(11,momname);
						if (momphone.isEmpty())
							updateStudent1.setString(12," ");
						else
							updateStudent1.setString(12,momphone);
						if (momemail.isEmpty())
							updateStudent1.setString(13," ");
						else
							updateStudent1.setString(13,momemail);
						updateStudent1.setString(14,dadname);
						if (dadphone.isEmpty())
							updateStudent1.setString(15," ");
						else
							updateStudent1.setString(15,dadphone);
						if (dademail.isEmpty())
							updateStudent1.setString(16," ");
						else
							updateStudent1.setString(16,dademail);
						updateStudent1.setString(17,faith);
						updateStudent1.setString(18,baptizement);
						updateStudent1.setString(19,awardpunish);
						updateStudent1.setString(20,awardpuncontent);
						updateStudent1.setInt(21, Integer.parseInt(studentid));
						
						result=updateStudent1.executeUpdate();
						
					}
					catch (SQLException sqlException)
					{
						sqlException.printStackTrace();
						close();
					}
					finally {
						  if (connection != null) {
						    try {
						      connection.close(); // <-- This is important
						    } catch (SQLException e) {
						      /* handle exception */
						    }
						  }
					}
				}
			
				return result;
			}
			
			
			public int deleteStudent(String StudentID) {
				
				int result=0;
				
				try
				{
					delStudent.setInt(1, Integer.parseInt(StudentID));
					
						
					result=delStudent.executeUpdate();
								
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			   
				return result;
				
			}
			

			public List<Student> findStudentName(String studentid){
				
				ResultSet resultset=null;
				List<Student> resultname = null;
				
				try {
					
					selectStudentName.setInt(1, Integer.parseInt(studentid));
					resultset=selectStudentName.executeQuery();
					resultname=new ArrayList<Student>();
					
					while (resultset.next())
					   resultname.add(new Student(resultset.getInt("StudentID"),resultset.getString("StudentName")));
				} 
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				
				return resultname;
			}
			
		public List<Student> findStudentInfo(String studentid){
				
				ResultSet rs=null;
				List<Student> resultname = null;
				
				try {
					
					selectStudentInfo.setInt(1, Integer.parseInt(studentid));
					rs=selectStudentInfo.executeQuery();
					resultname=new ArrayList<Student>();
					
					while (rs.next()){
					   resultname.add(new Student(rs.getInt("StudentID"),rs.getString("StudentName"), rs.getString("Studentphone"), rs.getString("StudentEmail"),
							     rs.getInt("Grade"),rs.getString("Dob"),rs.getString("Address"),rs.getString("Hobby"),rs.getBytes("StudentPhoto"),rs.getString("Gender"),
							     rs.getString("EntMoveinMoveout"),rs.getString("EntInOutDate"),rs.getString("MomName"),rs.getString("MomPhone"),rs.getString("MomEmail"),rs.getString("DadName"),
							     rs.getString("DadPhone"),rs.getString("DadEmail"),rs.getString("Faith"),rs.getString("Baptizement"),rs.getString("AwardPunish"),rs.getString("AwardPunContent"))); 
					}
					
				} 
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				
				return resultname;
			}

		public List<Student> studentSearch(Object select, String item){
			
			ResultSet rs=null;
			List<Student> result = null;
			
			try {
				if (select.equals("AllStudents"))
				{
					rs=selectStudentInfo0.executeQuery();
				}
				else if (select.equals("StudentID"))
				{
					selectStudentInfo.setString(1, item);
					  rs=selectStudentInfo.executeQuery();
				}
				else if (select.equals("Student_Name"))
				{
					  StudentSearchInfo1.setString(1, item);
					  rs=StudentSearchInfo1.executeQuery();
				}
				else if (select.equals("Grade"))
				{
					  StudentSearchInfo2.setString(1, item);
					  rs=StudentSearchInfo2.executeQuery();
				}
				else if (select.equals("Gender"))
				{
					  StudentSearchInfo3.setString(1, item);
					  rs=StudentSearchInfo3.executeQuery();
				}
				else if (select.equals("School_Enter"))
				{
					  StudentSearchInfo4.setString(1, item);
					  rs=StudentSearchInfo4.executeQuery();
				}
				else if (select.equals("Faith"))
				{
					  StudentSearchInfo5.setString(1, item);
					  rs=StudentSearchInfo5.executeQuery();
				}
				else if (select.equals("Baptizement"))
				{
					  StudentSearchInfo6.setString(1, item);
					  rs=StudentSearchInfo6.executeQuery();
				}
				else if (select.equals("Award_Punishment"))
				{
					  StudentSearchInfo7.setString(1, item);
					  rs=StudentSearchInfo7.executeQuery();
				}
				result=new ArrayList<Student>();
				
				while (rs.next())
				   result.add(new Student(rs.getInt("StudentID"),rs.getString("StudentName"), rs.getString("Studentphone"), rs.getString("StudentEmail"),
						     rs.getInt("Grade"),rs.getString("Dob"),rs.getString("Address"),rs.getString("Hobby"),rs.getBytes("StudentPhoto"),rs.getString("Gender"),
						     rs.getString("EntMoveinMoveout"),rs.getString("EntInOutDate"),rs.getString("MomName"),rs.getString("MomPhone"),rs.getString("MomEmail"),rs.getString("DadName"),
						     rs.getString("DadPhone"),rs.getString("DadEmail"),rs.getString("Faith"),rs.getString("Baptizement"),rs.getString("AwardPunish"),rs.getString("AwardPunContent"))); 
				
			} 
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
				close();
			}
			finally {
				  if (connection != null) {
				    try {
				      connection.close(); // <-- This is important
				    } catch (SQLException e) {
				      /* handle exception */
				    }
				  }
			}
			
			return result;
		}

			
			public List<Finance> findFinanceInfo(String pyear, String pmonth, String studentid){
				
				ResultSet rs=null;
				List<Finance> resultname = null;
				
				try {
					
					selectFinanceInfo.setInt(1, Integer.parseInt(studentid));
					selectFinanceInfo.setInt(2, Integer.parseInt(pyear));
					selectFinanceInfo.setInt(3, Integer.parseInt(pmonth));
					rs=selectFinanceInfo.executeQuery();
					resultname=new ArrayList<Finance>();
					
					while (rs.next())
					   resultname.add(new Finance(rs.getInt("PaymentID"),rs.getInt("PaymentYear"), rs.getInt("PaymentMonth"), rs.getInt("MonthlyTuition"),
							     rs.getInt("CostOfBooks"),rs.getString("T1"),rs.getInt("T1Cost"),rs.getString("T2"),rs.getInt("T2Cost"),rs.getString("T3"),rs.getInt("T3Cost"),
							     rs.getString("T4"),rs.getInt("T4Cost"),rs.getString("T5"),rs.getInt("T5Cost"),rs.getString("T6"),rs.getInt("T6Cost"),
							     rs.getString("T7"),rs.getInt("T7Cost"),rs.getString("T8"),rs.getInt("T8Cost"),rs.getString("T9"),rs.getInt("T9Cost"),
							     rs.getInt("TotalCost"),rs.getString("Scholarship"),rs.getInt("StudentID"), rs.getString("StudentName")));
				} 
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				
				return resultname;
			}
			
			
			public int addFinance(String pYear, String pMonth, String mTuition, String BookCost, 
					String T1, String T1Cost, String T2, String T2Cost, String T3, String T3Cost,
					String T4, String T4Cost, String T5, String T5Cost, String T6, String T6Cost,
					String T7, String T7Cost, String T8, String T8Cost, String T9, String T9Cost,
					String TotalCost, String Scholarship, String StudentID, String StudentName) {
							
				int result=0;
				
				try
				{
					insertNewFinance.setInt(1, Integer.parseInt(pYear));
					insertNewFinance.setInt(2, Integer.parseInt(pMonth));
					insertNewFinance.setInt(3, Integer.parseInt(mTuition));
					insertNewFinance.setInt(4, Integer.parseInt(BookCost));
					if (T1.isEmpty())
						insertNewFinance.setString(5, " ");
					else
						insertNewFinance.setString(5, T1);
					insertNewFinance.setInt(6, Integer.parseInt(T1Cost));
					if (T2.isEmpty())
						insertNewFinance.setString(7," ");
					else 
						insertNewFinance.setString(7, T2);
					insertNewFinance.setInt(8, Integer.parseInt(T2Cost));
					if (T3.isEmpty())
						insertNewFinance.setString(9," ");
					else 
						insertNewFinance.setString(9, T3);
					insertNewFinance.setInt(10, Integer.parseInt(T3Cost));
					if (T4.isEmpty())
						insertNewFinance.setString(11," ");
					else 
						insertNewFinance.setString(11, T4);
					insertNewFinance.setInt(12, Integer.parseInt(T4Cost));
					if (T5.isEmpty())
						insertNewFinance.setString(13," ");
					else 
						insertNewFinance.setString(13, T5);
					insertNewFinance.setInt(14, Integer.parseInt(T5Cost));
					if (T6.isEmpty())
						insertNewFinance.setString(15," ");
					else 
						insertNewFinance.setString(15, T6);
					insertNewFinance.setInt(16, Integer.parseInt(T6Cost));
					if (T7.isEmpty())
						insertNewFinance.setString(17," ");
					else 
						insertNewFinance.setString(17, T7);
					insertNewFinance.setInt(18, Integer.parseInt(T7Cost));
					if (T8.isEmpty())
						insertNewFinance.setString(19," ");
					else 
						insertNewFinance.setString(19, T8);
					insertNewFinance.setInt(20, Integer.parseInt(T8Cost));
					if (T9.isEmpty())
						insertNewFinance.setString(21," ");
					else 
						insertNewFinance.setString(21, T9);
					insertNewFinance.setInt(22, Integer.parseInt(T9Cost));
					insertNewFinance.setInt(23, Integer.parseInt(TotalCost));
					if (Scholarship.isEmpty())
						insertNewFinance.setString(24," ");
					else 
						insertNewFinance.setString(24, Scholarship);
					insertNewFinance.setInt(25, Integer.parseInt(StudentID));
					insertNewFinance.setString(26, StudentName);
								
					result=insertNewFinance.executeUpdate();
					
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			
				return result;
				
			}
			
			public int modifyFinance(String pYear, String pMonth, String mTuition, String BookCost, 
					String T1, String T1Cost, String T2, String T2Cost, String T3, String T3Cost,
					String T4, String T4Cost, String T5, String T5Cost, String T6, String T6Cost,
					String T7, String T7Cost, String T8, String T8Cost, String T9, String T9Cost,
					String TotalCost, String Scholarship, String StudentID, String StudentName) {
							
				int result=0;
				
				try
				{
					updateFinance.setInt(1, Integer.parseInt(pYear));
					updateFinance.setInt(2, Integer.parseInt(pMonth));
					updateFinance.setInt(3, Integer.parseInt(mTuition));
					updateFinance.setInt(4, Integer.parseInt(BookCost));
					if (T1.isEmpty())
						updateFinance.setString(5, " ");
					else
						updateFinance.setString(5, T1);
					updateFinance.setInt(6, Integer.parseInt(T1Cost));
					if (T2.isEmpty())
						updateFinance.setString(7," ");
					else 
						updateFinance.setString(7, T2);
					updateFinance.setInt(8, Integer.parseInt(T2Cost));
					if (T3.isEmpty())
						updateFinance.setString(9," ");
					else 
						updateFinance.setString(9, T3);
					updateFinance.setInt(10, Integer.parseInt(T3Cost));
					if (T4.isEmpty())
						updateFinance.setString(11," ");
					else 
						updateFinance.setString(11, T4);
					updateFinance.setInt(12, Integer.parseInt(T4Cost));
					if (T5.isEmpty())
						updateFinance.setString(13," ");
					else 
						updateFinance.setString(13, T5);
					updateFinance.setInt(14, Integer.parseInt(T5Cost));
					if (T6.isEmpty())
						updateFinance.setString(15," ");
					else 
						updateFinance.setString(15, T6);
					updateFinance.setInt(16, Integer.parseInt(T6Cost));
					if (T7.isEmpty())
						updateFinance.setString(17," ");
					else 
						updateFinance.setString(17, T7);
					updateFinance.setInt(18, Integer.parseInt(T7Cost));
					if (T8.isEmpty())
						updateFinance.setString(19," ");
					else 
						updateFinance.setString(19, T8);
					updateFinance.setInt(20, Integer.parseInt(T8Cost));
					if (T9.isEmpty())
						updateFinance.setString(21," ");
					else 
						updateFinance.setString(21, T9);
					updateFinance.setInt(22, Integer.parseInt(T9Cost));
					updateFinance.setInt(23, Integer.parseInt(TotalCost));
					if (Scholarship.isEmpty())
						updateFinance.setString(24," ");
					else 
						updateFinance.setString(24, Scholarship);
					updateFinance.setString(25, StudentName);
					updateFinance.setInt(26, Integer.parseInt(StudentID));
					
					result=updateFinance.executeUpdate();
								
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			
				return result;
				
			}
			
			public int deleteFinance(String pYear, String pMonth, String StudentID, String StudentName) {
							
				int result=0;
				
				try
				{
					delFinance.setInt(1, Integer.parseInt(pYear));
					delFinance.setInt(2, Integer.parseInt(pMonth));
					delFinance.setInt(3, Integer.parseInt(StudentID));
					delFinance.setString(4, StudentName);
						
					result=delFinance.executeUpdate();
								
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			
				return result;
				
			}

			private static void close() {
				
				try
				{
					connection.close();
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
				}
				
			}


			public List<Finance> monthlypayment(String year, String month) {
				// TODO Auto-generated method stub
				
				ResultSet rs=null;
				List<Finance> result = null;
				
				try {
					
					selectMonthlyPaymentLists.setInt(1, Integer.parseInt(year));
					selectMonthlyPaymentLists.setInt(2, Integer.parseInt(month));
					
					rs=selectMonthlyPaymentLists.executeQuery();
					result=new ArrayList<Finance>();
					
					while (rs.next())
					   result.add(new Finance(rs.getInt("PaymentID"),rs.getInt("PaymentYear"), rs.getInt("PaymentMonth"), rs.getInt("MonthlyTuition"),
					     rs.getInt("CostOfBooks"),rs.getString("T1"),rs.getInt("T1Cost"),rs.getString("T2"),rs.getInt("T2Cost"),rs.getString("T3"),rs.getInt("T3Cost"),
					     rs.getString("T4"),rs.getInt("T4Cost"),rs.getString("T5"),rs.getInt("T5Cost"),rs.getString("T6"),rs.getInt("T6Cost"),
					     rs.getString("T7"),rs.getInt("T7Cost"),rs.getString("T8"),rs.getInt("T8Cost"),rs.getString("T9"),rs.getInt("T9Cost"),
					     rs.getInt("TotalCost"),rs.getString("Scholarship"),rs.getInt("StudentID"), rs.getString("StudentName")));
										
				} 
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				
				return result;
			
			}
			
			public List<Finance> studentpayment(String studentID, String studentName) {
				// TODO Auto-generated method stub
				
				ResultSet rs=null;
				List<Finance> result = null;
				
				try {
					
					selectstudentPaymentLists.setInt(1, Integer.parseInt(studentID));
					selectstudentPaymentLists.setString(2, studentName);
					
					rs=selectstudentPaymentLists.executeQuery();
					result=new ArrayList<Finance>();
					
					while (rs.next())
					   result.add(new Finance(rs.getInt("PaymentID"),rs.getInt("PaymentYear"), rs.getInt("PaymentMonth"), rs.getInt("MonthlyTuition"),
					     rs.getInt("CostOfBooks"),rs.getString("T1"),rs.getInt("T1Cost"),rs.getString("T2"),rs.getInt("T2Cost"),rs.getString("T3"),rs.getInt("T3Cost"),
					     rs.getString("T4"),rs.getInt("T4Cost"),rs.getString("T5"),rs.getInt("T5Cost"),rs.getString("T6"),rs.getInt("T6Cost"),
					     rs.getString("T7"),rs.getInt("T7Cost"),rs.getString("T8"),rs.getInt("T8Cost"),rs.getString("T9"),rs.getInt("T9Cost"),
					     rs.getInt("TotalCost"),rs.getString("Scholarship"),rs.getInt("StudentID"), rs.getString("StudentName")));
										
				} 
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				
				return result;
			
			}


			public List<Finance> backupfile() {
				// TODO Auto-generated method stub
				ResultSet rs=null;
				List<Finance> result = null;
				
				try {
					
					rs=selectAllData.executeQuery();
					result=new ArrayList<Finance>();
					
					while (rs.next())
					   result.add(new Finance(rs.getInt("PaymentID"),rs.getInt("PaymentYear"), rs.getInt("PaymentMonth"), rs.getInt("MonthlyTuition"),
					     rs.getInt("CostOfBooks"),rs.getString("T1"),rs.getInt("T1Cost"),rs.getString("T2"),rs.getInt("T2Cost"),rs.getString("T3"),rs.getInt("T3Cost"),
					     rs.getString("T4"),rs.getInt("T4Cost"),rs.getString("T5"),rs.getInt("T5Cost"),rs.getString("T6"),rs.getInt("T6Cost"),
					     rs.getString("T7"),rs.getInt("T7Cost"),rs.getString("T8"),rs.getInt("T8Cost"),rs.getString("T9"),rs.getInt("T9Cost"),
					     rs.getInt("TotalCost"),rs.getString("Scholarship"),rs.getInt("StudentID"), rs.getString("StudentName")));
										
				} 
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				
				return result;
			
			}


			public int restorefile(String col1, String col2, String col3, String col4, String col5, String col6, String col7, String col8, String col9, String col10, String col11, String col12, String col13, 
					String col14, String col15, String col16, String col17, String col18, String col19, String col20, String col21, String col22, String col23, String col24, String col25, String col26, String col27) {
				int result=0;
										
				try
				{
					insertRestoreData.setInt(1, Integer.parseInt(col1));
					insertRestoreData.setInt(2, Integer.parseInt(col2));
					insertRestoreData.setInt(3, Integer.parseInt(col3));
					insertRestoreData.setInt(4, Integer.parseInt(col4));
					insertRestoreData.setInt(5, Integer.parseInt(col5));
					if (col6.isEmpty())
						insertRestoreData.setString(6, " ");
					else
						insertRestoreData.setString(6, col6);
					insertRestoreData.setInt(7, Integer.parseInt(col7));
					if (col8.isEmpty())
						insertRestoreData.setString(8," ");
					else 
						insertRestoreData.setString(8, col8);
					insertRestoreData.setInt(9, Integer.parseInt(col9));
					if (col10.isEmpty())
						insertRestoreData.setString(10," ");
					else 
						insertRestoreData.setString(10, col10);
					insertRestoreData.setInt(11, Integer.parseInt(col11));
					if (col12.isEmpty())
						insertRestoreData.setString(12," ");
					else 
						insertRestoreData.setString(12, col12);
					insertRestoreData.setInt(13, Integer.parseInt(col13));
					if (col14.isEmpty())
						insertRestoreData.setString(14," ");
					else 
						insertRestoreData.setString(14, col14);
					insertRestoreData.setInt(15, Integer.parseInt(col15));
					if (col16.isEmpty())
						insertRestoreData.setString(16," ");
					else 
						insertRestoreData.setString(16, col16);
					insertRestoreData.setInt(17, Integer.parseInt(col17));
					if (col18.isEmpty())
						insertRestoreData.setString(18," ");
					else 
						insertRestoreData.setString(18, col18);
					insertRestoreData.setInt(19, Integer.parseInt(col19));
					if (col20.isEmpty())
						insertRestoreData.setString(20," ");
					else 
						insertRestoreData.setString(20, col20);
					insertRestoreData.setInt(21, Integer.parseInt(col21));
					if (col22.isEmpty())
						insertRestoreData.setString(22," ");
					else 
						insertRestoreData.setString(22, col22);
					insertRestoreData.setInt(23, Integer.parseInt(col23));
					insertRestoreData.setInt(24, Integer.parseInt(col24));
					if (col25.isEmpty())
						insertRestoreData.setString(25," ");
					else 
						insertRestoreData.setString(25, col25);
					insertRestoreData.setInt(26, Integer.parseInt(col26));
					insertRestoreData.setString(27, col27);
										
					result=insertRestoreData.executeUpdate();
										
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			
				return result;
				
			}
			
			
			public List<Student> backupstudentfile() {
				// TODO Auto-generated method stub
				ResultSet rs=null;
				List<Student> result = null;
				
				try {
					
					rs=selectStudentAllData.executeQuery();
					result=new ArrayList<Student>();
					
					while (rs.next())
					   result.add(new Student(rs.getInt("StudentID"),rs.getString("StudentName"), rs.getString("StudentPhone"), rs.getString("StudentEmail"),
					     rs.getInt("Grade"),rs.getString("Dob"),rs.getString("Address"),rs.getString("Hobby"),rs.getBytes("StudentPhoto"),rs.getString("Gender"),rs.getString("EntMoveinMoveout"),
					     rs.getString("EntInOutDate"),rs.getString("MomName"),rs.getString("MomPhone"),rs.getString("MomEmail"),rs.getString("DadName"),rs.getString("DadPhone"),
					     rs.getString("DadEmail"),rs.getString("Faith"),rs.getString("Baptizement"),rs.getString("AwardPunish"),rs.getString("AwardPunContent")));
										
				} 
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
				
				return result;
			}
			
			
			public int restorestudentfile(String col1, String col2, String col3, String col4, String col5, String col6, String col7, String col8, String col9, String col10, String col11, String col12, String col13, 
					String col14, String col15, String col16, String col17, String col18, String col19, String col20, String col21) {
				int result=0;
										
				try
				{
					insertRestoreStudentData.setInt(1, Integer.parseInt(col1));
					insertRestoreStudentData.setString(2, col2);
					if (col3.isEmpty())
						insertRestoreStudentData.setString(3, " ");
					else
						insertRestoreStudentData.setString(3, col3);
					if (col4.isEmpty())
						insertRestoreStudentData.setString(4, null);
					else
						insertRestoreStudentData.setString(4, col4);
					insertRestoreStudentData.setInt(5, Integer.parseInt(col5));
					insertRestoreStudentData.setString(6, col6);
					insertRestoreStudentData.setString(7, col7);
					if (col8.isEmpty())
						insertRestoreStudentData.setString(8, " ");
					else
						insertRestoreStudentData.setString(8, col8);
					insertRestoreStudentData.setString(9, col9);
					insertRestoreStudentData.setString(10, col10);
					insertRestoreStudentData.setString(11, col11);
					insertRestoreStudentData.setString(12, col12);
					if (col13.isEmpty())
						insertRestoreStudentData.setString(13," ");
					else
						insertRestoreStudentData.setString(13,col13);
					if (col14.isEmpty())
						insertRestoreStudentData.setString(14," ");
					else
						insertRestoreStudentData.setString(14,col14);
					insertRestoreStudentData.setString(15, col15);
					if (col16.isEmpty())
						insertRestoreStudentData.setString(16," ");
					else
						insertRestoreStudentData.setString(16,col16);
					if (col17.isEmpty())
						insertRestoreStudentData.setString(17," ");
					else
						insertRestoreStudentData.setString(17,col17);
					insertRestoreStudentData.setString(18, col18);
					insertRestoreStudentData.setString(19, col19);
					insertRestoreStudentData.setString(20, col20);
					insertRestoreStudentData.setString(21, col21); 
										
					result=insertRestoreStudentData.executeUpdate();
											
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			
				return result;
				
			}
			   
			
			
			public int deleteall() {
				int result=0;
				
				try{
				result=deleteAll.executeUpdate();
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			
				return result;
				
			}
			
			public int deletestudentall() {
				int result=0;
				
				try{
				result=deleteStudentAll.executeUpdate();
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			
				return result;
				
			}
			
		public int loginsuccess(String loginname, String passwd) {
				
				ResultSet result=null;
				int success=0;
				
				try
				{
					selectlogin.setString(1, loginname);
					selectlogin.setString(2, passwd);
					
						
					result=selectlogin.executeQuery();
					
					if (result!=null)
						success=1;
								
				}
				catch (SQLException sqlException)
				{
					sqlException.printStackTrace();
					close();
				}
				finally {
					  if (connection != null) {
					    try {
					      connection.close(); // <-- This is important
					    } catch (SQLException e) {
					      /* handle exception */
					    }
					  }
				}
			   
				return success;
				
			}
			
			
		}
