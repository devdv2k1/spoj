import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PROB03 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x=1; x<=t; x++) {
			int h, w, m, n;
			h = sc.nextInt();
			w = sc.nextInt();
			m = sc.nextInt();
			n = sc.nextInt();
			int[][] a = new int[m][n];
			
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for(int i=0; i<=m-h; i++) {
				for(int j=0; j<=n-w; j++) {
					int s = sum(a, h, w, i, j);
					max =  s > max ? s : max;
				}
			}
			System.out.print("#"+x+" " + max);
			System.out.println();
		}
	}
	
	public static int sum(int[][] a, int h, int w, int i, int j) {
		int res = 0;
		
		for(int row = 0; row<h; row++) {
			if(a[row+i][j] % 2 == 0) {
				res += a[row+i][j];
			}
			if(a[row+i][j+w-1] % 2 == 0) {
				res += a[row+i][j+w-1];
			}
		}
		
		for(int col = 1; col<w-1; col++) {
			if(a[i][col+j] % 2 == 0) {
				res += a[i][col+j];
			}
			if(a[i+h-1][col+j] % 2 == 0) {
				res += a[i+h-1][col+j];
			}
		}
		
		return res;
	}

}
