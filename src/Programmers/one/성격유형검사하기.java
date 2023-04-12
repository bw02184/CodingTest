package Programmers.one;

import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] type = {"RT","CF","JM","AN"};
        String answer = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<survey.length;i++){
            int zero = map.getOrDefault(survey[i].charAt(0),0);
            int first = map.getOrDefault(survey[i].charAt(1),0);
            map.put(survey[i].charAt(0),
                choices[i]>=4?0 + zero : 4-choices[i] + zero);
            map.put(survey[i].charAt(1),
                choices[i]>=4?choices[i]-4 + first : 0 +first);
        }
        for(int i=0; i<type.length; i++){
            int zero = map.getOrDefault(type[i].charAt(0), 0);
            int first = map.getOrDefault(type[i].charAt(1), 0);
            if(zero == first)answer +=type[i].charAt(0);
            else if(zero > first)answer +=type[i].charAt(0);
            else answer +=type[i].charAt(1);
        }
        return answer;
    }
}