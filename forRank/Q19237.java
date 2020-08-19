package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q19237 {
	//위, 아래, 좌, 우
	private static final int MAX_TIME = 1000;
	
	private static final int rowAdder[] = {-1, 1, 0, 0};
	private static final int colAdder[] = {0, 0, -1, 1};
	
	private static int N, M, K;
	private static ArrayList<Shark> sharks;
	private static Map map[][];
	
	private static class Map{
		int smellTime;
		int smellOwner;
	}
	
	private static class Shark implements Comparable<Shark>{
		int row;
		int col;
		int number;
		int direction;
		int priority[][];
		
		public Shark(int row, int col, int number){
			this.row = row;
			this.col = col;
			this.number = number;
			priority = new int[4][4];
		}
		
		@Override
		public int compareTo(Shark shark){
			return this.number - shark.number;
		}
		
		@Override
		public String toString(){
			return "[" + number + "(" + direction + ")]" + row + "," + col;
		}
	}
	
	private static boolean isRightBoundary(int row, int col){
		return row >= 0 && row < N && col >= 0 && col < N;
	}
	
	private static void smellStamp(int curTime){
		for(Shark s : sharks){
			map[s.row][s.col].smellOwner = s.number;
			map[s.row][s.col].smellTime = curTime;
		}
	}
	
	private static void move(int curTime){
		//다음 위치를 모두 잡은다음 한번에 이동함
		int sharkMap[][] = new int[N][N];
		ArrayList<int[]> nextSharkPos = new ArrayList<int[]>();
		
		for(int sIndex = 0; sIndex < sharks.size(); sIndex++){
			Shark s = sharks.get(sIndex);
			int backDirection = -1;	//-1 초과값을 가지면 돌아가야함
			
			//새로운 빈자리를 찾음
			for (int i = 0; i < 4; i++) {
				int nextDirection = s.priority[s.direction][i];
				int nextRow = s.row + rowAdder[nextDirection];
				int nextCol = s.col + colAdder[nextDirection];
				
				if(isRightBoundary(nextRow, nextCol)){
					if(map[nextRow][nextCol].smellOwner == 0 || curTime - map[nextRow][nextCol].smellTime >= K){
						if(sharkMap[nextRow][nextCol] == 0){
							sharkMap[nextRow][nextCol] = s.number;
							nextSharkPos.add(new int[] {nextRow, nextCol, nextDirection});
						} else {
							sharks.remove(sIndex--);
						}
						backDirection = -1;
						break;
					}
					if(map[nextRow][nextCol].smellOwner == s.number && backDirection == -1)
						backDirection = nextDirection;
				}
			}
			
			//자신의 냄새 방향으로 돌아감
			if(backDirection > -1){
				int nextRow = s.row + rowAdder[backDirection];
				int nextCol = s.col + colAdder[backDirection];
				
				if(sharkMap[nextRow][nextCol] == 0){
					sharkMap[nextRow][nextCol] = s.number;
					nextSharkPos.add(new int[] {nextRow, nextCol, backDirection});
				} else {
					sharks.remove(s);
				}
			}
		}
		
		//shark들의 좌표를 업데이트함
		for (int i = 0; i < sharks.size(); i++) {
			Shark s = sharks.get(i);
			
			s.row = nextSharkPos.get(i)[0];
			s.col = nextSharkPos.get(i)[1];
			s.direction = nextSharkPos.get(i)[2];
		}
	}
	
	private static void oneStep(int curTime){
		smellStamp(curTime);
		move(curTime);
	}
	
	private static int getTime(){
		for(int t = 0; t <= MAX_TIME; t++){
			if(sharks.size() == 1)
				return t;
			
			oneStep(t);
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Map[N][N];
		sharks = new ArrayList<Shark>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Map();
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int sharkNum = Integer.parseInt(st.nextToken());
				
				if(sharkNum > 0)
					sharks.add(new Shark(i, j, sharkNum));
			}
		}
		
		Collections.sort(sharks);
		st = new StringTokenizer(br.readLine());
		for(Shark s : sharks)
			s.direction = Integer.parseInt(st.nextToken()) - 1;
		
		for(Shark s : sharks){
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					s.priority[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		
		bw.write(getTime() + "\n");
		
		br.close();
		bw.close();
	}
}
