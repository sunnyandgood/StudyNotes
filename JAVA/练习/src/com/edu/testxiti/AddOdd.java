package com.edu.testxiti;

/**
 * 计算出从1到1000的所有奇数和并打印输出到控制台
 * @author sunny
 *
 */
public class AddOdd {
	public static void main(String[] args) {
		AddOdd add = new AddOdd();
		Integer sum = add.addOdd(1000);
		System.out.println(sum);
	}
	//计算1到num的所有奇数和
	public Integer addOdd(int num) {
		int sum = 0;
		for(int i=0;i<num;i+=2) {
			sum += i;
		}
		return sum;
	}
}
