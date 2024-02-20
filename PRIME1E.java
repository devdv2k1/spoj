import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PRIME1E {
	static boolean isPrime[];
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			isPrime = new boolean[n + 1];
			init(n);
			for(int i=m;i<=n;i++) {
//				if(prime(i)==1) {
				if(isPrime[i]) {
					System.out.println(i);
				}
			}
			System.out.println();
		}
	}
	public static void init(int n) {
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i = 2; i <= n; i++)
			isPrime[i] = true;
		for(int i = 2; i*i <= n; i++){
			if(isPrime[i] == true) {
				for(int j = i*i; j <= n; j += i) 
					isPrime[j] = false;
			}
		}
	}
//	public static int prime(int n) {
//		if(n<=1) return 0;
//		for(int i=2;i<=Math.sqrt(n);i++) {
//			if(n%i==0) {
//				return 0;
//			}
//		}
//		return 1;
//	}
}
