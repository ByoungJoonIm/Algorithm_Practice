package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static class Point{
		int row;
		int col;
		boolean canBreakWall;
		
		public Point(int row, int col, boolean canBreakWall){
			this.row = row;
			this.col = col;
			this.canBreakWall = canBreakWall;
		}
	}

	private static int bfs(int M, int N, boolean map[][]){
		if(M == 1 && N == 1)
			return 1;
		
		boolean visited[][][] = new boolean[2][M + 2][N + 2];
		
		for (int i = 0; i < 2; i++) {
			Arrays.fill(visited[i][0], true);
			Arrays.fill(visited[i][M + 1], true);
			
			for (int j = 1; j <= M; j++) {
				visited[i][j][0] = true;
				visited[i][j][N + 1] = true;
			}
			
		}
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(1, 1, true));
		int counter = 2;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Point cur = queue.poll();
				
				int flag = cur.canBreakWall ? 0 : 1;
				
				for (int j = 0; j < rowAdder.length; j++) {
					int nextRow = cur.row + rowAdder[j];
					int nextCol = cur.col + colAdder[j];
					
					if(nextRow == M && nextCol == N)
						return counter;
					
					if(!visited[flag][nextRow][nextCol]){
						if(map[nextRow][nextCol]){
							visited[flag][nextRow][nextCol] = true;
							queue.add(new Point(nextRow, nextCol, cur.canBreakWall));
						} else {
							if(cur.canBreakWall){
								visited[flag][nextRow][nextCol] = true;
								queue.add(new Point(nextRow, nextCol, false));
							}
						}
					}
				}
				
			}
			counter++;
		}

		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean map[][] = new boolean[M + 2][N + 2];
		for (int i = 1; i <= M; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++)
				map[i][j] = line.charAt(j - 1) == '0';
		}
				
		int result = bfs(M, N, map);
		
		bw.write(result + "\n");
		
		br.close();
		bw.close();
	}
}
