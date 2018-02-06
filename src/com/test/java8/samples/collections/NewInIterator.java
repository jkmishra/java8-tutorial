/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author jugul.mishra 
 * Feb 5, 2018 10:22:38 PM
 *
 */
public class NewInIterator {
	public static void main(String[] args) {
		Student s1 = new Student("Shyam", 22);
		Student s2 = new Student("Ram", 23);
		Student s3 = new Student("Mohan", 19);
		Student s4 = new Student(null,0);
		List<Student> list = Arrays.asList(s1, s2, s3,s4);
		Iterator<Student> iterator = list.iterator();
		list.forEach(System.out::println);
		// why foreachremaining
		iterator.next();
		System.out.println("after next");		
		iterator.forEachRemaining(System.out::println);
	}

}
