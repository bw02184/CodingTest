import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    for (int testCase = 0; testCase < tc; testCase++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] array =
          Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
      Number[] num = new Number[array.length];
      LinkedList<Number> list = new LinkedList<>();
      int index = 0;
      for (int arr : array) {
        num[index] = new Number(arr, index);
        list.add(num[index]);
        index++;
      }
      int answer = 0;
      loop:
      while (true) {
        boolean isTrue = false;
        for (int i = 1; i < list.size(); i++) {
          if (list.get(0).getNum() < list.get(i).getNum()) {
            isTrue = true;
            list.add(list.remove(0));
            break;
          }
        }
        if (!isTrue) {
          answer++;
          if (list.get(0).getIndex() == m) {
            break loop;
          }
          list.remove(0);
        }
      }
      System.out.println(answer);
    }
  }

  public static class Number {
    int num;
    int index;

    public Number(int num, int index) {
      this.num = num;
      this.index = index;
    }

    public int getNum() {
      return num;
    }

    public int getIndex() {
      return index;
    }

    public String toString() {
      return num + " " + index;
    }
  }
}
