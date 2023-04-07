import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] array = new int[n+1];
        int left = 0, right = 1;
        int sum=right - left;
        while(right<=n){
            if(sum < n){
                sum += ++right;
            }else if(sum == n){
                answer++;
                sum += ++right;
            }else
                sum -= ++left;
        }

        return answer;
    }
}