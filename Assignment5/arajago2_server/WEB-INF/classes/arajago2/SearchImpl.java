
package arajago2;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@WebService(endpointInterface = "arajago2.Search")
public class SearchImpl implements Search {
	
private ArrayList<StudentModel> searchList = new ArrayList<StudentModel>();
	
	private EntityManagerFactory factory =Persistence.createEntityManagerFactory("HW5WS");
	private EntityManager em =factory.createEntityManager();

	@Override
	public ArrayList<StudentModel> getSearchList(String fName, String lName, String city, String state) {
		// TODO Auto-generated method stub

		searchList = new ArrayList<>();
	
    	if((!fName.equals("")&&!fName.equals(null))&&(lName.equals("")||lName.equals(null))&&(city.equals("")||city.equals(null))&&(state.equals("")||state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName", StudentModel.class).setParameter("fName", fName).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    	}else if((fName.equals("")||fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(city.equals("")||city.equals(null))&&(state.equals("")||state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName", StudentModel.class).setParameter("lName", lName).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb)
    		searchList.add(s1);
		}else if((fName.equals("")||fName.equals(null))&&(lName.equals("")||lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(state.equals("")||state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.city = :city", StudentModel.class).setParameter("city", city).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb)
    		searchList.add(s1);
		}else if((fName.equals("")||fName.equals(null))&&(lName.equals("")||lName.equals(null))&&(city.equals("")||city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.state = :state", StudentModel.class).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb)
    		searchList.add(s1);
    		/*---------------------------------------------------------------------------------*/	
    		
    	
    		
        	/*  Condition for exactly two input:  First and one from remaining three  */
		}else if((!fName.equals("")&&!fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(city.equals("")||city.equals(null))&&(state.equals("")||state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName", StudentModel.class).setParameter("fName", fName).setParameter("lName", lName).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!fName.equals("")&&!fName.equals(null))&&(lName.equals("")||lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(state.equals("")||state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.city = :city", StudentModel.class).setParameter("fName", fName).setParameter("city", city).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!fName.equals("")&&!fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(city.equals("")||city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.state = :state", StudentModel.class).setParameter("fName", fName).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    		
    		/*---------------------------------------------------------------------------------*/	    		
    		
        	/*  Condition for exactly two input:  Second and (Third or Fourth)  */
		}else if((fName.equals("")||fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(state.equals("")||state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName AND s.city = :city", StudentModel.class).setParameter("fName", fName).setParameter("city", city).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((fName.equals("")||fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(city.equals("")||city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName AND s.state = :state", StudentModel.class).setParameter("fName", fName).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    		/*---------------------------------------------------------------------------------*/	 
    		
        	/*  Condition for exactly two input:  Only Third AND Fourth  */
    		
		}else if((fName.equals("")||fName.equals(null))&&(lName.equals("")||lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.city = :city AND s.state = :state", StudentModel.class).setParameter("city", city).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
           /*---------------------------------------------------------------------------------*/
    			
    			/*  Condition for exactly THRE input  */	
		}else if((!fName.equals("")&&!fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(state.equals("")||state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName AND s.city = :city", StudentModel.class).setParameter("fName", fName).setParameter("lName", lName).setParameter("city", city).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!fName.equals("")&&!fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(city.equals("")||city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName AND s.state = :state", StudentModel.class).setParameter("fName", fName).setParameter("lName", lName).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((!fName.equals("")&&!fName.equals(null))&&(lName.equals("")||lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.city = :city AND s.state = :state", StudentModel.class).setParameter("fName", fName).setParameter("city", city).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
		}else if((fName.equals("")||fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.lName = :lName AND s.city = :city AND s.state = :state", StudentModel.class).setParameter("lName", lName).setParameter("city", city).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}
    		
    		/*---------------------------------------------------------------------------------*/
    		
    		
    		/*  Condition for exactly FOUR input  */
		}else if((!fName.equals("")&&!fName.equals(null))&&(!lName.equals("")&&!lName.equals(null))&&(!city.equals("")&&!city.equals(null))&&(!state.equals("")&&!state.equals(null))){
    		List<StudentModel> sdb= em.createQuery("SELECT s FROM StudentModel s WHERE s.fName = :fName AND s.lName = :lName AND s.city = :city AND s.state = :state", StudentModel.class).setParameter("fName", fName).setParameter("lName", lName).setParameter("city", city).setParameter("state", state).getResultList();
    		 
    			 
    		for(StudentModel s1:sdb){
    			searchList.add(s1);
    		}

    		/*---------------------------------------------------------------------------------*/
			
		}else {
			 
		}
    	
    	    	return searchList;
		
		
		
		
	}

	
	
	
}
