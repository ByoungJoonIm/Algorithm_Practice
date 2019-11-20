package shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Graph{
	int dest;
	int weight;
	
	public Graph(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object obj){
		Graph otherG = (Graph)obj;
		if(otherG.dest == this.dest)
			return true;
		return false;
	}
}

public class Dijkstra {
	public static void main(String[] args) throws IOException {
		final int MAXVALUE = 10000000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Short.parseShort(st.nextToken());	//vertex
		int E = Integer.parseInt(st.nextToken());	//edge
		int U = Short.parseShort(br.readLine());	//start
		
		ArrayList<Graph> weights[] = new ArrayList[V + 1];
		int dist[] = new int[V + 1];
		boolean isFixed[] = new boolean[V + 1];		//S
		
		
		for (int i = 1; i <= V; i++){
			weights[i] = new ArrayList<Graph>();
			dist[i] = MAXVALUE;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Byte.parseByte(st.nextToken());
			
			Graph newG = new Graph(v, w);
			int index = weights[u].indexOf(newG);
			if(index > -1){
				if(weights[u].get(index).weight > newG.weight)
					weights[u].set(index, newG);
			} else
				weights[u].add(new Graph(v, w));	
		}
		
		//init values
		dist[U] = 0;
		isFixed[U] = true;
		
		for (int i = 0; i < weights[U].size(); i++){
			dist[weights[U].get(i).dest] = weights[U].get(i).weight;
		}
		
		/*
		 * dijkstra
		 * */
		for (int i = 0; i < V - 1; i++) {
//			select next
			int minDist = MAXVALUE + 1;
			int minV = 0;
			for (int j = 1; j <= V; j++) {
				if(!isFixed[j]){
					if(minDist > dist[j]){
						minDist = dist[j];
						minV = j;
					}
				}
			}
			U = minV;
			isFixed[U] = true;
			
			//dist °è»ê
			for (int j = 0; j < weights[U].size(); j++) {
				int dest = weights[U].get(j).dest;
				if(!isFixed[dest]){
					dist[dest] = Math.min(dist[dest], dist[U] + weights[U].get(j).weight);
				}
			}
		}
		
		//output
		for (int i = 1; i <= V; i++) {
			if(dist[i] == 0)
				bw.write("0\n" );
			else if(dist[i] == MAXVALUE)
				bw.write("INF\n");
			else
				bw.write(dist[i] + "\n");
		}
		
		br.close();
		bw.close();
	}
}
