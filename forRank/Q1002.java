/*
 * 두 원 사이의 위치 관계에 관한 글 : https://mathjk.tistory.com/178
 */

package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int RPlus = (int)Math.pow(r1 + r2, 2);
			int RMinus = (int)Math.pow(r1 - r2, 2);
			int D = (int)Math.pow((x1 - x2), 2) + (int)Math.pow((y1 - y2), 2);
			
			
			if(D == 0 && r1 == r2)	//두 원이 일치하는 경우
				bw.write("-1\n");
			else if(RPlus < D || RMinus > D)	//만나지 않는 경우
				bw.write("0\n");
			else if(RPlus == D || RMinus == D)	//접한느 경우
				bw.write("1\n");
			else if(RMinus < D && D < RPlus)	//두 점에서 만나는 경우
				bw.write("2\n");
		}
		br.close();
		bw.close();
	}
}
