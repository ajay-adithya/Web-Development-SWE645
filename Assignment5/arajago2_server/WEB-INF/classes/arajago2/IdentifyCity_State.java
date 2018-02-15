
package arajago2;

import java.util.*;



public class IdentifyCity_State {

	Map<String, String> zipstatecity;

	public IdentifyCity_State() {
		super();
		zipstatecity = new HashMap<String, String>();
		zipstatecity.put("22312", "VA,Alexandria,22312");
		zipstatecity.put("22030", "VA,Fairfax,22030");
		zipstatecity.put("22301", "MD,Tysons Corner,22301");
		zipstatecity.put("20148", "VA,Ashburn,20148");

	}

	
	public String LookUp( String zip) {

		String match = zipstatecity.get(zip);
		String[] value = match.split(",");
		String cityState = new String(value[1] + "," + value[0]);
		return cityState;

	}

}
