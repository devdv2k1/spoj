import java.util.Scanner;

public class spoj_prime1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int m = sc.nextInt();
            int n = sc.nextInt();
            for(int i=m;i<=n;i++){
                if(checkNT(i)){
                    System.out.println(i);
                }
            }
        }
        sc.close();
    }
    public static boolean checkNT(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
