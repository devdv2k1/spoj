import java.io.FileInputStream;
import java.util.Scanner;
public class RGB {
	
	static int T, N, M;
	static int[][] a;
	static int[] way;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			a = new int[N + 1][M + 1];
			way = new int[7];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			int num = N/3;
			// dai mau dau tien
			int red = changeRed(1, num), green = changeGreen(1, num), blue = changeBlue(1, num);
			way[1] = way[2] = red;
			way[3] = way[4] = green;
			way[5] = way[6] = blue;
			// dai mau thu 2
			int red1 = changeRed(num + 1, num + num), green1 = changeGreen(num + 1, num + num), blue1 = changeBlue(num + 1, num + num);
			way[1] += green1;
			way[2] += blue1;
			way[3] += red1;
			way[4] += blue1;
			way[5] += red1;
			way[6] += green1;
			// dai mau thu 3
			int red2 = changeRed(num + num + 1, N), green2 = changeGreen(num + num + 1, N), blue2 = changeBlue(num + num + 1, N);
			way[1] += blue2;
			way[2] += green2;
			way[3] += blue2;
			way[4] += red2;
			way[5] += green2;
			way[6] += red2;
			
			int minChange = Integer.MAX_VALUE;
			for(int i = 1; i <= 6; i++) {
				if(way[i] < minChange) {
					minChange = way[i];
				}
			}
			System.out.println("#" + tc + " " + minChange);
		}
	}
	
	public static int changeRed(int rStart, int rEnd) {
		int dem = 0;
		
		for(int i = rStart; i <= rEnd; i++) {
			for(int j = 1; j <= M; j++) {
				if(a[i][j] != 1) {
					dem++;
				}
			}
		}
		
		return dem;
	}
	
	public static int changeGreen(int rStart, int rEnd) {
		int dem = 0;
		
		for(int i = rStart; i <= rEnd; i++) {
			for(int j = 1; j <= M; j++) {
				if(a[i][j] != 2) {
					dem++;
				}
			}
		}
		
		return dem;
	}
	
	public static int changeBlue(int rStart, int rEnd) {
		int dem = 0;
		
		for(int i = rStart; i <= rEnd; i++) {
			for(int j = 1; j <= M; j++) {
				if(a[i][j] != 3) {
					dem++;
				}
			}
		}
		
		return dem;
	}
}
