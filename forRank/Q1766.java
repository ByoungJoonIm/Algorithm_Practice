package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1766 {
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int inDegree[] = new int[N + 1];
		ArrayList<Integer> al[] = new ArrayList[N + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 1; i <= N; i++)
			al[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			inDegree[B]++;
			al[A].add(B);
		}

		for (int i = 1; i <= N; i++) {
			if(inDegree[i] == 0)
				pq.add(i);
		}
		
		while(!pq.isEmpty()){
			int cur = pq.poll();
			
			for (int i = 0; i < al[cur].size(); i++) {
				if(--inDegree[al[cur].get(i)] == 0){
					pq.add(al[cur].get(i));
				}
			}
			
			bw.write(cur + " ");
		}
		bw.write("\n");
		
		br.close();
		bw.close();
	}
}
