package Programmers.two;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int length = s.length();
            int zCount=0;
            for(int i=0;i<length; i++){
                if(s.charAt(i)=='0') zCount++;
            }
            s = Integer.toBinaryString(length-zCount);
            answer[0]++;
            answer[1] += zCount;
        }
        return answer;
    }
}