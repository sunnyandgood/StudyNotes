package com.edu.test5;

public class Student {
	private String stuId;
	private String name;
	private String classNum;
	private String phone;
	private Integer age;
	private String sex;
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[stuId = " + stuId + "; name = " + name + "; classNum = " + classNum + 
				"; phone = " + phone + "; age = " + age + "; sex = " + sex + "]";
	}
}
