package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13460 {
	private static final int RED = 0;
	private static final int BLUE = 1;
	
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static class Pair{
		Point balls[];
		
		public Pair(Pair pair){
			this();
			balls[RED] = new Point(pair.balls[RED]);
			balls[BLUE] = new Point(pair.balls[BLUE]);
		}
		
		public Pair(){
			balls = new Point[2];
		}
		
		@Override
		public boolean equals(Object obj){
			Pair pair = (Pair)obj;
			return this.balls[RED].equals(pair.balls[RED]) && this.balls[BLUE].equals(pair.balls[BLUE]);
		}
	}
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
		
		public Point(Point point){
			this(point.row, point.col);
		}
		
		@Override
		public boolean equals(Object obj){
			Point point = (Point)obj;
			return this.row == point.row && this.col == point.col;
		}
	}
	
	private static void move(boolean map[][], Pair pair, int color, Point hole, int direction){
		if(pair.balls[color].equals(hole))
			return;
		
		Point curPoint = pair.balls[color];
		Point nextPoint = new Point(curPoint.row + rowAdder[direction], curPoint.col + colAdder[direction]);
		
		if(nextPoint.equals(hole)){
			pair.balls[color] = new Point(nextPoint);
		} else if(!nextPoint.equals(pair.balls[Math.abs(color - 1)])){
			if(map[nextPoint.row][nextPoint.col]){
				pair.balls[color] = new Point(nextPoint);
				move(map, pair, color, hole, direction);
			}
		}
	}

	private static int bfs(boolean map[][], Pair start, Point hole){
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(start);
		
		int counter = 1;
		
		while(!queue.isEmpty() && counter < 11){
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Pair cur = queue.poll();
				
				for (int j = 0; j < 4; j++) {
					Pair newPair = new Pair(cur);
					for (int k = 0; k < 2; k++) {
						move(map, newPair, RED, hole, j);
						move(map, newPair, BLUE, hole, j);	
					}
					
					if(!newPair.balls[BLUE].equals(hole)){
						if(newPair.balls[RED].equals(hole))
							return counter;
						if(!newPair.equals(cur))
							queue.add(newPair);
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean map[][] = new boolean[N][M];
		Pair start = new Pair();
		Point hole = new Point(0,0);

		//inputs
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char cur = line.charAt(j);
				
				if(cur == '.'){
					map[i][j] = true;
				} else if(cur == 'O'){
					hole = new Point(i, j);
					map[i][j] = true;
				} else if(cur == 'R'){
					start.balls[RED] = new Point(i, j);
					map[i][j] = true;
				} else if(cur == 'B'){
					start.balls[BLUE] = new Point(i, j);
					map[i][j] = true;
				}
			}
		}
		
		//algorithm
		int result = bfs(map, start, hole);
		bw.write(result + "\n");
		
		br.close();
		bw.close();
	}
}
