import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QUE1E {
	static int a,b;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int heights[] = new int[n];
			int taller[] = new int[100001];
			int res[] = new int[n];
			
			for(int i=0; i<n; i++) {
				heights[i] = sc.nextInt();
				res[i] = -1;
			}
			
			for(int i=0; i<n; i++) {
				taller[i] = sc.nextInt();
			}
			for(int i=0; i<n-1; i++) {
				boolean flag = false;
				for(int j=0; j<n-i-1; j++) {
					if((heights[j] > heights[j+1]) || (heights[j] == heights[j+1] && taller[j] > taller[j+1])) {
						int temp1 = heights[j], temp2 = taller[j];
						heights[j] = heights[j+1];
						heights[j+1] = temp1;
						
						taller[j] = taller[j+1];
						taller[j+1] = temp2;
						flag = true;
					}
				}
				if(flag == false) {
					break;
				}
			}
//			for(int i=0; i<n-1; i++) {
//				for(int j=i+1; j<n; j++) {
//					if((heights[i] > heights[j]) || (heights[j] == heights[i] && taller[i] > taller[j])) {
//						int temp1 = heights[i], temp2 = taller[i];
//						heights[i] = heights[j];
//						heights[j] = temp1;
//						
//						taller[i] = taller[j];
//						taller[j] = temp2;
//					}
//				}
//			}
			int cnt;
			for (int i = 0; i < n; ++i) {
				cnt = 0;
				for (int j = 0; j < n; ++j) {
					if (res[j] == -1) {
						cnt++;
						if (cnt > taller[i]) {
							res[j] = heights[i];
							break;
						}
					}
				}
			}
			for(int k=0; k<n; k++) {
				System.out.print(res[k] + " ");
			}
			System.out.println();
		}
	}
}
