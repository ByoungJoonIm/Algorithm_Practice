package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5212 {
	private static final char FIELD = 'X';
	private static final char OCEAN = '.';
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[R][C];
		Queue<Point> queue = new LinkedList<Point>();
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j) == FIELD)
					map[i][j] = true;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int counter = 0;
				
				for (int k = 0; k < rowAdder.length; k++) {
					int nextRow = i + rowAdder[k];
					int nextCol = j + colAdder[k];
					
					if(nextRow >= 0 && nextCol >= 0 && nextRow < R && nextCol < C){
						if(map[nextRow][nextCol])
							continue;
					}
					counter++;
				}
				if(counter >= 3)
					queue.add(new Point(i, j));
			}
		}
		
		while(!queue.isEmpty()){
			Point point = queue.poll();
			map[point.row][point.col] = false;
		}
		
		int up = Integer.MAX_VALUE;
		int down = -1;
		int left = Integer.MAX_VALUE;
		int right = -1;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]){
					up = Math.min(up, i);
					down = i;
					left = Math.min(left, j);
					right = Math.max(right, j);
					
				}
			}
		}
		
		for (int i = up; i <= down; i++) {
			for (int j = left; j <= right; j++) {
				if(map[i][j])
					bw.write(FIELD);
				else
					bw.write(OCEAN);
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
