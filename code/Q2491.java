package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2491 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int LIS = 1;
		int LDS = 1;
		int numbers[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 1;
		
		numbers[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			
			if(numbers[i - 1] >= numbers[i])
				LIS++;
			if(numbers[i - 1] <= numbers[i])
				LDS++;
			
			max = Math.max(max, LIS);
			max = Math.max(max, LDS);

			if(numbers[i - 1] < numbers[i])
				LIS = 1;
			if(numbers[i - 1] > numbers[i])
				LDS = 1;
		}
		
		bw.write(max + "\n");
		
		br.close();
		bw.close();
	}
}