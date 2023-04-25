import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("[^").append(skill).append("]");
        for(String str : skill_trees){
            str = str.replaceAll(sb.toString(),"");
            //System.out.println(str);
            boolean isTrue = true;
            for(int i=0; i<skill.length(); i++){
                if(str.length() > i && skill.charAt(i)!=str.charAt(i)){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue)answer++;

        }
        //System.out.println(Arrays.toString(skill_trees));
        return answer;
    }
}