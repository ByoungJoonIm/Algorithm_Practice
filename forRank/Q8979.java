package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8979 {
	private static class Country implements Comparable<Country>{
		int countryNumber;
		int gold;
		int silver;
		int bronze;
		
		public Country(String str){
			StringTokenizer st = new StringTokenizer(str);
			countryNumber = Integer.parseInt(st.nextToken());
			gold = Integer.parseInt(st.nextToken());
			silver = Integer.parseInt(st.nextToken());
			bronze = Integer.parseInt(st.nextToken());
		}
		
		@Override
		public int compareTo(Country country){
			if(this.gold == country.gold){
				if(this.silver == country.silver){
					return country.bronze - this.bronze;
				}
				return country.silver - this.silver;
			}
			return country.gold - this.gold;
		}
		
		@Override
		public boolean equals(Object obj){
			Country country = (Country)obj;
			return this.gold == country.gold && this.silver == country.silver && this.bronze == country.bronze;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int targetCountryNumber = Integer.parseInt(st.nextToken());
		Country countries[] = new Country[N + 1];
		int rank = 1;
		
		countries[0] = new Country("0 1000000 1000000 1000000");	//dummy. always be the start value in array
		for (int i = 1; i <= N; i++) {
			countries[i] = new Country(br.readLine());
		}
		
		Arrays.sort(countries);
		
		for (int i = 1; i <= N; i++) {
			if(!countries[i].equals(countries[i - 1]))
				rank = i;
			
			if(countries[i].countryNumber == targetCountryNumber){
				bw.write(rank + "\n");
				break;
			}
		}
		
		br.close();
		bw.close();
	}
}
