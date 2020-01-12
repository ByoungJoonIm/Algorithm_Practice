package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int cycle = 0;
		int newNumber = N;
		
		do{
			int front = newNumber / 10;
			int back = newNumber % 10;
			newNumber = back * 10 + (front + back) % 10;
			cycle++;
		} while( N != newNumber);
		
		bw.write(cycle + "\n");
		
		br.close();
		bw.close();
	}
}
