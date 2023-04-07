import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] array = new int[n+1];
        for(int i=1; i<n+1; i++){
            array[i] = array[i-1]+i;
        }
        System.out.println(Arrays.toString(array));
        int first = 0, second = 1;
        while(second<=n){
            if(array[second] - array[first] < n){
                second++;
            }else if(array[second] - array[first] == n){
                answer++;
                second++;
            }else
                first++;
        }

        return answer;
    }
}