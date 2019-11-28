/*
 * TItle : Baeckjoon 11657 타임머신
 * Reference :https://namu.wiki/w/%EB%B2%A8%EB%A8%BC-%ED%8F%AC%EB%93%9C%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98 
 * */
package shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BellmanFord {
	private static final int INF = 1000000000;

	private static class Edge{
		public int s;
		public int e;
		public int w;
		
		public Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//도시 수
		int M = Integer.parseInt(st.nextToken());	//노선 수
		int dist[] = new int[N + 1];				//dist[1]은 이미 0
		Edge edges[] = new Edge[M];
		boolean isCycle = false;
		
		for (int i = 2; i <= N; i++)
			dist[i] = INF;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(A, B, C);
		}
		
		//bellman-ford algorithm
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M; j++) {
				Edge cur = edges[j];
				if(dist[cur.s] == INF)
					continue;
				if(dist[cur.e] > dist[cur.s] + cur.w)
					dist[cur.e] = dist[cur.s] + cur.w;
			}
		}
		
		for (int i = 0; i < M; i++) {
			if(dist[edges[i].s] == INF)
				continue;
			if(dist[edges[i].e] > dist[edges[i].s] + edges[i].w){
				isCycle = true;
				break;
			}
		}
		
		if(isCycle){
			bw.write(-1 + "\n");
		} else {
			for (int i = 2; i <= N; i++) {
				if(dist[i] == INF)
					bw.write(-1 + "\n");
				else
					bw.write(dist[i] + "\n");
			}	
		}
		
		br.close();
		bw.close();
	}
}
