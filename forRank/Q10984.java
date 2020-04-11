package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10984 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int totalScore = 0;
			double totalGrade = 0;
			
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				double grade = Double.parseDouble(st.nextToken());
				
				totalScore += score;
				totalGrade += grade * score;
			}
			
			bw.write(String.format("%d %.1f\n", totalScore, totalGrade / totalScore));
		}
		
		br.close();
		bw.close();
	}
}
