package com.edu.test3;

/**
 * Student类
 * @author sunny
 *
 */
public class Student {
	private Integer studentId;
	private String studentName;
	private Double averageScore;
	private static Integer nextId;
	
	public Student() {
		
	}
	public Student(Integer studentId) {
		this.studentId = studentId;
		nextId = studentId + 1;
	}
	
	@Override
	public String toString() {
		return "studentId=" + studentId 
				+ "; studentName=" + studentName
				+ "; averageScore=" + averageScore
				+"; nextId=" + nextId;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	public Integer getNextId() {
		return nextId;
	}
}
