
package arajago2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ManagedBean
@SessionScoped
public class SearchBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6892684298988923189L;

	public SearchBean(){}
	
	private String fName, lName, city,state;
	private ArrayList<StudentModel> searchList = new ArrayList<StudentModel>();
	
	private EntityManagerFactory factory =Persistence.createEntityManagerFactory("HW5WS");
	private EntityManager em =factory.createEntityManager();
	
	FormBean FB =new FormBean();

	public ArrayList<StudentModel> getSearchList() {
		return searchList;
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

	
public String actionControllerMethod2() throws Exception{
	
		
		searchList = new ArrayList<>();
	
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
    		
		}else if((getfName().equals("")||getfName().equals(null))&&(getlName().equals("")||getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.city = :city AND s.state = :state", StudentModel.class).setParameter("city", getCity()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
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
    		
    	}else if((!getfName().equals("")&&!getfName().equals(null))&&(!getlName().equals("")&&!getlName().equals(null))&&(!getCity().equals("")&&!getCity().equals(null))&&(!getState().equals("")&&!getState().equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName AND s.city = :city AND s.state = :state", StudentModel.class).setParameter("fName", getfName()).setParameter("lName", getlName()).setParameter("city", getCity()).setParameter("state", getState()).getResultList();
    		if(sdb==null)
    			return "Error";
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}

    		/*---------------------------------------------------------------------------------*/
			
		}
    	
    	    	return "SearchResults";

	} 
	
	
	

}
