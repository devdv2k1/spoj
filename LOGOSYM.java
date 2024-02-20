import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LOGOSYM {

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
			String flag = "YES";
			for(int i = 0; i <= n/2; i++) {
				for(int j = 0; j < n; j ++) {
					if(a[i][j] != a[n-i-1][j])
						flag = "NO";
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= n/2; j++) {
					if(a[i][j] != a[i][n-j-1])
						flag = "NO";
				}
			}
			System.out.print("#" + tc + " " + flag);
			System.out.println();
			
		}
	}

}
