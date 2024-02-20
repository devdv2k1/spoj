import java.io.FileInputStream;
import java.util.Scanner;

public class CANTON {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int n = sc.nextInt();
			int idxR = 0;
			int tongPT = 0;
			while(tongPT < n) {
				idxR++;
				tongPT += idxR;
			}
			tongPT -= idxR;
			
			int tu = n - tongPT;
			int mau = idxR - tu + 1;
			if(idxR % 2 == 0) { // row le
				System.out.println("TERM " + n + " IS " + tu +"/" + mau);
			}
			else { // row chan
				System.out.println("TERM " + n + " IS " + mau +"/" + tu);
			}
		} 
	}
}
