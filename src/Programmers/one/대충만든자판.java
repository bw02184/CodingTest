package Programmers.one;

import java.util.HashMap;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            String[] s=keymap[i].split("");
            for(int j=0; j<keymap[i].length(); j++){
                if(map.getOrDefault(s[j], 101) >j) map.put(s[j],j+1);

            }
        }
        System.out.println(map);
        int index=0;
        for(String s : targets){
            int sum=0;
            for(int i=0; i<s.length(); i++){
                if(map.get(""+s.charAt(i)) == null){
                    sum = -1;
                    break;
                }
                else
                    sum +=map.get(""+s.charAt(i));
            }
            answer[index] = sum;
            index++;
        }
        return answer;
    }
}