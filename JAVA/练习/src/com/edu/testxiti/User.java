package com.edu.testxiti;

/**
 * 设计一个表示用户的User类，类中的变量有用户名、口令和记录用户个数的变量（静态的），定义类的3个构造方法
 * （没有参数、有一个参数的给用户名赋值、有两个参数的给用户名和口令赋值）、获取和设置口令的方法、返回字符串表示的类信息的方法（包含用户名、口令）。
 * 编写main测试User类。
 * @author sunny
 *
 */
public class User {
	private String userName;
	private String password;
	private static Integer userNumber = 0;
	
	public User() {
		userNumber += 1;
	}
	public User(String userName) {
		this.userName = userName;
		userNumber += 1;
	}
	public User(String userName,String password) {
		this.userName = userName;
		this.password = password;
		userNumber += 1;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserNumber() {
		return userNumber;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[userName = " + userName + " ;password = " + password + "]";
	}
	
	
	public static void main(String[] args) {
		User user1 = new User("小雷");
		System.out.println("userNumber = " + user1.getUserNumber());
		
		User user2 = new User("小花","qwe");
		System.out.println("userNumber = " + user2.getUserNumber());
		
		System.out.println(user1);
		user1.setPassword("admin");
		System.out.println(user1);
		System.out.println(user1.getPassword());
		System.out.println(user2);
	}
}
