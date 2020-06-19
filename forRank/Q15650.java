package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15650 {
	private static int N, M;
	
	private static void dfs(int index, int depth, boolean visited[]){
		if(depth == M){
			System.out.println(getArrayString(visited));
			return;
		}
		
		for (int i = index; i <= N; i++) {
			visited[i - 1] = true;
			dfs(i + 1, depth + 1, visited);
			visited[i - 1] = false;
		}
	}
	
	private static String getArrayString(boolean visited[]){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]){
				sb.append((i + 1) + " ");
			}
		}
		
		return sb.substring(0, sb.length() - 1).toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(1, 0, new boolean[N]);
		
		br.close();
		bw.close();
	}
}
