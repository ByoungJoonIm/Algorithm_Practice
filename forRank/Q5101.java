package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q5101 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int diff = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			if(start == 0 && diff == 0 && value == 0)
				break;
			
			//an = a1 + dn ( 0 <= n )
			//an - a1 = dn
			//n = (an - a1) / d 
			
			if(start == value){
				bw.write("1\n");
			} else {
				int seq = 0;
				if(diff != 0 && (value - start) % diff == 0	&& (seq = (value - start) / diff) >= 0 ){
					bw.write((seq + 1) + "\n");
				} else
					bw.write("X\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
