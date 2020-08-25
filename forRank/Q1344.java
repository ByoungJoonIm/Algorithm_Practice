package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1344 {
	private static final int PROB_MAX = 100;
	private static final int prime[] = {2,3,5,7,11,13,17};
	private static final int UNIT = 18;
	private static long fact[];
	private static long nCr[];
	
	private static void init(){
		fact = new long[UNIT + 1];
		nCr = new long[UNIT + 1];
		
		if(fact.length < 2)
			return;
		fact[1] = 1;
		for (int i = 2; i <= UNIT; i++)
			fact[i] = fact[i - 1] * i;
		
		for (int i = 1; i < UNIT; i++)
			nCr[i] = fact[UNIT] / (fact[i] * (fact[UNIT - i]));
	}
	
	private static double getOneTeamProb(int prob){
		double result = 0;
		
		for (int i = 0; i < prime.length; i++) {
			int r = prime[i];
			
			//P^k = 18Ck * p^k * (1-p)^(18-k)
			result += nCr[r] * Math.pow((double)prob / PROB_MAX, r) * Math.pow((double)(PROB_MAX - prob) / PROB_MAX, UNIT - r);
		}
		
		return result;
	}
	
	private static double getResult(int prob1, int prob2){
		double result1 = getOneTeamProb(prob1);
		double result2 = getOneTeamProb(prob2);
		return  result1 + result2 - result1 * result2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		init();

		int prob1 = Integer.parseInt(br.readLine());
		int prob2 = Integer.parseInt(br.readLine());
		
		bw.write(getResult(prob1, prob2) + "\n");
		
		br.close();
		bw.close();
	}
}
