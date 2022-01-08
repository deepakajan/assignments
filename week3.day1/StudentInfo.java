package org.student;


public class StudentInfo {
	
	protected void getStudentInfo(int id) {
		System.out.println("Student ID: " + id);
	}
	
	protected void getStudentInfo(int id, String name) {
		System.out.println("Student ID: " + id + " and " + "Student Name is " + name);
	}
	
	protected void getStudentInfo(String email, long phone) {
		System.out.println("Student E-Mail: " + email + " and " + "Student Phone Number is " + phone);
	}
	
	public static void main(String[] args) {
		
		StudentInfo student = new StudentInfo();
		
		student.getStudentInfo(227); //int
		student.getStudentInfo(227, "Deepak"); //int, string
		student.getStudentInfo("deepakvrajan@gmail.com", 9876541230L);
				
	}
}

