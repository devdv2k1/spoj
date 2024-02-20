import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QKPE {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int b = 0;
		while(true) {
			++b;
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0) {
				break;
			}
			int[][] board = new int[n][m];
			boolean[][] visit = new boolean[n][m];
			int nchess, row, col;
			for(int kind = 1; kind < 4; kind++) {
				nchess = sc.nextInt();
				for(int pos=0; pos < nchess; pos++) {
					row = sc.nextInt();
					col = sc.nextInt();
					board[row-1][col-1] = kind; //de cho row, col bat dau tu 1, phan loai Queen:1, Knight:2, Pawn:3
					visit[row-1][col-1] = true;
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[i][j] == 1) {
						solve(board, 1, i, j, n, m, visit);
//						run(board, 1, i, j, n, m);
					}else if(board[i][j] == 2) {
						solve(board, 2, i, j, n, m, visit);
//						run(board, 2, i, j, n, m);
					}
				}
			}
			int dem = 0;
			for(int i = 0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[i][j] == 0 && !visit[i][j]) {
						dem++;
					}
				}
			}
//			for(int i = 0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(visit[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println("Board " + b + " has " + dem + " safe squares.");	
		}
		sc.close();
	}
	static int[][] queen = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static int[][] knight = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	public static void solve(int[][] board, int type, int i, int j, int n, int m, boolean[][] visit) {
		if(type == 1) {
			for(int x = 0; x < 8; x++) {
				int nextR = i + queen[x][0], nextC = j + queen[x][1];
				while(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
					visit[nextR][nextC] = true;
					if(board[nextR][nextC] != 0) {
						break;
					}
					nextR += queen[x][0];
					nextC += queen[x][1];
							
				}
			}
		}
		else {
			for(int x = 0; x < 8; x++) {
				int nextR = i + knight[x][0], nextC = j + knight[x][1];
				if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
					visit[nextR][nextC] = true;
					if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m ||board[nextR][nextC] != 0 ) {
						continue;
					}
//					nextR += knight[x][0];
//					nextC += knight[x][1];
							
				}
			}
		}
	}
//	public static void run(int[][] board, int kind, int i, int j, int n, int m) {
////		int temp_i = i;
////		int temp_j = j;
//		if(kind == 1) {
//			// dong
//			for(int k = j+1; k<m; k++) {
//				if(board[i][k] == 1 || board[i][k] == 2 || board[i][k] == 3) {
//					break;
//				}else {
//					board[i][k]--;
//				}
//			}
//			for(int k = j-1; k>=0; k--) {
//				if(board[i][k] == 1 || board[i][k] == 2 || board[i][k] == 3) {
//					break;
//				}else {
//					board[i][k]--;
//				}
//			}
//			// cot
//			for(int k = i+1; k<n; k++) {
//				if(board[k][j] == 1 || board[k][j] == 2 || board[k][j] == 3) {
//					break;
//				}else {
//					board[k][j]--;
//				}
//			}
//			for(int k = i-1; k>=0; k--) {
//				if(board[k][j] == 1 || board[k][j] == 2  || board[k][j] == 3) {
//					break;
//				}else {
//					board[k][j]--;
//				}
//			}
//			// duong cheo trai duoi -> phai tren
//			int cheo1 = j - 1;
//			for(int k = i+1; k<n && cheo1>=0; k++) {
//				if(board[k][cheo1] == 1 || board[k][cheo1] == 2 || board[k][cheo1] == 3) {
//					break;
//				}else {
//					board[k][cheo1--]--;			
//				}
//			}
//			int cheo2 = j + 1;
//			for(int k = i-1; k>=0 && cheo2<m; k--) {
//				if(board[k][cheo2] == 1 || board[k][cheo2] == 2 || board[k][cheo2] == 3) {
//					break;
//				}else {
//					board[k][cheo2++]--;			
//				}
//			}
//			// duong cheo trai tren -> phai duoi
//			int cheo3 = j - 1;
//			for(int k = i-1; k>=0 && cheo3>=0; k--) {
//				if(board[k][cheo3] == 1 || board[k][cheo3] == 2 || board[k][cheo3] == 3) {
//					break;
//				}else {
//					board[k][cheo3--]--;			
//				}
//			}
//			int cheo4 = j + 1;
//			for(int k = i+1; k<n && cheo4<m; k++) {
//				if(board[k][cheo4] == 1 || board[k][cheo4] == 2 || board[k][cheo4] == 3) {
//					break;
//				}else {
//					board[k][cheo4++]--;			
//				}
//			}
//		}else if(kind == 2) {
//			// trai tren
//			if(i-2>=0 && j-1>=0 && board[i-2][j-1] != 1 && board[i-2][j-1] != 2 && board[i-2][j-1] != 3) {
//				board[i-2][j-1]--;
//			}
//			if(i-1>=0 && j-2>=0 && board[i-1][j-2] != 1 && board[i-1][j-2] != 2 && board[i-1][j-2] != 3) {
//				board[i-1][j-2]--;
//			}
//			// trai duoi
//			if(i+1<n && j-2>=0 && board[i+1][j-2] != 1 && board[i+1][j-2] != 2 && board[i+1][j-2] != 3) {
//				board[i+1][j-2]--;
//			}
//			if(i+2<n && j-1>=0 && board[i+2][j-1] != 1 && board[i+2][j-1] != 2 && board[i+2][j-1] != 3) {
//				board[i+2][j-1]--;
//			}
//			// phai tren
//			if(i-1>=0 && j+2<m && board[i-1][j+2] != 1 && board[i-1][j+2] != 2 && board[i-1][j+2] != 3) {
//				board[i-1][j+2]--;
//			}
//			if(i-2>=0 && j+1<m && board[i-2][j+1] != 1 && board[i-2][j+1] != 2 && board[i-2][j+1] != 3) {
//				board[i-2][j+1]--;
//			}
//			// phai duoi
//			if(i+1<n && j+2<m && board[i+1][j+2] != 1 && board[i+1][j+2] != 2 && board[i+1][j+2] != 3) {
//				board[i+1][j+2]--;
//			}
//			if(i+2<n && j+1<m && board[i+2][j+1] != 1 && board[i+2][j+1] != 2 && board[i+2][j+1] != 3) {
//				board[i+2][j+1]--;
//			}
//		}
//	}
}
