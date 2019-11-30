package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2576 {
	private static final int NUMOFNUMBERS = 7;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		for (int i = 0; i < NUMOFNUMBERS; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number % 2 == 1){
				sum += number;
				min = Math.min(min, number);
			}
		}
		
		if(sum == 0)
			bw.write(-1 + "\n");
		else
			bw.write(sum + "\n" + min + "\n");
		
		br.close();
		bw.close();
	}
}
