package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		boolean isNotPossible = false;
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if(!isNotPossible){
				int cur = Integer.parseInt(br.readLine());
				
				while(stack.isEmpty() || stack.peek() != cur){
					stack.push(++cnt);
					sb.append("+\n");
					if(cnt > n){
						isNotPossible = true;
						break;
					}
				}
				stack.pop();
				sb.append("-\n");
			}
		}

		if(isNotPossible){
			bw.write("NO\n");
		} else
			bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
