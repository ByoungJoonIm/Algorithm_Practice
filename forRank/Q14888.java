package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14888 {
	private static int max;
	private static int min;
	private static int N;
	private static int numbers[];
	
	private static void solution(int index, int sum, int plus, int minus, int mult, int div){
		if(index == N){
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		
		if(plus > 0)
			solution(index + 1, sum + numbers[index], plus - 1, minus, mult, div);
		if(minus > 0)
			solution(index + 1, sum - numbers[index], plus, minus - 1, mult, div);
		if(mult > 0)
			solution(index + 1, sum * numbers[index], plus, minus, mult - 1, div);
		if(div > 0)
			solution(index + 1, sum / numbers[index], plus, minus, mult, div - 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		max = -Integer.MAX_VALUE + 1;
		min = Integer.MAX_VALUE;
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mult = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		solution(1, numbers[0], plus, minus, mult, div);
		
		bw.write(String.format("%d\n%d\n", max, min));
		
		br.close();
		bw.close();
	}
}
