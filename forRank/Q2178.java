package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	private static boolean visited[][];
	private static boolean map[][];
	private static int n;
	private static int m;
	private static int counter = 0;
	private static int rowAdder[] = {1, 0, -1, 0};
	private static int colAdder[] = {0, 1, 0, -1};
	
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	private static int bfs(){
		Queue<Point> queue = new LinkedList<Point>();
		visited = new boolean[n][m];
		
		queue.add(new Point(0, 0));
		
		while(!queue.isEmpty()){
			int size = queue.size();
			counter++;
			
			for (int i = 0; i < size; i++) {
				Point cur = queue.poll();
				if(!visited[cur.row][cur.col]){
					visited[cur.row][cur.col] = true;
					
					if(cur.row == n - 1 && cur.col == m - 1)
						return counter;
					
					for (int j = 0; j < 4; j++) {
						int nextRow = cur.row + rowAdder[j];
						int nextCol = cur.col + colAdder[j];
						
						if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m){
							if(map[nextRow][nextCol] && !visited[nextRow][nextCol])
								queue.add(new Point(nextRow, nextCol));
						}
					}
				}
			}
		}
		
		return counter;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if(str.charAt(j) == '1')
					map[i][j] = true;
			}
		}
		
		bw.write(bfs() + "\n");
		
		br.close();
		bw.close();
	}
}
