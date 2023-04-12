package Programmers.two;

import java.util.Arrays;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] array = new int[10000001];
        for(Integer t : tangerine){
            array[t] = array[t]+1;
        }

        Arrays.sort(array);
        int sum=0;
        int index = 1;
        for(int i=array.length-1; i>0; i--){
            sum +=array[i];
            if(sum >= k) {
                answer = index;
                break;}
            index++;
        }
        return answer;
    }
}