package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q15649 {
	private static int N, M;
	private static StringBuilder sb;
	private static int selected[];
	
	private static void dfs(int depth, boolean visited[]){
		if(depth == M){
			for (int i = 0; i < M - 1; i++)
				sb.append(selected[i]).append(' ');
			sb.append(selected[M - 1]).append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]){
				selected[depth] = i + 1;
				visited[i] = true;
				dfs(depth + 1, visited);
				visited[i] = false;	
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		
		dfs(0, new boolean[N]);
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
