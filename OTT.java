import java.io.FileInputStream;
import java.util.Scanner;

public class OTT {

	static int T, N, Q;
	static int[][] a;
	static boolean[] isOut;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
//		System.out.println(T);
		for(int tc  = 1; tc <= T; tc++) {
			N = sc.nextInt();
			Q = sc.nextInt();
//			System.out.println(N + " " + Q);
			
			a = new int[Q][N];
			isOut = new boolean[N];
			
			for(int i = 0; i < Q; i++) {
				for(int j = 0; j < N; j++) {
					a[i][j] = sc.nextInt();
				}
			}
//			for(int i = 0; i < Q; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(a[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			for(int i = 0; i < Q; i++) {
				int keo = 0, bua = 0, bao = 0;
				for(int j = 0; j < N; j++) {
					if(!isOut[j]) {
						if(a[i][j] == 1) {
							keo++;
						}
						else if(a[i][j] == 2) {
							bua++;
						}
						else if(a[i][j] == 3) {
							bao++;
						}
					}
				}
				if(keo > 0 && bua > 0 && bao == 0) {
					for(int j = 0; j < N; j++) {
						if(a[i][j] == 1) {
							isOut[j] = true;
						}
					}
				}
				else if(keo > 0 && bua == 0 && bao > 0) {
					for(int j = 0; j < N; j++) {
						if(a[i][j] == 3) {
							isOut[j] = true;
						}
					}
				}
				else if(keo == 0 && bua > 0 && bao > 0) {
					for(int j = 0; j < N; j++) {
						if(a[i][j] == 2) {
							isOut[j] = true;
						}
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int j = 0; j < N; j++) {
				if(!isOut[j]) {
					System.out.print((j + 1) + " ");
				}
			}
			System.out.println();
		}
	}
}
