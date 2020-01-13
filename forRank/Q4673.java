package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q4673 {
	private static final int FINISH_LINE = 10000;
	private static int creator(int number){
		int next = number;
		
		while(number > 0){
			next += number % 10;
			number /= 10;
		}
		
		return next;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isSelfNumber[] = new boolean[FINISH_LINE + 1];
		
		Arrays.fill(isSelfNumber, true);
		
		for (int i = 1; i <= FINISH_LINE; i++){
			int next = creator(i);
			if(next <= FINISH_LINE)
				isSelfNumber[next] = false;
		}
			
		for (int i = 1; i <= FINISH_LINE; i++) {
			if(isSelfNumber[i])
				bw.write(i + "\n");
		}
		
		br.close();
		bw.close();
	}
}
