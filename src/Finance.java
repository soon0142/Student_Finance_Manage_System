
public class Finance {
	
	private int paymentid;
	private int pYear;
	private int pMonth;
	private int mTuition;
	private int BookCost;
	private String T1;
	private int T1Cost;
	private String T2;
	private int T2Cost;
	private String T3;
	private int T3Cost;
	private String T4;
	private int T4Cost;
	private String T5;
	private int T5Cost;
	private String T6;
	private int T6Cost;
	private String T7;
	private int T7Cost;
	private String T8;
	private int T8Cost;
	private String T9;
	private int T9Cost;
	private int TotalCost;
	private String Scholarship;
	private int StudentID;
	private String StudentName;
	

	public Finance(){
		
	}
	
	public Finance(int paymentid, int pYear,int pMonth, int mTuition, int bookCost, String t1, int t1Cost, String t2, int t2Cost,
			String t3, int t3Cost, String t4, int t4Cost, String t5, int t5Cost, String t6, int t6Cost, String t7, int t7Cost,
			String t8, int t8Cost, String t9, int t9Cost, int totalCost, String scholarship, int studentID, String studentName)
	
	{
		setPaymentID(paymentid);		
		setpYear(pYear);
		setpMonth(pMonth);
		setmTuition(mTuition);
		setBookCost(bookCost);
		setT1(t1);
		setT1Cost(t1Cost);
		setT2(t2);
		setT2Cost(t2Cost);
		setT3(t3);
		setT3Cost(t3Cost);
		setT4(t4);
		setT4Cost(t4Cost);
		setT5(t5);
		setT5Cost(t5Cost);
		setT6(t6);
		setT6Cost(t6Cost);
		setT7(t7);
		setT7Cost(t7Cost);
		setT8(t7);
		setT8Cost(t8Cost);
		setT9(t9);
		setT9Cost(t9Cost);
		setTotalCost(totalCost);
		setScholarship(scholarship);
		setStudentID(studentID);
		setStudentName(studentName);
	}
	
	public int getpYear() {
		return pYear;
	}
	public void setpYear(int pYear) {
		this.pYear = pYear;
	}
	public int getpMonth() {
		return pMonth;
	}
	public void setpMonth(int pMonth) {
		this.pMonth = pMonth;
	}
	public int getmTuition() {
		return mTuition;
	}
	public void setmTuition(int mTuition) {
		this.mTuition = mTuition;
	}
	public int getBookCost() {
		return BookCost;
	}
	public void setBookCost(int bookCost) {
		BookCost = bookCost;
	}
	public String getT1() {
		return T1;
	}
	public void setT1(String t1) {
		T1 = t1;
	}
	public int getT1Cost() {
		return T1Cost;
	}
	public void setT1Cost(int t1Cost) {
		T1Cost = t1Cost;
	}
	public String getT2() {
		return T2;
	}
	public void setT2(String t2) {
		T2 = t2;
	}
	public int getT2Cost() {
		return T2Cost;
	}
	public void setT2Cost(int t2Cost) {
		T2Cost = t2Cost;
	}
	public String getT3() {
		return T3;
	}
	public void setT3(String t3) {
		T3 = t3;
	}
	public int getT3Cost() {
		return T3Cost;
	}
	public void setT3Cost(int t3Cost) {
		T3Cost = t3Cost;
	}
	public String getT4() {
		return T4;
	}
	public void setT4(String t4) {
		T4 = t4;
	}
	public int getT4Cost() {
		return T4Cost;
	}
	public void setT4Cost(int t4Cost) {
		T4Cost = t4Cost;
	}
	public String getT5() {
		return T5;
	}
	public void setT5(String t5) {
		T5 = t5;
	}
	public int getT5Cost() {
		return T5Cost;
	}
	public void setT5Cost(int t5Cost) {
		T5Cost = t5Cost;
	}
	public String getT6() {
		return T6;
	}
	public void setT6(String t6) {
		T6 = t6;
	}
	public int getT6Cost() {
		return T6Cost;
	}
	public void setT6Cost(int t6Cost) {
		T6Cost = t6Cost;
	}
	public String getT7() {
		return T7;
	}
	public void setT7(String t7) {
		T7 = t7;
	}
	public int getT7Cost() {
		return T7Cost;
	}
	public void setT7Cost(int t7Cost) {
		T7Cost = t7Cost;
	}
	public String getT8() {
		return T8;
	}
	public void setT8(String t8) {
		T8 = t8;
	}
	public int getT8Cost() {
		return T8Cost;
	}
	public void setT8Cost(int t8Cost) {
		T8Cost = t8Cost;
	}
	public String getT9() {
		return T9;
	}
	public void setT9(String t9) {
		T9 = t9;
	}
	public int getT9Cost() {
		return T9Cost;
	}
	public void setT9Cost(int t9Cost) {
		T9Cost = t9Cost;
	}
	public int getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}
	public String getScholarship() {
		return Scholarship;
	}
	public void setScholarship(String scholarship) {
		Scholarship = scholarship;
	}
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public int getPaymentID() {
		return paymentid;
	}

	public void setPaymentID(int paymentid) {
		this.paymentid = paymentid;
	}
	
	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
}
