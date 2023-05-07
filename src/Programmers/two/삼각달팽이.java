import java.util.*;

class Solution {
  public int[] solution(int n) {
    int[] answer = {0};
    int[][] tri = new int[n][];
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      tri[i - 1] = new int[i];
      sum += i;
    }
    int index = 1;
    int row = 0, col = 0;
    while (sum >= index) {
      // 위->아래
      while (row < n && tri[row][col] == 0) {
        tri[row++][col] = index++;
      }
      row--;
      col++;
      // 아래 ->오른쪽
      while (col < n && tri[row][col] == 0) {
        tri[row][col++] = index++;
      }
      row--;
      col -= 2;
      while (row >= 0 && col >= 0 && tri[row][col] == 0) {
        tri[row--][col--] = index++;
      }
      row += 2;
      col++;
      // System.out.println("row : "+row);
      // System.out.println("col : "+col);

    }
    // System.out.println(Arrays.deepToString(tri));

    answer = new int[sum];
    index = 0;
    for (int[] number : tri) {
      for (int num : number) {
        answer[index++] = num;
      }
    }

    return answer;
  }
}
