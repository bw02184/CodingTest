import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static boolean[][] graph;
    static int node;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        graph = new boolean[node + 1][node + 1];
        visited = new boolean[node + 1];
        answer = new int[node];
        for (int i = 0; i < node - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }
        dfs(1);
        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static void dfs(int index) {
        visited[index] = true;
        for (int i = 1; i <= node; i++) {
            if(graph[index][i] && !visited[i]){
                answer[i-1]=index;
                dfs(i);
            }
        }
    }


}