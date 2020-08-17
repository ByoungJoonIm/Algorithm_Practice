package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q18352 {
	private static int N, M, K, X;
	private static ArrayList<Integer> links[];
	
	private static String getResult(){
		int dist = 0;
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N + 1];
		queue.add(X);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			if(K == dist){
				while(!queue.isEmpty()){
					int cur = queue.poll();
					
					if(!visited[cur]){
						visited[cur] = true;
						result.add(cur);
					}
				}
				Collections.sort(result);
				break;
			} 
			
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();

				visited[cur] = true;
				
				for(int next : links[cur]){
					if(!visited[next])
						queue.add(next);
				}
			}
			dist++;
		}

		for(int i : result)
			sb.append(i).append('\n');
		
		if(sb.length() == 0)
			return "-1\n";
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		links = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			links[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			links[s].add(e);
		}

		bw.write(getResult());
		
		br.close();
		bw.close();
	}
}
