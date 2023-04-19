import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static boolean[][] graph;
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, 1, -1};

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int newY = y + dirR[i];
            int newX = x + dirC[i];
            if(graph[newY][newX] && !visited[newY][newX])
                dfs(newY,newX);
        }
    }

    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for(int tc=0;tc<testCase; tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            visited = new boolean[51][51];
            graph = new boolean[51][51];
            for (int i = 1; i <= count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y+1][x+1]  = true;
            }
            //System.out.println(Arrays.deepToString(graph));
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(graph[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }


}