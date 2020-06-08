	package forRank;
	
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class Q17142 {
		private static final int rowAdder[] = {0, 1, 0, -1};
		private static final int colAdder[] = {1, 0, -1, 0};
		private static final int EMPTY = 0;
		private static final int WALL = 1;
		
		private static int N, M;
		private static int map[][];
		private static Point virus[];
		private static int emptyCounter = 0;
		private static int virusCounter = 0;
		private static int minTime = Integer.MAX_VALUE;
		
		private static class Point{
			int row;
			int col;
	
			public Point(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}
		
		private static int getTime(int virusIndex[]){
			int counter = emptyCounter;
			
			if(emptyCounter == 0)
				return 0;
			
			int time = 0;
			
			Queue<Point> queue = new LinkedList<Point>();
			boolean visited[][] = new boolean[N][N];
			
			for (int i = 0; i < M; i++){
				Point curVirus = virus[virusIndex[i]];
				queue.add(curVirus);
				visited[curVirus.row][curVirus.col] = true;
			}
	
			while(!queue.isEmpty()){
				int size = queue.size();
				
				time++;
				
				for (int i = 0; i < size; i++) {
					Point curVirus = queue.poll();
					
					for (int j = 0; j < rowAdder.length; j++) {
						int nextRow = curVirus.row + rowAdder[j];
						int nextCol = curVirus.col + colAdder[j];
						
						if(nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N){
							if(!visited[nextRow][nextCol]){
								if(map[nextRow][nextCol] == WALL)
									continue;
								if(map[nextRow][nextCol] == EMPTY)
									counter--;
								
								if(counter == 0)
									return time;
								
								visited[nextRow][nextCol] = true;
								queue.add(new Point(nextRow, nextCol));
							}
						}
					}
				}
			}
			
			return Integer.MAX_VALUE;
		}
		
		private static void combination(int depth, int index, int virusIndex[]){
			if(depth == M){
				minTime = Math.min(minTime, getTime(virusIndex));
				return;
			}
			
			for (int i = index + 1; i < virusCounter; i++) {
				virusIndex[depth] = i;
				combination(depth + 1, i, virusIndex);
			}
			
		}
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
			//inputs
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
	
			Queue<Point> virusQueue = new LinkedList<Point>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 2)
						virusQueue.add(new Point(i, j));
					if(map[i][j] == 0)
						emptyCounter++;
				}
			}
			
			virusCounter = virusQueue.size();
			virus = new Point[virusCounter];
			for (int i = 0; i < virusCounter; i++)
				virus[i] = virusQueue.poll();
			
			//algorithm
			combination(0, -1, new int[M]);
			
			if(minTime == Integer.MAX_VALUE)
				minTime = -1;
			
			bw.write(minTime + "\n");
			
			br.close();
			bw.close();
		}
	}
