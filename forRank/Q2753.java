package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2753 {
	private static boolean isLeapYear(int year){
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int year = Integer.parseInt(br.readLine());
		
		bw.write((isLeapYear(year) ? 1 : 0) + "\n");
		
		br.close();
		bw.close();
	}
}
