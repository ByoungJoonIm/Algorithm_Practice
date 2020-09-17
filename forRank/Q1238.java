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

import javax.swing.JInternalFrame;

public class Q1238 {
	private static final int MAX_VALUE = 100000000;
	private static int N, M, X;
	
	private static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w){
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node node){
			return this.w - node.w;
		}
	}
	
	private static void dijkstra(int dist[], ArrayList<Node> edge[]){
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		Arrays.fill(dist, MAX_VALUE);
		dist[X] = 0;
		pq.add(new Node(X, 0));
		
		while(!pq.isEmpty()){
			Node cur = pq.poll();
			
			for(Node node : edge[cur.v]){
				if(dist[node.v] > dist[cur.v] + node.w){
					dist[node.v] = dist[cur.v] + node.w;
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
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		ArrayList<Node> enterEdge[] = new ArrayList[N + 1];
		ArrayList<Node> exitEdge[] = new ArrayList[N + 1];
		int enterDist[] = new int[N + 1];
		int exitDist[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			enterEdge[i] = new ArrayList<Node>();
			exitEdge[i] = new ArrayList<Node>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			enterEdge[e].add(new Node(s, w));	//¿ª¹æÇâ
			exitEdge[s].add(new Node(e, w));
		}
		
		int maxValue = Integer.MIN_VALUE;

		dijkstra(enterDist, enterEdge);
		dijkstra(exitDist, exitEdge);
		
		for (int i = 1; i <= N; i++)
			maxValue = Math.max(maxValue, enterDist[i] + exitDist[i]);
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();
	}
}
