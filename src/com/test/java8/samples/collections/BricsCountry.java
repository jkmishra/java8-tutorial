/**
 * 
 */
package com.test.java8.samples.collections;

/**
 * @author jugul.mishra 
 * Feb 5, 2018 4:32:21 PM
 *
 */
public class BricsCountry extends Country implements Comparable<BricsCountry> {
	@Override
	public String toString() {
		return "BricsCountry [countryName=" + countryName + ", population=" + population + "]";
	}

	private String countryName;
	private long population;
	
	public BricsCountry(String countryName, long population){
		super(countryName, population);
		this.countryName=countryName;
		this.population=population;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(BricsCountry o) {
		// TODO Auto-generated method stub
		return this.countryName.compareTo(o.countryName);
	}

}
