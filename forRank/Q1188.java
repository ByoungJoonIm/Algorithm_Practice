package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1188 {
	private static int gcd(int a, int b){
		if(a < b)
			return gcd(b, a);
		
		if( b == 0 )
			return a;
		
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//소시지 수
		int M = Integer.parseInt(st.nextToken());	//평론가 수
		
		bw.write(M - gcd(M, N) + "\n");
		
		br.close();
		bw.close();
	}
}
