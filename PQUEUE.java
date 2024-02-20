import java.io.FileInputStream;
import java.util.Scanner;

public class PQUEUE {

	static int N, M;
	static int[] prior, count;
	static boolean[] printed;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			prior = new int[1000];
			count = new int[10];
//			System.out.println(N + " " + M);
			printed = new boolean[105];
			for(int i = 0; i < N; i++) {
				prior[i] = sc.nextInt();
				count[prior[i]]++;
//				printed[i] = false;
			}
//			for(int i = 0; i < N; i++) {
//				System.out.print(prior[i] + " ");
//			}
//			System.out.println();
//			for(int i = 1; i <= 9; i++) {
//				System.out.println(count[i]);
//			}
			int time = 0;
            int index = 0, currHighest = 0;
            while (true) {
                while (printed[index]) {
                    index = (index + 1) % N;
                }
                currHighest = 0;
                for (int i = 9; i >= 1; i--) {
                    if (count[i] != 0) {
                        currHighest = i;
                        break;
                    }
                }
                if (prior[index] == currHighest) {
                    printed[index] = true;
                    count[currHighest]--;
                    time++;
                    if (index == M) {
                        break;
                    }
                }
                index = (index + 1) % N;
                
            }
            System.out.println(time);
		}
	}
}
