package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14890 {
	private static int N;
	private static int L;
	private static int map[][];
	
	private static boolean canInstall(boolean bridged[], int sRow, int eRow, int sCol, int eCol, boolean isRow){
		if(sRow < 0 || sCol < 0 || eRow >= N || eCol >= N)
			return false;
		
		int value = map[sRow][sCol];
		
		if(isRow){
			for (int i = sCol; i <= eCol; i++) {
				if(bridged[i] || map[sRow][i] != value)
					return false;
			}	
		} else {
			for (int i = sRow; i <= eRow; i++) {
				if(bridged[i] || map[i][sCol] != value)
					return false;
			}
		}
		
		return true;
	}
	
	private static void install(boolean bridged[], int start, int end){
		for (int i = start; i <= end; i++)
			bridged[i] = true;
	}
	
	private static int rowCount(){
		int counter = 0;
		
		for (int i = 0; i < N; i++) {
			boolean possible = true;
			boolean bridgedRow[] = new boolean[N];
			
			for (int j = 1; j < N && possible; j++) {
				int dist = map[i][j - 1] - map[i][j];	//1 : 낮아지는 경우, -1: 높아지는 경우
				if(dist == 0)
					continue;
				if(Math.abs(dist) > 1){
					possible = false;
					break;
				}
				
				if(dist == 1){	//낮아지는 경우
					if(canInstall(bridgedRow, i, i, j, j + L - 1, true)){
						install(bridgedRow, j, j + L - 1);
					} else
						possible = false;
				} else if(dist == -1){	//높아지는 경우
					if(canInstall(bridgedRow, i, i, j - L, j - 1, true)){
						install(bridgedRow, j - L, j - 1);
					} else
						possible = false;
				}
			}
			
			if(possible){
				counter++;
			}
		}
		return counter;
	}
	
	private static int colCount(){
		int counter = 0;
		
		for (int i = 0; i < N; i++) {
			boolean possible = true;
			boolean bridgedCol[] = new boolean[N];
			
			for (int j = 1; j < N && possible; j++) {
				int dist = map[j - 1][i] - map[j][i];	//1 : 낮아지는 경우, -1: 높아지는 경우
				if(dist == 0)
					continue;
				if(Math.abs(dist) > 1){
					possible = false;
					break;
				}
				
				if(dist == 1){	//낮아지는 경우
					if(canInstall(bridgedCol, j, j + L - 1, i, i, false)){
						install(bridgedCol, j, j + L - 1);
					} else
						possible = false;
				} else if(dist == -1){	//높아지는 경우
					if(canInstall(bridgedCol, j - L, j - 1, i, i, false)){
						install(bridgedCol, j - L, j - 1);
					} else
						possible = false;
				}
			}
			
			if(possible){
				counter++;
			}
		}
		return counter;
	}
	
	private static int getCount(){
		return rowCount() + colCount();
	}
	
	private static void printBridged(boolean bridged[][]){
		for (int i = 0; i < bridged.length; i++) {
			for (int j = 0; j < bridged[0].length; j++) {
				System.out.print(bridged[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}
	
	private static void printSubBridged(boolean bridged[]){
		for (int i = 0; i < bridged.length; i++) {
			System.out.print(bridged[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(getCount() + "\n");
		
		br.close();
		bw.close();
	}
}
