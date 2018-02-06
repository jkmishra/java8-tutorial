/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jugul.mishra Feb 5, 2018 9:05:16 PM
 *
 */
public class NewInComparator {
	public static void main(String[] args) {
		//	reverse();
		//thenComparing();
		comparatorNaturalOrder();
		//nullfirst();
	}

	private static void reverse() {
		List<Student> list = Student.getStudentList();
		Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
		Collections.sort(list, ageComparator);
		list.forEach(s -> System.out.println("Name:" + s.getName() + " Age:" + s.getAge()));
		// Using reversed order for sorting
		System.out.println("--Using reversed order for sorting--");
		Collections.sort(list, ageComparator.reversed());
		list.forEach(s -> System.out.println("Name:" + s.getName() + " Age:" + s.getAge()));
	}

	private static void thenComparing() {
		Student s1 = new Student("Shyam", 22);
		Student s2 = new Student("Ram", 23);
		Student s3 = new Student("Mohan", 19);
		Student s4 = new Student("Awadh", 19);
		List<Student> list = Arrays.asList(s1, s2, s3,s4	);
		Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		//ageComparator.thenComparing(nameComparator)
		//Collections.sort(list, ageComparator);
		//Collections.sort(list, nameComparator);
		Collections.sort(list, ageComparator.thenComparing(nameComparator));
		list.forEach(s -> System.out.println("Name:" + s.getName() + " Age:" + s.getAge()));
	}

	private static void comparatorNaturalOrder() {
		List<Student> list = Student.getStudentList();
		// need student class to implement comparable
		Collections.sort(list, Comparator.naturalOrder());
		list.forEach(s -> System.out.println("Name:" + s.getName() + " Age:" + s.getAge()));
		// Using natural reversed order for sorting
		System.out.println("--Using natural reversed order for sorting--");
		Collections.sort(list, Comparator.reverseOrder());
		list.forEach(s -> System.out.println("Name:" + s.getName() + " Age:" + s.getAge()));
	}
	
	private static void nullfirst() {
		Student s1 = new Student("Shyam", 22);
		Student s2 = new Student("Ram", 23);
		Student s3 = new Student("Mohan", 19);
		Student s4 = new Student(null,0);
		List<Student> list = Arrays.asList(s1, s2, s3,s4	);
		//Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		Comparator<Student> nameComparator =Comparator.comparing(Student::getName,Comparator.nullsFirst(Comparator.naturalOrder()));
		Collections.sort(list, nameComparator);
		list.forEach(s -> System.out.println("Name:" + s.getName() + " Age:" + s.getAge()));
	}


}
