package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1107 {
	private static final int INIT_NUMBER = 100;
	private static final int LAST_CHANNEL = 1000000;
	
	private static boolean disabled[];
	
	private static boolean isPossible(int number){
		while(number >= 0){
			int r = number % 10;
			if(disabled[r])
				return false;
			number /= 10;
			
			if(number == 0)
				return true;
		}
		return true;
	}
	
	private static int getLength(int number){
		int length = 1;
		number /= 10;
		
		while(number > 0){
			length++;
			number /= 10;
		}
		
		return length;
	}
	
	private static int getResult(int number){
		if(number == INIT_NUMBER)
			return 0;
		
		int counter = 0;
		int result = Math.abs(number - INIT_NUMBER);
		
		if(isPossible(number)){
			result = Math.min(result, getLength(number));
		}
		
		int plus = number + 1;
		int minus = number - 1;
		
		while(plus <= LAST_CHANNEL){
			counter++;
			if(isPossible(plus)){
				result = Math.min(result, counter + getLength(plus));
			}
			plus++;
		}
		
		counter = 0;
		while(minus >= 0){
			counter++;
			if(isPossible(minus)){
				result = Math.min(result, counter + getLength(minus));
			}
			minus--;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int number = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		disabled = new boolean[10];
		
		if(M > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				disabled[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		bw.write(getResult(number) + "\n");
		
		br.close();
		bw.close();
	}
}