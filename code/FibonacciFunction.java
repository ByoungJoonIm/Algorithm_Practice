package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciFunction {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int inputNumbers[];
		int fibo[][];
		int maxValue = 0;
		
		
		N = Integer.parseInt(br.readLine());
		inputNumbers = new int[N];
		
		for (int i = 0; i < N; i++) {
			inputNumbers[i] = Integer.parseInt(br.readLine());
			if(inputNumbers[i] > maxValue)
				maxValue = inputNumbers[i];
		}
		
		fibo = new int[maxValue + 1][2];
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		for (int i = 2; i < maxValue + 1; i++) {
			fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
			fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
		}
		
		for (int i = 0; i < N; i++)
			bw.write(fibo[inputNumbers[i]][0] + " " + fibo[inputNumbers[i]][1] + "\n");

		br.close();
		bw.close();
	}
}
