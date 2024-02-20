import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class ADDREV {
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\src\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int sum = reverse(x) + reverse(y);
			System.out.println(reverse(sum));
		}
	}
	public static int reverse(int n) {
		int res=0;
		while(n>0) {
			res = res*10 + n%10;
			n/=10;
		}
		return res;
	}
	
}
