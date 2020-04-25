package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q5575 {
	private static final int PEOPLE_NUM = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < PEOPLE_NUM; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int startTimeDelta = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
			int endTimeDelta = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
			int workingTimeDelta = endTimeDelta - startTimeDelta;
			
			bw.write(String.format("%d %d %d\n", workingTimeDelta / 3600, workingTimeDelta % 3600 / 60, workingTimeDelta % 60));
		}
		
		br.close();
		bw.close();
	}
}
