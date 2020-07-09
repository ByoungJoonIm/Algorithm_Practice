package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		int K = Integer.parseInt(br.readLine());
		long sum = 0;
		
		for (int i = 0; i < K; i++) {
			int number = Integer.parseInt(br.readLine());
			
			sum += number;
			
			if(number == 0)
				sum -= stack.pop();
			else
				stack.push(number);
		}
		
		bw.write(sum + "\n");
		
		br.close();
		bw.close();
	}
}
