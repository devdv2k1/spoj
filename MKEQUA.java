import java.io.FileInputStream;
import java.util.Scanner;

public class MKEQUA {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			
			int sum = 0, tmp = 0;
			for(int i = 0; i < N; i++) {
				tmp = sc.nextInt();
				sum += tmp;
			}
			
			if(sum % N == 0) {
				System.out.println(N);
			}
			else {
				System.out.println(N - 1);
			}
		}
	}

}
