package arajago2;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("raffleValidator")
public class RaffleValidator implements Validator{
	 @Override
	 public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
	 {
	        if (value == null)
	        {
	            return;
	        }
	        
	        System.out.println(String.valueOf(value));
	        String rafNumStr = String.valueOf(value);
	        String[] raffleNumbers = rafNumStr.split(",");
	        System.out.println(raffleNumbers.length);
	  
	        if (raffleNumbers.length != 10)
	        {
	            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, null));
	        }
	  
	        
	        
	    }
	
	
	
	
	
	
	
	
	
	
	

}
