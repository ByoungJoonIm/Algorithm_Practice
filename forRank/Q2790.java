package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2790 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int previousScore[] = new int[N];
		int maxScore;
		int score = N;
		int counter = 0;
		
		for (int i = 0; i < N; i++)
			previousScore[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(previousScore);
		maxScore = previousScore[N - 1] + 1;
		
		for (int i = 0; i < N; i++) {
			if(previousScore[i] + score >= maxScore){
				counter = i;
				break;
			} 
		}
		
		bw.write(N - counter + "\n");
		
		br.close();
		bw.close();
	}
}
