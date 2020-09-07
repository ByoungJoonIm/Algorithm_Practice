package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10819 {
	private static int maxValue;
	private static int N;
	private static int arr[];
	
	private static void dfs(int depth, int sum, int prevValue, boolean visited[]){
		if(depth == N){
			maxValue = Math.max(maxValue, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(!visited[i]){
				visited[i] = true;
				if(depth > 0){
					dfs(depth + 1, sum + Math.abs(prevValue - arr[i]), arr[i], visited);
				} else
					dfs(depth + 1, 0, arr[i], visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0, new boolean[N]);
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();
	}
}
