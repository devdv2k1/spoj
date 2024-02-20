import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CHKSDK {
	
	static int t;
	static char[][] sudu;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int x = 1; x <= t; x++) {
			sudu = new char[9][9];
			for(int i = 0; i < 9; i++) {
				String inputRow = sc.next();
				sudu[i] = inputRow.toCharArray();
			}
			
//			for(int i = 0; i < 9; i++) {
//				for(int j = 0; j < 9; j++) {
//					System.out.print(sudu[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.print("#" + x + " " + solve());
			System.out.println();
		}
	}
	
	public static int solve() {
		// check hang
		for(int j = 0; j < 9; j++) {
			if(!checkRow(j)) {
				return 0;
			}
	}
		// check cot
		for(int i = 0; i < 9; i++) {
				if(!checkCol(i)) {
					return 0;
				}
		}
		//check sub matrix
		for(int i = 0; i <= 6; i += 3) {
			for(int j = 0; j <= 6; j += 3) {
				if(!checkSubMatrix(i, j)) {
					return 0;
				}
			}
		}
		
		return 1;
	}
	
	public static boolean checkRow(int index) {
		int count[] = new int[10];
		for(int i = 0; i < 9; i++) {
			if(sudu[index][i] != '.') {
				int value = (int) (sudu[index][i] - '0');
				if(count[value] == 1) {
					return false;
				}else {
					count[value]++;
				}
			}
		}
		return true;
	}
	
	public static boolean checkCol(int index) {
		int count[] = new int[10];
		for(int i = 0; i < 9; i++) {
			if(sudu[i][index] != '.') {
				int value = (int) (sudu[i][index] - '0');
				if(count[value] == 1) {
					return false;
				}else {
					count[value]++;
				}
			}
		}
		return true;
	}
	
	public static boolean checkSubMatrix(int row, int col) {
		int count[] = new int[10];
		for(int i = row; i < row + 3; i++) {
			for(int j = col; j < col + 3; j++) {
				if(sudu[i][j] != '.') {
					int value = (int) (sudu[i][j] - '0');
					if(count[value] == 1) {
						return false;
					}else {
						count[value]++;
					}
				}
			}
		}
		return true;
	}
}
