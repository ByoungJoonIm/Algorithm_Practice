//cheolyeing_j님 코드를 참고하여 개선

package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11403 {
	private static boolean result[][];
	private static boolean isConnected[][];
	private static int n;
	private static boolean visited[];
	
	private static void solve(){
		result = new boolean[n][n];
		for (int i = 0; i < n; i++) {	//n번만 dfs 실행
			visited = new boolean[n];	
			dfs(i);
			result[i] = visited;
		}
	}
	
	private static void dfs(int start){
		for (int i = 0; i < n; i++) {
			if(isConnected[start][i] && !visited[i]){
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		isConnected = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					isConnected[i][j] = true;
			}
		}
		
		solve();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(result[i][j])
					bw.write("1 ");
				else
					bw.write("0 ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
