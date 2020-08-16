package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1033 {
	private static long gcd(long a, long b){
		if(a < b)
			return gcd(b, a);
		
		long rest = a % b;
		
		while(rest != 0){
			a = b;
			b = rest;
			rest = a % b;
		}
		
		return b;
	}
	
	private static class Ratio{
		private static final int SIZE = 2;
		int elems[];
		long rates[];
		
		public Ratio(String str){
			StringTokenizer st = new StringTokenizer(str);
			elems = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			rates = new long[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			long gcdValue = gcd(rates[0], rates[1]);
			rates[0] /= gcdValue;
			rates[1] /= gcdValue;
		}
		
		public static boolean adjustRatio(Ratio ratio1, Ratio ratio2){
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if(ratio1.elems[i] == ratio2.elems[j] && ratio1.rates[i] != ratio2.rates[j]){
						long minCommon = ratio1.rates[i] * ratio2.rates[j] / gcd(ratio1.rates[i], ratio2.rates[j]);
						long nextMult1 = minCommon / ratio1.rates[i];
						long nextMult2 = minCommon / ratio2.rates[j];
						
						for (int k = 0; k < SIZE; k++) {
							ratio1.rates[k] *= nextMult1;
							ratio2.rates[k] *= nextMult2;
						}
						
						return true;
					}
				}
			}
			
			return false;
		}
		
		public static String getResult(Ratio ratios[]){
			long result[] = new long[ratios.length + 1];
			
			for (int i = 0; i < ratios.length; i++) {
				for (int j = 0; j < SIZE; j++) {
					result[ratios[i].elems[j]] = ratios[i].rates[j];
				}
			}
			
			long gcdValue = gcd(result[0], result[1]);
			for (int i = 2; i < result.length; i++)
				gcdValue = gcd(gcdValue, result[i]);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length - 1; i++) {
				sb.append(result[i] / gcdValue).append(' ');
			}
			sb.append(result[result.length - 1] / gcdValue).append('\n');
			
			return sb.toString();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N > 1){
			Ratio ratios[] = new Ratio[N - 1];
			
			for (int i = 0; i < N - 1; i++)
				ratios[i] = new Ratio(br.readLine());
			
			boolean updated = true;
			
			while(updated){
				updated = false;
				for (int i = 1; i < N - 1; i++) {
					for (int j = 0; j < i; j++) {
						updated = updated || Ratio.adjustRatio(ratios[i], ratios[j]);
					}
				}
			}
			
			bw.write(Ratio.getResult(ratios));
		} else {
			bw.write("1\n");
		}
		
		br.close();
		bw.close();
	}
}
