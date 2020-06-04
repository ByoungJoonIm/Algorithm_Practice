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

public class Q3190 {
	private static final int EAST = 0;
	private static final int SOUTH = 1;
	private static final int WEST = 2;
	private static final int NORTH = 3;
	
	private static final int WALL = -1;
	private static final int EMPTY = 0;
	private static final int BAAAM = 1;
	private static final int APPLE = 2;
	
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	private static class Point{
		int direction;
		int row;
		int col;
		
		public Point(int direction, int row, int col) {
			this.direction = direction;
			this.row = row;
			this.col = col;
		}
		
		public Point(Point point){
			this(point.direction, point.row, point.col);
		}

		@Override
		public boolean equals(Object obj) {
			Point point = (Point)obj;
			return this.row == point.row && this.col == point.col;
		}
		
		public void move(){
			this.row += rowAdder[this.direction];
			this.col += colAdder[this.direction];
		}
		
		public void changeDirection(char c){
			if(c == 'D')
				this.direction = (this.direction + 1) % 4;
			if(c == 'L')
				this.direction = (this.direction + 3) % 4;
		}
	}
	
	private static void printMap(int map[][]){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int getTime() throws IOException{
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int map[][] = new int[N + 2][N + 2];
		
		//init map
		Arrays.fill(map[0], WALL);
		Arrays.fill(map[N + 1], WALL);
		
		for (int i = 1; i <= N; i++) {
			map[i][0] = WALL;
			map[i][N + 1] = WALL;
		}
		
		//algorithm
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = APPLE;
		}
		
		int curveCounter = Integer.parseInt(br.readLine());
		Point head = new Point(EAST, 1, 1);
		Point tail = new Point(EAST, 1, 1);
		Queue<Point> curve = new LinkedList<Point>();
		int time = 0;
		map[head.row][head.col] = BAAAM;
		
		for (int i = 0; i <= curveCounter; i++) {
			StringTokenizer st;
			int steps = 0;
			char changer = ' ';
			
			if(i == curveCounter){
				steps = 10101;
			} else {
				st = new StringTokenizer(br.readLine());
				steps = Integer.parseInt(st.nextToken());
				changer = st.nextToken().charAt(0);
			}
			
			for (int j = time; j < steps; j++) {
				System.out.println("time : " + time);
				printMap(map);
				
				time++;
				head.move();

				if(map[head.row][head.col] == WALL || map[head.row][head.col] == BAAAM){	//finish
					return time;
				} else if(map[head.row][head.col] == EMPTY){
					map[tail.row][tail.col] = EMPTY;
					if(!curve.isEmpty()){
						if(tail.equals(curve.peek())){
							tail = new Point(curve.poll());
							System.out.println(tail.direction);
						}
					}
					tail.move();
				}
				map[head.row][head.col] = BAAAM;
			}
			
			head.changeDirection(changer);
			curve.add(new Point(head));
		}
		return time;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(getTime() + "\n");
				
		br.close();
		bw.close();
	}
}
