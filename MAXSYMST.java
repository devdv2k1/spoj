import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MAXSYMST {

	static char[] s; 
	static int t, res;
	static String input;
	static boolean isPalin[][];
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			ret = 0;		
			str = sc.next();
			
			for (int i = 0; i < str.length(); i++) {
				currLen = longestPalindrome(str, i);
				
				if (currLen > ret) {
					ret = currLen;
				}
			}
			
			System.out.println("#" + tc + " " + ret);					
		}
		
		sc.close();
	}
	
	//Tìm độ dài chuỗi đối xứng dài nhất với pos là vị trí ở giữa
	static int longestPalindrome(String str, int pos)
	{
		int maxLen = 1;
		int i;
		
		for (i = 1; pos - i >= 0 && pos + i < str.length(); i++) {
			if (str.charAt(pos - i) != str.charAt(pos + i)) {
				break;
			}
		}
		
		//chuỗi có độ dài lẻ dài nhất tại vị trí pos: từ pos - (i - 1) đến pos + (i - 1)
		if (i * 2 - 1 > maxLen) {
			maxLen = i * 2 - 1;
		}

		for (i = 0; pos - i >= 0 && pos + i + 1 < str.length(); i++) {
			if (str.charAt(pos - i) != str.charAt(pos + i + 1)) {
				break;
			}
		}
		
		//chuỗi có độ dài chẵn dài nhất tại vị trí pos: từ pos - (i - 1) đến pos + i
		if (i * 2> maxLen) {
			maxLen = i * 2;
		}

		return maxLen;
	}
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
// 			res = 1; // dai nhat luon la 1
// 			for(int len = 2; len <= n; len++) {
// 				for(int i = 1; i <= n - len + 1	; i++) {
// 					int j = i + len - 1;
// 					if(len == 2 && s[i] == s[j]) isPalin[i][j] = true;
// 					else {
// 						isPalin[i][j] = isPalin[i + 1][j - 1] && (s[i] == s[j]);
// 					}
// 					if(isPalin[i][j] && len > res) res = len;
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
		
	}

}
