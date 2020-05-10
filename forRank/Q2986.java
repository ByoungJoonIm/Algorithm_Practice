package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int counter = 0;
		
		if(N % 2 == 0){
			counter = N / 2;
		} else {
			for (int i = 3; i * i <= N; i+=2) {
				if(N % i == 0){
					counter = N - N / i;
					break;
				}
			}	
		}
		
		if(counter == 0)
			counter = N - 1;
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
