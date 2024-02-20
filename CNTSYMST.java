import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CNTSYMST {

	static char[] s; 
	static int t, res;
	static String input;
	static boolean isPalin[][];
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);

		String str;
		int ret;
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; ++tc) {
			ret = 0;		
			str = sc.next();
			
			for (int i = 0; i < str.length(); i++) {
				ret += countPalindrome(str, i);
			}
			
			System.out.println("#" + tc + " " + ret);					
		}
		
		sc.close();
	}
	
	//Từ vị trí pos, lan sang 2 bên để đếm số palindrome mà có pos là vị trí ở giữa
	static int countPalindrome(String str, int pos)
	{
		int cnt = 1; //bản thân mỗi phần tử đã là một palindrome
		
		//Trường hợp độ dài chuỗi lẻ, so sánh các phần tử đối xứng qua pos, ví dụ pos - 1 vs pos + 1
		for (int i = 1; pos - i >= 0 && pos + i < str.length(); i++) {
			if (str.charAt(pos - i) == str.charAt(pos + i)) {
				cnt++;
			} else {
				break;
			}
		}
		
		//Trường hợp độ dài chẵn, so sánh các phần tử đối xứng qua cặp pos và pos + 1, ví dụ pos - 1 vs pos + 2
		for (int i = 0; pos - i >= 0 && pos + i + 1 < str.length(); i++) {
			if (str.charAt(pos - i) == str.charAt(pos + i + 1)) {
				cnt++;
			} else {
				break;
			}
		}
		
		return cnt;
	}
// 		Scanner sc = new Scanner(System.in);
// 		t = sc.nextInt();
// 		for(int tc = 1; tc <= t; tc++) {
			
// 			input  = sc.next();
// 			int n = input.length();
// 			input = "x" + input; // them vao dau de day index len 1 -> theo do dai cua xau
// //			System.out.println(input);
// 			s = new char[1001];
// 			isPalin = new boolean[1001][1001];
			
// //			System.out.println(n);
// 			s = input.toCharArray();
			
// //			for(int i = 1; i <= n; i++)
// //				System.out.println(s[i]);;
			
// 			for(int i = 1; i <= n; i++)
// 				isPalin[i][i] = true;
// 			res = 0;
// 			for(int len = 2; len <= n; len++) {
// 				for(int i = 1; i <= n - len + 1	; i++) {
// 					int j = i + len - 1;
// 					if(len == 2 && s[i] == s[j]) isPalin[i][j] = true;
// 					else {
// 						isPalin[i][j] = isPalin[i + 1][j - 1] && (s[i] == s[j]);
// 					}
// 				}
// 			}
// 			for(int i = 1; i <= n; i++) {
// 				for(int j = 1; j <= n; j++) {
// 					res += isPalin[i][j] ? 1 : 0;
// 				}
// 			}
// 			System.out.println("#" + tc + " " + res);
// //			freq = new int[128];
// //			
// //			s = sc.next();
// //			
// //			for(char c : s.toCharArray())
// //				freq[c]++;
// //			int OddChar = 0;
// //			for(int i : freq){
// //				
// //				OddChar += i & 1;
// //				// System.out.println(i&1);
// //				
// //			}
// //			res = s.length() - OddChar + (OddChar > 0 ? 1 : 0);
// //			System.out.print("#" + tc + " " +res);
// //			System.out.println();
// 		}
		
// 	}

}
