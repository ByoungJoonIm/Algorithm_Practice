package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2037 {
	private static final char panel[] = {' ', ' ', 'A', 'D', 'G', 'J', 'M', 'P', 'T', 'W'};	//32 65~
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());	//한번 누르는데 걸리는 시간
		int w = Integer.parseInt(st.nextToken());	//같은 문자 군을 여러번 찍기위해 기다리는 시간
		String string = br.readLine();
		
		int prevIndex = 0;
		int totalTime = 0;
		
		for (int i = 0; i < string.length(); i++) {
			char cur = string.charAt(i);
			
			for (int j = panel.length - 1; j > 0; j--) {
				if( cur >= panel[j] ){
					if(prevIndex == j && prevIndex != 1)
						totalTime += w;
					prevIndex = j;
					
					int dist = cur - panel[j] + 1;
					
					totalTime += dist * p;
					break;
				}
			}
		}
		
		bw.write(totalTime + "\n");
		
		br.close();
		bw.close();
	}
}
