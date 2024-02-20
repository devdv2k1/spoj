import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ABSYSE {

	static int t;
	static String[] s;
	static int[] res;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			
			int index = 0;
			s = new String[5];
			res = new int[3];

			for(int i = 0; i < 5; i++) {
				s[i] = sc.next();
				}

			if(s[0].contains("machula")) {
				res[0] = Integer.parseInt(s[4]) - Integer.parseInt(s[2]);
				res[1] = Integer.parseInt(s[2]);
				res[2] = Integer.parseInt(s[4]);
			}
			else 
				if(s[2].contains("machula")) {
				res[1] = Integer.parseInt(s[4]) - Integer.parseInt(s[0]);
				res[0] = Integer.parseInt(s[0]);
				res[2] = Integer.parseInt(s[4]);
			}
			else 
				if(s[4].contains("machula")) {
				res[2] = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
				res[0] = Integer.parseInt(s[0]);
				res[1] = Integer.parseInt(s[2]);
			}
			System.out.println(res[0] + " + " + res[1] + " = " + res[2]);
		}	
	}
}
