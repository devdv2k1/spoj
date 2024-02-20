import java.io.FileInputStream;
import java.util.Scanner;

public class ANARC09A {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true) {
			String s = sc.nextLine();
			if(s.charAt(0) == '-') {
				break;
			}
			int res = 0, open = 0, len = s.length();
			for(int i = 0; i < len; i++) {
				if(s.charAt(i) == '{') {
					open++;
				}
				else if(s.charAt(i) == '}' && open > 0) {
					open--;
				}
				else {
					open++;
					res++;
				}
			}
			res += open/2;
			
			System.out.println(tc + ". " + res);
			tc++;
		}
	}
}
