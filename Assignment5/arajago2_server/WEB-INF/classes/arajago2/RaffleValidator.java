
package arajago2;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("raffleValidator")
public class RaffleValidator implements Validator{
	 public void validate(FacesContext context, UIComponent componenttobeValidated, Object value) throws ValidatorException{

	String validateData = (String) value;
	context = FacesContext.getCurrentInstance();
	FacesMessage message = new FacesMessage(
			"Enter atleast, 10 comma separated values between 1 and 100");

	if (!(validateRaffleData(validateData)))
		throw new ValidatorException(message);

}


    

    public boolean validateRaffleData(String validateData) {

	String[] raffleArray = validateData.split(",");

	for (int i = 0; i < raffleArray.length; i++) {
		if (raffleArray[i] == "")
			continue;
		else
			raffleArray[i] = raffleArray[i].trim();
	}

	try {
		if (raffleArray.length < 10) {
			return false;
		} else {
			for (int lcv = 0; lcv < raffleArray.length; lcv++) {
				if ((Integer.parseInt(raffleArray[lcv]) > 100)||(Integer.parseInt(raffleArray[lcv]) < 1)) {
					return false;
				}
			}
			return true;
		}
	} catch (NumberFormatException e) {
		return false;
	}
}

}