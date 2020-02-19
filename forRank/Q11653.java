package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int number = 3;
		
		while(N % 2 == 0){
			bw.write(2 + "\n");
			N /= 2;
		}
		
		while(N > 1){
			if(N % number == 0){
				bw.write(number + "\n");
				N /= number;
			} else {
				number += 2;
			}
		}
		
		br.close();
		bw.close();
	}
}
