package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236 {
	private static final int rowAdder[] = {-1, 0, 0, 1};
	private static final int colAdder[] = {0, -1, 1, 0};
	
	private static int N;
	private static int map[][];
	private static Shark shark;
	
	private static class Point implements Comparable<Point>{
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public boolean isValid(boolean visited[][]){
			if(row >= 0 && col >= 0 && row < N && col < N && !visited[row][col])
				return true;
			return false;
		}
		
		@Override
		public int compareTo(Point point){
			if(this.row == point.row){
				return this.col - point.col;
			}
			return this.row - point.row;
		}
	}
	
	private static class Shark{
		Point point;
		int size;
		int sizeCounter;

		public Shark(Point point) {
			this.size = 2;
			this.sizeCounter = 2;
			this.point = point;
		}
		
		public void eat(Point point){
			map[point.row][point.col] = 0;
			sizeCounter--;
			
			if(sizeCounter == 0){
				size++;
				sizeCounter = size;
			}
			
			this.point = point;	//상어 이동
		}
	}

	private static int move(){
		int dist = 1;
		boolean visited[][] = new boolean[N][N];
		visited[shark.point.row][shark.point.col] = true;
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(shark.point);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			PriorityQueue<Point> candidate = new PriorityQueue<Point>();
			
			for (int i = 0; i < size; i++){
				Point cur = queue.poll();
				
				for (int j = 0; j < rowAdder.length; j++) {
					Point next = new Point(cur.row + rowAdder[j], cur.col + colAdder[j]);
					if(next.isValid(visited)){
						if(map[next.row][next.col] == shark.size || map[next.row][next.col] == 0){	//지나가는 경우
							visited[next.row][next.col] = true;
							queue.add(next);
						} else if(map[next.row][next.col] < shark.size){	//먹을 수 있는 경우
							candidate.add(next);
						} 
						//못지나가는 경우는 pass
					}
				}
			}

			if(!candidate.isEmpty()){
				shark.eat(candidate.poll());
				return dist;
			}
			dist++;
		}
		
		return -1;
	}

	private static int getTime(){
		int time = 0;
		
		while(true){
			int resultMove = move();
			
			if(resultMove < 0)
				return time;
			time += resultMove;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				
				if(value == 9)
					shark = new Shark(new Point(i, j));
				else if(value > 0)
					map[i][j] = value;
			}
		}
		
		bw.write(getTime() + "\n");
		
		br.close();
		bw.close();
	}
}
