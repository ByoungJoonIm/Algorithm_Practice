package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class SafeCoord{
	byte row;
	byte col;

	public SafeCoord(byte row, byte col) {
		this.row = row;
		this.col = col;
	}
}

public class SafeZone {
	private static byte N;
	private static byte map[][];
	private static byte maxHeight = 1;
	
	private static void visit(Stack<SafeCoord> stack, boolean visited[][], SafeCoord next, byte height){
		byte row = next.row;
		byte col = next.col;
		
		if(row >= 0 && col >= 0 && row < N && col < N){
			if(!visited[row][col] && map[row][col] > height){
				visited[row][col] = true;
				stack.add(next);
			}
		}
	}
	
	private static void dfs(boolean visited[][], SafeCoord safeCoord, byte height){
		Stack<SafeCoord> stack = new Stack<SafeCoord>();
		
		stack.add(safeCoord);
		visited[safeCoord.row][safeCoord.col] = true;
		
		while(!stack.isEmpty()){
			SafeCoord temp = stack.pop();
			visit(stack, visited, new SafeCoord((byte)(temp.row + 1), temp.col), height);
			visit(stack, visited, new SafeCoord(temp.row , (byte)(temp.col + 1)), height);
			visit(stack, visited, new SafeCoord((byte)(temp.row - 1), temp.col), height);
			visit(stack, visited, new SafeCoord(temp.row , (byte)(temp.col - 1)), height);
		}
	}

	/*
	 * return the number of area when the rain height is specific.
	 * */
	private static int getSpecificHeight(byte height){
		boolean visited[][] = new boolean[N][N];
		int counter = 0;
		
		for (byte i = 0; i < N; i++) {
			for (byte j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] > height){
					dfs(visited, new SafeCoord(i, j), height);
					counter++;
				}
			}
		}
		
		return counter;
	}
	
	private static int getMaxSafeZone(){
		int maxSafeZone = 0;
		for (byte i = 0; i < maxHeight; i++) {
			int safeZoneCounter = getSpecificHeight(i);
			maxSafeZone = (safeZoneCounter > maxSafeZone) ? safeZoneCounter : maxSafeZone;
		}
		return maxSafeZone;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Byte.parseByte(br.readLine());
		map = new byte[N][N];
		
		for( byte i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (byte j = 0; j < N; j++){
				map[i][j] = Byte.parseByte(st.nextToken());
				maxHeight = (map[i][j] > maxHeight) ? map[i][j] : maxHeight;
			}
		}
		
		System.out.println(getMaxSafeZone());
	}
}
