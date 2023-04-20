import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static String[][]graph;
    static int row,col, answer;
    static int[] dirR = {-1,1,0,0};
    static int[] dirC = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new String[m + 1][n+1];
        visited = new boolean[m + 1][n+1];
        col = n;
        row = m;
        for (int i = 1; i <= m; i++) {
            int index = 1;
            for(String s : br.readLine().trim().split(("")))
                graph[i][index++] = s;
        }
        int[] result = new int[2];
        //System.out.println(Arrays.deepToString(graph));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j].equals("W") && !visited[i][j]){
                    answer=0;
                    dfs(i,j,true);
                    result[0] += answer*answer;
                }
                if(graph[i][j].equals("B") && !visited[i][j]){
                    answer=0;
                    dfs(i,j,false);
                    result[1] += answer*answer;
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }

    public static void dfs(int y, int x, boolean flag) {
        visited[y][x] = true;
        answer++;
        String s = flag?"W" : "B";
        //System.out.println(answer);
        for (int i = 0; i < 4; i++) {
            int nowX = x + dirC[i];
            int nowY = y + dirR[i];
            if(nowX <=0 || nowX >col || nowY <=0 || nowY > row)continue;
            else if(graph[nowY][nowX] !=null&&graph[nowY][nowX].equals(s) && !visited[nowY][nowX]){
                dfs(nowY, nowX, flag);
            }
        }

    }


}