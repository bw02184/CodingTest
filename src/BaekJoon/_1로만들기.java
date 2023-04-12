import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());
        int[] dp = new int[num+1];
        for(int i=2; i<=num; i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0)
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            if(i%3==0)
                dp[i] = Math.min(dp[i],dp[i/3]+1);

        }
        System.out.println(dp[num]);

    }
}