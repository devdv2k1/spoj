import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ladder1 {

	static int t, n, res;
	static int[][] a;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = 1;
		while(t <= 10) {
//		while (true) { //
			t = sc.nextInt();
			n = sc.nextInt();

			a = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			}
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++)
//					System.out.print(a[i][j] + " ");
//				System.out.println();
//			}

			for (int nguoi = 0; nguoi < n; nguoi++) {
				if (a[0][nguoi] == 1 && findBomb(nguoi)) {
					res = nguoi;
					break;
				}
			}

			System.out.println("#" + t + " " + res);
			t++;
		}
	}

	public static boolean findBomb(int cotBD) {
		int cot = cotBD;
		for (int row = 1; row < n; row++) {
			int col = cot;
			if (col >= 0 && col < n) {
				int colR = col + 1;
				int colL = col - 1;
				if (colR < n && a[row][colR] == 1) {
					while (colR < n && a[row][colR] == 1) {
						if(colR + 1 < n && a[row][colR + 1] != 1 || colR == n - 1) {
							break;
						}
						colR++;
						cot = colR;
					}
				} else if (colL >= 0 && a[row][colL] == 1) {
					while (colL >= 0 && a[row][colL] == 1) {
						if(colL - 1 >= 0 && a[row][colL - 1] != 1 || colL == 0) {
							break;
						}
						colL--;
						cot = colL;
					}
				}
				if (row == n - 1 && a[row][col] == 2) {
					return true;
				}
			}
		}
		return false;
	}
}
