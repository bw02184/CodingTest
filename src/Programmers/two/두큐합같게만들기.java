import java.util.*;

class Solution {
  public int solution(int[] queue1, int[] queue2) {
    int answer = -2;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    long sum1 = 0, sum2 = 0;
    for (int q : queue1) {
      q1.offer(q);
      sum1 += q;
    }
    for (int q : queue2) {
      q2.offer(q);
      sum2 += q;
    }
    final long halfSum = (sum1 + sum2) / 2;
    //         if(sum %2==1) return -1;
    //         if(Arrays.stream(queue1).filter(i -> i>halfSum).count()>0) return -1;
    //         else if(Arrays.stream(queue2).filter(i -> i>halfSum).count()>0) return  -1;
    int index = 0;
    while (index <= 2 * (queue1.length + queue2.length)) {
      if (sum1 > halfSum) {
        sum1 -= q1.peek();
        sum2 += q1.peek();
        q2.offer(q1.poll());
        index++;
      } else if (sum1 == sum2) {
        break;
      } else {
        sum2 -= q2.peek();
        sum1 += q2.peek();
        q1.offer(q2.poll());
        index++;
      }
    }
    answer = index >= 2 * (queue1.length + queue2.length) ? -1 : index;

    return answer;
  }
}
