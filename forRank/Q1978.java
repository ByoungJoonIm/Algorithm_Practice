package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1978 {
	private static final int LAST = 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean isPrime[] = new boolean[LAST + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int counter = 0;
		
		Arrays.fill(isPrime, true);
		isPrime[1] = false;

		//get all prime numbers
		for (int i = 2; i * i < LAST; i++) {
			if(isPrime[i]){
				for (int j = i * 2; j <= LAST; j += i)
					isPrime[j] = false;	
			}
		}
		
		//count given numbers which are prime numbers
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(isPrime[number])
				counter++;
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
