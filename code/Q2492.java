package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2492 {
	private static class Point{
		int x;
		int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static Point points[];
	private static int N, M, T, K;
	
	private static int count(int squareX, int squareY){
		int cnt = 0;
		
		for (int i = 0; i < T; i++) {
			if(points[i].x <= squareX + K && points[i].x >= squareX
					&& points[i].y <= squareY && points[i].y >= squareY - K)
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//MAX X
		M = Integer.parseInt(st.nextToken());	//MAX Y
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		points = new Point[N];
		int max = 0;
		Point square = new Point(0, 0);
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T; j++) {
				int candX, candY;
				
				candX = (points[i].x <= N - K) ? points[i].x : N - K;	//CandX = Math.min(points[i].x, N - K);
				candY = (points[j].y - K >= 0) ? points[j].y : K;

				int rs = count(candX, candY);
				if(rs > max){
					max = rs;
					square = new Point(candX, candY);
				}
			}
		}
		
		bw.write(square.x + " " + square.y + "\n" + max + "\n");
		
		br.close();
		bw.close();
	}
}