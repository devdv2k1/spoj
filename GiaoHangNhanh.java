import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiaoHangNhanh {

	static int t, n;
	static int[][] a;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			
			n = sc.nextInt();
			a = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			}
			int di = 0;
			int i = 0;;
			int vitri = 0;
			int duongDi = 0;
			boolean[] isGone = new boolean[n];
			
			isGone[0] = true;
			for(; i < n;) {
				i = vitri;
				if(di == n) {
					break;
				}
				if(di == n - 1) {
					isGone[0] = false;
				}
//				int j = 0;
				int min = 1001;
				for(int j = 0; j < n; j++) {
					if(a[i][j] < min && a[i][j] != 0 && isGone[j] == false) {
						min = a[i][j];
						vitri = j;
					}	
				}
				duongDi += min;
				isGone[vitri] = true;
				di++;
				
			}
			System.out.println("#" + tc + " " + duongDi);
		}
	}

}
