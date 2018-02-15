/*
 * Ajay Adithya
 * Managed bean to manipulate and validate form data
 * 
 */

package as3;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response;

import java.io.*;
import java.util.*;

@ManagedBean(name= "formBean")
public class FormBean {

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
	
	public FormBean cityState;
	
	@ManagedProperty(value="#{winningBean}")
	private WinningBean winResult;
	
	private ArrayList<HashMap<String, String>> flist = new ArrayList<HashMap<String, String>>();
	
	public FormBean()
	{
		
	}

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
		
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://ec2-52-55-187-187.compute-1.amazonaws.com/645assign-3/webresources/zips/");
        WebTarget resourceWebTarget;
        resourceWebTarget = target.path(this.zip);
       
        Invocation.Builder invocationBuilder;
        invocationBuilder = resourceWebTarget.request(MediaType.TEXT_PLAIN);
        System.out.println(resourceWebTarget.getUri());
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());
        
        String s = response.readEntity(String.class);
        System.out.println("City"+s.split("-")[0]);
        System.out.println("State"+s.split("-")[1]);
        setCity(s.split("-")[0]);
        setState(s.split("-")[1]);
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

	public FormBean getCityState() {
		return cityState;
	}

	public void setCityState(FormBean cityState) {
		this.cityState = cityState;
	}
	
	public WinningBean getWinResult() {
		return winResult;
	}

	public void setWinResult(WinningBean winResult) {
		this.winResult = winResult;
	}

	public ArrayList<HashMap<String, String>> getFlist() {
		return flist;
	}

	public void setFlist(ArrayList<HashMap<String, String>> flist) {
		this.flist = flist;
	}

	public String submit() throws IOException
	{
		RaffleValidation();
		try 
		{
			writeToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (winResult.getMean() > 90) {
			return "success-winner";
		} else {
			return "success";
		}
	}
	
public List<String> completeRecommends(String query) {
		List<String> results = new ArrayList<String>();
		 results.add("Very Likely");
		results.add("Likely");
		results.add("Unlikely");
		return results;
		}
		
		public void validateRaffle(FacesContext context,
				UIComponent componenttoValidate, Object value){
			
			String validateString = (String)value;
			context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("*Invalid raffle values, Enter 10 comma separated values between 1 and 100");

			if(!(helpvalidateRaffle(validateString))){
				System.out.println("-----------VALIDATE RAFFLE ERROR ---------------");

				throw new ValidatorException(message);
			}
		}
		public boolean helpvalidateRaffle(String validateString){
			
			String[] integerArray = validateString.split(",");

			for(int i=0 ;i<integerArray.length; i++){
				if(integerArray[i] == "")
					continue;
				else
					integerArray[i] = integerArray[i].trim();
			}
			
			try{
					if(integerArray.length > 10){
						return false;
					}else if(integerArray.length < 10){
						return false;
					}else{
						for(int i=0; i<integerArray.length; i++){
						if(Integer.parseInt(integerArray[i]) > 100){
						 return false;
					 }
						}
						return true;
					}
			}catch(NumberFormatException nfe){
				return false;
			}
		}

	
	public void RaffleValidation() throws IOException
	{
		String raffle=getRaffle();
		String[] raffleValues = raffle.split(",");
		
		double mean = 0;
		for (int i = 0; i < raffleValues.length; i++)
			mean = mean + Integer.parseInt(raffleValues[i]);
		mean = mean / raffleValues.length;

		double sd = 0, temp = 0;
		for (int i = 0; i < raffleValues.length; i++)
			temp += Math.pow(Integer.parseInt(raffleValues[i]) - mean, 2);
		System.out.println(sd);
		sd = Math.sqrt(temp / (raffleValues.length - 1));
		System.out.println(sd);
		winResult.setMean(mean);
		winResult.setStandardDeviation(sd);
	}
	
	public void writeToFile() throws IOException
	{
		File file = new File("ListOfSurveyData.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileWriter bw = new FileWriter(file,true);
		
		StringBuilder builder= new StringBuilder();
		for(String s: getLiked())
		{
			builder.append(s);
			builder.append(",");
		}
		String liked_value = builder.toString();
		 
		try
		{
			bw.write(getFirstName() + "|" + getLastName() + "|" + getStreet() + "|" + getCity() + "|" + getState() + "|" + getZip() + "|" + getNumber() + "|" + getEmail() + "|" + getDos() + "|" + liked_value + "|" + getHear() + "|" + getRecommend() + "|" + getRaffle() + "|" + getComments() + "|" + System.getProperty("line.separator"));
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			bw.close();
		}
	}
	
	public ArrayList<HashMap<String, String>> displaySurvey() throws IOException
	{
		ArrayList<HashMap<String, String>> temp_flist = new ArrayList<HashMap<String, String>>();
		BufferedReader br = null;
		String all;
		StringBuilder sb = null;
		
		try
		{
			FileReader fileReader = new FileReader("ListOfSurveyData.txt");
			br = new BufferedReader(fileReader);
			String line = br.readLine();
			sb = new StringBuilder();
			while (line != null) 
			{
				String StudentFormData[] = line.split("\\|");
				HashMap<String, String> hashobj = new HashMap<String, String>();
			
				hashobj.put("firstName",StudentFormData[0]);
				hashobj.put("lastName",StudentFormData[1]);
				hashobj.put("street",StudentFormData[2]);
				hashobj.put("city",StudentFormData[3]);
				hashobj.put("state",StudentFormData[4]);
				hashobj.put("zip",StudentFormData[5]);
				hashobj.put("number",StudentFormData[6]);
				hashobj.put("email",StudentFormData[7]);
				hashobj.put("dos",StudentFormData[8]);
				hashobj.put("liked",StudentFormData[9]);
				System.out.print(StudentFormData[9]);
				hashobj.put("hear",StudentFormData[10]);
				hashobj.put("recommend",StudentFormData[11]);
				hashobj.put("raffle",StudentFormData[12]);
				hashobj.put("comment",StudentFormData[13]);
				temp_flist.add(hashobj);
				line = br.readLine();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		setFlist(temp_flist);
		all = sb.toString();
		br.close();
		return flist;
	}
	
	public void main (String[] args){
    	
	}
}
