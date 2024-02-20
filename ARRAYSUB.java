import java.io.FileInputStream;
import java.util.*;
//import java.lang.*;

public class ARRAYSUB {
	
	static int[] a, res;
	static int K, N;

	public static void main(String[] args) throws java.lang.Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
//		int[] a, res;
		N = sc.nextInt();
		a = new int[N];
		for(int i = 0; i < N; i++)
			a[i] = sc.nextInt();
		
		K = sc.nextInt();
		res = new int[N - K + 1];

		for(int i = 0; i <= N - K; i++) {
			res[i] = maxV(i);
//			int maxvalue = a[i];
//			for(int j = i + 1; j < i + K; j++) {
//				if(a[j] > maxvalue){
//					maxvalue = a[j];
//				}
//			}
//			res[i] = maxvalue;
		}
		for(int i = 0; i <= N - K; i++)
			System.out.print(res[i] + " ");
//		System.out.println();
	}
	public static int maxV(int start) {
		int max = a[start];
		for(int i = start + 1; i < start + K; i++) {
			if(a[i] > max){
				max = a[i];
			}
		}
		return max;
	}
}
