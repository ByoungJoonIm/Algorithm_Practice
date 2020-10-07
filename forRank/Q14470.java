package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q14470 {
	private static int getResult(int originTemper, int targetTemper, int icedHeatTime, int meltingTime, int heatTime){
		int totalTime = 0;
		
		if(originTemper < 0){
			totalTime += (-originTemper * icedHeatTime + meltingTime);
			totalTime += (targetTemper * heatTime);
		} else
			totalTime += (targetTemper - originTemper) * heatTime;
		
		return totalTime;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int originTemper = Integer.parseInt(br.readLine());
		int targetTemper = Integer.parseInt(br.readLine());
		int icedHeatTime = Integer.parseInt(br.readLine());
		int meltingTime = Integer.parseInt(br.readLine());
		int heatTime = Integer.parseInt(br.readLine());
		
		bw.write(getResult(originTemper, targetTemper, icedHeatTime, meltingTime, heatTime) + "\n");
		
		br.close();
		bw.close();
	}
}
