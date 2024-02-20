import java.io.FileInputStream;
import java.util.Scanner;

public class QuanLyMang {

	static int t, n, m, len;
	static int[] a, res, value, pos;
	static String[] oper;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			
			n = sc.nextInt();
			
			a = new int[1001];
			for(int i = 0; i < n; i++) 
				a[i] = sc.nextInt();
				
			m = sc.nextInt();
			sc.nextLine();
			pos = new int[1001];
			value = new int[1001];
			oper = new String[m];

			for(int i = 0; i < m; i++) {
				oper[i] = sc.next();
				if(oper[i].contains("delete")) {
					pos[i] = Integer.parseInt(sc.next());
					value[i] = -1;
				}else {
					pos[i] = Integer.parseInt(sc.next());
					value[i] = Integer.parseInt(sc.next());
				}
			}
//			System.out.println(n);
//			System.out.println(m);
//			for(int i = 0; i < n; i++)
//				System.out.print(a[i] + " ");
//			System.out.println();
//			for(int i = 0; i < m; i++) {
//				
//				System.out.print(oper[i]);
//				System.out.println();
//			}
			len = n;
			for(int i = 0; i < m; i++) {
				if(oper[i].contains("insert")) {
					int vtri =  pos[i];	
					int gtri =  value[i];
					insert(vtri, gtri);
				}
				else if(oper[i].contains("update")) {
					int vtri =  pos[i];	
					int gtri =  value[i];
					update(vtri, gtri);
				}
				else if(oper[i].contains("delete")) {
					int vtri = pos[i];
					delete(vtri);
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < len; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
	}
	public static void insert(int vtri, int gtri) {
		len = len + 1;
//		System.out.println(pos + " " + value);
		for(int i = len - 1; i > vtri; i--)
			a[i] = a[i - 1];
		a[vtri] = gtri;

	}
	public static void update(int vtri, int gtri) {
		a[vtri] = gtri;
	}
	public static void delete(int vtri) {
		len = len - 1;
		for(int i = vtri; i < len; i++) {
			a[i] = a[i + 1];
		}
	}
}
