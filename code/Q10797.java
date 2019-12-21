package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10797 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int prohibited = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			int carNum = Integer.parseInt(st.nextToken());
			if(carNum % 10 == prohibited)
				count++;
		}
		
		bw.write(count + "\n");
		
		br.close();
		bw.close();
	}
}
