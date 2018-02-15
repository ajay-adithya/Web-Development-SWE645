package assignment2_645;


import java.io.*;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name="studentservice")
public class StudentService {

	public  StudentService (){
		
	}
	private ArrayList<HashMap<String, String>> flist = new ArrayList<HashMap<String, String>>();
	private String surveyList;
	
	@ManagedProperty(value="#{formBean}")
	private FormBean fb = new FormBean();
	
	@ManagedProperty(value="#{winningBean}")
	private WinningBean winResult;
	
	
	public FormBean getFb() {
		return fb;
	}

	public void setFb(FormBean fb) {
		this.fb = fb;
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

	public String getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(String surveyList) {
		this.surveyList = surveyList;
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
	
	public void RaffleValidation() throws IOException
	{
		String raffle=fb.getRaffle();
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
		File file = new File("mySurveyData.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileWriter bw = new FileWriter(file,true);
		
		StringBuilder builder= new StringBuilder();
		for(String s: fb.getLiked())
		{
			builder.append(s);
			builder.append(",");
		}
		String liked_value = builder.toString();
		 
		try
		{
			bw.write(fb.getFirstName() + "|" + fb.getLastName() + "|" + fb.getStreet() + "|" + fb.getCity() + "|" + fb.getState() + "|" + fb.getZip() + "|" + fb.getNumber() + "|" + fb.getEmail() + "|" + fb.getDos() + "|" + liked_value + "|" + fb.getHear() + "|" + fb.getRecommend() + "|" + fb.getRaffle() + "|" + fb.getComments() + "|" + System.getProperty("line.separator"));
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
			FileReader fileReader = new FileReader("mySurveyData.txt");
			br = new BufferedReader(fileReader);
			String line = br.readLine();
			sb = new StringBuilder();
			while (line != null) 
			{
				String StudentFormData[] = line.split("\\|");
				HashMap<String, String> hashobj = new HashMap<String, String>();
			
				hashobj.put("FirstName",StudentFormData[0]);
				hashobj.put("LastName",StudentFormData[1]);
				hashobj.put("street",StudentFormData[2]);
				hashobj.put("city",StudentFormData[3]);
				hashobj.put("state",StudentFormData[4]);
				hashobj.put("zip",StudentFormData[5]);
				hashobj.put("number",StudentFormData[6]);
				hashobj.put("email",StudentFormData[7]);
				hashobj.put("dos",StudentFormData[8]);
				hashobj.put("liked",StudentFormData[9]);
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
	
}
