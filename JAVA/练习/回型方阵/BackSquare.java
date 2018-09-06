/**
 * 输入方阵阶数，输出回型方阵
 * eg:
 * 	1 1 1 1 1 1 1 1 1 1 
 * 	1 2 2 2 2 2 2 2 2 1 
 * 	1 2 3 3 3 3 3 3 2 1 
 * 	1 2 3 4 4 4 4 3 2 1 
 * 	1 2 3 4 5 5 4 3 2 1 
 * 	1 2 3 4 5 5 4 3 2 1 
 * 	1 2 3 4 4 4 4 3 2 1 
 * 	1 2 3 3 3 3 3 3 2 1 
 * 	1 2 2 2 2 2 2 2 2 1 
 * 	1 1 1 1 1 1 1 1 1 1 
 * @author sunny
 *
 */
public class BackSquare {
	public static void main(String[] args) {
		BackSquare backSquare = new BackSquare();
		int rank = 1;
		String[][] square = backSquare.square(rank);
		for(int i=0;i<rank*2;i++) {
			for(int j=0;j<rank*2;j++) {
				System.out.print(square[i][j]);
			}
			System.out.println();
		}
	}
	
	public String[][] square(int rank) {
		int value = rank*2;
		String[][] shape = new String[value][value];
		for(int i=0;i<rank;i++) {
			for(int j=value-1-i;j>=i;j--) {
				for(int k=value-1-i;k>=i;k--) {
					if(j==i) {
						shape[j][k] = i+1+" ";
					}
					if(k==i) {
						shape[j][k] = i+1+" ";
					}
					if(j==value-1-i) {
						shape[j][k] = i+1+" ";
					}
					if(k==value-1-i) {
						shape[j][k] = i+1+" ";
					}
				}
			}
		}
		return shape;		
	}
}
