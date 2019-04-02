package com.sengedou.bean;

public class StudentBean {
	
	private int studentId;
	private String studentName;
	private ClassBean cl;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public ClassBean getCl() {
		return cl;
	}
	public void setCl(ClassBean cl) {
		this.cl = cl;
	}
	@Override
	public String toString() {
		return "StudentBean [studentId=" + studentId + ", studentName=" + studentName + ", cl=" + cl + "]";
	}
	
	
}
