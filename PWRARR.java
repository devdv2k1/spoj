import java.io.FileInputStream;
import java.util.Scanner;

public class PWRARR {
	
	static int[] a, freq;
	static int N;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			N = sc.nextInt();
			a = new int[N];
			sort();
			freq = new int[50005];

			for(int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
				freq[a[i]]++;
			}
			long sum = 0;
			for(int i = 0; i < N - 1; i++) {
				if(a[i] < a[i + 1]) {
					freq[a[i + 1]] = freq[a[i]] + freq[a[i + 1]];
				}
			}
			for(int i = 0; i < N; i++) {
				sum += freq[a[i]];
			}
			System.out.println(sum);
		}
	}
	public static void sort() {
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				if(a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
