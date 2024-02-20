import java.io.*;
import java.util.*;
public class SUMPROE {
	static final int M = 1000007;
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\src\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int sum = 0;
			for(int i = 1; i<=n; i++) {
				sum += i*(n/i);
				sum %= M;
			}
			System.out.println(sum);
		}
	}

}
