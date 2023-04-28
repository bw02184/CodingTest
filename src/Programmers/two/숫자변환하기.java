import java.util.*;

class Solution {
  public int solution(int x, int y, int n) {
    int answer = 0;
    int[] dp = new int[1000001];
    Arrays.fill(dp, -1);
    int i = x;
    dp[x] = 0;
    while (i + n <= 1000000) {
      i += n;
      dp[i] = dp[i - n] + 1;
      if (i % 3 == 0 && dp[i / 3] != -1) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      if (i % 2 == 0 && dp[i / 2] != -1) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
    }
    return dp[y];
  }
}
