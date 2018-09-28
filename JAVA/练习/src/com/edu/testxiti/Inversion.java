package com.edu.testxiti;

/**
 * 程序编写，建立一个5行3列的整型数组，并将其倒置为3行5列的数组。
 * @author sunny
 *
 */
public class Inversion {
	public static void main(String[] args) {
		Inversion inver = new Inversion();
		String[][] str = {{"33","22","11"},
						  {"99","77","44"},
						  {"1 ","3 ","5 "},
						  {"9 ","66","4 "},
						  {"13","18","91"}};
		String[][] strings = inver.inversion(str);
		for(int i=0;i<strings.length;i++) {
			for(int j=0;j<strings[i].length;j++) {
				System.out.print(strings[i][j] + " ");
			}
			System.out.println();
		}
	}
	public String[][] inversion(String[][] str){
		String[][] string = new String[str[0].length][str.length];
		for(int i=0;i<str[0].length;i++) {
			for(int j=0;j<str.length;j++) {
				string[i][j] = str[j][i];
			}
		}
		return string;
 	}
}
