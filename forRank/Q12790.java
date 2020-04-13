package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q12790 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int HP = Integer.parseInt(st.nextToken());
			int MP = Integer.parseInt(st.nextToken());
			int AP = Integer.parseInt(st.nextToken());
			int DP = Integer.parseInt(st.nextToken());
			int EHP = Integer.parseInt(st.nextToken());
			int EMP = Integer.parseInt(st.nextToken());
			int EAP = Integer.parseInt(st.nextToken());
			int EDP = Integer.parseInt(st.nextToken());
			
			int power = ((HP + EHP < 1) ? 1 : HP + EHP) * 1
					+ ((MP + EMP < 1) ? 1 : MP + EMP) * 5
					+ ((AP + EAP < 0) ? 0 : AP + EAP) * 2
					+ (DP + EDP) * 2;
			bw.write(power + "\n");
			
		}
		
		br.close();
		bw.close();
	}
}
