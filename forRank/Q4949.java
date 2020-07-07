package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q4949 {
	private static String getLineResult(String line){
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);
			
			if(cur == '(' || cur == '[')
				stack.push(cur);
			else if(cur == ')'){
				if(stack.isEmpty() || stack.pop() != '(')
					return "no";
			} else if(cur == ']'){
				if(stack.isEmpty() || stack.pop() != '[')
					return "no";
			}
		}
		
		if(stack.isEmpty())
			return "yes";
		return "no";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		while(true){
			String line = br.readLine();
			
			if(line.length() == 1 && line.charAt(0) == '.')
				break;
			
			sb.append(getLineResult(line)).append('\n');
		}

		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
