package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11772 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			int pow = number % 10;
			number /= 10;
			
			sum += (int)Math.pow(number, pow);
		}
		
		bw.write(sum + "\n");
		
		br.close();
		bw.close();
	}
}
