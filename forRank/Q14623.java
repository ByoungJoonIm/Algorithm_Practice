package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Q14623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String B1 = br.readLine();
		String B2 = br.readLine();
		
		BigInteger b1 = new BigInteger(B1, 2);
		BigInteger b2 = new BigInteger(B2, 2);
		
		BigInteger mult = b1.multiply(b2);
		
		bw.write(mult.toString(2) + "\n");
		
		br.close();
		bw.close();
	}
}
