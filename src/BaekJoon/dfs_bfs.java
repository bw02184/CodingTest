import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static boolean[][] graph;
    static int N;
    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int vertex = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());
        visited = new boolean[node + 1];
        graph = new boolean[node + 1][node + 1];
        N = node;
        for (int i = 0; i < vertex; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }
        dfs(first);

    }

    public static void dfs(int index) {
        if(visited[index])
            return;
        else{
            visited[index] = true;
            System.out.print(index + " ");
            for (int i = 1; i <= N; i++) {
                if (graph[index][i] && !visited[i]) {

                    dfs(i);
                }
            }
        }
    }

}