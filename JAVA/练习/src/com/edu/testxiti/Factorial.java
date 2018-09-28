package com.edu.testxiti;

import java.math.BigInteger;

/**
 * 程序编写,计算出从1到100的阶乘并打印输出到控制台。
 * @author sunny
 *
 */
public class Factorial {
	public static void main(String[] args) {
		Factorial fac = new Factorial();
		BigInteger bigInteger = fac.factorial(10);
		System.out.println(bigInteger);
	}
	
	public BigInteger factorial(int num) {
		BigInteger bigInteger = new BigInteger("1");//String.valueOf(1)
		for(int i=1;i<=num;i++) {
			bigInteger = bigInteger.multiply(new BigInteger(""+i));//String.valueOf(i)
		}
		return bigInteger;
	}
}
