import java.io.FileInputStream;
import java.util.Scanner;
public class Ladder2 {
	
	static int t, n;
	static int[][] a;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = 1;
		while(t <= 1) {
			t = sc.nextInt();
			n = sc.nextInt();
			
			a = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					System.out.print(a[i][j] + " ");
				System.out.println();
			}
//			System.out.println(a[1][0]);
//			int min = 2000000000;
//			int ngMua = 0;
//			for(int player = 0; player < n; player++) {
// 				if(a[0][player] == 1) {
//					int res = findWay(player);
//					System.out.println(player + " " + res);
//					if(res < min || (res == min && player > ngMua)) {
//						min = res;
//						ngMua = player;
//					}
//				}
//			}
//			
//			System.out.println("#" + t + " " + min);
			int minSteps = Integer.MAX_VALUE;
            int minColumn = -1;
            for (int j = 0; j < n; j++) {
                if (a[0][j] == 1) {
                    int steps = 0;
                    int row = 0;
                    int column = j;
                    int direction = 0;  // 0: down, -1: left, 1: right
                    while (row < n - 1) {
                        steps++;
                        if (direction == 0) {
                            if (column > 0 && a[row][column - 1] == 1) {
                                direction = -1;
                            } else if (column < n - 1 && a[row][column + 1] == 1) {
                                direction = 1;
                            } else {
                                row++;
                            }
                        }
                        if (direction == -1) {
                            if (column > 0 && a[row][column - 1] == 1) {
                                column--;
                            } else {
                                direction = 0;
                            }
                        } else if (direction == 1) {
                            if (column < n - 1 && a[row][column + 1] == 1) {
                                column++;
                            } else {
                                direction = 0;
                            }
                        }
                    }
                    if (row == n - 1 && steps < minSteps) {
                        minSteps = steps;
                        minColumn = j;
                    }
                }
            }
            System.out.println("#" + t + " " + (minColumn == -1 ? -1 : minColumn));
			t++;
		}
	}
//	public static int findWay(int cotBD) {
//		int cot = cotBD;
//		int soBuoc = 1;
//		for (int row = 1; row < n; row++) {
//			int col = cot;
//			if(a[row][col] == 1) {
//				soBuoc++;
//			}
//			if (col >= 0 && col < n) {
//				int colR = col + 1;
//				int colL = col - 1;
//				if (colR < n && a[row][colR] == 1) {
//					while (colR < n && a[row][colR] == 1) {
//						if(colR + 1 < n && a[row][colR + 1] != 1 || colR == n - 1) {
//							break;
//						}
//						colR++;
//						cot = colR;
//						soBuoc++;
//					}
//				} else if (colL >= 0 && a[row][colL] == 1) {
//					while (colL >= 0 && a[row][colL] == 1) {
//						if(colL - 1 >= 0 && a[row][colL - 1] != 1 || colL == 0) {
//							break;
//						}
//						colL--;
//						cot = colL;
//						soBuoc++;
//					}
//				}
//			}
//		}
//		return soBuoc;
//	}
}