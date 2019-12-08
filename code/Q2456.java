package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2456 {
	private static class Candidate implements Comparable<Candidate>{
		int number;
		int score[];
		int total;
		
		public Candidate(int number){
			this.number = number;
			score = new int[4];
			total = 0;
		}
		
		@Override
		public int compareTo(Candidate candidate){
			if(total == candidate.total){
				if(score[3] == candidate.score[3])
					return score[2] - candidate.score[2];
				return score[3] - candidate.score[3];
			}
			return total - candidate.total;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Candidate candidates[] = new Candidate[3];
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 3; i++)
			candidates[i] = new Candidate(i + 1);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int score = Integer.parseInt(st.nextToken());
				candidates[j].score[score]++;
				candidates[j].total += score;
			}
		}
		
		Arrays.sort(candidates);
		
		if(candidates[2].compareTo(candidates[1]) == 0)
			bw.write("0 " + candidates[2].total + "\n");
		else
			bw.write(candidates[2].number + " " + candidates[2].total + "\n");
		
		br.close();
		bw.close();
	}
}
