package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1065 {
	private static boolean isSequence(int number){
		if(number < 10)
			return true;
		int dist = (number % 100) / 10 - number % 10;
		
		while(number >= 10){
			int front = (number % 100) / 10;
			int end = number % 10;
			
			if(front - end != dist)
				return false;
			
			number /= 10;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int counter = 0;
		
		for (int i = 1; i <= n; i++) {
			if(isSequence(i))
				counter++;
		}
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
