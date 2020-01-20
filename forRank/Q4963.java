package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q4963 {
	private static boolean map[][];
	private static int rowAdder[] = {0, 1, 0, -1, 1, -1, 1, -1};
	private static int colAdder[] = {1, 0, -1, 0, 1, -1, -1, 1};
	private static int w;
	private static int h;
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	private static int getCount(){
		int cnt = 0;
		boolean visited[][] = new boolean[w][h];
		
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if(!visited[i][j] && map[i][j]){
					dfs(new Point(i, j), visited);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	private static void dfs(Point p, boolean visited[][]){
		visited[p.row][p.col] = true;
		
		for (int i = 0; i < 8; i++) {
			int nextRow = p.row + rowAdder[i];
			int nextCol = p.col + colAdder[i];
			
			if(nextRow >= 0 && nextCol >= 0 && nextRow < w && nextCol < h){
				if(!visited[nextRow][nextCol] && map[nextRow][nextCol])
					dfs(new Point(nextRow, nextCol), visited);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)
				break;
			
			map = new boolean[w][h];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if(Integer.parseInt(st.nextToken()) == 1)
						map[j][i] = true;
				}
			}
			bw.write(String.format("%d\n", getCount()));
		}
		
		br.close();
		bw.close();
	}
}
