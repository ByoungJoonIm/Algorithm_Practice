package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14502 {
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	private static int N;
	private static int M;
	private static int map[][];
	private static int copiedMap[][];
	private static int safeArea;
	private static int copiedSafeArea;
	private static int maxSafeArea;
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	private static void copy(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) 
				copiedMap[i][j] = map[i][j];
		}
		copiedSafeArea = safeArea - 3;	//벽 세운걸 미리 빼기
	}
	
	private static void dfs(Point point){
		for (int i = 0; i < 4; i++) {
			int nextRow = point.row + rowAdder[i];
			int nextCol = point.col + colAdder[i];
			
			if(nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < M){
				if(copiedMap[nextRow][nextCol] == 0){
					copiedMap[nextRow][nextCol] = 2;
					copiedSafeArea--;
					dfs(new Point(nextRow, nextCol));
				}
			}
		}
	}
	
	private static void spreadVirus(){
		copy();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copiedMap[i][j] == 2)
					dfs(new Point(i, j));
			}
		}
		maxSafeArea = Math.max(maxSafeArea, copiedSafeArea);
	}
	
	private static void wall(int cnt){
		if(cnt == 3){
			spreadVirus();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0){
					map[i][j] = 1;
					wall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copiedMap = new int[N][M];
		maxSafeArea = 0;
		safeArea = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					safeArea++;
			}
		}

		wall(0);
		bw.write(maxSafeArea + "\n");
		
		br.close();
		bw.close();
	}
}
