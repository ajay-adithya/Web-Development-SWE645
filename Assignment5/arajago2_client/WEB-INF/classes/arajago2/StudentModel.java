package arajago2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentModel", propOrder = {
    "address",
    "campusRating",
    "checkBox",
    "city",
    "comments",
    "contactNumber",
    "dateSurvey",
    "email",
    "newStud",
    "raffle",
    "recommend",
    "source",
    "startDate",
    "state",
    "zip",
    "fName",
    "lName"
})
public class StudentModel {

    protected String address;
    @XmlElement(nillable = true)
    protected List<String> campusRating;
    protected String checkBox;
    protected String city;
    protected String comments;
    protected String contactNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateSurvey;
    protected String email;
    @XmlElement(nillable = true)
    protected List<StudentModel> newStud;
    protected String raffle;
    protected String recommend;
    protected String source;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    protected String state;
    protected String zip;
    protected String fName;
    protected String lName;

 
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String value) {
        this.address = value;
    }

    public List<String> getCampusRating() {
        if (campusRating == null) {
            campusRating = new ArrayList<String>();
        }
        return this.campusRating;
    }

    public String getCheckBox() {
        return checkBox;
    }
    public void setCheckBox(String value) {
        this.checkBox = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }
    public String getComments() {
        return comments;
    }

    public void setComments(String value) {
        this.comments = value;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String value) {
        this.contactNumber = value;
    }

    public XMLGregorianCalendar getDateSurvey() {
        return dateSurvey;
    }
    public void setDateSurvey(XMLGregorianCalendar value) {
        this.dateSurvey = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }
    public List<StudentModel> getNewStud() {
        if (newStud == null) {
            newStud = new ArrayList<StudentModel>();
        }
        return this.newStud;
    }

    public String getRaffle() {
        return raffle;
    }

    public void setRaffle(String value) {
        this.raffle = value;
    }
    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String value) {
        this.recommend = value;
    }
    public String getSource() {
        return source;
    }

    public void setSource(String value) {
        this.source = value;
    }

    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String value) {
        this.zip = value;
    }
    public String getFName() {
        return fName;
    }

    public void setFName(String value) {
        this.fName = value;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String value) {
        this.lName = value;
    }

}
