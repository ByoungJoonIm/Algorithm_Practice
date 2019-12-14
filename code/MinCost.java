package shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinCost {
	private static final int INF = 1000000001;
	private static int map[][];
	private static int dist[];
	
	private static class Node implements Comparable<Node>{
		int source;
		
		public Node(int source){
			this.source = source;
		}
		
		@Override
		public int compareTo(Node node){
			return dist[source] - dist[node.source];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		dist = new int[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		Arrays.fill(dist, INF);
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				map[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[s][d] = Math.min(map[s][d], w);
		}
		
		st = new StringTokenizer(br.readLine());
		int source = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
		dist[source] = 0;
		pq.add(new Node(source));
		
		while(!pq.isEmpty()){
			Node curNode = pq.poll();
			if(curNode.source == dest)
				break;
			
			for(int i = 1; i <= N; i++){
				if(map[curNode.source][i] < INF){
					if(dist[i] > dist[curNode.source] + map[curNode.source][i]){
						dist[i] = dist[curNode.source] + map[curNode.source][i];
						pq.add(new Node(i));
					}
				}
			}
		}
		
		bw.write(dist[dest] + "\n");
		
		br.close();
		bw.close();
	}
}
