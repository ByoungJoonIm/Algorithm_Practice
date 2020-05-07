package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1713 {
	private static class Candidate implements Comparable<Candidate>{
		int number;
		int sequence;
		int score;
		
		public Candidate(int number, int sequence){
			this.number = number;
			this.sequence = sequence;
			this.score = 1;
		}
		
		@Override
		public int compareTo(Candidate candidate){
			if(this.score == candidate.score)
				return this.sequence - candidate.sequence;
			return this.score - candidate.score;
		}
		
		@Override
		public boolean equals(Object obj){
			return this.number == ((Candidate)obj).number;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
			int number = Integer.parseInt(st.nextToken());
			Candidate candidate = new Candidate(number, i);
			int index = candidates.indexOf(candidate);
			
			if(index >= 0){
				candidates.get(index).score++;
			} else {
				if(candidates.size() == N){
					int minIndex = 0;
					
					for (int j = 1; j < candidates.size(); j++) {
						Candidate min = candidates.get(minIndex);
						Candidate cur = candidates.get(j);
						
						if(cur.score < min.score ){
							minIndex = j;
						} else if (min.score == cur.score){
							if(cur.sequence < min.sequence)
								minIndex = j;
						}
					}
					candidates.remove(minIndex);
				}
				candidates.add(candidate);
			}
		}
		
		Collections.sort(candidates, new Comparator<Candidate>(){
			@Override
			public int compare(Candidate cand1, Candidate cand2){
				return cand1.number - cand2.number;
			}
		});
		
		for (int i = 0; i < candidates.size(); i++) {
			bw.write(candidates.get(i).number + " ");
		}
		bw.write("\n");
		
		br.close();
		bw.close();
	}
}
