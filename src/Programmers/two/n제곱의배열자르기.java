import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int[][] squard = new int[n][n];
        int[] temp = new int[n*n];
        int index=0;
        for(int i=0; i<squard.length; i++){
            for(int j=0; j<squard.length; j++){
                if(j < i+1) squard[i][j] = i+1;
                else squard[i][j] = j+1;
                temp[index++] = squard[i][j];
            }
        }
        index=0;
        //System.out.println(Arrays.deepToString(squard));
        //System.out.println(Arrays.toString(temp));
        for(int i=(int)left; i<=right; i++)
            answer[index++] = temp[i];
        return answer;
    }
}