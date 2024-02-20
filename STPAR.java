import java.io.FileInputStream;
import java.util.Scanner;

public class STPAR {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			if(N == 0) {
				break;
			}
			int[] order = new int[N];
			int[] stack = new int[1005];
			for(int i = 0; i < N; i++)
				order[i] = sc.nextInt();
			int stack_len = 0;
			boolean ok = true;
			int start = 1;
			
			for(int i = 0; i < N; i++) {
				while(stack_len > 0 && stack[stack_len - 1] == start) {
					stack_len--;
					start++;
				}
				if(order[i] == start)
					start++;
				else if(stack_len > 0 && stack[stack_len - 1] < order[i]) {
					ok = false;
					break;
				}
				else {
					stack[stack_len]  = order[i];
					stack_len++;
				}
			}
			if(ok)
				System.out.println("yes");
			else
				System.out.println("no");
			
		}
	}

}
