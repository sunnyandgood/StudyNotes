package com.edu.test3;

/**
 * CollegeStudent类
 * @author sunny
 *
 */
public class CollegeStudent extends Student{
	private Integer courseNum;
	private Double creditHour;
	
	public CollegeStudent() {
		
	}
	public CollegeStudent(Integer studentId) {
		super(studentId);
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"; courseNum=" + courseNum +
				"; creditHour=" + creditHour;
	}
	public Integer getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(Integer courseNum) {
		this.courseNum = courseNum;
	}
	public Double getCreditHour() {
		return creditHour;
	}
	public void setCreditHour(Double creditHour) {
		this.creditHour = creditHour;
	}
}
