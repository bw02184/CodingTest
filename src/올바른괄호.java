import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char str = s.charAt(i);
            switch(str){
                case '(': stack.push('(');break;
                case ')': if (stack.isEmpty()) answer = false;
                else stack.pop();
            }
        }

        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}