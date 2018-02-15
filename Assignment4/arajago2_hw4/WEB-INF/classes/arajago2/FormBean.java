package arajago2;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



@ManagedBean
@SessionScoped

public class FormBean  implements Serializable{
	
	private StudentModel sm ;
	private WinningModel winM;
	private EntityManagerFactory factory =Persistence.createEntityManagerFactory("Assignment4");
	private EntityManager em =factory.createEntityManager();
	private ArrayList<StudentModel> aList = new ArrayList<StudentModel>();
	
	private ArrayList<StudentModel> searchList = new ArrayList<StudentModel>();
	

	


	public ArrayList<StudentModel> getSearchList() {
		return searchList;
	}
	
	//double convertedArray[];
	double mean;
	double SDeviation;

	public FormBean()
	{
		sm = new StudentModel();
		winM = new WinningModel();
	} 
	

	public ArrayList<StudentModel> getAList() {
		aList=new ArrayList<>();
    	List<StudentModel> l=em.createQuery("SELECT s FROM StudentModel s", StudentModel.class).getResultList();
        for(StudentModel l1 : l){
        	aList.add(l1);
        }
		return aList;
	}
	
	

	
	public long getId() {
		return sm.getId();
	}
	
	public String getfName() {
		return sm.getfName();
	}
	public void setfName(String fName) {
		sm.setfName(fName);
	}
	public String getlName() {
		return sm.getlName();
	}
	public void setlName(String lName) {
		sm.setlName(lName);;
	}
	public String getAddress() {
		return sm.getAddress();
	}
	public void setAddress(String address) {
		sm.setAddress(address);
	}
	public String getCity() {
		return sm.getCity();
	}
	public void setCity(String city) {
		sm.setCity(city);;
	}
	public String getState() {
		return sm.getState();
	}
	public void setState(String state) {
		sm.setState(state);;
	}
	public String getZip() {
		return sm.getZip();
	}
	

	public void setZip(String zip) throws MalformedURLException, IOException {
		sm.setZip(zip);
		
	}
	
	
	public String getContactNumber() {
		return sm.getContactNumber();
	}
	public void setContactNumber(String contactNumber) {
		sm.setContactNumber(contactNumber);;
	}
	public String getEmail() {
		return sm.getEmail();
	}
	public void setEmail(String email) {
		sm.setEmail(email);;
	}
	public Date getDateSurvey() {
		return sm.getDateSurvey();
	}
	public void setDateSurvey(Date dateSurvey) {
		sm.setDateSurvey(dateSurvey);;
	}
	public Date getStartDate() {
		return sm.getStartDate();
	}
	public void setStartDate(Date startDate) {
		sm.setStartDate(startDate);
	}
	public String[] getCampusRating() {
		return sm.getCampusRating();
	}
	public void setCampusRating(String[] campusRating) {
		sm.setCampusRating(campusRating);
	}
	public String getSource() {
		return sm.getSource();
	}
	public void setSource(String source) {
		sm.setSource(source);
	}
	public String getRecommend() {
		return sm.getRecommend();
	}
	public void setRecommend(String recommend) {
		sm.setRecommend(recommend);
	}
	public String getRaffle() {
		return sm.getRaffle();
	}
	public void setRaffle(String raffle) {
		sm.setRaffle(raffle);
	}
	public String getComments() {
		return sm.getComments();
	}
	public void setComments(String comments) {
		sm.setComments(comments);
	}

	
	
	
	public double getSD() {
		return SDeviation;
	}



	public double getMean1() {
		return mean;
	}


	
	
	
	

	public String getCheckBox(){
		return sm.getCheckBox();
	}
	
	public void init(){
		sm=new StudentModel();
	}
	
	public String actionController(){
		StudentService ss=new StudentService();
		aList.add(sm);
		//setAList(aList);
		String raf=sm.getRaffle();
		String[] rafNum = raf.split(",");
		double convertedArray[] = winM.getConvertedArray(rafNum);
		 mean = WinningModel.findMean(convertedArray);
		SDeviation=WinningModel.getSDeviation(convertedArray);
		System.out.println(SDeviation+"  YO");
		String result=ss.getResult(mean);		
		
		em.getTransaction().begin();
		em.persist(sm);
		em.getTransaction().commit();

		return result;	
	} 
	
	public String actionControllerMethod2() throws Exception{
	
		
		searchList = new ArrayList<>();
		

    	/*  Condition for exactly one input  */
    	if((!getfName().equals("")&&!getfName().equals(null))&&(getlName().equals("")||getlName().equals(null))&&(getCity().equals("")||getCity().equals(null))&&(getState().equals("")||getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName", StudentModel.class).setParameter("fName", getfName()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    	}else if((getfName().equals("")||getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(getCity().equals("")||getCity().equals(null))&&(getState().equals("")||getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName", StudentModel.class).setParameter("lName", getlName()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb)
    		searchList.add(s1);
		}else if((getfName().equals("")||getfName().equals(null))&&(getlName().equals("")||getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(getState().equals("")||getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.city = :city", StudentModel.class).setParameter("city", getCity()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb)
    		searchList.add(s1);
		}else if((getfName().equals("")||getfName().equals(null))&&(getlName().equals("")||getlName().equals(null))&&(getCity().equals("")||getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.state = :state", StudentModel.class).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb)
    		searchList.add(s1);
    		/*---------------------------------------------------------------------------------*/	
    		
    	
    		
        	/*  Condition for exactly two input:  First and one from remaining three  */
		}else if((!getfName().equals("")&&!getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(getCity().equals("")||getCity().equals(null))&&(getState().equals("")||getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName", StudentModel.class).setParameter("fName", getfName()).setParameter("lName", getlName()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!getfName().equals("")&&!getfName().equals(null))&&(getlName().equals("")||getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(getState().equals("")||getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.city = :city", StudentModel.class).setParameter("fName", getfName()).setParameter("city", getCity()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!getfName().equals("")&&!getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(getCity().equals("")||getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.state = :state", StudentModel.class).setParameter("fName", getfName()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    		
    		/*---------------------------------------------------------------------------------*/	    		
    		
        	/*  Condition for exactly two input:  Second and (Third or Fourth)  */
		}else if((getfName().equals("")||getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(getState().equals("")||getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName AND s.city = :city", StudentModel.class).setParameter("fName", getfName()).setParameter("city", getCity()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((getfName().equals("")||getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(getCity().equals("")||getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName AND s.state = :state", StudentModel.class).setParameter("fName", getfName()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    		/*---------------------------------------------------------------------------------*/	 
    		
        	/*  Condition for exactly two input:  Only Third AND Fourth  */
    		
		}else if((getfName().equals("")||getfName().equals(null))&&(getlName().equals("")||getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.city = :city AND s.state = :state", StudentModel.class).setParameter("city", getCity()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
           /*---------------------------------------------------------------------------------*/
    			
    			/*  Condition for exactly THRE input  */	
		}else if((!getfName().equals("")&&!getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(getState().equals("")||getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName AND s.city = :city", StudentModel.class).setParameter("fName", getfName()).setParameter("lName", getlName()).setParameter("city", getCity()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!getfName().equals("")&&!getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(getCity().equals("")||getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName AND s.state = :state", StudentModel.class).setParameter("fName", getfName()).setParameter("lName", getlName()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!getfName().equals("")&&!getfName().equals(null))&&(getlName().equals("")||getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.city = :city AND s.state = :state", StudentModel.class).setParameter("fName", getfName()).setParameter("city", getCity()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((getfName().equals("")||getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName AND s.city = :city AND s.state = :state", StudentModel.class).setParameter("lName", getlName()).setParameter("city", getCity()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    		
    		/*---------------------------------------------------------------------------------*/
    		
    		
    		/*  Condition for exactly FOUR input  */
		}else if((!getfName().equals("")&&!getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName AND s.city = :city AND s.state = :state", StudentModel.class).setParameter("fName", getfName()).setParameter("lName", getlName()).setParameter("city", getCity()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}

    		/*---------------------------------------------------------------------------------*/
			
		}else {
			return "Error";
		}
    	
    	    	return "SearchResult";

	} 
	
	
	public String deleteData(long id){
		StudentModel std = null;
    	List<StudentModel> li =em.createQuery("SELECT s FROM StudentModel s WHERE s.id = :id", StudentModel.class).setParameter("id", id).getResultList();
    	for(StudentModel l1: li){
    		std = l1;
    	}
    	em.getTransaction().begin();
    	em.remove(std);
    	em.getTransaction().commit();
    	searchList.remove(std);
    	return "SearchResult";
    }
	
	
	
	private static final String recOptions = "Likely,Very Likely,Unlikely"; 
	private static final String[] recOptionsArray =	recOptions.split(",");
	public List<String> autoRecommend(String firstName)
	{
		List<String> find = new ArrayList<String>(); 
		for(String possibleRecommend: recOptionsArray)
		{
			if(possibleRecommend.toUpperCase().startsWith(firstName.toUpperCase()))
			{
				find.add(possibleRecommend);
			}
		}
		return(find);
	 }
	
	
	
	
	
	
	
	
	
	
	
}
