/**
 * 
 */
package com.test.java8.samples.collections;

/**
 * @author jugul.mishra 
 * Feb 5, 2018 5:25:34 PM
 *
 */
public class Country {
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", population=" + population + "]";
	}

	private String countryName;
	private long population;
	
	public Country(String countryName, long population){
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
}
