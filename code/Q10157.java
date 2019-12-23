package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		if(K <= C * R){
			int sum = 0;
			int x = 1;
			int y = 0;
			int xw = C - 1;
			int yw = R;
			int sign = 1;
			
			for (int i = 0;; i++) {
				sign = i % 4 < 2 ? 1 : -1;
				
				if(i % 2 == 0){
					if(sum + yw < K){
						y += sign * yw;
						sum += yw--;
					} else {
						y += sign * (K - sum);
						break;
					}
				} else {
					if(sum + xw < K){
						x += sign * xw;
						sum += xw--;
					} else {
						x += sign * (K - sum);
						break;
					}
				}
			}
			bw.write(x + " " + y + "\n");
		} else
			bw.write("0\n");
		
		br.close();
		bw.close();
	}
}
