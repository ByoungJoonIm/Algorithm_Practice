package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11403 {
	private static boolean result[][];
	private static boolean isConnected[][];
	private static int n;
	
	private static class Node{
		int start;
		int end;
		
		public Node(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	private static void fillResult(){
		result = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(new Node(i, j), i);
			}
		}
	}
	
	private static void dfs(Node node, int start){
		if(isConnected[node.start][node.end]){
			result[start][node.end] = true;

			if(node.end == start)
				return;
			
			for (int i = 0; i < n; i++) {
				if(isConnected[node.end][i]){
					result[start][i] = true;
					if(start != i)
						dfs(new Node(node.end, i), start);
				}
					
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		isConnected = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					isConnected[i][j] = true;
			}
		}
		
		fillResult();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(result[i][j])
					bw.write("1 ");
				else
					bw.write("0 ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
