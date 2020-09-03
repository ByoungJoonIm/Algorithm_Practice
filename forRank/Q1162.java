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

public class Q1162 {
	private static final long MAX_VALUE = 20000000000L;
	
	private static int N, M, K;
	private static ArrayList<Node> edges[];
	
	private static class Node implements Comparable<Node>{
		int v;	//목표점
		long w;	//가중치
		int c;	//도로 포장 횟수
		
		public Node(int e, long w, int c) {
			this.v = e;
			this.w = w;
			this.c = c;
		}

		@Override
		public int compareTo(Node node){
			long dist = this.w - node.w;
			
			if(dist == 0)
				return 0;
			else if(dist > 0)
				return 1;
			return -1;
		}
	}
	
	private static long dijkstra(){
		long dist[][] = new long[K + 1][N + 1];
		long minValue = Long.MAX_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for (int i = 0; i <= K; i++) {
			Arrays.fill(dist[i], MAX_VALUE);
		}
		
		dist[0][1] = 0;
		pq.add(new Node(1, 0, 0));
		
		while(!pq.isEmpty()){
			Node cur = pq.poll();
			int s = cur.v;
			int c = cur.c;
			
			for(Node node : edges[s]){
				if(dist[c][node.v] > dist[c][s] + node.w){
					dist[c][node.v] = dist[c][s] + node.w;
					pq.add(new Node(node.v, dist[c][node.v], c));
				}
				
				if(c + 1 <= K){
					if(dist[c + 1][node.v] > dist[c][s]){
						dist[c + 1][node.v] = dist[c][s];
						pq.add(new Node(node.v, dist[c + 1][node.v], c + 1));
					}
				}
			}
		}

		for (int k = 0; k <= K; k++) 
			minValue = Math.min(minValue, dist[k][N]);
		
		return minValue;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Node>();
		}		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long w = Integer.parseInt(st.nextToken());
			
			edges[s].add(new Node(e, w, 0));
			edges[e].add(new Node(s, w, 0));
		}
		
		bw.write(dijkstra() + "\n");
		
		br.close();
		bw.close();
	}
}
