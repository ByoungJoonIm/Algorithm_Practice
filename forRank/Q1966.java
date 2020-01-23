package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {
	private static class Node implements Comparable<Node>{
		int priority;
		boolean isTarget;
		
		public Node(int priority){
			this.priority = priority;
			isTarget = false;
		}
		
		@Override
		public int compareTo(Node node){
			return node.priority - priority;
		}
	}
	
	private static int getCount(Queue<Node> queue, PriorityQueue<Node> pq){
		int counter = 1;
		while(!queue.isEmpty()){
			Node cur = queue.poll();
			Node highest = pq.poll();
			
			if(highest.priority == cur.priority){
				if(cur.isTarget)
					return counter;
			} else {
				queue.add(cur);
				while(true){
					cur = queue.poll();
					if(cur.priority == highest.priority){
						if(cur.isTarget)
							return counter;
						break;
					}
					queue.add(cur);
				}
			}
			counter++;
		}
		
		return counter;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Node> queue = new LinkedList<Node>();
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Node newNode = new Node(Integer.parseInt(st.nextToken()));
				if(j == M)
					newNode.isTarget = true;
				queue.add(newNode);
				pq.add(newNode);
			}
			bw.write(getCount(queue, pq) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
