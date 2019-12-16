package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2458 {
	private static int N;
	private static int M;
	private static boolean connection[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connection = new boolean[N + 1][N + 1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int source = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			connection[source][dest] = true;
		}
		
		//algorithm
		for (int m = 1; m <= N; m++) {			//중간 정점
			for (int e = 1; e <= N; e++) {		//종료 정점
				for (int s = 1; s <= N; s++) {	//시작 정점
					if(connection[s][m] && connection[m][e])
						connection[s][e] = true;
				}
			}
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			boolean isConnected = true;
			for (int j = 1; j <= N; j++) {
				if(i != j){
					if(!(connection[i][j] || connection[j][i])){
						isConnected = false;
						break;
					}
				}
			}
			if(isConnected)
				count++;
		}
		
		bw.write(count + "\n");
		
		br.close();
		bw.close();
	}
}
