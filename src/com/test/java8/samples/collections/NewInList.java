/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @author jugul.mishra Feb 5, 2018 6:16:29 PM
 *
 */
public class NewInList {

	public static void main(String[] args) {
		// new method in List
		// spliterator

		List<BricsCountry> list = BricsCountryUtil.buildList();
		System.out.println(list);
		Spliterator<BricsCountry> spliterator = list.spliterator();
		System.out.println(spliterator.characteristics());
		System.out.println(spliterator.estimateSize());
		// System.out.println(spliterator.getComparator());

		// list.sort(Comparator)
		list.sort((BricsCountry c1, BricsCountry c2) -> c1.getCountryName().compareTo(c2.getCountryName()));
		System.out.println(list);

		// list.removeIf(operator);
		removeIf();

		// replaceAll
		replaceAll();

	}

	public static void removeIf() {
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(new Person(1, "Mahesh"));
		listPerson.add(new Person(2, "Ram"));
		listPerson.add(new Person(3, "Krishna"));
		Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getPid() + ", Name:" + p.getName());
		System.out.println("---Before delete---");
		listPerson.forEach(style);
		int pid = 2;
		Predicate<Person> personPredicate = p -> p.getPid() == pid;
		listPerson.removeIf(personPredicate);
		System.out.println("---After delete---");
		listPerson.forEach(style);

	}

	public static void replaceAll() {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Mahesh"));
		list.add(new Person(2, "Ram"));
		list.add(new Person(3, "Krishna"));
		Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getPid() + ", Name:" + p.getName());
		System.out.println("---Before replaceAll---");
		list.forEach(style);
		UnaryOperator<Person> unaryOpt = pn -> modifyName(pn);
		list.replaceAll(unaryOpt);
		System.out.println("---After replaceAll---");
		list.forEach(style);
	}

	private static Person modifyName(Person p) {
		p.setName(p.getName().concat(" -God"));
		return p;
	}

}
