package com.edu.test5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 设计一个学生管理类能够对学生对象进行管理（添加、删除），并且根据学生学号进行快速查询
 * @author sunny
 *
 */
public class StudentManager {
	private Map<String, Student> map = new HashMap<>();
	//添加学生
	public void addStudent(String key,Student student) {
		map.put(key,student);
	}
	//删除学生
	public void deleteStudent(String key) {
		map.remove(key);
	}
	//修改
	public void updateStudent(String key,Student student) {
		map.replace(key, student);
	}
	//按照学号查找学生
	public Student selectStudentByStuId(String stuId) {
		Student student = map.get(stuId);
		return student;
	}
	//查找所有学生信息
	public Collection<Entry<String, Student>> selectAllStudent() {
		Collection<Entry<String, Student>> students = map.entrySet();
		return students;
	}
	
	//给HashMap内的数据排序
	public ArrayList<Map.Entry<String, Student>> sortHashMap(Collection<Entry<String, Student>> allStudent){
		ArrayList<Map.Entry<String, Student>> list = new ArrayList<>(allStudent);
		Collections.sort(list, new Comparator<Map.Entry<String, Student>>() {
			//升序排序
			@Override
			public int compare(Entry<String, Student> o1, Entry<String, Student> o2) {
				// TODO Auto-generated method stub
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		return list;
	}
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		//添加学生
		for(int i=1;i<12;i++) {
			String stuId = null;
			String phone = null;
			if(i<10) {
				stuId = "160706410" + i;
				phone = "1840658720" + i;
			}else if (i>9) {
				stuId = "16070641" + i;
				phone = "184065872" + i;
			}
			Student student = new Student();
			student.setStuId(stuId);
			student.setName("张三");
			student.setClassNum("16070641");
			student.setAge(21);
			student.setPhone(phone);
			student.setSex("男");
			manager.addStudent(stuId,student);
		}
		//查询学号为1607064110的学生
		Student student = manager.selectStudentByStuId("1607064110");
		System.out.println(student);
		System.out.println("----------------");
		//查询所有学生
		Collection<Entry<String, Student>> allStudent = manager.selectAllStudent();
		ArrayList<Entry<String,Student>> arrayList = manager.sortHashMap(allStudent);
		for(Entry<String, Student> entry: arrayList) {
			System.out.println(entry);
		}
		
		//删除学号为1607064108的学生
		manager.deleteStudent("1607064108");
		
		//修改学号为1607064102的学生
		Student stu = new Student();
		stu.setStuId("1607064102");
		stu.setName("李四");
		stu.setClassNum("16070641");
		stu.setAge(20);
		stu.setPhone("18406587202");
		stu.setSex("女");
		manager.updateStudent("1607064102", stu);
		
		System.out.println("---------------------");
		
		Collection<Entry<String, Student>> allStudent1 = manager.selectAllStudent();
		ArrayList<Entry<String,Student>> arrayList1 = manager.sortHashMap(allStudent);
		for(Entry<String, Student> entry: arrayList1) {
			System.out.println(entry);
		}
	}
}
