import java.util.LinkedList;
import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        for(String str : s.split(""))
            list.add(str);
        int size = list.size();
        while(size > 0){
            list.add(list.size()-1,list.remove(0));
            Stack<String> stack = new Stack<>();

            for(int i=0; i<list.size(); i++){
                if(stack.isEmpty())stack.push(list.get(i));
                else if(stack.peek().equals("[") && list.get(i).equals("]")) stack.pop();
                else if(stack.peek().equals("{") && list.get(i).equals("}")) stack.pop();
                else if(stack.peek().equals("(") && list.get(i).equals(")")) stack.pop();
                else stack.push(list.get(i));
            }
            if(stack.isEmpty())answer++;

            size--;

        }


        return answer;
    }
}