package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, String> intToString = new HashMap<Integer, String>();
		HashMap<String, Integer> stringToInt = new HashMap<String, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			intToString.put(i, name);
			stringToInt.put(name, i);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String value = br.readLine();
			
			try{
				int number = Integer.parseInt(value);
				sb.append(intToString.get(number));
			} catch(NumberFormatException nfe){
				sb.append(stringToInt.get(value));
			}
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
