/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jugul.mishra Feb 5, 2018 10:40:45 PM
 *
 */
public class NewInMap {
	public static void main(String[] args) {
		HashMap<Student, String> hashMap = new HashMap();

		String s1 = "s";

		/*
		 * We are starting from index 10 to make sure that hashCode values of
		 * Student object remains same and we get them in same bucket in HashMap
		 */
		for (int i = 10; i < 25; i++) {
			Student s = new Student(s1 + i, 2017);
			hashMap.put(s, s.getName());
		}

		//System.out.println(hashMap);

		// default V getOrDefault(Object key,V defaultValue)

		//System.out.println(hashMap.getOrDefault(new Student("s90", 2017), "test"));

		// foreach
		
		// default void replaceAll(BiFunction<? super K,? super V,? extends V>
		// function)
		hashMap.replaceAll((k,v)->v+10);
		//hashMap.forEach((k,v)->System.out.println(v));
		
		//default V putIfAbsent(K key,V value)
		
		Map<String, BricsCountry> buildMap = BricsCountryUtil.buildMap();
		System.out.println(buildMap.size());
		BricsCountry bricsCountry=new BricsCountry("india", 1000);
		buildMap.putIfAbsent("America",bricsCountry );
		System.out.println(buildMap.size());
		
		
		//default boolean remove(Object key, Object value);
		// remove only if asssociated value matched
		buildMap.remove("America", bricsCountry);
		System.out.println(buildMap.size());
		
		
		//default V replace(K key,  V value)
		buildMap.computeIfAbsent("india",v-> new BricsCountry("india", 1000));
		
		System.out.println(buildMap.size());
		
		
		// merge
		
		 Map<String, BricsCountry> buildMap2 = BricsCountryUtil.buildMap();
		
		// buildMap2.forEach((k,v)->System.out.println(v));
		 buildMap2.merge("india", new BricsCountry("india", 2000), (v1,v2)->new BricsCountry("india",v1.getPopulation()+v2.getPopulation()));
		
		 buildMap2.forEach((k,v)->System.out.println(v));
		
		
		
	}

}
