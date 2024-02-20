import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BTFNUM {
	
	static int t, n, m, x, y;
	static int btnum[];
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {	
			btnum = new int[10000001];
			
			n = sc.nextInt(); // so chu so dep
			m = sc.nextInt(); // min so chu so dep -> so dep
			for(int i = 0; i < n; i++) {
				btnum[i] = sc.nextInt();
			}
				
			
			x = sc.nextInt();
			y = sc.nextInt();
			int k = 200, scs = 1;
			for(int i = 1; i < m; i++) {
				scs *= 10;
			}
			if(x >= scs) k = x;
			else k = scs;
			
			int count = 0;
			for(; k <= y; k++) {
				if(checkNums(k)) {
					count++;
				}
			}
			System.out.print("#" + tc + " " + count);
			System.out.println();
		}
	}
	public static boolean checkNums(int value) {
		int dem = 0;
		int[] res = new int[10];
		while(value > 0) {
			res[value%10]++;
			value /= 10;
		}
		for(int i = 0; i < n; i++) {
				dem += res[btnum[i]];
		}
		if(dem >= m)
			return true;
		return false;
	}
}
