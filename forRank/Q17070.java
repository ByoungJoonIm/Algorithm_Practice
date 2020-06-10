package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17070 {
	private static boolean map[][];
	private static int countMap[][][];
	private static int N;
	
	private static final int HORIZONTAL = 0;
	private static final int VERTICAL = 1;
	private static final int DIAGONAL = 2;
	
	private static int getCount(){
		countMap[HORIZONTAL][1][2] = 1;

		//1За
		for (int i = 3; i <= N; i++) {
			if(map[1][i])
				countMap[HORIZONTAL][1][i] = countMap[HORIZONTAL][1][i - 1];
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				if(map[i][j]){
					if(map[i][j - 1] && map[i - 1][j])
						countMap[DIAGONAL][i][j] += (countMap[DIAGONAL][i - 1][j - 1] + countMap[HORIZONTAL][i - 1][j - 1] + countMap[VERTICAL][i - 1][j - 1]);
					
					countMap[VERTICAL][i][j] += (countMap[DIAGONAL][i - 1][j] + countMap[VERTICAL][i - 1][j]);
					countMap[HORIZONTAL][i][j] += (countMap[DIAGONAL][i][j - 1] + countMap[HORIZONTAL][i][j - 1]);
				}
			}
		}
		
		return countMap[DIAGONAL][N][N] + countMap[HORIZONTAL][N][N] + countMap[VERTICAL][N][N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new boolean[N + 1][N + 1];
		countMap = new int[3][N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken()) == 0;
		}
		
		bw.write(getCount() + "\n");
		
		br.close();
		bw.close();
	}
}
