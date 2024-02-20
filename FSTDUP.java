import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FSTDUP {
	
	static int n, t, idx; 
	static int[] a, res;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int x = 1; x <= t; x++) {
			n = sc.nextInt();
			
			a = new int[n];
			res = new int[100001];
			idx = -1;
			
			for(int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			
			for(int i = 0; i < n; i++) {
				if(res[a[i]] == 1) {
					idx = a[i];
					break;
				}
				res[a[i]]++;
			}
				
			System.out.print("#" + x + " " + idx);
			System.out.println();
		}
	}

}
