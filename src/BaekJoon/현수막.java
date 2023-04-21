import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][]graph;
    static int n,m;
    static int answer;
    static int[] dirY = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dirX = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n+1][m+1];
        for (int i = 0; i < n; i++) {
            int index=0;
            for(String number : br.readLine().trim().split(" ")){
                graph[i][index++] = Integer.parseInt(number);
            }
        }
        //System.out.println(Arrays.deepToString(graph));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);

    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int nowY = y + dirY[i];
            int nowX = x + dirX[i];
            if(nowX <0 || nowX >= m || nowY <0 || nowY>=n)
                return;
            if(graph[nowY][nowX] == 1 && !visited[nowY][nowX]) {
                dfs(nowY, nowX);
            }
        }
    }
}


