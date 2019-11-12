package mathmatics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KaingCalendar {
	private static int getResult(int M, int N, int x, int y){
		int targetX = (y - 1) % M + 1;
		int distance = N - M;
		
		for (int i = 0; i < M; i++) {
			if(targetX == x)
				return i * N + y;
			targetX += distance;
			targetX = (targetX - 1) % M + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int rs;
			
			if(N >= M)
				rs = getResult(M, N, x, y);
			else
				rs = getResult(N, M, y, x);
			bw.write(rs + "\n");
		}
		br.close();
		bw.close();
	}

}
