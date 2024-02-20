import java.io.FileInputStream;
import java.util.Scanner;

public class DIVSUM {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			int sum = 1;
			for(int i = 2; i*i <= N; i++) {
				if(N%i == 0) {
//					System.out.println(i + " " + N/i);
					if(i == (N/i))
						sum += i;
					else 
						sum += (i + N/i); 
				}
			}
			if(N <= 1) System.out.println(0);
			else
				System.out.println(sum);
			
		}
	}

}
