package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15683 {
	private static final int EMPTY = 0;
	private static final int WALL = 6;
	private static final int WATCHED = 7;
	
	private static int N;
	private static int M;
	private static int originMap[][];
	private static int minScore = Integer.MAX_VALUE;
	
	private static class CCTV{
		int row;
		int col;
		int type;
		
		public CCTV(int row, int col, int type) {
			this.row = row;
			this.col = col;
			this.type = type;
		}
		
		public void mark(int map[][], int direction){
			switch(type){
			case 1:
				markLine(map, direction);
				break;
			case 2:
				markLine(map, direction);
				markLine(map, (direction + 2) % 4);
				break;
			case 3:
				markLine(map, direction);
				markLine(map, (direction + 1) % 4);
				break;
			case 4:
				markLine(map, direction);
				markLine(map, (direction + 1) % 4);
				markLine(map, (direction + 3) % 4);
				break;
			case 5:
				markLine(map, direction);
				markLine(map, (direction + 1) % 4);
				markLine(map, (direction + 2) % 4);
				markLine(map, (direction + 3) % 4);
				break;
			}
		}
		
		private void markLine(int map[][], int direction){
			if(direction == 0){
				for (int i = row - 1; i >= 0; i--) {
					if(map[i][col] == EMPTY)
						map[i][col] = WATCHED;
					else if(map[i][col] == WALL)
						break;
				}
			} else if(direction == 1){
				for (int i = col + 1; i < M; i++) {
					if(map[row][i] == EMPTY)
						map[row][i] = WATCHED;
					else if(map[row][i] == WALL)
						break;
				}
			} else if(direction == 2){
				for (int i = row + 1; i < N; i++) {
					if(map[i][col] == EMPTY)
						map[i][col] = WATCHED;
					else if(map[i][col] == WALL)
						break;
				}
			} else if(direction == 3){
				for (int i = col - 1; i >= 0; i--) {
					if(map[row][i] == EMPTY)
						map[row][i] = WATCHED;
					else if(map[row][i] == WALL)
						break;
				}
			}
		}
	}
	
	private static int getMapScore(int map[][]){
		int score = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					score++;
			}
		}
		
		return score;
	}
	
	private static int[][] copyMap(int map[][]){
		int copiedMap[][] = new int[N][M];
		
		for (int i = 0; i < N; i++)
			copiedMap[i] = map[i].clone();
		
		return copiedMap;
	}
	
	private static void solve(int depth, int map[][], ArrayList<CCTV> cctvs){
		if(depth == cctvs.size()){
			minScore = Math.min(minScore, getMapScore(map));
			return;
		}
		
		CCTV curCCTV = cctvs.get(depth);
		for (int i = 0; i < 4; i++) {
			int copiedMap[][] = copyMap(map);
			curCCTV.mark(copiedMap, i);
			solve(depth + 1, copiedMap, cctvs);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		originMap = new int[N][M];
		
		ArrayList<CCTV> cctvs = new ArrayList<CCTV>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
				if(originMap[i][j] < WALL && originMap[i][j] > 0)
					cctvs.add(new CCTV(i, j, originMap[i][j]));
			}
		}
		
		solve(0, originMap, cctvs);
		
		bw.write(minScore + "\n");
		
		br.close();
		bw.close();
	}
}
