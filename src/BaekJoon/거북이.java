import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int d, x, y;
  static int[] dirX = {0, 1, 0, -1};
  static int[] dirY = {1, 0, -1, 0};
  static int minX, minY, maxX, maxY;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine().trim());

    for (int tc = 0; tc < testCase; tc++) {
      char[] cstr = br.readLine().trim().toCharArray();
      d = x = y = 0;
      minX = minY = maxX = maxY = 0;
      for (char ch : cstr) {
        switch (ch) {
          case 'F':
            x += dirX[d];
            y += dirY[d];
            break;
          case 'B':
            x -= dirX[d];
            y -= dirY[d];
            break;
          case 'L':
            if (d == 0) d = 3;
            else d--;
            break;
          case 'R':
            if (d == 3) d = 0;
            else d++;
            break;
        }

        maxX = Math.max(x, maxX);
        maxY = Math.max(y, maxY);
        minX = Math.min(x, minX);
        minY = Math.min(y, minY);
      }

      System.out.println(Math.abs(maxX - minX) * Math.abs(maxY - minY));
    }
  }
}
