package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ContinuousSum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		long parts[];
		long maxValue;
		
		/*
		 * inputs and algoritm
		 */
		/*
		 * f(i) means maximum sum of interval which has index i as right end.
		 * max(0, f(i-1)) + arr[i]		i > 0
		 * arr[i]						i == 0
		 * 	 
		 * */
		N = Integer.parseInt(br.readLine());
		parts = new long[N];
		String[] numbers = br.readLine().split(" ");
		
		parts[0] = Integer.parseInt(numbers[0]);
		maxValue = parts[0];
		
		for (int i = 1; i < N; i++){
			parts[i] = Math.max(0, parts[i - 1]) + Integer.parseInt(numbers[i]);
			if(parts[i] > maxValue)
				maxValue = parts[i];
		}
		System.out.println(maxValue);
	}
}
