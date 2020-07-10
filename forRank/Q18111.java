package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		int fieldSum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				fieldSum += map[i][j];
			}
		}
		
		int fitHeight = (fieldSum + B) / (N * M);
		int minTime = Integer.MAX_VALUE;
		int resultHeight = fitHeight;
		
		for (int h = fitHeight; h >= 0; h--) {	//높이를 낮추며 모두 계산. 최적화는 안돼있음
			int time = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > h)
						time += (map[i][j] - h) * 2;
					else if(map[i][j] < h)
						time += (h - map[i][j]);
				}
			}	
			if(time < minTime){
				minTime = time;
				resultHeight = h;
			}
		}
		
		bw.write(minTime + " " + resultHeight + "\n");
		
		br.close();
		bw.close();
	}
}
