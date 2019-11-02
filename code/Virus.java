package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class VirusNode{
	int value;
	ArrayList<Integer> links;
	
	public VirusNode(int value){
		this.value = value;
		links = new ArrayList<Integer>();
	}
}

public class Virus {
	public static int depthFS(VirusNode nodes[], int N){
		int count = 0;
		Stack<VirusNode> stack = new Stack<VirusNode>();
		boolean visited[] = new boolean[N + 1];
		
		stack.add(nodes[1]);
		while(!stack.isEmpty()){
			VirusNode temp = stack.pop();
			if(!visited[temp.value]){
				visited[temp.value] = true;
				count++;
				for (int i = 0; i < temp.links.size(); i++) {
					int next = temp.links.get(i);
					if(!visited[next])
						stack.add(nodes[next]);
				}
			}
		}
		
		return count - 1;
	}
	
	public static int bfs(VirusNode nodes[], int N){
		int count = 0;
		Queue<VirusNode> queue = new LinkedList<VirusNode>();
		boolean visited[] = new boolean[N + 1];
		
		queue.add(nodes[1]);
		while(!queue.isEmpty()){
			VirusNode temp = queue.poll();
			if(!visited[temp.value]){
				visited[temp.value] = true;
				count++;
				for (int i = 0; i < temp.links.size(); i++) {
					int next = temp.links.get(i);
					if(!visited[next])
						queue.add(nodes[next]);
				}
			}
		}
		return count - 1;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//the number of computers
		int M = Integer.parseInt(br.readLine());	//the number of links
		StringTokenizer st;
		
		VirusNode nodes[] = new VirusNode[N + 1];
		for (int i = 1; i <= N; i++)
			nodes[i] = new VirusNode(i);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes[start].links.add(end);
			nodes[end].links.add(start);
		}
		
		System.out.println(bfs(nodes,N));
	}
}
