import java.io.FileInputStream;
import java.util.Scanner;
public class CryptoGame {

	
	static int t, n, m, len;
	static int[] a, pos, num;
	static int[][] arr;
	static String[] oper;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = 1;
		while(t <= 1) {
			n = sc.nextInt();
			
			a = new int[10003];
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			len = n;
			
			m = sc.nextInt();
			
			oper = new String[m];
			pos = new int[m];
			num = new int[m];
			arr = new int[m][102];
			
			int index = 0;
			
			for(int i = 0; i < m; i++) {
				oper[i] = sc.next();
				pos[i] = sc.nextInt();
				num[i] = sc.nextInt();
				if(oper[i].toUpperCase().contains("I")) {
					for(int j = 0; j < num[i]; j++) {
						arr[index][j] = sc.nextInt();
					}
					index++;
				}
			}
//			for(int i = 0; i < m; i++) {
//				System.out.println("oper = " + oper[i] + " pos = " + pos[i] +" num = " + num[i]);
//			}
//			System.out.println();
//			for(int i = 0; i < index; i++) {
//				for(int j = 0; j < num[i]; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
			int idx = 0;
			for(int i = 0; i < m; i++) {
				if(oper[i].toUpperCase().contains("I")) {
					insert(idx, i);
					idx++;
				}else if(oper[i].toUpperCase().contains("D")) {
					delete(i);
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < len; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			t++;
		}
	}
	public static void insert(int idx, int insertI) {
		int positionI = pos[insertI];
		int numInsertI = num[insertI];
		int l1 = len;
		for(int i = l1 - 1; i >= positionI; i--) {
			a[i + numInsertI] = a[i];
		}
		int j = 0;
		for(int k = positionI; k < positionI + numInsertI; k++) {
				a[k] = arr[idx][j++];
		}
		len += numInsertI;
	}
	public static void delete(int deleteI) {
		int position = pos[deleteI];
		int numDelete = num[deleteI];
		int l = len - numDelete;
		for(int i = position; i < l; i++) {
			a[i] = a[i + numDelete];
		}
		len -= numDelete;
	}
}
