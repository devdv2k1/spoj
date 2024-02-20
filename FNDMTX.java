import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FNDMTX {
	
	static int t, n, m, k;
	static int[][] a;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			
			a = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			}
			int sum = 0;
			int diff = 0;
			int min_Diff = 2000000000;
			int row = 101;
			int col = 101;
			
			int i, j;
			for(i = 0; i <= n - m; i++) {
				for(j = 0; j <= n - m; j++) {
					
					sum = calSum(i, j);
					if(sum == -1) {
						continue;
					}else{
						diff = k - sum >= 0 ? k - sum : sum - k;
						if(min_Diff > diff || (min_Diff == diff && (i <= row || j <= col))) {
							min_Diff = diff;
							row = i;
							col = j;
						}
					}
				}
			}
			System.out.print("#" + tc + " " + row + " "+ col);
			System.out.println();
		}
	}
	
	public static int calSum(int i ,int j) {
		int rowM = i + m;
		int colM = j + m;
		int sumM = 0;
		if(rowM > n || colM > n)
			return -1;
		for(int r = i; r < rowM; r++) {
			for(int c = j; c < colM; c++) {
				sumM += a[r][c];
			}
		}
		return sumM;
	}
}
