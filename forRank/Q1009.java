/*
 * 이해는 가지 않지만, 다음 식이 성립함
 * a^b % 10 == (a^((b-1)/4) % 4 + 1) % 10
 * 즉, 제곱수는 4번 단위로 끝자리가 같아짐
 * */

package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int rs = 1;
			
			for (int j = 0; j < b; j++)
				rs = (rs % 10) * (a % 10) % 10;
		
			if(rs == 0)
				rs = 10;
			
			bw.write(rs + "\n");
		}
		
		br.close();
		bw.close();
	}
}
