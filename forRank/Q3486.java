package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q3486 {
	private static int reverse(int number){
		int result = 0;
		
		while(number % 10 == 0){
			number /= 10;
		}
		
		while( number > 0 ){
			result *= 10;
			result += number % 10;
			number /= 10;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write(reverse(reverse(a) + reverse(b)) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
