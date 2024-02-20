// import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class spoj_ONP_TransfromTheExpression {
    public static void main(String[] args) {
        // System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.nextLine();
            int len = s.length();
            Stack<Character> st = new Stack<>();
            String output = "";
            int counter = -1;
            while(counter++<len-1){
                if(s.charAt(counter) == '('){
                    continue;
                }
                char c = s.charAt(counter);
                if(c == '+' || c== '-' || c == '*' || c == '/' || c == '^'){
                    st.add(c);
                    continue;
                }else if (c == ')'){
                    output += st.pop();
                }else {
                    output += c;
                    continue;
                }
            }
            System.out.println(output);
        }
        sc.close();
    }
}
