package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1504 {
	private static final int INF = 100000000;
	
	private static ArrayList<Node> edges[];
	private static int N, E;
	private static int v1, v2;
	
	private static class Node implements Comparable<Node>{
		public int v;
		public int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node edge){
			return this.w - edge.w;
		}
	}

	private static int getResult(){
		int dist[][] = new int[3][N + 1];
		int result = INF;
		
		dijkstra(1, dist[0]);
		dijkstra(v1, dist[1]);
		dijkstra(v2, dist[2]);
		
		// 1 -> 2 -> 3 -> N
		result = Math.min(result, dist[0][v1] + dist[1][v2] + dist[2][N]);
		
		// 1 -> 3 -> 2 -> N
		result = Math.min(result, dist[0][v2] + dist[2][v1] + dist[1][N]);
		
		if(result == INF)
			return -1;
		return result;
	}
	
	private static void dijkstra(int start, int dist[]){
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()){
			int curV = pq.poll().v;
			
			for(Node node : edges[curV]){
				if(dist[node.v] > dist[curV] + node.w){
					dist[node.v] = dist[curV] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges[s].add(new Node(e, w));
			edges[e].add(new Node(s, w));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		bw.write(getResult() + "\n");
		
		br.close();
		bw.close();
	}
}
