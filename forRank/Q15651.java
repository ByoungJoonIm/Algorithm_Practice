package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q15651 {
	private static int N, M;
	private static int selected[];
	
	private static BufferedWriter bw;
	
	private static void dfs(int depth) throws IOException{
		if(depth == M){
			bw.write(getArrayString() + "\n");
			return;
		}
		
		for(int i = 1; i <= N; i++){
			selected[depth] = i;
			dfs(depth + 1);
		}
	}
	
	private static String getArrayString(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++){
			sb.append(selected[i] + " ");
		}
		
		return sb.substring(0, sb.length() - 1).toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		
		dfs(0);
				
		br.close();
		bw.close();
	}
}
