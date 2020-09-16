package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1167 {
	private static ArrayList<Node> rel[];
	private static int V;
	private static boolean visited[];
	
	private static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int e, int w){
			this.v = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node node){
			return this.w - node.w;
		}
	}

	private static int getFarV(int s){
		boolean visited[] = new boolean[V + 1];
		visited[s] = true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(s, 0));
		int maxValue = 0;
		int maxV = 1;
		
		while(!queue.isEmpty()){
			Node cur = queue.poll();
			
			for(Node node: rel[cur.v]){
				if(!visited[node.v]){
					visited[node.v] = true;
					queue.add(new Node(node.v, cur.w + node.w));
					
					if(cur.w + node.w > maxValue){
						maxValue = cur.w + node.w;
						maxV = node.v;
					}
				} 
			}
		}
		
		return maxV;
	}
	
	private static int dfs(int e){
		visited[e] = true;

		int maxValue = 0;
		for (int i = 0; i < rel[e].size(); i++) {
			Node node = rel[e].get(i);
			
			if(!visited[node.v]){
				maxValue = Math.max(maxValue, dfs(node.v) + node.w);
			}
		}
		
		return maxValue;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		V = Integer.parseInt(br.readLine());
		rel = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		int startNode = 1;
		
		for(int i = 1; i <= V; i++)
			rel[i] = new ArrayList<Node>();
		
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());	
			int e;
			int w;
			
			while( (e = Integer.parseInt(st.nextToken())) != -1){
				w = Integer.parseInt(st.nextToken());
				rel[v].add(new Node(e, w));
			}
		}

		//임의의 정점에서 제일 먼 정점에서의 최장거리
		bw.write(dfs(getFarV(startNode)) + "\n");
		
		br.close();
		bw.close();
	}
}
