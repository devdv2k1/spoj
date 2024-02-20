import java.io.FileInputStream;
import java.util.Scanner;
public class Magnet {
	
	static int t, n, m, k, rStart, cStart;
	static int order[];
	static int a[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			
			order = new int[k];
			a = new int[n][m];
			
			for(int i = 0; i < k; i++)
				order[i] = sc.nextInt();
			
			rStart = 0;
			cStart = 0;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
					if(a[i][j] == 2) {
						rStart = i;
						cStart = j;
					}
				}
			}
//			for(int i = 0; i < n; i++){
//				for(int j = 0; j < m; j++) {
//					System.out.print(a[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(rStart + " " + cStart);
//			for(int i = 0; i < k; i++)
//				System.out.print(order[i] + " ");
			for(int i = 0; i < k; i++) {
				if(order[i] == 1) {
					runUp();
				}
				else if(order[i] == 2) {
					runRight();
				}
				else if(order[i] == 3) {
					runDown();
				}
				else if(order[i] == 4) {
					runLeft();
				}
			}
			int step = 1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(a[i][j] == -1) {
						step++;
					}
				}
			}
			System.out.println("#" + tc + " " + step);
		}
	}
	public static void runUp() {
		int row = rStart;
		int col = cStart;
		while(row > 0) {
			row--;
			if(a[row][col] == 1) {
				rStart = row + 1;
				cStart = col;
				break;
			}
			else if (a[row][col] == 0) {
				a[row][col] = -1;
			}
			if(row == 0) {
				rStart = row;
				cStart = col;
			}
		}
	}
	
	public static void runDown() {
		int row = rStart;
		int col = cStart;
		while(row < n - 1) {
			row++;
			if(a[row][col] == 1) {
				rStart = row - 1;
				cStart = col;
				break;
			}
			else if (a[row][col] == 0) {
				a[row][col] = -1;
			}
			if(row == n - 1) {
				rStart = row;
				cStart = col;
			}
		}
	}
	
	public static void runLeft() {
		int row = rStart;
		int col = cStart;
		while(col > 0) {
			col--;
			if(a[row][col] == 1) {
				rStart = row;
				cStart = col + 1;
				break;
			}
			else if (a[row][col] == 0) {
				a[row][col] = -1;
			}
			if(col == 0) {
				rStart = row;
				cStart = col;
			}
		}
	}
	
	public static void runRight() {
		int row = rStart;
		int col = cStart;
		while(col < m - 1) {
			col++;
			if(a[row][col] == 1) {
				rStart = row;
				cStart = col - 1;
				break;
			}
			else if (a[row][col] == 0) {
				a[row][col] = -1;
			}
			if(col == m - 1) {
				rStart = row;
				cStart = col;
			}
		}
	}
}
