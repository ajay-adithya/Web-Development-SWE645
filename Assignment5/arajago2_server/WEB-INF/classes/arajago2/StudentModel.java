
package arajago2;

import java.io.Serializable;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class StudentModel  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1244359065795640489L;

	public StudentModel()
	{
		
	} 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fName, lName;	
	private String address;
	private String city, state;
	private String zip;
	private String contactNumber; 
	private String email;
	private Date dateSurvey, startDate;
	private String[] campusRating; 
	private String source;
	private String recommend;
	private String raffle;
	private String comments;
	private String checkBox="";
	
	@Transient
	private List<StudentModel> newStud = new ArrayList<StudentModel>();
	
	public List<StudentModel> getNewStud() {
		return newStud;
	}
	

	
	
	public void setNewStud(List<StudentModel> newStud) {
		this.newStud = newStud;
	}
	
	public long getId() {
		return id;
	}
	
	public String getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDateSurvey() {
		return dateSurvey;
	}
	public void setDateSurvey(Date dateSurvey) {
		this.dateSurvey = dateSurvey;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String[] getCampusRating() {
		return campusRating;
	}
	public void setCampusRating(String[] campusRating) {
		this.campusRating = campusRating;
		for(int i=0;i<campusRating.length;i++)
            checkBox=campusRating[i]+"  "+checkBox;
        setCheckBox(checkBox);
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}