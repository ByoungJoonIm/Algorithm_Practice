package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q5928 {
	private static final int BASE_D = 11;
	private static final int BASE_H = 11;
	private static final int BASE_M = 11;
	
	private static int getAbsTime(int D, int H, int M){
		int d = D - BASE_D;
		int h = H - BASE_H;
		int m = M - BASE_M;
		
		int absTime = (d * 24 + h) * 60 + m;
		
		if(absTime >= 0)
			return absTime;
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		bw.write(getAbsTime(D, H, M) + "\n");
		
		br.close();
		bw.close();
	}
}
