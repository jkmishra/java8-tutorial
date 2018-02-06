/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author jugul.mishra Feb 5, 2018 4:34:26 PM
 *
 */
public class BricsCountryUtil {
	private static BricsCountry[] buildCountries;
	static {
		BricsCountry brazil = new BricsCountry("brazil", 1000);
		BricsCountry rasia = new BricsCountry("rusia", 1000);
		BricsCountry india = new BricsCountry("india", 1000);
		BricsCountry china = new BricsCountry("china", 1000);
		BricsCountry southAfrica = new BricsCountry("south africa", 1000);
		BricsCountry[] buildCountry = { brazil, rasia, india, china, southAfrica };
		buildCountries = buildCountry;
	}

	public static List<BricsCountry> buildList() {
		return Arrays.asList(buildCountries);
	}

	public static TreeSet<BricsCountry> buildTreeSet() {
		return new TreeSet<>(Arrays.asList(buildCountries));
	}

	public static Map<String, BricsCountry> buildMap() {

		return Arrays.asList(buildCountries).stream().collect(Collectors.toMap(BricsCountry::getCountryName, b -> b));
	}

	public static ConcurrentMap<String, Object> buildConcurrentMap() {
		return Arrays.asList(buildCountries).stream()
				.collect(Collectors.toConcurrentMap(BricsCountry::getCountryName, b -> b));
	}
}
