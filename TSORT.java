import java.io.FileInputStream;
import java.util.Scanner;

public class TSORT {

	static int[] a;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		a = new int[T];
		for(int i = 0; i < T; i++) {
			a[i] = sc.nextInt();
		}
		sort(a, 0, T - 1);
		for(int i = 0; i < T; i++)
			System.out.println(a[i]);
	}
	public static void merge(int a[], int l, int m, int r) {
		int len1 = m - l + 1;
		int len2 = r - m;
		int L[] = new int[len1];
		int R[] = new int[len2];
		
		for(int i = 0; i < len1; i++)
			L[i] = a[l + i];
		for(int j = 0; j < len2; j++)
			R[j] = a[m + 1 + j];
		int i = 0, j = 0;
		int k = l;
		while(i < len1 && j < len2) {
			if(L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			}
			else {
				a[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < len1) {
			a[k] = L[i];
			k++;
			i++;
		}
		
		while(j < len2) {
			a[k] = R[j];
			k++;
			j++;
		}
	}
	public static void sort(int a[], int l, int r) {
		if(l < r) {
			int m = l + (r - l)/2;
			
			sort(a, l, m);
			sort(a, m + 1, r);
			
			merge(a, l, m , r);
		}
	}
}
