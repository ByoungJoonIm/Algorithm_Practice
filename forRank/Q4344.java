package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q4344 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int numbers[] = new int[n];
			int sum = 0;
			int counter = 0;
			double avg;
			
			for (int j = 0; j < n; j++){
				numbers[j] = Integer.parseInt(st.nextToken());
				sum += numbers[j];
			}
			
			avg = (double)sum / n;
			for (int j = 0; j < n; j++) {
				if(numbers[j] > avg)
					counter++;
			}
				
			bw.write(String.format("%.3f", (double)counter / n * 100) + "%\n");
		}
		
		br.close();
		bw.close();
	}
}
