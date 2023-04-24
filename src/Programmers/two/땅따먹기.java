import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp= new int[land.length][land[0].length];
        dp[0][0]=land[0][0];
        dp[0][1]=land[0][1];
        dp[0][2]=land[0][2];
        dp[0][3]=land[0][3];
        for(int i=1; i<land.length;i++){
            for(int j=0; j<land[0].length; j++){
                if(j==0)
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][3]));
                else if(j==1)
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0],Math.max(dp[i-1][2],dp[i-1][3]));
                else if(j==2)
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][3]));
                else
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[land.length-1][0],Math.max(dp[land.length-1][1],Math.max(dp[land.length-1][2],dp[land.length-1][3])));
    }
}