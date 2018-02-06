/**
 * 
 */
package com.test.java8.samples.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author jugul.mishra 
 * Feb 5, 2018 9:32:42 PM
 *
 */
public class Student implements Comparable<Student> {
	private String name;
    private int age;
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    
    
    
    
    public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		//int result = 1;
		//result = prime * result + age;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return name.length();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		//if (age != other.age)
		//	return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	public static List<Student> getStudentList(){
        Student s1 = new Student("Ram", 18);
        Student s2 = new Student("Shyam",22);
        Student s3 = new Student("Mohan",19);
        Student s4 = new Student("Mahesh",20);
        Student s5 = new Student("Krishna",21);
        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);
        return list;
    }
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

}
