package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q1837 {
	private static int mod(String S, int p){
		int ret = 0;
		
		for(int i = 0; i < S.length(); i++)
			ret = (ret * 10 + (S.charAt(i) - '0')) % p;
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String P = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		int k = 2;
		for (; k < K; k++) {
			if(mod(P, k) == 0)
				break;
		}

		if(k == K)
			bw.write("GOOD\n");
		else
			bw.write("BAD " + k + "\n");
		
		br.close();
		bw.close();
	}
}
