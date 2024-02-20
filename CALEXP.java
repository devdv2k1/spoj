import java.util.*;
import java.io.*;

public class CALEXP {
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int res = 0;
//			res = (int) Math.pow(a, b);
//			System.out.println("#"+i+ " "+res);
			System.out.println("#"+i+ " "+power(a, b));
		}
	}
	//Cách 2: nếu b lẻ: a ^ b = (a ^ (b / 2)) * (a ^ (b / 2)) * a
	//nếu b chẵn: a ^ b = (a ^ (b / 2)) * (a ^ (b / 2))
	public static int power(int a, int b) {
		if(b == 0)
			return 1;
		int tmp = power(a, b/2); 
		if(b % 2 == 1)
			return tmp * tmp * a;
		return tmp * tmp;
	}
}
