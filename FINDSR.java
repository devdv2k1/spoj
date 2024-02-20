import java.io.FileInputStream;
import java.util.Scanner;

public class FINDSR {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\vieta\\eclipse-workspace\\SVMC\\input.txt"));
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = sc.nextLine();
			if(s.equals("*")) {
				break;
			}
			int len = s.length();
			// S = T N = T T T ... -> tim N max
			// neu do dai chuoi con T la min -> N max
			int len_substr = 1;
			int max_root = 0;
			while(true) {
				// do dai chuoi con phai chia het cho do dai S, vi du abcabc neu xet len_substr = 4 thi chi xet dc den abca khong xet duoc ca chuoi
				if(len % len_substr != 0) {
					len_substr++;
					continue;
				}
				int idx = 0;
				boolean ok = true;
				while(true) {
					// vuot qua do dai S 
					if(idx + len_substr + 1 > len)
						break;
					// neu vi tri dau tien dang xet khong = vi tri sub_str tiep theo thi no la max r
					// vd abcdabc -> xet abc thi a khong = d -> dang bi sai no phai lien tiep nhau
					for(int i = 0; i < len_substr; i++) {
						if(s.charAt(i + idx) != s.charAt(i + len_substr + idx)) {
							ok = false;
							break;
						}
					}
					// sai thi len_substr do dang khong phu hop
					if(!ok)
						break;
					idx += len_substr;
				}
				// vd abcabc thi len = 6, lensubtr phu hop = 3 -> max_root = 2
				if(ok) {
					max_root = len / len_substr;
					break;
				}
				len_substr++;
			}
			System.out.println(max_root);
		}
	}
}
