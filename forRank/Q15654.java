package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {
	private static int N, M;
	private static int selected[];
	private static int numbers[];
	private static StringBuilder sb;
	
	private static void dfs(int depth, boolean visited[]){
		if(depth == M){
			for (int i = 0; i < M - 1; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append(selected[M - 1]).append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++){
			if(!visited[i]){
				visited[i] = true;
				selected[depth] = numbers[i];
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
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		dfs(0, new boolean[N]);
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
