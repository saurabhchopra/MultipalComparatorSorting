package com.main.java;

import java.util.Comparator;
import java.util.List;

public class StudentComparison {

	public enum SortOrder {
		ASCENDING, DESCENDING
	}

	public static Comparator<Student> getComparator(final SortOrder order,
			final List<StudentComparator> options) {
		return new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				for (StudentComparator comparator : options) {
					int result = comparator.compare(o1, o2);
					if (result != 0) {
						if (order == SortOrder.ASCENDING) {
							return result;
						} else {
							return result * (-1);
						}
					}
				}
				return 0;
			}
		};
	}
	
	public enum StudentComparator implements Comparator<Student> {
		ID_SORT {
			public int compare(Student o1, Student o2) {
				return Integer.valueOf(o1.getId()).compareTo(o2.getId());
			}
		},
		NAME_SORT {
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		},
		ADDRESS_SORT {
			public int compare(Student o1, Student o2) {
				return o1.getAddress().compareTo(o2.getAddress());
			}
		}
	}
}
