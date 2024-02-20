import java.io.*;
import java.util.*;

public class CALSQRT {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		for(int i=1; i<=t; i++) {
//			int n = sc.nextInt();
//			System.out.println("#"+i+" "+ (int)Math.sqrt(n));
//		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x = 1; x <= t; x++){
			int n = sc.nextInt();
			long res = 1;
			while(res * res <= n) {
				res++;
			}
//	        for(res = 1; res*res <= n; ++res);
//	        --res;
	        System.out.println("#"+ x + " " + (res - 1));
		}
	}
}
