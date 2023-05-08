import java.util.*;

class Solution {
  public int solution(int[] order) {
    int answer = 0;
    int length = order.length;
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    for (int i = 1; i <= length; i++) {

      if (i < order[index]) stack.push(i);
      else if (i == order[index]) {
        index++;
        answer++;
      }
      while (!stack.isEmpty() && stack.peek() == order[index]) {
        stack.pop();
        index++;
        answer++;
      }
      // System.out.println(stack);
    }
    return answer;
  }
}
