package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Q5893 {
	private static String decToBin(BigInteger dec){
		StringBuilder sb = new StringBuilder();
	
		if(dec.equals(new BigInteger("0")))
			return "0";
		
		while(dec.compareTo(new BigInteger("0")) > 0){
			if(dec.remainder(new BigInteger("2")).intValue() == 0)
				sb.append('0');
			else
				sb.append('1');
			dec = dec.divide(new BigInteger("2"));
		}
		
		return sb.reverse().toString();
	}
	
	private static BigInteger binToDec(String bin){
		BigInteger dec = new BigInteger("0");
		BigInteger weight = new BigInteger("1");
		
		int index = bin.length() - 1;
		
		while(index >= 0){
			if(bin.charAt(index--) == '1')
				dec = dec.add(weight);
				
			weight = weight.multiply(new BigInteger("2"));
		}
		
		return dec;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String bin = br.readLine();
		BigInteger value = binToDec(bin);
		value = value.multiply(new BigInteger("17"));
		
		bw.write(decToBin(value) + "\n");
		
		br.close();
		bw.close();
	}
}
