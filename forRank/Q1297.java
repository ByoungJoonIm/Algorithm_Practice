package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1297 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int diag = Integer.parseInt(st.nextToken());
		int yRate = Integer.parseInt(st.nextToken());
		int xRate = Integer.parseInt(st.nextToken());

		// 1:x의 비율로 전환
		double eyRate = 1;
		double exRate =  xRate / (double)yRate;
		
		//(y * eyRate)^2 + (y * exRate)^2 = diag^2
		//y^2 * eyRate^2 + y^2 * exRate^2 = diag^2
		//y^2(eyRate^2 + exRate^2) = diag^2
		//y^2 = diag^2 / (eyRate^2 + exRate^2)
		//y = sqrt(diag^2 / (eyRate^2 + exRate^2))
		
		double y = Math.sqrt(Math.pow(diag, 2) / (Math.pow(eyRate, 2) + Math.pow(exRate, 2)));
		double x = y * exRate;
		
		System.out.println((int)y + " " + (int)x + "\n");
		
		br.close();
		bw.close();
	}
}
