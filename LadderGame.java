import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LadderGame {

	static int t, n, b, m;
	static int[][] a;
	static int[] hrRow, hrCol;
		
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = 1;
		while(t <= 10) {
			n = sc.nextInt();
			b = sc.nextInt();
			m = sc.nextInt();
			
			hrRow = new int[2*m + 1];
			hrCol = new int[2*m + 1];
			
			a = new int[n+1][n+1];
			
			a[n][b] = -1;
			
			int index = 1;
			for(int i = 0; i < 2*m; i++) {
				hrRow[index] = sc.nextInt();
				hrCol[index] = sc.nextInt();
				index++;
			}
			
			int hK = 1;
			
			for(int i = 1; i <= 2 * m; i += 2) {
				a[hrRow[i]][hrCol[i]] = hK*1000;
				a[hrRow[i + 1]][hrCol[i + 1]] = hK*1000;
				int row = hrRow[i];
				int col = hrCol[i] + 1;
				while(col < hrCol[i + 1]) {
					a[row][col] = hK;
					col++;
				}
				hK++;
			}
			
//			for(int i = 1; i <= 2 * m; i++) {
//				System.out.print(hrRow[i] + " " + hrCol[i]);
//				System.out.println();
//			}
//			
//			for(int i = 1; i <= n; i++) {
//				for(int j = 1; j <= n; j++)
//					System.out.print(a[i][j] + " ");
//				System.out.println();
//			}
			boolean bomb = false;
			int res = 1;
			for(int nguoichoi = 1; nguoichoi <= n; nguoichoi++) {
				if(go(nguoichoi)) {
					res = nguoichoi;
					break;
				}
			}
			
			System.out.println("#" + t + " " + res);
			t++;
		}
	}
	public static boolean go(int cot) {
		int cotDi = cot;
		for(int i = 1; i <= n; i++) {
			int j = cotDi;
			if(j >= 1 && j <= n) {
//				int value = a[i][j];
				if(a[i][j] % 1000 == 0 && a[i][j] != 0) {
//					if(j + 1 <= n) {
//						int nextP = j + 1, gtriPhai = a[i][j + 1];
//					}
//					else if(j - 1 >= 1) {
//						
//						int nextT = j - 1, gtriTrai = a[i][j - 1];
//					}
					int gtri = a[i][j] / 1000;
					if(j + 1 <= n && a[i][j + 1] == a[i][j]) {
						cotDi = j + 1;
					}
					else if(j - 1 >= 1 && a[i][j - 1] == a[i][j]) {
						cotDi = j - 1;
					}
					else if(j + 1 <= n && a[i][j + 1] == gtri) {
						int col = j + 1; // ben phai
						while(col <= n && a[i][col] != a[i][j]) {
							col++;
							cotDi = col;
						}
					}
					else if(j - 1 >= 1 && a[i][j - 1] == gtri) {
						int col = j - 1; // ben trai
						while(col >= 0 && a[i][col] != a[i][j]) {
							col--;
							cotDi = col;
						}
					}
				}else if(i == n && j == b){
					return true;
				}
			}
		}
		return false;
	}
}
