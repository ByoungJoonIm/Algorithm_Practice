package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q2822 {
	private static final int theNumberOfProblems = 8;
	private static final int theNumberOfRank = 5;
	
	private static class Score{
		int score;
		int order;
		private static int theNumberOfObject = 0;
		
		public Score(int score){
			theNumberOfObject++;
			order = theNumberOfObject;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Score scores[] = new Score[theNumberOfProblems];
		int sum = 0;
		ArrayList<Integer> order = new ArrayList<Integer>();
		
		for (int i = 0; i < theNumberOfProblems; i++) {
			scores[i] = new Score(Integer.parseInt(br.readLine()));
		}
		
		Arrays.sort(scores, new Comparator<Score>(){
			@Override
			public int compare(Score score1, Score score2){
				return score2.score - score1.score;
			}
		});
		
		for (int i = 0; i < theNumberOfRank; i++) {
			sum += scores[i].score;
			order.add(scores[i].order);
		}
		
		Collections.sort(order);
		
		bw.write(sum + "\n");
		bw.write(order.toString().replace("[", "").replace("]", "").replaceAll(",", ""));
		
		br.close();
		bw.close();
	}
}
