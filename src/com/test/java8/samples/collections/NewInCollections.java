/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author jugul.mishra Feb 5, 2018 4:22:08 PM
 *
 */
public class NewInCollections {
	public static void main(String[] args) {
		NavigableSet<BricsCountry> navigableSet = BricsCountryUtil.buildTreeSet();
		System.out.println(navigableSet);
		// new method to create unmodifible navigable set

		NavigableSet<BricsCountry> unmodifiableNavigableSet = Collections.unmodifiableNavigableSet(navigableSet);

		unmodifiableNavigableSet.add(new BricsCountry("America", 1000));
		Map<BricsCountry, BricsCountry> collect = navigableSet.stream().collect(Collectors.toMap(k -> k, v -> v));
		NavigableMap<BricsCountry, BricsCountry> unmodifiableNavigableMap = Collections
				.unmodifiableNavigableMap(new TreeMap<>(collect));
		System.out.println(unmodifiableNavigableMap);
		

		 //NavigableSet s = Collections.synchronizedNavigableSet(new TreeSet());
		// public static <K,V> NavigableMap<K,V>
		// synchronizedNavigableMap(NavigableMap<K,V> m)
		
		// returns dynamic type safe 
		
		 //public static <E> Queue<E> checkedQueue(Queue<E> queue, Class<E> type)
		// public static <E> NavigableSet<E> checkedNavigableSet(NavigableSet<E>
		// s,Class<E> type)
		// public static <K,V> NavigableMap<K,V>
		// checkedNavigableMap(NavigableMap<K,V> m,Class<K> keyType,Class<V>
		// valueType)
		// public static <E> SortedSet<E> emptySortedSet()
		// emptyNavigableSet
		// emptySortedMap
		// emptyNavigableMap

		// java.util.List<E>
		
		checkedCollections();

	}

	// checked collections

	public static void checkedCollections() {
		List myList = new ArrayList();
		myList.add("one");
		myList.add("two");
		myList.add("three");
		myList.add("four");
		Collection chkList = Collections.checkedCollection(myList, String.class);
		System.out.println("Checked list content: " + chkList);
		// you can add any type of elements to myList object
		myList.add(10);
		// you cannot add any type of elements to chkList object, doing so
		// throws ClassCastException
		chkList.add(10); // throws ClassCastException
	}

}
