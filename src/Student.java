import java.sql.Blob;


public class Student {

	private int StudentID;
	private String StudentName;
	private String StudentPhone;
	private String StudentEmail;
	private int Grade;
	private String Dob;
	private String Address;
	private String Hobby;
	private byte[] StudentPhoto;
	private String Gender;
	private String EntMoveinMoveout;
	private String EntInOutDate;
	private String MomName;
	private String MomPhone;
	private String MomEmail;
	private String DadName;
	private String DadPhone;
	private String DadEmail;
	private String Faith;
	private String Baptizement;
	private String AwardPunish;
	private String AwardPunContent;
		
	
	public Student(){
		
	}
	
	public Student(int id, String studentname){
		
		setStudentID(id);
		setStudentName(studentname);
	}
	
	public Student(int id, String studentname, String studentphone, String studentemail, int grd, String dob,String address,
			String hobby, byte[] photo, String gender, String entMoveinMoveout, String entInOutDate, String momname, String momphone, String momemail, String dadname, String dadphone, 
			String dademail, String faith, String baptizement, String awardPunish, String awardPunContent){
		
		setStudentID(id);
		setStudentName(studentname);
		setStudentPhone(studentphone);
		setStudentEmail(studentemail);
		setGrade(grd);
		setDob(dob);
		setAddress(address);
		setHobby(hobby);
		setStudentPhoto(photo);
		setGender(gender);
		setEntMoveinMoveout(entMoveinMoveout);
		setEntInOutDate(entInOutDate);
		setMomName(momname);
		setMomPhone(momphone);
		setMomEmail(momemail);
		setDadName(dadname);
		setDadPhone(dadphone);
		setDadEmail(dademail);
		setFaith(faith);
		setBaptizement(baptizement);
		setAwardPunish(awardPunish);
		setAwardPunContent(awardPunContent);
		
	}
	
	
	

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int id) {
		StudentID = id;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentname) {
		StudentName = studentname;
	}

	public String getStudentPhone() {
		return StudentPhone;
	}

	public void setStudentPhone(String studentphone) {
		StudentPhone = studentphone;
	}

	public String getStudentEmail() {
		return StudentEmail;
	}

	public void setStudentEmail(String studentemail) {
		StudentEmail = studentemail;
	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grd) {
		Grade = grd;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	public String getHobby() {
		return Hobby;
	}

	public void setHobby(String hobby) {
		Hobby = hobby;
	}
	
	
	public byte[] getStudentPhoto() {
		return StudentPhoto;
	}

	public void setStudentPhoto(byte[] photo) {
		StudentPhoto = photo;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	
	public String getEntMoveinMoveout() {
		return EntMoveinMoveout;
	}

	public void setEntMoveinMoveout(String entMoveinMoveout) {
		EntMoveinMoveout = entMoveinMoveout;
	}

	public String getEntInOutDate() {
		return EntInOutDate;
	}

	public void setEntInOutDate(String entInOutDate) {
		EntInOutDate = entInOutDate;
	}
	
	public String getMomName() {
		return MomName;
	}

	public void setMomName(String momname) {
		MomName = momname;
	}

	public String getMomPhone() {
		return MomPhone;
	}

	public void setMomPhone(String momphone) {
		MomPhone = momphone;
	}

	public String getMomEmail() {
		return MomEmail;
	}

	public void setMomEmail(String momEmail) {
		MomEmail = momEmail;
	}
	
	public String getDadName() {
		return DadName;
	}

	public void setDadName(String dadname) {
		DadName = dadname;
	}

	public String getDadPhone() {
		return DadPhone;
	}

	public void setDadPhone(String dadphone) {
		DadPhone = dadphone;
	}

	public String getDadEmail() {
		return DadEmail;
	}

	public void setDadEmail(String dademail) {
		DadEmail = dademail;
	}

	public String getFaith() {
		return Faith;
	}

	public void setFaith(String faith) {
		Faith = faith;
	}
	
	public String getBaptizement() {
		return Baptizement;
	}

	public void setBaptizement(String baptizement) {
		Baptizement = baptizement;
	}
	
	public String getAwardPunish() {
		return AwardPunish;
	}

	public void setAwardPunish(String awardPunish) {
		AwardPunish = awardPunish;
	}

	public String getAwardPunContent() {
		return AwardPunContent;
	}

	public void setAwardPunContent(String awardPunContent) {
		AwardPunContent = awardPunContent;
	}

	
}