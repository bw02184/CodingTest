package Programmers.two;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int nOneCount = getOneCount(n);
        int otherOneCount = getOneCount(++n);
        while(nOneCount != otherOneCount){
            otherOneCount = getOneCount(++n);
        }
        return n;
    }

    public int getOneCount(int n){
        int count=0;
        String bin = Integer.toBinaryString(n);
        for(int i=0; i<bin.length(); i++){
            if(bin.charAt(i)=='1') count++;
        }
        return count;
    }
}