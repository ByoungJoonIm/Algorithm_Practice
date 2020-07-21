package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q11723 {
	public static class S{
		private static final int MAX_SIZE = 20;
		boolean elem[];
		
		public S(){
			elem = new boolean[MAX_SIZE + 1];
		}
		
		public void add(int x){
			elem[x] = true;
		}
		
		public void remove(int x){
			elem[x] = false;
		}
		
		public int check(int x){
			if(elem[x])
				return 1;
			return 0;
		}
		
		public void toggle(int x){
			elem[x] = !elem[x];
		}
		
		public void all(){
			Arrays.fill(elem, true);
		}
		
		public void empty(){
			Arrays.fill(elem, false);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S s = new S();
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x = 0;
			
			if(st.hasMoreElements())
				x = Integer.parseInt(st.nextToken());
			
			switch(cmd){
			case "add":
				s.add(x);
				break;
			case "all":
				s.all();
				break;
			case "check":
				bw.write(s.check(x) + "\n");
				break;
			case "remove":
				s.remove(x);
				break;
			case "toggle":
				s.toggle(x);
				break;
			case "empty":
				s.empty();
				break;
			}
		}
		
		br.close();
		bw.close();
	}
}
