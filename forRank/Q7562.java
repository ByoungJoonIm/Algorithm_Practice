package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {
	private static final int rowAdder[] = {2, 2, -2, -2, 1, 1, -1, -1};
	private static final int colAdder[] = {1, -1, 1, -1, 2, -2, 2, -2};
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
		
		@Override
		public boolean equals(Object obj){
			return this.row == ((Point)obj).row && this.col == ((Point)obj).col;
		}
	}
	
	private static int bfs(Point origin, Point destination, int l){
		if(origin.equals(destination))
			return 0;
		
		int counter = 0;
		boolean visited[][] = new boolean[l][l];
		visited[origin.row][origin.col] = true;
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(origin);
		
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point cur = queue.poll();
				
				for (int j = 0; j < rowAdder.length; j++) {
					int nextRow = cur.row + rowAdder[j];
					int nextCol = cur.col + colAdder[j];
					
					if(nextRow >= 0 && nextCol >= 0 && nextRow < l && nextCol < l){
						if(!visited[nextRow][nextCol]){
							visited[nextRow][nextCol] = true;
							Point next = new Point(nextRow, nextCol);
							if(next.equals(destination))
								return counter + 1;
							queue.add(next);
						}
					}
				}
			}
			counter++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int l = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Point destination = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			bw.write(bfs(cur, destination, l) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
