import java.io.FileInputStream;
import java.util.Scanner;

public class HYDRO {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			int[] a = new int[N];
			
			for(int i = 0; i < N; i++)
				a[i] = sc.nextInt();
			
			int left = 0, right = N - 1, maxL = a[left], maxR = a[right], maxWater = 0;
			
			while(left < right) {
				if(maxL < maxR) {
					left++;
					if(a[left] > maxL) {
						maxL = a[left];
					}
					else {
						maxWater += maxL - a[left];
					}
				}
				else {
					right--;
					if(a[right] > maxR) {
						maxR = a[right];
					}
					else {
						maxWater += maxR - a[right];
					}
				}
			}
			System.out.println(maxWater);
		}
	}
}
