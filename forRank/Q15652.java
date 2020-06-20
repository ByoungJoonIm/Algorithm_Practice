package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15652 {
	private static int N, M;
	private static int selected[];
	private static BufferedWriter bw;
	
	private static StringBuilder sb;
	
	private static void dfs(int depth, int index) throws IOException{
		if(depth == M){
			for(int i = 0; i < M - 1; i++)
				sb.append(selected[i] + " ");
			sb.append(selected[M - 1]).append("\n");
			return;
		}
		
		for(int i = index; i <= N; i++){
			selected[depth] = i;
			dfs(depth + 1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		
		dfs(0, 1);
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
