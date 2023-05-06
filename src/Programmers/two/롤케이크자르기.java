import java.util.*;

class Solution {
  public int solution(int[] topping) {
    int answer = 0;
    int index = 0;
    while (index < topping.length) {
      HashSet<Integer> set1 = new HashSet<>();
      HashSet<Integer> set2 = new HashSet<>();
      for (int i = 0; i <= index; i++) {
        set1.add(topping[i]);
      }
      for (int j = index + 1; j < topping.length; j++) {
        set2.add(topping[j]);
      }
      if (set1.size() == set2.size()) answer++;
      index++;
    }
    return answer;
  }
}
