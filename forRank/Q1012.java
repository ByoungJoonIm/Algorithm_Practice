package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1012 {
	private static boolean visited[][];
	private static boolean isExist[][];
	private static int M;
	private static int N;
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	private static int getNumber(){
		int counter = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(isExist[i][j] && !visited[i][j]){
					counter++;
					dfs(new Point(i, j));
				}
			}
		}
		return counter;
	}
	
	private static void dfs(Point point){
		if(!visited[point.row][point.col]){
			visited[point.row][point.col] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextRow = point.row + rowAdder[i];
				int nextCol = point.col + colAdder[i];
				
				if(nextRow >= 0 && nextCol >= 0 && nextRow < M && nextCol < N){
					if(!visited[nextRow][nextCol] && isExist[nextRow][nextCol])
						dfs(new Point(nextRow, nextCol));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			/*
			 * inputs
			 * */
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			visited = new boolean[M][N];
			isExist = new boolean[M][N];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				isExist[row][col] = true;
			}
			
			bw.write(getNumber() + "\n");
		}
		
		br.close();
		bw.close();
	}
}
