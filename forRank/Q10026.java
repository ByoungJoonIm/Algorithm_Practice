package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10026 {
	private static final int R = 0;
	private static final int G = 1;
	private static final int B = 2;

	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static void dfs(int n, int map[][], boolean visited[][], int row, int col, int curColor){
		visited[row][col] = true;
		
		for (int i = 0; i < rowAdder.length; i++) {
			int nextRow = row + rowAdder[i];
			int nextCol = col + colAdder[i];
			
			if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n){
				if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == curColor){
					dfs(n, map, visited, nextRow, nextCol, curColor);
				}
			}
		}
	}
	
	private static int getCaseCounter(int n, int map[][]){
		int counter = 0;
		boolean visited[][] = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]){
					counter++;
					dfs(n, map, visited, i, j, map[i][j]);
				}
			}
		}
		
		return counter;
	}
	
	private static String solve(int n, int map[][]){
		String result = "";
		
		//for normal case
		result += getCaseCounter(n, map) + " ";
		
		//make G to R
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == G)
					map[i][j] = R;
			}
		}
		
		//for special case
		result += getCaseCounter(n, map);
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				char color = line.charAt(j);
				
				if(color == 'R')
					map[i][j] = R;
				else if(color == 'G')
					map[i][j] = G;
				else if(color == 'B')
					map[i][j] = B;
			}
		}
		
		bw.write(solve(n, map) + "\n");
		
		br.close();
		bw.close();
	}
}
