package com.sengedou.bean;

import java.util.List;

public class ClassBean {
	
	private int classId;
	private String className;
	private List<StudentBean> student;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<StudentBean> getStudent() {
		return student;
	}
	public void setStudent(List<StudentBean> student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "ClassBean [classId=" + classId + ", className=" + className + ", student=" + student + "]";
	}
	
	
}
