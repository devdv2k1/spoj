import java.io.*;
import java.util.*;

public class NUMPER {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int flag = 0;
			System.out.print("#"+i +" ");
			for(int j=a; j<=b; j++) {
				if(chinhPhuong(j)==1) {
					System.out.print(j+" ");
					flag = 1;
				}
			}
			if(flag==0) {
				System.out.print("NO NUMBER");
			}
			System.out.println();
		}
	}
	public static int chinhPhuong(int j) {
		int i;
		for(i=1; i*i<j; ++i);
		if(i*i == j)
			return 1;
		return 0;
	}
}
