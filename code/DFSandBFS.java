package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
	int value;
	ArrayList<Integer> links;
	
	public Node(int value){
		this.value = value;
		links = new ArrayList<Integer>();
	}
}

public class DFAandBFS {
	static BufferedWriter bw;
	public static void dfs(Node nodes[], int V) throws Exception{
		boolean visited[] = new boolean[nodes.length];
		Stack<Node> stack = new Stack<Node>();
		
		stack.add(nodes[V]);
		
		while(!stack.isEmpty()){
			Node temp = stack.pop();
			if(!visited[temp.value]){
				visited[temp.value] = true;
				bw.write(temp.value + " ");
				
				for (int i = temp.links.size() - 1; i >= 0; i--) {
					if(!visited[temp.links.get(i)])
						stack.add(nodes[temp.links.get(i)]);
				}
			}
		}
		bw.write("\n");
	}
	
	public static void bfs(Node nodes[], int V) throws Exception{
		boolean visited[] = new boolean[nodes.length];
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(nodes[V]);
		
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			if(!visited[temp.value]){
				visited[temp.value] = true;
				bw.write(temp.value + " ");
				
				for (int i = 0; i < temp.links.size(); i++) {
					if(!visited[temp.links.get(i)])
						queue.add(nodes[temp.links.get(i)]);
				}
			}
		}
		bw.write("\n");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Node nodes[] = new Node[N + 1];
		for (int i = 1; i <= N; i++)
			nodes[i] = new Node(i);
			
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes[start].links.add(end);
			nodes[end].links.add(start);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(nodes[i].links);
		}
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dfs(nodes, V);
		bfs(nodes, V);
		bw.close();
	}
}
