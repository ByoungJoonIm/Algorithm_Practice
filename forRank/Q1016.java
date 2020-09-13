package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1016 {
	private static final long MAX_VALUE = 1000001000000L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		int width = (int)(max - min + 1);
		boolean isWrong[] = new boolean[width];
		int counter = width;
		
		for (long i = 2; i * i <= MAX_VALUE; i++) {
			long div = (min - 1) / (i * i) + 1;
			for (long j = i * i * div; j <= max; j += i * i) {
				int index = (int)(j - min);
				if(!isWrong[index]){
					counter--;
					isWrong[index] = true;
				}	
			}
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
