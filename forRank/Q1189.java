package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1189 {
	private static final int rowAdder[] = {0, 0, 1, -1};
	private static final int colAdder[] = {1, -1, 0, 0};
	private static final char WALL = 'T';

	private static int counter = 0;
	private static char map[][];
	private static int R, C, K;
	
	private static void dfs(int depth, int row, int col, boolean visited[][]){
		if(row == 1 && col == C && depth == K)
			counter++;
		
		if(depth >= K)
			return;
		
		for (int i = 0; i < rowAdder.length; i++) {
			int nextRow = row + rowAdder[i];
			int nextCol = col + colAdder[i];
			
			if(map[nextRow][nextCol] != WALL){
				if(!visited[nextRow][nextCol]){
					visited[nextRow][nextCol] = true;
					dfs(depth + 1, nextRow, nextCol, visited);
					visited[nextRow][nextCol] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//start : R, 1
		//end : 1, C
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R + 2][C + 2];
		Arrays.fill(map[0], WALL);
		Arrays.fill(map[R + 1], WALL);
		for (int i = 1; i <= R; i++) {
			map[i][0] = WALL;
			map[i][C + 1] = WALL;
		}
		
		for (int i = 1; i <= R; i++) {
			String line = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
		
		boolean visited[][] = new boolean[R + 2][C + 2];
		visited[R][1] = true;
		
		dfs(1, R, 1, visited);
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
