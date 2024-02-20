import java.util.Scanner;
import java.io.FileInputStream;;
class Main{
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\OnlinePTIT\\tt\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];;
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
            int[][] visit = new int[m][n];
            int index = 0;
                boolean cd = false;
                int idx = 0;
//                int i, j;
        for(int k = 0; k < len; k++) {
	        for(int i = 0; i < m; i++){
	            // if(cd)
	            //     break;
	            for(int j = 0; j < n; j++){
	                if(visit[i][j] == 0 && arr[idx] == mat[i][j]){
	                    visit[i][j] = 1;
	                    cd = check(visit, i, j, m, n);
	                    System.out.println(cd);
	//                    i = 0;
	//                    j = 0;
	                    if(cd){
	                        System.out.println(idx);
	                    }
	                    idx++;
	                    break;
	                }
	            }
	        }
            for(int x = 0; x < m; x++){
                 for(int y = 0; y < n; y++){
                    System.out.print(visit[x][y] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
            System.out.println(idx);
        }
        public static boolean check(int[][] visit, int i, int j, int m, int n){
            boolean checkRow = true, checkCol = true;
            for(int l = j - 1; l >= 0; l--){
                if(visit[i][l] == 0)
                    checkRow = false;
            }
            for(int r = j + 1; r < n; r++){
                if(visit[i][r] == 0)
                    checkRow = false;
            }
            for(int t = i - 1; t >= 0 ; t--){
                if(visit[t][j] == 0)
                    checkCol =  false;
            }
            for(int b = i + 1; b < m; b++){
                if(visit[b][j] == 0)
                    checkCol =  false;
            }
            return checkRow || checkCol;
        }
}

