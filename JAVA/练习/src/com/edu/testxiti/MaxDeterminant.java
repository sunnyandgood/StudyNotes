package com.edu.testxiti;

/**
 * 程序编写,建立一个5行3列的整型数组,找出其中最大的元素所在行和列,并输出该值及其行,列位置.(以0为起始位置)
 * @author sunny
 *
 */
public class MaxDeterminant {
	public static void main(String[] args) {
		MaxDeterminant max = new MaxDeterminant();
		Integer[][] array = {{33,22,11},{99,77,44},{1,3,5},{9,66,4},{13,18,91}};
		Integer[] index = max.maxIndex(array);
		System.out.println("最大值:" + index[0] + "行：" + index[1] + "列：" + index[2]);
	}
	//求行列式中的最大值及其索引
	public Integer[] maxIndex(Integer[][] array) {
		Integer[] arr = new Integer[3];
		int max = array[0][0];
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				if(array[i][j] > max) {
					max = array[i][j];
					arr[0] = max;
					arr[1] = i;
					arr[2] = j;
				}
			}
		}
		return arr;
	}
}
