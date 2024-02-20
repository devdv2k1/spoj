import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BLDTWR {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		StringBuilder s = new StringBuilder();
//		StringBuffer s1 = new StringBuffer();
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x = 1; x <= t; x++) {
			int n, m1, m2;
			n = sc.nextInt();
			m1 = sc.nextInt();
			m2  = sc.nextInt();
			int brick[] = new int[n];
			for(int i=0; i<n; i++) brick[i] = sc.nextInt();
			
			for(int i=0; i<n-1; i++) {
				boolean flag = false;
				for(int j=0; j<n-i-1; j++) {
					if(brick[j] < brick[j+1]) {
						int temp = brick[j];
						brick[j] = brick[j+1];
						brick[j+1] = temp;
						flag = true;
					}
				}
				if(flag == false) {
					break;
				}
			}
			
			int i = 1, j = 1, index = 0, res = 0;
			while(true) {
				if(i > m1 && j > m2) 
					break;
				if(i <= m1) {
					res += brick[index]*i;
					i++;
					index++;
				}
				if(j <= m2) {
					res += brick[index]*j;
					j++;
					index++;
				}
			}
			System.out.print("#" + x + " " + res);
			System.out.println();
		}
	}

}
