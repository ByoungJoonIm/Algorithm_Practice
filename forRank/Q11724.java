package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724 {
	private static boolean visited[];
	private static int N;
	private static ArrayList<Integer> map[];
	private static int counter = 0;
	
	private static void solve(){
		for (int i = 1; i <= N; i++) {
			if(!visited[i]){
				counter++;
				if(map[i].size() > 0)
					dfs(i);
			}
		}
	}
	
	private static void dfs(int v){
		if(!visited[v]){
			visited[v] = true;
			for (int i = 0; i < map[v].size(); i++) {
				int next = map[v].get(i);
				if(!visited[next])
					dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//정점의 수
		int M = Integer.parseInt(st.nextToken());	//간선의 수
		visited = new boolean[N + 1];
		map = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			map[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start].add(end);
			map[end].add(start);
		}
			
		solve();
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
