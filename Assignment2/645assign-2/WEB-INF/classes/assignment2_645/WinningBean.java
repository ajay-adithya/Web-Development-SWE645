package assignment2_645;

import javax.faces.bean.*;
@ManagedBean(name= "winningBean", eager = true)
public class WinningBean {
	 private double mean;
	 private double standardDeviation;
	 
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
}
