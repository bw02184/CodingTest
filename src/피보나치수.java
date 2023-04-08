class Solution {
    public double solution(int n) {
        int answer = 0;
        long[] temp = new long[n+1];
        temp[1]=1L;
        for(int i=2; i<=n;i++){
            temp[i]=(temp[i-2]+temp[i-1])%1234567L;
        }
        return temp[n];
    }
}