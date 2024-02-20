import java.io.*;
import java.util.*;
import java.lang.*;
public class PROB02 {
	
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		for(int x=1; x<=t; x++) {
//			int m = sc.nextInt();
//			int n = sc.nextInt();
//			int row = 5*m+1;
//			int col = 5*n+1;
//			char[][] arr = new char[row][col];
//			res = new int[5];
//			for(int i = 0; i < row; i++) {
//				String rowInput = sc.next();
//				for(int j = 0; j < col; j++) {
//					arr[i][j] = rowInput.charAt(j);
//				}
//			}
//			int t0=0, t1=0, t2=0, t3=0, t4=0;
//			for(int i=1; i<row; i+=5) {
//				for(int j=1; j<col; j+=5) {
//					int dem=0;
//					for(int k=i; k<i+4; k++) { // thu = dau.
//						if(arr[k][j] == '*') {
//							dem++;
//						}
//					}
//					if(dem==0) {
//						t0++;
//					}else if(dem==1) {
//						t1++;
//					}else if(dem==2) {
//						t2++;
//					}else if(dem==3) {
//						t3++;
//					}else if(dem==4) {
//						t4++;
//					}
//				}	
//			}
//			System.out.println("#"+x+" "+t0 +" "+t1+" "+t2+" "+t3+" "+t4);
//		}
//	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x=1; x<=t; x++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int row = 5*m+1, col = 5*n+1;
			char a[][] = new char[row][col];
			int res[] = new int[5];
			
			for(int i=0; i<row; i++) {
				String inputRow = sc.next();
				for(int j=0; j<col; j++) {
					a[i][j] = inputRow.charAt(j);
				}
			}
			
			for(int i=1; i<row; i+=5) {
				for(int j=1; j<col; j+=5) {
					res[run(a,i,j)]++;
				}
			}
			System.out.print("#" + x +" ");
			for(int i=0; i<=4; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
		}
	}
	
	public static int run(char[][] a, int i, int j) {
		int res;
		for(res = 0; res < 4; res++) {
			if(a[i+res][j] == '.') {
				return res;
			}
		}
		return 4;
	}

}
