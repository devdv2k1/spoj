import java.io.FileInputStream;
import java.util.Scanner;

public class HFLOOR {
	
	static int M, N;
	static char[][] a;
	static int[] room;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			M = sc.nextInt();
			N = sc.nextInt();
			a = new char[M][N];
			room = new int[100];
			for(int i = 0; i < M; i++) {
				a[i] = sc.next().toCharArray();
			}
//			for(int i = 0; i < M; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(a[i][j] + " ");
//				}
//				System.out.println();
//			}
			
		}
	}
	

}
