import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PROB06 {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x = 1; x <= t; x++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			char[][] a = new char[m][n];
//			int[][] res = new int[m][n];
			boolean[][] visit = new boolean[m][n];
			
			for(int i=0; i < m; i++) {
				String rowInput = sc.next();
				for(int j = 0; j < n; j++) {
					a[i][j] = rowInput.charAt(j);
					if(a[i][j] == 'A') {
						solve(a, i, j, 1, visit, m, n);
					}
					else if(a[i][j] == 'B') {
						solve(a, i, j, 2, visit, m, n);
					}
					else if(a[i][j] == 'C') {
						solve(a, i, j, 3, visit, m, n);
					}
//					if(a[i][j] == 'X') {
//						res[i][j] = -1;
//					}else if(a[i][j] == 'H') {
//						res[i][j] = 0;
//					}else if(a[i][j] == 'A') {
//						res[i][j] = 100;
//					}else if(a[i][j] == 'B') {
//						res[i][j] = 200;
//					}else if(a[i][j] == 'C') {
//						res[i][j] = 300;
//					}
				}
			}
			
//			for(int i=0; i<m; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(res[i][j] + " ");
//				}
//				System.out.println();
//			}
//			for(int i=0; i<m; i++) {
//				for(int j=0; j<n; j++) {
//					if(res[i][j] == 100) {
//						run(res, i, j, m, n, 100);
//					}else if(res[i][j] == 200) {
//						run(res, i, j, m, n, 200);
//					}else if(res[i][j] == 300) {
//						run(res, i, j, m, n, 300);
//					}
//				}
//			}
			int dem = 0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
//					dem = res[i][j]==0 ? dem+1 : dem;
//					System.out.print(visit[i][j] + " ");
					dem = a[i][j] == 'H' && !visit[i][j] ? dem + 1 : dem;
				}
//				System.out.println();
			}
			System.out.println("#" + x + " " + dem);
//			System.out.println();
//			for(int i=0; i<m; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(a[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
	}
	public static void solve(char[][] a, int i, int j, int type, boolean[][] visit, int m, int n) {
		for(int num = 1; num <= type; num++) {
			int top = i - num, bot = i + num, left = j - num, right = j + num;
			if(top >= 0) visit[top][j] = true;
			if(bot < m) visit[bot][j] = true;
			if(left >= 0) visit[i][left] = true;
			if(right < n) visit[i][right] = true;
		}
		
	}
//	public static void run(int[][] res, int i, int j, int m, int n, int type) {
//		int l = 0;
//		if(type == 100) {
//			l = 1;
//		}else if(type == 200) {
//			l = 2;
//		}else if(type == 300) {
//			l = 3;
//		}
//		for(int x=1; x <= l ; x++) {
//			if(i+x < m)
//				if(res[i+x][j]!=100 && res[i+x][j]!=200 && res[i+x][j]!=300 && res[i+x][j]!=-1)
//				res[i+x][j]++;
//			if(j+x<n)
//				if(res[i][j+x]!=100 && res[i][j+x]!=200 && res[i][j+x]!=300 && res[i][j+x]!=-1)
//				res[i][j+x]++;
//			if(i-x>=0)
//				if(res[i-x][j]!=100 && res[i-x][j]!=200 && res[i-x][j]!=300 && res[i-x][j]!=-1)
//				res[i-x][j]++;
//			if(j-x>=0)
//				if(res[i][j-x]!=100 && res[i][j-x]!=200 && res[i][j-x]!=300 && res[i][j-x]!=-1)
//				res[i][j-x]++;
//		}
//	}
}
