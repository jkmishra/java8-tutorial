/**
 * 
 */
package com.test.java8.samples.collections;

/**
 * @author jugul.mishra Feb 5, 2018 8:53:41 PM
 *
 */
public class Person {
	private int pid;
	private String name;

	public Person() {
	}

	public Person(int pid, String name) {
		this.pid = pid;
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
