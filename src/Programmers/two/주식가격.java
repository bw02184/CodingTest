class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=prices.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(prices[j]<=prices[i]){
                    answer[j]++;
                }
                else{
                    answer[j]=1;
                }
            }
        }
        return answer;
    }
}