import java.io.*;
import java.util.*;

public class Complex_Sort {
	public static class Student implements Comparable<Student>{
		String name;
		int id;
		
		public Student(String name, int id) {
			this.name = name;
			this.id = id;
		}
		
		public int compareTo(Student s2) {
			if (!this.name.equals(s2.name))
			{
				return s2.name.compareTo(this.name);
			}
			else
			{
				return s2.id - this.id;
			}
		}
		
		public String toString() {
			return name + " " + id;
		}
	}
	public static class Student2{
		String name;
		int id;
		
		public Student2(String name, int id) {
			this.name = name;
			this.id = id;
		}
		
		public String toString() {
			return name + " " + id;
		}
	}
	
	public static void main(String[] args) throws IOException{
		ArrayList<Student2> students = new ArrayList<Student2>();
		Student2 s = new Student2("Bob", 5);
		students.add(s);
		s = new Student2("Bob", 2);
		students.add(s);
		s = new Student2("Jack", 3);
		students.add(s);
		s = new Student2("Jerry", 7);
		students.add(s);
		s = new Student2("Abby", 9);
		students.add(s);
		s = new Student2("Zach", 0);
		students.add(s);
		Collections.sort(students, new Comparator<Student2>() {
			public int compare(Student2 s1, Student2 s2) {
				if (!s1.name.equals(s2.name))
				{
					return s2.name.compareTo(s1.name);
				}
				else
				{
					return s2.id - s1.id;
				}
			}
		});
		System.out.println(students);
	}
}
