package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1756 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int ovenIndex = D - 1;
		int pizzaIndex = 0;
		
		if(D >= N){
			int oven[] = new int[D];
			int pizza[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			oven[0] = Integer.parseInt(st.nextToken());
			for (int i = 1; i < D; i++)
				oven[i] = Math.min(Integer.parseInt(st.nextToken()), oven[i - 1]);
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				pizza[i] = Integer.parseInt(st.nextToken());
			
			
			while(ovenIndex >= 0 && pizzaIndex < N){
				if(oven[ovenIndex] >= pizza[pizzaIndex]){
					pizzaIndex++;
				}
				ovenIndex--;
			}
		}
		
		if(pizzaIndex != N)
			bw.write("0\n");
		else
			bw.write(ovenIndex + 2 + "\n");
		
		br.close();
		bw.close();
	}
}
