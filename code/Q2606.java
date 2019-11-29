package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2606 {
	private static int cnt;
	private static int N;
	private static int E;
	private static ArrayList<Integer> edges[];
	private static boolean visited[];
	
	private static void dfs(int dest){
		if(!visited[dest]){
			visited[dest] = true;
			cnt++;
			for (int i = 0; i < edges[dest].size(); i++) {
				dfs(edges[dest].get(i));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		edges = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			edges[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[u].add(v);
			edges[v].add(u);
		}
		
		dfs(1);
		bw.write((cnt - 1) + "\n");
		
		br.close();
		bw.close();
	}
}
