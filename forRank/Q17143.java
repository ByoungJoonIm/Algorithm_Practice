package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q17143 {
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int RIGHT = 3;
	private static final int LEFT = 4;
	
	private static int R, C, M;
	private static Shark sharks[];
	private static int sharkIndexMap[][];
	
	private static class Shark{
		int row;
		int col;
		int vectorRow;
		int vectorCol;
		int speed;
		boolean isRowDirection;
		boolean isLive;
		int size;
		private static int counter = 0;
		
		public Shark(String line) {
			StringTokenizer st = new StringTokenizer(line);
			row = Integer.parseInt(st.nextToken()) - 1;
			col = Integer.parseInt(st.nextToken()) - 1;
			speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			size = Integer.parseInt(st.nextToken());
			
			if(direction > 2)
				isRowDirection = true;

			vectorRow = row;
			vectorCol = col;
			
			if(direction == UP && row != 0)
				vectorRow = 2 * (R - 1) - row;
			if(direction == LEFT && col != 0)
				vectorCol = 2 * (C - 1) - col;
			
			if(direction == UP || direction == DOWN){
				speed %= ((R - 1) * 2);
			} else {
				speed %= ((C - 1) * 2);
			}
			
			isLive = true;
			sharkIndexMap[row][col] = ++counter;
		}
		
		public void move(){
			if(isRowDirection){
				int unit = C - 1;
				
				vectorCol = (vectorCol + speed) % (2 * unit);
				
				if(vectorCol > unit)
					col = 2 * unit - vectorCol;
				else
					col = vectorCol;
			} else {
				int unit = R - 1;
				
				vectorRow = (vectorRow + speed) % (2 * unit);
				
				if(vectorRow > unit)
					row = 2 * unit - vectorRow;
				else
					row = vectorRow;
			}
		}
		
		public boolean bigger(Shark shark){
			if(this.size > shark.size)
				return true;
			return false;
		}
		
		public void printShark(){
			System.out.println("--------------------------");
			System.out.println(String.format("row : %d(%d)\ncol : %d(%d)", row, vectorRow, col, vectorCol));
		}
	}
	
	private static int fishing(int curCol){
		for (int i = 0; i < R; i++) {
			if (sharkIndexMap[i][curCol] > 0){
				sharks[sharkIndexMap[i][curCol]].isLive = false;
				return sharks[sharkIndexMap[i][curCol]].size;
			}
		}
		return 0;
	}
	
	private static void moveAllShark(){
		int tempIndexMap[][] = new int[R][C];
		
		for (int i = 1; i <= M; i++) {
			Shark curShark = sharks[i];
			if(curShark.isLive){
				curShark.move();
				if(tempIndexMap[curShark.row][curShark.col] == 0)
					tempIndexMap[curShark.row][curShark.col] = i;
				else {
					Shark prevShark = sharks[tempIndexMap[curShark.row][curShark.col]];
					
					if(curShark.bigger(prevShark)){
						tempIndexMap[curShark.row][curShark.col] = i;
						prevShark.isLive = false;
					} else {
						curShark.isLive = false;
					}
				}
			}
		}
		
		sharkIndexMap = tempIndexMap;
	}
	
	public static int getTotalSize(){
		int totalSize = 0;
		for (int i = 0; i < C; i++) {
			totalSize += fishing(i);
			moveAllShark();
		}
		
		return totalSize;
	}
	
	public static void test(int sharkIndex){
		System.out.println("size : " + sharks[sharkIndex].size);
		System.out.println("speed : " + sharks[sharkIndex].speed);
		
		for (int i = 0; i < 5; i++) {
			sharks[sharkIndex].printShark();
			sharks[sharkIndex].move();
		}
		sharks[sharkIndex].printShark();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sharks = new Shark[M + 1];
		sharkIndexMap = new int[R][C];
		
		for (int i = 1; i <= M; i++) {
			sharks[i] = new Shark(br.readLine());
		}

		bw.write(getTotalSize() + "\n");
		
		br.close();
		bw.close();
	}
}
