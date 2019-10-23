package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node{
	int value;
	ArrayList<Node> links = null;
	
	public Node(int value){
		this.value = value;
		if(links == null)
			links = new ArrayList<Node>();
	}
}

public class Travel {
	static Scanner scan = new Scanner(System.in);
	
	private static void solution(){
		Node countries[];
		int N = scan.nextInt();
		int M = scan.nextInt();
		Queue<Node> queue = new LinkedList<Node>();
		boolean visited[] = new boolean[N + 1];		//initial values are false
		
		countries = new Node[N + 1];
		for (int i = 1; i < N + 1; i++)
			countries[i] = new Node(i);
		
		for (int i = 0; i < M; i++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			countries[a].links.add(countries[b]);
			countries[b].links.add(countries[a]);
		}
			
		//BFS
		queue.add(countries[1]);
		int cnt = -1;
		
		while(!queue.isEmpty()){
			Node cur = queue.poll();
			if(visited[cur.value])
				continue;
			visited[cur.value] = true;
			cnt++;
			for (int i = 0; i < cur.links.size(); i++) {
				Node temp = cur.links.get(i);
				if(!visited[temp.value])
					queue.add(temp);
			}
		}
		
		System.out.println(cnt);
	}
	
	/*
	 * This is a trick.
	 * */
	private static void solution2(){
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		for (int i = 0; i < M; i++){
			scan.nextInt();
			scan.nextInt();
		}
		
		System.out.println(N - 1);
	}
	
	
	/*
	public static void main(String[] args){
		int T = scan.nextInt();
		
		for (int i = 0; i < T; i++)
			solution2();
		
		scan.close();
	}
	*/
	
	//solution3
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++)
				br.readLine();
			bw.write((N - 1) + "\n");	
		}
		br.close();		
		bw.close();
	}

}
