import java.io.FileInputStream;
import java.util.Scanner;

public class BROKEN {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		while(true) {
			int[] visit = new int[1000];
			int m = sc.nextInt();
			if(m == 0) {
				break;
			}
			sc.nextLine();
			String s = sc.nextLine();
//			System.out.println(m + " " + s);
			int maxLen = 0, startIdx = 0, idx = 0, numDiffChar = 0, len = s.length();
			// dung 2 con tro
			while(idx < len) {
				// chua xuat hien trong xau
				if(visit[s.charAt(idx)] == 0) {
					// chua = so luong ky tu khac nhau cho phep
					if(numDiffChar < m) {
						// danh dau ki tu nay da xuat hien
						visit[s.charAt(idx)] = 1;
						// tang so luong ki tu 
						numDiffChar++;
						idx++;
					}
					// neu so luong ki tu max tuc la khong the them dc nua
					else if(numDiffChar == m) {
						// max = index di duoc tru cho ki tu bat dau
						int currMax = idx - startIdx;
						if(currMax > maxLen)
							maxLen = currMax;
						// khi so luong ki tu max thi dich phai, xoa dan dan cho den vi tri hien tai cua index
						while(numDiffChar == m) {
							visit[s.charAt(startIdx)]--;
							if(visit[s.charAt(startIdx)] == 0)
								numDiffChar--;
							startIdx++;
						}
					}
				}
				else {
					// co xuat hien trong xau roi thi chi tang visit va index khong can tang numDiffChar
					visit[s.charAt(idx)]++;
					idx++;
				}
			}
			int currLen = idx - startIdx;
			if(currLen > maxLen) {
				maxLen = currLen;
			}
			System.out.println(maxLen);
		}
	}
}
