package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2476 {
	private static int prize(String str){
		StringTokenizer st = new StringTokenizer(str);
		int hist[] = new int[7];
		int high = 0;
		
		for (int i = 0; i < 3; i++)
			hist[Integer.parseInt(st.nextToken())]++;

		for (int i = 6; i > 0; i--) {
			if(hist[i] == 3)
				return 10000 + i * 1000;
			if(hist[i] == 2)
				return 1000 + i * 100;
			
			if(hist[i] >= 0){
				if(high == 0)
					high = i;
			}
		}
		
		return high * 100;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		
		for (int i = 0; i < N; i++)
			max = Math.max(max, prize(br.readLine()));
		
		bw.write(max + "\n");
		
		br.close();
		bw.close();
	}
}
