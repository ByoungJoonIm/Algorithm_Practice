package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14889 {
	private static int N;
	private static int map[][];
	private static int minValue;
	private static boolean visited[];
	
	private static void getValue(int cnt, int index){
		if(cnt == N / 2){
			int startSum = 0;
			int linkSum = 0;
			int startIndex[] = new int[N / 2];
			int linkIndex[] = new int[N / 2];
			int startIndexIndex = 0;
			int linkIndexIndex = 0;
			
			for (int i = 0; i < N; i++) {
				if(visited[i])
					startIndex[startIndexIndex++] = i;
				else
					linkIndex[linkIndexIndex++] = i;
			}
			
			for (int i = 1; i < N / 2; i++) {
				for (int j = 0; j < i; j++) {
					startSum += map[startIndex[i]][startIndex[j]];
					startSum += map[startIndex[j]][startIndex[i]];
					linkSum += map[linkIndex[i]][linkIndex[j]];
					linkSum += map[linkIndex[j]][linkIndex[i]];
				}
			}
			
			minValue = Math.min(minValue, Math.abs(startSum - linkSum));
			return;
		}
		for (int i = index; i < N; i++) {
			if(!visited[i]){
				visited[i] = true;
				getValue(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		minValue = Integer.MAX_VALUE;
		
		//inputs
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		getValue(0, 0);
		bw.write(minValue + "\n");
		
		br.close();
		bw.close();
	}
}
