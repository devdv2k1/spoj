import java.io.FileInputStream;
import java.util.Scanner;

public class SAMER08F {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int max = i > j ? i : j;
					cnt += n - max;
				}
			}
			System.out.println(cnt);
		}
	}
}
