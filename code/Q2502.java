package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());	//넘어온 날 수
		int K = Integer.parseInt(st.nextToken());	//떡의 갯수
		int a = 1;	//A의 계수
		int b = 1;	//B의 계수

		for (int i = 4; i <= D; i++) {
			int temp = b;
			b = a + b;
			a = temp;
		}
		
		for (int B = 1; b * B <= K; B++) {
			for (int A = 1; A <= B; A++) {
				if(a * A + b * B == K){
					bw.write(A + "\n" + B + "\n");
					bw.close();
					br.close();
					return;
				}
			}
		}
	}
}
