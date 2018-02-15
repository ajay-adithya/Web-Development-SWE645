
package arajago2;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class SearchClient {

private List<StudentModel> searchList = new ArrayList<StudentModel>();
public List<StudentModel> getSearchList() {
	return searchList;
}

public void setSearchList(ArrayList<StudentModel> searchList) {
	this.searchList = searchList;
}

private String fName, lName, city,state;
	
public String actionControllerMethod2() throws Exception{
	SearchImplService SIS = new SearchImplService();
	Search s = SIS.getSearchImplPort();
	
	searchList = s.getSearchList(getFName(), getLName(), getCity(), getState());

	return "SearchResults";
}	
	
public String getFName() {
	return fName;
}

public void setFName(String fName) {
	this.fName = fName;
}

public String getLName() {
	return lName;
}

public void setLName(String lName) {
	this.lName = lName;
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
}