package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10800 {
	private static final int MAXSIZE = 2000;
	private static class Ball implements Comparable<Ball>{
		int sequence;
		int color;
		int size;
		
		public Ball(int sequence, int color, int size) {
			this.sequence = sequence;
			this.color = color;
			this.size = size;
		}
		
		@Override
		public int compareTo(Ball ball){
			if(this.size == ball.size)
				return this.color - ball.color;
			return this.size - ball.size;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball[N];
		int rs[] = new int[N];
		int sumByColor[] = new int[N + 1];
		int sum = 0;
		int beforeSize = 0;
		int beforeColor = 0;
		int sameColors = 0;
		int sameSizes = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(i, color, size);
		}
		
		Arrays.sort(balls);
		
		for (int i = 0; i < N; i++) {
			int sequence = balls[i].sequence;
			int color = balls[i].color;
			int size = balls[i].size;
			
			sum += size;
			sumByColor[color] += size;
			
			if(beforeSize == size){
				sameSizes++;
				if(beforeColor == color){
					rs[sequence] = sum - sumByColor[color] - sameSizes * size + ++sameColors * size;	
				} else {
					rs[sequence] = sum - sumByColor[color] - sameSizes * size;
					sameColors = 0;
				}
			} else {	
				rs[sequence] = sum - sumByColor[color];
				sameSizes = 0;
				sameColors = 0;
			}
			
			beforeSize = size;
			beforeColor = color;
		}
		
		for (int i = 0; i < N; i++)
			bw.write(rs[i] + "\n");
		
		br.close();
		bw.close();
	}
}
