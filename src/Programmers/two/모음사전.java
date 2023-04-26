import java.util.*;

class Solution {
  static LinkedList<String> list = new LinkedList<>();

  public int solution(String word) {
    dfs("", 0);

    return list.indexOf(word);
  }

  public static void dfs(String str, int index) {
    if (str.length() > 5) return;
    list.add(str);
    for (int i = 0; i < 5; i++) {
      dfs(str + "AEIOU".charAt(i), index + 1);
    }
  }
}
