
/*
 * Ajay Adithya
 * Simple managed bean to map form values.
 */ 
 package as3;

import javax.faces.bean.ManagedBean;

@ManagedBean 
public class Student {

	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String number;
	private String email;
	private String dos;
	private String startDate;
	private String[] liked;
	private String hear;
	private String recommend;
	private String raffle;
	private String comments;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos = dos;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String[] getLiked() {
		return liked;
	}
	public void setLiked(String[] liked) {
		this.liked = liked;
	}
	public String getHear() {
		return hear;
	}
	public void setHear(String hear) {
		this.hear = hear;
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
