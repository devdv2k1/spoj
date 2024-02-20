import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PROB01 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\src\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i=1;
		while(i<=t) {
			int n = sc.nextInt();
			int res = 0;
			while(n>0) {
				res += n%10;
				n/=10;
				if(n == 0 && res >=10) {
					n = res;
					res=0;
				}
			}
			System.out.println("#"+i+" "+res);
			i++;
		}
	}
}
