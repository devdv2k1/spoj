import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SLTKNGHT {

	static int t, n, k, m, d;
	static boolean[][] map;
	static int[] kx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] ky = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] kRow = new int[1000001], kCol = new int[1000001];
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			m = sc.nextInt();
			d = sc.nextInt();
			
			map = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					map[i][j] = false;
			}
			
			for(int i = 0; i < k; i++) {
				kRow[i] = sc.nextInt();
				kCol[i] = sc.nextInt();
				map[kRow[i]][kCol[i]] = true;
			}
			
			
			for(int i = 0; i < m; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = true;
			}
			
			for(int i = 0; i < d; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = false;
			}
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++)
//					System.out.print(map[i][j] + " ");
//				System.out.println();
//			}
			int maxCnt = -1, curCnt, nextR, nextC, row = 0, col = 0; 
			for(int i = 0; i < k; i++) {
				curCnt = 0;
				for(int j = 0; j < 8; j++) {
					nextR = kRow[i] + kx[j];
					nextC = kCol[i] + ky[j];
					if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && map[nextR][nextC] == true) {
						curCnt++;
					}
				}
				if(curCnt > maxCnt) {
					maxCnt = curCnt;
					row = kRow[i];
					col = kCol[i];
				}
			}
			System.out.print("#" + tc + " " + row + " " + col + " " + maxCnt);
			System.out.println();
		}
	}

}
