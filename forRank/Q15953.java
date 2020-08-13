package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15953 {
	private static final int UNIT = 10000;
	
	private static int firstContest[][];	//누적 등수, 상금
	private static int secondContest[][];
	
	private static void initFirstContest(){
		int prize[] = {500, 300, 200, 50, 30, 10};
		int amountWeight = 0;
		int weight = 1;
		
		firstContest = new int[6][2];
		
		for (int i = 0; i < firstContest.length; i++) {
			amountWeight += weight++;
			firstContest[i][0] = amountWeight;
			firstContest[i][1] = prize[i];
		}
	}
	
	private static void initSecondContest(){
		int startPrize = 512;
		int amountWeight = 0;
		int weight = 1;
		
		secondContest = new int[5][2];
		
		for (int i = 0; i < secondContest.length; i++) {
			amountWeight += weight;
			weight = weight << 1;
			secondContest[i][0] = amountWeight;
			secondContest[i][1] = startPrize;
			startPrize = startPrize >> 1;
		}
	}
	
	private static int getFirstPrize(int rank){
		if(rank == 0)
			return 0;
		for (int i = 0; i < firstContest.length; i++) {
			if(rank <= firstContest[i][0])
				return firstContest[i][1];
		}
		return 0;
	}
	
	private static int getSecondPrize(int rank){
		if(rank == 0)
			return 0;
		for (int i = 0; i < secondContest.length; i++) {
			if(rank <= secondContest[i][0])
				return secondContest[i][1];
		}
		return 0;
	}

	private static int getResult(int rank1, int rank2){
		return (getFirstPrize(rank1) + getSecondPrize(rank2)) * UNIT;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		initFirstContest();
		initSecondContest();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			bw.write(getResult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
