package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CuttingLanWire {
	private static int wires[];
	private static int K;
	private static int N;
	
	
	private static int getCutNumber(long unit){
		int sum = 0;
		
		for (int i = 0; i < K; i++)
			sum += (wires[i] / unit);
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		wires = new int[K];
		
		for (int i = 0; i < K; i++)
			wires[i] = Integer.parseInt(br.readLine());
		
		long left = 1;
		long right = Integer.MAX_VALUE;
		
		while(left <= right){
			long mid = (left + right) / 2;
			int curNumber = getCutNumber(mid);
			
			if(curNumber < N)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		bw.write((left - 1) + "\n");//모든 경우 L의 -1이 최종 값이 됨.
		
		br.close();
		bw.close();
	}
}
