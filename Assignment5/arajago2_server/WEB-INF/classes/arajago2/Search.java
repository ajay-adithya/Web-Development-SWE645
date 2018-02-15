
package arajago2;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)

public interface Search {
	@WebMethod ArrayList<StudentModel> getSearchList(String fName, String lName,String city,String state);
	

}
