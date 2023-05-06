import java.util.*;

class Solution {
  public int solution(int[] topping) {
    int answer = 0;
    int index = 0;
    HashMap<Integer, Integer> map1 = new HashMap<>();
    HashMap<Integer, Integer> map2 = new HashMap<>();
    for (int i = 0; i <= index; i++) {
      map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
    }
    for (int j = index + 1; j < topping.length; j++) {
      map2.put(topping[j], map2.getOrDefault(topping[j], 0) + 1);
    }
    while (index < topping.length - 1) {
      index++;
      map1.put(topping[index], map1.getOrDefault(topping[index], 0) + 1);
      map2.put(topping[index], map2.getOrDefault(topping[index], 0) - 1);
      if (map2.get(topping[index]) == 0) {
        map2.remove(topping[index]);
      }
      if (map1.size() == map2.size()) answer++;
      // System.out.println(map1.size()+" " +map2Count);
    }
    return answer;
  }
}
