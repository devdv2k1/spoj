import java.util.Scanner;
import java.io.FileInputStream;

class Pos{
    public int r;
    public int c;
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Hole{
    public Pos A;
    public Pos B;
    public int time;
    public Hole(int r1, int c1, int r2, int c2, int t) {
        A = new Pos(r1, c1);
        B = new Pos(r2, c2);
        time = t;
    }
}
public class WormHole {

    static int N, SR, SC, ER, EC, minTime;
    static Hole map[];
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
         System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            SR = sc.nextInt();
            SC = sc.nextInt();
            ER = sc.nextInt();
            EC = sc.nextInt();
            
            map = new Hole[100];
            visit = new boolean[100];
            
            for(int i = 1; i <= N; i++) {
                map[i] = new Hole(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            
            
            minTime = Integer.MAX_VALUE;
            backtrack(SR, SC, 0);
            System.out.println(minTime);
        }
    }
    public static void backtrack(int r, int c, int time) {
        minTime = Math.min(minTime, time + cal(r, c, ER, EC));
        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                
                backtrack(map[i].B.r, map[i].B.c, time + cal(r, c, map[i].A.r, map[i].A.c) + map[i].time);
                backtrack(map[i].A.r, map[i].A.c, time + cal(r, c, map[i].B.r, map[i].B.c) + map[i].time);
                
                visit[i] = false;
            }
        }
    }
    public static int cal(int a, int b, int c, int d) {
        return Math.abs(a - c) + Math.abs(b - d);
    }
}