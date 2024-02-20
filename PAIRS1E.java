import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PAIRS1E {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n;
			int k;
			n = sc.nextInt();
			k = sc.nextInt();
			int[] a = new int[n];
			
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			int dem = 0;
//			for(int i=0; i<n-1; i++) {
//				boolean flag = false;
//				for(int j=0; j<n-i-1; j++) {
////					if((a[j-i] - a[i] == k) || (a[j-i] - a[i] == -k)) {
////						dem++;
////					}
////					if(a[j-i] + k == a[i] || a[i]+k == a[j-i]) {
////						dem++;
////					}
//					if(a[j] > a[j+1]) {
//						long temp = a[j];
//						a[j] = a[j+1];
//						a[j+1] = temp;
//						flag = true;
//					}
//				}
//				if(!flag) {
//					break;
//				}
//			}
			sort(a, 0, n - 1);
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					if(a[j] - a[i] == k) {
						dem++;
					}
				}
			}
//			for(int i=0; i<n; i++) {
//				System.out.print(a[i] + " ");
//			}
//			System.out.println();
			System.out.println(dem);
		}
	}
	public static void merge(int[] a, int l, int m, int r) {
		int l1 = m + 1 - l, l2 = r - m;
		int[] L = new int[l1], R = new int[l2];
		
		for(int i = 0; i < l1; i++) {
			L[i] = a[l + i];
		}
		for(int j = 0; j < l2; j++) {
			R[j] = a[m + 1 + j];
		}
		int i = 0, j = 0, idx = l;
		while(i < l1 && j < l2) {
			if(L[i] <= R[j]) {
				a[idx] = L[i];
				i++;
			}
			else {
				a[idx] = R[j];
				j++;
			}
			idx++;
		}
		while(i < l1) {
			a[idx] = L[i];
			idx++;
			i++;
		}
		while(i < l2) {
			a[idx] = R[j];
			idx++;
			j++;
		}
	}
	public static void sort(int[] a, int l, int r) {
		if(l < r) {
			int m = l + (r - l)/2;
			
			sort(a, l, m);
			sort(a, m + 1, r);
			merge(a, l, m, r);
		}
	}
}
