package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2747 {
	private static int fibo(int n){
		int front = 1;
		int cur = 1;
		
		for (int i = 2; i < n; i++) {
			int temp = cur;
			cur+= front;
			front = temp;
		}
		
		return cur;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		bw.write(fibo(n) + "\n");
		
		br.close();
		bw.close();
	}
}
