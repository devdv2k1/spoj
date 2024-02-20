import java.io.FileInputStream;
import java.util.Scanner;

public class NSTEPS {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] a = new int[10003][10003];
//		int value = 0;
//		int value2 = 
		for(int i = 0; i <= 10000; i++) {
			for(int j = i; j <= 10000; j++) {
				if(i == j) {
					if(i % 2 == 0) {
						a[i][j] = i + j;
						a[i][j + 2] = i + j + 2;
					}
					else {
						a[i][j] = i + j - 1;
						a[i][j + 2] = i + j + 2 - 1;
					}
					break;
				}
			}
		}
//		System.out.println(a[4][2]);
//		for(int i = 0; i <= 7; i++) {
//			for(int j = 0; j <= 7; j++) {
//				System.out.println("i = "+i + " j = " + j + " " +a[i][j]);
//			}
//			System.out.println();
//		}
		while(T-- > 0) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			if(r == 0 && c == 0 && a[r][c] == 0) {
				System.out.println(a[r][c]);
			}else if(a[r][c] != 0){
				System.out.println(a[r][c]);
			}else {
				System.out.println("No Number");
			}
		}
	}
}
