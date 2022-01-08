package org.student;

import org.department.Department;

public class Student extends Department {
	
	protected void studentName(String name) {
		System.out.println("Student name was " + name);
	}
	
	protected void studentDept(String name) {
		System.out.println("Student department is " + name);
	}
	
	protected void studentId(int id) {
		System.out.println("Student ID is " + id);
	}
	
	public static void main(String[] args) {
		
		Student student = new Student();
		
		student.studentName("Depak");
		student.studentDept("CS");
		student.studentId(2451322);
		student.deptName();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
				
	}
}
