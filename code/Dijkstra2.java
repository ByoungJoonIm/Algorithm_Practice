/*
 * 이 코드는 itstt님 코드를 참고하여 기존 코드를 개선한 코드입니다.
 * */

package shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra2 {
	static final int INF = 1000000000;
	static class Node implements Comparable<Node>{
		int index;
		int weight;
		
		public Node(int index, int distance){
			this.index = index;
			this.weight = distance;
		}
		
		@Override
		public int compareTo(Node node){
			return this.weight - node.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<List<Node>> list = new ArrayList<List<Node>>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(br.readLine());
		int dist[] = new int[V + 1];
		
		//init
		Arrays.fill(dist, INF);
		for (int i = 0; i <= V; i++)
			list.add(new ArrayList<Node>());
		
		//inputs
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Node(v, w));
		}
		
		//dijkstra algorithm
		dist[U] = 0;
		pq.add(new Node(U, 0));
		
		while(!pq.isEmpty()){
			int curIndex = pq.poll().index;
			
			for(Node node : list.get(curIndex)){
				if(dist[node.index] > dist[curIndex] + node.weight ){
					dist[node.index] = dist[curIndex] + node.weight;
					pq.add(new Node(node.index, dist[node.index]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] == INF)
				bw.write("INF\n");
			else
				bw.write(dist[i] + "\n");
		}
		
		br.close();
		bw.close();
	}
}