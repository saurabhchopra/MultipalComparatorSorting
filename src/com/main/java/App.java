package com.main.java;

import static com.main.java.StudentComparison.StudentComparator.ID_SORT;
import static com.main.java.StudentComparison.StudentComparator.NAME_SORT;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.main.java.StudentComparison.SortOrder;

public class App {

	public static void main(String[] args) {
		Student s1 = new Student(1, "A", "add 1");
		Student s2 = new Student(2, "D", "add 2");
		Student s3 = new Student(3, "B", "add 3");
		Student s4 = new Student(4, "Z", "add 4");
		Student s5 = new Student(5, "B", "add 5");

		List<Student> studentList = Arrays.asList(s1, s2, s3, s4, s5);
		
		Collections.sort(studentList,
				StudentComparison.getComparator(SortOrder.DESCENDING, Arrays.asList(ID_SORT, NAME_SORT)));

		for (Student student : studentList) {
			System.out.println("name : " + student.getName() + " id : "
					+ student.getId());
		}
	}
}
