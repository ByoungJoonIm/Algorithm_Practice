package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1476 {
	private static final int E_MAX = 15;
	private static final int S_MAX = 28;
	private static final int M_MAX = 19;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int i = 0;
		
		for (i = 1; i <= E_MAX * S_MAX * M_MAX; i++) {	//이 문제에서는 이게 최소공배수임. 원래 최소공배수까지 돌려야함
			int e = (i - 1) % E_MAX + 1;
			int s = (i - 1) % S_MAX + 1;
			int m = (i - 1) % M_MAX + 1;
			
			if(E == e && S == s && M == m)
				break;
		}
		
		bw.write(i + "\n");
		
		br.close();
		bw.close();
	}
}
