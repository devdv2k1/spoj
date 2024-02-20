import java.io.FileInputStream;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//public class OVCOBS {
//	
//	static int t, n, x, y, dem, row, col, valueBefore;
//	static int[][] a;
//	static int[] count;
//	public static void main(String[] args) throws FileNotFoundException{
//		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
//		Scanner sc = new Scanner(System.in);
//		t = sc.nextInt();
//		for(int tc = 1; tc <= t; tc++) {
//			
//			n = sc.nextInt();
//			x = sc.nextInt();
//			y = sc.nextInt();
//			
//			a = new int[n][n];
//			count = new int[1001];
////			for(int i = 0; i < 50; i++)
////				System.out.println(count[i]);
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++)
//					a[i][j] = sc.nextInt();
//			}
//			count[a[x][y]] = 1;
////			for(int i = 0; i < n; i++) {
////				for(int j = 0; j < n; j++)
////					System.out.print(a[i][j] + " ");
////				System.out.println();
////			}
//			dem = 0;
//			while(true) {
//				boolean flag = passObject();
//				if(!flag) {
//					break;
//				}
//			}
//			System.out.print("#" + tc + " "+ dem);
//			System.out.println();
//		}
//	}
//	public static boolean passObject() {
//			int value = a[x][y];
//			int min = 1000001;
//			int numR = 3, numC = 3;
//			int r = x, c = y;
//			if(x - 1 >= 0) {
//				row = x - 1;
//			}else if(y - 1 < 0 && x - 1 < 0){
//				row = x;
//				numR--;
//			}
//			if(y - 1 >= 0) {
//				col = y - 1;
//			}else {
//				col = y;
//				numC--;
//			}
//			
//			for(int i = row; i < row + numR && i < n; i++) {
//				for(int j = col; j < col + numC && j < n; j++) {
//					int before = count[a[i][j]];
//					if(a[i][j] < min && a[i][j] > value && before == 0) {
//						min = a[i][j];
//						r = i;
//						c = j;
//					}
//				}
//			}
//			if(min == 1000001) {
//				return false;
//			}
//			if(value < min) {
// 				x = r;
//				y = c;
//				valueBefore = a[x][y];
//				count[a[x][y]] += 1;
//				dem++;
//				return true;
//			}
//		return false;
//	}
//	
//}


import java.util.*;
import java.io.*;
public class OVCOBS{
	
	static int t, n, rStart, cStart, dem, row, col;
	static int[][] a;
	static int[] freq;
	static int[] moveR = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] moveC = {-1, 0, 1, 1, 1, 0, -1, -1};
 	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			
			n = sc.nextInt();
			rStart = sc.nextInt();
			cStart = sc.nextInt();
			
			a = new int[n][n];
			freq = new int[1001];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			}
			
			dem = 0;
			row = rStart;
			col = cStart;
			boolean ok;
			do {
				ok = passObject();
			}while(ok);
			
			System.out.print("#" + tc + " " + dem);
			System.out.println();
		}
	}
	
	public static boolean passObject() {
		int value = a[row][col];
		freq[value]++;
		int minNext = 1001;
		int rNext = 0;
		int cNext = 0;
		int r = 0, c = 0;
		for(int i = 0; i < 8; i++) {
			rNext = row + moveR[i];
			cNext = col + moveC[i];
			if(rNext >= 0 && rNext < n && cNext >=0 && cNext < n) {
				int valueNext = a[rNext][cNext];
				if(valueNext < minNext && freq[valueNext] == 0 && valueNext > value) {
					minNext = valueNext;
					r = rNext;
					c = cNext;
				}
			}
		}
		if(minNext == 1001) {
			return false;
		}else if(freq[minNext] == 0){
			dem++;
			row = r;
			col = c;
			return true;
		}
		
		return false;
	}
}
