package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int A[] = new int[n + 1];
		int maxValue = 0;
		ArrayList<Integer> dp = new ArrayList<Integer>();
		dp.add(0);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			int dpValue = Collections.binarySearch(dp, A[i]);
			
			if(dpValue < 0){
				dpValue = -dpValue - 1;
				
				if(dpValue > maxValue)
					dp.add(A[i]);
				else if(dp.get(dpValue) > A[i])
					dp.set(dpValue, A[i]);
			}
			maxValue = Math.max(maxValue, dpValue);
		}
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();
	}
}
