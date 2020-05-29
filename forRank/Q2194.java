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

public class Q2194 {
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static final int RIGHT = 0;
	private static final int UP = 1;
	private static final int LEFT = 2;
	private static final int DOWN = 3;
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
		
		@Override
		public boolean equals(Object obj){
			Point point = (Point)obj;
			return this.row == point.row && this.col == point.col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Point> queue = new LinkedList<Point>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());	//row Size
		int B = Integer.parseInt(st.nextToken());	//col Size
		int K = Integer.parseInt(st.nextToken());
		
		boolean map[][] = new boolean[N + 2][M + 2];
		boolean visited[][] = new boolean[N + 2][M + 2];
		
		for (int i = 1; i <= N; i++)
			Arrays.fill(map[i], true);
		
		for (int i = 1; i <= N ; i++) {
			map[i][0] = false;
			map[i][M + 1] = false;
		}
		
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = false;
		}
		
		st = new StringTokenizer(br.readLine());
		Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		
		//algorithm
		int step = 0;
		
		visited[start.row][start.col] = true;
		queue.add(start);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Point cur = queue.poll();
				
				for (int j = 0; j < rowAdder.length; j++) {
					int nextRow = cur.row + rowAdder[j];
					int nextCol = cur.col + colAdder[j];
					
					//맵 범위 체크
					if( nextRow >= 1 && nextCol >= 1 && nextRow + A - 1 < N + 1 && nextCol + B - 1 < M + 1){
						//장애물 체크
						boolean isValid = true;
						
						switch(j){
						case UP:
							for (int k = 0; k < A && isValid; k++) {
								if(!map[nextRow][nextCol + k])
									isValid = false;
							}
							break;
						case DOWN:
							for (int k = 0; k < A && isValid; k++) {
								if(!map[nextRow + B - 1][nextCol + k])
									isValid = false;
							}
							break;
						case LEFT:
							for (int k = 0; k < B && isValid; k++) {
								if(!map[nextRow + B - 1][nextCol + k])
									isValid = false;
							}
							break;
						case RIGHT:
							break;
						}
					}
				}
				
			}
			step++;
		}
		
		br.close();
		bw.close();
	}
}
