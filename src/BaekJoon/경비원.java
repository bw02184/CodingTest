import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] lrArray =
        Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    int point = Integer.parseInt(br.readLine().trim());
    int d[] = new int[point];
    int next[] = new int[point];
    int answer = 0;
    int r = (lrArray[0] + lrArray[1]) * 2;

    for (int m = 0; m < point; m++) {
      StringTokenizer st = new StringTokenizer(br.readLine().trim());
      d[m] = Integer.parseInt(st.nextToken());
      next[m] = Integer.parseInt(st.nextToken());
    }
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int pDir = Integer.parseInt(st.nextToken());
    int pNext = Integer.parseInt(st.nextToken());

    for (int i = 0; i < point; i++) {
      if (pDir == 1) {
        if (d[i] == 1) {
          answer += Math.abs(next[i] - pNext);
        } else if (d[i] == 2) {
          int length = lrArray[1] + pNext + next[i];
          answer += Math.min(length, r - length);
        } else if (d[i] == 3) {
          answer += next[i] + pNext;
        } else {
          answer += lrArray[0] - pNext + next[i];
        }
      } else if (pDir == 2) {
        if (d[i] == 1) {
          int length = lrArray[1] + pNext + next[i];
          answer += Math.min(length, r - length);
        } else if (d[i] == 2) {
          answer += Math.abs(next[i] - pNext);

        } else if (d[i] == 3) {
          answer += lrArray[1] - next[i] + pNext;
        } else {
          answer += lrArray[0] - pNext + lrArray[1] - next[i];
        }
      } else if (pDir == 3) {
        if (d[i] == 1) {
          answer += next[i] + pNext;
        } else if (d[i] == 2) {
          answer += lrArray[1] - pNext + next[i];
        } else if (d[i] == 3) {
          answer += Math.abs(next[i] - pNext);
        } else {
          int length = lrArray[0] + pNext + next[i];
          answer += Math.min(length, r - length);
        }
      } else {
        if (d[i] == 1) {
          answer += lrArray[0] - next[i] + pNext;
        } else if (d[i] == 2) {
          answer += lrArray[1] - pNext + lrArray[0] - next[i];
        } else if (d[i] == 3) {
          int length = lrArray[0] + pNext + next[i];
          answer += Math.min(length, r - length);
        } else {
          answer += Math.abs(next[i] - pNext);
        }
      }
    }
    System.out.println(answer);
  }
}
