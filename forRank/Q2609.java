package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2609 {
	private static int gcd(int num1, int num2){
		if(num2 > num1)
			return gcd(num2, num1);
		
		int rest = num1 % num2;
		
		while(rest > 0){
			num1 = num2;
			num2 = rest;
			rest = num1 % num2;
		}
		return num2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int divisor = gcd(num1, num2);
		
		bw.write(String.format("%d\n%d\n", divisor, (num1 / divisor) * (num2 / divisor) * divisor));
		
		br.close();
		bw.close();
	}
}
