package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10709 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < H; i++) {
			String line = br.readLine();
			int value = -1;
			for (int j = 0; j < W; j++) {
				char weather = line.charAt(j);
				
				if(weather == 'c')
					value = 0;
				else if( value >= 0 )
					value++;
				
				bw.write(value + " ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
