import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int col = Integer.parseInt(br.readLine().trim());
        int row = Integer.parseInt(br.readLine().trim());
        int[][] dp = new int[col][];
        for(int i=0; i<col; i++){
            dp[i] = new int[i+1];
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for(int i=2; i<col; i++){
            for(int j=1;j<i;j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];

            }
        }
        //System.out.println((Arrays.deepToString(dp)));
        System.out.println(dp[col-1][row-1]);
    }
}