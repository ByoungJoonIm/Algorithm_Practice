package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11729 {
	private static BufferedWriter bw;
	
	private static void hnoi(int n, int s, int m, int e) throws IOException{
		if(n == 1){
			bw.write(s + " " + e + "\n");
		} else {
			hnoi(n - 1, s, e, m);
			bw.write(s + " " + e + "\n");
			hnoi(n - 1, m, s, e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		bw.write((int)(Math.pow(2, N) - 1) + "\n");
		hnoi(N, 1, 2, 3);
		
		br.close();
		bw.close();
	}
}
