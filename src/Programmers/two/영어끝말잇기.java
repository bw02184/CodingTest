package Programmers.two;

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        int size=0;
        String bfString = words[0];
        set.add(words[0]);
        for(int i=1; i<words.length; i++){
            set.add(words[i]);
            if(set.size() != i+1 || bfString.charAt(bfString.length()-1) != words[i].charAt(0)){
                size = i+1;
                break;
            }
            bfString = words[i];
        }
        answer[0] = size%n ==0 && size !=0? n : size%n;
        answer[1] = (int)Math.ceil(size*1.0/n);
        return answer;
    }
}