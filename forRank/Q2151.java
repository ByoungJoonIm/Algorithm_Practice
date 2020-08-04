package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2151 {
	private static final char WALL = '*';
	private static final char POSSIBLE = '!';
	private static final char EMPTY = '.';
	private static final char DOOR = '#';
	
	private static final int rowAdder[] = {0, 0, 1, -1};	//동서남북
	private static final int colAdder[] = {1, -1, 0, 0};
	
	private static int N;
	private static char map[][];
	
	private static int getResult(int start[]){
		Queue<int[]> queue = new LinkedList<int[]>();
		int minMirror = Integer.MAX_VALUE;
		int visited[][][] = new int[N + 2][N + 2][rowAdder.length];		//더 작아질때만 업데이트
		
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				for (int k = 0; k < visited[0][0].length; k++) {
					visited[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		for (int i = 0; i < rowAdder.length; i++){
			int nextRow = start[0] + rowAdder[i];
			int nextCol = start[1] + colAdder[i];
			
			if(map[nextRow][nextCol] != WALL){
				queue.add(new int[] {nextRow, nextCol, i, 0});	//행, 열, 방향, 거울 수
			}
		}
		
		while(!queue.isEmpty()){
			int size = queue.size();	
			
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				
				if(map[cur[0]][cur[1]] == DOOR && !(cur[0] == start[0] && cur[1] == start[1])){
					minMirror = Math.min(minMirror, cur[3]);
				} else if(map[cur[0]][cur[1]] == EMPTY){
					int nextRow = cur[0] + rowAdder[cur[2]];
					int nextCol = cur[1] + colAdder[cur[2]];
					
					if(map[nextRow][nextCol] != WALL){
						queue.add(new int[] {nextRow, nextCol, cur[2], cur[3]});
					}
				} else if(map[cur[0]][cur[1]] == POSSIBLE){
					int exceptDirection = (cur[2] % 2 == 0) ? cur[2] + 1 : cur[2] - 1;
					for (int j = 0; j < rowAdder.length; j++) {
						if(j == exceptDirection)
							continue;
						
						int nextRow = cur[0] + rowAdder[j];
						int nextCol = cur[1] + colAdder[j];
						
						if(map[nextRow][nextCol] != WALL){
							int nextMirror = (j == cur[2]) ? cur[3] : cur[3] + 1;
							
							if(visited[nextRow][nextCol][j] > nextMirror){	//같은 경로로 들어가면 더 거울 값일때만 탐색
								visited[nextRow][nextCol][j] = nextMirror;
								queue.add(new int[] {nextRow, nextCol, j, nextMirror});
							}
						}
					}
				}
			}
		}
		
		return minMirror;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new char[N + 2][N + 2];
		
		int start[] = null;
		
		//boundary 셋팅
		Arrays.fill(map[0], WALL);
		Arrays.fill(map[N + 1], WALL);
		for (int i = 1; i <= N; i++) {
			map[i][0] = WALL;
			map[i][N + 1] = WALL;
		}
		
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = line.charAt(j - 1);
				
				if(map[i][j] == DOOR){
					if(start == null)
						start = (new int[] {i, j});
				}
			}
		}
		
		bw.write(getResult(start) + "\n");
		
		br.close();
		bw.close();
	}
}
