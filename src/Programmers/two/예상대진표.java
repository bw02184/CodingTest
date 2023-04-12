package Programmers.two;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            a = (int) Math.round(a / 2.0);
            b = (int) Math.round(b / 2.0);
            answer++;
        }

        return answer;
    }
}