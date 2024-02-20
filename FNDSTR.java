//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class FNDSTR {
//
//	static int t;
//	static String s1, s2;
//	public static void main(String[] args) throws FileNotFoundException{
//		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
//		Scanner sc = new Scanner(System.in);
//		t = sc.nextInt();
//		sc.nextLine();
//		for(int tc = 1; tc <= t; tc++) {
//			String s[] = new String[1001];
//			s1 = sc.nextLine();
//			s2 = sc.nextLine();
//			int count = 0, l1 = s1.length(), l2 = s2.length();
//			s = s2.strip().split("\\s+");
//			for(int i = 0; i < s.length; i++) { 
//				String temp = s[i];
//				for(int j = 0; j <= temp.length() - l1; j++) {
////						System.out.println("j = " + j + " j + l1 = "+ (j + l1)+" s = "+temp.subSequence(j, j + l1));
//					if(s1.equals(temp.subSequence(j, j + l1)))
//						count++;;
//				}
//			}
////			System.out.println("abcabc".subSequence(3, 3 + l1));
////			System.out.println(s2.length());
////			System.out.println(s2.charAt(12));
////			for(int i = 0; i < s2.length() && i + l1 < l2; i++) {
////				while(s2.charAt(i) == ' ') {
////					i++;
////				}
////				System.out.println(i + " s2 = " + s2.substring(i, i + l1) + " s1 = " + s1);
////				if(s1.equals(s2.substring(i, i + l1)))
////					count++;;
////			}
//			System.out.println("#" + tc + " " + count);
//		}
//	}
//}
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FNDSTR {

	static int t, dem;
	static String s1, s2;
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in, "UTF-8");
		while(true) {
			t = sc.nextInt();
			
			sc.nextLine();

			s1 = sc.nextLine();
			s2 = sc.nextLine();
			
			int l1 = s1.length();
			int l2 = s2.length();
			
//			s1 = "0" + s1;
//			s2 = "0" + s2;
			
//			System.out.println(s1 + " " + s2);
			dem = 0;
			for(int i = 0; i < s2.length(); i++) {
				if(i + s1.length() <= s2.length()) {
					
					String tmp = s2.substring(i, (i + s1.length()));
					if(s1.equals(tmp))
						dem++;
				}
			}
			System.out.println("#" + t + " " + dem);
			if(t == 10) {
				break;
			}
		}
	}
}