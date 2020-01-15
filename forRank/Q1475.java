package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int counter[] = new int[10];
		int max = 0;
		
		String input = br.readLine();
		
		for (int i = 0; i < input.length(); i++)
			counter[input.charAt(i) - '0']++;
		
		counter[6] = (counter[6] + counter[9] + 1) / 2;
		
		for (int i = 0; i <= 8; i++)
			max = Math.max(max, counter[i]);
		
		bw.write(max + "\n");
		
		br.close();
		bw.close();
	}
}
