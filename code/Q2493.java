package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {
	private static class Pair{
		int height;
		int index;
		
		public Pair(int height, int index){
			this.height = height;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Pair> stack = new Stack<Pair>();
		
		for (int i = 1; i <= N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			boolean isFound = false;
			
			while(!stack.isEmpty()){
				Pair curPair = stack.pop();
				if(curPair.height >= cur){
					stack.push(curPair);
					bw.write(curPair.index + " ");
					isFound = true;
					break;
				}
			}
			stack.push(new Pair(cur, i));
			if(!isFound)
				bw.write("0 ");
		}
		
		bw.write("\n");
		br.close();
		bw.close();
	}
}
