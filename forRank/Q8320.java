package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q8320 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j * i <= N; j++) {
				result++;
			}
		}
		
		bw.write(result + "\n");
		
		br.close();
		bw.close();
	}
}
