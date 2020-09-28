package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q6764 {
	private static final int DEPTH_SIZE = 4;
	private static final String STATUS_INCREASE = "Fish Rising";
	private static final String STATUS_DECREASE = "Fish Diving";
	private static final String STATUS_IDENTICAL = "Fish At Constant Depth";
	private static final String STATUS_NOFISH = "No Fish";
	
	private static boolean isIncrease(int depth[]){
		int value = depth[0];
		
		for (int i = 1; i < depth.length; i++) {
			if(value < depth[i])
				value = depth[i];
			else
				return false;
		}
		
		return true;
	}
	
	private static boolean isDecrease(int depth[]){
		int value = depth[0];
		
		for (int i = 1; i < depth.length; i++) {
			if(value > depth[i])
				value = depth[i];
			else
				return false;
		}
		
		return true;
	}
	
	private static boolean isAllSame(int depth[]){
		int value = depth[0];
		
		for (int i = 1; i < depth.length; i++) {
			if(value == depth[i])
				value = depth[i];
			else
				return false;
		}
		
		return true;
	}
	
	private static String getResult(int depth[]){
		if(isIncrease(depth))
			return STATUS_INCREASE;
		if(isDecrease(depth))
			return STATUS_DECREASE;
		if(isAllSame(depth))
			return STATUS_IDENTICAL;
		return STATUS_NOFISH;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int depth[] = new int[DEPTH_SIZE];
		for (int i = 0; i < DEPTH_SIZE; i++) {
			depth[i] = Integer.parseInt(br.readLine());
		}
		
		bw.write(getResult(depth) + "\n");
		
		br.close();
		bw.close();
	}
}
