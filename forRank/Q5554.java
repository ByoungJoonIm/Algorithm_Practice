package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5554 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		
		bw.write((sum / 60) + "\n");
		bw.write((sum % 60) + "\n");
		
		br.close();
		bw.close();
	}
}
