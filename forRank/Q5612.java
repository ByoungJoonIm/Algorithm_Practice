package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q5612 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int maxCar = m;
		boolean isValid = m >= 0;

		for (int i = 0; i < n && isValid; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int enterCar = Integer.parseInt(st.nextToken());
			int exitCar = Integer.parseInt(st.nextToken());
			
			m = m + enterCar - exitCar;
			maxCar = Math.max(maxCar, m);
			isValid = m >= 0;
		}
		
		if(isValid)
			bw.write(maxCar + "\n");
		else
			bw.write("0\n");
		
		br.close();
		bw.close();
	}
}
