package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//inputs
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int position[] = new int[N + 1];
		int sum = 0;
		
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			//사각형 위치를 직선으로 변경. 북족 오른쪽 끝이 기준
			if(direction == 1)
				position[i] = w - distance;
			else if(direction == 3)
				position[i] = w + distance;
			else if(direction == 2)
				position[i] = w + h + distance;
			else if(direction == 4)
				position[i] = 2 * w + 2 * h - distance;
		}
		
		for (int i = 0; i < N; i++) {
			int distance = Math.abs(position[i] - position[N]);
			sum += Math.min(distance, 2 * w + 2 * h - distance);
		}
		
		bw.write(sum + "\n");
		
		br.close();
		bw.close();
	}
}
