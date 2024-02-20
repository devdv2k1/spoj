import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TOANDFRO {
	
	static int n;
	static String s;
	static char[][] a;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
//		System.out.println("ttyohhieneesiaabss".length());
		while(true) {
			
			n = sc.nextInt();
			
			if(n == 0)
				break;
			
			s = sc.next();
			
			int m = (s.length()/n) + 1;
//			System.out.println(m);
			a = new char[m][n];
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					a[i][j] = '0';
				}
			}
			
			int index = 0;
			for(int i = 0; i < m && index < s.length(); i++) {
				if(i%2 == 0) {
					for(int j = 0; j < n; j++) {
						a[i][j] = s.charAt(index);
						index++;
					}
				}
				else {
					for(int j = n - 1; j >= 0; j--) {
						a[i][j] = s.charAt(index);
						index++;
					}
				}
				if(index == s.length())
					break;
			}
			String res = "";
			for(int j = 0; j < n; j++) {
				for(int i = 0; i < m; i++)
					if(a[i][j] != '0')
						res += a[i][j];
			}
			System.out.println(res);
//			for(int i = 0; i < m; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(a[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
	}

}
