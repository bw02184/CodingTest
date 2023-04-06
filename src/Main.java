import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        try{
            for(String str : s.split("")){
                switch(str){
                    case "(": stack.push("(");break;
                    case ")": stack.pop(); break;
                }
            }
        }catch(Exception e){
            answer = false;
        }
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}