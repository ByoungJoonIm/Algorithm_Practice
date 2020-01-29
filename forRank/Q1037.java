package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1037 {
	private static long getNumber(int subs[], int N, int maxValue, int minValue){
		long i = 0;
		boolean isAllCorrect = false;
		
		for (i = maxValue * minValue; !isAllCorrect ; i += maxValue) {
			isAllCorrect = true;
			
			for (int j = 0; j < N; j++) {
				if(i % subs[j] != 0){
					isAllCorrect = false;
					break;
				}
			}
		}
		
		return i - maxValue;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int subs[] = new int[N];
		int maxValue = 0;
		int minValue = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++){
			subs[i] = Integer.parseInt(st.nextToken());
			maxValue = Math.max(subs[i], maxValue);
			minValue = Math.min(subs[i], minValue);
		}
		
		bw.write(getNumber(subs, N, maxValue, minValue) + "\n");
		
		br.close();
		bw.close();
	}
}