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
	private static int N;
	private static int M;
	private static BufferedWriter bw;
	
	private static void print(int depth, int[] arr, boolean visited[]) throws IOException{
		if(depth == M){
			for (int i = 0; i < M; i++)
				bw.write(arr[i] + " ");
			bw.write("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]){
				arr[depth] = i;
				visited[i] = true;
				print(depth + 1, arr, visited);
				visited[i] = false;	
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		print(0, new int[N], new boolean[N + 1]);
		
		br.close();
		bw.close();
	}
}
