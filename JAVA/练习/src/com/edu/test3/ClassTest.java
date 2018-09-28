package com.edu.test3;

import org.junit.Test;
/**
 * 测试类（用junit4做测试）
 * @author sunny
 *
 */
public class ClassTest {
	/**
	 * Student类的测试
	 */
	@Test
	public void testStudent() {
		Student[] stu = new Student[3];
		
		stu[0] = new Student(1);
		stu[0].setStudentName("小花");
		stu[0].setAverageScore(80.5);
		
		stu[1] = new Student(2);
		stu[1].setStudentName("小明");
		stu[1].setAverageScore(90.8);
		
		stu[2] = new Student(3);
		stu[2].setStudentName("小华");
		stu[2].setAverageScore(88.9);
		
		for(int i=0;i<stu.length;i++) {
			System.out.println(stu[i]);
		}
	}
	/**
	 * CollegeStudent类的测试
	 */
	@Test
	public void testCollegeStudent() {
		CollegeStudent[] cstu = new CollegeStudent[2];
		
		cstu[0] = new CollegeStudent(1);
		cstu[0].setStudentName("小雷");
		cstu[0].setAverageScore(99.9);
		cstu[0].setCourseNum(8);
		cstu[0].setCreditHour(6.6);
		
		cstu[1] = new CollegeStudent(2);
		cstu[1].setStudentName("小芳");
		cstu[1].setAverageScore(90.9);
		cstu[1].setCourseNum(6);
		cstu[1].setCreditHour(8.0);
		
		for(CollegeStudent cStudent : cstu) {
			System.out.println(cStudent);
		}
	}
	
	/**
	 * Postgraduate类的测试
	 */
	@Test
	public void testPostgraduate() {
		Postgraduate[] pstu = new Postgraduate[2];
		
		pstu[0] = new Postgraduate(1);
		pstu[0].setStudentName("小建");
		pstu[0].setAverageScore(80.8);
		pstu[0].setCourseNum(9);
		pstu[0].setCreditHour(5.0);
		pstu[0].setPaperName("神经网络");
		pstu[0].setPleaScore(99.0);
		
		pstu[1] = new Postgraduate(2);
		pstu[1].setStudentName("小剑");
		pstu[1].setAverageScore(90.8);
		pstu[1].setCourseNum(6);
		pstu[1].setCreditHour(6.0);
		pstu[1].setPaperName("人脸识别");
		pstu[1].setPleaScore(95.0);
		
		for(Postgraduate pstudent : pstu) {
			System.out.println(pstudent);
		}
	}
	
}
