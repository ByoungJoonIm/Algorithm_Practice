package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q9020 {
	private static final int LAST = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//get primes
		boolean prime[] = new boolean[LAST + 1];
		
		Arrays.fill(prime,  true);
		prime[1] = false;
		
		for (int i = 4; i <= LAST; i+= 2)
			prime[i] = false;
		
		for (int i = 3; i * i <= LAST; i += 2) {
			for (int j = i * 2; j <= LAST; j += i) {
				prime[j] = false;
			}
		}
		
		//algorithm
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			
			for (int j = num / 2; j > 1; j--) {
				if(prime[num - j] && prime[j]){
					bw.write(j + " " + (num - j) + "\n");
					break;
				}
			}
		}
		
		br.close();
		bw.close();
	}
}
