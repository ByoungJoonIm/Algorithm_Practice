package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1748 {
	private static int getLength(int n){
		int tempN = n;
		int nLength = 0;
		int lengthSum = 0;
		int weight = 9;
		
		if(n < 10)
			return n;
		
		while(tempN > 0){
			nLength++;
			tempN /= 10;
		}
		
		for (int i = 1; i < nLength; i++) {
			lengthSum += (weight * i);
			weight *= 10;
		}
		lengthSum += (((n - Math.pow(10, nLength - 1)) + 1) * nLength);
		
		return lengthSum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		bw.write(getLength(N) + "\n");
		
		br.close();
		bw.close();
	}
}
