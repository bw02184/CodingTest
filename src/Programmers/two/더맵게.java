import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int num : scoville)
            pQueue.offer(num);
        while(pQueue.size()>=2 && pQueue.peek() <K){
            int first = pQueue.poll();
            int second = pQueue.poll();
            int newNum = first+2*(second);
            pQueue.offer(newNum);
            answer++;
            //System.out.println(pQueue);
        }
        if(pQueue.size()<2 && pQueue.poll() < K){
            answer = -1;
        }
        return answer;
    }
}