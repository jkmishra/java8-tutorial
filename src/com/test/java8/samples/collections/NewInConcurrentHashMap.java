/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jugul.mishra Feb 6, 2018 11:14:59 AM
 *
 */
public class NewInConcurrentHashMap {
	public static void main(String[] args) {
		BricsCountry brazil = new BricsCountry("brazil", 1000);
		BricsCountry rusia = new BricsCountry("rusia", 1000);
		BricsCountry india = new BricsCountry("india", 1000);
		BricsCountry china = new BricsCountry("china", 2000);
		BricsCountry southAfrica = new BricsCountry("south africa", 1000);

		ConcurrentHashMap<String, BricsCountry> map = new ConcurrentHashMap<>();
		map.put("brazil", brazil);
		map.put("rusia", rusia);
		map.put("india", india);
		map.put("china", china);
		map.put("southAfrica", southAfrica);

		map.forEach((k, v) -> System.out.println(k + "contains " + v));

		// Adding parallelism threshold
		map.forEach(1, (k, v) -> v.getPopulation() + " is population of " + k, System.out::println);

		// search if key value pair qualify then return result else return null

		System.out.println(map.search(1, (k, v) -> {
			return v.getPopulation() > 1000 ? k : null;
		}));

		// search key

		System.out.println(map.searchKeys(1, key -> key.equals("china") ? key : null));

		// search value

		System.out.println(map.searchValues(1, v -> v.getCountryName().equals("india") ? v : null));

		// reduce its have almost 19 overload
		/*System.out.println(map.reduce(10, (k, v) -> v.getPopulation(), (total, elem) -> total + elem));
		System.out.println(map.reduceKeys(1, (k1, k2) -> k1.compareTo(k2) < 0 ? k1 : k2));
		System.out.println(map.reduceValues(1, BricsCountry::getPopulation, (total, elem) -> total + elem));*/
		
		
		ConcurrentHashMap<String, Integer> reducedMap = new ConcurrentHashMap<>();
		reducedMap.put("One", 1);
		reducedMap.put("Two", 2);
		reducedMap.put("Three", 3);
		System.out.println("reduce example => " 
		 +reducedMap.reduce(2, (k, v) -> v*2, (total, elem) -> total + elem)); 
		System.out.println("reduceKeys example => " 
		 +reducedMap.reduceKeys(2, (key1, key2) -> key1.length() > key2.length() ? key1 + "-"+key2 : key2 + "-"+key1)); 
		System.out.println("reduceValues example => " 
		 +reducedMap.reduceValues(2, (v) -> v*2 , (value1, value2) -> value1 > value2 ? value1 - value2 : value2 - value1));
		System.out.println("After reduce => " +reducedMap);
		
		
		// the actual count may differ if there are concurrent insertions or
		// removals . used instead of size()
		System.out.println(map.mappingCount());
		// KeySetView<Object, Boolean> newKeySet =
		// ConcurrentHashMap.newKeySet();
		System.out.println();
	}

}
