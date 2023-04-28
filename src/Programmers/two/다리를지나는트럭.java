import java.util.*;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    Queue<LinkedList<Integer>> queue = new LinkedList<>();

    int weights = 0;
    int i = 0;
    while (i < truck_weights.length) {
      LinkedList<Integer> list = new LinkedList<>();
      if (!queue.isEmpty() && queue.peek().get(1) + bridge_length == answer) {
        weights -= queue.peek().get(0);
        queue.poll();
      }
      if (queue.size() <= bridge_length && weights + truck_weights[i] <= weight) {
        weights += truck_weights[i];
        list.add(truck_weights[i]);
        list.add(answer);
        queue.offer(list);
        i++;
      }
      answer++;
      // System.out.println(queue);
    }

    return answer + bridge_length;
  }
}
