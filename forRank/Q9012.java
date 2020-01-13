package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q9012 {
	private static boolean isValid(String str){
		int strLen = str.length();
		
		if(strLen % 2 == 1)
			return false;
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < strLen; i++) {
			char ch = str.charAt(i);
			
			if(ch == '('){
				stack.push(ch);
			} else if(ch == ')'){
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			bw.write((isValid(str) ? "YES" : "NO") + "\n");
		}
		
		br.close();
		bw.close();
	}
}
