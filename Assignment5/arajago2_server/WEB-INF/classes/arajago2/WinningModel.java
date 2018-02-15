
package arajago2;


import java.io.Serializable;

public class WinningModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6447883342657055090L;
	private static double SD;
	private double mean1;
	
	
	public static double getSD() {
		return SD;
	}


	public static void setSD(double sD) {
		SD = sD;
	}


	public double getMean1() {
		return mean1;
	}


	public void setMean1(double mean1) {
		this.mean1 = mean1;
	}


	public double[] getConvertedArray(String[] rafNum){
		double [] temp = new double[rafNum.length];
		for(int i=0;i<rafNum.length;i++){
			temp[i]=Double.parseDouble(rafNum[i]);
		}
		return temp;
	}
	
	
	public static double getSDeviation(double[] convertedArray) {
		double [] temp1 = new double[convertedArray.length];
	    temp1 = convertedArray;
		double tempMean = findMean(temp1);
		double squareSum = 0;

		for (int i = 0; i < temp1.length; i++) {
		squareSum += Math.pow(temp1[i] - tempMean, 2);
		}
        SD= Math.sqrt((squareSum) / (temp1.length - 1));
		return Math.sqrt((squareSum) / (temp1.length - 1)); 
		
	}
	
	
	public static double findMean(double[] convertedArray) {
		double sum = 0;

		for (int i = 0; i < convertedArray.length; i++) {
		sum += convertedArray[i];
		}
		return sum / convertedArray.length;
		}






	
	

}
