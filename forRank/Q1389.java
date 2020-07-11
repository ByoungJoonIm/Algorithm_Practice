package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1389 {
	private static int N, M;
	private static ArrayList<Integer> relation[];
	private static int minV;
	private static int minValue;
	
	private static int getValue(int s){
		int sum = 0;
		boolean visited[] = new boolean[N + 1];
		visited[s] = true;

		int dist = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for (int j = 0; j < size; j++) {
				int cur = queue.poll();
				sum += dist;
				
				for (int k = 0; k < relation[cur].size(); k++) {
					if(!visited[relation[cur].get(k)]){
						visited[relation[cur].get(k)] = true;
						queue.add(relation[cur].get(k));
					}
				}
			}
			dist++;
		}

		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//inputs
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		relation = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<Integer>();
		}
		
		HashSet<String> existSet = new HashSet<String>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(!existSet.contains(s + " " + e)){
				existSet.add(s + " " + e);
				existSet.add(e + " " + s);
				
				relation[s].add(e);
				relation[e].add(s);
			}
		}
		
		//bfs
		int minV = 1;
		int minSum = Integer.MAX_VALUE;
		
		
		for (int i = 1; i <= N; i++) {
			int curSum = getValue(i);
			
			if(minSum > curSum){
				minSum = curSum;
				minV = i;
			}
		}
		
		bw.write(minV + "\n");
		
		br.close();
		bw.close();
	}
}
