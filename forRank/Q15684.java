package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15684 {
	private static final int CANNOT_PUT = -1;
	private static final int CAN_PUT = 0;
	private static final int EXIST = 1;
	
	private static int N;
	private static int H;
	private static int M;
	private static int map[][];
	private static int minValue = 4;
	
	private static void printMap(){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void solve(int depth, int rowIndex, int colIndex){
		if(depth < minValue){
			if(check())
				minValue = Math.min(minValue, depth);
			for (int i = rowIndex; i < H; i++) {
				for (int j = rowIndex == i ? colIndex : 1; j < N; j++) {
					if(isCanPut(i, j)){
						setBridge(i, j);
						solve(depth + 1, i, j + 2);
						unSetBridge(i, j);
					}
				}
			}
		}
	}
	
	private static boolean isCanPut(int row, int col){
		return map[row][col] == CAN_PUT && map[row][col - 1] != EXIST && map[row][col + 1] != EXIST;
	}
	
	private static void setBridge(int row, int col){
		map[row][col] = EXIST;
	}
	
	private static void unSetBridge(int row, int col){
		map[row][col] = CAN_PUT;
	}

	private static boolean check(){
		for (int i = 1; i <= N; i++) {
			if(!lineCheck(i))
				return false;
		}
		return true;
	}
	
	private static boolean lineCheck(int lineNumber){
		int curLine = lineNumber;
		
		for (int i = 0; i < map.length; i++) {
			if(curLine == 1){	//오른쪽만 체크
				if(map[i][curLine] == EXIST)
					curLine++;
			} else if(curLine == N){ //왼쪽만 체크
				if(map[i][curLine - 1] == EXIST)
					curLine--;
			} else {	//좌우 모두 체크
				if(map[i][curLine] == EXIST)	//동시 발생 없음
					curLine++;
				else if(map[i][curLine - 1] == EXIST)
					curLine--;
			}	
		}
		return curLine == lineNumber;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N + 1];	//H 자리에는 인덱스가 들어감에 주의
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			setBridge(a - 1, b);
		}
		
		solve(0, 0, 1);
		
		if(minValue == 4)
			minValue = -1;
		bw.write(minValue + "\n");
		
		br.close();
		bw.close();
	}
}
