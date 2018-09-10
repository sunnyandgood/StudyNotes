import java.util.Scanner;
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
                int rank;
                Scanner input  = new Scanner(System.in);
                rank = input.nextInt();
                String[][] square = backSquare.square(rank);
                for(int i=0;i<rank;i++) {
                        for(int j=0;j<rank;j++) {
                                System.out.print(square[i][j]);
                        }
                        System.out.println();
                }
        }
        
        public String[][] square(int rank) {
                String[][] shape = new String[rank][rank];
                for(int i=0;i<rank/2;i++) {
                        for(int j=rank-1-i;j>=i;j--) {
                                for(int k=rank-1-i;k>=i;k--) {
                                        if(j==i) {
                                                shape[j][k] = i+1+" ";
                                        }
                                        if(k==i) {
                                                shape[j][k] = i+1+" ";
                                        }
                                        if(j==rank-1-i) {
                                                shape[j][k] = i+1+" ";
                                        }
                                        if(k==rank-1-i) {
                                                shape[j][k] = i+1+" ";
                                        }
                                        if(rank%2!=0) {
                                                shape[(rank-1)/2][(rank-1)/2] = rank/2+1+" ";
                                        }
                                }
                        }
                }
                return shape;           
        }
}
